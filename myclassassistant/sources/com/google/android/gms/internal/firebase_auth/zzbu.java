package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInWithEmailAndPasswordAidlRequestCreator")
public final class zzbu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbu> CREATOR = new zzbv();
    @SafeParcelable.Field(getter = "getEmail", mo10718id = 1)
    private final String zzgh;
    @SafeParcelable.Field(getter = "getPassword", mo10718id = 2)
    private final String zzgi;
    @Nullable
    @SafeParcelable.Field(getter = "getTenantId", mo10718id = 3)
    private final String zzgw;

    @SafeParcelable.Constructor
    public zzbu(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) @NonNull String str2, @Nullable @SafeParcelable.Param(mo10721id = 3) String str3) {
        this.zzgh = str;
        this.zzgi = str2;
        this.zzgw = str3;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String getPassword() {
        return this.zzgi;
    }

    @Nullable
    public final String zzcf() {
        return this.zzgw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgi, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
