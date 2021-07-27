package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzdw;

public final class zzdo implements zzdw<zzdo, zzj.zzo> {
    private String zzgc;
    private String zzgh;
    private String zzhw;
    private String zzid;
    private long zzos;

    public final String getIdToken() {
        return this.zzgc;
    }

    @NonNull
    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        return this.zzos;
    }

    public final zzhl<zzj.zzo> zzdj() {
        return zzj.zzo.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhb zzhb) {
        if (!(zzhb instanceof zzj.zzo)) {
            throw new IllegalArgumentException("The passed proto must be an instance of SignUpNewUserResponse.");
        }
        zzj.zzo zzo = (zzj.zzo) zzhb;
        this.zzgc = Strings.emptyToNull(zzo.getIdToken());
        this.zzhw = Strings.emptyToNull(zzo.getDisplayName());
        this.zzgh = Strings.emptyToNull(zzo.getEmail());
        this.zzid = Strings.emptyToNull(zzo.zzr());
        this.zzos = zzo.zzs();
        return this;
    }
}
