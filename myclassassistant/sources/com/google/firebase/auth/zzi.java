package com.google.firebase.auth;

import com.google.firebase.auth.FirebaseAuth;

final class zzi implements Runnable {
    private final /* synthetic */ FirebaseAuth.IdTokenListener zzhb;
    private final /* synthetic */ FirebaseAuth zzhc;

    zzi(FirebaseAuth firebaseAuth, FirebaseAuth.IdTokenListener idTokenListener) {
        this.zzhc = firebaseAuth;
        this.zzhb = idTokenListener;
    }

    public final void run() {
        this.zzhb.onIdTokenChanged(this.zzhc);
    }
}
