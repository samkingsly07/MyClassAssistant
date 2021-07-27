package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.EmailAuthCredential;

@SafeParcelable.Class(creator = "SignInWithEmailLinkAidlRequestCreator")
public final class zzbw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbw> CREATOR = new zzbx();
    @SafeParcelable.Field(getter = "getCredential", mo10718id = 1)
    private final EmailAuthCredential zzij;

    @SafeParcelable.Constructor
    public zzbw(@SafeParcelable.Param(mo10721id = 1) @NonNull EmailAuthCredential emailAuthCredential) {
        this.zzij = emailAuthCredential;
    }

    public final EmailAuthCredential zzct() {
        return this.zzij;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzij, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
