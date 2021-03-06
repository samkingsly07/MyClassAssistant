package com.google.firebase.database.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.UserWriteRecord;
import com.google.firebase.database.core.persistence.PersistenceStorageEngine;
import com.google.firebase.database.core.persistence.PruneForest;
import com.google.firebase.database.core.persistence.TrackedQuery;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.utilities.NodeSizeEstimator;
import com.google.firebase.database.core.utilities.Pair;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.core.view.QuerySpec;
import com.google.firebase.database.logging.LogWrapper;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import com.google.firebase.database.snapshot.NodeUtilities;
import com.google.firebase.database.util.JsonMapper;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class SqlPersistenceStorageEngine implements PersistenceStorageEngine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int CHILDREN_NODE_SPLIT_SIZE_THRESHOLD = 16384;
    private static final String CREATE_SERVER_CACHE = "CREATE TABLE serverCache (path TEXT PRIMARY KEY, value BLOB);";
    private static final String CREATE_TRACKED_KEYS = "CREATE TABLE trackedKeys (id INTEGER, key TEXT);";
    private static final String CREATE_TRACKED_QUERIES = "CREATE TABLE trackedQueries (id INTEGER PRIMARY KEY, path TEXT, queryParams TEXT, lastUse INTEGER, complete INTEGER, active INTEGER);";
    private static final String CREATE_WRITES = "CREATE TABLE writes (id INTEGER, path TEXT, type TEXT, part INTEGER, node BLOB, UNIQUE (id, part));";
    private static final String FIRST_PART_KEY = ".part-0000";
    private static final String LOGGER_COMPONENT = "Persistence";
    private static final String PART_KEY_FORMAT = ".part-%04d";
    private static final String PART_KEY_PREFIX = ".part-";
    private static final String PATH_COLUMN_NAME = "path";
    private static final String ROW_ID_COLUMN_NAME = "rowid";
    private static final int ROW_SPLIT_SIZE = 262144;
    private static final String SERVER_CACHE_TABLE = "serverCache";
    private static final String TRACKED_KEYS_ID_COLUMN_NAME = "id";
    private static final String TRACKED_KEYS_KEY_COLUMN_NAME = "key";
    private static final String TRACKED_KEYS_TABLE = "trackedKeys";
    private static final String TRACKED_QUERY_ACTIVE_COLUMN_NAME = "active";
    private static final String TRACKED_QUERY_COMPLETE_COLUMN_NAME = "complete";
    private static final String TRACKED_QUERY_ID_COLUMN_NAME = "id";
    private static final String TRACKED_QUERY_LAST_USE_COLUMN_NAME = "lastUse";
    private static final String TRACKED_QUERY_PARAMS_COLUMN_NAME = "queryParams";
    private static final String TRACKED_QUERY_PATH_COLUMN_NAME = "path";
    private static final String TRACKED_QUERY_TABLE = "trackedQueries";
    private static final Charset UTF8_CHARSET = Charset.forName("UTF-8");
    private static final String VALUE_COLUMN_NAME = "value";
    private static final String WRITES_TABLE = "writes";
    private static final String WRITE_ID_COLUMN_NAME = "id";
    private static final String WRITE_NODE_COLUMN_NAME = "node";
    private static final String WRITE_PART_COLUMN_NAME = "part";
    private static final String WRITE_TYPE_COLUMN_NAME = "type";
    private static final String WRITE_TYPE_MERGE = "m";
    private static final String WRITE_TYPE_OVERWRITE = "o";
    private final SQLiteDatabase database;
    private boolean insideTransaction;
    private final LogWrapper logger;
    private long transactionStart = 0;

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private static class PersistentCacheOpenHelper extends SQLiteOpenHelper {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final int DATABASE_VERSION = 2;

        static {
            Class<SqlPersistenceStorageEngine> cls = SqlPersistenceStorageEngine.class;
        }

        public PersistentCacheOpenHelper(Context context, String cacheId) {
            super(context, cacheId, (SQLiteDatabase.CursorFactory) null, 2);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SqlPersistenceStorageEngine.CREATE_SERVER_CACHE);
            db.execSQL(SqlPersistenceStorageEngine.CREATE_WRITES);
            db.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_QUERIES);
            db.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_KEYS);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            if (oldVersion <= 1) {
                dropTable(db, SqlPersistenceStorageEngine.SERVER_CACHE_TABLE);
                db.execSQL(SqlPersistenceStorageEngine.CREATE_SERVER_CACHE);
                dropTable(db, SqlPersistenceStorageEngine.TRACKED_QUERY_COMPLETE_COLUMN_NAME);
                db.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_KEYS);
                db.execSQL(SqlPersistenceStorageEngine.CREATE_TRACKED_QUERIES);
                return;
            }
            throw new AssertionError("We don't handle upgrading to " + newVersion);
        }

        private void dropTable(SQLiteDatabase db, String table) {
            db.execSQL("DROP TABLE IF EXISTS " + table);
        }
    }

    public SqlPersistenceStorageEngine(Context context, com.google.firebase.database.core.Context firebaseContext, String cacheId) {
        try {
            String sanitizedCacheId = URLEncoder.encode(cacheId, "utf-8");
            this.logger = firebaseContext.getLogger(LOGGER_COMPONENT);
            this.database = openDatabase(context, sanitizedCacheId);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveUserOverwrite(Path path, Node node, long writeId) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        saveWrite(path, writeId, WRITE_TYPE_OVERWRITE, serializeObject(node.getValue(true)));
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Persisted user overwrite in %dms", new Object[]{Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void saveUserMerge(Path path, CompoundWrite children, long writeId) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        saveWrite(path, writeId, WRITE_TYPE_MERGE, serializeObject(children.getValue(true)));
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Persisted user merge in %dms", new Object[]{Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void removeUserWrite(long writeId) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        int count = this.database.delete(WRITES_TABLE, "id = ?", new String[]{String.valueOf(writeId)});
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Deleted %d write(s) with writeId %d in %dms", new Object[]{Integer.valueOf(count), Long.valueOf(writeId), Long.valueOf(duration)}), new Object[0]);
        }
    }

    public List<UserWriteRecord> loadUserWrites() {
        byte[] serialized;
        UserWriteRecord record;
        String[] columns = {"id", "path", WRITE_TYPE_COLUMN_NAME, WRITE_PART_COLUMN_NAME, WRITE_NODE_COLUMN_NAME};
        long start = System.currentTimeMillis();
        Cursor cursor = this.database.query(WRITES_TABLE, columns, (String) null, (String[]) null, (String) null, (String) null, "id, part");
        List<UserWriteRecord> writes = new ArrayList<>();
        while (cursor.moveToNext()) {
            try {
                long writeId = cursor.getLong(0);
                Path path = new Path(cursor.getString(1));
                String type = cursor.getString(2);
                if (cursor.isNull(3)) {
                    serialized = cursor.getBlob(4);
                } else {
                    List<byte[]> parts = new ArrayList<>();
                    do {
                        parts.add(cursor.getBlob(4));
                        if (!cursor.moveToNext() || cursor.getLong(0) != writeId) {
                            cursor.moveToPrevious();
                            serialized = joinBytes(parts);
                        }
                        parts.add(cursor.getBlob(4));
                        break;
                    } while (cursor.getLong(0) != writeId);
                    cursor.moveToPrevious();
                    serialized = joinBytes(parts);
                }
                Object writeValue = JsonMapper.parseJsonValue(new String(serialized, UTF8_CHARSET));
                if (WRITE_TYPE_OVERWRITE.equals(type)) {
                    Object obj = writeValue;
                    record = new UserWriteRecord(writeId, path, NodeUtilities.NodeFromJSON(writeValue), true);
                } else {
                    Object writeValue2 = writeValue;
                    if (WRITE_TYPE_MERGE.equals(type)) {
                        record = new UserWriteRecord(writeId, path, CompoundWrite.fromValue((Map) writeValue2));
                    } else {
                        throw new IllegalStateException("Got invalid write type: " + type);
                    }
                }
                writes.add(record);
            } catch (IOException e) {
                throw new RuntimeException("Failed to load writes", e);
            } catch (Throwable th) {
                Throwable th2 = th;
                cursor.close();
                throw th2;
            }
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Loaded %d writes in %dms", new Object[]{Integer.valueOf(writes.size()), Long.valueOf(duration)}), new Object[0]);
        }
        cursor.close();
        return writes;
    }

    private void saveWrite(Path path, long writeId, String type, byte[] serializedWrite) {
        verifyInsideTransaction();
        int i = 0;
        this.database.delete(WRITES_TABLE, "id = ?", new String[]{String.valueOf(writeId)});
        if (serializedWrite.length >= 262144) {
            List<byte[]> parts = splitBytes(serializedWrite, 262144);
            while (true) {
                int i2 = i;
                if (i2 < parts.size()) {
                    ContentValues values = new ContentValues();
                    values.put("id", Long.valueOf(writeId));
                    values.put("path", pathToKey(path));
                    values.put(WRITE_TYPE_COLUMN_NAME, type);
                    values.put(WRITE_PART_COLUMN_NAME, Integer.valueOf(i2));
                    values.put(WRITE_NODE_COLUMN_NAME, parts.get(i2));
                    this.database.insertWithOnConflict(WRITES_TABLE, (String) null, values, 5);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else {
            ContentValues values2 = new ContentValues();
            values2.put("id", Long.valueOf(writeId));
            values2.put("path", pathToKey(path));
            values2.put(WRITE_TYPE_COLUMN_NAME, type);
            values2.put(WRITE_PART_COLUMN_NAME, (Integer) null);
            values2.put(WRITE_NODE_COLUMN_NAME, serializedWrite);
            this.database.insertWithOnConflict(WRITES_TABLE, (String) null, values2, 5);
        }
    }

    public Node serverCache(Path path) {
        return loadNested(path);
    }

    public void overwriteServerCache(Path path, Node node) {
        verifyInsideTransaction();
        updateServerCache(path, node, false);
    }

    public void mergeIntoServerCache(Path path, Node node) {
        verifyInsideTransaction();
        updateServerCache(path, node, true);
    }

    private void updateServerCache(Path path, Node node, boolean merge) {
        int savedRows;
        int removedRows;
        long start = System.currentTimeMillis();
        if (!merge) {
            removedRows = removeNested(SERVER_CACHE_TABLE, path);
            savedRows = saveNested(path, node);
        } else {
            removedRows = 0;
            savedRows = 0;
            Iterator it = node.iterator();
            while (it.hasNext()) {
                NamedNode child = (NamedNode) it.next();
                removedRows += removeNested(SERVER_CACHE_TABLE, path.child(child.getName()));
                savedRows += saveNested(path.child(child.getName()), child.getNode());
            }
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Persisted a total of %d rows and deleted %d rows for a set at %s in %dms", new Object[]{Integer.valueOf(savedRows), Integer.valueOf(removedRows), path.toString(), Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void mergeIntoServerCache(Path path, CompoundWrite children) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        int savedRows = 0;
        int removedRows = 0;
        Iterator<Map.Entry<Path, Node>> it = children.iterator();
        while (it.hasNext()) {
            Map.Entry<Path, Node> entry = it.next();
            removedRows += removeNested(SERVER_CACHE_TABLE, path.child(entry.getKey()));
            savedRows += saveNested(path.child(entry.getKey()), entry.getValue());
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Persisted a total of %d rows and deleted %d rows for a merge at %s in %dms", new Object[]{Integer.valueOf(savedRows), Integer.valueOf(removedRows), path.toString(), Long.valueOf(duration)}), new Object[0]);
        }
    }

    public long serverCacheEstimatedSizeInBytes() {
        Cursor cursor = this.database.rawQuery(String.format("SELECT sum(length(%s) + length(%s)) FROM %s", new Object[]{VALUE_COLUMN_NAME, "path", SERVER_CACHE_TABLE}), (String[]) null);
        try {
            if (cursor.moveToFirst()) {
                return cursor.getLong(0);
            }
            throw new IllegalStateException("Couldn't read database result!");
        } finally {
            cursor.close();
        }
    }

    public void saveTrackedQuery(TrackedQuery trackedQuery) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        ContentValues values = new ContentValues();
        values.put("id", Long.valueOf(trackedQuery.f86id));
        values.put("path", pathToKey(trackedQuery.querySpec.getPath()));
        values.put(TRACKED_QUERY_PARAMS_COLUMN_NAME, trackedQuery.querySpec.getParams().toJSON());
        values.put(TRACKED_QUERY_LAST_USE_COLUMN_NAME, Long.valueOf(trackedQuery.lastUse));
        values.put(TRACKED_QUERY_COMPLETE_COLUMN_NAME, Boolean.valueOf(trackedQuery.complete));
        values.put(TRACKED_QUERY_ACTIVE_COLUMN_NAME, Boolean.valueOf(trackedQuery.active));
        this.database.insertWithOnConflict(TRACKED_QUERY_TABLE, (String) null, values, 5);
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Saved new tracked query in %dms", new Object[]{Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void deleteTrackedQuery(long trackedQueryId) {
        verifyInsideTransaction();
        String trackedQueryIdStr = String.valueOf(trackedQueryId);
        this.database.delete(TRACKED_QUERY_TABLE, "id = ?", new String[]{trackedQueryIdStr});
        this.database.delete(TRACKED_KEYS_TABLE, "id = ?", new String[]{trackedQueryIdStr});
    }

    public List<TrackedQuery> loadTrackedQueries() {
        String[] columns = {"id", "path", TRACKED_QUERY_PARAMS_COLUMN_NAME, TRACKED_QUERY_LAST_USE_COLUMN_NAME, TRACKED_QUERY_COMPLETE_COLUMN_NAME, TRACKED_QUERY_ACTIVE_COLUMN_NAME};
        long start = System.currentTimeMillis();
        Cursor cursor = this.database.query(TRACKED_QUERY_TABLE, columns, (String) null, (String[]) null, (String) null, (String) null, "id");
        List<TrackedQuery> queries = new ArrayList<>();
        while (cursor.moveToNext()) {
            try {
                long id = cursor.getLong(0);
                Path path = new Path(cursor.getString(1));
                Map<String, Object> paramsObject = JsonMapper.parseJson(cursor.getString(2));
                Map<String, Object> map = paramsObject;
                queries.add(new TrackedQuery(id, QuerySpec.fromPathAndQueryObject(path, paramsObject), cursor.getLong(3), cursor.getInt(4) != 0, cursor.getInt(5) != 0));
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (Throwable th) {
                Throwable th2 = th;
                cursor.close();
                throw th2;
            }
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Loaded %d tracked queries in %dms", new Object[]{Integer.valueOf(queries.size()), Long.valueOf(duration)}), new Object[0]);
        }
        cursor.close();
        return queries;
    }

    public void resetPreviouslyActiveTrackedQueries(long lastUse) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        ContentValues values = new ContentValues();
        values.put(TRACKED_QUERY_ACTIVE_COLUMN_NAME, false);
        values.put(TRACKED_QUERY_LAST_USE_COLUMN_NAME, Long.valueOf(lastUse));
        this.database.updateWithOnConflict(TRACKED_QUERY_TABLE, values, "active = 1", new String[0], 5);
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Reset active tracked queries in %dms", new Object[]{Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void saveTrackedQueryKeys(long trackedQueryId, Set<ChildKey> keys) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        String trackedQueryIdStr = String.valueOf(trackedQueryId);
        this.database.delete(TRACKED_KEYS_TABLE, "id = ?", new String[]{trackedQueryIdStr});
        for (ChildKey addedKey : keys) {
            ContentValues values = new ContentValues();
            values.put("id", Long.valueOf(trackedQueryId));
            values.put(TRACKED_KEYS_KEY_COLUMN_NAME, addedKey.asString());
            this.database.insertWithOnConflict(TRACKED_KEYS_TABLE, (String) null, values, 5);
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Set %d tracked query keys for tracked query %d in %dms", new Object[]{Integer.valueOf(keys.size()), Long.valueOf(trackedQueryId), Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void updateTrackedQueryKeys(long trackedQueryId, Set<ChildKey> added, Set<ChildKey> removed) {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        String trackedQueryIdStr = String.valueOf(trackedQueryId);
        for (ChildKey removedKey : removed) {
            this.database.delete(TRACKED_KEYS_TABLE, "id = ? AND key = ?", new String[]{trackedQueryIdStr, removedKey.asString()});
        }
        for (ChildKey addedKey : added) {
            ContentValues values = new ContentValues();
            values.put("id", Long.valueOf(trackedQueryId));
            values.put(TRACKED_KEYS_KEY_COLUMN_NAME, addedKey.asString());
            this.database.insertWithOnConflict(TRACKED_KEYS_TABLE, (String) null, values, 5);
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Updated tracked query keys (%d added, %d removed) for tracked query id %d in %dms", new Object[]{Integer.valueOf(added.size()), Integer.valueOf(removed.size()), Long.valueOf(trackedQueryId), Long.valueOf(duration)}), new Object[0]);
        }
    }

    public Set<ChildKey> loadTrackedQueryKeys(long trackedQueryId) {
        return loadTrackedQueryKeys((Set<Long>) Collections.singleton(Long.valueOf(trackedQueryId)));
    }

    public Set<ChildKey> loadTrackedQueryKeys(Set<Long> trackedQueryIds) {
        String[] columns = {TRACKED_KEYS_KEY_COLUMN_NAME};
        long start = System.currentTimeMillis();
        Cursor cursor = this.database.query(true, TRACKED_KEYS_TABLE, columns, "id IN (" + commaSeparatedList(trackedQueryIds) + ")", (String[]) null, (String) null, (String) null, (String) null, (String) null);
        Set<ChildKey> keys = new HashSet<>();
        while (cursor.moveToNext()) {
            try {
                keys.add(ChildKey.fromString(cursor.getString(0)));
            } finally {
                cursor.close();
            }
        }
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Loaded %d tracked queries keys for tracked queries %s in %dms", new Object[]{Integer.valueOf(keys.size()), trackedQueryIds.toString(), Long.valueOf(duration)}), new Object[0]);
        }
        return keys;
    }

    public void pruneCache(Path root, PruneForest pruneForest) {
        ImmutableTree<Long> rowIdsToKeep;
        char c;
        Path path = root;
        PruneForest pruneForest2 = pruneForest;
        if (pruneForest.prunesAnything()) {
            verifyInsideTransaction();
            long start = System.currentTimeMillis();
            Cursor cursor = loadNestedQuery(path, new String[]{ROW_ID_COLUMN_NAME, "path"});
            ImmutableTree<Long> rowIdsToPrune = new ImmutableTree<>(null);
            ImmutableTree<Long> rowIdsToKeep2 = new ImmutableTree<>(null);
            ImmutableTree<Long> rowIdsToPrune2 = rowIdsToPrune;
            while (true) {
                rowIdsToKeep = rowIdsToKeep2;
                if (!cursor.moveToNext()) {
                    break;
                }
                long rowId = cursor.getLong(0);
                Path rowPath = new Path(cursor.getString(1));
                if (!path.contains(rowPath)) {
                    LogWrapper logWrapper = this.logger;
                    logWrapper.warn("We are pruning at " + path + " but we have data stored higher up at " + rowPath + ". Ignoring.");
                } else {
                    Path relativePath = Path.getRelative(path, rowPath);
                    if (pruneForest2.shouldPruneUnkeptDescendants(relativePath)) {
                        rowIdsToPrune2 = rowIdsToPrune2.set(relativePath, Long.valueOf(rowId));
                    } else if (pruneForest2.shouldKeep(relativePath)) {
                        rowIdsToKeep2 = rowIdsToKeep.set(relativePath, Long.valueOf(rowId));
                    } else {
                        LogWrapper logWrapper2 = this.logger;
                        logWrapper2.warn("We are pruning at " + path + " and have data at " + rowPath + " that isn't marked for pruning or keeping. Ignoring.");
                    }
                }
                rowIdsToKeep2 = rowIdsToKeep;
            }
            int prunedCount = 0;
            int resavedCount = 0;
            if (!rowIdsToPrune2.isEmpty()) {
                List<Pair<Path, Node>> rowsToResave = new ArrayList<>();
                c = 1;
                pruneTreeRecursive(path, Path.getEmptyPath(), rowIdsToPrune2, rowIdsToKeep, pruneForest2, rowsToResave);
                Collection<Long> rowIdsToDelete = rowIdsToPrune2.values();
                this.database.delete(SERVER_CACHE_TABLE, "rowid IN (" + commaSeparatedList(rowIdsToDelete) + ")", (String[]) null);
                List<Pair<Path, Node>> rowsToResave2 = rowsToResave;
                for (Pair<Path, Node> node : rowsToResave2) {
                    saveNested(path.child(node.getFirst()), node.getSecond());
                }
                prunedCount = rowIdsToDelete.size();
                resavedCount = rowsToResave2.size();
            } else {
                c = 1;
            }
            int prunedCount2 = prunedCount;
            int resavedCount2 = resavedCount;
            long duration = System.currentTimeMillis() - start;
            if (this.logger.logsDebug()) {
                LogWrapper logWrapper3 = this.logger;
                Object[] objArr = new Object[3];
                int i = prunedCount2;
                objArr[0] = Integer.valueOf(prunedCount2);
                objArr[c] = Integer.valueOf(resavedCount2);
                objArr[2] = Long.valueOf(duration);
                logWrapper3.debug(String.format("Pruned %d rows with %d nodes resaved in %dms", objArr), new Object[0]);
                return;
            }
        }
    }

    private void pruneTreeRecursive(Path pruneRoot, Path relativePath, ImmutableTree<Long> rowIdsToPrune, ImmutableTree<Long> rowIdsToKeep, PruneForest pruneForest, List<Pair<Path, Node>> rowsToResaveAccumulator) {
        final ImmutableTree<Long> immutableTree = rowIdsToKeep;
        PruneForest pruneForest2 = pruneForest;
        if (rowIdsToPrune.getValue() != null) {
            int nodesToResave = ((Integer) pruneForest2.foldKeptNodes(0, new ImmutableTree.TreeVisitor<Void, Integer>() {
                public Integer onNodeValue(Path keepPath, Void ignore, Integer nodesToResave) {
                    return Integer.valueOf(immutableTree.get(keepPath) == null ? nodesToResave.intValue() + 1 : nodesToResave.intValue());
                }
            })).intValue();
            if (nodesToResave > 0) {
                Path absolutePath = pruneRoot.child(relativePath);
                if (this.logger.logsDebug()) {
                    this.logger.debug(String.format("Need to rewrite %d nodes below path %s", new Object[]{Integer.valueOf(nodesToResave), absolutePath}), new Object[0]);
                }
                final ImmutableTree<Long> immutableTree2 = immutableTree;
                final List<Pair<Path, Node>> list = rowsToResaveAccumulator;
                final Path path = relativePath;
                final Node loadNested = loadNested(absolutePath);
                pruneForest2.foldKeptNodes(null, new ImmutableTree.TreeVisitor<Void, Void>() {
                    public Void onNodeValue(Path keepPath, Void ignore, Void ignore2) {
                        if (immutableTree2.get(keepPath) != null) {
                            return null;
                        }
                        list.add(new Pair(path.child(keepPath), loadNested.getChild(keepPath)));
                        return null;
                    }
                });
            }
        } else {
            Iterator<Map.Entry<ChildKey, ImmutableTree<Long>>> it = rowIdsToPrune.getChildren().iterator();
            while (it.hasNext()) {
                Map.Entry<ChildKey, ImmutableTree<Long>> entry = it.next();
                ChildKey childKey = entry.getKey();
                Path path2 = pruneRoot;
                pruneTreeRecursive(path2, relativePath.child(childKey), entry.getValue(), immutableTree.getChild(childKey), pruneForest2.child(entry.getKey()), rowsToResaveAccumulator);
            }
        }
        Path path3 = relativePath;
    }

    public void removeAllUserWrites() {
        verifyInsideTransaction();
        long start = System.currentTimeMillis();
        int count = this.database.delete(WRITES_TABLE, (String) null, (String[]) null);
        long duration = System.currentTimeMillis() - start;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Deleted %d (all) write(s) in %dms", new Object[]{Integer.valueOf(count), Long.valueOf(duration)}), new Object[0]);
        }
    }

    public void purgeCache() {
        verifyInsideTransaction();
        this.database.delete(SERVER_CACHE_TABLE, (String) null, (String[]) null);
        this.database.delete(WRITES_TABLE, (String) null, (String[]) null);
        this.database.delete(TRACKED_QUERY_TABLE, (String) null, (String[]) null);
        this.database.delete(TRACKED_KEYS_TABLE, (String) null, (String[]) null);
    }

    public void beginTransaction() {
        Utilities.hardAssert(!this.insideTransaction, "runInTransaction called when an existing transaction is already in progress.");
        if (this.logger.logsDebug()) {
            this.logger.debug("Starting transaction.", new Object[0]);
        }
        this.database.beginTransaction();
        this.insideTransaction = true;
        this.transactionStart = System.currentTimeMillis();
    }

    public void endTransaction() {
        this.database.endTransaction();
        this.insideTransaction = false;
        long elapsed = System.currentTimeMillis() - this.transactionStart;
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Transaction completed. Elapsed: %dms", new Object[]{Long.valueOf(elapsed)}), new Object[0]);
        }
    }

    public void setTransactionSuccessful() {
        this.database.setTransactionSuccessful();
    }

    public void close() {
        this.database.close();
    }

    private SQLiteDatabase openDatabase(Context context, String cacheId) {
        try {
            SQLiteDatabase database2 = new PersistentCacheOpenHelper(context, cacheId).getWritableDatabase();
            database2.rawQuery("PRAGMA locking_mode = EXCLUSIVE", (String[]) null).close();
            database2.beginTransaction();
            database2.endTransaction();
            return database2;
        } catch (SQLiteException e) {
            if (e instanceof SQLiteDatabaseLockedException) {
                throw new DatabaseException("Failed to gain exclusive lock to Firebase Database's offline persistence. This generally means you are using Firebase Database from multiple processes in your app. Keep in mind that multi-process Android apps execute the code in your Application class in all processes, so you may need to avoid initializing FirebaseDatabase in your Application class. If you are intentionally using Firebase Database from multiple processes, you can only enable offline persistence (i.e. call setPersistenceEnabled(true)) in one of them.", e);
            }
            throw e;
        }
    }

    private void verifyInsideTransaction() {
        Utilities.hardAssert(this.insideTransaction, "Transaction expected to already be in progress.");
    }

    private int saveNested(Path path, Node node) {
        long estimatedSize = NodeSizeEstimator.estimateSerializedNodeSize(node);
        if (!(node instanceof ChildrenNode) || estimatedSize <= PlaybackStateCompat.ACTION_PREPARE) {
            saveNode(path, node);
            return 1;
        }
        if (this.logger.logsDebug()) {
            this.logger.debug(String.format("Node estimated serialized size at path %s of %d bytes exceeds limit of %d bytes. Splitting up.", new Object[]{path, Long.valueOf(estimatedSize), 16384}), new Object[0]);
        }
        int sum = 0;
        Iterator it = node.iterator();
        while (it.hasNext()) {
            NamedNode child = (NamedNode) it.next();
            sum += saveNested(path.child(child.getName()), child.getNode());
        }
        if (!node.getPriority().isEmpty()) {
            saveNode(path.child(ChildKey.getPriorityKey()), node.getPriority());
            sum++;
        }
        saveNode(path, EmptyNode.Empty());
        return sum + 1;
    }

    private String partKey(Path path, int i) {
        return pathToKey(path) + String.format(PART_KEY_FORMAT, new Object[]{Integer.valueOf(i)});
    }

    private void saveNode(Path path, Node node) {
        byte[] serialized = serializeObject(node.getValue(true));
        if (serialized.length >= 262144) {
            List<byte[]> parts = splitBytes(serialized, 262144);
            int i = 0;
            if (this.logger.logsDebug()) {
                LogWrapper logWrapper = this.logger;
                logWrapper.debug("Saving huge leaf node with " + parts.size() + " parts.", new Object[0]);
            }
            while (true) {
                int i2 = i;
                if (i2 < parts.size()) {
                    ContentValues values = new ContentValues();
                    values.put("path", partKey(path, i2));
                    values.put(VALUE_COLUMN_NAME, parts.get(i2));
                    this.database.insertWithOnConflict(SERVER_CACHE_TABLE, (String) null, values, 5);
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else {
            ContentValues values2 = new ContentValues();
            values2.put("path", pathToKey(path));
            values2.put(VALUE_COLUMN_NAME, serialized);
            this.database.insertWithOnConflict(SERVER_CACHE_TABLE, (String) null, values2, 5);
        }
    }

    private Node loadNested(Path path) {
        Cursor cursor;
        Throwable th;
        Path savedPath;
        long queryDuration;
        Node savedNode;
        Path path2 = path;
        List<String> arrayList = new ArrayList<>();
        List<byte[]> payloads = new ArrayList<>();
        long queryStart = System.currentTimeMillis();
        Cursor cursor2 = loadNestedQuery(path2, new String[]{"path", VALUE_COLUMN_NAME});
        long queryDuration2 = System.currentTimeMillis() - queryStart;
        long loadingStart = System.currentTimeMillis();
        while (cursor2.moveToNext()) {
            try {
                try {
                    arrayList.add(cursor2.getString(0));
                    payloads.add(cursor2.getBlob(1));
                } catch (Throwable th2) {
                    th = th2;
                    ArrayList arrayList2 = arrayList;
                    cursor = cursor2;
                    long j = loadingStart;
                    long j2 = queryDuration2;
                }
            } catch (Throwable th3) {
                List<String> list = arrayList;
                cursor = cursor2;
                long j3 = loadingStart;
                long j4 = queryDuration2;
                th = th3;
                cursor.close();
                throw th;
            }
        }
        cursor2.close();
        long loadingDuration = System.currentTimeMillis() - loadingStart;
        long serializingStart = System.currentTimeMillis();
        Node node = EmptyNode.Empty();
        boolean sawDescendant = false;
        long j5 = loadingStart;
        HashMap hashMap = new HashMap();
        int i = 0;
        while (true) {
            Cursor cursor3 = cursor2;
            long loadingDuration2 = loadingDuration;
            if (i < payloads.size()) {
                if (((String) arrayList.get(i)).endsWith(FIRST_PART_KEY)) {
                    String pathString = (String) arrayList.get(i);
                    queryDuration = queryDuration2;
                    Path savedPath2 = new Path(pathString.substring(0, pathString.length() - FIRST_PART_KEY.length()));
                    int splitNodeRunLength = splitNodeRunLength(savedPath2, arrayList, i);
                    if (this.logger.logsDebug()) {
                        LogWrapper logWrapper = this.logger;
                        StringBuilder sb = new StringBuilder();
                        String str = pathString;
                        sb.append("Loading split node with ");
                        sb.append(splitNodeRunLength);
                        sb.append(" parts.");
                        savedPath = savedPath2;
                        logWrapper.debug(sb.toString(), new Object[0]);
                    } else {
                        savedPath = savedPath2;
                    }
                    savedNode = deserializeNode(joinBytes(payloads.subList(i, i + splitNodeRunLength)));
                    i = (i + splitNodeRunLength) - 1;
                } else {
                    queryDuration = queryDuration2;
                    savedNode = deserializeNode(payloads.get(i));
                    savedPath = new Path((String) arrayList.get(i));
                }
                Path savedPath3 = savedPath;
                if (savedPath3.getBack() != null && savedPath3.getBack().isPriorityChildName()) {
                    hashMap.put(savedPath3, savedNode);
                } else if (savedPath3.contains(path2)) {
                    Utilities.hardAssert(!sawDescendant, "Descendants of path must come after ancestors.");
                    node = savedNode.getChild(Path.getRelative(savedPath3, path2));
                } else if (path2.contains(savedPath3)) {
                    node = node.updateChild(Path.getRelative(path2, savedPath3), savedNode);
                    sawDescendant = true;
                } else {
                    throw new IllegalStateException(String.format("Loading an unrelated row with path %s for %s", new Object[]{savedPath3, path2}));
                }
                i++;
                cursor2 = cursor3;
                loadingDuration = loadingDuration2;
                queryDuration2 = queryDuration;
            } else {
                long queryDuration3 = queryDuration2;
                for (Map.Entry<Path, Node> entry : hashMap.entrySet()) {
                    node = node.updateChild(Path.getRelative(path2, entry.getKey()), entry.getValue());
                }
                long serializeDuration = System.currentTimeMillis() - serializingStart;
                HashMap hashMap2 = hashMap;
                long duration = System.currentTimeMillis() - queryStart;
                if (this.logger.logsDebug()) {
                    ArrayList arrayList3 = arrayList;
                    long queryDuration4 = queryDuration3;
                    long j6 = queryDuration4;
                    this.logger.debug(String.format("Loaded a total of %d rows for a total of %d nodes at %s in %dms (Query: %dms, Loading: %dms, Serializing: %dms)", new Object[]{Integer.valueOf(payloads.size()), Integer.valueOf(NodeSizeEstimator.nodeCount(node)), path2, Long.valueOf(duration), Long.valueOf(queryDuration4), Long.valueOf(loadingDuration2), Long.valueOf(serializeDuration)}), new Object[0]);
                } else {
                    List<String> pathStrings = arrayList;
                    long j7 = loadingDuration2;
                    long j8 = queryDuration3;
                }
                return node;
            }
        }
    }

    private int splitNodeRunLength(Path path, List<String> pathStrings, int startPosition) {
        int endPosition = startPosition + 1;
        String pathPrefix = pathToKey(path);
        if (!pathStrings.get(startPosition).startsWith(pathPrefix)) {
            throw new IllegalStateException("Extracting split nodes needs to start with path prefix");
        }
        while (endPosition < pathStrings.size() && pathStrings.get(endPosition).equals(partKey(path, endPosition - startPosition))) {
            endPosition++;
        }
        if (endPosition < pathStrings.size()) {
            if (pathStrings.get(endPosition).startsWith(pathPrefix + PART_KEY_PREFIX)) {
                throw new IllegalStateException("Run did not finish with all parts");
            }
        }
        return endPosition - startPosition;
    }

    private Cursor loadNestedQuery(Path path, String[] columns) {
        String pathPrefixStart = pathToKey(path);
        String pathPrefixEnd = pathPrefixStartToPrefixEnd(pathPrefixStart);
        String[] arguments = new String[(path.size() + 3)];
        String whereClause = buildAncestorWhereClause(path, arguments) + " OR (path > ? AND path < ?)";
        arguments[path.size() + 1] = pathPrefixStart;
        arguments[path.size() + 2] = pathPrefixEnd;
        return this.database.query(SERVER_CACHE_TABLE, columns, whereClause, arguments, (String) null, (String) null, "path");
    }

    private static String pathToKey(Path path) {
        if (path.isEmpty()) {
            return "/";
        }
        return path.toString() + "/";
    }

    private static String pathPrefixStartToPrefixEnd(String prefix) {
        return prefix.substring(0, prefix.length() - 1) + '0';
    }

    private static String buildAncestorWhereClause(Path path, String[] arguments) {
        int count = 0;
        StringBuilder whereClause = new StringBuilder("(");
        while (!path.isEmpty()) {
            whereClause.append("path");
            whereClause.append(" = ? OR ");
            arguments[count] = pathToKey(path);
            path = path.getParent();
            count++;
        }
        whereClause.append("path");
        whereClause.append(" = ?)");
        arguments[count] = pathToKey(Path.getEmptyPath());
        return whereClause.toString();
    }

    private int removeNested(String table, Path path) {
        String pathPrefixStart = pathToKey(path);
        String pathPrefixEnd = pathPrefixStartToPrefixEnd(pathPrefixStart);
        return this.database.delete(table, "path >= ? AND path < ?", new String[]{pathPrefixStart, pathPrefixEnd});
    }

    private static List<byte[]> splitBytes(byte[] bytes, int size) {
        int parts = ((bytes.length - 1) / size) + 1;
        List<byte[]> partList = new ArrayList<>(parts);
        for (int i = 0; i < parts; i++) {
            int length = Math.min(size, bytes.length - (i * size));
            byte[] part = new byte[length];
            System.arraycopy(bytes, i * size, part, 0, length);
            partList.add(part);
        }
        return partList;
    }

    private byte[] joinBytes(List<byte[]> payloads) {
        int totalSize = 0;
        for (byte[] payload : payloads) {
            totalSize += payload.length;
        }
        byte[] buffer = new byte[totalSize];
        int currentBytePosition = 0;
        for (byte[] payload2 : payloads) {
            System.arraycopy(payload2, 0, buffer, currentBytePosition, payload2.length);
            currentBytePosition += payload2.length;
        }
        return buffer;
    }

    private byte[] serializeObject(Object object) {
        try {
            return JsonMapper.serializeJsonValue(object).getBytes(UTF8_CHARSET);
        } catch (IOException e) {
            throw new RuntimeException("Could not serialize leaf node", e);
        }
    }

    private Node deserializeNode(byte[] value) {
        try {
            return NodeUtilities.NodeFromJSON(JsonMapper.parseJsonValue(new String(value, UTF8_CHARSET)));
        } catch (IOException e) {
            String stringValue = new String(value, UTF8_CHARSET);
            throw new RuntimeException("Could not deserialize node: " + stringValue, e);
        }
    }

    private String commaSeparatedList(Collection<Long> items) {
        StringBuilder list = new StringBuilder();
        boolean first = true;
        for (Long longValue : items) {
            long item = longValue.longValue();
            if (!first) {
                list.append(",");
            }
            first = false;
            list.append(item);
        }
        return list.toString();
    }
}
