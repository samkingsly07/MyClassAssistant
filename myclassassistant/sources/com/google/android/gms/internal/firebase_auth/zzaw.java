package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "GetProvidersForEmailAidlRequestCreator")
public final class zzaw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzaw> CREATOR = new zzax();
    @SafeParcelable.Field(getter = "getEmail", mo10718id = 1)
    private final String zzgh;
    @Nullable
    @SafeParcelable.Field(getter = "getTenantId", mo10718id = 2)
    private final String zzgw;

    @SafeParcelable.Constructor
    public zzaw(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @Nullable @SafeParcelable.Param(mo10721id = 2) String str2) {
        this.zzgh = str;
        this.zzgw = str2;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    @Nullable
    public final String zzcf() {
        return this.zzgw;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
