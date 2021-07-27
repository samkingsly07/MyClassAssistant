package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ChangePasswordAidlRequestCreator")
public final class zzak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzak> CREATOR = new zzal();
    @SafeParcelable.Field(getter = "getPassword", mo10718id = 2)
    private final String zzgi;
    @SafeParcelable.Field(getter = "getCachedState", mo10718id = 1)
    private final String zzgk;

    @SafeParcelable.Constructor
    public zzak(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) @NonNull String str2) {
        this.zzgk = str;
        this.zzgi = str2;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgk, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
