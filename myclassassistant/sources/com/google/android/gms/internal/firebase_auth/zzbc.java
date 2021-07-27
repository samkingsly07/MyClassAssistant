package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.PhoneAuthCredential;

@SafeParcelable.Class(creator = "LinkPhoneAuthCredentialAidlRequestCreator")
public final class zzbc extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbc> CREATOR = new zzbd();
    @SafeParcelable.Field(getter = "getCachedState", mo10718id = 1)
    private final String zzgk;
    @SafeParcelable.Field(getter = "getCredential", mo10718id = 2)
    private final PhoneAuthCredential zzif;

    @SafeParcelable.Constructor
    public zzbc(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) @NonNull PhoneAuthCredential phoneAuthCredential) {
        this.zzgk = str;
        this.zzif = phoneAuthCredential;
    }

    public final String zzbx() {
        return this.zzgk;
    }

    public final PhoneAuthCredential zzcp() {
        return this.zzif;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgk, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzif, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
