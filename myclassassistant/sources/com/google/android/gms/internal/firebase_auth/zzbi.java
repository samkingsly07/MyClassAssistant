package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.ActionCodeSettings;

@SafeParcelable.Class(creator = "SendGetOobConfirmationCodeEmailAidlRequestCreator")
public final class zzbi extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbi> CREATOR = new zzbj();
    @SafeParcelable.Field(getter = "getEmail", mo10718id = 1)
    private final String zzgh;
    @Nullable
    @SafeParcelable.Field(getter = "getTenantId", mo10718id = 3)
    private final String zzgw;
    @SafeParcelable.Field(getter = "getActionCodeSettings", mo10718id = 2)
    private final ActionCodeSettings zzig;

    @SafeParcelable.Constructor
    public zzbi(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) @NonNull ActionCodeSettings actionCodeSettings, @Nullable @SafeParcelable.Param(mo10721id = 3) String str2) {
        this.zzgh = str;
        this.zzig = actionCodeSettings;
        this.zzgw = str2;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final ActionCodeSettings zzcq() {
        return this.zzig;
    }

    public final String zzcf() {
        return this.zzgw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzig, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
