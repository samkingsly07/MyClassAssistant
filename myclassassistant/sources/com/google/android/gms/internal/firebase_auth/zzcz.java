package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzjl;
import com.google.firebase.auth.api.internal.zzdw;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "GetTokenResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzcz extends AbstractSafeParcelable implements zzdw<zzcz, zzjl.zzb> {
    public static final Parcelable.Creator<zzcz> CREATOR = new zzda();
    @SafeParcelable.Field(getter = "getAccessToken", mo10718id = 3)
    private String zzgd;
    @SafeParcelable.Field(getter = "getRefreshToken", mo10718id = 2)
    private String zzid;
    @SafeParcelable.Field(getter = "getExpiresIn", mo10718id = 4)
    private Long zzph;
    @SafeParcelable.Field(getter = "getTokenType", mo10718id = 5)
    private String zzpi;
    @SafeParcelable.Field(getter = "getIssuedAt", mo10718id = 6)
    private Long zzpj;

    public zzcz() {
        this.zzpj = Long.valueOf(System.currentTimeMillis());
    }

    public zzcz(String str, String str2, Long l, String str3) {
        this(str, str2, l, str3, Long.valueOf(System.currentTimeMillis()));
    }

    @SafeParcelable.Constructor
    zzcz(@SafeParcelable.Param(mo10721id = 2) String str, @SafeParcelable.Param(mo10721id = 3) String str2, @SafeParcelable.Param(mo10721id = 4) Long l, @SafeParcelable.Param(mo10721id = 5) String str3, @SafeParcelable.Param(mo10721id = 6) Long l2) {
        this.zzid = str;
        this.zzgd = str2;
        this.zzph = l;
        this.zzpi = str3;
        this.zzpj = l2;
    }

    public final boolean isValid() {
        return DefaultClock.getInstance().currentTimeMillis() + 300000 < this.zzpj.longValue() + (this.zzph.longValue() * 1000);
    }

    public final void zzce(@NonNull String str) {
        this.zzid = Preconditions.checkNotEmpty(str);
    }

    public final String zzr() {
        return this.zzid;
    }

    public final String zzdw() {
        return this.zzgd;
    }

    public final long zzs() {
        if (this.zzph == null) {
            return 0;
        }
        return this.zzph.longValue();
    }

    @Nullable
    public final String zzdx() {
        return this.zzpi;
    }

    public final long zzdy() {
        return this.zzpj.longValue();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzid, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgd, false);
        SafeParcelWriter.writeLongObject(parcel, 4, Long.valueOf(zzs()), false);
        SafeParcelWriter.writeString(parcel, 5, this.zzpi, false);
        SafeParcelWriter.writeLongObject(parcel, 6, Long.valueOf(this.zzpj.longValue()), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzhl<zzjl.zzb> zzdj() {
        return zzjl.zzb.zzl();
    }

    public final String zzdz() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("refresh_token", this.zzid);
            jSONObject.put("access_token", this.zzgd);
            jSONObject.put("expires_in", this.zzph);
            jSONObject.put("token_type", this.zzpi);
            jSONObject.put("issued_at", this.zzpj);
            return jSONObject.toString();
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to convert GetTokenResponse to JSON");
            throw new zzaf((Throwable) e);
        }
    }

    public static zzcz zzcf(@NonNull String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            zzcz zzcz = new zzcz();
            zzcz.zzid = jSONObject.optString("refresh_token", (String) null);
            zzcz.zzgd = jSONObject.optString("access_token", (String) null);
            zzcz.zzph = Long.valueOf(jSONObject.optLong("expires_in"));
            zzcz.zzpi = jSONObject.optString("token_type", (String) null);
            zzcz.zzpj = Long.valueOf(jSONObject.optLong("issued_at"));
            return zzcz;
        } catch (JSONException e) {
            Log.d("GetTokenResponse", "Failed to read GetTokenResponse from JSONObject");
            throw new zzaf((Throwable) e);
        }
    }

    public final /* synthetic */ zzdw zza(zzhb zzhb) {
        if (!(zzhb instanceof zzjl.zzb)) {
            throw new IllegalArgumentException("The passed proto must be an instance of GrantTokenResponse.");
        }
        zzjl.zzb zzb = (zzjl.zzb) zzhb;
        this.zzid = Strings.emptyToNull(zzb.zzr());
        this.zzgd = Strings.emptyToNull(zzb.zzdw());
        this.zzph = Long.valueOf(zzb.zzs());
        this.zzpi = Strings.emptyToNull(zzb.zzdx());
        this.zzpj = Long.valueOf(System.currentTimeMillis());
        return this;
    }
}
