package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.ActionCodeSettings;

@SafeParcelable.Class(creator = "SendEmailVerificationWithSettingsAidlRequestCreator")
public final class zzbg extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbg> CREATOR = new zzbh();
    @SafeParcelable.Field(getter = "getToken", mo10718id = 1)
    private final String zzhm;
    @Nullable
    @SafeParcelable.Field(getter = "getActionCodeSettings", mo10718id = 2)
    private final ActionCodeSettings zzig;

    @SafeParcelable.Constructor
    public zzbg(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @Nullable @SafeParcelable.Param(mo10721id = 2) ActionCodeSettings actionCodeSettings) {
        this.zzhm = str;
        this.zzig = actionCodeSettings;
    }

    public final String getToken() {
        return this.zzhm;
    }

    @Nullable
    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhm, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzig, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
