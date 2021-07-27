package com.google.firebase.database.tubesock;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.support.annotation.Nullable;
import com.google.firebase.database.connection.ConnectionContext;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.logging.Logger;
import java.io.File;
import java.io.IOException;
import java.lang.Thread;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocket;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class WebSocket {
    static final byte OPCODE_BINARY = 2;
    static final byte OPCODE_CLOSE = 8;
    static final byte OPCODE_NONE = 0;
    static final byte OPCODE_PING = 9;
    static final byte OPCODE_PONG = 10;
    static final byte OPCODE_TEXT = 1;
    private static final int SSL_HANDSHAKE_TIMEOUT_MS = 60000;
    private static final String THREAD_BASE_NAME = "TubeSock";
    private static final Charset UTF8 = Charset.forName("UTF-8");
    private static final AtomicInteger clientCount = new AtomicInteger(0);
    private static ThreadInitializer intializer = new ThreadInitializer() {
        public void setName(Thread t, String name) {
            t.setName(name);
        }
    };
    private static ThreadFactory threadFactory = Executors.defaultThreadFactory();
    private final int clientId;
    private WebSocketEventHandler eventHandler;
    private final WebSocketHandshake handshake;
    private final Thread innerThread;
    private final LogWrapper logger;
    private final WebSocketReceiver receiver;
    private volatile Socket socket;
    @Nullable
    private final String sslCacheDirectory;
    private volatile State state;
    private final URI url;
    private final WebSocketWriter writer;

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private enum State {
        NONE,
        CONNECTING,
        CONNECTED,
        DISCONNECTING,
        DISCONNECTED
    }

    static ThreadFactory getThreadFactory() {
        return threadFactory;
    }

    static ThreadInitializer getIntializer() {
        return intializer;
    }

    public static void setThreadFactory(ThreadFactory threadFactory2, ThreadInitializer intializer2) {
        threadFactory = threadFactory2;
        intializer = intializer2;
    }

    public WebSocket(ConnectionContext context, URI url2) {
        this(context, url2, (String) null);
    }

    public WebSocket(ConnectionContext context, URI url2, String protocol) {
        this(context, url2, protocol, (Map<String, String>) null);
    }

    public WebSocket(ConnectionContext context, URI url2, String protocol, Map<String, String> extraHeaders) {
        this.state = State.NONE;
        this.socket = null;
        this.eventHandler = null;
        this.clientId = clientCount.incrementAndGet();
        this.innerThread = getThreadFactory().newThread(new Runnable() {
            public void run() {
                WebSocket.this.runReader();
            }
        });
        this.url = url2;
        this.sslCacheDirectory = context.getSslCacheDirectory();
        Logger logger2 = context.getLogger();
        this.logger = new LogWrapper(logger2, "WebSocket", "sk_" + this.clientId);
        this.handshake = new WebSocketHandshake(url2, protocol, extraHeaders);
        this.receiver = new WebSocketReceiver(this);
        this.writer = new WebSocketWriter(this, THREAD_BASE_NAME, this.clientId);
    }

    public void setEventHandler(WebSocketEventHandler eventHandler2) {
        this.eventHandler = eventHandler2;
    }

    /* access modifiers changed from: package-private */
    public WebSocketEventHandler getEventHandler() {
        return this.eventHandler;
    }

    public synchronized void connect() {
        if (this.state != State.NONE) {
            this.eventHandler.onError(new WebSocketException("connect() already called"));
            close();
            return;
        }
        ThreadInitializer intializer2 = getIntializer();
        Thread innerThread2 = getInnerThread();
        intializer2.setName(innerThread2, "TubeSockReader-" + this.clientId);
        this.state = State.CONNECTING;
        getInnerThread().start();
    }

    public synchronized void send(String data) {
        send(OPCODE_TEXT, data.getBytes(UTF8));
    }

    public synchronized void send(byte[] data) {
        send(OPCODE_BINARY, data);
    }

    /* access modifiers changed from: package-private */
    public synchronized void pong(byte[] data) {
        send(OPCODE_PONG, data);
    }

    private synchronized void send(byte opcode, byte[] data) {
        if (this.state != State.CONNECTED) {
            this.eventHandler.onError(new WebSocketException("error while sending data: not connected"));
        } else {
            try {
                this.writer.send(opcode, true, data);
            } catch (IOException e) {
                this.eventHandler.onError(new WebSocketException("Failed to send frame", e));
                close();
            }
        }
        return;
    }

    /* access modifiers changed from: package-private */
    public void handleReceiverError(WebSocketException e) {
        this.eventHandler.onError(e);
        if (this.state == State.CONNECTED) {
            close();
        }
        closeSocket();
    }

    public synchronized void close() {
        switch (this.state) {
            case NONE:
                this.state = State.DISCONNECTED;
                return;
            case CONNECTING:
                closeSocket();
                return;
            case CONNECTED:
                sendCloseHandshake();
                return;
            case DISCONNECTING:
                return;
            case DISCONNECTED:
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: package-private */
    public void onCloseOpReceived() {
        closeSocket();
    }

    private synchronized void closeSocket() {
        if (this.state != State.DISCONNECTED) {
            this.receiver.stopit();
            this.writer.stopIt();
            if (this.socket != null) {
                try {
                    this.socket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            this.state = State.DISCONNECTED;
            this.eventHandler.onClose();
        }
    }

    private void sendCloseHandshake() {
        try {
            this.state = State.DISCONNECTING;
            this.writer.stopIt();
            this.writer.send(OPCODE_CLOSE, true, new byte[0]);
        } catch (IOException e) {
            this.eventHandler.onError(new WebSocketException("Failed to send close frame", e));
        }
    }

    private Socket createSocket() {
        String scheme = this.url.getScheme();
        String host = this.url.getHost();
        int port = this.url.getPort();
        if (scheme != null && scheme.equals("ws")) {
            if (port == -1) {
                port = 80;
            }
            try {
                return new Socket(host, port);
            } catch (UnknownHostException uhe) {
                throw new WebSocketException("unknown host: " + host, uhe);
            } catch (IOException ioe) {
                throw new WebSocketException("error while creating socket to " + this.url, ioe);
            }
        } else if (scheme == null || !scheme.equals("wss")) {
            throw new WebSocketException("unsupported protocol: " + scheme);
        } else {
            if (port == -1) {
                port = 443;
            }
            SSLSessionCache sessionCache = null;
            try {
                if (this.sslCacheDirectory != null) {
                    sessionCache = new SSLSessionCache(new File(this.sslCacheDirectory));
                }
            } catch (IOException e) {
                this.logger.debug("Failed to initialize SSL session cache", e, new Object[0]);
            }
            try {
                SSLSocket sslSocket = (SSLSocket) SSLCertificateSocketFactory.getDefault(SSL_HANDSHAKE_TIMEOUT_MS, sessionCache).createSocket(host, port);
                if (HttpsURLConnection.getDefaultHostnameVerifier().verify(host, sslSocket.getSession())) {
                    return sslSocket;
                }
                throw new WebSocketException("Error while verifying secure socket to " + this.url);
            } catch (UnknownHostException uhe2) {
                throw new WebSocketException("unknown host: " + host, uhe2);
            } catch (IOException ioe2) {
                throw new WebSocketException("error while creating secure socket to " + this.url, ioe2);
            }
        }
    }

    public void blockClose() throws InterruptedException {
        if (this.writer.getInnerThread().getState() != Thread.State.NEW) {
            this.writer.getInnerThread().join();
        }
        getInnerThread().join();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        r1 = new java.io.DataInputStream(r0.getInputStream());
        r2 = r0.getOutputStream();
        r2.write(r15.handshake.getHandshake());
        r3 = false;
        r5 = new byte[1000];
        r6 = 0;
        r7 = new java.util.ArrayList<>();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0044, code lost:
        if (r3 != false) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0046, code lost:
        r8 = r1.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004b, code lost:
        if (r8 != -1) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        throw new com.google.firebase.database.tubesock.WebSocketException("Connection closed before handshake was complete");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0055, code lost:
        r5[r6] = (byte) r8;
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0060, code lost:
        if (r5[r6 - 1] != 10) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r5[r6 - 2] != 13) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x006a, code lost:
        r9 = new java.lang.String(r5, UTF8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x007b, code lost:
        if (r9.trim().equals("") == false) goto L_0x007f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x007d, code lost:
        r3 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x007f, code lost:
        r7.add(r9.trim());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0086, code lost:
        r5 = new byte[1000];
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x008d, code lost:
        if (r6 != 1000) goto L_0x00ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008f, code lost:
        r9 = new java.lang.String(r5, UTF8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ac, code lost:
        throw new com.google.firebase.database.tubesock.WebSocketException("Unexpected long line in handshake: " + r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ae, code lost:
        r15.handshake.verifyServerStatusLine(r7.get(0));
        r7.remove(0);
        r8 = new java.util.HashMap<>();
        r10 = r7.iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00ca, code lost:
        if (r10.hasNext() == false) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00cc, code lost:
        r12 = r10.next().split(": ", 2);
        r8.put(r12[0], r12[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00e2, code lost:
        r15.handshake.verifyServerHandshakeHeaders(r8);
        r15.writer.setOutput(r2);
        r15.receiver.setInput(r1);
        r15.state = com.google.firebase.database.tubesock.WebSocket.State.CONNECTED;
        r15.writer.getInnerThread().start();
        r15.eventHandler.onOpen();
        r15.receiver.run();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void runReader() {
        /*
            r15 = this;
            java.net.Socket r0 = r15.createSocket()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            monitor-enter(r15)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r15.socket = r0     // Catch:{ all -> 0x0109 }
            com.google.firebase.database.tubesock.WebSocket$State r1 = r15.state     // Catch:{ all -> 0x0109 }
            com.google.firebase.database.tubesock.WebSocket$State r2 = com.google.firebase.database.tubesock.WebSocket.State.DISCONNECTED     // Catch:{ all -> 0x0109 }
            if (r1 != r2) goto L_0x0022
            java.net.Socket r1 = r15.socket     // Catch:{ IOException -> 0x001b }
            r1.close()     // Catch:{ IOException -> 0x001b }
            r1 = 0
            r15.socket = r1     // Catch:{ all -> 0x0109 }
            monitor-exit(r15)     // Catch:{ all -> 0x0109 }
            r15.close()
            return
        L_0x001b:
            r1 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException     // Catch:{ all -> 0x0109 }
            r2.<init>(r1)     // Catch:{ all -> 0x0109 }
            throw r2     // Catch:{ all -> 0x0109 }
        L_0x0022:
            monitor-exit(r15)     // Catch:{ all -> 0x0109 }
            java.io.DataInputStream r1 = new java.io.DataInputStream     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.io.InputStream r2 = r0.getInputStream()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r1.<init>(r2)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            com.google.firebase.database.tubesock.WebSocketHandshake r3 = r15.handshake     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            byte[] r3 = r3.getHandshake()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r2.write(r3)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r3 = 0
            r4 = 1000(0x3e8, float:1.401E-42)
            byte[] r5 = new byte[r4]     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r6 = 0
            java.util.ArrayList r7 = new java.util.ArrayList     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r7.<init>()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
        L_0x0044:
            if (r3 != 0) goto L_0x00ae
            int r8 = r1.read()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r9 = -1
            if (r8 != r9) goto L_0x0055
            com.google.firebase.database.tubesock.WebSocketException r9 = new com.google.firebase.database.tubesock.WebSocketException     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.lang.String r10 = "Connection closed before handshake was complete"
            r9.<init>(r10)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            throw r9     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
        L_0x0055:
            byte r9 = (byte) r8     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r5[r6] = r9     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            int r6 = r6 + 1
            int r9 = r6 + -1
            byte r9 = r5[r9]     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r10 = 10
            if (r9 != r10) goto L_0x008b
            int r9 = r6 + -2
            byte r9 = r5[r9]     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r10 = 13
            if (r9 != r10) goto L_0x008b
            java.lang.String r9 = new java.lang.String     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.nio.charset.Charset r10 = UTF8     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r9.<init>(r5, r10)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.lang.String r10 = r9.trim()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.lang.String r11 = ""
            boolean r10 = r10.equals(r11)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            if (r10 == 0) goto L_0x007f
            r3 = 1
            goto L_0x0086
        L_0x007f:
            java.lang.String r10 = r9.trim()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r7.add(r10)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
        L_0x0086:
            byte[] r10 = new byte[r4]     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r5 = r10
            r6 = 0
            goto L_0x00ad
        L_0x008b:
            r9 = 1000(0x3e8, float:1.401E-42)
            if (r6 != r9) goto L_0x00ad
            java.lang.String r9 = new java.lang.String     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.nio.charset.Charset r10 = UTF8     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r9.<init>(r5, r10)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            com.google.firebase.database.tubesock.WebSocketException r10 = new com.google.firebase.database.tubesock.WebSocketException     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r11.<init>()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.lang.String r12 = "Unexpected long line in handshake: "
            r11.append(r12)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r11.append(r9)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.lang.String r11 = r11.toString()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r10.<init>(r11)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            throw r10     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
        L_0x00ad:
            goto L_0x0044
        L_0x00ae:
            com.google.firebase.database.tubesock.WebSocketHandshake r8 = r15.handshake     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r9 = 0
            java.lang.Object r10 = r7.get(r9)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r8.verifyServerStatusLine(r10)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r7.remove(r9)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.util.HashMap r8 = new java.util.HashMap     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r8.<init>()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.util.Iterator r10 = r7.iterator()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
        L_0x00c6:
            boolean r11 = r10.hasNext()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            if (r11 == 0) goto L_0x00e2
            java.lang.Object r11 = r10.next()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.lang.String r12 = ": "
            r13 = 2
            java.lang.String[] r12 = r11.split(r12, r13)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r13 = r12[r9]     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r14 = 1
            r14 = r12[r14]     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r8.put(r13, r14)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            goto L_0x00c6
        L_0x00e2:
            com.google.firebase.database.tubesock.WebSocketHandshake r9 = r15.handshake     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r9.verifyServerHandshakeHeaders(r8)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            com.google.firebase.database.tubesock.WebSocketWriter r9 = r15.writer     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r9.setOutput(r2)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            com.google.firebase.database.tubesock.WebSocketReceiver r9 = r15.receiver     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r9.setInput(r1)     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            com.google.firebase.database.tubesock.WebSocket$State r9 = com.google.firebase.database.tubesock.WebSocket.State.CONNECTED     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r15.state = r9     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            com.google.firebase.database.tubesock.WebSocketWriter r9 = r15.writer     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            java.lang.Thread r9 = r9.getInnerThread()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r9.start()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            com.google.firebase.database.tubesock.WebSocketEventHandler r9 = r15.eventHandler     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r9.onOpen()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            com.google.firebase.database.tubesock.WebSocketReceiver r9 = r15.receiver     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            r9.run()     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
            goto L_0x0135
        L_0x0109:
            r1 = move-exception
            monitor-exit(r15)     // Catch:{ all -> 0x0109 }
            throw r1     // Catch:{ WebSocketException -> 0x012f, IOException -> 0x010e }
        L_0x010c:
            r0 = move-exception
            goto L_0x013a
        L_0x010e:
            r0 = move-exception
            com.google.firebase.database.tubesock.WebSocketEventHandler r1 = r15.eventHandler     // Catch:{ all -> 0x010c }
            com.google.firebase.database.tubesock.WebSocketException r2 = new com.google.firebase.database.tubesock.WebSocketException     // Catch:{ all -> 0x010c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x010c }
            r3.<init>()     // Catch:{ all -> 0x010c }
            java.lang.String r4 = "error while connecting: "
            r3.append(r4)     // Catch:{ all -> 0x010c }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x010c }
            r3.append(r4)     // Catch:{ all -> 0x010c }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x010c }
            r2.<init>(r3, r0)     // Catch:{ all -> 0x010c }
            r1.onError(r2)     // Catch:{ all -> 0x010c }
            goto L_0x0135
        L_0x012f:
            r0 = move-exception
            com.google.firebase.database.tubesock.WebSocketEventHandler r1 = r15.eventHandler     // Catch:{ all -> 0x010c }
            r1.onError(r0)     // Catch:{ all -> 0x010c }
        L_0x0135:
            r15.close()
            return
        L_0x013a:
            r15.close()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.tubesock.WebSocket.runReader():void");
    }

    /* access modifiers changed from: package-private */
    public Thread getInnerThread() {
        return this.innerThread;
    }
}
