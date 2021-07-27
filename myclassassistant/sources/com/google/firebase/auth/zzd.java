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

@SafeParcelable.Class(creator = "DefaultOAuthCredentialCreator")
public class zzd extends zzv {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    @Nullable
    @SafeParcelable.Field(getter = "getProvider", mo10718id = 1)
    private final String zzgb;
    @Nullable
    @SafeParcelable.Field(getter = "getIdToken", mo10718id = 2)
    private final String zzgc;
    @Nullable
    @SafeParcelable.Field(getter = "getAccessToken", mo10718id = 3)
    private final String zzgd;
    @Nullable
    @SafeParcelable.Field(getter = "getWebSignInCredential", mo10718id = 4)
    private final zzdr zzge;
    @Nullable
    @SafeParcelable.Field(getter = "getPendingToken", mo10718id = 5)
    private final String zzgf;

    @SafeParcelable.Constructor
    zzd(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @Nullable @SafeParcelable.Param(mo10721id = 2) String str2, @Nullable @SafeParcelable.Param(mo10721id = 3) String str3, @Nullable @SafeParcelable.Param(mo10721id = 4) zzdr zzdr, @Nullable @SafeParcelable.Param(mo10721id = 5) String str4) {
        this.zzgb = str;
        this.zzgc = str2;
        this.zzgd = str3;
        this.zzge = zzdr;
        this.zzgf = str4;
    }

    public static zzd zza(String str, String str2, String str3) {
        return zzb(str, str2, str3, (String) null);
    }

    public static zzd zza(String str, String str2, String str3, String str4) {
        return zzb(str, str2, str3, str4);
    }

    private static zzd zzb(String str, String str2, String str3, @Nullable String str4) {
        Preconditions.checkNotEmpty(str, "Must specify a non-empty providerId");
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            return new zzd(str, str2, str3, (zzdr) null, str4);
        }
        throw new IllegalArgumentException("Must specify an idToken or an accessToken.");
    }

    public static zzd zza(@NonNull zzdr zzdr) {
        Preconditions.checkNotNull(zzdr, "Must specify a non-null webSignInCredential");
        return new zzd((String) null, (String) null, (String) null, zzdr, (String) null);
    }

    public String getProvider() {
        return this.zzgb;
    }

    public String getSignInMethod() {
        return this.zzgb;
    }

    @Nullable
    public final String zzay() {
        return this.zzgf;
    }

    public static zzdr zza(@NonNull zzd zzd, @Nullable String str) {
        Preconditions.checkNotNull(zzd);
        if (zzd.zzge != null) {
            return zzd.zzge;
        }
        return new zzdr(zzd.zzgc, zzd.zzgd, zzd.getProvider(), (String) null, (String) null, (String) null, str, zzd.zzgf);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getProvider(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgc, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgd, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzge, i, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzgf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
