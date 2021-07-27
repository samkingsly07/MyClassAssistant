package com.google.firebase.database.tubesock;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
class WebSocketWriter {
    private WritableByteChannel channel;
    private boolean closeSent = false;
    private final Thread innerThread = WebSocket.getThreadFactory().newThread(new Runnable() {
        public void run() {
            WebSocketWriter.this.runWriter();
        }
    });
    private BlockingQueue<ByteBuffer> pendingBuffers;
    private final Random random = new Random();
    private volatile boolean stop = false;
    private WebSocket websocket;

    WebSocketWriter(WebSocket websocket2, String threadBaseName, int clientId) {
        ThreadInitializer intializer = WebSocket.getIntializer();
        Thread innerThread2 = getInnerThread();
        intializer.setName(innerThread2, threadBaseName + "Writer-" + clientId);
        this.websocket = websocket2;
        this.pendingBuffers = new LinkedBlockingQueue();
    }

    /* access modifiers changed from: package-private */
    public void setOutput(OutputStream output) {
        this.channel = Channels.newChannel(output);
    }

    private ByteBuffer frameInBuffer(byte opcode, boolean masking, byte[] data) throws IOException {
        int headerLength = 2;
        if (masking) {
            headerLength = 2 + 4;
        }
        int length = data.length;
        if (length >= 126) {
            if (length <= 65535) {
                headerLength += 2;
            } else {
                headerLength += 8;
            }
        }
        ByteBuffer frame = ByteBuffer.allocate(data.length + headerLength);
        frame.put((byte) (Byte.MIN_VALUE | opcode));
        int i = 0;
        if (length < 126) {
            if (masking) {
                length |= 128;
            }
            frame.put((byte) length);
        } else if (length <= 65535) {
            int length_field = 126;
            if (masking) {
                length_field = 126 | 128;
            }
            frame.put((byte) length_field);
            frame.putShort((short) length);
        } else {
            int length_field2 = 127;
            if (masking) {
                length_field2 = 127 | 128;
            }
            frame.put((byte) length_field2);
            frame.putInt(0);
            frame.putInt(length);
        }
        if (masking) {
            byte[] mask = generateMask();
            frame.put(mask);
            while (true) {
                int i2 = i;
                if (i2 >= data.length) {
                    break;
                }
                frame.put((byte) (data[i2] ^ mask[i2 % 4]));
                i = i2 + 1;
            }
        }
        frame.flip();
        return frame;
    }

    private byte[] generateMask() {
        byte[] mask = new byte[4];
        this.random.nextBytes(mask);
        return mask;
    }

    /* access modifiers changed from: package-private */
    public synchronized void send(byte opcode, boolean masking, byte[] data) throws IOException {
        ByteBuffer frame = frameInBuffer(opcode, masking, data);
        if (!this.stop || (!this.closeSent && opcode == 8)) {
            if (opcode == 8) {
                this.closeSent = true;
            }
            this.pendingBuffers.add(frame);
        } else {
            throw new WebSocketException("Shouldn't be sending");
        }
    }

    private void writeMessage() throws InterruptedException, IOException {
        this.channel.write(this.pendingBuffers.take());
    }

    /* access modifiers changed from: package-private */
    public void stopIt() {
        this.stop = true;
    }

    private void handleError(WebSocketException e) {
        this.websocket.handleReceiverError(e);
    }

    /* access modifiers changed from: private */
    public void runWriter() {
        while (!this.stop && !Thread.interrupted()) {
            try {
                writeMessage();
            } catch (IOException e) {
                handleError(new WebSocketException("IO Exception", e));
                return;
            } catch (InterruptedException e2) {
                return;
            }
        }
        for (int i = 0; i < this.pendingBuffers.size(); i++) {
            writeMessage();
        }
    }

    /* access modifiers changed from: package-private */
    public Thread getInnerThread() {
        return this.innerThread;
    }
}
