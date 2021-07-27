package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GetAccessTokenAidlRequestCreator")
public final class zzau extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzau> CREATOR = new zzav();
    @SafeParcelable.Field(getter = "getRefreshToken", mo10718id = 1)
    private final String zzid;

    @SafeParcelable.Constructor
    public zzau(@SafeParcelable.Param(mo10721id = 1) @NonNull String str) {
        this.zzid = str;
    }

    public final String zzr() {
        return this.zzid;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzid, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
