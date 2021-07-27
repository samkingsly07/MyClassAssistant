package com.google.android.gms.internal.firebase_auth;

final class zzja extends zziz {
    zzja() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0043, code lost:
        if (r13[r14] > -65) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0081, code lost:
        if (r13[r14] > -65) goto L_0x0083;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        if (r13[r14] > -65) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r12, byte[] r13, int r14, int r15) {
        /*
            r11 = this;
            r0 = -19
            r1 = -16
            r2 = -62
            r3 = 0
            r4 = -96
            r5 = -32
            r6 = -1
            r7 = -65
            if (r12 == 0) goto L_0x0084
            if (r14 < r15) goto L_0x0013
            return r12
        L_0x0013:
            byte r8 = (byte) r12
            if (r8 >= r5) goto L_0x001f
            if (r8 < r2) goto L_0x001e
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x0085
        L_0x001e:
            return r6
        L_0x001f:
            if (r8 >= r1) goto L_0x0048
            int r12 = r12 >> 8
            r12 = r12 ^ r6
            byte r12 = (byte) r12
            if (r12 != 0) goto L_0x0035
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 < r15) goto L_0x0032
            int r12 = com.google.android.gms.internal.firebase_auth.zzix.zzt(r8, r14)
            return r12
        L_0x0032:
            r10 = r14
            r14 = r12
            r12 = r10
        L_0x0035:
            if (r12 > r7) goto L_0x0047
            if (r8 != r5) goto L_0x003b
            if (r12 < r4) goto L_0x0047
        L_0x003b:
            if (r8 != r0) goto L_0x003f
            if (r12 >= r4) goto L_0x0047
        L_0x003f:
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x0046
            goto L_0x0047
        L_0x0046:
            goto L_0x0085
        L_0x0047:
            return r6
        L_0x0048:
            int r9 = r12 >> 8
            r9 = r9 ^ r6
            byte r9 = (byte) r9
            if (r9 != 0) goto L_0x005d
            int r12 = r14 + 1
            byte r9 = r13[r14]
            if (r12 < r15) goto L_0x005a
            int r12 = com.google.android.gms.internal.firebase_auth.zzix.zzt(r8, r9)
            return r12
        L_0x005a:
            r14 = r12
            r12 = 0
            goto L_0x0060
        L_0x005d:
            int r12 = r12 >> 16
            byte r12 = (byte) r12
        L_0x0060:
            if (r12 != 0) goto L_0x0070
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r12 < r15) goto L_0x006d
            int r12 = com.google.android.gms.internal.firebase_auth.zzix.zze((int) r8, (int) r9, (int) r14)
            return r12
        L_0x006d:
            r10 = r14
            r14 = r12
            r12 = r10
        L_0x0070:
            if (r9 > r7) goto L_0x0083
            int r8 = r8 << 28
            int r9 = r9 + 112
            int r8 = r8 + r9
            int r8 = r8 >> 30
            if (r8 != 0) goto L_0x0083
            if (r12 > r7) goto L_0x0083
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x0085
        L_0x0083:
            return r6
        L_0x0084:
            r12 = r14
        L_0x0085:
            if (r12 >= r15) goto L_0x008e
            byte r14 = r13[r12]
            if (r14 < 0) goto L_0x008e
            int r12 = r12 + 1
            goto L_0x0085
        L_0x008e:
            if (r12 < r15) goto L_0x0091
            return r3
        L_0x0091:
            if (r12 < r15) goto L_0x0094
            return r3
        L_0x0094:
            int r14 = r12 + 1
            byte r12 = r13[r12]
            if (r12 >= 0) goto L_0x00f0
            if (r12 >= r5) goto L_0x00a8
            if (r14 < r15) goto L_0x009f
            return r12
        L_0x009f:
            if (r12 < r2) goto L_0x00a7
            int r12 = r14 + 1
            byte r14 = r13[r14]
            if (r14 <= r7) goto L_0x00ee
        L_0x00a7:
            return r6
        L_0x00a8:
            if (r12 >= r1) goto L_0x00c8
            int r8 = r15 + -1
            if (r14 < r8) goto L_0x00b3
            int r12 = com.google.android.gms.internal.firebase_auth.zzix.zzf((byte[]) r13, (int) r14, (int) r15)
            return r12
        L_0x00b3:
            int r8 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r7) goto L_0x00c7
            if (r12 != r5) goto L_0x00bd
            if (r14 < r4) goto L_0x00c7
        L_0x00bd:
            if (r12 != r0) goto L_0x00c1
            if (r14 >= r4) goto L_0x00c7
        L_0x00c1:
            int r12 = r8 + 1
            byte r14 = r13[r8]
            if (r14 <= r7) goto L_0x00ee
        L_0x00c7:
            return r6
        L_0x00c8:
            int r8 = r15 + -2
            if (r14 < r8) goto L_0x00d1
            int r12 = com.google.android.gms.internal.firebase_auth.zzix.zzf((byte[]) r13, (int) r14, (int) r15)
            return r12
        L_0x00d1:
            int r8 = r14 + 1
            byte r14 = r13[r14]
            if (r14 > r7) goto L_0x00ef
            int r12 = r12 << 28
            int r14 = r14 + 112
            int r12 = r12 + r14
            int r12 = r12 >> 30
            if (r12 != 0) goto L_0x00ef
            int r12 = r8 + 1
            byte r14 = r13[r8]
            if (r14 > r7) goto L_0x00ef
            int r14 = r12 + 1
            byte r12 = r13[r12]
            if (r12 <= r7) goto L_0x00ed
            goto L_0x00ef
        L_0x00ed:
            r12 = r14
        L_0x00ee:
            goto L_0x0091
        L_0x00ef:
            return r6
        L_0x00f0:
            r12 = r14
            goto L_0x0091
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzja.zzb(int, byte[], int, int):int");
    }

    /* access modifiers changed from: package-private */
    public final String zzg(byte[] bArr, int i, int i2) throws zzgb {
        if ((i | i2 | ((bArr.length - i) - i2)) < 0) {
            throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", new Object[]{Integer.valueOf(bArr.length), Integer.valueOf(i), Integer.valueOf(i2)}));
        }
        int i3 = i + i2;
        char[] cArr = new char[i2];
        int i4 = 0;
        while (r13 < i3) {
            byte b = bArr[r13];
            if (!zziy.zzd(b)) {
                break;
            }
            i = r13 + 1;
            zziy.zza(b, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (r13 < i3) {
            int i6 = r13 + 1;
            byte b2 = bArr[r13];
            if (zziy.zzd(b2)) {
                int i7 = i5 + 1;
                zziy.zza(b2, cArr, i5);
                while (i6 < i3) {
                    byte b3 = bArr[i6];
                    if (!zziy.zzd(b3)) {
                        break;
                    }
                    i6++;
                    zziy.zza(b3, cArr, i7);
                    i7++;
                }
                r13 = i6;
                i5 = i7;
            } else if (zziy.zze(b2)) {
                if (i6 >= i3) {
                    throw zzgb.zzhx();
                }
                zziy.zza(b2, bArr[i6], cArr, i5);
                r13 = i6 + 1;
                i5++;
            } else if (zziy.zzf(b2)) {
                if (i6 >= i3 - 1) {
                    throw zzgb.zzhx();
                }
                int i8 = i6 + 1;
                zziy.zza(b2, bArr[i6], bArr[i8], cArr, i5);
                r13 = i8 + 1;
                i5++;
            } else if (i6 >= i3 - 2) {
                throw zzgb.zzhx();
            } else {
                int i9 = i6 + 1;
                byte b4 = bArr[i6];
                int i10 = i9 + 1;
                zziy.zza(b2, b4, bArr[i9], bArr[i10], cArr, i5);
                r13 = i10 + 1;
                i5 = i5 + 1 + 1;
            }
        }
        return new String(cArr, 0, i5);
    }

    /* access modifiers changed from: package-private */
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        int i5;
        char charAt;
        int length = charSequence.length();
        int i6 = i2 + i;
        int i7 = 0;
        while (i7 < length && (i5 = i7 + i) < i6 && (charAt = charSequence.charAt(i7)) < 128) {
            bArr[i5] = (byte) charAt;
            i7++;
        }
        if (i7 == length) {
            return i + length;
        }
        int i8 = i + i7;
        while (i7 < length) {
            char charAt2 = charSequence.charAt(i7);
            if (charAt2 < 128 && i8 < i6) {
                i4 = i8 + 1;
                bArr[i8] = (byte) charAt2;
            } else if (charAt2 < 2048 && i8 <= i6 - 2) {
                int i9 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 >>> 6) | 960);
                i8 = i9 + 1;
                bArr[i9] = (byte) ((charAt2 & '?') | 128);
                i7++;
            } else if ((charAt2 < 55296 || 57343 < charAt2) && i8 <= i6 - 3) {
                int i10 = i8 + 1;
                bArr[i8] = (byte) ((charAt2 >>> 12) | 480);
                int i11 = i10 + 1;
                bArr[i10] = (byte) (((charAt2 >>> 6) & 63) | 128);
                i4 = i11 + 1;
                bArr[i11] = (byte) ((charAt2 & '?') | 128);
            } else if (i8 <= i6 - 4) {
                int i12 = i7 + 1;
                if (i12 != charSequence.length()) {
                    char charAt3 = charSequence.charAt(i12);
                    if (!Character.isSurrogatePair(charAt2, charAt3)) {
                        i7 = i12;
                    } else {
                        int codePoint = Character.toCodePoint(charAt2, charAt3);
                        int i13 = i8 + 1;
                        bArr[i8] = (byte) ((codePoint >>> 18) | 240);
                        int i14 = i13 + 1;
                        bArr[i13] = (byte) (((codePoint >>> 12) & 63) | 128);
                        int i15 = i14 + 1;
                        bArr[i14] = (byte) (((codePoint >>> 6) & 63) | 128);
                        i8 = i15 + 1;
                        bArr[i15] = (byte) ((codePoint & 63) | 128);
                        i7 = i12;
                        i7++;
                    }
                }
                throw new zzjb(i7 - 1, length);
            } else if (55296 > charAt2 || charAt2 > 57343 || ((i3 = i7 + 1) != charSequence.length() && Character.isSurrogatePair(charAt2, charSequence.charAt(i3)))) {
                StringBuilder sb = new StringBuilder(37);
                sb.append("Failed writing ");
                sb.append(charAt2);
                sb.append(" at index ");
                sb.append(i8);
                throw new ArrayIndexOutOfBoundsException(sb.toString());
            } else {
                throw new zzjb(i7, length);
            }
            i8 = i4;
            i7++;
        }
        return i8;
    }
}
