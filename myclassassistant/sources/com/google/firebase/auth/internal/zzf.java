package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.AdditionalUserInfo;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.zzd;
import java.util.List;

@SafeParcelable.Class(creator = "DefaultAuthResultCreator")
public final class zzf implements AuthResult {
    public static final Parcelable.Creator<zzf> CREATOR = new zzg();
    @SafeParcelable.Field(getter = "getUser", mo10718id = 1)
    private zzl zzqn;
    @SafeParcelable.Field(getter = "getAdditionalUserInfo", mo10718id = 2)
    private zzd zzqo;
    @SafeParcelable.Field(getter = "getOAuthCredential", mo10718id = 3)
    private zzd zzqp;

    @SafeParcelable.Constructor
    zzf(@SafeParcelable.Param(mo10721id = 1) zzl zzl, @SafeParcelable.Param(mo10721id = 2) zzd zzd, @SafeParcelable.Param(mo10721id = 3) zzd zzd2) {
        this.zzqn = zzl;
        this.zzqo = zzd;
        this.zzqp = zzd2;
    }

    public zzf(@NonNull zzl zzl) {
        this.zzqn = (zzl) Preconditions.checkNotNull(zzl);
        List<zzh> zzef = this.zzqn.zzef();
        this.zzqo = null;
        for (int i = 0; i < zzef.size(); i++) {
            if (!TextUtils.isEmpty(zzef.get(i).getRawUserInfo())) {
                this.zzqo = new zzd(zzef.get(i).getProviderId(), zzef.get(i).getRawUserInfo(), zzl.isNewUser());
            }
        }
        if (this.zzqo == null) {
            this.zzqo = new zzd(zzl.isNewUser());
        }
        this.zzqp = zzl.zzcv();
    }

    @Nullable
    public final FirebaseUser getUser() {
        return this.zzqn;
    }

    @Nullable
    public final AdditionalUserInfo getAdditionalUserInfo() {
        return this.zzqo;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getUser(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, getAdditionalUserInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzqp, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int describeContents() {
        return 0;
    }
}
