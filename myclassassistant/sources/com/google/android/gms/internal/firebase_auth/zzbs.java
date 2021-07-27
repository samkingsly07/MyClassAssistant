package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInWithCustomTokenAidlRequestCreator")
public final class zzbs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbs> CREATOR = new zzbt();
    @SafeParcelable.Field(getter = "getToken", mo10718id = 1)
    private final String zzhm;

    @SafeParcelable.Constructor
    public zzbs(@SafeParcelable.Param(mo10721id = 1) @NonNull String str) {
        this.zzhm = str;
    }

    public final String getToken() {
        return this.zzhm;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
