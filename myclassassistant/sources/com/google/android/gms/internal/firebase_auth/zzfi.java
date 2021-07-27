package com.google.android.gms.internal.firebase_auth;

final class zzfi {
    private static final zzfg<?> zztz = new zzfh();
    private static final zzfg<?> zzua = zzgr();

    private static zzfg<?> zzgr() {
        try {
            return (zzfg) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception e) {
            return null;
        }
    }

    static zzfg<?> zzgs() {
        return zztz;
    }

    static zzfg<?> zzgt() {
        if (zzua != null) {
            return zzua;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
