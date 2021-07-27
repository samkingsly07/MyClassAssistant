package com.google.android.gms.internal.firebase_auth;

final class zzjc extends zziz {
    zzjc() {
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0188, code lost:
        return -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0059, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r8) > -65) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0086, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r8) > -65) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00ce, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r8) > -65) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x012a, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzb(int r24, byte[] r25, int r26, int r27) {
        /*
            r23 = this;
            r0 = r24
            r1 = r25
            r2 = r26
            r3 = r27
            r4 = r2 | r3
            int r5 = r1.length
            int r5 = r5 - r3
            r4 = r4 | r5
            r5 = 2
            r6 = 3
            r7 = 0
            if (r4 >= 0) goto L_0x0034
            java.lang.ArrayIndexOutOfBoundsException r0 = new java.lang.ArrayIndexOutOfBoundsException
            java.lang.String r4 = "Array length=%d, index=%d, limit=%d"
            java.lang.Object[] r6 = new java.lang.Object[r6]
            int r1 = r1.length
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r6[r7] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r26)
            r2 = 1
            r6[r2] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r27)
            r6[r5] = r1
            java.lang.String r1 = java.lang.String.format(r4, r6)
            r0.<init>(r1)
            throw r0
        L_0x0034:
            long r8 = (long) r2
            long r2 = (long) r3
            r4 = 16
            r10 = -19
            r11 = -16
            r12 = -62
            r13 = -96
            r14 = -32
            r15 = -1
            r6 = -65
            r16 = 1
            if (r0 == 0) goto L_0x00d1
            int r18 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r18 < 0) goto L_0x004e
            return r0
        L_0x004e:
            byte r5 = (byte) r0
            if (r5 >= r14) goto L_0x005c
            if (r5 < r12) goto L_0x005b
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r8)
            if (r0 <= r6) goto L_0x00d3
        L_0x005b:
            return r15
        L_0x005c:
            if (r5 >= r11) goto L_0x008b
            int r0 = r0 >> 8
            r0 = r0 ^ r15
            byte r0 = (byte) r0
            if (r0 != 0) goto L_0x0075
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r8)
            int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x0073
            int r0 = com.google.android.gms.internal.firebase_auth.zzix.zzt(r5, r0)
            return r0
        L_0x0073:
            r8 = r19
        L_0x0075:
            if (r0 > r6) goto L_0x008a
            if (r5 != r14) goto L_0x007b
            if (r0 < r13) goto L_0x008a
        L_0x007b:
            if (r5 != r10) goto L_0x007f
            if (r0 >= r13) goto L_0x008a
        L_0x007f:
            r0 = 0
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r8)
            if (r0 <= r6) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            goto L_0x00d3
        L_0x008a:
            return r15
        L_0x008b:
            int r18 = r0 >> 8
            r10 = r18 ^ -1
            byte r10 = (byte) r10
            if (r10 != 0) goto L_0x00a6
            long r19 = r8 + r16
            byte r10 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r8)
            int r0 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x00a2
            int r0 = com.google.android.gms.internal.firebase_auth.zzix.zzt(r5, r10)
            return r0
        L_0x00a2:
            r8 = r19
            r0 = 0
            goto L_0x00a8
        L_0x00a6:
            int r0 = r0 >> r4
            byte r0 = (byte) r0
        L_0x00a8:
            if (r0 != 0) goto L_0x00bb
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r8)
            int r8 = (r19 > r2 ? 1 : (r19 == r2 ? 0 : -1))
            if (r8 < 0) goto L_0x00b9
            int r0 = com.google.android.gms.internal.firebase_auth.zzix.zze((int) r5, (int) r10, (int) r0)
            return r0
        L_0x00b9:
            r8 = r19
        L_0x00bb:
            if (r10 > r6) goto L_0x00d0
            int r5 = r5 << 28
            int r10 = r10 + 112
            int r5 = r5 + r10
            int r5 = r5 >> 30
            if (r5 != 0) goto L_0x00d0
            if (r0 > r6) goto L_0x00d0
            long r19 = r8 + r16
            byte r0 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r8)
            if (r0 <= r6) goto L_0x00d3
        L_0x00d0:
            return r15
        L_0x00d1:
            r19 = r8
        L_0x00d3:
            r0 = 0
            long r8 = r2 - r19
            int r0 = (int) r8
            if (r0 >= r4) goto L_0x00dd
            r2 = 0
            goto L_0x00f1
        L_0x00dd:
            r3 = r19
            r2 = 0
        L_0x00e0:
            if (r2 >= r0) goto L_0x00ef
            long r8 = r3 + r16
            byte r3 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r3)
            if (r3 >= 0) goto L_0x00eb
            goto L_0x00f1
        L_0x00eb:
            int r2 = r2 + 1
            r3 = r8
            goto L_0x00e0
        L_0x00ef:
            r2 = r0
        L_0x00f1:
            int r0 = r0 - r2
            long r2 = (long) r2
            long r4 = r19 + r2
        L_0x00f5:
            r2 = 0
        L_0x00f7:
            if (r0 <= 0) goto L_0x010e
            long r2 = r4 + r16
            byte r4 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r4)
            if (r4 < 0) goto L_0x0109
            int r0 = r0 + -1
            r21 = r2
            r2 = r4
            r4 = r21
            goto L_0x00f7
        L_0x0109:
            r21 = r2
            r2 = r4
            r4 = r21
        L_0x010e:
            if (r0 != 0) goto L_0x0111
            return r7
        L_0x0111:
            int r0 = r0 + -1
            if (r2 >= r14) goto L_0x012b
            if (r0 != 0) goto L_0x0118
            return r2
        L_0x0118:
            int r0 = r0 + -1
            if (r2 < r12) goto L_0x012a
            long r2 = r4 + r16
            byte r4 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r4)
            if (r4 <= r6) goto L_0x0125
            goto L_0x012a
        L_0x0125:
            r4 = r2
            r3 = 2
            r10 = -19
            goto L_0x0185
        L_0x012a:
            return r15
        L_0x012b:
            if (r2 >= r11) goto L_0x0155
            r3 = 2
            if (r0 >= r3) goto L_0x0135
            int r0 = zza(r1, r2, r4, r0)
            return r0
        L_0x0135:
            int r0 = r0 + -2
            long r8 = r4 + r16
            byte r4 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r4)
            if (r4 > r6) goto L_0x0154
            if (r2 != r14) goto L_0x0143
            if (r4 < r13) goto L_0x0154
        L_0x0143:
            r10 = -19
            if (r2 != r10) goto L_0x0149
            if (r4 >= r13) goto L_0x0154
        L_0x0149:
            r2 = 0
            long r4 = r8 + r16
            byte r2 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r8)
            if (r2 <= r6) goto L_0x0153
            goto L_0x0154
        L_0x0153:
            goto L_0x00f5
        L_0x0154:
            return r15
        L_0x0155:
            r3 = 2
            r10 = -19
            r8 = 3
            if (r0 >= r8) goto L_0x0160
            int r0 = zza(r1, r2, r4, r0)
            return r0
        L_0x0160:
            int r0 = r0 + -3
            long r7 = r4 + r16
            byte r4 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r4)
            if (r4 > r6) goto L_0x0188
            int r2 = r2 << 28
            int r4 = r4 + 112
            int r2 = r2 + r4
            int r2 = r2 >> 30
            if (r2 != 0) goto L_0x0188
            long r4 = r7 + r16
            byte r2 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r7)
            if (r2 > r6) goto L_0x0188
            long r7 = r4 + r16
            byte r2 = com.google.android.gms.internal.firebase_auth.zziv.zza(r1, r4)
            if (r2 <= r6) goto L_0x0184
            goto L_0x0188
        L_0x0184:
            r4 = r7
        L_0x0185:
            r7 = 0
            goto L_0x00f5
        L_0x0188:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzjc.zzb(int, byte[], int, int):int");
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
            byte zza = zziv.zza(bArr, (long) r13);
            if (!zziy.zzd(zza)) {
                break;
            }
            i = r13 + 1;
            zziy.zza(zza, cArr, i4);
            i4++;
        }
        int i5 = i4;
        while (r13 < i3) {
            int i6 = r13 + 1;
            byte zza2 = zziv.zza(bArr, (long) r13);
            if (zziy.zzd(zza2)) {
                int i7 = i5 + 1;
                zziy.zza(zza2, cArr, i5);
                while (i6 < i3) {
                    byte zza3 = zziv.zza(bArr, (long) i6);
                    if (!zziy.zzd(zza3)) {
                        break;
                    }
                    i6++;
                    zziy.zza(zza3, cArr, i7);
                    i7++;
                }
                r13 = i6;
                i5 = i7;
            } else if (zziy.zze(zza2)) {
                if (i6 >= i3) {
                    throw zzgb.zzhx();
                }
                int i8 = i6 + 1;
                zziy.zza(zza2, zziv.zza(bArr, (long) i6), cArr, i5);
                r13 = i8;
                i5++;
            } else if (zziy.zzf(zza2)) {
                if (i6 >= i3 - 1) {
                    throw zzgb.zzhx();
                }
                int i9 = i6 + 1;
                int i10 = i9 + 1;
                zziy.zza(zza2, zziv.zza(bArr, (long) i6), zziv.zza(bArr, (long) i9), cArr, i5);
                r13 = i10;
                i5++;
            } else if (i6 >= i3 - 2) {
                throw zzgb.zzhx();
            } else {
                int i11 = i6 + 1;
                byte zza4 = zziv.zza(bArr, (long) i6);
                int i12 = i11 + 1;
                zziy.zza(zza2, zza4, zziv.zza(bArr, (long) i11), zziv.zza(bArr, (long) i12), cArr, i5);
                r13 = i12 + 1;
                i5 = i5 + 1 + 1;
            }
        }
        return new String(cArr, 0, i5);
    }

    /* access modifiers changed from: package-private */
    public final int zzb(CharSequence charSequence, byte[] bArr, int i, int i2) {
        long j;
        int i3;
        long j2;
        char charAt;
        CharSequence charSequence2 = charSequence;
        byte[] bArr2 = bArr;
        int i4 = i;
        int i5 = i2;
        long j3 = (long) i4;
        long j4 = j3 + ((long) i5);
        int length = charSequence.length();
        if (length > i5 || bArr2.length - i5 < i4) {
            char charAt2 = charSequence2.charAt(length - 1);
            StringBuilder sb = new StringBuilder(37);
            sb.append("Failed writing ");
            sb.append(charAt2);
            sb.append(" at index ");
            sb.append(i4 + i5);
            throw new ArrayIndexOutOfBoundsException(sb.toString());
        }
        int i6 = 0;
        while (i6 < length && (charAt = charSequence2.charAt(i6)) < 128) {
            zziv.zza(bArr2, j, (byte) charAt);
            i6++;
            j3 = j + 1;
        }
        if (i6 == length) {
            return (int) j;
        }
        while (i6 < length) {
            char charAt3 = charSequence2.charAt(i6);
            if (charAt3 < 128 && j < j4) {
                j2 = j + 1;
                zziv.zza(bArr2, j, (byte) charAt3);
            } else if (charAt3 < 2048 && j <= j4 - 2) {
                long j5 = j + 1;
                zziv.zza(bArr2, j, (byte) ((charAt3 >>> 6) | 960));
                j = j5 + 1;
                zziv.zza(bArr2, j5, (byte) ((charAt3 & '?') | 128));
                i6++;
            } else if ((charAt3 < 55296 || 57343 < charAt3) && j <= j4 - 3) {
                long j6 = j + 1;
                zziv.zza(bArr2, j, (byte) ((charAt3 >>> 12) | 480));
                long j7 = j6 + 1;
                zziv.zza(bArr2, j6, (byte) (((charAt3 >>> 6) & 63) | 128));
                j2 = j7 + 1;
                zziv.zza(bArr2, j7, (byte) ((charAt3 & '?') | 128));
            } else if (j <= j4 - 4) {
                int i7 = i6 + 1;
                if (i7 != length) {
                    char charAt4 = charSequence2.charAt(i7);
                    if (Character.isSurrogatePair(charAt3, charAt4)) {
                        int codePoint = Character.toCodePoint(charAt3, charAt4);
                        long j8 = j + 1;
                        zziv.zza(bArr2, j, (byte) ((codePoint >>> 18) | 240));
                        long j9 = j8 + 1;
                        zziv.zza(bArr2, j8, (byte) (((codePoint >>> 12) & 63) | 128));
                        long j10 = j9 + 1;
                        zziv.zza(bArr2, j9, (byte) (((codePoint >>> 6) & 63) | 128));
                        j = j10 + 1;
                        zziv.zza(bArr2, j10, (byte) ((codePoint & 63) | 128));
                        i6 = i7;
                        i6++;
                    }
                } else {
                    i7 = i6;
                }
                throw new zzjb(i7 - 1, length);
            } else if (55296 > charAt3 || charAt3 > 57343 || ((i3 = i6 + 1) != length && Character.isSurrogatePair(charAt3, charSequence2.charAt(i3)))) {
                StringBuilder sb2 = new StringBuilder(46);
                sb2.append("Failed writing ");
                sb2.append(charAt3);
                sb2.append(" at index ");
                sb2.append(j);
                throw new ArrayIndexOutOfBoundsException(sb2.toString());
            } else {
                throw new zzjb(i6, length);
            }
            j = j2;
            i6++;
        }
        return (int) j;
    }

    private static int zza(byte[] bArr, int i, long j, int i2) {
        switch (i2) {
            case 0:
                return zzix.zzbd(i);
            case 1:
                return zzix.zzt(i, zziv.zza(bArr, j));
            case 2:
                return zzix.zze(i, (int) zziv.zza(bArr, j), (int) zziv.zza(bArr, j + 1));
            default:
                throw new AssertionError();
        }
    }
}
