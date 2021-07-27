package com.google.firebase.auth.api.internal;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzci;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzcm;
import com.google.android.gms.internal.firebase_auth.zzcn;
import com.google.android.gms.internal.firebase_auth.zzcp;
import com.google.android.gms.internal.firebase_auth.zzcq;
import com.google.android.gms.internal.firebase_auth.zzcr;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcx;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdf;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.android.gms.internal.firebase_auth.zzdl;
import com.google.android.gms.internal.firebase_auth.zzdm;
import com.google.android.gms.internal.firebase_auth.zzdn;
import com.google.android.gms.internal.firebase_auth.zzdo;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zzdt;
import com.google.android.gms.internal.firebase_auth.zzdu;
import com.google.android.gms.internal.firebase_auth.zzdv;
import com.google.android.gms.internal.firebase_auth.zzdx;
import com.google.android.gms.internal.firebase_auth.zzdy;
import com.google.android.gms.internal.firebase_auth.zzjn;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.zzd;

public final class zza {
    /* access modifiers changed from: private */
    public final zzex zzip;
    /* access modifiers changed from: private */
    public final zzdu zziq;

    public zza(@NonNull zzex zzex, @NonNull zzdu zzdu) {
        this.zzip = (zzex) Preconditions.checkNotNull(zzex);
        this.zziq = (zzdu) Preconditions.checkNotNull(zzdu);
    }

    public final void zza(@NonNull String str, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzcp(str), (zzez<zzcz>) new zzb(this, zzdp));
    }

    public final void zzb(@NonNull String str, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdu(str), (zzez<zzdv>) new zzm(this, zzdp));
    }

    public final void zza(@NonNull zzdr zzdr, @NonNull zzdp zzdp) {
        Preconditions.checkNotNull(zzdr);
        Preconditions.checkNotNull(zzdp);
        if (this.zziq.zzdi().booleanValue()) {
            zzdr.zzq(this.zziq.zzdi().booleanValue());
        }
        this.zzip.zza(zzdr, (zzez<zzdt>) new zzx(this, zzdp));
    }

    public final void zzc(@Nullable String str, @NonNull zzdp zzdp) {
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdn(str), (zzez<zzdo>) new zzab(this, zzdp));
    }

    public final void zza(@NonNull String str, @NonNull UserProfileChangeRequest userProfileChangeRequest, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(userProfileChangeRequest);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzac(this, userProfileChangeRequest, zzdp));
    }

    public final void zza(@NonNull String str, @NonNull String str2, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzad(this, str2, zzdp));
    }

    public final void zzb(@NonNull String str, @NonNull String str2, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzae(this, str2, zzdp));
    }

    public final void zzc(@NonNull String str, @Nullable String str2, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zzdl zzdl = new zzdl();
        zzdl.zzco(str);
        zzdl.zzcp(str2);
        this.zzip.zza(zzdl, (zzez<zzdm>) new zzaf(this, zzdp));
    }

    private final void zza(@NonNull String str, @NonNull zzez<zzcz> zzez) {
        Preconditions.checkNotNull(zzez);
        Preconditions.checkNotEmpty(str);
        zzcz zzcf = zzcz.zzcf(str);
        if (zzcf.isValid()) {
            zzez.onSuccess(zzcf);
            return;
        }
        this.zzip.zza(new zzcp(zzcf.zzr()), (zzez<zzcz>) new zzag(this, zzez));
    }

    public final void zza(@NonNull String str, @NonNull String str2, @Nullable String str3, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdn(str, str2, (String) null, str3), (zzez<zzdo>) new zzc(this, zzdp));
    }

    public final void zzb(@NonNull String str, @NonNull String str2, @Nullable String str3, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdx(str, str2, str3), (zzez<zzdy>) new zzd(this, zzdp));
    }

    public final void zza(@NonNull EmailAuthCredential emailAuthCredential, @NonNull zzdp zzdp) {
        Preconditions.checkNotNull(emailAuthCredential);
        Preconditions.checkNotNull(zzdp);
        if (emailAuthCredential.zzby()) {
            zza(emailAuthCredential.zzbx(), (zzez<zzcz>) new zze(this, emailAuthCredential, zzdp));
        } else {
            zza(new zzcm(emailAuthCredential, (String) null), zzdp);
        }
    }

    /* access modifiers changed from: private */
    public final void zza(@NonNull zzcm zzcm, @NonNull zzdp zzdp) {
        Preconditions.checkNotNull(zzcm);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(zzcm, (zzez<zzcn>) new zzf(this, zzdp));
    }

    /* access modifiers changed from: private */
    public final void zza(@NonNull zzdp zzdp, @NonNull zzcz zzcz, @NonNull zzdl zzdl, @NonNull zzey zzey) {
        Preconditions.checkNotNull(zzdp);
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzdl);
        Preconditions.checkNotNull(zzey);
        this.zzip.zza(new zzcq(zzcz.zzdw()), (zzez<zzcr>) new zzg(this, zzey, zzdp, zzcz, zzdl));
    }

    /* access modifiers changed from: private */
    public final void zza(@NonNull zzdp zzdp, @NonNull zzcz zzcz, @NonNull zzct zzct, @NonNull zzdl zzdl, @NonNull zzey zzey) {
        Preconditions.checkNotNull(zzdp);
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzct);
        Preconditions.checkNotNull(zzdl);
        Preconditions.checkNotNull(zzey);
        this.zzip.zza(zzdl, (zzez<zzdm>) new zzh(this, zzdl, zzct, zzdp, zzcz, zzey));
    }

    /* access modifiers changed from: private */
    public static zzcz zza(@NonNull zzcz zzcz, @NonNull zzdm zzdm) {
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzdm);
        String idToken = zzdm.getIdToken();
        String zzr = zzdm.zzr();
        if (TextUtils.isEmpty(idToken) || TextUtils.isEmpty(zzr)) {
            return zzcz;
        }
        return new zzcz(zzr, idToken, Long.valueOf(zzdm.zzs()), zzcz.zzdx());
    }

    /* access modifiers changed from: private */
    public final void zza(@NonNull zzcz zzcz, @Nullable String str, @Nullable String str2, @Nullable Boolean bool, @Nullable zzd zzd, @NonNull zzdp zzdp, @NonNull zzey zzey) {
        Preconditions.checkNotNull(zzcz);
        Preconditions.checkNotNull(zzey);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzcq(zzcz.zzdw()), (zzez<zzcr>) new zzi(this, zzey, str2, str, bool, zzd, zzdp, zzcz));
    }

    public final void zzd(@NonNull String str, @Nullable String str2, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzci(str, str2), (zzez<zzcj>) new zzj(this, zzdp));
    }

    public final void zza(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings, @Nullable String str2, @NonNull zzdp zzdp) {
        zzcx zzcx;
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zzjn zzbf = zzjn.zzbf(actionCodeSettings.getRequestType());
        if (zzbf != null) {
            zzcx = new zzcx(zzbf);
        } else {
            zzcx = new zzcx(zzjn.OOB_REQ_TYPE_UNSPECIFIED);
        }
        zzcx.zzcb(str);
        zzcx.zza(actionCodeSettings);
        zzcx.zzcd(str2);
        this.zzip.zza(zzcx, (zzez<Object>) new zzk(this, zzdp));
    }

    public final void zza(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zzcx zzcx = new zzcx(zzjn.VERIFY_EMAIL);
        zzcx.zzcc(str);
        if (actionCodeSettings != null) {
            zzcx.zza(actionCodeSettings);
        }
        this.zzip.zza(zzcx, (zzez<Object>) new zzl(this, zzdp));
    }

    public final void zze(@NonNull String str, @Nullable String str2, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdf(str, (String) null, str2), (zzez<zzdg>) new zzn(this, zzdp));
    }

    public final void zzc(@NonNull String str, @NonNull String str2, @Nullable String str3, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        this.zzip.zza(new zzdf(str, str2, str3), (zzez<zzdg>) new zzo(this, zzdp));
    }

    public final void zzd(@NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotEmpty(str3);
        Preconditions.checkNotNull(zzdp);
        zza(str3, (zzez<zzcz>) new zzp(this, str, str2, zzdp));
    }

    public final void zza(@NonNull String str, @NonNull zzdr zzdr, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdr);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzq(this, zzdr, zzdp));
    }

    public final void zzd(@NonNull String str, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzs(this, zzdp));
    }

    public final void zzf(@NonNull String str, @NonNull String str2, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        Preconditions.checkNotNull(zzdp);
        zza(str2, (zzez<zzcz>) new zzt(this, str, zzdp));
    }

    public final void zze(@NonNull String str, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzv(this, zzdp));
    }

    public final void zzf(@NonNull String str, @NonNull zzdp zzdp) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzdp);
        zza(str, (zzez<zzcz>) new zzy(this, zzdp));
    }

    public final void zzg(@Nullable String str, @NonNull zzdp zzdp) {
        Preconditions.checkNotNull(zzdp);
        this.zzip.zzb(str, new zzaa(this, zzdp));
    }
}
