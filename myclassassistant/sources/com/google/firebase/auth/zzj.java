package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

final class zzj implements Runnable {
    private final /* synthetic */ FirebaseAuth zzhc;
    private final /* synthetic */ FirebaseAuth.AuthStateListener zzhd;

    zzj(FirebaseAuth firebaseAuth, FirebaseAuth.AuthStateListener authStateListener) {
        this.zzhc = firebaseAuth;
        this.zzhd = authStateListener;
    }

    public final void run() {
        this.zzhd.onAuthStateChanged(this.zzhc);
    }
}
