package com.google.android.gms.internal.firebase_auth;

import java.util.Iterator;
import java.util.Map;

final class zzib extends zzih {
    private final /* synthetic */ zzhy zzabc;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzib(zzhy zzhy) {
        super(zzhy, (zzhz) null);
        this.zzabc = zzhy;
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzia(this.zzabc, (zzhz) null);
    }

    /* synthetic */ zzib(zzhy zzhy, zzhz zzhz) {
        this(zzhy);
    }
}
