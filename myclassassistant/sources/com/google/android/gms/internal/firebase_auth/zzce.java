package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.UserProfileChangeRequest;

@SafeParcelable.Class(creator = "UpdateProfileAidlRequestCreator")
public final class zzce extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzce> CREATOR = new zzcf();
    @SafeParcelable.Field(getter = "getCachedState", mo10718id = 2)
    private final String zzgk;
    @SafeParcelable.Field(getter = "getUserProfileChangeRequest", mo10718id = 1)
    private final UserProfileChangeRequest zzil;

    @SafeParcelable.Constructor
    public zzce(@SafeParcelable.Param(mo10721id = 1) @NonNull UserProfileChangeRequest userProfileChangeRequest, @SafeParcelable.Param(mo10721id = 2) @NonNull String str) {
        this.zzil = userProfileChangeRequest;
        this.zzgk = str;
    }

    public final UserProfileChangeRequest zzcu() {
        return this.zzil;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzil, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
