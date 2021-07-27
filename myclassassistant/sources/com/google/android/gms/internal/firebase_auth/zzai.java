package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ChangeEmailAidlRequestCreator")
public final class zzai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzai> CREATOR = new zzaj();
    @SafeParcelable.Field(getter = "getEmail", mo10718id = 2)
    private final String zzgh;
    @SafeParcelable.Field(getter = "getCachedState", mo10718id = 1)
    private final String zzgk;

    @SafeParcelable.Constructor
    public zzai(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) @NonNull String str2) {
        this.zzgk = str;
        this.zzgh = str2;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgk, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
