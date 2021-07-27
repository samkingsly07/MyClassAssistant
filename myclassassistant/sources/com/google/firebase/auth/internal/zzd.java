package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.AdditionalUserInfo;
import java.util.Map;
import javax.annotation.Nullable;

@SafeParcelable.Class(creator = "DefaultAdditionalUserInfoCreator")
public final class zzd implements AdditionalUserInfo {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    @SafeParcelable.Field(getter = "getProviderId", mo10718id = 1)
    private final String zzgb;
    @SafeParcelable.Field(getter = "isNewUser", mo10718id = 3)
    private boolean zzor;
    @SafeParcelable.Field(getter = "getRawUserInfo", mo10718id = 2)
    private final String zzpl;
    private Map<String, Object> zzqm;

    @SafeParcelable.Constructor
    public zzd(@SafeParcelable.Param(mo10721id = 1) String str, @SafeParcelable.Param(mo10721id = 2) String str2, @SafeParcelable.Param(mo10721id = 3) boolean z) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        this.zzgb = str;
        this.zzpl = str2;
        this.zzqm = zzab.zzcw(str2);
        this.zzor = z;
    }

    public zzd(boolean z) {
        this.zzor = z;
        this.zzpl = null;
        this.zzgb = null;
        this.zzqm = null;
    }

    @Nullable
    public final String getProviderId() {
        return this.zzgb;
    }

    @Nullable
    public final Map<String, Object> getProfile() {
        return this.zzqm;
    }

    @Nullable
    public final String getUsername() {
        if ("github.com".equals(this.zzgb)) {
            return (String) this.zzqm.get("login");
        }
        if ("twitter.com".equals(this.zzgb)) {
            return (String) this.zzqm.get("screen_name");
        }
        return null;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getProviderId(), false);
        SafeParcelWriter.writeString(parcel, 2, this.zzpl, false);
        SafeParcelWriter.writeBoolean(parcel, 3, isNewUser());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int describeContents() {
        return 0;
    }
}
