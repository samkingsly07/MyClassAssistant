package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.zzd;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "GetAccountInfoUserListCreator")
@SafeParcelable.Reserved({1})
public final class zzcv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzcv> CREATOR = new zzcw();
    @SafeParcelable.Field(getter = "getUsers", mo10718id = 2)
    private List<zzct> zzpe;

    public zzcv() {
        this.zzpe = new ArrayList();
    }

    public final List<zzct> zzdt() {
        return this.zzpe;
    }

    @SafeParcelable.Constructor
    zzcv(@SafeParcelable.Param(mo10721id = 2) List<zzct> list) {
        List<zzct> list2;
        if (list == null) {
            list2 = Collections.emptyList();
        } else {
            list2 = Collections.unmodifiableList(list);
        }
        this.zzpe = list2;
    }

    public static zzcv zza(zzcv zzcv) {
        Preconditions.checkNotNull(zzcv);
        List<zzct> list = zzcv.zzpe;
        zzcv zzcv2 = new zzcv();
        if (list != null && !list.isEmpty()) {
            zzcv2.zzpe.addAll(list);
        }
        return zzcv2;
    }

    public static zzcv zza(zzj.zzg zzg) {
        ArrayList arrayList = new ArrayList(zzg.zzx());
        for (int i = 0; i < zzg.zzx(); i++) {
            zzr zza = zzg.zza(i);
            zzct zzct = r4;
            zzct zzct2 = new zzct(Strings.emptyToNull(zza.getLocalId()), Strings.emptyToNull(zza.getEmail()), zza.zzan(), Strings.emptyToNull(zza.getDisplayName()), Strings.emptyToNull(zza.zzal()), zzdd.zzc(zza.zzak()), Strings.emptyToNull(zza.zzbm()), Strings.emptyToNull(zza.getPhoneNumber()), zza.zzbl(), zza.zzbk(), false, (zzd) null);
            arrayList.add(zzct);
        }
        return new zzcv(arrayList);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzpe, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
