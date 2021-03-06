package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs;
import java.io.IOException;
import java.util.Arrays;

public final class zziq {
    private static final zziq zzabm = new zziq(0, new int[0], new Object[0], false);
    private int count;
    private int[] zzabn;
    private boolean zzsh;
    private int zzwz;
    private Object[] zzzm;

    public static zziq zzjn() {
        return zzabm;
    }

    static zziq zzjo() {
        return new zziq();
    }

    static zziq zza(zziq zziq, zziq zziq2) {
        int i = zziq.count + zziq2.count;
        int[] copyOf = Arrays.copyOf(zziq.zzabn, i);
        System.arraycopy(zziq2.zzabn, 0, copyOf, zziq.count, zziq2.count);
        Object[] copyOf2 = Arrays.copyOf(zziq.zzzm, i);
        System.arraycopy(zziq2.zzzm, 0, copyOf2, zziq.count, zziq2.count);
        return new zziq(i, copyOf, copyOf2, true);
    }

    private zziq() {
        this(0, new int[8], new Object[8], true);
    }

    private zziq(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzwz = -1;
        this.count = i;
        this.zzabn = iArr;
        this.zzzm = objArr;
        this.zzsh = z;
    }

    public final void zzev() {
        this.zzsh = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzjk zzjk) throws IOException {
        if (zzjk.zzgk() == zzfs.zze.zzxr) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzjk.zza(this.zzabn[i] >>> 3, this.zzzm[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzjk.zza(this.zzabn[i2] >>> 3, this.zzzm[i2]);
        }
    }

    public final void zzb(zzjk zzjk) throws IOException {
        if (this.count != 0) {
            if (zzjk.zzgk() == zzfs.zze.zzxq) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzabn[i], this.zzzm[i], zzjk);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzabn[i2], this.zzzm[i2], zzjk);
            }
        }
    }

    private static void zzb(int i, Object obj, zzjk zzjk) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 != 5) {
            switch (i3) {
                case 0:
                    zzjk.zzi(i2, ((Long) obj).longValue());
                    return;
                case 1:
                    zzjk.zzc(i2, ((Long) obj).longValue());
                    return;
                case 2:
                    zzjk.zza(i2, (zzeh) obj);
                    return;
                case 3:
                    if (zzjk.zzgk() == zzfs.zze.zzxq) {
                        zzjk.zzao(i2);
                        ((zziq) obj).zzb(zzjk);
                        zzjk.zzap(i2);
                        return;
                    }
                    zzjk.zzap(i2);
                    ((zziq) obj).zzb(zzjk);
                    zzjk.zzao(i2);
                    return;
                default:
                    throw new RuntimeException(zzgb.zzhu());
            }
        } else {
            zzjk.zzj(i2, ((Integer) obj).intValue());
        }
    }

    public final int zzjp() {
        int i = this.zzwz;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzez.zzd(this.zzabn[i3] >>> 3, (zzeh) this.zzzm[i3]);
        }
        this.zzwz = i2;
        return i2;
    }

    public final int zzgv() {
        int i;
        int i2 = this.zzwz;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzabn[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 != 5) {
                switch (i7) {
                    case 0:
                        i = zzez.zze(i6, ((Long) this.zzzm[i4]).longValue());
                        break;
                    case 1:
                        i = zzez.zzg(i6, ((Long) this.zzzm[i4]).longValue());
                        break;
                    case 2:
                        i = zzez.zzc(i6, (zzeh) this.zzzm[i4]);
                        break;
                    case 3:
                        i = (zzez.zzaf(i6) << 1) + ((zziq) this.zzzm[i4]).zzgv();
                        break;
                    default:
                        throw new IllegalStateException(zzgb.zzhu());
                }
            } else {
                i = zzez.zzn(i6, ((Integer) this.zzzm[i4]).intValue());
            }
            i3 += i;
        }
        this.zzwz = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zziq)) {
            return false;
        }
        zziq zziq = (zziq) obj;
        if (this.count == zziq.count) {
            int[] iArr = this.zzabn;
            int[] iArr2 = zziq.zzabn;
            int i = this.count;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzzm;
                Object[] objArr2 = zziq.zzzm;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (!z2) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = (this.count + 527) * 31;
        int[] iArr = this.zzabn;
        int i2 = this.count;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i2; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i + i4) * 31;
        Object[] objArr = this.zzzm;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzhe.zza(sb, i, String.valueOf(this.zzabn[i2] >>> 3), this.zzzm[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (!this.zzsh) {
            throw new UnsupportedOperationException();
        }
        if (this.count == this.zzabn.length) {
            int i2 = this.count + (this.count < 4 ? 8 : this.count >> 1);
            this.zzabn = Arrays.copyOf(this.zzabn, i2);
            this.zzzm = Arrays.copyOf(this.zzzm, i2);
        }
        this.zzabn[this.count] = i;
        this.zzzm[this.count] = obj;
        this.count++;
    }
}
