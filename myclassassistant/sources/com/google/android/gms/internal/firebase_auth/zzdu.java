package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

public final class zzdu implements zzff<zzj.zzr> {
    private String zzhm;
    private boolean zzpt = true;

    public zzdu(@NonNull String str) {
        this.zzhm = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzhb zzds() {
        return (zzj.zzr) ((zzfs) zzj.zzr.zzba().zzbi(this.zzhm).zzl(this.zzpt).zzhm());
    }
}
