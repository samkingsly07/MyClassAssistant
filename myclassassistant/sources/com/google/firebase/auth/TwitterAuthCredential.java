package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzdr;

@SafeParcelable.Class(creator = "TwitterAuthCredentialCreator")
public class TwitterAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<TwitterAuthCredential> CREATOR = new zzy();
    @SafeParcelable.Field(getter = "getToken", mo10718id = 1)
    private String zzhm;
    @SafeParcelable.Field(getter = "getSecret", mo10718id = 2)
    private String zzhv;

    @SafeParcelable.Constructor
    TwitterAuthCredential(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) @NonNull String str2) {
        this.zzhm = Preconditions.checkNotEmpty(str);
        this.zzhv = Preconditions.checkNotEmpty(str2);
    }

    public String getProvider() {
        return "twitter.com";
    }

    public String getSignInMethod() {
        return "twitter.com";
    }

    public static zzdr zza(@NonNull TwitterAuthCredential twitterAuthCredential, @Nullable String str) {
        Preconditions.checkNotNull(twitterAuthCredential);
        return new zzdr((String) null, twitterAuthCredential.zzhm, twitterAuthCredential.getProvider(), (String) null, twitterAuthCredential.zzhv, (String) null, str, (String) null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhm, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzhv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
