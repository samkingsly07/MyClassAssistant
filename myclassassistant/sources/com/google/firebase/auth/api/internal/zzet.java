package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.PhoneAuthProvider;

final class zzet implements zzev {
    private final /* synthetic */ Status zzoa;

    zzet(zzep zzep, Status status) {
        this.zzoa = status;
    }

    public final void zza(PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, Object... objArr) {
        onVerificationStateChangedCallbacks.onVerificationFailed(zzds.zzb(this.zzoa));
    }
}
