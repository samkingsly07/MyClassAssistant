package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

public final class zzcq implements zzff<zzj.zzf> {
    private String zzgc;

    public zzcq(@NonNull String str) {
        this.zzgc = Preconditions.checkNotEmpty(str);
    }

    public final /* synthetic */ zzhb zzds() {
        return (zzj.zzf) ((zzfs) zzj.zzf.zzv().zzo(this.zzgc).zzhm());
    }
}
