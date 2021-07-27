package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzdw;

@SafeParcelable.Class(creator = "VerifyCustomTokenResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdv extends AbstractSafeParcelable implements zzdw<zzdv, zzj.zzs> {
    public static final Parcelable.Creator<zzdv> CREATOR = new zzdw();
    @SafeParcelable.Field(getter = "getIdToken", mo10718id = 2)
    private String zzgc;
    @SafeParcelable.Field(getter = "getRefreshToken", mo10718id = 3)
    private String zzid;
    @SafeParcelable.Field(getter = "isNewUser", mo10718id = 5)
    private boolean zzor;
    @SafeParcelable.Field(getter = "getExpiresIn", mo10718id = 4)
    private long zzos;

    public zzdv() {
    }

    @SafeParcelable.Constructor
    zzdv(@SafeParcelable.Param(mo10721id = 2) String str, @SafeParcelable.Param(mo10721id = 3) String str2, @SafeParcelable.Param(mo10721id = 4) long j, @SafeParcelable.Param(mo10721id = 5) boolean z) {
        this.zzgc = str;
        this.zzid = str2;
        this.zzos = j;
        this.zzor = z;
    }

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

    public final boolean isNewUser() {
        return this.zzor;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzgc, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzid, false);
        SafeParcelWriter.writeLong(parcel, 4, this.zzos);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzor);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzhl<zzj.zzs> zzdj() {
        return zzj.zzs.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhb zzhb) {
        if (!(zzhb instanceof zzj.zzs)) {
            throw new IllegalArgumentException("The passed proto must be an instance of VerifyCustomTokenResponse.");
        }
        zzj.zzs zzs = (zzj.zzs) zzhb;
        this.zzgc = Strings.emptyToNull(zzs.getIdToken());
        this.zzid = Strings.emptyToNull(zzs.zzr());
        this.zzos = zzs.zzs();
        this.zzor = zzs.zzt();
        return this;
    }
}
