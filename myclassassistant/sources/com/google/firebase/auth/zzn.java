package com.google.firebase.auth;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthProvider;

final class zzn extends PhoneAuthProvider.OnVerificationStateChangedCallbacks {
    private final /* synthetic */ FirebaseAuth zzhc;
    private final /* synthetic */ PhoneAuthProvider.OnVerificationStateChangedCallbacks zzhf;

    zzn(FirebaseAuth firebaseAuth, PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks) {
        this.zzhc = firebaseAuth;
        this.zzhf = onVerificationStateChangedCallbacks;
    }

    public final void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        this.zzhf.onVerificationCompleted(phoneAuthCredential);
    }

    public final void onCodeSent(String str, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
        this.zzhf.onVerificationCompleted(PhoneAuthProvider.getCredential(str, this.zzhc.zzgs.getSmsCode()));
    }

    public final void onCodeAutoRetrievalTimeOut(String str) {
    }

    public final void onVerificationFailed(FirebaseException firebaseException) {
        this.zzhf.onVerificationFailed(firebaseException);
    }
}
