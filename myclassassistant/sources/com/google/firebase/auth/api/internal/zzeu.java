package com.google.firebase.auth.api.internal;

final class zzeu implements Runnable {
    private final /* synthetic */ zzev zzob;
    private final /* synthetic */ zzep zzoc;

    zzeu(zzep zzep, zzev zzev) {
        this.zzoc = zzep;
        this.zzob = zzev;
    }

    public final void run() {
        synchronized (this.zzoc.zznx.zznh) {
            if (!this.zzoc.zznx.zznh.isEmpty()) {
                this.zzob.zza(this.zzoc.zznx.zznh.get(0), new Object[0]);
            }
        }
    }
}
