package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class zzhf<T> implements zzhv<T> {
    private static final int[] zzzj = new int[0];
    private static final Unsafe zzzk = zziv.zzjs();
    private final zzfg<?> zzaaa;
    private final zzgw zzaab;
    private final int[] zzzl;
    private final Object[] zzzm;
    private final int zzzn;
    private final int zzzo;
    private final zzhb zzzp;
    private final boolean zzzq;
    private final boolean zzzr;
    private final boolean zzzs;
    private final boolean zzzt;
    private final int[] zzzu;
    private final int zzzv;
    private final int zzzw;
    private final zzhi zzzx;
    private final zzgl zzzy;
    private final zzip<?, ?> zzzz;

    private zzhf(int[] iArr, Object[] objArr, int i, int i2, zzhb zzhb, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzhi zzhi, zzgl zzgl, zzip<?, ?> zzip, zzfg<?> zzfg, zzgw zzgw) {
        this.zzzl = iArr;
        this.zzzm = objArr;
        this.zzzn = i;
        this.zzzo = i2;
        this.zzzr = zzhb instanceof zzfs;
        this.zzzs = z;
        this.zzzq = zzfg != null && zzfg.zzf(zzhb);
        this.zzzt = false;
        this.zzzu = iArr2;
        this.zzzv = i3;
        this.zzzw = i4;
        this.zzzx = zzhi;
        this.zzzy = zzgl;
        this.zzzz = zzip;
        this.zzaaa = zzfg;
        this.zzzp = zzhb;
        this.zzaab = zzgw;
    }

    static <T> zzhf<T> zza(Class<T> cls, zzgz zzgz, zzhi zzhi, zzgl zzgl, zzip<?, ?> zzip, zzfg<?> zzfg, zzgw zzgw) {
        int i;
        int[] iArr;
        int i2;
        char c;
        char c2;
        char c3;
        char c4;
        char c5;
        int i3;
        int i4;
        int i5;
        char c6;
        char c7;
        char c8;
        int i6;
        int i7;
        int i8;
        int i9;
        Field field;
        int i10;
        char charAt;
        int i11;
        char c9;
        Field field2;
        Field field3;
        int i12;
        char charAt2;
        int i13;
        char charAt3;
        int i14;
        char charAt4;
        int i15;
        int i16;
        char charAt5;
        int i17;
        char charAt6;
        int i18;
        char charAt7;
        int i19;
        char charAt8;
        int i20;
        char charAt9;
        int i21;
        char charAt10;
        int i22;
        char charAt11;
        int i23;
        char charAt12;
        int i24;
        char charAt13;
        char charAt14;
        zzgz zzgz2 = zzgz;
        if (zzgz2 instanceof zzhp) {
            zzhp zzhp = (zzhp) zzgz2;
            char c10 = 0;
            boolean z = zzhp.zzim() == zzfs.zze.zzxo;
            String zziv = zzhp.zziv();
            int length = zziv.length();
            char charAt15 = zziv.charAt(0);
            if (charAt15 >= 55296) {
                char c11 = charAt15 & 8191;
                int i25 = 1;
                int i26 = 13;
                while (true) {
                    i = i25 + 1;
                    charAt14 = zziv.charAt(i25);
                    if (charAt14 < 55296) {
                        break;
                    }
                    c11 |= (charAt14 & 8191) << i26;
                    i26 += 13;
                    i25 = i;
                }
                charAt15 = (charAt14 << i26) | c11;
            } else {
                i = 1;
            }
            int i27 = i + 1;
            char charAt16 = zziv.charAt(i);
            if (charAt16 >= 55296) {
                char c12 = charAt16 & 8191;
                int i28 = 13;
                while (true) {
                    i24 = i27 + 1;
                    charAt13 = zziv.charAt(i27);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c12 |= (charAt13 & 8191) << i28;
                    i28 += 13;
                    i27 = i24;
                }
                charAt16 = c12 | (charAt13 << i28);
                i27 = i24;
            }
            if (charAt16 == 0) {
                iArr = zzzj;
                c5 = 0;
                c4 = 0;
                c3 = 0;
                c2 = 0;
                c = 0;
                i2 = 0;
            } else {
                int i29 = i27 + 1;
                char charAt17 = zziv.charAt(i27);
                if (charAt17 >= 55296) {
                    char c13 = charAt17 & 8191;
                    int i30 = 13;
                    while (true) {
                        i23 = i29 + 1;
                        charAt12 = zziv.charAt(i29);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c13 |= (charAt12 & 8191) << i30;
                        i30 += 13;
                        i29 = i23;
                    }
                    charAt17 = c13 | (charAt12 << i30);
                    i29 = i23;
                }
                int i31 = i29 + 1;
                char charAt18 = zziv.charAt(i29);
                if (charAt18 >= 55296) {
                    char c14 = charAt18 & 8191;
                    int i32 = 13;
                    while (true) {
                        i22 = i31 + 1;
                        charAt11 = zziv.charAt(i31);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c14 |= (charAt11 & 8191) << i32;
                        i32 += 13;
                        i31 = i22;
                    }
                    charAt18 = c14 | (charAt11 << i32);
                    i31 = i22;
                }
                int i33 = i31 + 1;
                c4 = zziv.charAt(i31);
                if (c4 >= 55296) {
                    char c15 = c4 & 8191;
                    int i34 = 13;
                    while (true) {
                        i21 = i33 + 1;
                        charAt10 = zziv.charAt(i33);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c15 |= (charAt10 & 8191) << i34;
                        i34 += 13;
                        i33 = i21;
                    }
                    c4 = c15 | (charAt10 << i34);
                    i33 = i21;
                }
                int i35 = i33 + 1;
                c3 = zziv.charAt(i33);
                if (c3 >= 55296) {
                    char c16 = c3 & 8191;
                    int i36 = 13;
                    while (true) {
                        i20 = i35 + 1;
                        charAt9 = zziv.charAt(i35);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c16 |= (charAt9 & 8191) << i36;
                        i36 += 13;
                        i35 = i20;
                    }
                    c3 = c16 | (charAt9 << i36);
                    i35 = i20;
                }
                int i37 = i35 + 1;
                c2 = zziv.charAt(i35);
                if (c2 >= 55296) {
                    char c17 = c2 & 8191;
                    int i38 = 13;
                    while (true) {
                        i19 = i37 + 1;
                        charAt8 = zziv.charAt(i37);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c17 |= (charAt8 & 8191) << i38;
                        i38 += 13;
                        i37 = i19;
                    }
                    c2 = c17 | (charAt8 << i38);
                    i37 = i19;
                }
                int i39 = i37 + 1;
                char charAt19 = zziv.charAt(i37);
                if (charAt19 >= 55296) {
                    char c18 = charAt19 & 8191;
                    int i40 = 13;
                    while (true) {
                        i18 = i39 + 1;
                        charAt7 = zziv.charAt(i39);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c18 |= (charAt7 & 8191) << i40;
                        i40 += 13;
                        i39 = i18;
                    }
                    charAt19 = c18 | (charAt7 << i40);
                    i39 = i18;
                }
                int i41 = i39 + 1;
                char charAt20 = zziv.charAt(i39);
                if (charAt20 >= 55296) {
                    int i42 = 13;
                    int i43 = i41;
                    char c19 = charAt20 & 8191;
                    int i44 = i43;
                    while (true) {
                        i17 = i44 + 1;
                        charAt6 = zziv.charAt(i44);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c19 |= (charAt6 & 8191) << i42;
                        i42 += 13;
                        i44 = i17;
                    }
                    charAt20 = c19 | (charAt6 << i42);
                    i15 = i17;
                } else {
                    i15 = i41;
                }
                int i45 = i15 + 1;
                char charAt21 = zziv.charAt(i15);
                if (charAt21 >= 55296) {
                    int i46 = 13;
                    int i47 = i45;
                    char c20 = charAt21 & 8191;
                    int i48 = i47;
                    while (true) {
                        i16 = i48 + 1;
                        charAt5 = zziv.charAt(i48);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c20 |= (charAt5 & 8191) << i46;
                        i46 += 13;
                        i48 = i16;
                    }
                    charAt21 = c20 | (charAt5 << i46);
                    i45 = i16;
                }
                char c21 = charAt19;
                c = charAt21;
                c10 = c21;
                int i49 = (charAt17 << 1) + charAt18;
                c5 = charAt17;
                i27 = i45;
                iArr = new int[(charAt21 + charAt19 + charAt20)];
                i2 = i49;
            }
            Unsafe unsafe = zzzk;
            Object[] zziw = zzhp.zziw();
            Class<?> cls2 = zzhp.zzio().getClass();
            int[] iArr2 = new int[(c2 * 3)];
            Object[] objArr = new Object[(c2 << 1)];
            int i50 = c10 + c;
            int i51 = i50;
            char c22 = c;
            int i52 = i2;
            int i53 = 0;
            int i54 = 0;
            while (i27 < length) {
                int i55 = i27 + 1;
                int charAt22 = zziv.charAt(i27);
                int i56 = length;
                char c23 = 55296;
                if (charAt22 >= 55296) {
                    int i57 = 13;
                    int i58 = i55;
                    int i59 = charAt22 & 8191;
                    int i60 = i58;
                    while (true) {
                        i14 = i60 + 1;
                        charAt4 = zziv.charAt(i60);
                        if (charAt4 < c23) {
                            break;
                        }
                        i59 |= (charAt4 & 8191) << i57;
                        i57 += 13;
                        i60 = i14;
                        c23 = 55296;
                    }
                    charAt22 = i59 | (charAt4 << i57);
                    i3 = i14;
                } else {
                    i3 = i55;
                }
                int i61 = i3 + 1;
                char charAt23 = zziv.charAt(i3);
                int i62 = i50;
                char c24 = 55296;
                if (charAt23 >= 55296) {
                    int i63 = 13;
                    int i64 = i61;
                    char c25 = charAt23 & 8191;
                    int i65 = i64;
                    while (true) {
                        i13 = i65 + 1;
                        charAt3 = zziv.charAt(i65);
                        if (charAt3 < c24) {
                            break;
                        }
                        c25 |= (charAt3 & 8191) << i63;
                        i63 += 13;
                        i65 = i13;
                        c24 = 55296;
                    }
                    charAt23 = c25 | (charAt3 << i63);
                    i4 = i13;
                } else {
                    i4 = i61;
                }
                char c26 = c;
                char c27 = charAt23 & 255;
                boolean z2 = z;
                if ((charAt23 & 1024) != 0) {
                    iArr[i53] = i54;
                    i53++;
                }
                int i66 = i53;
                if (c27 >= '3') {
                    int i67 = i4 + 1;
                    char charAt24 = zziv.charAt(i4);
                    char c28 = 55296;
                    if (charAt24 >= 55296) {
                        char c29 = charAt24 & 8191;
                        int i68 = 13;
                        while (true) {
                            i12 = i67 + 1;
                            charAt2 = zziv.charAt(i67);
                            if (charAt2 < c28) {
                                break;
                            }
                            c29 |= (charAt2 & 8191) << i68;
                            i68 += 13;
                            i67 = i12;
                            c28 = 55296;
                        }
                        charAt24 = c29 | (charAt2 << i68);
                        i67 = i12;
                    }
                    int i69 = c27 - '3';
                    int i70 = i67;
                    if (i69 == 9 || i69 == 17) {
                        c9 = 1;
                        objArr[((i54 / 3) << 1) + 1] = zziw[i52];
                        i52++;
                    } else {
                        if (i69 == 12 && (charAt15 & 1) == 1) {
                            objArr[((i54 / 3) << 1) + 1] = zziw[i52];
                            i52++;
                        }
                        c9 = 1;
                    }
                    int i71 = charAt24 << c9;
                    Object obj = zziw[i71];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls2, (String) obj);
                        zziw[i71] = field2;
                    }
                    c8 = c3;
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i72 = i71 + 1;
                    Object obj2 = zziw[i72];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls2, (String) obj2);
                        zziw[i72] = field3;
                    }
                    c6 = c5;
                    c7 = c4;
                    i5 = i70;
                    i6 = objectFieldOffset;
                    i7 = (int) unsafe.objectFieldOffset(field3);
                    i8 = 0;
                } else {
                    c8 = c3;
                    int i73 = i52 + 1;
                    Field zza = zza(cls2, (String) zziw[i52]);
                    if (c27 == 9 || c27 == 17) {
                        c7 = c4;
                        objArr[((i54 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c27 == 27 || c27 == '1') {
                            c7 = c4;
                            i11 = i73 + 1;
                            objArr[((i54 / 3) << 1) + 1] = zziw[i73];
                        } else if (c27 == 12 || c27 == 30 || c27 == ',') {
                            c7 = c4;
                            if ((charAt15 & 1) == 1) {
                                i11 = i73 + 1;
                                objArr[((i54 / 3) << 1) + 1] = zziw[i73];
                            }
                        } else if (c27 == '2') {
                            int i74 = c22 + 1;
                            iArr[c22] = i54;
                            int i75 = (i54 / 3) << 1;
                            int i76 = i73 + 1;
                            objArr[i75] = zziw[i73];
                            if ((charAt23 & 2048) != 0) {
                                i73 = i76 + 1;
                                objArr[i75 + 1] = zziw[i76];
                                c7 = c4;
                                c22 = i74;
                            } else {
                                c7 = c4;
                                i73 = i76;
                                c22 = i74;
                            }
                        } else {
                            c7 = c4;
                        }
                        i73 = i11;
                    }
                    int i77 = i73;
                    i6 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt15 & 1) != 1 || c27 > 17) {
                        c6 = c5;
                        i5 = i4;
                        i8 = 0;
                        i7 = 0;
                    } else {
                        int i78 = i4 + 1;
                        char charAt25 = zziv.charAt(i4);
                        if (charAt25 >= 55296) {
                            char c30 = charAt25 & 8191;
                            int i79 = 13;
                            while (true) {
                                i10 = i78 + 1;
                                charAt = zziv.charAt(i78);
                                if (charAt < 55296) {
                                    break;
                                }
                                c30 |= (charAt & 8191) << i79;
                                i79 += 13;
                                i78 = i10;
                            }
                            charAt25 = c30 | (charAt << i79);
                            i78 = i10;
                        }
                        int i80 = (c5 << 1) + (charAt25 / ' ');
                        Object obj3 = zziw[i80];
                        if (obj3 instanceof Field) {
                            field = (Field) obj3;
                        } else {
                            field = zza(cls2, (String) obj3);
                            zziw[i80] = field;
                        }
                        c6 = c5;
                        i5 = i78;
                        i7 = (int) unsafe.objectFieldOffset(field);
                        i8 = charAt25 % ' ';
                    }
                    if (c27 >= 18 && c27 <= '1') {
                        iArr[i51] = i6;
                        i51++;
                    }
                    i52 = i77;
                }
                int i81 = i54 + 1;
                iArr2[i54] = charAt22;
                int i82 = i81 + 1;
                if ((charAt23 & 512) != 0) {
                    i9 = 536870912;
                } else {
                    i9 = 0;
                }
                iArr2[i81] = ((charAt23 & 256) != 0 ? 268435456 : 0) | i9 | (c27 << 20) | i6;
                i54 = i82 + 1;
                iArr2[i82] = (i8 << 20) | i7;
                length = i56;
                i50 = i62;
                c = c26;
                z = z2;
                i53 = i66;
                c3 = c8;
                c4 = c7;
                c5 = c6;
                i27 = i5;
            }
            boolean z3 = z;
            char c31 = c;
            return new zzhf(iArr2, objArr, c4, c3, zzhp.zzio(), z, false, iArr, c, i50, zzhi, zzgl, zzip, zzfg, zzgw);
        }
        ((zzii) zzgz2).zzim();
        throw new NoSuchMethodError();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException e) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    public final T newInstance() {
        return this.zzzx.newInstance(this.zzzp);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0072, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzhx.zzd(com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6), com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)) != false) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0086, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzl(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzl(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0098, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00ac, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzl(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzl(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00be, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00d0, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00e2, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f8, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzhx.zzd(com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6), com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)) != false) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x010e, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzhx.zzd(com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6), com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)) != false) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0124, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzhx.zzd(com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6), com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)) != false) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0136, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzm(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzm(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0148, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x015c, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzl(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzl(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x016e, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0181, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzl(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzl(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x0194, code lost:
        if (com.google.android.gms.internal.firebase_auth.zziv.zzl(r10, r6) == com.google.android.gms.internal.firebase_auth.zziv.zzl(r11, r6)) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01ad, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_auth.zziv.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.firebase_auth.zziv.zzn(r11, r6))) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01c8, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_auth.zziv.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.firebase_auth.zziv.zzo(r11, r6))) goto L_0x01ce;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:83:0x01cb, code lost:
        r3 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003e, code lost:
        if (com.google.android.gms.internal.firebase_auth.zzhx.zzd(com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6), com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)) != false) goto L_0x01ce;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzzl
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01d5
            int r4 = r9.zzaw(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01b0;
                case 1: goto L_0x0197;
                case 2: goto L_0x0184;
                case 3: goto L_0x0171;
                case 4: goto L_0x0160;
                case 5: goto L_0x014c;
                case 6: goto L_0x013a;
                case 7: goto L_0x0128;
                case 8: goto L_0x0112;
                case 9: goto L_0x00fc;
                case 10: goto L_0x00e6;
                case 11: goto L_0x00d4;
                case 12: goto L_0x00c2;
                case 13: goto L_0x00b0;
                case 14: goto L_0x009c;
                case 15: goto L_0x008a;
                case 16: goto L_0x0076;
                case 17: goto L_0x0060;
                case 18: goto L_0x0051;
                case 19: goto L_0x0051;
                case 20: goto L_0x0051;
                case 21: goto L_0x0051;
                case 22: goto L_0x0051;
                case 23: goto L_0x0051;
                case 24: goto L_0x0051;
                case 25: goto L_0x0051;
                case 26: goto L_0x0051;
                case 27: goto L_0x0051;
                case 28: goto L_0x0051;
                case 29: goto L_0x0051;
                case 30: goto L_0x0051;
                case 31: goto L_0x0051;
                case 32: goto L_0x0051;
                case 33: goto L_0x0051;
                case 34: goto L_0x0051;
                case 35: goto L_0x0051;
                case 36: goto L_0x0051;
                case 37: goto L_0x0051;
                case 38: goto L_0x0051;
                case 39: goto L_0x0051;
                case 40: goto L_0x0051;
                case 41: goto L_0x0051;
                case 42: goto L_0x0051;
                case 43: goto L_0x0051;
                case 44: goto L_0x0051;
                case 45: goto L_0x0051;
                case 46: goto L_0x0051;
                case 47: goto L_0x0051;
                case 48: goto L_0x0051;
                case 49: goto L_0x0051;
                case 50: goto L_0x0042;
                case 51: goto L_0x0020;
                case 52: goto L_0x0020;
                case 53: goto L_0x0020;
                case 54: goto L_0x0020;
                case 55: goto L_0x0020;
                case 56: goto L_0x0020;
                case 57: goto L_0x0020;
                case 58: goto L_0x0020;
                case 59: goto L_0x0020;
                case 60: goto L_0x0020;
                case 61: goto L_0x0020;
                case 62: goto L_0x0020;
                case 63: goto L_0x0020;
                case 64: goto L_0x0020;
                case 65: goto L_0x0020;
                case 66: goto L_0x0020;
                case 67: goto L_0x0020;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x01cd
        L_0x0020:
            int r4 = r9.zzax(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r4)
            if (r8 != r4) goto L_0x0040
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01cd
        L_0x0040:
            goto L_0x01cb
        L_0x0042:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzd((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01ce
        L_0x0051:
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzd((java.lang.Object) r3, (java.lang.Object) r4)
            goto L_0x01ce
        L_0x0060:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x0074
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01cd
        L_0x0074:
            goto L_0x01cb
        L_0x0076:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x0088
            long r4 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01cd
        L_0x0088:
            goto L_0x01cb
        L_0x008a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x009a
            int r4 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01cd
        L_0x009a:
            goto L_0x01cb
        L_0x009c:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x00ae
            long r4 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01cd
        L_0x00ae:
            goto L_0x01cb
        L_0x00b0:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x00c0
            int r4 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01cd
        L_0x00c0:
            goto L_0x01cb
        L_0x00c2:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x00d2
            int r4 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01cd
        L_0x00d2:
            goto L_0x01cb
        L_0x00d4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x00e4
            int r4 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01cd
        L_0x00e4:
            goto L_0x01cb
        L_0x00e6:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x00fa
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01cd
        L_0x00fa:
            goto L_0x01cb
        L_0x00fc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x0110
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01cd
        L_0x0110:
            goto L_0x01cb
        L_0x0112:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x0126
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzd((java.lang.Object) r4, (java.lang.Object) r5)
            if (r4 != 0) goto L_0x01cd
        L_0x0126:
            goto L_0x01cb
        L_0x0128:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x0138
            boolean r4 = com.google.android.gms.internal.firebase_auth.zziv.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.firebase_auth.zziv.zzm(r11, r6)
            if (r4 == r5) goto L_0x01cd
        L_0x0138:
            goto L_0x01cb
        L_0x013a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x014a
            int r4 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01cd
        L_0x014a:
            goto L_0x01cb
        L_0x014c:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x015e
            long r4 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01cd
        L_0x015e:
            goto L_0x01cb
        L_0x0160:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x0170
            int r4 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r11, r6)
            if (r4 == r5) goto L_0x01cd
        L_0x0170:
            goto L_0x01cb
        L_0x0171:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x0183
            long r4 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01cd
        L_0x0183:
            goto L_0x01cb
        L_0x0184:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x0196
            long r4 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01cd
        L_0x0196:
            goto L_0x01cb
        L_0x0197:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01af
            float r4 = com.google.android.gms.internal.firebase_auth.zziv.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.firebase_auth.zziv.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01cd
        L_0x01af:
            goto L_0x01cb
        L_0x01b0:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01ca
            double r4 = com.google.android.gms.internal.firebase_auth.zziv.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.firebase_auth.zziv.zzo(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01cd
        L_0x01ca:
        L_0x01cb:
            r3 = 0
            goto L_0x01ce
        L_0x01cd:
        L_0x01ce:
            if (r3 != 0) goto L_0x01d1
            return r1
        L_0x01d1:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01d5:
            com.google.android.gms.internal.firebase_auth.zzip<?, ?> r0 = r9.zzzz
            java.lang.Object r0 = r0.zzs(r10)
            com.google.android.gms.internal.firebase_auth.zzip<?, ?> r2 = r9.zzzz
            java.lang.Object r2 = r2.zzs(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01e8
            return r1
        L_0x01e8:
            boolean r0 = r9.zzzq
            if (r0 == 0) goto L_0x01fd
            com.google.android.gms.internal.firebase_auth.zzfg<?> r0 = r9.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfj r10 = r0.zzd(r10)
            com.google.android.gms.internal.firebase_auth.zzfg<?> r0 = r9.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfj r11 = r0.zzd(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01fd:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhf.equals(java.lang.Object, java.lang.Object):boolean");
    }

    public final int hashCode(T t) {
        int length = this.zzzl.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2 += 3) {
            int zzaw = zzaw(i2);
            int i3 = this.zzzl[i2];
            long j = (long) (1048575 & zzaw);
            int i4 = 37;
            switch ((zzaw & 267386880) >>> 20) {
                case 0:
                    i = (i * 53) + zzfu.zzk(Double.doubleToLongBits(zziv.zzo(t, j)));
                    break;
                case 1:
                    i = (i * 53) + Float.floatToIntBits(zziv.zzn(t, j));
                    break;
                case 2:
                    i = (i * 53) + zzfu.zzk(zziv.zzl(t, j));
                    break;
                case 3:
                    i = (i * 53) + zzfu.zzk(zziv.zzl(t, j));
                    break;
                case 4:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 5:
                    i = (i * 53) + zzfu.zzk(zziv.zzl(t, j));
                    break;
                case 6:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 7:
                    i = (i * 53) + zzfu.zzu(zziv.zzm(t, j));
                    break;
                case 8:
                    i = (i * 53) + ((String) zziv.zzp(t, j)).hashCode();
                    break;
                case 9:
                    Object zzp = zziv.zzp(t, j);
                    if (zzp != null) {
                        i4 = zzp.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 10:
                    i = (i * 53) + zziv.zzp(t, j).hashCode();
                    break;
                case 11:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 12:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 13:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 14:
                    i = (i * 53) + zzfu.zzk(zziv.zzl(t, j));
                    break;
                case 15:
                    i = (i * 53) + zziv.zzk(t, j);
                    break;
                case 16:
                    i = (i * 53) + zzfu.zzk(zziv.zzl(t, j));
                    break;
                case 17:
                    Object zzp2 = zziv.zzp(t, j);
                    if (zzp2 != null) {
                        i4 = zzp2.hashCode();
                    }
                    i = (i * 53) + i4;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i = (i * 53) + zziv.zzp(t, j).hashCode();
                    break;
                case 50:
                    i = (i * 53) + zziv.zzp(t, j).hashCode();
                    break;
                case 51:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfu.zzk(Double.doubleToLongBits(zzf(t, j)));
                        break;
                    }
                case 52:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + Float.floatToIntBits(zzg(t, j));
                        break;
                    }
                case 53:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfu.zzk(zzi(t, j));
                        break;
                    }
                case 54:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfu.zzk(zzi(t, j));
                        break;
                    }
                case 55:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 56:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfu.zzk(zzi(t, j));
                        break;
                    }
                case 57:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 58:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfu.zzu(zzj(t, j));
                        break;
                    }
                case 59:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + ((String) zziv.zzp(t, j)).hashCode();
                        break;
                    }
                case 60:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zziv.zzp(t, j).hashCode();
                        break;
                    }
                case 61:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zziv.zzp(t, j).hashCode();
                        break;
                    }
                case 62:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 63:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 64:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 65:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfu.zzk(zzi(t, j));
                        break;
                    }
                case 66:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzh(t, j);
                        break;
                    }
                case 67:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zzfu.zzk(zzi(t, j));
                        break;
                    }
                case 68:
                    if (!zza(t, i3, i2)) {
                        break;
                    } else {
                        i = (i * 53) + zziv.zzp(t, j).hashCode();
                        break;
                    }
            }
        }
        int hashCode = (i * 53) + this.zzzz.zzs(t).hashCode();
        if (this.zzzq) {
            return (hashCode * 53) + this.zzaaa.zzd(t).hashCode();
        }
        return hashCode;
    }

    public final void zzc(T t, T t2) {
        if (t2 == null) {
            throw new NullPointerException();
        }
        for (int i = 0; i < this.zzzl.length; i += 3) {
            int zzaw = zzaw(i);
            long j = (long) (1048575 & zzaw);
            int i2 = this.zzzl[i];
            switch ((zzaw & 267386880) >>> 20) {
                case 0:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzo(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 1:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzn(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 2:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzl(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 3:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzl(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 4:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 5:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzl(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 6:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 7:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzm(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 8:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzp(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 9:
                    zza(t, t2, i);
                    break;
                case 10:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzp(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 11:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 12:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 13:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 14:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzl(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 15:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zzb((Object) t, j, zziv.zzk(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 16:
                    if (!zza(t2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzl(t2, j));
                        zzb(t, i);
                        break;
                    }
                case 17:
                    zza(t, t2, i);
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    this.zzzy.zza(t, t2, j);
                    break;
                case 50:
                    zzhx.zza(this.zzaab, t, t2, j);
                    break;
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                    if (!zza(t2, i2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzp(t2, j));
                        zzb(t, i2, i);
                        break;
                    }
                case 60:
                    zzb(t, t2, i);
                    break;
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                    if (!zza(t2, i2, i)) {
                        break;
                    } else {
                        zziv.zza((Object) t, j, zziv.zzp(t2, j));
                        zzb(t, i2, i);
                        break;
                    }
                case 68:
                    zzb(t, t2, i);
                    break;
            }
        }
        if (!this.zzzs) {
            zzhx.zza(this.zzzz, t, t2);
            if (this.zzzq) {
                zzhx.zza(this.zzaaa, t, t2);
            }
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzaw = (long) (zzaw(i) & 1048575);
        if (zza(t2, i)) {
            Object zzp = zziv.zzp(t, zzaw);
            Object zzp2 = zziv.zzp(t2, zzaw);
            if (zzp != null && zzp2 != null) {
                zziv.zza((Object) t, zzaw, zzfu.zza(zzp, zzp2));
                zzb(t, i);
            } else if (zzp2 != null) {
                zziv.zza((Object) t, zzaw, zzp2);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzaw = zzaw(i);
        int i2 = this.zzzl[i];
        long j = (long) (zzaw & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zziv.zzp(t, j);
            Object zzp2 = zziv.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zziv.zza((Object) t, j, zzfu.zza(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zziv.zza((Object) t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:412:0x0a25, code lost:
        r18 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:472:0x0b4a, code lost:
        r3 = r3 + 3;
        r9 = r18;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzp(T r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = r22
            boolean r2 = r0.zzzs
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r6 = 0
            r7 = 1
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x058a
            sun.misc.Unsafe r2 = zzzk
            r12 = 0
            r13 = 0
        L_0x0017:
            int[] r14 = r0.zzzl
            int r14 = r14.length
            if (r12 >= r14) goto L_0x0582
            int r14 = r0.zzaw(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzzl
            r3 = r3[r12]
            r14 = r14 & r8
            long r4 = (long) r14
            com.google.android.gms.internal.firebase_auth.zzfm r14 = com.google.android.gms.internal.firebase_auth.zzfm.DOUBLE_LIST_PACKED
            int r14 = r14.mo11584id()
            if (r15 < r14) goto L_0x0048
            com.google.android.gms.internal.firebase_auth.zzfm r14 = com.google.android.gms.internal.firebase_auth.zzfm.SINT64_LIST_PACKED
            int r14 = r14.mo11584id()
            if (r15 > r14) goto L_0x0048
            int[] r14 = r0.zzzl
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r8
            goto L_0x004a
        L_0x0048:
            r14 = 0
        L_0x004a:
            switch(r15) {
                case 0: goto L_0x056f;
                case 1: goto L_0x0563;
                case 2: goto L_0x0553;
                case 3: goto L_0x0542;
                case 4: goto L_0x0532;
                case 5: goto L_0x0526;
                case 6: goto L_0x051a;
                case 7: goto L_0x050e;
                case 8: goto L_0x04ee;
                case 9: goto L_0x04d9;
                case 10: goto L_0x04c6;
                case 11: goto L_0x04b5;
                case 12: goto L_0x04a4;
                case 13: goto L_0x0497;
                case 14: goto L_0x048a;
                case 15: goto L_0x0479;
                case 16: goto L_0x0467;
                case 17: goto L_0x044f;
                case 18: goto L_0x0444;
                case 19: goto L_0x0439;
                case 20: goto L_0x042e;
                case 21: goto L_0x0423;
                case 22: goto L_0x0418;
                case 23: goto L_0x040d;
                case 24: goto L_0x0402;
                case 25: goto L_0x03f7;
                case 26: goto L_0x03ec;
                case 27: goto L_0x03dc;
                case 28: goto L_0x03d1;
                case 29: goto L_0x03c6;
                case 30: goto L_0x03bb;
                case 31: goto L_0x03b0;
                case 32: goto L_0x03a5;
                case 33: goto L_0x039a;
                case 34: goto L_0x038f;
                case 35: goto L_0x036c;
                case 36: goto L_0x0349;
                case 37: goto L_0x0326;
                case 38: goto L_0x0303;
                case 39: goto L_0x02e0;
                case 40: goto L_0x02bd;
                case 41: goto L_0x029a;
                case 42: goto L_0x0277;
                case 43: goto L_0x0254;
                case 44: goto L_0x0231;
                case 45: goto L_0x020e;
                case 46: goto L_0x01eb;
                case 47: goto L_0x01c8;
                case 48: goto L_0x01a5;
                case 49: goto L_0x0195;
                case 50: goto L_0x0184;
                case 51: goto L_0x0175;
                case 52: goto L_0x0168;
                case 53: goto L_0x0157;
                case 54: goto L_0x0146;
                case 55: goto L_0x0135;
                case 56: goto L_0x0128;
                case 57: goto L_0x011b;
                case 58: goto L_0x010e;
                case 59: goto L_0x00ee;
                case 60: goto L_0x00d9;
                case 61: goto L_0x00c5;
                case 62: goto L_0x00b4;
                case 63: goto L_0x00a3;
                case 64: goto L_0x0096;
                case 65: goto L_0x0089;
                case 66: goto L_0x0078;
                case 67: goto L_0x0067;
                case 68: goto L_0x004f;
                default: goto L_0x004d;
            }
        L_0x004d:
            goto L_0x057c
        L_0x004f:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x057c
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhb r4 = (com.google.android.gms.internal.firebase_auth.zzhb) r4
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzc(r3, r4, r5)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0067:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x057c
            long r4 = zzi(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzf((int) r3, (long) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0078:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x057c
            int r4 = zzh(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzm(r3, r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0089:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzh((int) r3, (long) r9)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0096:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzo(r3, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x00a3:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x057c
            int r4 = zzh(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzp(r3, r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x00b4:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x057c
            int r4 = zzh(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzl(r3, r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x00c5:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x057c
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r3, (com.google.android.gms.internal.firebase_auth.zzeh) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x00d9:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x057c
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzc((int) r3, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzhv) r5)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x00ee:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x057c
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r1, r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.firebase_auth.zzeh
            if (r5 == 0) goto L_0x0105
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r3, (com.google.android.gms.internal.firebase_auth.zzeh) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0105:
            java.lang.String r4 = (java.lang.String) r4
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r3, (java.lang.String) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x010e:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r3, (boolean) r7)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x011b:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzn(r3, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0128:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzg((int) r3, (long) r9)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0135:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x057c
            int r4 = zzh(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzk(r3, r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0146:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x057c
            long r4 = zzi(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zze(r3, r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0157:
            boolean r14 = r0.zza(r1, (int) r3, (int) r12)
            if (r14 == 0) goto L_0x057c
            long r4 = zzi(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzd((int) r3, (long) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0168:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r3, (float) r6)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0175:
            boolean r4 = r0.zza(r1, (int) r3, (int) r12)
            if (r4 == 0) goto L_0x057c
            r4 = 0
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r3, (double) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0184:
            com.google.android.gms.internal.firebase_auth.zzgw r14 = r0.zzaab
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r1, r4)
            java.lang.Object r5 = r0.zzau(r12)
            int r3 = r14.zzb(r3, r4, r5)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0195:
            java.util.List r4 = zze(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzd(r3, r4, r5)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x01a5:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzv((java.util.List<java.lang.Long>) r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x01ba
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x01ba:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x01c8:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzz(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x01dd
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x01dd:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x01eb:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzab(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x0200
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x0200:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x020e:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzaa(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x0223
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x0223:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0231:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzw(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x0246
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x0246:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0254:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzy(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x0269
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x0269:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0277:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzac(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x028c
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x028c:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x029a:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzaa(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x02af
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x02af:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x02bd:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzab(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x02d2
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x02d2:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x02e0:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzx(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x02f5
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x02f5:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0303:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzu(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x0318
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x0318:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0326:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzt(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x033b
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x033b:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0349:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzaa(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x035e
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x035e:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x036c:
            java.lang.Object r4 = r2.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.firebase_auth.zzhx.zzab(r4)
            if (r4 <= 0) goto L_0x057c
            boolean r5 = r0.zzzt
            if (r5 == 0) goto L_0x0381
            long r14 = (long) r14
            r2.putInt(r1, r14, r4)
        L_0x0381:
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r3)
            int r5 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r4)
            int r3 = r3 + r5
            int r3 = r3 + r4
            int r13 = r13 + r3
            goto L_0x057c
        L_0x038f:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzq(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x039a:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzu(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x03a5:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzw(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x03b0:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzv(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x03bb:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzr(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x03c6:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzt(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x03d1:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzd((int) r3, (java.util.List<com.google.android.gms.internal.firebase_auth.zzeh>) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x03dc:
            java.util.List r4 = zze(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzc((int) r3, (java.util.List<?>) r4, (com.google.android.gms.internal.firebase_auth.zzhv) r5)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x03ec:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzc(r3, r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x03f7:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzx(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0402:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzv(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x040d:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzw(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0418:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzs(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0423:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzp(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x042e:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzo(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0439:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzv(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0444:
            java.util.List r4 = zze(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzw(r3, r4, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x044f:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x057c
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhb r4 = (com.google.android.gms.internal.firebase_auth.zzhb) r4
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzc(r3, r4, r5)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0467:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x057c
            long r4 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzf((int) r3, (long) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0479:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x057c
            int r4 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzm(r3, r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x048a:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzh((int) r3, (long) r9)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0497:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzo(r3, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x04a4:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x057c
            int r4 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzp(r3, r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x04b5:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x057c
            int r4 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzl(r3, r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x04c6:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x057c
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r3, (com.google.android.gms.internal.firebase_auth.zzeh) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x04d9:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x057c
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            int r3 = com.google.android.gms.internal.firebase_auth.zzhx.zzc((int) r3, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzhv) r5)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x04ee:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x057c
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r1, r4)
            boolean r5 = r4 instanceof com.google.android.gms.internal.firebase_auth.zzeh
            if (r5 == 0) goto L_0x0505
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r3, (com.google.android.gms.internal.firebase_auth.zzeh) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0505:
            java.lang.String r4 = (java.lang.String) r4
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r3, (java.lang.String) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x050e:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r3, (boolean) r7)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x051a:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzn(r3, r11)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0526:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzg((int) r3, (long) r9)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0532:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x057c
            int r4 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzk(r3, r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0542:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x057c
            long r4 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zze(r3, r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0553:
            boolean r14 = r0.zza(r1, (int) r12)
            if (r14 == 0) goto L_0x057c
            long r4 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r1, r4)
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzd((int) r3, (long) r4)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x0563:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x057c
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r3, (float) r6)
            int r13 = r13 + r3
            goto L_0x057c
        L_0x056f:
            boolean r4 = r0.zza(r1, (int) r12)
            if (r4 == 0) goto L_0x057c
            r4 = 0
            int r3 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r3, (double) r4)
            int r13 = r13 + r3
        L_0x057c:
            int r12 = r12 + 3
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0017
        L_0x0582:
            com.google.android.gms.internal.firebase_auth.zzip<?, ?> r2 = r0.zzzz
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x058a:
            sun.misc.Unsafe r2 = zzzk
            r3 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r12 = 0
        L_0x0593:
            int[] r13 = r0.zzzl
            int r13 = r13.length
            if (r3 >= r13) goto L_0x0b52
            int r13 = r0.zzaw(r3)
            int[] r14 = r0.zzzl
            r14 = r14[r3]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r15
            int r15 = r16 >>> 20
            r6 = 17
            if (r15 > r6) goto L_0x05c6
            int[] r6 = r0.zzzl
            int r16 = r3 + 2
            r6 = r6[r16]
            r11 = r6 & r8
            int r16 = r6 >>> 20
            int r16 = r7 << r16
            if (r11 == r5) goto L_0x05c5
            long r9 = (long) r11
            int r12 = r2.getInt(r1, r9)
            r5 = r11
        L_0x05c5:
            goto L_0x05e7
        L_0x05c6:
            boolean r6 = r0.zzzt
            if (r6 == 0) goto L_0x05e4
            com.google.android.gms.internal.firebase_auth.zzfm r6 = com.google.android.gms.internal.firebase_auth.zzfm.DOUBLE_LIST_PACKED
            int r6 = r6.mo11584id()
            if (r15 < r6) goto L_0x05e4
            com.google.android.gms.internal.firebase_auth.zzfm r6 = com.google.android.gms.internal.firebase_auth.zzfm.SINT64_LIST_PACKED
            int r6 = r6.mo11584id()
            if (r15 > r6) goto L_0x05e4
            int[] r6 = r0.zzzl
            int r9 = r3 + 2
            r6 = r6[r9]
            r11 = r6 & r8
            r6 = r11
            goto L_0x05e5
        L_0x05e4:
            r6 = 0
        L_0x05e5:
            r16 = 0
        L_0x05e7:
            r9 = r13 & r8
            long r9 = (long) r9
            switch(r15) {
                case 0: goto L_0x0b3b;
                case 1: goto L_0x0b2b;
                case 2: goto L_0x0b19;
                case 3: goto L_0x0b08;
                case 4: goto L_0x0af7;
                case 5: goto L_0x0ae8;
                case 6: goto L_0x0adc;
                case 7: goto L_0x0ad1;
                case 8: goto L_0x0ab3;
                case 9: goto L_0x0aa0;
                case 10: goto L_0x0a90;
                case 11: goto L_0x0a82;
                case 12: goto L_0x0a74;
                case 13: goto L_0x0a69;
                case 14: goto L_0x0a5d;
                case 15: goto L_0x0a4f;
                case 16: goto L_0x0a41;
                case 17: goto L_0x0a2c;
                case 18: goto L_0x0a17;
                case 19: goto L_0x0a0a;
                case 20: goto L_0x09fd;
                case 21: goto L_0x09f0;
                case 22: goto L_0x09e3;
                case 23: goto L_0x09d6;
                case 24: goto L_0x09c9;
                case 25: goto L_0x09bb;
                case 26: goto L_0x09ae;
                case 27: goto L_0x099c;
                case 28: goto L_0x098e;
                case 29: goto L_0x0980;
                case 30: goto L_0x0972;
                case 31: goto L_0x0964;
                case 32: goto L_0x0956;
                case 33: goto L_0x0948;
                case 34: goto L_0x0939;
                case 35: goto L_0x0916;
                case 36: goto L_0x08f3;
                case 37: goto L_0x08d0;
                case 38: goto L_0x08ad;
                case 39: goto L_0x088a;
                case 40: goto L_0x0867;
                case 41: goto L_0x0844;
                case 42: goto L_0x0821;
                case 43: goto L_0x07fe;
                case 44: goto L_0x07db;
                case 45: goto L_0x07b8;
                case 46: goto L_0x0795;
                case 47: goto L_0x0772;
                case 48: goto L_0x074f;
                case 49: goto L_0x073d;
                case 50: goto L_0x072c;
                case 51: goto L_0x071d;
                case 52: goto L_0x070f;
                case 53: goto L_0x06fe;
                case 54: goto L_0x06ed;
                case 55: goto L_0x06dc;
                case 56: goto L_0x06cd;
                case 57: goto L_0x06bf;
                case 58: goto L_0x06b2;
                case 59: goto L_0x0692;
                case 60: goto L_0x067d;
                case 61: goto L_0x0669;
                case 62: goto L_0x0658;
                case 63: goto L_0x0647;
                case 64: goto L_0x0639;
                case 65: goto L_0x062a;
                case 66: goto L_0x0619;
                case 67: goto L_0x0608;
                case 68: goto L_0x05f0;
                default: goto L_0x05ee;
            }
        L_0x05ee:
            goto L_0x0a24
        L_0x05f0:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            java.lang.Object r6 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzhb r6 = (com.google.android.gms.internal.firebase_auth.zzhb) r6
            com.google.android.gms.internal.firebase_auth.zzhv r9 = r0.zzat(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzc(r14, r6, r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0608:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            long r9 = zzi(r1, r9)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzf((int) r14, (long) r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0619:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            int r6 = zzh(r1, r9)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzm(r14, r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x062a:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            r9 = 0
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzh((int) r14, (long) r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0639:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            r6 = 0
            int r9 = com.google.android.gms.internal.firebase_auth.zzez.zzo(r14, r6)
            int r4 = r4 + r9
            goto L_0x0a24
        L_0x0647:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            int r6 = zzh(r1, r9)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzp(r14, r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0658:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            int r6 = zzh(r1, r9)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzl(r14, r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0669:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            java.lang.Object r6 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzeh r6 = (com.google.android.gms.internal.firebase_auth.zzeh) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r14, (com.google.android.gms.internal.firebase_auth.zzeh) r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x067d:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            java.lang.Object r6 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzhv r9 = r0.zzat(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzc((int) r14, (java.lang.Object) r6, (com.google.android.gms.internal.firebase_auth.zzhv) r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0692:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            java.lang.Object r6 = r2.getObject(r1, r9)
            boolean r9 = r6 instanceof com.google.android.gms.internal.firebase_auth.zzeh
            if (r9 == 0) goto L_0x06a9
            com.google.android.gms.internal.firebase_auth.zzeh r6 = (com.google.android.gms.internal.firebase_auth.zzeh) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r14, (com.google.android.gms.internal.firebase_auth.zzeh) r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x06a9:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r14, (java.lang.String) r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x06b2:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r14, (boolean) r7)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x06bf:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            r6 = 0
            int r9 = com.google.android.gms.internal.firebase_auth.zzez.zzn(r14, r6)
            int r4 = r4 + r9
            goto L_0x0a24
        L_0x06cd:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            r9 = 0
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzg((int) r14, (long) r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x06dc:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            int r6 = zzh(r1, r9)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzk(r14, r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x06ed:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            long r9 = zzi(r1, r9)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zze(r14, r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x06fe:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            long r9 = zzi(r1, r9)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzd((int) r14, (long) r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x070f:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            r6 = 0
            int r9 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r14, (float) r6)
            int r4 = r4 + r9
            goto L_0x0a24
        L_0x071d:
            boolean r6 = r0.zza(r1, (int) r14, (int) r3)
            if (r6 == 0) goto L_0x0a24
            r9 = 0
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r14, (double) r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x072c:
            com.google.android.gms.internal.firebase_auth.zzgw r6 = r0.zzaab
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.lang.Object r10 = r0.zzau(r3)
            int r6 = r6.zzb(r14, r9, r10)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x073d:
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.firebase_auth.zzhv r9 = r0.zzat(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzd(r14, r6, r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x074f:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzv((java.util.List<java.lang.Long>) r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x0764
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x0764:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0772:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzz(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x0787
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x0787:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0795:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzab(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x07aa
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x07aa:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x07b8:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzaa(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x07cd
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x07cd:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x07db:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzw(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x07f0
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x07f0:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x07fe:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzy(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x0813
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x0813:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0821:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzac(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x0836
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x0836:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0844:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzaa(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x0859
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x0859:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0867:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzab(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x087c
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x087c:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x088a:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzx(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x089f
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x089f:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x08ad:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzu(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x08c2
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x08c2:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x08d0:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzt(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x08e5
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x08e5:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x08f3:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzaa(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x0908
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x0908:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0916:
            java.lang.Object r9 = r2.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zzhx.zzab(r9)
            if (r9 <= 0) goto L_0x0a24
            boolean r10 = r0.zzzt
            if (r10 == 0) goto L_0x092b
            long r10 = (long) r6
            r2.putInt(r1, r10, r9)
        L_0x092b:
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzaf(r14)
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzah(r9)
            int r6 = r6 + r10
            int r6 = r6 + r9
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0939:
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            r11 = 0
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzq(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0948:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzu(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0956:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzw(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0964:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzv(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0972:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzr(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0980:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzt(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x098e:
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzd((int) r14, (java.util.List<com.google.android.gms.internal.firebase_auth.zzeh>) r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x099c:
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            com.google.android.gms.internal.firebase_auth.zzhv r9 = r0.zzat(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzc((int) r14, (java.util.List<?>) r6, (com.google.android.gms.internal.firebase_auth.zzhv) r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x09ae:
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzc(r14, r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x09bb:
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            r11 = 0
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzx(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x09c9:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzv(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x09d6:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzw(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x09e3:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzs(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x09f0:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzp(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x09fd:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzo(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0a0a:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzv(r14, r6, r11)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0a17:
            r11 = 0
            java.lang.Object r6 = r2.getObject(r1, r9)
            java.util.List r6 = (java.util.List) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzw(r14, r6, r11)
            int r4 = r4 + r6
        L_0x0a24:
            r6 = 0
        L_0x0a25:
            r9 = 0
            r10 = 0
            r18 = 0
            goto L_0x0b4a
        L_0x0a2c:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            java.lang.Object r6 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzhb r6 = (com.google.android.gms.internal.firebase_auth.zzhb) r6
            com.google.android.gms.internal.firebase_auth.zzhv r9 = r0.zzat(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzc(r14, r6, r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0a41:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            long r9 = r2.getLong(r1, r9)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzf((int) r14, (long) r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0a4f:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            int r6 = r2.getInt(r1, r9)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzm(r14, r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0a5d:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            r9 = 0
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzh((int) r14, (long) r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0a69:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            r6 = 0
            int r9 = com.google.android.gms.internal.firebase_auth.zzez.zzo(r14, r6)
            int r4 = r4 + r9
            goto L_0x0a24
        L_0x0a74:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            int r6 = r2.getInt(r1, r9)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzp(r14, r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0a82:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            int r6 = r2.getInt(r1, r9)
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzl(r14, r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0a90:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            java.lang.Object r6 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzeh r6 = (com.google.android.gms.internal.firebase_auth.zzeh) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r14, (com.google.android.gms.internal.firebase_auth.zzeh) r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0aa0:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            java.lang.Object r6 = r2.getObject(r1, r9)
            com.google.android.gms.internal.firebase_auth.zzhv r9 = r0.zzat(r3)
            int r6 = com.google.android.gms.internal.firebase_auth.zzhx.zzc((int) r14, (java.lang.Object) r6, (com.google.android.gms.internal.firebase_auth.zzhv) r9)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0ab3:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            java.lang.Object r6 = r2.getObject(r1, r9)
            boolean r9 = r6 instanceof com.google.android.gms.internal.firebase_auth.zzeh
            if (r9 == 0) goto L_0x0ac8
            com.google.android.gms.internal.firebase_auth.zzeh r6 = (com.google.android.gms.internal.firebase_auth.zzeh) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r14, (com.google.android.gms.internal.firebase_auth.zzeh) r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0ac8:
            java.lang.String r6 = (java.lang.String) r6
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r14, (java.lang.String) r6)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0ad1:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            int r6 = com.google.android.gms.internal.firebase_auth.zzez.zzc((int) r14, (boolean) r7)
            int r4 = r4 + r6
            goto L_0x0a24
        L_0x0adc:
            r6 = r12 & r16
            if (r6 == 0) goto L_0x0a24
            r6 = 0
            int r9 = com.google.android.gms.internal.firebase_auth.zzez.zzn(r14, r6)
            int r4 = r4 + r9
            goto L_0x0a25
        L_0x0ae8:
            r6 = 0
            r9 = r12 & r16
            if (r9 == 0) goto L_0x0a25
            r9 = 0
            int r11 = com.google.android.gms.internal.firebase_auth.zzez.zzg((int) r14, (long) r9)
            int r4 = r4 + r11
            r18 = r9
            goto L_0x0b29
        L_0x0af7:
            r6 = 0
            r18 = 0
            r11 = r12 & r16
            if (r11 == 0) goto L_0x0b29
            int r9 = r2.getInt(r1, r9)
            int r9 = com.google.android.gms.internal.firebase_auth.zzez.zzk(r14, r9)
            int r4 = r4 + r9
            goto L_0x0b29
        L_0x0b08:
            r6 = 0
            r18 = 0
            r11 = r12 & r16
            if (r11 == 0) goto L_0x0b29
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.firebase_auth.zzez.zze(r14, r9)
            int r4 = r4 + r9
            goto L_0x0b29
        L_0x0b19:
            r6 = 0
            r18 = 0
            r11 = r12 & r16
            if (r11 == 0) goto L_0x0b29
            long r9 = r2.getLong(r1, r9)
            int r9 = com.google.android.gms.internal.firebase_auth.zzez.zzd((int) r14, (long) r9)
            int r4 = r4 + r9
        L_0x0b29:
            r9 = 0
            goto L_0x0b38
        L_0x0b2b:
            r6 = 0
            r18 = 0
            r9 = r12 & r16
            if (r9 == 0) goto L_0x0b29
            r9 = 0
            int r10 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r14, (float) r9)
            int r4 = r4 + r10
        L_0x0b38:
            r10 = 0
            goto L_0x0b4a
        L_0x0b3b:
            r6 = 0
            r9 = 0
            r18 = 0
            r10 = r12 & r16
            if (r10 == 0) goto L_0x0b38
            r10 = 0
            int r13 = com.google.android.gms.internal.firebase_auth.zzez.zzb((int) r14, (double) r10)
            int r4 = r4 + r13
        L_0x0b4a:
            int r3 = r3 + 3
            r9 = r18
            r6 = 0
            r11 = 0
            goto L_0x0593
        L_0x0b52:
            com.google.android.gms.internal.firebase_auth.zzip<?, ?> r2 = r0.zzzz
            int r2 = zza(r2, r1)
            int r4 = r4 + r2
            boolean r2 = r0.zzzq
            if (r2 == 0) goto L_0x0b68
            com.google.android.gms.internal.firebase_auth.zzfg<?> r2 = r0.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfj r1 = r2.zzd(r1)
            int r1 = r1.zzgv()
            int r4 = r4 + r1
        L_0x0b68:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhf.zzp(java.lang.Object):int");
    }

    private static <UT, UB> int zza(zzip<UT, UB> zzip, T t) {
        return zzip.zzp(zzip.zzs(t));
    }

    private static <E> List<E> zze(Object obj, long j) {
        return (List) zziv.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x05aa  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x05ec  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0b5a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.firebase_auth.zzjk r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzgk()
            int r1 = com.google.android.gms.internal.firebase_auth.zzfs.zze.zzxr
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x05c1
            com.google.android.gms.internal.firebase_auth.zzip<?, ?> r0 = r13.zzzz
            zza(r0, r14, (com.google.android.gms.internal.firebase_auth.zzjk) r15)
            boolean r0 = r13.zzzq
            if (r0 == 0) goto L_0x0033
            com.google.android.gms.internal.firebase_auth.zzfg<?> r0 = r13.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfj r0 = r0.zzd(r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0033
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0035
        L_0x0033:
            r0 = r3
            r1 = r0
        L_0x0035:
            int[] r7 = r13.zzzl
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x003a:
            if (r7 < 0) goto L_0x05a8
            int r8 = r13.zzaw(r7)
            int[] r9 = r13.zzzl
            r9 = r9[r7]
        L_0x0046:
            if (r1 == 0) goto L_0x0064
            com.google.android.gms.internal.firebase_auth.zzfg<?> r10 = r13.zzaaa
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0064
            com.google.android.gms.internal.firebase_auth.zzfg<?> r10 = r13.zzaaa
            r10.zza((com.google.android.gms.internal.firebase_auth.zzjk) r15, (java.util.Map.Entry<?, ?>) r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0046
        L_0x0062:
            r1 = r3
            goto L_0x0046
        L_0x0064:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x0593;
                case 1: goto L_0x0581;
                case 2: goto L_0x056f;
                case 3: goto L_0x055d;
                case 4: goto L_0x054b;
                case 5: goto L_0x0539;
                case 6: goto L_0x0527;
                case 7: goto L_0x0514;
                case 8: goto L_0x0502;
                case 9: goto L_0x04ec;
                case 10: goto L_0x04d8;
                case 11: goto L_0x04c5;
                case 12: goto L_0x04b2;
                case 13: goto L_0x049f;
                case 14: goto L_0x048c;
                case 15: goto L_0x0479;
                case 16: goto L_0x0466;
                case 17: goto L_0x0450;
                case 18: goto L_0x043c;
                case 19: goto L_0x0428;
                case 20: goto L_0x0414;
                case 21: goto L_0x0400;
                case 22: goto L_0x03ec;
                case 23: goto L_0x03d8;
                case 24: goto L_0x03c4;
                case 25: goto L_0x03b0;
                case 26: goto L_0x039c;
                case 27: goto L_0x0384;
                case 28: goto L_0x0370;
                case 29: goto L_0x035c;
                case 30: goto L_0x0348;
                case 31: goto L_0x0334;
                case 32: goto L_0x0320;
                case 33: goto L_0x030c;
                case 34: goto L_0x02f8;
                case 35: goto L_0x02e4;
                case 36: goto L_0x02d0;
                case 37: goto L_0x02bc;
                case 38: goto L_0x02a8;
                case 39: goto L_0x0294;
                case 40: goto L_0x0280;
                case 41: goto L_0x026c;
                case 42: goto L_0x0258;
                case 43: goto L_0x0244;
                case 44: goto L_0x0230;
                case 45: goto L_0x021c;
                case 46: goto L_0x0208;
                case 47: goto L_0x01f4;
                case 48: goto L_0x01e0;
                case 49: goto L_0x01c8;
                case 50: goto L_0x01bc;
                case 51: goto L_0x01aa;
                case 52: goto L_0x0198;
                case 53: goto L_0x0186;
                case 54: goto L_0x0174;
                case 55: goto L_0x0162;
                case 56: goto L_0x0150;
                case 57: goto L_0x013e;
                case 58: goto L_0x012c;
                case 59: goto L_0x011a;
                case 60: goto L_0x0104;
                case 61: goto L_0x00f0;
                case 62: goto L_0x00de;
                case 63: goto L_0x00cc;
                case 64: goto L_0x00ba;
                case 65: goto L_0x00a8;
                case 66: goto L_0x0096;
                case 67: goto L_0x0084;
                case 68: goto L_0x006e;
                default: goto L_0x006c;
            }
        L_0x006c:
            goto L_0x05a4
        L_0x006e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzhv) r10)
            goto L_0x05a4
        L_0x0084:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x05a4
        L_0x0096:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzi((int) r9, (int) r8)
            goto L_0x05a4
        L_0x00a8:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj((int) r9, (long) r10)
            goto L_0x05a4
        L_0x00ba:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzq(r9, r8)
            goto L_0x05a4
        L_0x00cc:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x05a4
        L_0x00de:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x05a4
        L_0x00f0:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzeh r8 = (com.google.android.gms.internal.firebase_auth.zzeh) r8
            r15.zza((int) r9, (com.google.android.gms.internal.firebase_auth.zzeh) r8)
            goto L_0x05a4
        L_0x0104:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzhv) r10)
            goto L_0x05a4
        L_0x011a:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzjk) r15)
            goto L_0x05a4
        L_0x012c:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zzb((int) r9, (boolean) r8)
            goto L_0x05a4
        L_0x013e:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzj((int) r9, (int) r8)
            goto L_0x05a4
        L_0x0150:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x05a4
        L_0x0162:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x05a4
        L_0x0174:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x05a4
        L_0x0186:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzi((int) r9, (long) r10)
            goto L_0x05a4
        L_0x0198:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzg(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x05a4
        L_0x01aa:
            boolean r10 = r13.zza(r14, (int) r9, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzf(r14, r10)
            r15.zza((int) r9, (double) r10)
            goto L_0x05a4
        L_0x01bc:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            r13.zza((com.google.android.gms.internal.firebase_auth.zzjk) r15, (int) r9, (java.lang.Object) r8, (int) r7)
            goto L_0x05a4
        L_0x01c8:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
            com.google.android.gms.internal.firebase_auth.zzhx.zzb((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (com.google.android.gms.internal.firebase_auth.zzhv) r10)
            goto L_0x05a4
        L_0x01e0:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x01f4:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0208:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x021c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0230:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0244:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0258:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x026c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0280:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x0294:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02a8:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02bc:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r9, r8, r15, r4)
            goto L_0x05a4
        L_0x02d0:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (boolean) r4)
            goto L_0x05a4
        L_0x02e4:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (boolean) r4)
            goto L_0x05a4
        L_0x02f8:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x030c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0320:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0334:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0348:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x035c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0370:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r9, r8, r15)
            goto L_0x05a4
        L_0x0384:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r9, (java.util.List<?>) r8, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (com.google.android.gms.internal.firebase_auth.zzhv) r10)
            goto L_0x05a4
        L_0x039c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r9, (java.util.List<java.lang.String>) r8, (com.google.android.gms.internal.firebase_auth.zzjk) r15)
            goto L_0x05a4
        L_0x03b0:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x03c4:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x03d8:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x03ec:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0400:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0414:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r9, r8, r15, r5)
            goto L_0x05a4
        L_0x0428:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zzb((int) r9, (java.util.List<java.lang.Float>) r8, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (boolean) r5)
            goto L_0x05a4
        L_0x043c:
            int[] r9 = r13.zzzl
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r9, (java.util.List<java.lang.Double>) r8, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (boolean) r5)
            goto L_0x05a4
        L_0x0450:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
            r15.zzb((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzhv) r10)
            goto L_0x05a4
        L_0x0466:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r10)
            r15.zzb((int) r9, (long) r10)
            goto L_0x05a4
        L_0x0479:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzi((int) r9, (int) r8)
            goto L_0x05a4
        L_0x048c:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r10)
            r15.zzj((int) r9, (long) r10)
            goto L_0x05a4
        L_0x049f:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzq(r9, r8)
            goto L_0x05a4
        L_0x04b2:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x05a4
        L_0x04c5:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x05a4
        L_0x04d8:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzeh r8 = (com.google.android.gms.internal.firebase_auth.zzeh) r8
            r15.zza((int) r9, (com.google.android.gms.internal.firebase_auth.zzeh) r8)
            goto L_0x05a4
        L_0x04ec:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            com.google.android.gms.internal.firebase_auth.zzhv r10 = r13.zzat(r7)
            r15.zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzhv) r10)
            goto L_0x05a4
        L_0x0502:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r10)
            zza((int) r9, (java.lang.Object) r8, (com.google.android.gms.internal.firebase_auth.zzjk) r15)
            goto L_0x05a4
        L_0x0514:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.firebase_auth.zziv.zzm(r14, r10)
            r15.zzb((int) r9, (boolean) r8)
            goto L_0x05a4
        L_0x0527:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzj((int) r9, (int) r8)
            goto L_0x05a4
        L_0x0539:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x05a4
        L_0x054b:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r10)
            r15.zzg(r9, r8)
            goto L_0x05a4
        L_0x055d:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r10)
            r15.zza((int) r9, (long) r10)
            goto L_0x05a4
        L_0x056f:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r10)
            r15.zzi((int) r9, (long) r10)
            goto L_0x05a4
        L_0x0581:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.firebase_auth.zziv.zzn(r14, r10)
            r15.zza((int) r9, (float) r8)
            goto L_0x05a4
        L_0x0593:
            boolean r10 = r13.zza(r14, (int) r7)
            if (r10 == 0) goto L_0x05a4
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.firebase_auth.zziv.zzo(r14, r10)
            r15.zza((int) r9, (double) r10)
        L_0x05a4:
            int r7 = r7 + -3
            goto L_0x003a
        L_0x05a8:
            if (r1 == 0) goto L_0x05c0
            com.google.android.gms.internal.firebase_auth.zzfg<?> r14 = r13.zzaaa
            r14.zza((com.google.android.gms.internal.firebase_auth.zzjk) r15, (java.util.Map.Entry<?, ?>) r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x05bd
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x05a8
        L_0x05bd:
            r1 = r3
            goto L_0x05a8
        L_0x05c0:
            return
        L_0x05c1:
            boolean r0 = r13.zzzs
            if (r0 == 0) goto L_0x0b76
            boolean r0 = r13.zzzq
            if (r0 == 0) goto L_0x05e3
            com.google.android.gms.internal.firebase_auth.zzfg<?> r0 = r13.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfj r0 = r0.zzd(r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x05e3
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x05e5
        L_0x05e3:
            r0 = r3
            r1 = r0
        L_0x05e5:
            int[] r7 = r13.zzzl
            int r7 = r7.length
            r8 = r1
            r1 = 0
        L_0x05ea:
            if (r1 >= r7) goto L_0x0b58
            int r9 = r13.zzaw(r1)
            int[] r10 = r13.zzzl
            r10 = r10[r1]
        L_0x05f6:
            if (r8 == 0) goto L_0x0614
            com.google.android.gms.internal.firebase_auth.zzfg<?> r11 = r13.zzaaa
            int r11 = r11.zza(r8)
            if (r11 > r10) goto L_0x0614
            com.google.android.gms.internal.firebase_auth.zzfg<?> r11 = r13.zzaaa
            r11.zza((com.google.android.gms.internal.firebase_auth.zzjk) r15, (java.util.Map.Entry<?, ?>) r8)
            boolean r8 = r0.hasNext()
            if (r8 == 0) goto L_0x0612
            java.lang.Object r8 = r0.next()
            java.util.Map$Entry r8 = (java.util.Map.Entry) r8
            goto L_0x05f6
        L_0x0612:
            r8 = r3
            goto L_0x05f6
        L_0x0614:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0b43;
                case 1: goto L_0x0b31;
                case 2: goto L_0x0b1f;
                case 3: goto L_0x0b0d;
                case 4: goto L_0x0afb;
                case 5: goto L_0x0ae9;
                case 6: goto L_0x0ad7;
                case 7: goto L_0x0ac4;
                case 8: goto L_0x0ab2;
                case 9: goto L_0x0a9c;
                case 10: goto L_0x0a88;
                case 11: goto L_0x0a75;
                case 12: goto L_0x0a62;
                case 13: goto L_0x0a4f;
                case 14: goto L_0x0a3c;
                case 15: goto L_0x0a29;
                case 16: goto L_0x0a16;
                case 17: goto L_0x0a00;
                case 18: goto L_0x09ec;
                case 19: goto L_0x09d8;
                case 20: goto L_0x09c4;
                case 21: goto L_0x09b0;
                case 22: goto L_0x099c;
                case 23: goto L_0x0988;
                case 24: goto L_0x0974;
                case 25: goto L_0x0960;
                case 26: goto L_0x094c;
                case 27: goto L_0x0934;
                case 28: goto L_0x0920;
                case 29: goto L_0x090c;
                case 30: goto L_0x08f8;
                case 31: goto L_0x08e4;
                case 32: goto L_0x08d0;
                case 33: goto L_0x08bc;
                case 34: goto L_0x08a8;
                case 35: goto L_0x0894;
                case 36: goto L_0x0880;
                case 37: goto L_0x086c;
                case 38: goto L_0x0858;
                case 39: goto L_0x0844;
                case 40: goto L_0x0830;
                case 41: goto L_0x081c;
                case 42: goto L_0x0808;
                case 43: goto L_0x07f4;
                case 44: goto L_0x07e0;
                case 45: goto L_0x07cc;
                case 46: goto L_0x07b8;
                case 47: goto L_0x07a4;
                case 48: goto L_0x0790;
                case 49: goto L_0x0778;
                case 50: goto L_0x076c;
                case 51: goto L_0x075a;
                case 52: goto L_0x0748;
                case 53: goto L_0x0736;
                case 54: goto L_0x0724;
                case 55: goto L_0x0712;
                case 56: goto L_0x0700;
                case 57: goto L_0x06ee;
                case 58: goto L_0x06dc;
                case 59: goto L_0x06ca;
                case 60: goto L_0x06b4;
                case 61: goto L_0x06a0;
                case 62: goto L_0x068e;
                case 63: goto L_0x067c;
                case 64: goto L_0x066a;
                case 65: goto L_0x0658;
                case 66: goto L_0x0646;
                case 67: goto L_0x0634;
                case 68: goto L_0x061e;
                default: goto L_0x061c;
            }
        L_0x061c:
            goto L_0x0b54
        L_0x061e:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzhv) r11)
            goto L_0x0b54
        L_0x0634:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0b54
        L_0x0646:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzi((int) r10, (int) r9)
            goto L_0x0b54
        L_0x0658:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj((int) r10, (long) r11)
            goto L_0x0b54
        L_0x066a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzq(r10, r9)
            goto L_0x0b54
        L_0x067c:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0b54
        L_0x068e:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0b54
        L_0x06a0:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzeh r9 = (com.google.android.gms.internal.firebase_auth.zzeh) r9
            r15.zza((int) r10, (com.google.android.gms.internal.firebase_auth.zzeh) r9)
            goto L_0x0b54
        L_0x06b4:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzhv) r11)
            goto L_0x0b54
        L_0x06ca:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzjk) r15)
            goto L_0x0b54
        L_0x06dc:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zzb((int) r10, (boolean) r9)
            goto L_0x0b54
        L_0x06ee:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzj((int) r10, (int) r9)
            goto L_0x0b54
        L_0x0700:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0b54
        L_0x0712:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0b54
        L_0x0724:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0b54
        L_0x0736:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzi((int) r10, (long) r11)
            goto L_0x0b54
        L_0x0748:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzg(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0b54
        L_0x075a:
            boolean r11 = r13.zza(r14, (int) r10, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzf(r14, r11)
            r15.zza((int) r10, (double) r11)
            goto L_0x0b54
        L_0x076c:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            r13.zza((com.google.android.gms.internal.firebase_auth.zzjk) r15, (int) r10, (java.lang.Object) r9, (int) r1)
            goto L_0x0b54
        L_0x0778:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
            com.google.android.gms.internal.firebase_auth.zzhx.zzb((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (com.google.android.gms.internal.firebase_auth.zzhv) r11)
            goto L_0x0b54
        L_0x0790:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x07a4:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x07b8:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x07cc:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x07e0:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x07f4:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x0808:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x081c:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x0830:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x0844:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x0858:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x086c:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r10, r9, r15, r4)
            goto L_0x0b54
        L_0x0880:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (boolean) r4)
            goto L_0x0b54
        L_0x0894:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (boolean) r4)
            goto L_0x0b54
        L_0x08a8:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x08bc:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x08d0:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x08e4:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x08f8:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x090c:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x0920:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r10, r9, r15)
            goto L_0x0b54
        L_0x0934:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r10, (java.util.List<?>) r9, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (com.google.android.gms.internal.firebase_auth.zzhv) r11)
            goto L_0x0b54
        L_0x094c:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r10, (java.util.List<java.lang.String>) r9, (com.google.android.gms.internal.firebase_auth.zzjk) r15)
            goto L_0x0b54
        L_0x0960:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x0974:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x0988:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x099c:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x09b0:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x09c4:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r10, r9, r15, r5)
            goto L_0x0b54
        L_0x09d8:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zzb((int) r10, (java.util.List<java.lang.Float>) r9, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (boolean) r5)
            goto L_0x0b54
        L_0x09ec:
            int[] r10 = r13.zzzl
            r10 = r10[r1]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r10, (java.util.List<java.lang.Double>) r9, (com.google.android.gms.internal.firebase_auth.zzjk) r15, (boolean) r5)
            goto L_0x0b54
        L_0x0a00:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
            r15.zzb((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzhv) r11)
            goto L_0x0b54
        L_0x0a16:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r11)
            r15.zzb((int) r10, (long) r11)
            goto L_0x0b54
        L_0x0a29:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzi((int) r10, (int) r9)
            goto L_0x0b54
        L_0x0a3c:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r11)
            r15.zzj((int) r10, (long) r11)
            goto L_0x0b54
        L_0x0a4f:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzq(r10, r9)
            goto L_0x0b54
        L_0x0a62:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0b54
        L_0x0a75:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0b54
        L_0x0a88:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzeh r9 = (com.google.android.gms.internal.firebase_auth.zzeh) r9
            r15.zza((int) r10, (com.google.android.gms.internal.firebase_auth.zzeh) r9)
            goto L_0x0b54
        L_0x0a9c:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            com.google.android.gms.internal.firebase_auth.zzhv r11 = r13.zzat(r1)
            r15.zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzhv) r11)
            goto L_0x0b54
        L_0x0ab2:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r11)
            zza((int) r10, (java.lang.Object) r9, (com.google.android.gms.internal.firebase_auth.zzjk) r15)
            goto L_0x0b54
        L_0x0ac4:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.firebase_auth.zziv.zzm(r14, r11)
            r15.zzb((int) r10, (boolean) r9)
            goto L_0x0b54
        L_0x0ad7:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzj((int) r10, (int) r9)
            goto L_0x0b54
        L_0x0ae9:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0b54
        L_0x0afb:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.firebase_auth.zziv.zzk(r14, r11)
            r15.zzg(r10, r9)
            goto L_0x0b54
        L_0x0b0d:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r11)
            r15.zza((int) r10, (long) r11)
            goto L_0x0b54
        L_0x0b1f:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.firebase_auth.zziv.zzl(r14, r11)
            r15.zzi((int) r10, (long) r11)
            goto L_0x0b54
        L_0x0b31:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.firebase_auth.zziv.zzn(r14, r11)
            r15.zza((int) r10, (float) r9)
            goto L_0x0b54
        L_0x0b43:
            boolean r11 = r13.zza(r14, (int) r1)
            if (r11 == 0) goto L_0x0b54
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.firebase_auth.zziv.zzo(r14, r11)
            r15.zza((int) r10, (double) r11)
        L_0x0b54:
            int r1 = r1 + 3
            goto L_0x05ea
        L_0x0b58:
            if (r8 == 0) goto L_0x0b70
            com.google.android.gms.internal.firebase_auth.zzfg<?> r1 = r13.zzaaa
            r1.zza((com.google.android.gms.internal.firebase_auth.zzjk) r15, (java.util.Map.Entry<?, ?>) r8)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0b6d
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            r8 = r1
            goto L_0x0b58
        L_0x0b6d:
            r8 = r3
            goto L_0x0b58
        L_0x0b70:
            com.google.android.gms.internal.firebase_auth.zzip<?, ?> r0 = r13.zzzz
            zza(r0, r14, (com.google.android.gms.internal.firebase_auth.zzjk) r15)
            return
        L_0x0b76:
            r13.zzb(r14, (com.google.android.gms.internal.firebase_auth.zzjk) r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhf.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzjk):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:172:0x055a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0030  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r21, com.google.android.gms.internal.firebase_auth.zzjk r22) throws java.io.IOException {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            r2 = r22
            boolean r3 = r0.zzzq
            if (r3 == 0) goto L_0x0022
            com.google.android.gms.internal.firebase_auth.zzfg<?> r3 = r0.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfj r3 = r3.zzd(r1)
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0022
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0024
        L_0x0022:
            r3 = 0
            r5 = 0
        L_0x0024:
            r6 = -1
            int[] r7 = r0.zzzl
            int r7 = r7.length
            sun.misc.Unsafe r8 = zzzk
            r10 = r5
            r5 = 0
            r11 = 0
        L_0x002e:
            if (r5 >= r7) goto L_0x0558
            int r12 = r0.zzaw(r5)
            int[] r13 = r0.zzzl
            r13 = r13[r5]
            r14 = 267386880(0xff00000, float:2.3665827E-29)
            r14 = r14 & r12
            int r14 = r14 >>> 20
            boolean r15 = r0.zzzs
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r15 != 0) goto L_0x0069
            r15 = 17
            if (r14 > r15) goto L_0x0069
            int[] r15 = r0.zzzl
            int r17 = r5 + 2
            r15 = r15[r17]
            r9 = r15 & r16
            if (r9 == r6) goto L_0x0061
            r18 = r5
            long r4 = (long) r9
            int r11 = r8.getInt(r1, r4)
            r6 = r9
            goto L_0x0063
        L_0x0061:
            r18 = r5
        L_0x0063:
            int r4 = r15 >>> 20
            r5 = 1
            int r9 = r5 << r4
            goto L_0x006c
        L_0x0069:
            r18 = r5
            r9 = 0
        L_0x006c:
            if (r10 == 0) goto L_0x008c
            com.google.android.gms.internal.firebase_auth.zzfg<?> r4 = r0.zzaaa
            int r4 = r4.zza(r10)
            if (r4 > r13) goto L_0x008c
            com.google.android.gms.internal.firebase_auth.zzfg<?> r4 = r0.zzaaa
            r4.zza((com.google.android.gms.internal.firebase_auth.zzjk) r2, (java.util.Map.Entry<?, ?>) r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0089
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x006c
        L_0x0089:
            r10 = 0
            goto L_0x006c
        L_0x008c:
            r4 = r12 & r16
            long r4 = (long) r4
            switch(r14) {
                case 0: goto L_0x0546;
                case 1: goto L_0x0537;
                case 2: goto L_0x0529;
                case 3: goto L_0x051b;
                case 4: goto L_0x050d;
                case 5: goto L_0x04ff;
                case 6: goto L_0x04f1;
                case 7: goto L_0x04e1;
                case 8: goto L_0x04d2;
                case 9: goto L_0x04bf;
                case 10: goto L_0x04ae;
                case 11: goto L_0x049f;
                case 12: goto L_0x0490;
                case 13: goto L_0x0481;
                case 14: goto L_0x0472;
                case 15: goto L_0x0463;
                case 16: goto L_0x0454;
                case 17: goto L_0x0440;
                case 18: goto L_0x042d;
                case 19: goto L_0x041a;
                case 20: goto L_0x0407;
                case 21: goto L_0x03f4;
                case 22: goto L_0x03e1;
                case 23: goto L_0x03ce;
                case 24: goto L_0x03bb;
                case 25: goto L_0x03a8;
                case 26: goto L_0x0396;
                case 27: goto L_0x037f;
                case 28: goto L_0x036d;
                case 29: goto L_0x035a;
                case 30: goto L_0x0347;
                case 31: goto L_0x0334;
                case 32: goto L_0x0321;
                case 33: goto L_0x030e;
                case 34: goto L_0x02fb;
                case 35: goto L_0x02e8;
                case 36: goto L_0x02d5;
                case 37: goto L_0x02c2;
                case 38: goto L_0x02af;
                case 39: goto L_0x029c;
                case 40: goto L_0x0289;
                case 41: goto L_0x0276;
                case 42: goto L_0x0263;
                case 43: goto L_0x0250;
                case 44: goto L_0x023d;
                case 45: goto L_0x022a;
                case 46: goto L_0x0217;
                case 47: goto L_0x0204;
                case 48: goto L_0x01f1;
                case 49: goto L_0x01da;
                case 50: goto L_0x01cf;
                case 51: goto L_0x01be;
                case 52: goto L_0x01ad;
                case 53: goto L_0x019c;
                case 54: goto L_0x018b;
                case 55: goto L_0x017a;
                case 56: goto L_0x0169;
                case 57: goto L_0x0158;
                case 58: goto L_0x0147;
                case 59: goto L_0x0136;
                case 60: goto L_0x0121;
                case 61: goto L_0x010e;
                case 62: goto L_0x00fe;
                case 63: goto L_0x00ee;
                case 64: goto L_0x00de;
                case 65: goto L_0x00ce;
                case 66: goto L_0x00be;
                case 67: goto L_0x00ae;
                case 68: goto L_0x0099;
                default: goto L_0x0094;
            }
        L_0x0094:
            r12 = r18
        L_0x0096:
            r14 = 0
            goto L_0x0554
        L_0x0099:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            r2.zzb((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzhv) r5)
            goto L_0x0096
        L_0x00ae:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            long r4 = zzi(r1, r4)
            r2.zzb((int) r13, (long) r4)
            goto L_0x0096
        L_0x00be:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            int r4 = zzh(r1, r4)
            r2.zzi((int) r13, (int) r4)
            goto L_0x0096
        L_0x00ce:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            long r4 = zzi(r1, r4)
            r2.zzj((int) r13, (long) r4)
            goto L_0x0096
        L_0x00de:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            int r4 = zzh(r1, r4)
            r2.zzq(r13, r4)
            goto L_0x0096
        L_0x00ee:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            int r4 = zzh(r1, r4)
            r2.zzr(r13, r4)
            goto L_0x0096
        L_0x00fe:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            int r4 = zzh(r1, r4)
            r2.zzh(r13, r4)
            goto L_0x0096
        L_0x010e:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            r2.zza((int) r13, (com.google.android.gms.internal.firebase_auth.zzeh) r4)
            goto L_0x0096
        L_0x0121:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            r2.zza((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzhv) r5)
            goto L_0x0096
        L_0x0136:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            java.lang.Object r4 = r8.getObject(r1, r4)
            zza((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzjk) r2)
            goto L_0x0096
        L_0x0147:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            boolean r4 = zzj(r1, r4)
            r2.zzb((int) r13, (boolean) r4)
            goto L_0x0096
        L_0x0158:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            int r4 = zzh(r1, r4)
            r2.zzj((int) r13, (int) r4)
            goto L_0x0096
        L_0x0169:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            long r4 = zzi(r1, r4)
            r2.zzc(r13, r4)
            goto L_0x0096
        L_0x017a:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            int r4 = zzh(r1, r4)
            r2.zzg(r13, r4)
            goto L_0x0096
        L_0x018b:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            long r4 = zzi(r1, r4)
            r2.zza((int) r13, (long) r4)
            goto L_0x0096
        L_0x019c:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            long r4 = zzi(r1, r4)
            r2.zzi((int) r13, (long) r4)
            goto L_0x0096
        L_0x01ad:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            float r4 = zzg(r1, r4)
            r2.zza((int) r13, (float) r4)
            goto L_0x0096
        L_0x01be:
            r12 = r18
            boolean r9 = r0.zza(r1, (int) r13, (int) r12)
            if (r9 == 0) goto L_0x0096
            double r4 = zzf(r1, r4)
            r2.zza((int) r13, (double) r4)
            goto L_0x0096
        L_0x01cf:
            r12 = r18
            java.lang.Object r4 = r8.getObject(r1, r4)
            r0.zza((com.google.android.gms.internal.firebase_auth.zzjk) r2, (int) r13, (java.lang.Object) r4, (int) r12)
            goto L_0x0096
        L_0x01da:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            com.google.android.gms.internal.firebase_auth.zzhx.zzb((int) r9, (java.util.List<?>) r4, (com.google.android.gms.internal.firebase_auth.zzjk) r2, (com.google.android.gms.internal.firebase_auth.zzhv) r5)
            goto L_0x0096
        L_0x01f1:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r9, r4, r2, r5)
            goto L_0x0096
        L_0x0204:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r9, r4, r2, r5)
            goto L_0x0096
        L_0x0217:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r9, r4, r2, r5)
            goto L_0x0096
        L_0x022a:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r9, r4, r2, r5)
            goto L_0x0096
        L_0x023d:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r9, r4, r2, r5)
            goto L_0x0096
        L_0x0250:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r9, r4, r2, r5)
            goto L_0x0096
        L_0x0263:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r9, r4, r2, r5)
            goto L_0x0096
        L_0x0276:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r9, r4, r2, r5)
            goto L_0x0096
        L_0x0289:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r9, r4, r2, r5)
            goto L_0x0096
        L_0x029c:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r9, r4, r2, r5)
            goto L_0x0096
        L_0x02af:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r9, r4, r2, r5)
            goto L_0x0096
        L_0x02c2:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r9, r4, r2, r5)
            goto L_0x0096
        L_0x02d5:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zzb((int) r9, (java.util.List<java.lang.Float>) r4, (com.google.android.gms.internal.firebase_auth.zzjk) r2, (boolean) r5)
            goto L_0x0096
        L_0x02e8:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 1
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r9, (java.util.List<java.lang.Double>) r4, (com.google.android.gms.internal.firebase_auth.zzjk) r2, (boolean) r5)
            goto L_0x0096
        L_0x02fb:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zze(r9, r4, r2, r5)
            goto L_0x0096
        L_0x030e:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzj(r9, r4, r2, r5)
            goto L_0x0096
        L_0x0321:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzg(r9, r4, r2, r5)
            goto L_0x0096
        L_0x0334:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzl(r9, r4, r2, r5)
            goto L_0x0096
        L_0x0347:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzm(r9, r4, r2, r5)
            goto L_0x0096
        L_0x035a:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzi(r9, r4, r2, r5)
            goto L_0x0096
        L_0x036d:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhx.zzb(r9, r4, r2)
            goto L_0x0096
        L_0x037f:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r9, (java.util.List<?>) r4, (com.google.android.gms.internal.firebase_auth.zzjk) r2, (com.google.android.gms.internal.firebase_auth.zzhv) r5)
            goto L_0x0096
        L_0x0396:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r9, (java.util.List<java.lang.String>) r4, (com.google.android.gms.internal.firebase_auth.zzjk) r2)
            goto L_0x0096
        L_0x03a8:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzn(r9, r4, r2, r5)
            goto L_0x0096
        L_0x03bb:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzk(r9, r4, r2, r5)
            goto L_0x0096
        L_0x03ce:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzf(r9, r4, r2, r5)
            goto L_0x0096
        L_0x03e1:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzh(r9, r4, r2, r5)
            goto L_0x0096
        L_0x03f4:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzd(r9, r4, r2, r5)
            goto L_0x0096
        L_0x0407:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzc(r9, r4, r2, r5)
            goto L_0x0096
        L_0x041a:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r5 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zzb((int) r9, (java.util.List<java.lang.Float>) r4, (com.google.android.gms.internal.firebase_auth.zzjk) r2, (boolean) r5)
            goto L_0x0096
        L_0x042d:
            r12 = r18
            int[] r9 = r0.zzzl
            r9 = r9[r12]
            java.lang.Object r4 = r8.getObject(r1, r4)
            java.util.List r4 = (java.util.List) r4
            r14 = 0
            com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r9, (java.util.List<java.lang.Double>) r4, (com.google.android.gms.internal.firebase_auth.zzjk) r2, (boolean) r14)
            goto L_0x0554
        L_0x0440:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            r2.zzb((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzhv) r5)
            goto L_0x0554
        L_0x0454:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            long r4 = r8.getLong(r1, r4)
            r2.zzb((int) r13, (long) r4)
            goto L_0x0554
        L_0x0463:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            int r4 = r8.getInt(r1, r4)
            r2.zzi((int) r13, (int) r4)
            goto L_0x0554
        L_0x0472:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            long r4 = r8.getLong(r1, r4)
            r2.zzj((int) r13, (long) r4)
            goto L_0x0554
        L_0x0481:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            int r4 = r8.getInt(r1, r4)
            r2.zzq(r13, r4)
            goto L_0x0554
        L_0x0490:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            int r4 = r8.getInt(r1, r4)
            r2.zzr(r13, r4)
            goto L_0x0554
        L_0x049f:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            int r4 = r8.getInt(r1, r4)
            r2.zzh(r13, r4)
            goto L_0x0554
        L_0x04ae:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzeh r4 = (com.google.android.gms.internal.firebase_auth.zzeh) r4
            r2.zza((int) r13, (com.google.android.gms.internal.firebase_auth.zzeh) r4)
            goto L_0x0554
        L_0x04bf:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            java.lang.Object r4 = r8.getObject(r1, r4)
            com.google.android.gms.internal.firebase_auth.zzhv r5 = r0.zzat(r12)
            r2.zza((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzhv) r5)
            goto L_0x0554
        L_0x04d2:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            java.lang.Object r4 = r8.getObject(r1, r4)
            zza((int) r13, (java.lang.Object) r4, (com.google.android.gms.internal.firebase_auth.zzjk) r2)
            goto L_0x0554
        L_0x04e1:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            boolean r4 = com.google.android.gms.internal.firebase_auth.zziv.zzm(r1, r4)
            r2.zzb((int) r13, (boolean) r4)
            goto L_0x0554
        L_0x04f1:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            int r4 = r8.getInt(r1, r4)
            r2.zzj((int) r13, (int) r4)
            goto L_0x0554
        L_0x04ff:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            long r4 = r8.getLong(r1, r4)
            r2.zzc(r13, r4)
            goto L_0x0554
        L_0x050d:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            int r4 = r8.getInt(r1, r4)
            r2.zzg(r13, r4)
            goto L_0x0554
        L_0x051b:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            long r4 = r8.getLong(r1, r4)
            r2.zza((int) r13, (long) r4)
            goto L_0x0554
        L_0x0529:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            long r4 = r8.getLong(r1, r4)
            r2.zzi((int) r13, (long) r4)
            goto L_0x0554
        L_0x0537:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            float r4 = com.google.android.gms.internal.firebase_auth.zziv.zzn(r1, r4)
            r2.zza((int) r13, (float) r4)
            goto L_0x0554
        L_0x0546:
            r12 = r18
            r14 = 0
            r9 = r9 & r11
            if (r9 == 0) goto L_0x0554
            double r4 = com.google.android.gms.internal.firebase_auth.zziv.zzo(r1, r4)
            r2.zza((int) r13, (double) r4)
        L_0x0554:
            int r5 = r12 + 3
            goto L_0x002e
        L_0x0558:
            if (r10 == 0) goto L_0x0570
            com.google.android.gms.internal.firebase_auth.zzfg<?> r4 = r0.zzaaa
            r4.zza((com.google.android.gms.internal.firebase_auth.zzjk) r2, (java.util.Map.Entry<?, ?>) r10)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x056d
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r10 = r4
            goto L_0x0558
        L_0x056d:
            r10 = 0
            goto L_0x0558
        L_0x0570:
            com.google.android.gms.internal.firebase_auth.zzip<?, ?> r3 = r0.zzzz
            zza(r3, r1, (com.google.android.gms.internal.firebase_auth.zzjk) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhf.zzb(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzjk):void");
    }

    private final <K, V> void zza(zzjk zzjk, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzjk.zza(i, this.zzaab.zzo(zzau(i2)), this.zzaab.zzk(obj));
        }
    }

    private static <UT, UB> void zza(zzip<UT, UB> zzip, T t, zzjk zzjk) throws IOException {
        zzip.zza(zzip.zzs(t), zzjk);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r18, com.google.android.gms.internal.firebase_auth.zzhq r19, com.google.android.gms.internal.firebase_auth.zzff r20) throws java.io.IOException {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r10 = r19
            r11 = r20
            if (r11 != 0) goto L_0x0010
            java.lang.NullPointerException r2 = new java.lang.NullPointerException
            r2.<init>()
            throw r2
        L_0x0010:
            com.google.android.gms.internal.firebase_auth.zzip<?, ?> r12 = r1.zzzz
            com.google.android.gms.internal.firebase_auth.zzfg<?> r13 = r1.zzaaa
            r14 = 0
            r3 = r14
            r15 = r3
        L_0x0019:
            int r4 = r19.zzgf()     // Catch:{ all -> 0x062d }
            int r5 = r1.zzzn     // Catch:{ all -> 0x062d }
            if (r4 < r5) goto L_0x0049
            int r5 = r1.zzzo     // Catch:{ all -> 0x062d }
            if (r4 > r5) goto L_0x0049
            r5 = 0
            int[] r7 = r1.zzzl     // Catch:{ all -> 0x062d }
            int r7 = r7.length     // Catch:{ all -> 0x062d }
            int r7 = r7 / 3
            int r7 = r7 + -1
        L_0x002e:
            if (r5 > r7) goto L_0x0047
            int r8 = r7 + r5
            int r8 = r8 >>> 1
            int r9 = r8 * 3
            int[] r6 = r1.zzzl     // Catch:{ all -> 0x062d }
            r6 = r6[r9]     // Catch:{ all -> 0x062d }
            if (r4 != r6) goto L_0x003f
            goto L_0x004b
        L_0x003f:
            if (r4 >= r6) goto L_0x0044
            int r7 = r8 + -1
            goto L_0x002e
        L_0x0044:
            int r5 = r8 + 1
            goto L_0x002e
        L_0x0047:
            goto L_0x004a
        L_0x0049:
        L_0x004a:
            r9 = -1
        L_0x004b:
            if (r9 >= 0) goto L_0x00b8
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 != r5) goto L_0x0069
            int r3 = r1.zzzv
        L_0x0054:
            int r4 = r1.zzzw
            if (r3 >= r4) goto L_0x0063
            int[] r4 = r1.zzzu
            r4 = r4[r3]
            java.lang.Object r15 = r1.zza((java.lang.Object) r2, (int) r4, r15, r12)
            int r3 = r3 + 1
            goto L_0x0054
        L_0x0063:
            if (r15 == 0) goto L_0x0068
            r12.zzf(r2, r15)
        L_0x0068:
            return
        L_0x0069:
            boolean r5 = r1.zzzq     // Catch:{ all -> 0x062d }
            if (r5 != 0) goto L_0x0070
            r5 = r14
            goto L_0x0077
        L_0x0070:
            com.google.android.gms.internal.firebase_auth.zzhb r5 = r1.zzzp     // Catch:{ all -> 0x062d }
            java.lang.Object r4 = r13.zza(r11, r5, r4)     // Catch:{ all -> 0x062d }
            r5 = r4
        L_0x0077:
            if (r5 == 0) goto L_0x0091
            if (r3 != 0) goto L_0x007f
            com.google.android.gms.internal.firebase_auth.zzfj r3 = r13.zze(r2)     // Catch:{ all -> 0x062d }
        L_0x007f:
            r16 = r3
            r3 = r13
            r4 = r10
            r6 = r11
            r7 = r16
            r8 = r15
            r9 = r12
            java.lang.Object r3 = r3.zza(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x062d }
            r15 = r3
            r3 = r16
            goto L_0x0019
        L_0x0091:
            r12.zza(r10)     // Catch:{ all -> 0x062d }
            if (r15 != 0) goto L_0x009b
            java.lang.Object r4 = r12.zzt(r2)     // Catch:{ all -> 0x062d }
            r15 = r4
        L_0x009b:
            boolean r4 = r12.zza(r15, (com.google.android.gms.internal.firebase_auth.zzhq) r10)     // Catch:{ all -> 0x062d }
            if (r4 != 0) goto L_0x0019
            int r3 = r1.zzzv
        L_0x00a3:
            int r4 = r1.zzzw
            if (r3 >= r4) goto L_0x00b2
            int[] r4 = r1.zzzu
            r4 = r4[r3]
            java.lang.Object r15 = r1.zza((java.lang.Object) r2, (int) r4, r15, r12)
            int r3 = r3 + 1
            goto L_0x00a3
        L_0x00b2:
            if (r15 == 0) goto L_0x00b7
            r12.zzf(r2, r15)
        L_0x00b7:
            return
        L_0x00b8:
            int r5 = r1.zzaw(r9)     // Catch:{ all -> 0x062d }
            r6 = 267386880(0xff00000, float:2.3665827E-29)
            r6 = r6 & r5
            int r6 = r6 >>> 20
            r7 = 1048575(0xfffff, float:1.469367E-39)
            switch(r6) {
                case 0: goto L_0x05d3;
                case 1: goto L_0x05c3;
                case 2: goto L_0x05b3;
                case 3: goto L_0x05a3;
                case 4: goto L_0x0593;
                case 5: goto L_0x0583;
                case 6: goto L_0x0573;
                case 7: goto L_0x0563;
                case 8: goto L_0x055b;
                case 9: goto L_0x0525;
                case 10: goto L_0x0515;
                case 11: goto L_0x0505;
                case 12: goto L_0x04e1;
                case 13: goto L_0x04d1;
                case 14: goto L_0x04c1;
                case 15: goto L_0x04b1;
                case 16: goto L_0x04a1;
                case 17: goto L_0x046b;
                case 18: goto L_0x045e;
                case 19: goto L_0x0451;
                case 20: goto L_0x0444;
                case 21: goto L_0x0437;
                case 22: goto L_0x042a;
                case 23: goto L_0x041d;
                case 24: goto L_0x0410;
                case 25: goto L_0x0403;
                case 26: goto L_0x03e2;
                case 27: goto L_0x03cd;
                case 28: goto L_0x03c0;
                case 29: goto L_0x03b3;
                case 30: goto L_0x039b;
                case 31: goto L_0x038e;
                case 32: goto L_0x0381;
                case 33: goto L_0x0374;
                case 34: goto L_0x0367;
                case 35: goto L_0x035a;
                case 36: goto L_0x034d;
                case 37: goto L_0x0340;
                case 38: goto L_0x0333;
                case 39: goto L_0x0326;
                case 40: goto L_0x0319;
                case 41: goto L_0x030c;
                case 42: goto L_0x02ff;
                case 43: goto L_0x02f2;
                case 44: goto L_0x02dc;
                case 45: goto L_0x02cf;
                case 46: goto L_0x02c2;
                case 47: goto L_0x02b5;
                case 48: goto L_0x02a8;
                case 49: goto L_0x0293;
                case 50: goto L_0x024f;
                case 51: goto L_0x023c;
                case 52: goto L_0x0229;
                case 53: goto L_0x0216;
                case 54: goto L_0x0203;
                case 55: goto L_0x01f0;
                case 56: goto L_0x01dd;
                case 57: goto L_0x01ca;
                case 58: goto L_0x01b7;
                case 59: goto L_0x01af;
                case 60: goto L_0x0179;
                case 61: goto L_0x016a;
                case 62: goto L_0x0157;
                case 63: goto L_0x0130;
                case 64: goto L_0x011d;
                case 65: goto L_0x010a;
                case 66: goto L_0x00f7;
                case 67: goto L_0x00e4;
                case 68: goto L_0x00d0;
                default: goto L_0x00c8;
            }
        L_0x00c8:
            if (r15 != 0) goto L_0x05e4
            java.lang.Object r4 = r12.zzjm()     // Catch:{ zzgc -> 0x0603 }
            goto L_0x05e3
        L_0x00d0:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzhv r7 = r1.zzat(r9)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r7 = r10.zzb(r7, r11)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x00e4:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            long r7 = r19.zzfv()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x00f7:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            int r7 = r19.zzfu()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x010a:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            long r7 = r19.zzft()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x011d:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            int r7 = r19.zzfs()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0130:
            int r6 = r19.zzfr()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzfx r8 = r1.zzav(r9)     // Catch:{ zzgc -> 0x0603 }
            if (r8 == 0) goto L_0x0148
            boolean r8 = r8.zzc(r6)     // Catch:{ zzgc -> 0x0603 }
            if (r8 == 0) goto L_0x0141
            goto L_0x0148
        L_0x0141:
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r4, (int) r6, r15, r12)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x03b0
        L_0x0148:
            r5 = r5 & r7
            long r7 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r6)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r7, (java.lang.Object) r5)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0157:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            int r7 = r19.zzfq()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x016a:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzeh r7 = r19.zzfp()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0179:
            boolean r6 = r1.zza(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            if (r6 == 0) goto L_0x0198
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzhv r8 = r1.zzat(r9)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r8 = r10.zza(r8, r11)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zzfu.zza((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x01aa
        L_0x0198:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzhv r7 = r1.zzat(r9)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r7 = r10.zza(r7, r11)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
        L_0x01aa:
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x01af:
            r1.zza((java.lang.Object) r2, (int) r5, (com.google.android.gms.internal.firebase_auth.zzhq) r10)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x01b7:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            boolean r7 = r19.zzfn()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x01ca:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            int r7 = r19.zzfm()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x01dd:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            long r7 = r19.zzfl()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x01f0:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            int r7 = r19.zzfk()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0203:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            long r7 = r19.zzfi()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0216:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            long r7 = r19.zzfj()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0229:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            float r7 = r19.readFloat()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x023c:
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            double r7 = r19.readDouble()     // Catch:{ zzgc -> 0x0603 }
            java.lang.Double r7 = java.lang.Double.valueOf(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r4, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x024f:
            java.lang.Object r4 = r1.zzau(r9)     // Catch:{ zzgc -> 0x0603 }
            int r5 = r1.zzaw(r9)     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            if (r7 != 0) goto L_0x026a
            com.google.android.gms.internal.firebase_auth.zzgw r7 = r1.zzaab     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r7 = r7.zzn(r4)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0282
        L_0x026a:
            com.google.android.gms.internal.firebase_auth.zzgw r8 = r1.zzaab     // Catch:{ zzgc -> 0x0603 }
            boolean r8 = r8.zzl(r7)     // Catch:{ zzgc -> 0x0603 }
            if (r8 == 0) goto L_0x0282
            com.google.android.gms.internal.firebase_auth.zzgw r8 = r1.zzaab     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r8 = r8.zzn(r4)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzgw r9 = r1.zzaab     // Catch:{ zzgc -> 0x0603 }
            r9.zzb(r8, r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r5, (java.lang.Object) r8)     // Catch:{ zzgc -> 0x0603 }
            r7 = r8
        L_0x0282:
            com.google.android.gms.internal.firebase_auth.zzgw r5 = r1.zzaab     // Catch:{ zzgc -> 0x0603 }
            java.util.Map r5 = r5.zzj(r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzgw r6 = r1.zzaab     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzgu r4 = r6.zzo(r4)     // Catch:{ zzgc -> 0x0603 }
            r10.zza(r5, r4, (com.google.android.gms.internal.firebase_auth.zzff) r11)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0293:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzhv r6 = r1.zzat(r9)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzgl r7 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r7.zza(r2, r4)     // Catch:{ zzgc -> 0x0603 }
            r10.zzb(r4, r6, r11)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x02a8:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzs(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x02b5:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzr(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x02c2:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzq(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x02cf:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzp(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x02dc:
            com.google.android.gms.internal.firebase_auth.zzgl r6 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r7 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r5 = r6.zza(r2, r7)     // Catch:{ zzgc -> 0x0603 }
            r10.zzo(r5)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzfx r6 = r1.zzav(r9)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzhx.zza(r4, r5, r6, r15, r12)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x03b0
        L_0x02f2:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzn(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x02ff:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzk(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x030c:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzj(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0319:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzi(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0326:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzh(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0333:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzf(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0340:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzg(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x034d:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zze(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x035a:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzd(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0367:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzs(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0374:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzr(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0381:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzq(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x038e:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzp(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x039b:
            com.google.android.gms.internal.firebase_auth.zzgl r6 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r7 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r5 = r6.zza(r2, r7)     // Catch:{ zzgc -> 0x0603 }
            r10.zzo(r5)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzfx r6 = r1.zzav(r9)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzhx.zza(r4, r5, r6, r15, r12)     // Catch:{ zzgc -> 0x0603 }
        L_0x03b0:
            r15 = r4
            goto L_0x0019
        L_0x03b3:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzn(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x03c0:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzm(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x03cd:
            com.google.android.gms.internal.firebase_auth.zzhv r4 = r1.zzat(r9)     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzgl r7 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            java.util.List r5 = r7.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zza(r5, r4, (com.google.android.gms.internal.firebase_auth.zzff) r11)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x03e2:
            boolean r4 = zzay(r5)     // Catch:{ zzgc -> 0x0603 }
            if (r4 == 0) goto L_0x03f6
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzl(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x03f6:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.readStringList(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0403:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzk(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0410:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzj(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x041d:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzi(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x042a:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzh(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0437:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzf(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0444:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzg(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0451:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zze(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x045e:
            com.google.android.gms.internal.firebase_auth.zzgl r4 = r1.zzzy     // Catch:{ zzgc -> 0x0603 }
            r5 = r5 & r7
            long r5 = (long) r5     // Catch:{ zzgc -> 0x0603 }
            java.util.List r4 = r4.zza(r2, r5)     // Catch:{ zzgc -> 0x0603 }
            r10.zzd(r4)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x046b:
            boolean r4 = r1.zza(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            if (r4 == 0) goto L_0x048c
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r6 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r2, r4)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzhv r7 = r1.zzat(r9)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r7 = r10.zzb(r7, r11)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r6 = com.google.android.gms.internal.firebase_auth.zzfu.zza((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r6)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x048c:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzhv r6 = r1.zzat(r9)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r6 = r10.zzb(r6, r11)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x04a1:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            long r6 = r19.zzfv()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (long) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x04b1:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            int r6 = r19.zzfu()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zzb((java.lang.Object) r2, (long) r4, (int) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x04c1:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            long r6 = r19.zzft()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (long) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x04d1:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            int r6 = r19.zzfs()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zzb((java.lang.Object) r2, (long) r4, (int) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x04e1:
            int r6 = r19.zzfr()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzfx r8 = r1.zzav(r9)     // Catch:{ zzgc -> 0x0603 }
            if (r8 == 0) goto L_0x04f9
            boolean r8 = r8.zzc(r6)     // Catch:{ zzgc -> 0x0603 }
            if (r8 == 0) goto L_0x04f2
            goto L_0x04f9
        L_0x04f2:
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzhx.zza((int) r4, (int) r6, r15, r12)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x03b0
        L_0x04f9:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zzb((java.lang.Object) r2, (long) r4, (int) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0505:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            int r6 = r19.zzfq()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zzb((java.lang.Object) r2, (long) r4, (int) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0515:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzeh r6 = r19.zzfp()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0525:
            boolean r4 = r1.zza(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            if (r4 == 0) goto L_0x0546
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r6 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r2, r4)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzhv r7 = r1.zzat(r9)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r7 = r10.zza(r7, r11)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r6 = com.google.android.gms.internal.firebase_auth.zzfu.zza((java.lang.Object) r6, (java.lang.Object) r7)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r6)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0546:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zzhv r6 = r1.zzat(r9)     // Catch:{ zzgc -> 0x0603 }
            java.lang.Object r6 = r10.zza(r6, r11)     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (java.lang.Object) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x055b:
            r1.zza((java.lang.Object) r2, (int) r5, (com.google.android.gms.internal.firebase_auth.zzhq) r10)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0563:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            boolean r6 = r19.zzfn()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (boolean) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0573:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            int r6 = r19.zzfm()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zzb((java.lang.Object) r2, (long) r4, (int) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0583:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            long r6 = r19.zzfl()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (long) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x0593:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            int r6 = r19.zzfk()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zzb((java.lang.Object) r2, (long) r4, (int) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x05a3:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            long r6 = r19.zzfi()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (long) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x05b3:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            long r6 = r19.zzfj()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (long) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x05c3:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            float r6 = r19.readFloat()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (float) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x05d3:
            r4 = r5 & r7
            long r4 = (long) r4     // Catch:{ zzgc -> 0x0603 }
            double r6 = r19.readDouble()     // Catch:{ zzgc -> 0x0603 }
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r2, (long) r4, (double) r6)     // Catch:{ zzgc -> 0x0603 }
            r1.zzb(r2, (int) r9)     // Catch:{ zzgc -> 0x0603 }
            goto L_0x0019
        L_0x05e3:
            r15 = r4
        L_0x05e4:
            boolean r4 = r12.zza(r15, (com.google.android.gms.internal.firebase_auth.zzhq) r10)     // Catch:{ zzgc -> 0x0603 }
            if (r4 != 0) goto L_0x0601
            int r3 = r1.zzzv
        L_0x05ec:
            int r4 = r1.zzzw
            if (r3 >= r4) goto L_0x05fb
            int[] r4 = r1.zzzu
            r4 = r4[r3]
            java.lang.Object r15 = r1.zza((java.lang.Object) r2, (int) r4, r15, r12)
            int r3 = r3 + 1
            goto L_0x05ec
        L_0x05fb:
            if (r15 == 0) goto L_0x0600
            r12.zzf(r2, r15)
        L_0x0600:
            return
        L_0x0601:
            goto L_0x0019
        L_0x0603:
            r0 = move-exception
            r12.zza(r10)     // Catch:{ all -> 0x062d }
            if (r15 != 0) goto L_0x060e
            java.lang.Object r4 = r12.zzt(r2)     // Catch:{ all -> 0x062d }
            r15 = r4
        L_0x060e:
            boolean r4 = r12.zza(r15, (com.google.android.gms.internal.firebase_auth.zzhq) r10)     // Catch:{ all -> 0x062d }
            if (r4 != 0) goto L_0x062b
            int r3 = r1.zzzv
        L_0x0616:
            int r4 = r1.zzzw
            if (r3 >= r4) goto L_0x0625
            int[] r4 = r1.zzzu
            r4 = r4[r3]
            java.lang.Object r15 = r1.zza((java.lang.Object) r2, (int) r4, r15, r12)
            int r3 = r3 + 1
            goto L_0x0616
        L_0x0625:
            if (r15 == 0) goto L_0x062a
            r12.zzf(r2, r15)
        L_0x062a:
            return
        L_0x062b:
            goto L_0x0019
        L_0x062d:
            r0 = move-exception
            r3 = r0
            int r4 = r1.zzzv
        L_0x0631:
            int r5 = r1.zzzw
            if (r4 >= r5) goto L_0x0640
            int[] r5 = r1.zzzu
            r5 = r5[r4]
            java.lang.Object r15 = r1.zza((java.lang.Object) r2, (int) r5, r15, r12)
            int r4 = r4 + 1
            goto L_0x0631
        L_0x0640:
            if (r15 == 0) goto L_0x0645
            r12.zzf(r2, r15)
        L_0x0645:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhf.zza(java.lang.Object, com.google.android.gms.internal.firebase_auth.zzhq, com.google.android.gms.internal.firebase_auth.zzff):void");
    }

    private final zzhv zzat(int i) {
        int i2 = (i / 3) << 1;
        zzhv zzhv = (zzhv) this.zzzm[i2];
        if (zzhv != null) {
            return zzhv;
        }
        zzhv zzf = zzhn.zzit().zzf((Class) this.zzzm[i2 + 1]);
        this.zzzm[i2] = zzf;
        return zzf;
    }

    private final Object zzau(int i) {
        return this.zzzm[(i / 3) << 1];
    }

    private final zzfx zzav(int i) {
        return (zzfx) this.zzzm[((i / 3) << 1) + 1];
    }

    public final void zzf(T t) {
        for (int i = this.zzzv; i < this.zzzw; i++) {
            long zzaw = (long) (zzaw(this.zzzu[i]) & 1048575);
            Object zzp = zziv.zzp(t, zzaw);
            if (zzp != null) {
                zziv.zza((Object) t, zzaw, this.zzaab.zzm(zzp));
            }
        }
        int length = this.zzzu.length;
        for (int i2 = this.zzzw; i2 < length; i2++) {
            this.zzzy.zzb(t, (long) this.zzzu[i2]);
        }
        this.zzzz.zzf(t);
        if (this.zzzq) {
            this.zzaaa.zzf((Object) t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzip<UT, UB> zzip) {
        zzfx zzav;
        int i2 = this.zzzl[i];
        Object zzp = zziv.zzp(obj, (long) (zzaw(i) & 1048575));
        if (zzp == null || (zzav = zzav(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzaab.zzj(zzp), zzav, ub, zzip);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzfx zzfx, UB ub, zzip<UT, UB> zzip) {
        zzgu<?, ?> zzo = this.zzaab.zzo(zzau(i));
        Iterator<Map.Entry<K, V>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!zzfx.zzc(((Integer) next.getValue()).intValue())) {
                if (ub == null) {
                    ub = zzip.zzjm();
                }
                zzeo zzl = zzeh.zzl(zzgt.zza(zzo, next.getKey(), next.getValue()));
                try {
                    zzgt.zza(zzl.zzfg(), zzo, next.getKey(), next.getValue());
                    zzip.zza(ub, i2, zzl.zzff());
                    it.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:83:0x0115, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzq(T r14) {
        /*
            r13 = this;
            r0 = 0
            r1 = -1
            r1 = 0
            r2 = -1
            r3 = 0
        L_0x0007:
            int r4 = r13.zzzv
            r5 = 1
            if (r1 >= r4) goto L_0x0119
            int[] r4 = r13.zzzu
            r4 = r4[r1]
            int[] r6 = r13.zzzl
            r6 = r6[r4]
            int r7 = r13.zzaw(r4)
            boolean r8 = r13.zzzs
            r9 = 1048575(0xfffff, float:1.469367E-39)
            if (r8 != 0) goto L_0x003b
            int[] r8 = r13.zzzl
            int r10 = r4 + 2
            r8 = r8[r10]
            r10 = r8 & r9
            int r8 = r8 >>> 20
            int r8 = r5 << r8
            if (r10 == r2) goto L_0x003c
            sun.misc.Unsafe r2 = zzzk
            long r11 = (long) r10
            int r2 = r2.getInt(r14, r11)
            r3 = r2
            r2 = r10
            goto L_0x003c
        L_0x003b:
            r8 = 0
        L_0x003c:
            r10 = 268435456(0x10000000, float:2.5243549E-29)
            r10 = r10 & r7
            if (r10 == 0) goto L_0x0043
            r10 = 1
            goto L_0x0045
        L_0x0043:
            r10 = 0
        L_0x0045:
            if (r10 == 0) goto L_0x004e
            boolean r10 = r13.zza(r14, (int) r4, (int) r3, (int) r8)
            if (r10 != 0) goto L_0x004e
            return r0
        L_0x004e:
            r10 = 267386880(0xff00000, float:2.3665827E-29)
            r10 = r10 & r7
            int r10 = r10 >>> 20
            r11 = 9
            if (r10 == r11) goto L_0x0104
            r11 = 17
            if (r10 == r11) goto L_0x0104
            r8 = 27
            if (r10 == r8) goto L_0x00d4
            r8 = 60
            if (r10 == r8) goto L_0x00c3
            r8 = 68
            if (r10 == r8) goto L_0x00c3
            switch(r10) {
                case 49: goto L_0x00d4;
                case 50: goto L_0x006d;
                default: goto L_0x006b;
            }
        L_0x006b:
            goto L_0x0115
        L_0x006d:
            com.google.android.gms.internal.firebase_auth.zzgw r6 = r13.zzaab
            r7 = r7 & r9
            long r7 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r7)
            java.util.Map r6 = r6.zzk(r7)
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x00bf
            java.lang.Object r4 = r13.zzau(r4)
            com.google.android.gms.internal.firebase_auth.zzgw r7 = r13.zzaab
            com.google.android.gms.internal.firebase_auth.zzgu r4 = r7.zzo(r4)
            com.google.android.gms.internal.firebase_auth.zzje r4 = r4.zzze
            com.google.android.gms.internal.firebase_auth.zzjj r4 = r4.zzjw()
            com.google.android.gms.internal.firebase_auth.zzjj r7 = com.google.android.gms.internal.firebase_auth.zzjj.MESSAGE
            if (r4 != r7) goto L_0x00bf
            r4 = 0
            java.util.Collection r6 = r6.values()
            java.util.Iterator r6 = r6.iterator()
        L_0x009d:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00bf
            java.lang.Object r7 = r6.next()
            if (r4 != 0) goto L_0x00b5
            com.google.android.gms.internal.firebase_auth.zzhn r4 = com.google.android.gms.internal.firebase_auth.zzhn.zzit()
            java.lang.Class r8 = r7.getClass()
            com.google.android.gms.internal.firebase_auth.zzhv r4 = r4.zzf(r8)
        L_0x00b5:
            boolean r7 = r4.zzq(r7)
            if (r7 != 0) goto L_0x00be
            r5 = 0
            goto L_0x00c0
        L_0x00be:
            goto L_0x009d
        L_0x00bf:
        L_0x00c0:
            if (r5 != 0) goto L_0x0115
            return r0
        L_0x00c3:
            boolean r5 = r13.zza(r14, (int) r6, (int) r4)
            if (r5 == 0) goto L_0x0115
            com.google.android.gms.internal.firebase_auth.zzhv r4 = r13.zzat(r4)
            boolean r4 = zza((java.lang.Object) r14, (int) r7, (com.google.android.gms.internal.firebase_auth.zzhv) r4)
            if (r4 != 0) goto L_0x0115
            return r0
        L_0x00d4:
            r6 = r7 & r9
            long r6 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.firebase_auth.zziv.zzp(r14, r6)
            java.util.List r6 = (java.util.List) r6
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x0100
            com.google.android.gms.internal.firebase_auth.zzhv r4 = r13.zzat(r4)
            r7 = 0
        L_0x00ea:
            int r8 = r6.size()
            if (r7 >= r8) goto L_0x0100
            java.lang.Object r8 = r6.get(r7)
            boolean r8 = r4.zzq(r8)
            if (r8 != 0) goto L_0x00fd
            r5 = 0
            goto L_0x0101
        L_0x00fd:
            int r7 = r7 + 1
            goto L_0x00ea
        L_0x0100:
        L_0x0101:
            if (r5 != 0) goto L_0x0115
            return r0
        L_0x0104:
            boolean r5 = r13.zza(r14, (int) r4, (int) r3, (int) r8)
            if (r5 == 0) goto L_0x0115
            com.google.android.gms.internal.firebase_auth.zzhv r4 = r13.zzat(r4)
            boolean r4 = zza((java.lang.Object) r14, (int) r7, (com.google.android.gms.internal.firebase_auth.zzhv) r4)
            if (r4 != 0) goto L_0x0115
            return r0
        L_0x0115:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x0119:
            boolean r1 = r13.zzzq
            if (r1 == 0) goto L_0x012a
            com.google.android.gms.internal.firebase_auth.zzfg<?> r1 = r13.zzaaa
            com.google.android.gms.internal.firebase_auth.zzfj r14 = r1.zzd(r14)
            boolean r14 = r14.isInitialized()
            if (r14 != 0) goto L_0x012a
            return r0
        L_0x012a:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhf.zzq(java.lang.Object):boolean");
    }

    private static boolean zza(Object obj, int i, zzhv zzhv) {
        return zzhv.zzq(zziv.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzjk zzjk) throws IOException {
        if (obj instanceof String) {
            zzjk.zza(i, (String) obj);
        } else {
            zzjk.zza(i, (zzeh) obj);
        }
    }

    private final void zza(Object obj, int i, zzhq zzhq) throws IOException {
        if (zzay(i)) {
            zziv.zza(obj, (long) (i & 1048575), (Object) zzhq.zzfo());
        } else if (this.zzzr) {
            zziv.zza(obj, (long) (i & 1048575), (Object) zzhq.readString());
        } else {
            zziv.zza(obj, (long) (i & 1048575), (Object) zzhq.zzfp());
        }
    }

    private final int zzaw(int i) {
        return this.zzzl[i + 1];
    }

    private final int zzax(int i) {
        return this.zzzl[i + 2];
    }

    private static boolean zzay(int i) {
        return (i & 536870912) != 0;
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zziv.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zziv.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zziv.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zziv.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zziv.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        if (this.zzzs) {
            return zza(t, i);
        }
        return (i2 & i3) != 0;
    }

    private final boolean zza(T t, int i) {
        if (this.zzzs) {
            int zzaw = zzaw(i);
            long j = (long) (zzaw & 1048575);
            switch ((zzaw & 267386880) >>> 20) {
                case 0:
                    return zziv.zzo(t, j) != 0.0d;
                case 1:
                    return zziv.zzn(t, j) != 0.0f;
                case 2:
                    return zziv.zzl(t, j) != 0;
                case 3:
                    return zziv.zzl(t, j) != 0;
                case 4:
                    return zziv.zzk(t, j) != 0;
                case 5:
                    return zziv.zzl(t, j) != 0;
                case 6:
                    return zziv.zzk(t, j) != 0;
                case 7:
                    return zziv.zzm(t, j);
                case 8:
                    Object zzp = zziv.zzp(t, j);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzeh) {
                        return !zzeh.zzso.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zziv.zzp(t, j) != null;
                case 10:
                    return !zzeh.zzso.equals(zziv.zzp(t, j));
                case 11:
                    return zziv.zzk(t, j) != 0;
                case 12:
                    return zziv.zzk(t, j) != 0;
                case 13:
                    return zziv.zzk(t, j) != 0;
                case 14:
                    return zziv.zzl(t, j) != 0;
                case 15:
                    return zziv.zzk(t, j) != 0;
                case 16:
                    return zziv.zzl(t, j) != 0;
                case 17:
                    return zziv.zzp(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzax = zzax(i);
            return (zziv.zzk(t, (long) (zzax & 1048575)) & (1 << (zzax >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        if (!this.zzzs) {
            int zzax = zzax(i);
            long j = (long) (zzax & 1048575);
            zziv.zzb((Object) t, j, zziv.zzk(t, j) | (1 << (zzax >>> 20)));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zziv.zzk(t, (long) (zzax(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zziv.zzb((Object) t, (long) (zzax(i2) & 1048575), i);
    }
}
