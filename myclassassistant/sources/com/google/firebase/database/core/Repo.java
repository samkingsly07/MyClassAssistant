package com.google.firebase.database.core;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.InternalHelpers;
import com.google.firebase.database.MutableData;
import com.google.firebase.database.Transaction;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.annotations.NotNull;
import com.google.firebase.database.connection.HostInfo;
import com.google.firebase.database.connection.ListenHashProvider;
import com.google.firebase.database.connection.PersistentConnection;
import com.google.firebase.database.connection.RangeMerge;
import com.google.firebase.database.connection.RequestResultCallback;
import com.google.firebase.database.core.AuthTokenProvider;
import com.google.firebase.database.core.SparseSnapshotTree;
import com.google.firebase.database.core.SyncTree;
import com.google.firebase.database.core.persistence.NoopPersistenceManager;
import com.google.firebase.database.core.persistence.PersistenceManager;
import com.google.firebase.database.core.utilities.DefaultClock;
import com.google.firebase.database.core.utilities.OffsetClock;
import com.google.firebase.database.core.utilities.Tree;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.Event;
import com.google.firebase.database.core.view.EventRaiser;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class Repo implements PersistentConnection.Delegate {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final String INTERRUPT_REASON = "repo_interrupt";
    private static final int TRANSACTION_MAX_RETRIES = 25;
    private static final String TRANSACTION_OVERRIDE_BY_SET = "overriddenBySet";
    private static final String TRANSACTION_TOO_MANY_RETRIES = "maxretries";
    /* access modifiers changed from: private */
    public PersistentConnection connection;
    private final Context ctx;
    private final LogWrapper dataLogger;
    public long dataUpdateCount = 0;
    private FirebaseDatabase database;
    private final EventRaiser eventRaiser;
    private boolean hijackHash = false;
    /* access modifiers changed from: private */
    public SnapshotHolder infoData;
    /* access modifiers changed from: private */
    public SyncTree infoSyncTree;
    private boolean loggedTransactionPersistenceWarning = false;
    private long nextWriteId = 1;
    /* access modifiers changed from: private */
    public SparseSnapshotTree onDisconnect;
    /* access modifiers changed from: private */
    public final LogWrapper operationLogger;
    private final RepoInfo repoInfo;
    /* access modifiers changed from: private */
    public final OffsetClock serverClock = new OffsetClock(new DefaultClock(), 0);
    /* access modifiers changed from: private */
    public SyncTree serverSyncTree;
    private final LogWrapper transactionLogger;
    private long transactionOrder = 0;
    /* access modifiers changed from: private */
    public Tree<List<TransactionData>> transactionQueueTree;

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private enum TransactionStatus {
        INITIALIZING,
        RUN,
        SENT,
        COMPLETED,
        SENT_NEEDS_ABORT,
        NEEDS_ABORT
    }

    Repo(RepoInfo repoInfo2, Context ctx2, FirebaseDatabase database2) {
        this.repoInfo = repoInfo2;
        this.ctx = ctx2;
        this.database = database2;
        this.operationLogger = this.ctx.getLogger("RepoOperation");
        this.transactionLogger = this.ctx.getLogger("Transaction");
        this.dataLogger = this.ctx.getLogger("DataOperation");
        this.eventRaiser = new EventRaiser(this.ctx);
        scheduleNow(new Runnable() {
            public void run() {
                Repo.this.deferredInitialization();
            }
        });
    }

    /* access modifiers changed from: private */
    public void deferredInitialization() {
        this.connection = this.ctx.newPersistentConnection(new HostInfo(this.repoInfo.host, this.repoInfo.namespace, this.repoInfo.secure), this);
        this.ctx.getAuthTokenProvider().addTokenChangeListener(new AuthTokenProvider.TokenChangeListener() {
            public void onTokenChange() {
                Repo.this.operationLogger.debug("Auth token changed, triggering auth token refresh", new Object[0]);
                Repo.this.connection.refreshAuthToken();
            }

            public void onTokenChange(String token) {
                Repo.this.operationLogger.debug("Auth token changed, triggering auth token refresh", new Object[0]);
                Repo.this.connection.refreshAuthToken(token);
            }
        });
        this.connection.initialize();
        PersistenceManager persistenceManager = this.ctx.getPersistenceManager(this.repoInfo.host);
        this.infoData = new SnapshotHolder();
        this.onDisconnect = new SparseSnapshotTree();
        this.transactionQueueTree = new Tree<>();
        this.infoSyncTree = new SyncTree(this.ctx, new NoopPersistenceManager(), new SyncTree.ListenProvider() {
            public void startListening(final QuerySpec query, Tag tag, ListenHashProvider hash, final SyncTree.CompletionListener onComplete) {
                Repo.this.scheduleNow(new Runnable() {
                    public void run() {
                        Node node = Repo.this.infoData.getNode(query.getPath());
                        if (!node.isEmpty()) {
                            Repo.this.postEvents(Repo.this.infoSyncTree.applyServerOverwrite(query.getPath(), node));
                            onComplete.onListenComplete((DatabaseError) null);
                        }
                    }
                });
            }

            public void stopListening(QuerySpec query, Tag tag) {
            }
        });
        this.serverSyncTree = new SyncTree(this.ctx, persistenceManager, new SyncTree.ListenProvider() {
            public void startListening(QuerySpec query, Tag tag, ListenHashProvider hash, final SyncTree.CompletionListener onListenComplete) {
                Repo.this.connection.listen(query.getPath().asList(), query.getParams().getWireProtocolParams(), hash, tag != null ? Long.valueOf(tag.getTagNumber()) : null, new RequestResultCallback() {
                    public void onRequestResult(String optErrorCode, String optErrorMessage) {
                        Repo.this.postEvents(onListenComplete.onListenComplete(Repo.fromErrorCode(optErrorCode, optErrorMessage)));
                    }
                });
            }

            public void stopListening(QuerySpec query, Tag tag) {
                Repo.this.connection.unlisten(query.getPath().asList(), query.getParams().getWireProtocolParams());
            }
        });
        restoreWrites(persistenceManager);
        updateInfo(Constants.DOT_INFO_AUTHENTICATED, false);
        updateInfo(Constants.DOT_INFO_CONNECTED, false);
    }

    private void restoreWrites(PersistenceManager persistenceManager) {
        List<UserWriteRecord> writes = persistenceManager.loadUserWrites();
        Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
        long lastWriteId = Long.MIN_VALUE;
        for (final UserWriteRecord write : writes) {
            RequestResultCallback onComplete = new RequestResultCallback() {
                public void onRequestResult(String optErrorCode, String optErrorMessage) {
                    DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                    Repo.this.warnIfWriteFailed("Persisted write", write.getPath(), error);
                    Repo.this.ackWriteAndRerunTransactions(write.getWriteId(), write.getPath(), error);
                }
            };
            if (lastWriteId >= write.getWriteId()) {
                throw new IllegalStateException("Write ids were not in order.");
            }
            lastWriteId = write.getWriteId();
            this.nextWriteId = write.getWriteId() + 1;
            if (write.isOverwrite()) {
                if (this.operationLogger.logsDebug()) {
                    LogWrapper logWrapper = this.operationLogger;
                    logWrapper.debug("Restoring overwrite with id " + write.getWriteId(), new Object[0]);
                }
                this.connection.put(write.getPath().asList(), write.getOverwrite().getValue(true), onComplete);
                this.serverSyncTree.applyUserOverwrite(write.getPath(), write.getOverwrite(), ServerValues.resolveDeferredValueSnapshot(write.getOverwrite(), serverValues), write.getWriteId(), true, false);
            } else {
                if (this.operationLogger.logsDebug()) {
                    LogWrapper logWrapper2 = this.operationLogger;
                    logWrapper2.debug("Restoring merge with id " + write.getWriteId(), new Object[0]);
                }
                this.connection.merge(write.getPath().asList(), write.getMerge().getValue(true), onComplete);
                this.serverSyncTree.applyUserMerge(write.getPath(), write.getMerge(), ServerValues.resolveDeferredValueMerge(write.getMerge(), serverValues), write.getWriteId(), false);
            }
        }
    }

    public FirebaseDatabase getDatabase() {
        return this.database;
    }

    public String toString() {
        return this.repoInfo.toString();
    }

    public RepoInfo getRepoInfo() {
        return this.repoInfo;
    }

    public void scheduleNow(Runnable r) {
        this.ctx.requireStarted();
        this.ctx.getRunLoop().scheduleNow(r);
    }

    public void postEvent(Runnable r) {
        this.ctx.requireStarted();
        this.ctx.getEventTarget().postEvent(r);
    }

    /* access modifiers changed from: private */
    public void postEvents(List<? extends Event> events) {
        if (!events.isEmpty()) {
            this.eventRaiser.raiseEvents(events);
        }
    }

    public long getServerTime() {
        return this.serverClock.millis();
    }

    /* access modifiers changed from: package-private */
    public boolean hasListeners() {
        return !this.infoSyncTree.isEmpty() || !this.serverSyncTree.isEmpty();
    }

    public void onDataUpdate(List<String> pathSegments, Object message, boolean isMerge, Long optTag) {
        List<? extends Event> events;
        List<? extends Event> events2;
        Path path = new Path(pathSegments);
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("onDataUpdate: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("onDataUpdate: " + path + " " + message, new Object[0]);
        }
        this.dataUpdateCount++;
        if (optTag != null) {
            try {
                Tag tag = new Tag(optTag.longValue());
                if (isMerge) {
                    Map<Path, Node> taggedChildren = new HashMap<>();
                    for (Map.Entry<String, Object> entry : ((Map) message).entrySet()) {
                        taggedChildren.put(new Path(entry.getKey()), NodeUtilities.NodeFromJSON(entry.getValue()));
                    }
                    events2 = this.serverSyncTree.applyTaggedQueryMerge(path, taggedChildren, tag);
                } else {
                    events2 = this.serverSyncTree.applyTaggedQueryOverwrite(path, NodeUtilities.NodeFromJSON(message), tag);
                }
                events = events2;
            } catch (DatabaseException e) {
                this.operationLogger.error("FIREBASE INTERNAL ERROR", e);
                return;
            }
        } else if (isMerge) {
            Map<Path, Node> changedChildren = new HashMap<>();
            for (Map.Entry<String, Object> entry2 : ((Map) message).entrySet()) {
                changedChildren.put(new Path(entry2.getKey()), NodeUtilities.NodeFromJSON(entry2.getValue()));
            }
            events = this.serverSyncTree.applyServerMerge(path, changedChildren);
        } else {
            events = this.serverSyncTree.applyServerOverwrite(path, NodeUtilities.NodeFromJSON(message));
        }
        if (events.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(events);
    }

    public void onRangeMergeUpdate(List<String> pathSegments, List<RangeMerge> merges, Long tagNumber) {
        List<? extends Event> events;
        Path path = new Path(pathSegments);
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("onRangeMergeUpdate: " + path, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("onRangeMergeUpdate: " + path + " " + merges, new Object[0]);
        }
        this.dataUpdateCount++;
        List<com.google.firebase.database.snapshot.RangeMerge> parsedMerges = new ArrayList<>(merges.size());
        for (RangeMerge merge : merges) {
            parsedMerges.add(new com.google.firebase.database.snapshot.RangeMerge(merge));
        }
        if (tagNumber != null) {
            events = this.serverSyncTree.applyTaggedRangeMerges(path, parsedMerges, new Tag(tagNumber.longValue()));
        } else {
            events = this.serverSyncTree.applyServerRangeMerges(path, parsedMerges);
        }
        if (events.size() > 0) {
            rerunTransactions(path);
        }
        postEvents(events);
    }

    /* access modifiers changed from: package-private */
    public void callOnComplete(final DatabaseReference.CompletionListener onComplete, final DatabaseError error, Path path) {
        final DatabaseReference ref;
        if (onComplete != null) {
            ChildKey last = path.getBack();
            if (last == null || !last.isPriorityChildName()) {
                ref = InternalHelpers.createReference(this, path);
            } else {
                ref = InternalHelpers.createReference(this, path.getParent());
            }
            postEvent(new Runnable() {
                public void run() {
                    onComplete.onComplete(error, ref);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void ackWriteAndRerunTransactions(long writeId, Path path, DatabaseError error) {
        if (error == null || error.getCode() != -25) {
            List<? extends Event> clearEvents = this.serverSyncTree.ackUserWrite(writeId, !(error == null), true, this.serverClock);
            if (clearEvents.size() > 0) {
                rerunTransactions(path);
            }
            postEvents(clearEvents);
        }
    }

    public void setValue(Path path, Node newValueUnresolved, DatabaseReference.CompletionListener onComplete) {
        Path path2 = path;
        Node node = newValueUnresolved;
        if (this.operationLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            logWrapper.debug("set: " + path2, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            LogWrapper logWrapper2 = this.dataLogger;
            logWrapper2.debug("set: " + path2 + " " + node, new Object[0]);
        }
        Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
        Node newValue = ServerValues.resolveDeferredValueSnapshot(node, serverValues);
        long writeId = getNextWriteId();
        postEvents(this.serverSyncTree.applyUserOverwrite(path2, node, newValue, writeId, true, true));
        PersistentConnection persistentConnection = this.connection;
        List<String> asList = path.asList();
        Object value = node.getValue(true);
        final Path path3 = path2;
        Map<String, Object> map = serverValues;
        final long j = writeId;
        final DatabaseReference.CompletionListener completionListener = onComplete;
        persistentConnection.put(asList, value, new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("setValue", path3, error);
                Repo.this.ackWriteAndRerunTransactions(j, path3, error);
                Repo.this.callOnComplete(completionListener, error, path3);
            }
        });
        rerunTransactions(abortTransactions(path2, -9));
    }

    public void updateChildren(Path path, CompoundWrite updates, DatabaseReference.CompletionListener onComplete, Map<String, Object> unParsedUpdates) {
        Path path2 = path;
        Map<String, Object> map = unParsedUpdates;
        if (this.operationLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            logWrapper.debug("update: " + path2, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            LogWrapper logWrapper2 = this.dataLogger;
            logWrapper2.debug("update: " + path2 + " " + map, new Object[0]);
        }
        if (updates.isEmpty()) {
            if (this.operationLogger.logsDebug()) {
                this.operationLogger.debug("update called with no changes. No-op", new Object[0]);
            }
            callOnComplete(onComplete, (DatabaseError) null, path2);
            return;
        }
        final DatabaseReference.CompletionListener completionListener = onComplete;
        Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
        CompoundWrite compoundWrite = updates;
        CompoundWrite resolved = ServerValues.resolveDeferredValueMerge(compoundWrite, serverValues);
        long writeId = getNextWriteId();
        postEvents(this.serverSyncTree.applyUserMerge(path2, compoundWrite, resolved, writeId, true));
        final Path path3 = path2;
        Map<String, Object> map2 = serverValues;
        final long j = writeId;
        this.connection.merge(path.asList(), map, new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("updateChildren", path3, error);
                Repo.this.ackWriteAndRerunTransactions(j, path3, error);
                Repo.this.callOnComplete(completionListener, error, path3);
            }
        });
        Iterator<Map.Entry<Path, Node>> it = updates.iterator();
        while (it.hasNext()) {
            rerunTransactions(abortTransactions(path2.child(it.next().getKey()), -9));
        }
    }

    public void purgeOutstandingWrites() {
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("Purging writes", new Object[0]);
        }
        postEvents(this.serverSyncTree.removeAllWrites());
        abortTransactions(Path.getEmptyPath(), -25);
        this.connection.purgeOutstandingWrites();
    }

    public void removeEventCallback(@NotNull EventRegistration eventRegistration) {
        List<Event> events;
        if (Constants.DOT_INFO.equals(eventRegistration.getQuerySpec().getPath().getFront())) {
            events = this.infoSyncTree.removeEventRegistration(eventRegistration);
        } else {
            events = this.serverSyncTree.removeEventRegistration(eventRegistration);
        }
        postEvents(events);
    }

    public void onDisconnectSetValue(final Path path, final Node newValue, final DatabaseReference.CompletionListener onComplete) {
        this.connection.onDisconnectPut(path.asList(), newValue.getValue(true), new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("onDisconnect().setValue", path, error);
                if (error == null) {
                    Repo.this.onDisconnect.remember(path, newValue);
                }
                Repo.this.callOnComplete(onComplete, error, path);
            }
        });
    }

    public void onDisconnectUpdate(final Path path, final Map<Path, Node> newChildren, final DatabaseReference.CompletionListener listener, Map<String, Object> unParsedUpdates) {
        this.connection.onDisconnectMerge(path.asList(), unParsedUpdates, new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("onDisconnect().updateChildren", path, error);
                if (error == null) {
                    for (Map.Entry<Path, Node> entry : newChildren.entrySet()) {
                        Repo.this.onDisconnect.remember(path.child(entry.getKey()), entry.getValue());
                    }
                }
                Repo.this.callOnComplete(listener, error, path);
            }
        });
    }

    public void onDisconnectCancel(final Path path, final DatabaseReference.CompletionListener onComplete) {
        this.connection.onDisconnectCancel(path.asList(), new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                if (error == null) {
                    Repo.this.onDisconnect.forget(path);
                }
                Repo.this.callOnComplete(onComplete, error, path);
            }
        });
    }

    public void onConnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, true);
    }

    public void onDisconnect() {
        onServerInfoUpdate(Constants.DOT_INFO_CONNECTED, false);
        runOnDisconnectEvents();
    }

    public void onAuthStatus(boolean authOk) {
        onServerInfoUpdate(Constants.DOT_INFO_AUTHENTICATED, Boolean.valueOf(authOk));
    }

    public void onServerInfoUpdate(ChildKey key, Object value) {
        updateInfo(key, value);
    }

    public void onServerInfoUpdate(Map<String, Object> updates) {
        for (Map.Entry<String, Object> entry : updates.entrySet()) {
            updateInfo(ChildKey.fromString(entry.getKey()), entry.getValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void interrupt() {
        this.connection.interrupt(INTERRUPT_REASON);
    }

    /* access modifiers changed from: package-private */
    public void resume() {
        this.connection.resume(INTERRUPT_REASON);
    }

    public void addEventCallback(@NotNull EventRegistration eventRegistration) {
        List<? extends Event> events;
        ChildKey front = eventRegistration.getQuerySpec().getPath().getFront();
        if (front == null || !front.equals(Constants.DOT_INFO)) {
            events = this.serverSyncTree.addEventRegistration(eventRegistration);
        } else {
            events = this.infoSyncTree.addEventRegistration(eventRegistration);
        }
        postEvents(events);
    }

    public void keepSynced(QuerySpec query, boolean keep) {
        this.serverSyncTree.keepSynced(query, keep);
    }

    /* access modifiers changed from: package-private */
    public PersistentConnection getConnection() {
        return this.connection;
    }

    private void updateInfo(ChildKey childKey, Object value) {
        if (childKey.equals(Constants.DOT_INFO_SERVERTIME_OFFSET)) {
            this.serverClock.setOffset(((Long) value).longValue());
        }
        Path path = new Path(Constants.DOT_INFO, childKey);
        try {
            Node node = NodeUtilities.NodeFromJSON(value);
            this.infoData.update(path, node);
            postEvents(this.infoSyncTree.applyServerOverwrite(path, node));
        } catch (DatabaseException e) {
            this.operationLogger.error("Failed to parse info update", e);
        }
    }

    private long getNextWriteId() {
        long j = this.nextWriteId;
        this.nextWriteId = j + 1;
        return j;
    }

    private void runOnDisconnectEvents() {
        SparseSnapshotTree resolvedTree = ServerValues.resolveDeferredValueTree(this.onDisconnect, ServerValues.generateServerValues(this.serverClock));
        final List<Event> events = new ArrayList<>();
        resolvedTree.forEachTree(Path.getEmptyPath(), new SparseSnapshotTree.SparseSnapshotTreeVisitor() {
            public void visitTree(Path prefixPath, Node node) {
                events.addAll(Repo.this.serverSyncTree.applyServerOverwrite(prefixPath, node));
                Path unused = Repo.this.rerunTransactions(Repo.this.abortTransactions(prefixPath, -9));
            }
        });
        this.onDisconnect = new SparseSnapshotTree();
        postEvents(events);
    }

    /* access modifiers changed from: private */
    public void warnIfWriteFailed(String writeType, Path path, DatabaseError error) {
        if (error != null && error.getCode() != -1 && error.getCode() != -25) {
            LogWrapper logWrapper = this.operationLogger;
            logWrapper.warn(writeType + " at " + path.toString() + " failed: " + error.toString());
        }
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private static class TransactionData implements Comparable<TransactionData> {
        /* access modifiers changed from: private */
        public DatabaseError abortReason;
        /* access modifiers changed from: private */
        public boolean applyLocally;
        /* access modifiers changed from: private */
        public Node currentInputSnapshot;
        /* access modifiers changed from: private */
        public Node currentOutputSnapshotRaw;
        /* access modifiers changed from: private */
        public Node currentOutputSnapshotResolved;
        /* access modifiers changed from: private */
        public long currentWriteId;
        /* access modifiers changed from: private */
        public Transaction.Handler handler;
        private long order;
        /* access modifiers changed from: private */
        public ValueEventListener outstandingListener;
        /* access modifiers changed from: private */
        public Path path;
        /* access modifiers changed from: private */
        public int retryCount;
        /* access modifiers changed from: private */
        public TransactionStatus status;

        static /* synthetic */ int access$2008(TransactionData x0) {
            int i = x0.retryCount;
            x0.retryCount = i + 1;
            return i;
        }

        private TransactionData(Path path2, Transaction.Handler handler2, ValueEventListener outstandingListener2, TransactionStatus status2, boolean applyLocally2, long order2) {
            this.path = path2;
            this.handler = handler2;
            this.outstandingListener = outstandingListener2;
            this.status = status2;
            this.retryCount = 0;
            this.applyLocally = applyLocally2;
            this.order = order2;
            this.abortReason = null;
            this.currentInputSnapshot = null;
            this.currentOutputSnapshotRaw = null;
            this.currentOutputSnapshotResolved = null;
        }

        public int compareTo(TransactionData o) {
            if (this.order < o.order) {
                return -1;
            }
            if (this.order == o.order) {
                return 0;
            }
            return 1;
        }
    }

    public void startTransaction(Path path, Transaction.Handler handler, boolean applyLocally) {
        Transaction.Result result;
        Path path2 = path;
        final Transaction.Handler handler2 = handler;
        if (this.operationLogger.logsDebug()) {
            this.operationLogger.debug("transaction: " + path2, new Object[0]);
        }
        if (this.dataLogger.logsDebug()) {
            this.operationLogger.debug("transaction: " + path2, new Object[0]);
        }
        if (this.ctx.isPersistenceEnabled() && !this.loggedTransactionPersistenceWarning) {
            this.loggedTransactionPersistenceWarning = true;
            this.transactionLogger.info("runTransaction() usage detected while persistence is enabled. Please be aware that transactions *will not* be persisted across database restarts.  See https://www.firebase.com/docs/android/guide/offline-capabilities.html#section-handling-transactions-offline for more details.");
        }
        DatabaseReference watchRef = InternalHelpers.createReference(this, path);
        ValueEventListener listener = new ValueEventListener() {
            public void onDataChange(DataSnapshot snapshot) {
            }

            public void onCancelled(DatabaseError error) {
            }
        };
        addEventCallback(new ValueEventRegistration(this, listener, watchRef.getSpec()));
        TransactionData transaction = new TransactionData(path2, handler2, listener, TransactionStatus.INITIALIZING, applyLocally, nextTransactionOrder());
        Node currentState = getLatestState(path);
        Node unused = transaction.currentInputSnapshot = currentState;
        MutableData mutableCurrent = InternalHelpers.createMutableData(currentState);
        DatabaseError error = null;
        try {
            result = handler2.doTransaction(mutableCurrent);
            if (result == null) {
                throw new NullPointerException("Transaction returned null as result");
            }
        } catch (Throwable th) {
            Throwable e = th;
            this.operationLogger.error("Caught Throwable.", e);
            error = DatabaseError.fromException(e);
            result = Transaction.abort();
        }
        DatabaseError error2 = error;
        Transaction.Result result2 = result;
        if (!result2.isSuccess()) {
            Node unused2 = transaction.currentOutputSnapshotRaw = null;
            Node unused3 = transaction.currentOutputSnapshotResolved = null;
            final DatabaseError innerClassError = error2;
            final DataSnapshot snap = InternalHelpers.createDataSnapshot(watchRef, IndexedNode.from(transaction.currentInputSnapshot));
            postEvent(new Runnable() {
                public void run() {
                    handler2.onComplete(innerClassError, false, snap);
                }
            });
            Transaction.Result result3 = result2;
            MutableData mutableData = mutableCurrent;
            return;
        }
        TransactionStatus unused4 = transaction.status = TransactionStatus.RUN;
        Tree<List<TransactionData>> queueNode = this.transactionQueueTree.subTree(path2);
        List<TransactionData> nodeQueue = queueNode.getValue();
        if (nodeQueue == null) {
            nodeQueue = new ArrayList<>();
        }
        List<TransactionData> nodeQueue2 = nodeQueue;
        nodeQueue2.add(transaction);
        queueNode.setValue(nodeQueue2);
        Map<String, Object> serverValues = ServerValues.generateServerValues(this.serverClock);
        Node newNodeUnresolved = result2.getNode();
        Node newNode = ServerValues.resolveDeferredValueSnapshot(newNodeUnresolved, serverValues);
        Node unused5 = transaction.currentOutputSnapshotRaw = newNodeUnresolved;
        Node unused6 = transaction.currentOutputSnapshotResolved = newNode;
        long unused7 = transaction.currentWriteId = getNextWriteId();
        Node node = newNodeUnresolved;
        Map<String, Object> map = serverValues;
        Tree<List<TransactionData>> tree = queueNode;
        List<TransactionData> list = nodeQueue2;
        Transaction.Result result4 = result2;
        MutableData mutableData2 = mutableCurrent;
        postEvents(this.serverSyncTree.applyUserOverwrite(path2, newNodeUnresolved, newNode, transaction.currentWriteId, applyLocally, false));
        sendAllReadyTransactions();
    }

    private Node getLatestState(Path path) {
        return getLatestState(path, new ArrayList());
    }

    private Node getLatestState(Path path, List<Long> excudeSets) {
        Node state = this.serverSyncTree.calcCompleteEventCache(path, excudeSets);
        if (state == null) {
            return EmptyNode.Empty();
        }
        return state;
    }

    public void setHijackHash(boolean hijackHash2) {
        this.hijackHash = hijackHash2;
    }

    /* access modifiers changed from: private */
    public void sendAllReadyTransactions() {
        Tree<List<TransactionData>> node = this.transactionQueueTree;
        pruneCompletedTransactions(node);
        sendReadyTransactions(node);
    }

    /* access modifiers changed from: private */
    public void sendReadyTransactions(Tree<List<TransactionData>> node) {
        if (node.getValue() != null) {
            List<TransactionData> queue = buildTransactionQueue(node);
            Boolean allRun = true;
            Iterator<TransactionData> it = queue.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (it.next().status != TransactionStatus.RUN) {
                        allRun = false;
                        break;
                    }
                } else {
                    break;
                }
            }
            if (allRun.booleanValue()) {
                sendTransactionQueue(queue, node.getPath());
            }
        } else if (node.hasChildren()) {
            node.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
                public void visitTree(Tree<List<TransactionData>> tree) {
                    Repo.this.sendReadyTransactions(tree);
                }
            });
        }
    }

    private void sendTransactionQueue(final List<TransactionData> queue, final Path path) {
        List<Long> setsToIgnore = new ArrayList<>();
        for (TransactionData txn : queue) {
            setsToIgnore.add(Long.valueOf(txn.currentWriteId));
        }
        Node latestState = getLatestState(path, setsToIgnore);
        Node snapToSend = latestState;
        String latestHash = "badhash";
        if (!this.hijackHash) {
            latestHash = latestState.getHash();
        }
        for (TransactionData txn2 : queue) {
            TransactionStatus unused = txn2.status = TransactionStatus.SENT;
            TransactionData.access$2008(txn2);
            snapToSend = snapToSend.updateChild(Path.getRelative(path, txn2.path), txn2.currentOutputSnapshotRaw);
        }
        this.connection.compareAndPut(path.asList(), snapToSend.getValue(true), latestHash, new RequestResultCallback() {
            public void onRequestResult(String optErrorCode, String optErrorMessage) {
                DatabaseError error = Repo.fromErrorCode(optErrorCode, optErrorMessage);
                Repo.this.warnIfWriteFailed("Transaction", path, error);
                List<Event> events = new ArrayList<>();
                if (error == null) {
                    List<Runnable> callbacks = new ArrayList<>();
                    for (final TransactionData txn : queue) {
                        TransactionStatus unused = txn.status = TransactionStatus.COMPLETED;
                        events.addAll(Repo.this.serverSyncTree.ackUserWrite(txn.currentWriteId, false, false, Repo.this.serverClock));
                        final DataSnapshot snap = InternalHelpers.createDataSnapshot(InternalHelpers.createReference(this, txn.path), IndexedNode.from(txn.currentOutputSnapshotResolved));
                        callbacks.add(new Runnable() {
                            public void run() {
                                txn.handler.onComplete((DatabaseError) null, true, snap);
                            }
                        });
                        Repo.this.removeEventCallback(new ValueEventRegistration(Repo.this, txn.outstandingListener, QuerySpec.defaultQueryAtPath(txn.path)));
                    }
                    Repo.this.pruneCompletedTransactions(Repo.this.transactionQueueTree.subTree(path));
                    Repo.this.sendAllReadyTransactions();
                    this.postEvents(events);
                    for (int i = 0; i < callbacks.size(); i++) {
                        Repo.this.postEvent(callbacks.get(i));
                    }
                    return;
                }
                if (error.getCode() == -1) {
                    for (TransactionData transaction : queue) {
                        if (transaction.status == TransactionStatus.SENT_NEEDS_ABORT) {
                            TransactionStatus unused2 = transaction.status = TransactionStatus.NEEDS_ABORT;
                        } else {
                            TransactionStatus unused3 = transaction.status = TransactionStatus.RUN;
                        }
                    }
                } else {
                    for (TransactionData transaction2 : queue) {
                        TransactionStatus unused4 = transaction2.status = TransactionStatus.NEEDS_ABORT;
                        DatabaseError unused5 = transaction2.abortReason = error;
                    }
                }
                Path unused6 = Repo.this.rerunTransactions(path);
            }
        });
    }

    /* access modifiers changed from: private */
    public void pruneCompletedTransactions(Tree<List<TransactionData>> node) {
        List<TransactionData> queue = node.getValue();
        if (queue != null) {
            int i = 0;
            while (i < queue.size()) {
                if (queue.get(i).status == TransactionStatus.COMPLETED) {
                    queue.remove(i);
                } else {
                    i++;
                }
            }
            if (queue.size() > 0) {
                node.setValue(queue);
            } else {
                node.setValue(null);
            }
        }
        node.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.pruneCompletedTransactions(tree);
            }
        });
    }

    private long nextTransactionOrder() {
        long j = this.transactionOrder;
        this.transactionOrder = j + 1;
        return j;
    }

    /* access modifiers changed from: private */
    public Path rerunTransactions(Path changedPath) {
        Tree<List<TransactionData>> rootMostTransactionNode = getAncestorTransactionNode(changedPath);
        Path path = rootMostTransactionNode.getPath();
        rerunTransactionQueue(buildTransactionQueue(rootMostTransactionNode), path);
        return path;
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x016f  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x019a A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void rerunTransactionQueue(java.util.List<com.google.firebase.database.core.Repo.TransactionData> r33, com.google.firebase.database.core.Path r34) {
        /*
            r32 = this;
            r1 = r32
            boolean r2 = r33.isEmpty()
            if (r2 == 0) goto L_0x0009
            return
        L_0x0009:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.util.Iterator r4 = r33.iterator()
        L_0x0017:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x002f
            java.lang.Object r5 = r4.next()
            com.google.firebase.database.core.Repo$TransactionData r5 = (com.google.firebase.database.core.Repo.TransactionData) r5
            long r6 = r5.currentWriteId
            java.lang.Long r6 = java.lang.Long.valueOf(r6)
            r3.add(r6)
            goto L_0x0017
        L_0x002f:
            java.util.Iterator r4 = r33.iterator()
        L_0x0033:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x019f
            java.lang.Object r5 = r4.next()
            com.google.firebase.database.core.Repo$TransactionData r5 = (com.google.firebase.database.core.Repo.TransactionData) r5
            com.google.firebase.database.core.Path r6 = r5.path
            r7 = r34
            com.google.firebase.database.core.Path r6 = com.google.firebase.database.core.Path.getRelative(r7, r6)
            r8 = 0
            r9 = 0
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            com.google.firebase.database.core.Repo$TransactionStatus r11 = r5.status
            com.google.firebase.database.core.Repo$TransactionStatus r12 = com.google.firebase.database.core.Repo.TransactionStatus.NEEDS_ABORT
            if (r11 != r12) goto L_0x0081
            r8 = 1
            com.google.firebase.database.DatabaseError r9 = r5.abortReason
            int r11 = r9.getCode()
            r12 = -25
            if (r11 == r12) goto L_0x007b
            com.google.firebase.database.core.SyncTree r13 = r1.serverSyncTree
            long r14 = r5.currentWriteId
            r16 = 1
            r17 = 0
            com.google.firebase.database.core.utilities.OffsetClock r11 = r1.serverClock
            r18 = r11
            java.util.List r11 = r13.ackUserWrite(r14, r16, r17, r18)
            r10.addAll(r11)
        L_0x007b:
            r20 = r4
            r29 = r6
            goto L_0x016a
        L_0x0081:
            com.google.firebase.database.core.Repo$TransactionStatus r11 = r5.status
            com.google.firebase.database.core.Repo$TransactionStatus r12 = com.google.firebase.database.core.Repo.TransactionStatus.RUN
            if (r11 != r12) goto L_0x0162
            int r11 = r5.retryCount
            r12 = 25
            if (r11 < r12) goto L_0x00ac
            r8 = 1
            java.lang.String r11 = "maxretries"
            com.google.firebase.database.DatabaseError r9 = com.google.firebase.database.DatabaseError.fromStatus(r11)
            com.google.firebase.database.core.SyncTree r11 = r1.serverSyncTree
            long r12 = r5.currentWriteId
            r14 = 1
            com.google.firebase.database.core.utilities.OffsetClock r15 = r1.serverClock
            r16 = r15
            r15 = 0
            java.util.List r11 = r11.ackUserWrite(r12, r14, r15, r16)
            r10.addAll(r11)
            goto L_0x007b
        L_0x00ac:
            com.google.firebase.database.core.Path r11 = r5.path
            com.google.firebase.database.snapshot.Node r11 = r1.getLatestState(r11, r3)
            com.google.firebase.database.snapshot.Node unused = r5.currentInputSnapshot = r11
            com.google.firebase.database.MutableData r12 = com.google.firebase.database.InternalHelpers.createMutableData(r11)
            r13 = 0
            com.google.firebase.database.Transaction$Handler r14 = r5.handler     // Catch:{ Throwable -> 0x00c8 }
            com.google.firebase.database.Transaction$Result r14 = r14.doTransaction(r12)     // Catch:{ Throwable -> 0x00c8 }
            r20 = r4
            goto L_0x00db
        L_0x00c8:
            r0 = move-exception
            r14 = r0
            com.google.firebase.database.logging.LogWrapper r15 = r1.operationLogger
            r20 = r4
            java.lang.String r4 = "Caught Throwable."
            r15.error(r4, r14)
            com.google.firebase.database.DatabaseError r13 = com.google.firebase.database.DatabaseError.fromException(r14)
            com.google.firebase.database.Transaction$Result r14 = com.google.firebase.database.Transaction.abort()
        L_0x00db:
            r4 = r14
            boolean r14 = r4.isSuccess()
            if (r14 == 0) goto L_0x0144
            long r14 = r5.currentWriteId
            java.lang.Long r14 = java.lang.Long.valueOf(r14)
            com.google.firebase.database.core.utilities.OffsetClock r15 = r1.serverClock
            java.util.Map r15 = com.google.firebase.database.core.ServerValues.generateServerValues(r15)
            r29 = r6
            com.google.firebase.database.snapshot.Node r6 = r4.getNode()
            r30 = r4
            com.google.firebase.database.snapshot.Node r4 = com.google.firebase.database.core.ServerValues.resolveDeferredValueSnapshot(r6, r15)
            com.google.firebase.database.snapshot.Node unused = r5.currentOutputSnapshotRaw = r6
            com.google.firebase.database.snapshot.Node unused = r5.currentOutputSnapshotResolved = r4
            r31 = r8
            long r7 = r32.getNextWriteId()
            long unused = r5.currentWriteId = r7
            r3.remove(r14)
            com.google.firebase.database.core.SyncTree r7 = r1.serverSyncTree
            com.google.firebase.database.core.Path r22 = r5.path
            long r25 = r5.currentWriteId
            boolean r27 = r5.applyLocally
            r28 = 0
            r21 = r7
            r23 = r6
            r24 = r4
            java.util.List r7 = r21.applyUserOverwrite(r22, r23, r24, r25, r27, r28)
            r10.addAll(r7)
            com.google.firebase.database.core.SyncTree r7 = r1.serverSyncTree
            long r22 = r14.longValue()
            r24 = 1
            r25 = 0
            com.google.firebase.database.core.utilities.OffsetClock r8 = r1.serverClock
            r21 = r7
            r26 = r8
            java.util.List r7 = r21.ackUserWrite(r22, r24, r25, r26)
            r10.addAll(r7)
            goto L_0x0168
        L_0x0144:
            r30 = r4
            r29 = r6
            r31 = r8
            r8 = 1
            r9 = r13
            com.google.firebase.database.core.SyncTree r14 = r1.serverSyncTree
            long r15 = r5.currentWriteId
            r17 = 1
            r18 = 0
            com.google.firebase.database.core.utilities.OffsetClock r4 = r1.serverClock
            r19 = r4
            java.util.List r4 = r14.ackUserWrite(r15, r17, r18, r19)
            r10.addAll(r4)
            goto L_0x016a
        L_0x0162:
            r20 = r4
            r29 = r6
            r31 = r8
        L_0x0168:
            r8 = r31
        L_0x016a:
            r1.postEvents(r10)
            if (r8 == 0) goto L_0x019a
            com.google.firebase.database.core.Repo$TransactionStatus r4 = com.google.firebase.database.core.Repo.TransactionStatus.COMPLETED
            com.google.firebase.database.core.Repo.TransactionStatus unused = r5.status = r4
            com.google.firebase.database.core.Path r4 = r5.path
            com.google.firebase.database.DatabaseReference r4 = com.google.firebase.database.InternalHelpers.createReference(r1, r4)
            com.google.firebase.database.snapshot.Node r6 = r5.currentInputSnapshot
            com.google.firebase.database.snapshot.IndexedNode r7 = com.google.firebase.database.snapshot.IndexedNode.from(r6)
            com.google.firebase.database.DataSnapshot r7 = com.google.firebase.database.InternalHelpers.createDataSnapshot(r4, r7)
            com.google.firebase.database.core.Repo$18 r11 = new com.google.firebase.database.core.Repo$18
            r11.<init>(r5)
            r1.scheduleNow(r11)
            r11 = r9
            com.google.firebase.database.core.Repo$19 r12 = new com.google.firebase.database.core.Repo$19
            r12.<init>(r5, r11, r7)
            r2.add(r12)
        L_0x019a:
            r4 = r20
            goto L_0x0033
        L_0x019f:
            com.google.firebase.database.core.utilities.Tree<java.util.List<com.google.firebase.database.core.Repo$TransactionData>> r4 = r1.transactionQueueTree
            r1.pruneCompletedTransactions(r4)
            r4 = 0
        L_0x01a5:
            int r5 = r2.size()
            if (r4 >= r5) goto L_0x01b7
            java.lang.Object r5 = r2.get(r4)
            java.lang.Runnable r5 = (java.lang.Runnable) r5
            r1.postEvent(r5)
            int r4 = r4 + 1
            goto L_0x01a5
        L_0x01b7:
            r32.sendAllReadyTransactions()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.Repo.rerunTransactionQueue(java.util.List, com.google.firebase.database.core.Path):void");
    }

    private Tree<List<TransactionData>> getAncestorTransactionNode(Path path) {
        Tree<List<TransactionData>> transactionNode = this.transactionQueueTree;
        while (!path.isEmpty() && transactionNode.getValue() == null) {
            transactionNode = transactionNode.subTree(new Path(path.getFront()));
            path = path.popFront();
        }
        return transactionNode;
    }

    private List<TransactionData> buildTransactionQueue(Tree<List<TransactionData>> transactionNode) {
        List<TransactionData> queue = new ArrayList<>();
        aggregateTransactionQueues(queue, transactionNode);
        Collections.sort(queue);
        return queue;
    }

    /* access modifiers changed from: private */
    public void aggregateTransactionQueues(final List<TransactionData> queue, Tree<List<TransactionData>> node) {
        List<TransactionData> childQueue = node.getValue();
        if (childQueue != null) {
            queue.addAll(childQueue);
        }
        node.forEachChild(new Tree.TreeVisitor<List<TransactionData>>() {
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.aggregateTransactionQueues(queue, tree);
            }
        });
    }

    /* access modifiers changed from: private */
    public Path abortTransactions(Path path, final int reason) {
        Path affectedPath = getAncestorTransactionNode(path).getPath();
        if (this.transactionLogger.logsDebug()) {
            LogWrapper logWrapper = this.operationLogger;
            logWrapper.debug("Aborting transactions for path: " + path + ". Affected: " + affectedPath, new Object[0]);
        }
        Tree<List<TransactionData>> transactionNode = this.transactionQueueTree.subTree(path);
        transactionNode.forEachAncestor(new Tree.TreeFilter<List<TransactionData>>() {
            public boolean filterTreeNode(Tree<List<TransactionData>> tree) {
                Repo.this.abortTransactionsAtNode(tree, reason);
                return false;
            }
        });
        abortTransactionsAtNode(transactionNode, reason);
        transactionNode.forEachDescendant(new Tree.TreeVisitor<List<TransactionData>>() {
            public void visitTree(Tree<List<TransactionData>> tree) {
                Repo.this.abortTransactionsAtNode(tree, reason);
            }
        });
        return affectedPath;
    }

    /* access modifiers changed from: private */
    public void abortTransactionsAtNode(Tree<List<TransactionData>> node, int reason) {
        final DatabaseError abortError;
        Tree<List<TransactionData>> tree = node;
        int i = reason;
        List<TransactionData> queue = node.getValue();
        List<Event> events = new ArrayList<>();
        if (queue != null) {
            List<Runnable> callbacks = new ArrayList<>();
            if (i == -9) {
                abortError = DatabaseError.fromStatus(TRANSACTION_OVERRIDE_BY_SET);
            } else {
                Utilities.hardAssert(i == -25, "Unknown transaction abort reason: " + i);
                abortError = DatabaseError.fromCode(-25);
            }
            int lastSent = -1;
            for (int i2 = 0; i2 < queue.size(); i2++) {
                final TransactionData transaction = queue.get(i2);
                if (transaction.status != TransactionStatus.SENT_NEEDS_ABORT) {
                    if (transaction.status == TransactionStatus.SENT) {
                        lastSent = i2;
                        TransactionStatus unused = transaction.status = TransactionStatus.SENT_NEEDS_ABORT;
                        DatabaseError unused2 = transaction.abortReason = abortError;
                    } else {
                        removeEventCallback(new ValueEventRegistration(this, transaction.outstandingListener, QuerySpec.defaultQueryAtPath(transaction.path)));
                        if (i == -9) {
                            events.addAll(this.serverSyncTree.ackUserWrite(transaction.currentWriteId, true, false, this.serverClock));
                        } else {
                            Utilities.hardAssert(i == -25, "Unknown transaction abort reason: " + i);
                        }
                        callbacks.add(new Runnable() {
                            public void run() {
                                transaction.handler.onComplete(abortError, false, (DataSnapshot) null);
                            }
                        });
                    }
                }
            }
            if (lastSent == -1) {
                tree.setValue(null);
            } else {
                tree.setValue(queue.subList(0, lastSent + 1));
            }
            postEvents(events);
            for (Runnable r : callbacks) {
                postEvent(r);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public SyncTree getServerSyncTree() {
        return this.serverSyncTree;
    }

    /* access modifiers changed from: package-private */
    public SyncTree getInfoSyncTree() {
        return this.infoSyncTree;
    }

    /* access modifiers changed from: private */
    public static DatabaseError fromErrorCode(String optErrorCode, String optErrorReason) {
        if (optErrorCode != null) {
            return DatabaseError.fromStatus(optErrorCode, optErrorReason);
        }
        return null;
    }
}
