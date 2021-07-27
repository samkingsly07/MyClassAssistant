package com.google.android.gms.internal.firebase_auth;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

class zzih extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzhy zzabc;

    private zzih(zzhy zzhy) {
        this.zzabc = zzhy;
    }

    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzig(this.zzabc, (zzhz) null);
    }

    public int size() {
        return this.zzabc.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzabc.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zzabc.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzabc.clear();
    }

    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzabc.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzih(zzhy zzhy, zzhz zzhz) {
        this(zzhy);
    }
}
