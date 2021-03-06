package com.google.android.gms.internal.firebase_auth;

import java.util.Map;

final class zzif implements Comparable<zzif>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzhy zzabc;
    private final K zzabf;

    zzif(zzhy zzhy, Map.Entry<K, V> entry) {
        this(zzhy, (Comparable) entry.getKey(), entry.getValue());
    }

    zzif(zzhy zzhy, K k, V v) {
        this.zzabc = zzhy;
        this.zzabf = k;
        this.value = v;
    }

    public final V getValue() {
        return this.value;
    }

    public final V setValue(V v) {
        this.zzabc.zzjg();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (!equals(this.zzabf, entry.getKey()) || !equals(this.value, entry.getValue())) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        int hashCode = this.zzabf == null ? 0 : this.zzabf.hashCode();
        if (this.value != null) {
            i = this.value.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzabf);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public final /* synthetic */ Object getKey() {
        return this.zzabf;
    }

    public final /* synthetic */ int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((zzif) obj).getKey());
    }
}
