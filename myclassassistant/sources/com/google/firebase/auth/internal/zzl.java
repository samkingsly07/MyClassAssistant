package com.google.firebase.auth.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.UserInfo;
import com.google.firebase.auth.zzd;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SafeParcelable.Class(creator = "DefaultFirebaseUserCreator")
public class zzl extends FirebaseUser {
    public static final Parcelable.Creator<zzl> CREATOR = new zzm();
    @SafeParcelable.Field(getter = "getDefaultOAuthCredential", mo10718id = 11)
    private zzd zzin;
    @SafeParcelable.Field(getter = "isNewUser", mo10718id = 10)
    private boolean zzor;
    @SafeParcelable.Field(getter = "getCachedTokenState", mo10718id = 1)
    private zzcz zzqr;
    @SafeParcelable.Field(getter = "getDefaultAuthUserInfo", mo10718id = 2)
    private zzh zzqs;
    @SafeParcelable.Field(getter = "getFirebaseAppName", mo10718id = 3)
    private String zzqt;
    @SafeParcelable.Field(getter = "getUserType", mo10718id = 4)
    private String zzqu;
    @SafeParcelable.Field(getter = "getUserInfos", mo10718id = 5)
    private List<zzh> zzqv;
    @SafeParcelable.Field(getter = "getProviders", mo10718id = 6)
    private List<String> zzqw;
    @SafeParcelable.Field(getter = "getCurrentVersion", mo10718id = 7)
    private String zzqx;
    @SafeParcelable.Field(getter = "isAnonymous", mo10718id = 8)
    private Boolean zzqy;
    @SafeParcelable.Field(getter = "getMetadata", mo10718id = 9)
    private zzn zzqz;

    @SafeParcelable.Constructor
    zzl(@SafeParcelable.Param(mo10721id = 1) zzcz zzcz, @SafeParcelable.Param(mo10721id = 2) zzh zzh, @SafeParcelable.Param(mo10721id = 3) String str, @SafeParcelable.Param(mo10721id = 4) String str2, @SafeParcelable.Param(mo10721id = 5) List<zzh> list, @SafeParcelable.Param(mo10721id = 6) List<String> list2, @SafeParcelable.Param(mo10721id = 7) String str3, @SafeParcelable.Param(mo10721id = 8) Boolean bool, @SafeParcelable.Param(mo10721id = 9) zzn zzn, @SafeParcelable.Param(mo10721id = 10) boolean z, @SafeParcelable.Param(mo10721id = 11) zzd zzd) {
        this.zzqr = zzcz;
        this.zzqs = zzh;
        this.zzqt = str;
        this.zzqu = str2;
        this.zzqv = list;
        this.zzqw = list2;
        this.zzqx = str3;
        this.zzqy = bool;
        this.zzqz = zzn;
        this.zzor = z;
        this.zzin = zzd;
    }

    public zzl(@NonNull FirebaseApp firebaseApp, @NonNull List<? extends UserInfo> list) {
        Preconditions.checkNotNull(firebaseApp);
        this.zzqt = firebaseApp.getName();
        this.zzqu = "com.google.firebase.auth.internal.DefaultFirebaseUser";
        this.zzqx = "2";
        zza(list);
    }

    @Nullable
    public String getDisplayName() {
        return this.zzqs.getDisplayName();
    }

    @Nullable
    public Uri getPhotoUrl() {
        return this.zzqs.getPhotoUrl();
    }

    @Nullable
    public String getEmail() {
        return this.zzqs.getEmail();
    }

    @Nullable
    public String getPhoneNumber() {
        return this.zzqs.getPhoneNumber();
    }

    @Nullable
    public final String zzcf() {
        Map map;
        if (this.zzqr == null || this.zzqr.zzdw() == null || (map = (Map) zzaa.zzcu(this.zzqr.zzdw()).getClaims().get(FirebaseAuthProvider.PROVIDER_ID)) == null) {
            return null;
        }
        return (String) map.get("tenant");
    }

    public final zzl zzcs(@NonNull String str) {
        this.zzqx = str;
        return this;
    }

    @NonNull
    public String getProviderId() {
        return this.zzqs.getProviderId();
    }

    @NonNull
    public final FirebaseApp zzcc() {
        return FirebaseApp.getInstance(this.zzqt);
    }

    public final List<zzh> zzef() {
        return this.zzqv;
    }

    @NonNull
    public String getUid() {
        return this.zzqs.getUid();
    }

    public boolean isAnonymous() {
        if (this.zzqy == null || this.zzqy.booleanValue()) {
            String str = "";
            if (this.zzqr != null) {
                GetTokenResult zzcu = zzaa.zzcu(this.zzqr.zzdw());
                str = zzcu != null ? zzcu.getSignInProvider() : "";
            }
            boolean z = true;
            if (getProviderData().size() > 1 || (str != null && str.equals("custom"))) {
                z = false;
            }
            this.zzqy = Boolean.valueOf(z);
        }
        return this.zzqy.booleanValue();
    }

    @Nullable
    public final List<String> getProviders() {
        return this.zzqw;
    }

    @NonNull
    public final FirebaseUser zza(@NonNull List<? extends UserInfo> list) {
        Preconditions.checkNotNull(list);
        this.zzqv = new ArrayList(list.size());
        this.zzqw = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            UserInfo userInfo = (UserInfo) list.get(i);
            if (userInfo.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                this.zzqs = (zzh) userInfo;
            } else {
                this.zzqw.add(userInfo.getProviderId());
            }
            this.zzqv.add((zzh) userInfo);
        }
        if (this.zzqs == null) {
            this.zzqs = this.zzqv.get(0);
        }
        return this;
    }

    @NonNull
    public List<? extends UserInfo> getProviderData() {
        return this.zzqv;
    }

    @NonNull
    public final zzcz zzcg() {
        return this.zzqr;
    }

    @NonNull
    public final String zzci() {
        return zzcg().zzdw();
    }

    @NonNull
    public final String zzch() {
        return this.zzqr.zzdz();
    }

    public final void zza(@NonNull zzcz zzcz) {
        this.zzqr = (zzcz) Preconditions.checkNotNull(zzcz);
    }

    public boolean isEmailVerified() {
        return this.zzqs.isEmailVerified();
    }

    public final void zza(zzn zzn) {
        this.zzqz = zzn;
    }

    public FirebaseUserMetadata getMetadata() {
        return this.zzqz;
    }

    public final void zzr(boolean z) {
        this.zzor = z;
    }

    public final boolean isNewUser() {
        return this.zzor;
    }

    public final void zzb(zzd zzd) {
        this.zzin = zzd;
    }

    @Nullable
    public final zzd zzcv() {
        return this.zzin;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, zzcg(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzqs, i, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzqt, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzqu, false);
        SafeParcelWriter.writeTypedList(parcel, 5, this.zzqv, false);
        SafeParcelWriter.writeStringList(parcel, 6, getProviders(), false);
        SafeParcelWriter.writeString(parcel, 7, this.zzqx, false);
        SafeParcelWriter.writeBooleanObject(parcel, 8, Boolean.valueOf(isAnonymous()), false);
        SafeParcelWriter.writeParcelable(parcel, 9, getMetadata(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzor);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzin, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public static FirebaseUser zza(FirebaseApp firebaseApp, FirebaseUser firebaseUser) {
        zzl zzl = new zzl(firebaseApp, firebaseUser.getProviderData());
        if (firebaseUser instanceof zzl) {
            zzl zzl2 = (zzl) firebaseUser;
            zzl.zzqx = zzl2.zzqx;
            zzl.zzqu = zzl2.zzqu;
            zzl.zzqz = (zzn) zzl2.getMetadata();
        } else {
            zzl.zzqz = null;
        }
        if (firebaseUser.zzcg() != null) {
            zzl.zza(firebaseUser.zzcg());
        }
        if (!firebaseUser.isAnonymous()) {
            zzl.zzce();
        }
        return zzl;
    }

    public final /* synthetic */ FirebaseUser zzce() {
        this.zzqy = false;
        return this;
    }
}
