package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzdw;
import java.util.List;

@SafeParcelable.Class(creator = "GetAccountInfoResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzcr extends AbstractSafeParcelable implements zzdw<zzcr, zzj.zzg> {
    public static final Parcelable.Creator<zzcr> CREATOR = new zzcs();
    @SafeParcelable.Field(getter = "getUserList", mo10718id = 2)
    private zzcv zzoz;

    public zzcr() {
    }

    @SafeParcelable.Constructor
    zzcr(@SafeParcelable.Param(mo10721id = 2) zzcv zzcv) {
        zzcv zzcv2;
        if (zzcv == null) {
            zzcv2 = new zzcv();
        } else {
            zzcv2 = zzcv.zza(zzcv);
        }
        this.zzoz = zzcv2;
    }

    public final List<zzct> zzdt() {
        return this.zzoz.zzdt();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzoz, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzhl<zzj.zzg> zzdj() {
        return zzj.zzg.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhb zzhb) {
        if (!(zzhb instanceof zzj.zzg)) {
            throw new IllegalArgumentException("The passed proto must be an instance of GetAccountInfoResponse.");
        }
        zzj.zzg zzg = (zzj.zzg) zzhb;
        if (zzg.zzx() == 0) {
            this.zzoz = new zzcv();
        } else {
            this.zzoz = zzcv.zza(zzg);
        }
        return this;
    }
}
