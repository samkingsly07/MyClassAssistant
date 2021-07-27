package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.util.Arrays;

final class zzeu extends zzes {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zztc;
    private int zztd;
    private int zzte;
    private int zztf;
    private int zztg;

    private zzeu(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zztg = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzte = this.pos;
        this.zztc = z;
    }

    public final int zzfh() throws IOException {
        if (zzfx()) {
            this.zztf = 0;
            return 0;
        }
        this.zztf = zzfz();
        if ((this.zztf >>> 3) != 0) {
            return this.zztf;
        }
        throw zzgb.zzhs();
    }

    public final void zzm(int i) throws zzgb {
        if (this.zztf != i) {
            throw zzgb.zzht();
        }
    }

    public final boolean zzn(int i) throws IOException {
        int zzfh;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] < 0) {
                            i2++;
                        }
                    }
                    throw zzgb.zzhr();
                }
                while (i2 < 10) {
                    if (zzge() < 0) {
                        i2++;
                    }
                }
                throw zzgb.zzhr();
                return true;
            case 1:
                zzr(8);
                return true;
            case 2:
                zzr(zzfz());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzr(4);
                return true;
            default:
                throw zzgb.zzhu();
        }
        do {
            zzfh = zzfh();
            if (zzfh == 0 || !zzn(zzfh)) {
                zzm(((i >>> 3) << 3) | 4);
                return true;
            }
            zzfh = zzfh();
            zzm(((i >>> 3) << 3) | 4);
            return true;
        } while (!zzn(zzfh));
        zzm(((i >>> 3) << 3) | 4);
        return true;
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzgc());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzgb());
    }

    public final long zzfi() throws IOException {
        return zzga();
    }

    public final long zzfj() throws IOException {
        return zzga();
    }

    public final int zzfk() throws IOException {
        return zzfz();
    }

    public final long zzfl() throws IOException {
        return zzgc();
    }

    public final int zzfm() throws IOException {
        return zzgb();
    }

    public final boolean zzfn() throws IOException {
        return zzga() != 0;
    }

    public final String readString() throws IOException {
        int zzfz = zzfz();
        if (zzfz > 0 && zzfz <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzfz, zzfu.UTF_8);
            this.pos += zzfz;
            return str;
        } else if (zzfz == 0) {
            return "";
        } else {
            if (zzfz < 0) {
                throw zzgb.zzhq();
            }
            throw zzgb.zzhp();
        }
    }

    public final String zzfo() throws IOException {
        int zzfz = zzfz();
        if (zzfz > 0 && zzfz <= this.limit - this.pos) {
            String zzg = zzix.zzg(this.buffer, this.pos, zzfz);
            this.pos += zzfz;
            return zzg;
        } else if (zzfz == 0) {
            return "";
        } else {
            if (zzfz <= 0) {
                throw zzgb.zzhq();
            }
            throw zzgb.zzhp();
        }
    }

    public final zzeh zzfp() throws IOException {
        byte[] bArr;
        int zzfz = zzfz();
        if (zzfz > 0 && zzfz <= this.limit - this.pos) {
            zzeh zzb = zzeh.zzb(this.buffer, this.pos, zzfz);
            this.pos += zzfz;
            return zzb;
        } else if (zzfz == 0) {
            return zzeh.zzso;
        } else {
            if (zzfz > 0 && zzfz <= this.limit - this.pos) {
                int i = this.pos;
                this.pos += zzfz;
                bArr = Arrays.copyOfRange(this.buffer, i, this.pos);
            } else if (zzfz > 0) {
                throw zzgb.zzhp();
            } else if (zzfz == 0) {
                bArr = zzfu.EMPTY_BYTE_ARRAY;
            } else {
                throw zzgb.zzhq();
            }
            return zzeh.zza(bArr);
        }
    }

    public final int zzfq() throws IOException {
        return zzfz();
    }

    public final int zzfr() throws IOException {
        return zzfz();
    }

    public final int zzfs() throws IOException {
        return zzgb();
    }

    public final long zzft() throws IOException {
        return zzgc();
    }

    public final int zzfu() throws IOException {
        return zzq(zzfz());
    }

    public final long zzfv() throws IOException {
        return zza(zzga());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0068, code lost:
        if (r1[r2] >= 0) goto L_0x006a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzfz() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006d
            byte[] r1 = r5.buffer
            int r2 = r0 + 1
            byte r0 = r1[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r2
            return r0
        L_0x0011:
            int r3 = r5.limit
            int r3 = r3 - r2
            r4 = 9
            if (r3 < r4) goto L_0x006d
            int r3 = r2 + 1
            byte r2 = r1[r2]
            int r2 = r2 << 7
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x0024
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x006a
        L_0x0024:
            int r2 = r3 + 1
            byte r3 = r1[r3]
            int r3 = r3 << 14
            r0 = r0 ^ r3
            if (r0 < 0) goto L_0x0031
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002f:
            r3 = r2
            goto L_0x006a
        L_0x0031:
            int r3 = r2 + 1
            byte r2 = r1[r2]
            int r2 = r2 << 21
            r0 = r0 ^ r2
            if (r0 >= 0) goto L_0x003f
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L_0x006a
        L_0x003f:
            int r2 = r3 + 1
            byte r3 = r1[r3]
            int r4 = r3 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r2 = r1[r2]
            if (r2 >= 0) goto L_0x006a
            int r2 = r3 + 1
            byte r3 = r1[r3]
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r2 = r1[r2]
            if (r2 >= 0) goto L_0x006a
            int r2 = r3 + 1
            byte r3 = r1[r3]
            if (r3 >= 0) goto L_0x002f
            int r3 = r2 + 1
            byte r1 = r1[r2]
            if (r1 < 0) goto L_0x006d
        L_0x006a:
            r5.pos = r3
            return r0
        L_0x006d:
            long r0 = r5.zzfw()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzeu.zzfz():int");
    }

    private final long zzga() throws IOException {
        long j;
        int i;
        long j2;
        long j3;
        long j4;
        int i2 = this.pos;
        if (this.limit != i2) {
            byte[] bArr = this.buffer;
            int i3 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i3;
                return (long) b;
            } else if (this.limit - i3 >= 9) {
                int i4 = i3 + 1;
                byte b2 = b ^ (bArr[i3] << 7);
                if (b2 < 0) {
                    j3 = (long) (b2 ^ Byte.MIN_VALUE);
                } else {
                    int i5 = i4 + 1;
                    byte b3 = b2 ^ (bArr[i4] << 14);
                    if (b3 >= 0) {
                        j4 = (long) (b3 ^ 16256);
                        i = i5;
                        j = j4;
                        this.pos = i;
                        return j;
                    }
                    i4 = i5 + 1;
                    byte b4 = b3 ^ (bArr[i5] << 21);
                    if (b4 < 0) {
                        j3 = (long) (b4 ^ -2080896);
                    } else {
                        long j5 = (long) b4;
                        int i6 = i4 + 1;
                        long j6 = j5 ^ (((long) bArr[i4]) << 28);
                        if (j6 >= 0) {
                            j2 = j6 ^ 266354560;
                        } else {
                            int i7 = i6 + 1;
                            long j7 = j6 ^ (((long) bArr[i6]) << 35);
                            if (j7 < 0) {
                                j = j7 ^ -34093383808L;
                            } else {
                                i6 = i7 + 1;
                                long j8 = j7 ^ (((long) bArr[i7]) << 42);
                                if (j8 >= 0) {
                                    j2 = j8 ^ 4363953127296L;
                                } else {
                                    i7 = i6 + 1;
                                    long j9 = j8 ^ (((long) bArr[i6]) << 49);
                                    if (j9 < 0) {
                                        j = j9 ^ -558586000294016L;
                                    } else {
                                        int i8 = i7 + 1;
                                        long j10 = (j9 ^ (((long) bArr[i7]) << 56)) ^ 71499008037633920L;
                                        if (j10 < 0) {
                                            int i9 = i8 + 1;
                                            if (((long) bArr[i8]) >= 0) {
                                                i8 = i9;
                                            }
                                        }
                                        j = j10;
                                        this.pos = i;
                                        return j;
                                    }
                                }
                            }
                            i = i7;
                            this.pos = i;
                            return j;
                        }
                        j = j2;
                        this.pos = i;
                        return j;
                    }
                }
                j4 = j3;
                i = i4;
                j = j4;
                this.pos = i;
                return j;
            }
        }
        return zzfw();
    }

    /* access modifiers changed from: package-private */
    public final long zzfw() throws IOException {
        long j = 0;
        int i = 0;
        while (i < 64) {
            byte zzge = zzge();
            long j2 = j | (((long) (zzge & Byte.MAX_VALUE)) << i);
            if ((zzge & 128) == 0) {
                return j2;
            }
            i += 7;
            j = j2;
        }
        throw zzgb.zzhr();
    }

    private final int zzgb() throws IOException {
        int i = this.pos;
        if (this.limit - i < 4) {
            throw zzgb.zzhp();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzgc() throws IOException {
        int i = this.pos;
        if (this.limit - i < 8) {
            throw zzgb.zzhp();
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public final int zzo(int i) throws zzgb {
        if (i < 0) {
            throw zzgb.zzhq();
        }
        int zzfy = i + zzfy();
        int i2 = this.zztg;
        if (zzfy > i2) {
            throw zzgb.zzhp();
        }
        this.zztg = zzfy;
        zzgd();
        return i2;
    }

    private final void zzgd() {
        this.limit += this.zztd;
        int i = this.limit - this.zzte;
        if (i > this.zztg) {
            this.zztd = i - this.zztg;
            this.limit -= this.zztd;
            return;
        }
        this.zztd = 0;
    }

    public final void zzp(int i) {
        this.zztg = i;
        zzgd();
    }

    public final boolean zzfx() throws IOException {
        return this.pos == this.limit;
    }

    public final int zzfy() {
        return this.pos - this.zzte;
    }

    private final byte zzge() throws IOException {
        if (this.pos == this.limit) {
            throw zzgb.zzhp();
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final void zzr(int i) throws IOException {
        if (i >= 0 && i <= this.limit - this.pos) {
            this.pos += i;
        } else if (i < 0) {
            throw zzgb.zzhq();
        } else {
            throw zzgb.zzhp();
        }
    }
}
