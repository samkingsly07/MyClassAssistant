package com.google.firebase.auth.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.firebase.auth.FirebaseUserMetadata;
import org.json.JSONException;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "DefaultFirebaseUserMetadataCreator")
public final class zzn implements FirebaseUserMetadata {
    public static final Parcelable.Creator<zzn> CREATOR = new zzo();
    @SafeParcelable.Field(getter = "getCreationTimestamp", mo10718id = 2)
    private long zzpc;
    @SafeParcelable.Field(getter = "getLastSignInTimestamp", mo10718id = 1)
    private long zzra;

    @SafeParcelable.Constructor
    public zzn(@SafeParcelable.Param(mo10721id = 1) long j, @SafeParcelable.Param(mo10721id = 2) long j2) {
        this.zzra = j;
        this.zzpc = j2;
    }

    public final long getLastSignInTimestamp() {
        return this.zzra;
    }

    public final long getCreationTimestamp() {
        return this.zzpc;
    }

    public final JSONObject zzeg() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("lastSignInTimestamp", this.zzra);
            jSONObject.put("creationTimestamp", this.zzpc);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public static zzn zza(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        try {
            return new zzn(jSONObject.getLong("lastSignInTimestamp"), jSONObject.getLong("creationTimestamp"));
        } catch (JSONException e) {
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getLastSignInTimestamp());
        SafeParcelWriter.writeLong(parcel, 2, getCreationTimestamp());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int describeContents() {
        return 0;
    }
}
