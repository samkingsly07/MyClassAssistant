package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzgp extends zzed<Long> implements zzga<Long>, zzhm, RandomAccess {
    private static final zzgp zzyx;
    private int size;
    private long[] zzyy;

    zzgp() {
        this(new long[10], 0);
    }

    private zzgp(long[] jArr, int i) {
        this.zzyy = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzew();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzyy, i2, this.zzyy, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgp)) {
            return super.equals(obj);
        }
        zzgp zzgp = (zzgp) obj;
        if (this.size != zzgp.size) {
            return false;
        }
        long[] jArr = zzgp.zzyy;
        for (int i = 0; i < this.size; i++) {
            if (this.zzyy[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzfu.zzk(this.zzyy[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzh(i);
        return this.zzyy[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzl(long j) {
        zzk(this.size, j);
    }

    private final void zzk(int i, long j) {
        zzew();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
        if (this.size < this.zzyy.length) {
            System.arraycopy(this.zzyy, i, this.zzyy, i + 1, this.size - i);
        } else {
            long[] jArr = new long[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzyy, 0, jArr, 0, i);
            System.arraycopy(this.zzyy, i, jArr, i + 1, this.size - i);
            this.zzyy = jArr;
        }
        this.zzyy[i] = j;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Long> collection) {
        zzew();
        zzfu.checkNotNull(collection);
        if (!(collection instanceof zzgp)) {
            return super.addAll(collection);
        }
        zzgp zzgp = (zzgp) collection;
        if (zzgp.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzgp.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzgp.size;
        if (i > this.zzyy.length) {
            this.zzyy = Arrays.copyOf(this.zzyy, i);
        }
        System.arraycopy(zzgp.zzyy, 0, this.zzyy, this.size, zzgp.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzyy[i]))) {
                System.arraycopy(this.zzyy, i + 1, this.zzyy, i, this.size - i);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzh(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
    }

    private final String zzi(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzew();
        zzh(i);
        long j = this.zzyy[i];
        this.zzyy[i] = longValue;
        return Long.valueOf(j);
    }

    public final /* synthetic */ Object remove(int i) {
        zzew();
        zzh(i);
        long j = this.zzyy[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzyy, i + 1, this.zzyy, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzk(i, ((Long) obj).longValue());
    }

    public final /* synthetic */ zzga zzj(int i) {
        if (i >= this.size) {
            return new zzgp(Arrays.copyOf(this.zzyy, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzgp zzgp = new zzgp();
        zzyx = zzgp;
        zzgp.zzev();
    }
}
