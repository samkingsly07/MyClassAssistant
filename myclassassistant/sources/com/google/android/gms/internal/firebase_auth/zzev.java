package com.google.android.gms.internal.firebase_auth;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzev extends zzes {
    private final byte[] buffer;
    private int pos;
    private int zztd;
    private int zztf;
    private int zztg;
    private final InputStream zzth;
    private int zzti;
    private int zztj;
    private zzew zztk;

    private zzev(InputStream inputStream, int i) {
        super();
        this.zztg = Integer.MAX_VALUE;
        this.zztk = null;
        zzfu.zza(inputStream, "input");
        this.zzth = inputStream;
        this.buffer = new byte[i];
        this.zzti = 0;
        this.pos = 0;
        this.zztj = 0;
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
                if (this.zzti - this.pos >= 10) {
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
        if (zzfz > 0 && zzfz <= this.zzti - this.pos) {
            String str = new String(this.buffer, this.pos, zzfz, zzfu.UTF_8);
            this.pos += zzfz;
            return str;
        } else if (zzfz == 0) {
            return "";
        } else {
            if (zzfz > this.zzti) {
                return new String(zzu(zzfz), zzfu.UTF_8);
            }
            zzs(zzfz);
            String str2 = new String(this.buffer, this.pos, zzfz, zzfu.UTF_8);
            this.pos += zzfz;
            return str2;
        }
    }

    public final String zzfo() throws IOException {
        byte[] bArr;
        int zzfz = zzfz();
        int i = this.pos;
        int i2 = 0;
        if (zzfz <= this.zzti - i && zzfz > 0) {
            bArr = this.buffer;
            this.pos = i + zzfz;
            i2 = i;
        } else if (zzfz == 0) {
            return "";
        } else {
            if (zzfz <= this.zzti) {
                zzs(zzfz);
                bArr = this.buffer;
                this.pos = zzfz;
            } else {
                bArr = zzu(zzfz);
            }
        }
        return zzix.zzg(bArr, i2, zzfz);
    }

    public final zzeh zzfp() throws IOException {
        int zzfz = zzfz();
        if (zzfz <= this.zzti - this.pos && zzfz > 0) {
            zzeh zzb = zzeh.zzb(this.buffer, this.pos, zzfz);
            this.pos += zzfz;
            return zzb;
        } else if (zzfz == 0) {
            return zzeh.zzso;
        } else {
            byte[] zzv = zzv(zzfz);
            if (zzv != null) {
                return zzeh.zza(zzv);
            }
            int i = this.pos;
            int i2 = this.zzti - this.pos;
            this.zztj += this.zzti;
            this.pos = 0;
            this.zzti = 0;
            List<byte[]> zzw = zzw(zzfz - i2);
            ArrayList arrayList = new ArrayList(zzw.size() + 1);
            arrayList.add(zzeh.zzb(this.buffer, i, i2));
            for (byte[] zza : zzw) {
                arrayList.add(zzeh.zza(zza));
            }
            return zzeh.zze(arrayList);
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
            int r1 = r5.zzti
            if (r1 == r0) goto L_0x006d
            byte[] r1 = r5.buffer
            int r2 = r0 + 1
            byte r0 = r1[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r2
            return r0
        L_0x0011:
            int r3 = r5.zzti
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzev.zzfz():int");
    }

    private final long zzga() throws IOException {
        long j;
        int i;
        long j2;
        long j3;
        long j4;
        int i2 = this.pos;
        if (this.zzti != i2) {
            byte[] bArr = this.buffer;
            int i3 = i2 + 1;
            byte b = bArr[i2];
            if (b >= 0) {
                this.pos = i3;
                return (long) b;
            } else if (this.zzti - i3 >= 9) {
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
        if (this.zzti - i < 4) {
            zzs(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16);
    }

    private final long zzgc() throws IOException {
        int i = this.pos;
        if (this.zzti - i < 8) {
            zzs(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48) | ((((long) bArr[i + 7]) & 255) << 56);
    }

    public final int zzo(int i) throws zzgb {
        if (i < 0) {
            throw zzgb.zzhq();
        }
        int i2 = i + this.zztj + this.pos;
        int i3 = this.zztg;
        if (i2 > i3) {
            throw zzgb.zzhp();
        }
        this.zztg = i2;
        zzgd();
        return i3;
    }

    private final void zzgd() {
        this.zzti += this.zztd;
        int i = this.zztj + this.zzti;
        if (i > this.zztg) {
            this.zztd = i - this.zztg;
            this.zzti -= this.zztd;
            return;
        }
        this.zztd = 0;
    }

    public final void zzp(int i) {
        this.zztg = i;
        zzgd();
    }

    public final boolean zzfx() throws IOException {
        return this.pos == this.zzti && !zzt(1);
    }

    public final int zzfy() {
        return this.zztj + this.pos;
    }

    private final void zzs(int i) throws IOException {
        if (zzt(i)) {
            return;
        }
        if (i > (this.zzsz - this.zztj) - this.pos) {
            throw zzgb.zzhv();
        }
        throw zzgb.zzhp();
    }

    private final boolean zzt(int i) throws IOException {
        while (this.pos + i > this.zzti) {
            if (i > (this.zzsz - this.zztj) - this.pos || this.zztj + this.pos + i > this.zztg) {
                return false;
            }
            int i2 = this.pos;
            if (i2 > 0) {
                if (this.zzti > i2) {
                    System.arraycopy(this.buffer, i2, this.buffer, 0, this.zzti - i2);
                }
                this.zztj += i2;
                this.zzti -= i2;
                this.pos = 0;
            }
            int read = this.zzth.read(this.buffer, this.zzti, Math.min(this.buffer.length - this.zzti, (this.zzsz - this.zztj) - this.zzti));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                String valueOf = String.valueOf(this.zzth.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                sb.append(valueOf);
                sb.append("#read(byte[]) returned invalid result: ");
                sb.append(read);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            } else if (read <= 0) {
                return false;
            } else {
                this.zzti += read;
                zzgd();
                if (this.zzti >= i) {
                    return true;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    private final byte zzge() throws IOException {
        if (this.pos == this.zzti) {
            zzs(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final byte[] zzu(int i) throws IOException {
        byte[] zzv = zzv(i);
        if (zzv != null) {
            return zzv;
        }
        int i2 = this.pos;
        int i3 = this.zzti - this.pos;
        this.zztj += this.zzti;
        this.pos = 0;
        this.zzti = 0;
        List<byte[]> zzw = zzw(i - i3);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i3);
        for (byte[] next : zzw) {
            System.arraycopy(next, 0, bArr, i3, next.length);
            i3 += next.length;
        }
        return bArr;
    }

    private final byte[] zzv(int i) throws IOException {
        if (i == 0) {
            return zzfu.EMPTY_BYTE_ARRAY;
        }
        if (i < 0) {
            throw zzgb.zzhq();
        }
        int i2 = this.zztj + this.pos + i;
        if (i2 - this.zzsz > 0) {
            throw zzgb.zzhv();
        } else if (i2 > this.zztg) {
            zzr((this.zztg - this.zztj) - this.pos);
            throw zzgb.zzhp();
        } else {
            int i3 = this.zzti - this.pos;
            int i4 = i - i3;
            if (i4 >= 4096 && i4 > this.zzth.available()) {
                return null;
            }
            byte[] bArr = new byte[i];
            System.arraycopy(this.buffer, this.pos, bArr, 0, i3);
            this.zztj += this.zzti;
            this.pos = 0;
            this.zzti = 0;
            while (i3 < bArr.length) {
                int read = this.zzth.read(bArr, i3, i - i3);
                if (read == -1) {
                    throw zzgb.zzhp();
                }
                this.zztj += read;
                i3 += read;
            }
            return bArr;
        }
    }

    private final List<byte[]> zzw(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = this.zzth.read(bArr, i2, bArr.length - i2);
                if (read == -1) {
                    throw zzgb.zzhp();
                }
                this.zztj += read;
                i2 += read;
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzr(int i) throws IOException {
        if (i <= this.zzti - this.pos && i >= 0) {
            this.pos += i;
        } else if (i < 0) {
            throw zzgb.zzhq();
        } else if (this.zztj + this.pos + i > this.zztg) {
            zzr((this.zztg - this.zztj) - this.pos);
            throw zzgb.zzhp();
        } else {
            this.zztj += this.pos;
            int i2 = this.zzti - this.pos;
            this.zzti = 0;
            this.pos = 0;
            while (i2 < i) {
                try {
                    long j = (long) (i - i2);
                    long skip = this.zzth.skip(j);
                    if (skip >= 0) {
                        if (skip <= j) {
                            i2 += (int) skip;
                        }
                    }
                    String valueOf = String.valueOf(this.zzth.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                    sb.append(valueOf);
                    sb.append("#skip returned invalid result: ");
                    sb.append(skip);
                    sb.append("\nThe InputStream implementation is buggy.");
                    throw new IllegalStateException(sb.toString());
                } catch (Throwable th) {
                    this.zztj += i2;
                    zzgd();
                    throw th;
                }
            }
            this.zztj += i2;
            zzgd();
        }
    }
}
