package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.PhoneAuthCredential;

@SafeParcelable.Class(creator = "SignInWithPhoneNumberAidlRequestCreator")
public final class zzby extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzby> CREATOR = new zzbz();
    @Nullable
    @SafeParcelable.Field(getter = "getTenantId", mo10718id = 2)
    private final String zzgw;
    @SafeParcelable.Field(getter = "getCredential", mo10718id = 1)
    private final PhoneAuthCredential zzif;

    @SafeParcelable.Constructor
    public zzby(@SafeParcelable.Param(mo10721id = 1) @NonNull PhoneAuthCredential phoneAuthCredential, @Nullable @SafeParcelable.Param(mo10721id = 2) String str) {
        this.zzif = phoneAuthCredential;
        this.zzgw = str;
    }

    public final PhoneAuthCredential zzcp() {
        return this.zzif;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzif, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
