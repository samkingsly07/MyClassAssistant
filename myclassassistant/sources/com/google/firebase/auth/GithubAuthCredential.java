package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzdr;

@SafeParcelable.Class(creator = "GithubAuthCredentialCreator")
public class GithubAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<GithubAuthCredential> CREATOR = new zzt();
    @SafeParcelable.Field(getter = "getToken", mo10718id = 1)
    private String zzhm;

    @SafeParcelable.Constructor
    GithubAuthCredential(@SafeParcelable.Param(mo10721id = 1) @NonNull String str) {
        this.zzhm = Preconditions.checkNotEmpty(str);
    }

    public String getProvider() {
        return "github.com";
    }

    public String getSignInMethod() {
        return "github.com";
    }

    public static zzdr zza(@NonNull GithubAuthCredential githubAuthCredential, @Nullable String str) {
        Preconditions.checkNotNull(githubAuthCredential);
        return new zzdr((String) null, githubAuthCredential.zzhm, githubAuthCredential.getProvider(), (String) null, (String) null, (String) null, str, (String) null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhm, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
