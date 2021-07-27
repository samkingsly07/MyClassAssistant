package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzdw;
import java.util.ArrayList;
import java.util.List;

@SafeParcelable.Class(creator = "CreateAuthUriResponseCreator")
@SafeParcelable.Reserved({1})
public final class zzcj extends AbstractSafeParcelable implements zzdw<zzcj, zzj.zzb> {
    public static final Parcelable.Creator<zzcj> CREATOR = new zzck();
    @SafeParcelable.Field(getter = "getProviderId", mo10718id = 4)
    private String zzgb;
    @SafeParcelable.Field(getter = "getAuthUri", mo10718id = 2)
    private String zzol;
    @SafeParcelable.Field(getter = "isRegistered", mo10718id = 3)
    private boolean zzom;
    @SafeParcelable.Field(getter = "isForExistingProvider", mo10718id = 5)
    private boolean zzon;
    @SafeParcelable.Field(getter = "getStringList", mo10718id = 6)
    private zzdp zzoo;
    @SafeParcelable.Field(getter = "getSignInMethods", mo10718id = 7)
    private List<String> zzop;

    public zzcj() {
        this.zzoo = zzdp.zzec();
    }

    @SafeParcelable.Constructor
    public zzcj(@SafeParcelable.Param(mo10721id = 2) String str, @SafeParcelable.Param(mo10721id = 3) boolean z, @SafeParcelable.Param(mo10721id = 4) String str2, @SafeParcelable.Param(mo10721id = 5) boolean z2, @SafeParcelable.Param(mo10721id = 6) zzdp zzdp, @SafeParcelable.Param(mo10721id = 7) List<String> list) {
        this.zzol = str;
        this.zzom = z;
        this.zzgb = str2;
        this.zzon = z2;
        this.zzoo = zzdp == null ? zzdp.zzec() : zzdp.zza(zzdp);
        this.zzop = list;
    }

    @Nullable
    public final List<String> getAllProviders() {
        return this.zzoo.zzeb();
    }

    @Nullable
    public final List<String> getSignInMethods() {
        return this.zzop;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzol, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzom);
        SafeParcelWriter.writeString(parcel, 4, this.zzgb, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzon);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzoo, i, false);
        SafeParcelWriter.writeStringList(parcel, 7, this.zzop, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final zzhl<zzj.zzb> zzdj() {
        return zzj.zzb.zzl();
    }

    public final /* synthetic */ zzdw zza(zzhb zzhb) {
        zzdp zzdp;
        if (!(zzhb instanceof zzj.zzb)) {
            throw new IllegalArgumentException("The passed proto must be an instance of CreateAuthUriResponse.");
        }
        zzj.zzb zzb = (zzj.zzb) zzhb;
        this.zzol = Strings.emptyToNull(zzb.zze());
        this.zzom = zzb.zzh();
        this.zzgb = Strings.emptyToNull(zzb.getProviderId());
        this.zzon = zzb.zzi();
        if (zzb.zzg() == 0) {
            zzdp = zzdp.zzec();
        } else {
            zzdp = new zzdp(1, new ArrayList(zzb.zzf()));
        }
        this.zzoo = zzdp;
        this.zzop = zzb.zzk() == 0 ? new ArrayList<>(0) : zzb.zzj();
        return this;
    }
}
