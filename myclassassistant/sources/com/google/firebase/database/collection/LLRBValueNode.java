package com.google.firebase.database.collection;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.database.collection.LLRBNode;
import java.util.Comparator;

@KeepForSdk
public abstract class LLRBValueNode<K, V> implements LLRBNode<K, V> {
    private final V value;
    private final K zzq;
    private LLRBNode<K, V> zzr;
    private final LLRBNode<K, V> zzs;

    LLRBValueNode(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        this.zzq = k;
        this.value = v;
        this.zzr = lLRBNode == null ? LLRBEmptyNode.getInstance() : lLRBNode;
        this.zzs = lLRBNode2 == null ? LLRBEmptyNode.getInstance() : lLRBNode2;
    }

    private static LLRBNode.Color zzb(LLRBNode lLRBNode) {
        return lLRBNode.isRed() ? LLRBNode.Color.BLACK : LLRBNode.Color.RED;
    }

    private final LLRBNode<K, V> zzb() {
        if (this.zzr.isEmpty()) {
            return LLRBEmptyNode.getInstance();
        }
        LLRBValueNode zzc = (getLeft().isRed() || getLeft().getLeft().isRed()) ? this : zzc();
        return zzc.zza((Object) null, (Object) null, ((LLRBValueNode) zzc.zzr).zzb(), (LLRBNode) null).zzd();
    }

    private final LLRBValueNode<K, V> zzc() {
        LLRBValueNode<K, V> zzg = zzg();
        return zzg.getRight().getLeft().isRed() ? zzg.zza((K) null, (V) null, (LLRBNode<K, V>) null, ((LLRBValueNode) zzg.getRight()).zzf()).zze().zzg() : zzg;
    }

    private final LLRBValueNode<K, V> zzd() {
        LLRBValueNode zze = (!this.zzs.isRed() || this.zzr.isRed()) ? this : zze();
        if (zze.zzr.isRed() && ((LLRBValueNode) zze.zzr).zzr.isRed()) {
            zze = zze.zzf();
        }
        return (!zze.zzr.isRed() || !zze.zzs.isRed()) ? zze : zze.zzg();
    }

    private final LLRBValueNode<K, V> zze() {
        LLRBNode.Color color = LLRBNode.Color.RED;
        LLRBNode<K, V> lLRBNode = ((LLRBValueNode) this.zzs).zzr;
        return (LLRBValueNode) this.zzs.copy(null, null, zza(), (LLRBValueNode) copy((Object) null, (Object) null, color, (LLRBNode) null, (LLRBNode) lLRBNode), (LLRBValueNode) null);
    }

    private final LLRBValueNode<K, V> zzf() {
        LLRBNode.Color color = LLRBNode.Color.RED;
        LLRBNode<K, V> lLRBNode = ((LLRBValueNode) this.zzr).zzs;
        return (LLRBValueNode) this.zzr.copy(null, null, zza(), (LLRBNode) null, (LLRBValueNode) copy((Object) null, (Object) null, color, (LLRBNode) lLRBNode, (LLRBNode) null));
    }

    private final LLRBValueNode<K, V> zzg() {
        return (LLRBValueNode) copy((Object) null, (Object) null, zzb(this), (LLRBNode) this.zzr.copy(null, null, zzb(this.zzr), (LLRBNode) null, (LLRBNode) null), (LLRBNode) this.zzs.copy(null, null, zzb(this.zzs), (LLRBNode) null, (LLRBNode) null));
    }

    @KeepForSdk
    public LLRBValueNode<K, V> copy(K k, V v, LLRBNode.Color color, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2) {
        if (k == null) {
            k = this.zzq;
        }
        if (v == null) {
            v = this.value;
        }
        if (lLRBNode == null) {
            lLRBNode = this.zzr;
        }
        if (lLRBNode2 == null) {
            lLRBNode2 = this.zzs;
        }
        return color == LLRBNode.Color.RED ? new LLRBRedValueNode(k, v, lLRBNode, lLRBNode2) : new LLRBBlackValueNode(k, v, lLRBNode, lLRBNode2);
    }

    @KeepForSdk
    public K getKey() {
        return this.zzq;
    }

    @KeepForSdk
    public LLRBNode<K, V> getLeft() {
        return this.zzr;
    }

    @KeepForSdk
    public LLRBNode<K, V> getMax() {
        return this.zzs.isEmpty() ? this : this.zzs.getMax();
    }

    @KeepForSdk
    public LLRBNode<K, V> getMin() {
        return this.zzr.isEmpty() ? this : this.zzr.getMin();
    }

    @KeepForSdk
    public LLRBNode<K, V> getRight() {
        return this.zzs;
    }

    @KeepForSdk
    public V getValue() {
        return this.value;
    }

    @KeepForSdk
    public void inOrderTraversal(LLRBNode.NodeVisitor<K, V> nodeVisitor) {
        this.zzr.inOrderTraversal(nodeVisitor);
        nodeVisitor.visitEntry(this.zzq, this.value);
        this.zzs.inOrderTraversal(nodeVisitor);
    }

    @KeepForSdk
    public LLRBNode<K, V> insert(K k, V v, Comparator<K> comparator) {
        int compare = comparator.compare(k, this.zzq);
        return (compare < 0 ? zza((Object) null, (Object) null, this.zzr.insert(k, v, comparator), (LLRBNode<K, V>) null) : compare == 0 ? zza(k, v, (LLRBNode) null, (LLRBNode) null) : zza((Object) null, (Object) null, (LLRBNode) null, this.zzs.insert(k, v, comparator))).zzd();
    }

    @KeepForSdk
    public boolean isEmpty() {
        return false;
    }

    @KeepForSdk
    public LLRBNode<K, V> remove(K k, Comparator<K> comparator) {
        LLRBValueNode<K, V> lLRBValueNode;
        if (comparator.compare(k, this.zzq) < 0) {
            LLRBValueNode zzc = (this.zzr.isEmpty() || this.zzr.isRed() || ((LLRBValueNode) this.zzr).zzr.isRed()) ? this : zzc();
            lLRBValueNode = zzc.zza((Object) null, (Object) null, zzc.zzr.remove(k, comparator), (LLRBNode<K, V>) null);
        } else {
            LLRBValueNode zzf = this.zzr.isRed() ? zzf() : this;
            if (!zzf.zzs.isEmpty() && !zzf.zzs.isRed() && !((LLRBValueNode) zzf.zzs).zzr.isRed()) {
                zzf = zzf.zzg();
                if (zzf.getLeft().getLeft().isRed()) {
                    zzf = zzf.zzf().zzg();
                }
            }
            if (comparator.compare(k, zzf.zzq) == 0) {
                if (zzf.zzs.isEmpty()) {
                    return LLRBEmptyNode.getInstance();
                }
                LLRBNode<K, V> min = zzf.zzs.getMin();
                zzf = zzf.zza(min.getKey(), min.getValue(), (LLRBNode) null, ((LLRBValueNode) zzf.zzs).zzb());
            }
            lLRBValueNode = zzf.zza((Object) null, (Object) null, (LLRBNode) null, zzf.zzs.remove(k, comparator));
        }
        return lLRBValueNode.zzd();
    }

    @KeepForSdk
    public boolean shortCircuitingInOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor) {
        if (!this.zzr.shortCircuitingInOrderTraversal(shortCircuitingNodeVisitor) || !shortCircuitingNodeVisitor.shouldContinue(this.zzq, this.value)) {
            return false;
        }
        return this.zzs.shortCircuitingInOrderTraversal(shortCircuitingNodeVisitor);
    }

    @KeepForSdk
    public boolean shortCircuitingReverseOrderTraversal(LLRBNode.ShortCircuitingNodeVisitor<K, V> shortCircuitingNodeVisitor) {
        if (!this.zzs.shortCircuitingReverseOrderTraversal(shortCircuitingNodeVisitor) || !shortCircuitingNodeVisitor.shouldContinue(this.zzq, this.value)) {
            return false;
        }
        return this.zzr.shortCircuitingReverseOrderTraversal(shortCircuitingNodeVisitor);
    }

    /* access modifiers changed from: protected */
    public abstract LLRBNode.Color zza();

    /* access modifiers changed from: protected */
    public abstract LLRBValueNode<K, V> zza(K k, V v, LLRBNode<K, V> lLRBNode, LLRBNode<K, V> lLRBNode2);

    /* access modifiers changed from: package-private */
    public void zza(LLRBNode<K, V> lLRBNode) {
        this.zzr = lLRBNode;
    }
}
