package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

final class zzhr extends zzeh {
    /* access modifiers changed from: private */
    public static final int[] zzaai;
    private final int zzaaj;
    /* access modifiers changed from: private */
    public final zzeh zzaak;
    /* access modifiers changed from: private */
    public final zzeh zzaal;
    private final int zzaam;
    private final int zzaan;

    private zzhr(zzeh zzeh, zzeh zzeh2) {
        this.zzaak = zzeh;
        this.zzaal = zzeh2;
        this.zzaam = zzeh.size();
        this.zzaaj = this.zzaam + zzeh2.size();
        this.zzaan = Math.max(zzeh.zzfb(), zzeh2.zzfb()) + 1;
    }

    static zzeh zza(zzeh zzeh, zzeh zzeh2) {
        if (zzeh2.size() == 0) {
            return zzeh;
        }
        if (zzeh.size() == 0) {
            return zzeh2;
        }
        int size = zzeh.size() + zzeh2.size();
        if (size < 128) {
            return zzb(zzeh, zzeh2);
        }
        if (zzeh instanceof zzhr) {
            zzhr zzhr = (zzhr) zzeh;
            if (zzhr.zzaal.size() + zzeh2.size() < 128) {
                return new zzhr(zzhr.zzaak, zzb(zzhr.zzaal, zzeh2));
            } else if (zzhr.zzaak.zzfb() > zzhr.zzaal.zzfb() && zzhr.zzfb() > zzeh2.zzfb()) {
                return new zzhr(zzhr.zzaak, new zzhr(zzhr.zzaal, zzeh2));
            }
        }
        if (size >= zzaai[Math.max(zzeh.zzfb(), zzeh2.zzfb()) + 1]) {
            return new zzhr(zzeh, zzeh2);
        }
        return new zzht().zzc(zzeh, zzeh2);
    }

    private static zzeh zzb(zzeh zzeh, zzeh zzeh2) {
        int size = zzeh.size();
        int size2 = zzeh2.size();
        byte[] bArr = new byte[(size + size2)];
        zzeh.zza(bArr, 0, 0, size);
        zzeh2.zza(bArr, 0, size, size2);
        return zzeh.zza(bArr);
    }

    public final byte zzk(int i) {
        zze(i, this.zzaaj);
        if (i < this.zzaam) {
            return this.zzaak.zzk(i);
        }
        return this.zzaal.zzk(i - this.zzaam);
    }

    public final int size() {
        return this.zzaaj;
    }

    /* access modifiers changed from: protected */
    public final int zzfb() {
        return this.zzaan;
    }

    /* access modifiers changed from: protected */
    public final boolean zzfc() {
        return this.zzaaj >= zzaai[this.zzaan];
    }

    public final zzeh zzd(int i, int i2) {
        int zzd = zzd(i, i2, this.zzaaj);
        if (zzd == 0) {
            return zzeh.zzso;
        }
        if (zzd == this.zzaaj) {
            return this;
        }
        if (i2 <= this.zzaam) {
            return this.zzaak.zzd(i, i2);
        }
        if (i >= this.zzaam) {
            return this.zzaal.zzd(i - this.zzaam, i2 - this.zzaam);
        }
        zzeh zzeh = this.zzaak;
        return new zzhr(zzeh.zzd(i, zzeh.size()), this.zzaal.zzd(0, i2 - this.zzaam));
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.zzaam) {
            this.zzaak.zzb(bArr, i, i2, i3);
        } else if (i >= this.zzaam) {
            this.zzaal.zzb(bArr, i - this.zzaam, i2, i3);
        } else {
            int i4 = this.zzaam - i;
            this.zzaak.zzb(bArr, i, i2, i4);
            this.zzaal.zzb(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeg zzeg) throws IOException {
        this.zzaak.zza(zzeg);
        this.zzaal.zza(zzeg);
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        byte[] bArr;
        int size = size();
        if (size == 0) {
            bArr = zzfu.EMPTY_BYTE_ARRAY;
        } else {
            byte[] bArr2 = new byte[size];
            zzb(bArr2, 0, 0, size);
            bArr = bArr2;
        }
        return new String(bArr, charset);
    }

    public final boolean zzfa() {
        if (this.zzaal.zzb(this.zzaak.zzb(0, 0, this.zzaam), 0, this.zzaal.size()) == 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final int zzb(int i, int i2, int i3) {
        if (i2 + i3 <= this.zzaam) {
            return this.zzaak.zzb(i, i2, i3);
        }
        if (i2 >= this.zzaam) {
            return this.zzaal.zzb(i, i2 - this.zzaam, i3);
        }
        int i4 = this.zzaam - i2;
        return this.zzaal.zzb(this.zzaak.zzb(i, i2, i4), 0, i3 - i4);
    }

    public final boolean equals(Object obj) {
        boolean z;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeh)) {
            return false;
        }
        zzeh zzeh = (zzeh) obj;
        if (this.zzaaj != zzeh.size()) {
            return false;
        }
        if (this.zzaaj == 0) {
            return true;
        }
        int zzfd = zzfd();
        int zzfd2 = zzeh.zzfd();
        if (zzfd != 0 && zzfd2 != 0 && zzfd != zzfd2) {
            return false;
        }
        zzhu zzhu = new zzhu(this);
        zzep zzep = (zzep) zzhu.next();
        zzhu zzhu2 = new zzhu(zzeh);
        zzep zzep2 = (zzep) zzhu2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = zzep.size() - i;
            int size2 = zzep2.size() - i2;
            int min = Math.min(size, size2);
            if (i == 0) {
                z = zzep.zza(zzep2, i2, min);
            } else {
                z = zzep2.zza(zzep, i, min);
            }
            if (!z) {
                return false;
            }
            i3 += min;
            if (i3 < this.zzaaj) {
                if (min == size) {
                    zzep = (zzep) zzhu.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    zzep2 = (zzep) zzhu2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == this.zzaaj) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    /* access modifiers changed from: protected */
    public final int zzc(int i, int i2, int i3) {
        if (i2 + i3 <= this.zzaam) {
            return this.zzaak.zzc(i, i2, i3);
        }
        if (i2 >= this.zzaam) {
            return this.zzaal.zzc(i, i2 - this.zzaam, i3);
        }
        int i4 = this.zzaam - i2;
        return this.zzaal.zzc(this.zzaak.zzc(i, i2, i4), 0, i3 - i4);
    }

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        zzaai = new int[arrayList.size()];
        for (int i4 = 0; i4 < zzaai.length; i4++) {
            zzaai[i4] = ((Integer) arrayList.get(i4)).intValue();
        }
    }
}
