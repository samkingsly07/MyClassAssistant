package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UnlinkFederatedCredentialAidlRequestCreator")
public final class zzcc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcc> CREATOR = new zzcd();
    @SafeParcelable.Field(getter = "getCachedState", mo10718id = 2)
    private final String zzgk;
    @SafeParcelable.Field(getter = "getProvider", mo10718id = 1)
    private final String zzik;

    @SafeParcelable.Constructor
    public zzcc(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) @NonNull String str2) {
        this.zzik = str;
        this.zzgk = str2;
    }

    public final String getProvider() {
        return this.zzik;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzik, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
