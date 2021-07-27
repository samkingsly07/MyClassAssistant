package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInWithCredentialAidlRequestCreator")
public final class zzbq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbq> CREATOR = new zzbr();
    @SafeParcelable.Field(getter = "getVerifyAssertionRequest", mo10718id = 1)
    private final zzdr zzie;

    @SafeParcelable.Constructor
    public zzbq(@SafeParcelable.Param(mo10721id = 1) @NonNull zzdr zzdr) {
        this.zzie = zzdr;
    }

    public final zzdr zzco() {
        return this.zzie;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzie, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
