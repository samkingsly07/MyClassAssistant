package com.google.android.gms.internal.firebase_auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

final class zzhn {
    private static final zzhn zzaae = new zzhn();
    private final zzhw zzaaf;
    private final ConcurrentMap<Class<?>, zzhv<?>> zzaag = new ConcurrentHashMap();

    public static zzhn zzit() {
        return zzaae;
    }

    public final <T> zzhv<T> zzf(Class<T> cls) {
        zzfu.zza(cls, "messageType");
        zzhv<T> zzhv = (zzhv) this.zzaag.get(cls);
        if (zzhv != null) {
            return zzhv;
        }
        zzhv<T> zze = this.zzaaf.zze(cls);
        zzfu.zza(cls, "messageType");
        zzfu.zza(zze, "schema");
        zzhv<T> putIfAbsent = this.zzaag.putIfAbsent(cls, zze);
        return putIfAbsent != null ? putIfAbsent : zze;
    }

    public final <T> zzhv<T> zzr(T t) {
        return zzf(t.getClass());
    }

    private zzhn() {
        String[] strArr = {"com.google.protobuf.AndroidProto3SchemaFactory"};
        zzhw zzhw = null;
        for (int i = 0; i <= 0; i++) {
            zzhw = zzdd(strArr[0]);
            if (zzhw != null) {
                break;
            }
        }
        this.zzaaf = zzhw == null ? new zzgq() : zzhw;
    }

    private static zzhw zzdd(String str) {
        try {
            return (zzhw) Class.forName(str).getConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Throwable th) {
            return null;
        }
    }
}
