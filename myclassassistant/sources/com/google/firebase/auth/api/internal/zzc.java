package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdo;
import com.google.firebase.auth.internal.zzq;
import com.google.firebase.auth.zzd;

final class zzc implements zzez<zzdo> {
    private final /* synthetic */ zzdp zzir;
    private final /* synthetic */ zza zzis;

    zzc(zza zza, zzdp zzdp) {
        this.zzis = zza;
        this.zzir = zzdp;
    }

    public final void zzbp(@Nullable String str) {
        this.zzir.onFailure(zzq.zzct(str));
    }

    public final /* synthetic */ void onSuccess(@NonNull Object obj) {
        zzdo zzdo = (zzdo) obj;
        this.zzis.zza(new zzcz(zzdo.zzr(), zzdo.getIdToken(), Long.valueOf(zzdo.zzs()), "Bearer"), (String) null, (String) null, true, (zzd) null, this.zzir, this);
    }
}
