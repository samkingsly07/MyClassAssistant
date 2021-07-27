package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzdw;

@SafeParcelable.Class(creator = "ResetPasswordResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzdg extends AbstractSafeParcelable implements zzdw<zzdg, zzj.C0748zzj> {
    public static final Parcelable.Creator<zzdg> CREATOR = new zzdi();
    @SafeParcelable.Field(getter = "getEmail", mo10718id = 2)
    private String zzgh;
    @SafeParcelable.Field(getter = "getRequestType", mo10718id = 4)
    private String zzpf;
    @SafeParcelable.Field(getter = "getNewEmail", mo10718id = 3)
    private String zzpn;

    public zzdg() {
    }

    @SafeParcelable.Constructor
    zzdg(@SafeParcelable.Param(mo10721id = 2) String str, @SafeParcelable.Param(mo10721id = 3) String str2, @SafeParcelable.Param(mo10721id = 4) String str3) {
        this.zzgh = str;
        this.zzpn = str2;
        this.zzpf = str3;
    }

    public final String getEmail() {
        return this.zzgh;
    }

    public final String zzad() {
        return this.zzpn;
    }

    public final String zzea() {
        return this.zzpf;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzpn, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzpf, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzhl<zzj.C0748zzj> zzdj() {
        return zzj.C0748zzj.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhb zzhb) {
        String str;
        if (!(zzhb instanceof zzj.C0748zzj)) {
            throw new IllegalArgumentException("The passed proto must be an instance of ResetPasswordResponse.");
        }
        zzj.C0748zzj zzj = (zzj.C0748zzj) zzhb;
        this.zzgh = Strings.emptyToNull(zzj.getEmail());
        this.zzpn = Strings.emptyToNull(zzj.zzad());
        switch (zzdh.zzpg[zzj.zzae().ordinal()]) {
            case 1:
                str = "VERIFY_EMAIL";
                break;
            case 2:
                str = "PASSWORD_RESET";
                break;
            default:
                str = null;
                break;
        }
        this.zzpf = str;
        return this;
    }
}
