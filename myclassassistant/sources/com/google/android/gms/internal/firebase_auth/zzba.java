package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "LinkFederatedCredentialAidlRequestCreator")
public final class zzba extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzba> CREATOR = new zzbb();
    @SafeParcelable.Field(getter = "getCachedState", mo10718id = 1)
    private final String zzgk;
    @SafeParcelable.Field(getter = "getVerifyAssertionRequest", mo10718id = 2)
    private final zzdr zzie;

    @SafeParcelable.Constructor
    public zzba(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) @NonNull zzdr zzdr) {
        this.zzgk = str;
        this.zzie = zzdr;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final zzdr zzco() {
        return this.zzie;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgk, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzie, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
