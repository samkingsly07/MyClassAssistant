package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@KeepForSdk
@SafeParcelable.Class(creator = "GetServiceRequestCreator")
@SafeParcelable.Reserved({9})
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new zzd();
    @SafeParcelable.VersionField(mo10724id = 1)
    private final int version;
    @SafeParcelable.Field(mo10718id = 2)
    private final int zzdg;
    @SafeParcelable.Field(mo10718id = 3)
    private int zzdh;
    @SafeParcelable.Field(mo10718id = 5)
    IBinder zzdi;
    @SafeParcelable.Field(mo10718id = 6)
    Scope[] zzdj;
    @SafeParcelable.Field(mo10718id = 7)
    Bundle zzdk;
    @SafeParcelable.Field(mo10718id = 8)
    Account zzdl;
    @SafeParcelable.Field(mo10718id = 10)
    Feature[] zzdm;
    @SafeParcelable.Field(mo10718id = 11)
    Feature[] zzdn;
    @SafeParcelable.Field(mo10718id = 12)
    private boolean zzdo;
    @SafeParcelable.Field(mo10718id = 4)
    String zzy;

    public GetServiceRequest(int i) {
        this.version = 4;
        this.zzdh = GoogleApiAvailabilityLight.GOOGLE_PLAY_SERVICES_VERSION_CODE;
        this.zzdg = i;
        this.zzdo = true;
    }

    @SafeParcelable.Constructor
    GetServiceRequest(@SafeParcelable.Param(mo10721id = 1) int i, @SafeParcelable.Param(mo10721id = 2) int i2, @SafeParcelable.Param(mo10721id = 3) int i3, @SafeParcelable.Param(mo10721id = 4) String str, @SafeParcelable.Param(mo10721id = 5) IBinder iBinder, @SafeParcelable.Param(mo10721id = 6) Scope[] scopeArr, @SafeParcelable.Param(mo10721id = 7) Bundle bundle, @SafeParcelable.Param(mo10721id = 8) Account account, @SafeParcelable.Param(mo10721id = 10) Feature[] featureArr, @SafeParcelable.Param(mo10721id = 11) Feature[] featureArr2, @SafeParcelable.Param(mo10721id = 12) boolean z) {
        this.version = i;
        this.zzdg = i2;
        this.zzdh = i3;
        if ("com.google.android.gms".equals(str)) {
            this.zzy = "com.google.android.gms";
        } else {
            this.zzy = str;
        }
        if (i < 2) {
            this.zzdl = iBinder != null ? AccountAccessor.getAccountBinderSafe(IAccountAccessor.Stub.asInterface(iBinder)) : null;
        } else {
            this.zzdi = iBinder;
            this.zzdl = account;
        }
        this.zzdj = scopeArr;
        this.zzdk = bundle;
        this.zzdm = featureArr;
        this.zzdn = featureArr2;
        this.zzdo = z;
    }

    @KeepForSdk
    public Bundle getExtraArgs() {
        return this.zzdk;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.version);
        SafeParcelWriter.writeInt(parcel, 2, this.zzdg);
        SafeParcelWriter.writeInt(parcel, 3, this.zzdh);
        SafeParcelWriter.writeString(parcel, 4, this.zzy, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zzdi, false);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.zzdj, i, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzdk, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzdl, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 10, this.zzdm, i, false);
        SafeParcelWriter.writeTypedArray(parcel, 11, this.zzdn, i, false);
        SafeParcelWriter.writeBoolean(parcel, 12, this.zzdo);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
