package com.google.firebase.database.core.view;

import com.google.firebase.database.core.CompoundWrite;
import com.google.firebase.database.core.Path;
import com.google.firebase.database.core.WriteTreeRef;
import com.google.firebase.database.core.operation.AckUserWrite;
import com.google.firebase.database.core.operation.Merge;
import com.google.firebase.database.core.operation.Operation;
import com.google.firebase.database.core.operation.Overwrite;
import com.google.firebase.database.core.utilities.ImmutableTree;
import com.google.firebase.database.core.view.filter.ChildChangeAccumulator;
import com.google.firebase.database.core.view.filter.NodeFilter;
import com.google.firebase.database.snapshot.ChildKey;
import com.google.firebase.database.snapshot.ChildrenNode;
import com.google.firebase.database.snapshot.EmptyNode;
import com.google.firebase.database.snapshot.Index;
import com.google.firebase.database.snapshot.IndexedNode;
import com.google.firebase.database.snapshot.KeyIndex;
import com.google.firebase.database.snapshot.NamedNode;
import com.google.firebase.database.snapshot.Node;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class ViewProcessor {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static NodeFilter.CompleteChildSource NO_COMPLETE_SOURCE = new NodeFilter.CompleteChildSource() {
        public Node getCompleteChild(ChildKey childKey) {
            return null;
        }

        public NamedNode getChildAfterChild(Index index, NamedNode child, boolean reverse) {
            return null;
        }
    };
    private final NodeFilter filter;

    public ViewProcessor(NodeFilter filter2) {
        this.filter = filter2;
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    public static class ProcessorResult {
        public final List<Change> changes;
        public final ViewCache viewCache;

        public ProcessorResult(ViewCache viewCache2, List<Change> changes2) {
            this.viewCache = viewCache2;
            this.changes = changes2;
        }
    }

    public ProcessorResult applyOperation(ViewCache oldViewCache, Operation operation, WriteTreeRef writesCache, Node optCompleteCache) {
        ViewCache newViewCache;
        ChildChangeAccumulator accumulator = new ChildChangeAccumulator();
        switch (operation.getType()) {
            case Overwrite:
                Overwrite overwrite = (Overwrite) operation;
                if (!overwrite.getSource().isFromUser()) {
                    newViewCache = applyServerOverwrite(oldViewCache, overwrite.getPath(), overwrite.getSnapshot(), writesCache, optCompleteCache, overwrite.getSource().isTagged() || (oldViewCache.getServerCache().isFiltered() && !overwrite.getPath().isEmpty()), accumulator);
                    break;
                } else {
                    newViewCache = applyUserOverwrite(oldViewCache, overwrite.getPath(), overwrite.getSnapshot(), writesCache, optCompleteCache, accumulator);
                    break;
                }
                break;
            case Merge:
                Merge merge = (Merge) operation;
                if (!merge.getSource().isFromUser()) {
                    newViewCache = applyServerMerge(oldViewCache, merge.getPath(), merge.getChildren(), writesCache, optCompleteCache, merge.getSource().isTagged() || oldViewCache.getServerCache().isFiltered(), accumulator);
                    break;
                } else {
                    newViewCache = applyUserMerge(oldViewCache, merge.getPath(), merge.getChildren(), writesCache, optCompleteCache, accumulator);
                    break;
                }
                break;
            case AckUserWrite:
                AckUserWrite ackUserWrite = (AckUserWrite) operation;
                if (ackUserWrite.isRevert()) {
                    newViewCache = revertUserWrite(oldViewCache, ackUserWrite.getPath(), writesCache, optCompleteCache, accumulator);
                    break;
                } else {
                    newViewCache = ackUserWrite(oldViewCache, ackUserWrite.getPath(), ackUserWrite.getAffectedTree(), writesCache, optCompleteCache, accumulator);
                    break;
                }
            case ListenComplete:
                newViewCache = listenComplete(oldViewCache, operation.getPath(), writesCache, optCompleteCache, accumulator);
                break;
            default:
                throw new AssertionError("Unknown operation: " + operation.getType());
        }
        List<Change> changes = new ArrayList<>(accumulator.getChanges());
        maybeAddValueEvent(oldViewCache, newViewCache, changes);
        return new ProcessorResult(newViewCache, changes);
    }

    private void maybeAddValueEvent(ViewCache oldViewCache, ViewCache newViewCache, List<Change> accumulator) {
        CacheNode eventSnap = newViewCache.getEventCache();
        if (eventSnap.isFullyInitialized()) {
            boolean isLeafOrEmpty = eventSnap.getNode().isLeafNode() || eventSnap.getNode().isEmpty();
            if (!accumulator.isEmpty() || !oldViewCache.getEventCache().isFullyInitialized() || ((isLeafOrEmpty && !eventSnap.getNode().equals(oldViewCache.getCompleteEventSnap())) || !eventSnap.getNode().getPriority().equals(oldViewCache.getCompleteEventSnap().getPriority()))) {
                accumulator.add(Change.valueChange(eventSnap.getIndexedNode()));
            }
        }
    }

    private ViewCache generateEventCacheAfterServerEvent(ViewCache viewCache, Path changePath, WriteTreeRef writesCache, NodeFilter.CompleteChildSource source, ChildChangeAccumulator accumulator) {
        IndexedNode newEventCache;
        Node serverNode;
        Node newEventChild;
        IndexedNode newEventCache2;
        Node serverCache;
        ViewCache viewCache2 = viewCache;
        Path path = changePath;
        WriteTreeRef writeTreeRef = writesCache;
        CacheNode oldEventSnap = viewCache.getEventCache();
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache2;
        }
        if (changePath.isEmpty()) {
            if (viewCache.getServerCache().isFiltered()) {
                Node serverCache2 = viewCache.getCompleteServerSnap();
                serverCache = writeTreeRef.calcCompleteEventChildren(serverCache2 instanceof ChildrenNode ? serverCache2 : EmptyNode.Empty());
            } else {
                serverCache = writeTreeRef.calcCompleteEventCache(viewCache.getCompleteServerSnap());
            }
            newEventCache = this.filter.updateFullNode(viewCache.getEventCache().getIndexedNode(), IndexedNode.from(serverCache, this.filter.getIndex()), accumulator);
        } else {
            ChildChangeAccumulator childChangeAccumulator = accumulator;
            ChildKey childKey = changePath.getFront();
            if (childKey.isPriorityChildName()) {
                Node updatedPriority = writeTreeRef.calcEventCacheAfterServerOverwrite(path, oldEventSnap.getNode(), viewCache.getServerCache().getNode());
                if (updatedPriority != null) {
                    newEventCache2 = this.filter.updatePriority(oldEventSnap.getIndexedNode(), updatedPriority);
                } else {
                    newEventCache2 = oldEventSnap.getIndexedNode();
                }
                newEventCache = newEventCache2;
            } else {
                Path childChangePath = changePath.popFront();
                if (oldEventSnap.isCompleteForChild(childKey)) {
                    Node eventChildUpdate = writeTreeRef.calcEventCacheAfterServerOverwrite(path, oldEventSnap.getNode(), viewCache.getServerCache().getNode());
                    if (eventChildUpdate != null) {
                        newEventChild = oldEventSnap.getNode().getImmediateChild(childKey).updateChild(childChangePath, eventChildUpdate);
                    } else {
                        newEventChild = oldEventSnap.getNode().getImmediateChild(childKey);
                    }
                    serverNode = newEventChild;
                } else {
                    serverNode = writeTreeRef.calcCompleteChild(childKey, viewCache.getServerCache());
                }
                newEventCache = serverNode != null ? this.filter.updateChild(oldEventSnap.getIndexedNode(), childKey, serverNode, childChangePath, source, accumulator) : oldEventSnap.getIndexedNode();
            }
        }
        return viewCache2.updateEventSnap(newEventCache, oldEventSnap.isFullyInitialized() || changePath.isEmpty(), this.filter.filtersNodes());
    }

    private ViewCache applyServerOverwrite(ViewCache oldViewCache, Path changePath, Node changedSnap, WriteTreeRef writesCache, Node optCompleteCache, boolean filterServerNode, ChildChangeAccumulator accumulator) {
        Path path;
        IndexedNode newServerCache;
        ViewCache viewCache = oldViewCache;
        Node node = changedSnap;
        CacheNode oldServerSnap = oldViewCache.getServerCache();
        NodeFilter serverFilter = filterServerNode ? this.filter : this.filter.getIndexedFilter();
        boolean z = true;
        if (changePath.isEmpty()) {
            newServerCache = serverFilter.updateFullNode(oldServerSnap.getIndexedNode(), IndexedNode.from(node, serverFilter.getIndex()), (ChildChangeAccumulator) null);
        } else if (!serverFilter.filtersNodes() || oldServerSnap.isFiltered()) {
            ChildKey childKey = changePath.getFront();
            path = changePath;
            if (!oldServerSnap.isCompleteForPath(path) && changePath.size() > 1) {
                return viewCache;
            }
            Path childChangePath = changePath.popFront();
            Node newChildNode = oldServerSnap.getNode().getImmediateChild(childKey).updateChild(childChangePath, node);
            if (childKey.isPriorityChildName()) {
                newServerCache = serverFilter.updatePriority(oldServerSnap.getIndexedNode(), newChildNode);
            } else {
                Node node2 = newChildNode;
                newServerCache = serverFilter.updateChild(oldServerSnap.getIndexedNode(), childKey, newChildNode, childChangePath, NO_COMPLETE_SOURCE, (ChildChangeAccumulator) null);
            }
            IndexedNode newServerCache2 = newServerCache;
            if (!oldServerSnap.isFullyInitialized() && !changePath.isEmpty()) {
                z = false;
            }
            ViewCache newViewCache = viewCache.updateServerSnap(newServerCache2, z, serverFilter.filtersNodes());
            WriteTreeRef writeTreeRef = writesCache;
            NodeFilter nodeFilter = serverFilter;
            return generateEventCacheAfterServerEvent(newViewCache, path, writeTreeRef, new WriteTreeCompleteChildSource(writeTreeRef, newViewCache, optCompleteCache), accumulator);
        } else {
            ChildKey childKey2 = changePath.getFront();
            newServerCache = serverFilter.updateFullNode(oldServerSnap.getIndexedNode(), oldServerSnap.getIndexedNode().updateChild(childKey2, oldServerSnap.getNode().getImmediateChild(childKey2).updateChild(changePath.popFront(), node)), (ChildChangeAccumulator) null);
        }
        path = changePath;
        IndexedNode newServerCache22 = newServerCache;
        z = false;
        ViewCache newViewCache2 = viewCache.updateServerSnap(newServerCache22, z, serverFilter.filtersNodes());
        WriteTreeRef writeTreeRef2 = writesCache;
        NodeFilter nodeFilter2 = serverFilter;
        return generateEventCacheAfterServerEvent(newViewCache2, path, writeTreeRef2, new WriteTreeCompleteChildSource(writeTreeRef2, newViewCache2, optCompleteCache), accumulator);
    }

    private ViewCache applyUserOverwrite(ViewCache oldViewCache, Path changePath, Node changedSnap, WriteTreeRef writesCache, Node optCompleteCache, ChildChangeAccumulator accumulator) {
        Node childNode;
        ViewCache newViewCache = oldViewCache;
        Node node = changedSnap;
        CacheNode oldEventSnap = oldViewCache.getEventCache();
        WriteTreeCompleteChildSource writeTreeCompleteChildSource = new WriteTreeCompleteChildSource(writesCache, newViewCache, optCompleteCache);
        if (changePath.isEmpty()) {
            return newViewCache.updateEventSnap(this.filter.updateFullNode(oldViewCache.getEventCache().getIndexedNode(), IndexedNode.from(node, this.filter.getIndex()), accumulator), true, this.filter.filtersNodes());
        }
        ChildChangeAccumulator childChangeAccumulator = accumulator;
        ChildKey childKey = changePath.getFront();
        if (childKey.isPriorityChildName()) {
            return newViewCache.updateEventSnap(this.filter.updatePriority(oldViewCache.getEventCache().getIndexedNode(), node), oldEventSnap.isFullyInitialized(), oldEventSnap.isFiltered());
        }
        Path childChangePath = changePath.popFront();
        Node oldChild = oldEventSnap.getNode().getImmediateChild(childKey);
        if (childChangePath.isEmpty()) {
            childNode = node;
        } else {
            childNode = writeTreeCompleteChildSource.getCompleteChild(childKey);
            if (childNode == null) {
                childNode = EmptyNode.Empty();
            } else if (!childChangePath.getBack().isPriorityChildName() || !childNode.getChild(childChangePath.getParent()).isEmpty()) {
                childNode = childNode.updateChild(childChangePath, node);
            } else {
                Node node2 = childNode;
            }
        }
        Node newChild = childNode;
        if (!oldChild.equals(newChild)) {
            Node node3 = newChild;
            Node node4 = oldChild;
            Path path = childChangePath;
            return newViewCache.updateEventSnap(this.filter.updateChild(oldEventSnap.getIndexedNode(), childKey, newChild, childChangePath, writeTreeCompleteChildSource, childChangeAccumulator), oldEventSnap.isFullyInitialized(), this.filter.filtersNodes());
        }
        Node node5 = oldChild;
        Path path2 = childChangePath;
        return newViewCache;
    }

    private static boolean cacheHasChild(ViewCache viewCache, ChildKey childKey) {
        return viewCache.getEventCache().isCompleteForChild(childKey);
    }

    private ViewCache applyUserMerge(ViewCache viewCache, Path path, CompoundWrite changedChildren, WriteTreeRef writesCache, Node serverCache, ChildChangeAccumulator accumulator) {
        ViewCache viewCache2 = viewCache;
        Path path2 = path;
        ViewCache currentViewCache = viewCache2;
        Iterator<Map.Entry<Path, Node>> it = changedChildren.iterator();
        while (it.hasNext()) {
            Map.Entry<Path, Node> entry = it.next();
            Path writePath = path2.child(entry.getKey());
            if (cacheHasChild(viewCache2, writePath.getFront())) {
                currentViewCache = applyUserOverwrite(currentViewCache, writePath, entry.getValue(), writesCache, serverCache, accumulator);
            }
        }
        Iterator<Map.Entry<Path, Node>> it2 = changedChildren.iterator();
        while (it2.hasNext()) {
            Map.Entry<Path, Node> entry2 = it2.next();
            Path writePath2 = path2.child(entry2.getKey());
            if (!cacheHasChild(viewCache2, writePath2.getFront())) {
                currentViewCache = applyUserOverwrite(currentViewCache, writePath2, entry2.getValue(), writesCache, serverCache, accumulator);
            }
        }
        return currentViewCache;
    }

    private ViewCache applyServerMerge(ViewCache viewCache, Path path, CompoundWrite changedChildren, WriteTreeRef writesCache, Node serverCache, boolean filterServerNode, ChildChangeAccumulator accumulator) {
        CompoundWrite actualMerge;
        if (viewCache.getServerCache().getNode().isEmpty() && !viewCache.getServerCache().isFullyInitialized()) {
            return viewCache;
        }
        ViewCache curViewCache = viewCache;
        if (path.isEmpty()) {
            actualMerge = changedChildren;
            Path path2 = path;
            CompoundWrite compoundWrite = changedChildren;
        } else {
            actualMerge = CompoundWrite.emptyWrite().addWrites(path, changedChildren);
        }
        Node serverNode = viewCache.getServerCache().getNode();
        Map<ChildKey, CompoundWrite> childCompoundWrites = actualMerge.childCompoundWrites();
        for (Map.Entry<ChildKey, CompoundWrite> childMerge : childCompoundWrites.entrySet()) {
            ChildKey childKey = childMerge.getKey();
            if (serverNode.hasChild(childKey)) {
                Node serverChild = serverNode.getImmediateChild(childKey);
                Node node = serverChild;
                ChildKey childKey2 = childKey;
                Map.Entry<ChildKey, CompoundWrite> entry = childMerge;
                curViewCache = applyServerOverwrite(curViewCache, new Path(childKey), childMerge.getValue().apply(serverChild), writesCache, serverCache, filterServerNode, accumulator);
            }
        }
        for (Map.Entry<ChildKey, CompoundWrite> childMerge2 : childCompoundWrites.entrySet()) {
            ChildKey childKey3 = childMerge2.getKey();
            CompoundWrite childCompoundWrite = childMerge2.getValue();
            boolean isUnknownDeepMerge = !viewCache.getServerCache().isCompleteForChild(childKey3) && childCompoundWrite.rootWrite() == null;
            if (!serverNode.hasChild(childKey3) && !isUnknownDeepMerge) {
                Node serverChild2 = serverNode.getImmediateChild(childKey3);
                Node node2 = serverChild2;
                CompoundWrite compoundWrite2 = childCompoundWrite;
                ChildKey childKey4 = childKey3;
                curViewCache = applyServerOverwrite(curViewCache, new Path(childKey3), childMerge2.getValue().apply(serverChild2), writesCache, serverCache, filterServerNode, accumulator);
            }
        }
        return curViewCache;
    }

    private ViewCache ackUserWrite(ViewCache viewCache, Path ackPath, ImmutableTree<Boolean> affectedTree, WriteTreeRef writesCache, Node optCompleteCache, ChildChangeAccumulator accumulator) {
        Path path = ackPath;
        WriteTreeRef writeTreeRef = writesCache;
        if (writeTreeRef.shadowingWrite(path) != null) {
            return viewCache;
        }
        boolean filterServerNode = viewCache.getServerCache().isFiltered();
        CacheNode serverCache = viewCache.getServerCache();
        if (affectedTree.getValue() == null) {
            CompoundWrite changedChildren = CompoundWrite.emptyWrite();
            Iterator<Map.Entry<Path, Boolean>> it = affectedTree.iterator();
            CompoundWrite changedChildren2 = changedChildren;
            while (it.hasNext()) {
                Path mergePath = it.next().getKey();
                Path serverCachePath = path.child(mergePath);
                if (serverCache.isCompleteForPath(serverCachePath)) {
                    changedChildren2 = changedChildren2.addWrite(mergePath, serverCache.getNode().getChild(serverCachePath));
                }
            }
            return applyServerMerge(viewCache, path, changedChildren2, writeTreeRef, optCompleteCache, filterServerNode, accumulator);
        } else if ((path.isEmpty() && serverCache.isFullyInitialized()) || serverCache.isCompleteForPath(path)) {
            return applyServerOverwrite(viewCache, path, serverCache.getNode().getChild(path), writeTreeRef, optCompleteCache, filterServerNode, accumulator);
        } else if (!path.isEmpty()) {
            return viewCache;
        } else {
            CompoundWrite changedChildren3 = CompoundWrite.emptyWrite();
            CompoundWrite changedChildren4 = changedChildren3;
            for (NamedNode child : serverCache.getNode()) {
                changedChildren4 = changedChildren4.addWrite(child.getName(), child.getNode());
            }
            return applyServerMerge(viewCache, path, changedChildren4, writeTreeRef, optCompleteCache, filterServerNode, accumulator);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0113  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.database.core.view.ViewCache revertUserWrite(com.google.firebase.database.core.view.ViewCache r18, com.google.firebase.database.core.Path r19, com.google.firebase.database.core.WriteTreeRef r20, com.google.firebase.database.snapshot.Node r21, com.google.firebase.database.core.view.filter.ChildChangeAccumulator r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            r15 = r22
            r14 = r19
            com.google.firebase.database.snapshot.Node r3 = r2.shadowingWrite(r14)
            if (r3 == 0) goto L_0x0011
            return r1
        L_0x0011:
            com.google.firebase.database.core.view.ViewProcessor$WriteTreeCompleteChildSource r8 = new com.google.firebase.database.core.view.ViewProcessor$WriteTreeCompleteChildSource
            r13 = r21
            r8.<init>(r2, r1, r13)
            com.google.firebase.database.core.view.CacheNode r3 = r18.getEventCache()
            com.google.firebase.database.snapshot.IndexedNode r12 = r3.getIndexedNode()
            boolean r3 = r19.isEmpty()
            if (r3 != 0) goto L_0x00c9
            com.google.firebase.database.snapshot.ChildKey r3 = r19.getFront()
            boolean r3 = r3.isPriorityChildName()
            if (r3 == 0) goto L_0x0034
            r6 = r12
            r3 = r15
            goto L_0x00cb
        L_0x0034:
            com.google.firebase.database.snapshot.ChildKey r11 = r19.getFront()
            com.google.firebase.database.core.view.CacheNode r3 = r18.getServerCache()
            com.google.firebase.database.snapshot.Node r3 = r2.calcCompleteChild(r11, r3)
            if (r3 != 0) goto L_0x0054
            com.google.firebase.database.core.view.CacheNode r4 = r18.getServerCache()
            boolean r4 = r4.isCompleteForChild(r11)
            if (r4 == 0) goto L_0x0054
            com.google.firebase.database.snapshot.Node r4 = r12.getNode()
            com.google.firebase.database.snapshot.Node r3 = r4.getImmediateChild(r11)
        L_0x0054:
            r16 = r3
            if (r16 == 0) goto L_0x006b
            com.google.firebase.database.core.view.filter.NodeFilter r3 = r0.filter
            com.google.firebase.database.core.Path r7 = r19.popFront()
            r4 = r12
            r5 = r11
            r6 = r16
            r9 = r15
            com.google.firebase.database.snapshot.IndexedNode r3 = r3.updateChild(r4, r5, r6, r7, r8, r9)
            r6 = r12
            r12 = r3
            r3 = r15
            goto L_0x0095
        L_0x006b:
            if (r16 != 0) goto L_0x0091
            com.google.firebase.database.core.view.CacheNode r3 = r18.getEventCache()
            com.google.firebase.database.snapshot.Node r3 = r3.getNode()
            boolean r3 = r3.hasChild(r11)
            if (r3 == 0) goto L_0x0091
            com.google.firebase.database.core.view.filter.NodeFilter r9 = r0.filter
            com.google.firebase.database.snapshot.EmptyNode r3 = com.google.firebase.database.snapshot.EmptyNode.Empty()
            com.google.firebase.database.core.Path r4 = r19.popFront()
            r10 = r12
            r5 = r11
            r6 = r12
            r12 = r3
            r13 = r4
            r14 = r8
            r3 = r15
            com.google.firebase.database.snapshot.IndexedNode r12 = r9.updateChild(r10, r11, r12, r13, r14, r15)
            goto L_0x0095
        L_0x0091:
            r5 = r11
            r6 = r12
            r3 = r15
            r12 = r6
        L_0x0095:
            r4 = r12
            com.google.firebase.database.snapshot.Node r7 = r4.getNode()
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x00fb
            com.google.firebase.database.core.view.CacheNode r7 = r18.getServerCache()
            boolean r7 = r7.isFullyInitialized()
            if (r7 == 0) goto L_0x00fb
            com.google.firebase.database.snapshot.Node r7 = r18.getCompleteServerSnap()
            com.google.firebase.database.snapshot.Node r7 = r2.calcCompleteEventCache(r7)
            boolean r9 = r7.isLeafNode()
            if (r9 == 0) goto L_0x00fb
            com.google.firebase.database.core.view.filter.NodeFilter r9 = r0.filter
            com.google.firebase.database.snapshot.Index r9 = r9.getIndex()
            com.google.firebase.database.snapshot.IndexedNode r9 = com.google.firebase.database.snapshot.IndexedNode.from(r7, r9)
            com.google.firebase.database.core.view.filter.NodeFilter r10 = r0.filter
            com.google.firebase.database.snapshot.IndexedNode r4 = r10.updateFullNode(r4, r9, r3)
            goto L_0x00fb
        L_0x00c9:
            r6 = r12
            r3 = r15
        L_0x00cb:
            com.google.firebase.database.core.view.CacheNode r4 = r18.getServerCache()
            boolean r4 = r4.isFullyInitialized()
            if (r4 == 0) goto L_0x00de
            com.google.firebase.database.snapshot.Node r4 = r18.getCompleteServerSnap()
            com.google.firebase.database.snapshot.Node r4 = r2.calcCompleteEventCache(r4)
            goto L_0x00ea
        L_0x00de:
            com.google.firebase.database.core.view.CacheNode r4 = r18.getServerCache()
            com.google.firebase.database.snapshot.Node r4 = r4.getNode()
            com.google.firebase.database.snapshot.Node r4 = r2.calcCompleteEventChildren(r4)
        L_0x00ea:
            com.google.firebase.database.core.view.filter.NodeFilter r5 = r0.filter
            com.google.firebase.database.snapshot.Index r5 = r5.getIndex()
            com.google.firebase.database.snapshot.IndexedNode r5 = com.google.firebase.database.snapshot.IndexedNode.from(r4, r5)
            com.google.firebase.database.core.view.filter.NodeFilter r7 = r0.filter
            com.google.firebase.database.snapshot.IndexedNode r4 = r7.updateFullNode(r6, r5, r3)
        L_0x00fb:
            com.google.firebase.database.core.view.CacheNode r5 = r18.getServerCache()
            boolean r5 = r5.isFullyInitialized()
            if (r5 != 0) goto L_0x0113
            com.google.firebase.database.core.Path r5 = com.google.firebase.database.core.Path.getEmptyPath()
            com.google.firebase.database.snapshot.Node r5 = r2.shadowingWrite(r5)
            if (r5 == 0) goto L_0x0111
            goto L_0x0113
        L_0x0111:
            r5 = 0
            goto L_0x0114
        L_0x0113:
            r5 = 1
        L_0x0114:
            com.google.firebase.database.core.view.filter.NodeFilter r7 = r0.filter
            boolean r7 = r7.filtersNodes()
            com.google.firebase.database.core.view.ViewCache r7 = r1.updateEventSnap(r4, r5, r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.view.ViewProcessor.revertUserWrite(com.google.firebase.database.core.view.ViewCache, com.google.firebase.database.core.Path, com.google.firebase.database.core.WriteTreeRef, com.google.firebase.database.snapshot.Node, com.google.firebase.database.core.view.filter.ChildChangeAccumulator):com.google.firebase.database.core.view.ViewCache");
    }

    private ViewCache listenComplete(ViewCache viewCache, Path path, WriteTreeRef writesCache, Node serverCache, ChildChangeAccumulator accumulator) {
        CacheNode oldServerNode = viewCache.getServerCache();
        return generateEventCacheAfterServerEvent(viewCache.updateServerSnap(oldServerNode.getIndexedNode(), oldServerNode.isFullyInitialized() || path.isEmpty(), oldServerNode.isFiltered()), path, writesCache, NO_COMPLETE_SOURCE, accumulator);
    }

    /* compiled from: com.google.firebase:firebase-database@@16.0.4 */
    private static class WriteTreeCompleteChildSource implements NodeFilter.CompleteChildSource {
        private final Node optCompleteServerCache;
        private final ViewCache viewCache;
        private final WriteTreeRef writes;

        public WriteTreeCompleteChildSource(WriteTreeRef writes2, ViewCache viewCache2, Node optCompleteServerCache2) {
            this.writes = writes2;
            this.viewCache = viewCache2;
            this.optCompleteServerCache = optCompleteServerCache2;
        }

        public Node getCompleteChild(ChildKey childKey) {
            CacheNode serverNode;
            CacheNode node = this.viewCache.getEventCache();
            if (node.isCompleteForChild(childKey)) {
                return node.getNode().getImmediateChild(childKey);
            }
            if (this.optCompleteServerCache != null) {
                serverNode = new CacheNode(IndexedNode.from(this.optCompleteServerCache, KeyIndex.getInstance()), true, false);
            } else {
                serverNode = this.viewCache.getServerCache();
            }
            return this.writes.calcCompleteChild(childKey, serverNode);
        }

        public NamedNode getChildAfterChild(Index index, NamedNode child, boolean reverse) {
            Node completeServerData;
            if (this.optCompleteServerCache != null) {
                completeServerData = this.optCompleteServerCache;
            } else {
                completeServerData = this.viewCache.getCompleteServerSnap();
            }
            return this.writes.calcNextNodeAfterPost(completeServerData, child, reverse, index);
        }
    }
}
