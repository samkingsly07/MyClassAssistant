package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ConfirmPasswordResetAidlRequestCreator")
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new zzap();
    @Nullable
    @SafeParcelable.Field(getter = "getTenantId", mo10718id = 3)
    private final String zzgw;
    @SafeParcelable.Field(getter = "getCode", mo10718id = 1)
    private final String zzib;
    @SafeParcelable.Field(getter = "getNewPassword", mo10718id = 2)
    private final String zzic;

    @SafeParcelable.Constructor
    public zzao(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) @NonNull String str2, @Nullable @SafeParcelable.Param(mo10721id = 3) String str3) {
        this.zzib = str;
        this.zzic = str2;
        this.zzgw = str3;
    }

    public final String zzcm() {
        return this.zzib;
    }

    public final String zzcn() {
        return this.zzic;
    }

    @Nullable
    public final String zzcf() {
        return this.zzgw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzib, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzic, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
