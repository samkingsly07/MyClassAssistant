package com.google.android.gms.internal.firebase_auth;

import java.util.Map;

final class zzgg<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzge> zzym;

    private zzgg(Map.Entry<K, zzge> entry) {
        this.zzym = entry;
    }

    public final K getKey() {
        return this.zzym.getKey();
    }

    public final Object getValue() {
        if (this.zzym.getValue() == null) {
            return null;
        }
        return zzge.zzhz();
    }

    public final zzge zzia() {
        return this.zzym.getValue();
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzhb) {
            return this.zzym.getValue().zzj((zzhb) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
