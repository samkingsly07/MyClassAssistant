package com.google.android.gms.internal.firebase_auth;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zziv {
    private static final Logger logger = Logger.getLogger(zziv.class.getName());
    private static final boolean zzabt = zzk(Long.TYPE);
    private static final boolean zzabu = zzk(Integer.TYPE);
    private static final zzd zzabv;
    private static final boolean zzabw = zzju();
    private static final long zzabx = ((long) zzi(byte[].class));
    private static final long zzaby = ((long) zzi(boolean[].class));
    private static final long zzabz = ((long) zzj(boolean[].class));
    private static final long zzaca = ((long) zzi(int[].class));
    private static final long zzacb = ((long) zzj(int[].class));
    private static final long zzacc = ((long) zzi(long[].class));
    private static final long zzacd = ((long) zzj(long[].class));
    private static final long zzace = ((long) zzi(float[].class));
    private static final long zzacf = ((long) zzj(float[].class));
    private static final long zzacg = ((long) zzi(double[].class));
    private static final long zzach = ((long) zzj(double[].class));
    private static final long zzaci = ((long) zzi(Object[].class));
    private static final long zzacj = ((long) zzj(Object[].class));
    private static final long zzack;
    /* access modifiers changed from: private */
    public static final boolean zzacl = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);
    private static final Class<?> zzsk = zzee.zzey();
    private static final boolean zztp = zzjt();
    private static final Unsafe zzzk = zzjs();

    private zziv() {
    }

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zziv.zzacl) {
                return zziv.zzq(obj, j);
            }
            return zziv.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zziv.zzacl) {
                zziv.zza(obj, j, b);
            } else {
                zziv.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zziv.zzacl) {
                return zziv.zzs(obj, j);
            }
            return zziv.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zziv.zzacl) {
                zziv.zzb(obj, j, z);
            } else {
                zziv.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            if (zziv.zzacl) {
                return zziv.zzq(obj, j);
            }
            return zziv.zzr(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            if (zziv.zzacl) {
                zziv.zza(obj, j, b);
            } else {
                zziv.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            if (zziv.zzacl) {
                return zziv.zzs(obj, j);
            }
            return zziv.zzt(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zziv.zzacl) {
                zziv.zzb(obj, j, z);
            } else {
                zziv.zzc(obj, j, z);
            }
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzacm.getByte(obj, j);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzacm.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzacm.getBoolean(obj, j);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzacm.putBoolean(obj, j, z);
        }

        public final float zzn(Object obj, long j) {
            return this.zzacm.getFloat(obj, j);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzacm.putFloat(obj, j, f);
        }

        public final double zzo(Object obj, long j) {
            return this.zzacm.getDouble(obj, j);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzacm.putDouble(obj, j, d);
        }
    }

    static boolean zzjq() {
        return zztp;
    }

    static abstract class zzd {
        Unsafe zzacm;

        zzd(Unsafe unsafe) {
            this.zzacm = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public abstract void zza(Object obj, long j, boolean z);

        public abstract void zze(Object obj, long j, byte b);

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);

        public final int zzk(Object obj, long j) {
            return this.zzacm.getInt(obj, j);
        }

        public final void zzb(Object obj, long j, int i) {
            this.zzacm.putInt(obj, j, i);
        }

        public final long zzl(Object obj, long j) {
            return this.zzacm.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zzacm.putLong(obj, j, j2);
        }
    }

    static boolean zzjr() {
        return zzabw;
    }

    static <T> T zzh(Class<T> cls) {
        try {
            return zzzk.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzi(Class<?> cls) {
        if (zztp) {
            return zzabv.zzacm.arrayBaseOffset(cls);
        }
        return -1;
    }

    private static int zzj(Class<?> cls) {
        if (zztp) {
            return zzabv.zzacm.arrayIndexScale(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzabv.zzk(obj, j);
    }

    static void zzb(Object obj, long j, int i) {
        zzabv.zzb(obj, j, i);
    }

    static long zzl(Object obj, long j) {
        return zzabv.zzl(obj, j);
    }

    static void zza(Object obj, long j, long j2) {
        zzabv.zza(obj, j, j2);
    }

    static boolean zzm(Object obj, long j) {
        return zzabv.zzm(obj, j);
    }

    static void zza(Object obj, long j, boolean z) {
        zzabv.zza(obj, j, z);
    }

    static float zzn(Object obj, long j) {
        return zzabv.zzn(obj, j);
    }

    static void zza(Object obj, long j, float f) {
        zzabv.zza(obj, j, f);
    }

    static double zzo(Object obj, long j) {
        return zzabv.zzo(obj, j);
    }

    static void zza(Object obj, long j, double d) {
        zzabv.zza(obj, j, d);
    }

    static Object zzp(Object obj, long j) {
        return zzabv.zzacm.getObject(obj, j);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzabv.zzacm.putObject(obj, j, obj2);
    }

    static byte zza(byte[] bArr, long j) {
        return zzabv.zzy(bArr, zzabx + j);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzabv.zze(bArr, zzabx + j, b);
    }

    static Unsafe zzjs() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zziw());
        } catch (Throwable th) {
            return null;
        }
    }

    private static boolean zzjt() {
        if (zzzk == null) {
            return false;
        }
        try {
            Class<?> cls = zzzk.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzee.zzex()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzju() {
        if (zzzk == null) {
            return false;
        }
        try {
            Class<?> cls = zzzk.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzjv() == null) {
                return false;
            }
            if (zzee.zzex()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzk(Class<?> cls) {
        if (!zzee.zzex()) {
            return false;
        }
        try {
            Class<?> cls2 = zzsk;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    private static Field zzjv() {
        Field zzb2;
        if (zzee.zzex() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            Field declaredField = cls.getDeclaredField(str);
            declaredField.setAccessible(true);
            return declaredField;
        } catch (Throwable th) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, j & -4) >>> ((int) (((j ^ -1) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, j & -4) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = j & -4;
        int i = ((((int) j) ^ -1) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = j & -4;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & ((255 << i) ^ -1)));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static {
        long j;
        zzd zzd2 = null;
        if (zzzk != null) {
            if (!zzee.zzex()) {
                zzd2 = new zzc(zzzk);
            } else if (zzabt) {
                zzd2 = new zzb(zzzk);
            } else if (zzabu) {
                zzd2 = new zza(zzzk);
            }
        }
        zzabv = zzd2;
        Field zzjv = zzjv();
        if (zzjv == null || zzabv == null) {
            j = -1;
        } else {
            j = zzabv.zzacm.objectFieldOffset(zzjv);
        }
        zzack = j;
    }
}
