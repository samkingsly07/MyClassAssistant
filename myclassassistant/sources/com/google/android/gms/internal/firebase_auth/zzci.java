package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

public final class zzci implements zzff<zzj.zza> {
    @Nullable
    private final String zzgw;
    private String zzoj;
    private String zzok = "http://localhost";

    public zzci(@NonNull String str, @Nullable String str2) {
        this.zzoj = Preconditions.checkNotEmpty(str);
        this.zzgw = str2;
    }

    public final /* synthetic */ zzhb zzds() {
        zzj.zza.C0747zza zze = zzj.zza.zzc().zzd(this.zzoj).zze(this.zzok);
        if (this.zzgw != null) {
            zze.zzf(this.zzgw);
        }
        return (zzj.zza) ((zzfs) zze.zzhm());
    }
}
