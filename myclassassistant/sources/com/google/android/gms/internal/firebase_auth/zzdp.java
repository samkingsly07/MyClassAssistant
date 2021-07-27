package com.google.android.gms.internal.firebase_auth;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.Strings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "StringListCreator")
public final class zzdp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzdp> CREATOR = new zzdq();
    @SafeParcelable.VersionField(mo10724id = 1)
    private final int versionCode;
    @SafeParcelable.Field(getter = "getValues", mo10718id = 2)
    private List<String> zzpw;

    public final List<String> zzeb() {
        return this.zzpw;
    }

    public zzdp() {
        this((List<String>) null);
    }

    private zzdp(@Nullable List<String> list) {
        this.versionCode = 1;
        this.zzpw = new ArrayList();
        if (list != null && !list.isEmpty()) {
            this.zzpw.addAll(list);
        }
    }

    @SafeParcelable.Constructor
    zzdp(@SafeParcelable.Param(mo10721id = 1) int i, @SafeParcelable.Param(mo10721id = 2) List<String> list) {
        this.versionCode = i;
        if (list == null || list.isEmpty()) {
            this.zzpw = Collections.emptyList();
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            list.set(i2, Strings.emptyToNull(list.get(i2)));
        }
        this.zzpw = Collections.unmodifiableList(list);
    }

    public static zzdp zzec() {
        return new zzdp((List<String>) null);
    }

    public static zzdp zza(zzdp zzdp) {
        List<String> list;
        if (zzdp != null) {
            list = zzdp.zzpw;
        } else {
            list = null;
        }
        return new zzdp(list);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeStringList(parcel, 2, this.zzpw, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
