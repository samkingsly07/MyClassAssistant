package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SetFirebaseUiVersionAidlRequestCreator")
public final class zzbm extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbm> CREATOR = new zzbn();
    @SafeParcelable.Field(getter = "getFirebaseUiVersion", mo10718id = 1)
    private final String zzii;

    @SafeParcelable.Constructor
    public zzbm(@SafeParcelable.Param(mo10721id = 1) @NonNull String str) {
        this.zzii = str;
    }

    public final String zzcs() {
        return this.zzii;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzii, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
