package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzdr;

@SafeParcelable.Class(creator = "PlayGamesAuthCredentialCreator")
public class PlayGamesAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<PlayGamesAuthCredential> CREATOR = new zzx();
    @SafeParcelable.Field(getter = "getServerAuthCode", mo10718id = 1)
    private final String zzhu;

    @SafeParcelable.Constructor
    PlayGamesAuthCredential(@SafeParcelable.Param(mo10721id = 1) @NonNull String str) {
        this.zzhu = Preconditions.checkNotEmpty(str);
    }

    public String getProvider() {
        return "playgames.google.com";
    }

    public String getSignInMethod() {
        return "playgames.google.com";
    }

    public static zzdr zza(@NonNull PlayGamesAuthCredential playGamesAuthCredential, @Nullable String str) {
        Preconditions.checkNotNull(playGamesAuthCredential);
        return new zzdr((String) null, (String) null, playGamesAuthCredential.getProvider(), (String) null, (String) null, playGamesAuthCredential.zzhu, str, (String) null);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzhu, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
