package com.google.firebase.auth.api.internal;

import com.google.firebase.auth.PhoneAuthProvider;

final class zzeq implements zzev {
    private final /* synthetic */ String zzny;

    zzeq(zzep zzep, String str) {
        this.zzny = str;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onCodeSent(this.zzny, PhoneAuthProvider.ForceResendingToken.zzcj());
    }
}
