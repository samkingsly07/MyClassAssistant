package com.google.android.gms.internal.firebase_auth;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzfp extends zzed<Float> implements zzga<Float>, zzhm, RandomAccess {
    private static final zzfp zzwu;
    private int size;
    private float[] zzwv;

    zzfp() {
        this(new float[10], 0);
    }

    private zzfp(float[] fArr, int i) {
        this.zzwv = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzew();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzwv, i2, this.zzwv, i, this.size - i2);
        this.size -= i2 - i;
        this.modCount++;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzfp)) {
            return super.equals(obj);
        }
        zzfp zzfp = (zzfp) obj;
        if (this.size != zzfp.size) {
            return false;
        }
        float[] fArr = zzfp.zzwv;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzwv[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzwv[i2]);
        }
        return i;
    }

    public final int size() {
        return this.size;
    }

    public final void zzc(float f) {
        zzc(this.size, f);
    }

    private final void zzc(int i, float f) {
        zzew();
        if (i < 0 || i > this.size) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
        if (this.size < this.zzwv.length) {
            System.arraycopy(this.zzwv, i, this.zzwv, i + 1, this.size - i);
        } else {
            float[] fArr = new float[(((this.size * 3) / 2) + 1)];
            System.arraycopy(this.zzwv, 0, fArr, 0, i);
            System.arraycopy(this.zzwv, i, fArr, i + 1, this.size - i);
            this.zzwv = fArr;
        }
        this.zzwv[i] = f;
        this.size++;
        this.modCount++;
    }

    public final boolean addAll(Collection<? extends Float> collection) {
        zzew();
        zzfu.checkNotNull(collection);
        if (!(collection instanceof zzfp)) {
            return super.addAll(collection);
        }
        zzfp zzfp = (zzfp) collection;
        if (zzfp.size == 0) {
            return false;
        }
        if (Integer.MAX_VALUE - this.size < zzfp.size) {
            throw new OutOfMemoryError();
        }
        int i = this.size + zzfp.size;
        if (i > this.zzwv.length) {
            this.zzwv = Arrays.copyOf(this.zzwv, i);
        }
        System.arraycopy(zzfp.zzwv, 0, this.zzwv, this.size, zzfp.size);
        this.size = i;
        this.modCount++;
        return true;
    }

    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Float.valueOf(this.zzwv[i]))) {
                System.arraycopy(this.zzwv, i + 1, this.zzwv, i, this.size - i);
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
        float floatValue = ((Float) obj).floatValue();
        zzew();
        zzh(i);
        float f = this.zzwv[i];
        this.zzwv[i] = floatValue;
        return Float.valueOf(f);
    }

    public final /* synthetic */ Object remove(int i) {
        zzew();
        zzh(i);
        float f = this.zzwv[i];
        if (i < this.size - 1) {
            System.arraycopy(this.zzwv, i + 1, this.zzwv, i, this.size - i);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    public final /* synthetic */ void add(int i, Object obj) {
        zzc(i, ((Float) obj).floatValue());
    }

    public final /* synthetic */ zzga zzj(int i) {
        if (i >= this.size) {
            return new zzfp(Arrays.copyOf(this.zzwv, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final /* synthetic */ Object get(int i) {
        zzh(i);
        return Float.valueOf(this.zzwv[i]);
    }

    static {
        zzfp zzfp = new zzfp();
        zzwu = zzfp;
        zzfp.zzev();
    }
}
