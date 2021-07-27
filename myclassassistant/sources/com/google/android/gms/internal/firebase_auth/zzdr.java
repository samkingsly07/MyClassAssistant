package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

@SafeParcelable.Class(creator = "VerifyAssertionRequestCreator")
@SafeParcelable.Reserved({1})
public final class zzdr extends AbstractSafeParcelable implements zzff<zzj.zzp> {
    public static final Parcelable.Creator<zzdr> CREATOR = new zzds();
    @SafeParcelable.Field(getter = "getProviderId", mo10718id = 6)
    private String zzgb;
    @SafeParcelable.Field(getter = "getIdToken", mo10718id = 4)
    private String zzgc;
    @SafeParcelable.Field(getter = "getAccessToken", mo10718id = 5)
    private String zzgd;
    @Nullable
    @SafeParcelable.Field(getter = "getPendingToken", mo10718id = 17)
    private String zzgf;
    @Nullable
    @SafeParcelable.Field(getter = "getEmail", mo10718id = 7)
    private String zzgh;
    @SafeParcelable.Field(getter = "getTenantId", mo10718id = 15)
    private String zzgw;
    @SafeParcelable.Field(getter = "getAutoCreate", mo10718id = 11)
    private boolean zzhr;
    @SafeParcelable.Field(getter = "getReturnSecureToken", mo10718id = 10)
    private boolean zzpt;
    @SafeParcelable.Field(getter = "getRequestUri", mo10718id = 2)
    private String zzpx;
    @SafeParcelable.Field(getter = "getCurrentIdToken", mo10718id = 3)
    private String zzpy;
    @SafeParcelable.Field(getter = "getPostBody", mo10718id = 8)
    private String zzpz;
    @SafeParcelable.Field(getter = "getOauthTokenSecret", mo10718id = 9)
    private String zzqa;
    @SafeParcelable.Field(getter = "getAuthCode", mo10718id = 12)
    private String zzqb;
    @SafeParcelable.Field(getter = "getSessionId", mo10718id = 13)
    private String zzqc;
    @SafeParcelable.Field(getter = "getIdpResponseUrl", mo10718id = 14)
    private String zzqd;
    @SafeParcelable.Field(getter = "getReturnIdpCredential", mo10718id = 16)
    private boolean zzqe;

    public zzdr() {
        this.zzpt = true;
        this.zzhr = true;
    }

    @SafeParcelable.Constructor
    zzdr(@SafeParcelable.Param(mo10721id = 2) String str, @SafeParcelable.Param(mo10721id = 3) String str2, @SafeParcelable.Param(mo10721id = 4) String str3, @SafeParcelable.Param(mo10721id = 5) String str4, @SafeParcelable.Param(mo10721id = 6) String str5, @SafeParcelable.Param(mo10721id = 7) String str6, @SafeParcelable.Param(mo10721id = 8) String str7, @SafeParcelable.Param(mo10721id = 9) String str8, @SafeParcelable.Param(mo10721id = 10) boolean z, @SafeParcelable.Param(mo10721id = 11) boolean z2, @SafeParcelable.Param(mo10721id = 12) String str9, @SafeParcelable.Param(mo10721id = 13) String str10, @SafeParcelable.Param(mo10721id = 14) String str11, @SafeParcelable.Param(mo10721id = 15) String str12, @SafeParcelable.Param(mo10721id = 16) boolean z3, @SafeParcelable.Param(mo10721id = 17) String str13) {
        this.zzpx = str;
        this.zzpy = str2;
        this.zzgc = str3;
        this.zzgd = str4;
        this.zzgb = str5;
        this.zzgh = str6;
        this.zzpz = str7;
        this.zzqa = str8;
        this.zzpt = z;
        this.zzhr = z2;
        this.zzqb = str9;
        this.zzqc = str10;
        this.zzqd = str11;
        this.zzgw = str12;
        this.zzqe = z3;
        this.zzgf = str13;
    }

    public zzdr(@Nullable String str, @Nullable String str2, @NonNull String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable String str8) {
        this.zzpx = "http://localhost";
        this.zzgc = str;
        this.zzgd = str2;
        this.zzqa = str5;
        this.zzqb = str6;
        this.zzgw = str7;
        this.zzgf = str8;
        this.zzpt = true;
        if (!TextUtils.isEmpty(this.zzgc) || !TextUtils.isEmpty(this.zzgd) || !TextUtils.isEmpty(this.zzqb)) {
            this.zzgb = Preconditions.checkNotEmpty(str3);
            this.zzgh = null;
            StringBuilder sb = new StringBuilder();
            if (!TextUtils.isEmpty(this.zzgc)) {
                sb.append("id_token=");
                sb.append(this.zzgc);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.zzgd)) {
                sb.append("access_token=");
                sb.append(this.zzgd);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.zzgh)) {
                sb.append("identifier=");
                sb.append(this.zzgh);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.zzqa)) {
                sb.append("oauth_token_secret=");
                sb.append(this.zzqa);
                sb.append("&");
            }
            if (!TextUtils.isEmpty(this.zzqb)) {
                sb.append("code=");
                sb.append(this.zzqb);
                sb.append("&");
            }
            sb.append("providerId=");
            sb.append(this.zzgb);
            this.zzpz = sb.toString();
            this.zzhr = true;
            return;
        }
        throw new IllegalArgumentException("idToken, accessToken and authCode cannot all be null");
    }

    public final zzdr zzcq(@NonNull String str) {
        this.zzpy = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zzdr zzp(boolean z) {
        this.zzhr = false;
        return this;
    }

    public final zzdr zzq(boolean z) {
        this.zzqe = z;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzpx, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzpy, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzgc, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzgd, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzgb, false);
        SafeParcelWriter.writeString(parcel, 7, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 8, this.zzpz, false);
        SafeParcelWriter.writeString(parcel, 9, this.zzqa, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzpt);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzhr);
        SafeParcelWriter.writeString(parcel, 12, this.zzqb, false);
        SafeParcelWriter.writeString(parcel, 13, this.zzqc, false);
        SafeParcelWriter.writeString(parcel, 14, this.zzqd, false);
        SafeParcelWriter.writeString(parcel, 15, this.zzgw, false);
        SafeParcelWriter.writeBoolean(parcel, 16, this.zzqe);
        SafeParcelWriter.writeString(parcel, 17, this.zzgf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final /* synthetic */ zzhb zzds() {
        zzj.zzp.zza zzk = zzj.zzp.zzas().zzi(this.zzpt).zzk(this.zzhr);
        if (this.zzpy != null) {
            zzk.zzbe(this.zzpy);
        }
        if (this.zzpx != null) {
            zzk.zzbb(this.zzpx);
        }
        if (this.zzpz != null) {
            zzk.zzbc(this.zzpz);
        }
        if (this.zzgw != null) {
            zzk.zzbf(this.zzgw);
        }
        if (this.zzgf != null) {
            zzk.zzbg(this.zzgf);
        }
        if (!TextUtils.isEmpty(this.zzqc)) {
            zzk.zzbd(this.zzqc);
        }
        if (!TextUtils.isEmpty(this.zzqd)) {
            zzk.zzbb(this.zzqd);
        }
        zzk.zzj(this.zzqe);
        return (zzj.zzp) ((zzfs) zzk.zzhm());
    }
}
