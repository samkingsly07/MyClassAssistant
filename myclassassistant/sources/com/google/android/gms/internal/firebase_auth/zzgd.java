package com.google.android.gms.internal.firebase_auth;

public enum zzgd {
    VOID(Void.class, Void.class, (Class<?>) null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzeh.class, zzeh.class, zzeh.zzso),
    ENUM(Integer.TYPE, Integer.class, (Class<?>) null),
    MESSAGE(Object.class, Object.class, (Class<?>) null);
    
    private final Class<?> zzyi;
    private final Class<?> zzyj;
    private final Object zzyk;

    private zzgd(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzyi = cls;
        this.zzyj = cls2;
        this.zzyk = obj;
    }

    public final Class<?> zzhy() {
        return this.zzyj;
    }
}
