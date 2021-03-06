package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzft extends zzed<Integer> implements zzfy, zzhm, RandomAccess {
    private static final zzft zzxt;
    private int size;
    private int[] zzxu;

    public static zzft zzho() {
        return zzxt;
    }

    zzft() {
        this(new int[10], 0);
    }

    private zzft(int[] iArr, int i) {
        this.zzxu = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzew();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzxu, i2, this.zzxu, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzft)) {
            return super.equals(obj);
        }
        zzft zzft = (zzft) obj;
        if (this.size != zzft.size) {
            return false;
        }
        int[] iArr = zzft.zzxu;
        for (int i = 0; i < this.size; i++) {
            if (this.zzxu[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzxu[i2];
        }
        return i;
    }

    /* renamed from: zzaq */
    public final zzfy zzj(int i) {
        if (i >= this.size) {
            return new zzft(Arrays.copyOf(this.zzxu, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final int getInt(int i) {
        zzh(i);
        return this.zzxu[i];
    }

    public final int size() {
        return this.size;
    }

    public final void zzar(int i) {
        zzs(this.size, i);
    }

    private final void zzs(int i, int i2) {
        zzew();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
        if (this.size < this.zzxu.length) {
            System.arraycopy(this.zzxu, i, this.zzxu, i + 1, this.size - i);
        } else {
            int[] iArr = new int[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzxu, 0, iArr, 0, i);
            System.arraycopy(this.zzxu, i, iArr, i + 1, this.size - i);
            this.zzxu = iArr;
        }
        this.zzxu[i] = i2;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Integer> collection) {
        zzew();
        zzfu.checkNotNull(collection);
        if (!(collection instanceof zzft)) {
            return super.addAll(collection);
        }
        zzft zzft = (zzft) collection;
        if (zzft.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzft.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzft.size;
        if (i > this.zzxu.length) {
            this.zzxu = Arrays.copyOf(this.zzxu, i);
        }
        System.arraycopy(zzft.zzxu, 0, this.zzxu, this.size, zzft.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Integer.valueOf(this.zzxu[i]))) {
                System.arraycopy(this.zzxu, i + 1, this.zzxu, i, this.size - i);
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
        int intValue = ((Integer) obj).intValue();
        zzew();
        zzh(i);
        int i2 = this.zzxu[i];
        this.zzxu[i] = intValue;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ Object remove(int i) {
        zzew();
        zzh(i);
        int i2 = this.zzxu[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzxu, i + 1, this.zzxu, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzs(i, ((Integer) obj).intValue());
    }

    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzft zzft = new zzft();
        zzxt = zzft;
        zzft.zzev();
    }
}
