package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

public final class zzdn implements zzff<zzj.zzn> {
    private String zzgh;
    private String zzgi;
    @Nullable
    private String zzgw;
    @Nullable
    private String zzhw;

    public zzdn(@Nullable String str) {
        this.zzgw = str;
    }

    public zzdn(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4) {
        this.zzgh = Preconditions.checkNotEmpty(str);
        this.zzgi = Preconditions.checkNotEmpty(str2);
        this.zzhw = null;
        this.zzgw = str4;
    }

    public final /* synthetic */ zzhb zzds() {
        zzj.zzn.zza zzap = zzj.zzn.zzap();
        if (this.zzgh != null) {
            zzap.zzau(this.zzgh);
        }
        if (this.zzgi != null) {
            zzap.zzav(this.zzgi);
        }
        if (this.zzgw != null) {
            zzap.zzaw(this.zzgw);
        }
        return (zzj.zzn) ((zzfs) zzap.zzhm());
    }
}
