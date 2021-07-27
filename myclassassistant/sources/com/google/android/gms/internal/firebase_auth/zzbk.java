package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SendVerificationCodeAidlRequestCreator")
public final class zzbk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbk> CREATOR = new zzbl();
    @SafeParcelable.Field(getter = "getSendVerificationCodeRequest", mo10718id = 1)
    private final zzdj zzih;

    @SafeParcelable.Constructor
    public zzbk(@SafeParcelable.Param(mo10721id = 1) @NonNull zzdj zzdj) {
        this.zzih = zzdj;
    }

    public final zzdj zzcr() {
        return this.zzih;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzih, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
