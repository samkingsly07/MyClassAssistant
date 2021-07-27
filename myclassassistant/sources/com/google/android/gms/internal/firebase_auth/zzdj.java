package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

@SafeParcelable.Class(creator = "SendVerificationCodeRequestCreator")
public final class zzdj extends AbstractSafeParcelable implements zzff<zzj.zzk> {
    public static final Parcelable.Creator<zzdj> CREATOR = new zzdk();
    @Nullable
    @SafeParcelable.Field(getter = "getTenantId", mo10718id = 5)
    private final String zzgw;
    @SafeParcelable.Field(getter = "getPhoneNumber", mo10718id = 1)
    private final String zzhq;
    @SafeParcelable.Field(getter = "getTimeoutInSeconds", mo10718id = 2)
    private final long zzpo;
    @SafeParcelable.Field(getter = "getForceNewSmsVerificationSession", mo10718id = 3)
    private final boolean zzpp;
    @SafeParcelable.Field(getter = "getLanguageHeader", mo10718id = 4)
    private final String zzpq;

    @SafeParcelable.Constructor
    public zzdj(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) long j, @SafeParcelable.Param(mo10721id = 3) boolean z, @SafeParcelable.Param(mo10721id = 4) String str2, @Nullable @SafeParcelable.Param(mo10721id = 5) String str3) {
        this.zzhq = Preconditions.checkNotEmpty(str);
        this.zzpo = j;
        this.zzpp = z;
        this.zzpq = str2;
        this.zzgw = str3;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhq, false);
        SafeParcelWriter.writeLong(parcel, 2, this.zzpo);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzpp);
        SafeParcelWriter.writeString(parcel, 4, this.zzpq, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ zzhb zzds() {
        zzj.zzk.zza zzaj = zzj.zzk.zzag().zzaj(this.zzhq);
        if (this.zzgw != null) {
            zzaj.zzak(this.zzgw);
        }
        return (zzj.zzk) ((zzfs) zzaj.zzhm());
    }
}
