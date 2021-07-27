package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzdr;

@SafeParcelable.Class(creator = "FacebookAuthCredentialCreator")
public class FacebookAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<FacebookAuthCredential> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getAccessToken", mo10718id = 1)
    private final String zzgd;

    @SafeParcelable.Constructor
    FacebookAuthCredential(@SafeParcelable.Param(mo10721id = 1) @NonNull String str) {
        this.zzgd = Preconditions.checkNotEmpty(str);
    }

    public String getProvider() {
        return "facebook.com";
    }

    public String getSignInMethod() {
        return "facebook.com";
    }

    public static zzdr zza(@NonNull FacebookAuthCredential facebookAuthCredential, @Nullable String str) {
        Preconditions.checkNotNull(facebookAuthCredential);
        return new zzdr((String) null, facebookAuthCredential.zzgd, facebookAuthCredential.getProvider(), (String) null, (String) null, (String) null, str, (String) null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
