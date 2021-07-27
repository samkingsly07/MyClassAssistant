package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "UserProfileChangeRequestCreator")
@SafeParcelable.Reserved({1})
public class UserProfileChangeRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<UserProfileChangeRequest> CREATOR = new zzz();
    @SafeParcelable.Field(getter = "getDisplayName", mo10718id = 2)
    private String zzhw;
    @SafeParcelable.Field(getter = "getPhotoUrl", mo10718id = 3)
    private String zzhx;
    @SafeParcelable.Field(getter = "shouldRemoveDisplayName", mo10718id = 4)
    private boolean zzhy;
    @SafeParcelable.Field(getter = "shouldRemovePhotoUri", mo10718id = 5)
    private boolean zzhz;
    private Uri zzia;

    public static class Builder {
        private String zzhw;
        private boolean zzhy;
        private boolean zzhz;
        private Uri zzia;

        public Builder setDisplayName(@Nullable String str) {
            if (str == null) {
                this.zzhy = true;
            } else {
                this.zzhw = str;
            }
            return this;
        }

        public Builder setPhotoUri(@Nullable Uri uri) {
            if (uri == null) {
                this.zzhz = true;
            } else {
                this.zzia = uri;
            }
            return this;
        }

        public UserProfileChangeRequest build() {
            return new UserProfileChangeRequest(this.zzhw, this.zzia == null ? null : this.zzia.toString(), this.zzhy, this.zzhz);
        }
    }

    @SafeParcelable.Constructor
    UserProfileChangeRequest(@SafeParcelable.Param(mo10721id = 2) String str, @SafeParcelable.Param(mo10721id = 3) String str2, @SafeParcelable.Param(mo10721id = 4) boolean z, @SafeParcelable.Param(mo10721id = 5) boolean z2) {
        this.zzhw = str;
        this.zzhx = str2;
        this.zzhy = z;
        this.zzhz = z2;
        this.zzia = TextUtils.isEmpty(str2) ? null : Uri.parse(str2);
    }

    @Nullable
    public String getDisplayName() {
        return this.zzhw;
    }

    public final String zzal() {
        return this.zzhx;
    }

    @Nullable
    public Uri getPhotoUri() {
        return this.zzia;
    }

    public final boolean zzck() {
        return this.zzhy;
    }

    public final boolean zzcl() {
        return this.zzhz;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeString(parcel, 3, this.zzhx, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzhy);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzhz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
