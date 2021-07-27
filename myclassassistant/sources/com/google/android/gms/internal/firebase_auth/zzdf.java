package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

public final class zzdf implements zzff<zzj.zzi> {
    @Nullable
    private final String zzgw;
    private final String zzib;
    @Nullable
    private final String zzic;

    public zzdf(@NonNull String str, @Nullable String str2, @Nullable String str3) {
        this.zzib = Preconditions.checkNotEmpty(str);
        this.zzic = str2;
        this.zzgw = str3;
    }

    public final /* synthetic */ zzhb zzds() {
        zzj.zzi.zza zzaf = zzj.zzi.zzab().zzaf(this.zzib);
        if (this.zzic != null) {
            zzaf.zzag(this.zzic);
        }
        if (this.zzgw != null) {
            zzaf.zzah(this.zzgw);
        }
        return (zzj.zzi) ((zzfs) zzaf.zzhm());
    }
}
