package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzdr;

@SafeParcelable.Class(creator = "GoogleAuthCredentialCreator")
public class GoogleAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GoogleAuthCredential> CREATOR = new zzu();
    @SafeParcelable.Field(getter = "getIdToken", mo10718id = 1)
    private final String zzgc;
    @SafeParcelable.Field(getter = "getAccessToken", mo10718id = 2)
    private final String zzgd;

    @SafeParcelable.Constructor
    GoogleAuthCredential(@Nullable @SafeParcelable.Param(mo10721id = 1) String str, @Nullable @SafeParcelable.Param(mo10721id = 2) String str2) {
        if (str == null && str2 == null) {
            throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
        }
        this.zzgc = zza(str, "idToken");
        this.zzgd = zza(str2, "accessToken");
    }

    public String getProvider() {
        return "google.com";
    }

    public String getSignInMethod() {
        return "google.com";
    }

    public static zzdr zza(@NonNull GoogleAuthCredential googleAuthCredential, @Nullable String str) {
        Preconditions.checkNotNull(googleAuthCredential);
        return new zzdr(googleAuthCredential.zzgc, googleAuthCredential.zzgd, googleAuthCredential.getProvider(), (String) null, (String) null, (String) null, str, (String) null);
    }

    private static String zza(String str, String str2) {
        if (str == null || !TextUtils.isEmpty(str)) {
            return str;
        }
        throw new IllegalArgumentException(String.valueOf(str2).concat(" must not be empty"));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgc, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgd, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
