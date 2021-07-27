package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.zzd;

@SafeParcelable.Class(creator = "OnFailedIdpSignInAidlResponseCreator")
public final class zzcg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcg> CREATOR = new zzch();
    @SafeParcelable.Field(getter = "getEmail", mo10718id = 3)
    private final String zzgh;
    @SafeParcelable.Field(getter = "getStatus", mo10718id = 1)
    private final Status zzim;
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", mo10718id = 2)
    private final zzd zzin;

    @SafeParcelable.Constructor
    public zzcg(@SafeParcelable.Param(mo10721id = 1) @NonNull Status status, @SafeParcelable.Param(mo10721id = 2) @NonNull zzd zzd, @SafeParcelable.Param(mo10721id = 3) @NonNull String str) {
        this.zzim = status;
        this.zzin = zzd;
        this.zzgh = str;
    }

    public final Status getStatus() {
        return this.zzim;
    }

    public final zzd zzcv() {
        return this.zzin;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzim, i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzin, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
