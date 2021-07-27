package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

final class zzig implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private Iterator<Map.Entry<K, V>> zzabb;
    private final /* synthetic */ zzhy zzabc;
    private boolean zzabg;

    private zzig(zzhy zzhy) {
        this.zzabc = zzhy;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzabc.zzaaw.size() || (!this.zzabc.zzaax.isEmpty() && zzji().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (!this.zzabg) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzabg = false;
        this.zzabc.zzjg();
        if (this.pos < this.zzabc.zzaaw.size()) {
            zzhy zzhy = this.zzabc;
            int i = this.pos;
            this.pos = i - 1;
            Object unused = zzhy.zzbc(i);
            return;
        }
        zzji().remove();
    }

    private final Iterator<Map.Entry<K, V>> zzji() {
        if (this.zzabb == null) {
            this.zzabb = this.zzabc.zzaax.entrySet().iterator();
        }
        return this.zzabb;
    }

    public final /* synthetic */ Object next() {
        this.zzabg = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzabc.zzaaw.size()) {
            return (Map.Entry) this.zzabc.zzaaw.get(this.pos);
        }
        return (Map.Entry) zzji().next();
    }

    /* synthetic */ zzig(zzhy zzhy, zzhz zzhz) {
        this(zzhy);
    }
}
