package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

final class zzgh<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzyn;

    public zzgh(Iterator<Map.Entry<K, Object>> it) {
        this.zzyn = it;
    }

    public final boolean hasNext() {
        return this.zzyn.hasNext();
    }

    public final void remove() {
        this.zzyn.remove();
    }

    public final /* synthetic */ Object next() {
        Map.Entry next = this.zzyn.next();
        if (next.getValue() instanceof zzge) {
            return new zzgg(next);
        }
        return next;
    }
}
