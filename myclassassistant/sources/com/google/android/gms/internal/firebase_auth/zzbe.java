package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ReloadAidlRequestCreator")
public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbf();
    @SafeParcelable.Field(getter = "getCachedState", mo10718id = 1)
    private final String zzgk;

    @SafeParcelable.Constructor
    public zzbe(@SafeParcelable.Param(mo10721id = 1) @NonNull String str) {
        this.zzgk = str;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgk, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
