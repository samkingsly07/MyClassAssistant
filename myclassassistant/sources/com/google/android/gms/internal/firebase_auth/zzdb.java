package com.google.android.gms.internal.firebase_auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ProviderUserInfoCreator")
@SafeParcelable.Reserved({1})
public final class zzdb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdb> CREATOR = new zzdc();
    @SafeParcelable.Field(getter = "getProviderId", mo10718id = 5)
    private String zzgb;
    @SafeParcelable.Field(getter = "getEmail", mo10718id = 8)
    private String zzgh;
    @SafeParcelable.Field(getter = "getPhoneNumber", mo10718id = 7)
    private String zzhq;
    @SafeParcelable.Field(getter = "getDisplayName", mo10718id = 3)
    private String zzhw;
    @SafeParcelable.Field(getter = "getPhotoUrl", mo10718id = 4)
    private String zzhx;
    @SafeParcelable.Field(getter = "getFederatedId", mo10718id = 2)
    private String zzpk;
    @SafeParcelable.Field(getter = "getRawUserInfo", mo10718id = 6)
    private String zzpl;

    public zzdb() {
    }

    @SafeParcelable.Constructor
    zzdb(@SafeParcelable.Param(mo10721id = 2) String str, @SafeParcelable.Param(mo10721id = 3) String str2, @SafeParcelable.Param(mo10721id = 4) String str3, @SafeParcelable.Param(mo10721id = 5) String str4, @SafeParcelable.Param(mo10721id = 6) String str5, @SafeParcelable.Param(mo10721id = 7) String str6, @SafeParcelable.Param(mo10721id = 8) String str7) {
        this.zzpk = str;
        this.zzhw = str2;
        this.zzhx = str3;
        this.zzgb = str4;
        this.zzpl = str5;
        this.zzhq = str6;
        this.zzgh = str7;
    }

    public final String zzbg() {
        return this.zzpk;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzhw;
    }

    @Nullable
    public final Uri getPhotoUri() {
        if (!TextUtils.isEmpty(this.zzhx)) {
            return Uri.parse(this.zzhx);
        }
        return null;
    }

    public final String getProviderId() {
        return this.zzgb;
    }

    public final String getPhoneNumber() {
        return this.zzhq;
    }

    public final void zzcg(String str) {
        this.zzpl = str;
    }

    @Nullable
    public final String getRawUserInfo() {
        return this.zzpl;
    }

    @Nullable
    public final String getEmail() {
        return this.zzgh;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzpk, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzhw, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzhx, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzgb, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzpl, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzhq, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzgh, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
