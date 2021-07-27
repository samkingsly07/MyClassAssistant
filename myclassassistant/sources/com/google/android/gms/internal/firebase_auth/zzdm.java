package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.Nullable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzdw;
import java.util.List;

public final class zzdm implements zzdw<zzdm, zzj.zzm> {
    private String zzgc;
    private String zzgh;
    private String zzgi;
    private String zzhw;
    private String zzhx;
    private String zzid;
    private long zzos;
    private zzdd zzpb;
    private Boolean zzpv;

    @Nullable
    public final String getIdToken() {
        return this.zzgc;
    }

    @Nullable
    public final String zzr() {
        return this.zzid;
    }

    public final long zzs() {
        return this.zzos;
    }

    @Nullable
    public final String getEmail() {
        return this.zzgh;
    }

    public final List<zzdb> zzdu() {
        if (this.zzpb != null) {
            return this.zzpb.zzdu();
        }
        return null;
    }

    public final zzhl<zzj.zzm> zzdj() {
        return zzj.zzm.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhb zzhb) {
        if (!(zzhb instanceof zzj.zzm)) {
            throw new IllegalArgumentException("The passed proto must be an instance of SetAccountInfoResponse.");
        }
        zzj.zzm zzm = (zzj.zzm) zzhb;
        this.zzgh = Strings.emptyToNull(zzm.getEmail());
        this.zzgi = Strings.emptyToNull(zzm.zzam());
        this.zzpv = Boolean.valueOf(zzm.zzan());
        this.zzhw = Strings.emptyToNull(zzm.getDisplayName());
        this.zzhx = Strings.emptyToNull(zzm.zzal());
        this.zzpb = zzdd.zzc(zzm.zzak());
        this.zzgc = Strings.emptyToNull(zzm.getIdToken());
        this.zzid = Strings.emptyToNull(zzm.zzr());
        this.zzos = zzm.zzs();
        return this;
    }
}
