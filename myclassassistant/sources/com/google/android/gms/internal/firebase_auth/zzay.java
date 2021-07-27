package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LinkEmailAuthCredentialAidlRequestCreator")
public final class zzay extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzay> CREATOR = new zzaz();
    @SafeParcelable.Field(getter = "getEmail", mo10718id = 1)
    private final String zzgh;
    @SafeParcelable.Field(getter = "getPassword", mo10718id = 2)
    private final String zzgi;
    @SafeParcelable.Field(getter = "getCachedState", mo10718id = 3)
    private final String zzgk;

    @SafeParcelable.Constructor
    public zzay(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) @NonNull String str2, @SafeParcelable.Param(mo10721id = 3) @NonNull String str3) {
        this.zzgh = str;
        this.zzgi = str2;
        this.zzgk = str3;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgi, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
