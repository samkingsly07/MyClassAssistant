package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzdw;

public final class zzcn implements zzdw<zzcn, zzj.zze> {
    private String zzgc;
    private String zzgh;
    private String zzid;
    private String zzoq;
    private boolean zzor;
    private long zzos;

    @NonNull
    public final String getIdToken() {
        return this.zzgc;
    }

    @NonNull
    public final String zzr() {
        return this.zzid;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    public final long zzs() {
        return this.zzos;
    }

    public final zzhl<zzj.zze> zzdj() {
        return zzj.zze.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhb zzhb) {
        if (!(zzhb instanceof zzj.zze)) {
            throw new IllegalArgumentException("The passed proto must be an instance of EmailLinkSigninResponse.");
        }
        zzj.zze zze = (zzj.zze) zzhb;
        this.zzoq = Strings.emptyToNull(zze.getLocalId());
        this.zzgh = Strings.emptyToNull(zze.getEmail());
        this.zzgc = Strings.emptyToNull(zze.getIdToken());
        this.zzid = Strings.emptyToNull(zze.zzr());
        this.zzor = zze.zzt();
        this.zzos = zze.zzs();
        return this;
    }
}
