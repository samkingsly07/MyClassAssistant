package com.google.firebase.auth.api.internal;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzdb;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zzjn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.ActionCodeResult;
import com.google.firebase.auth.ActionCodeSettings;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.auth.SignInMethodQueryResult;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zza;
import com.google.firebase.auth.internal.zzah;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzn;
import com.google.firebase.auth.internal.zzv;
import com.google.firebase.auth.internal.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public final class zzao extends zzah {
    @NonNull
    private final Context zzjx;
    @NonNull
    private final zzef zzjy;
    private final Future<zzai<zzef>> zzjz = zzcw();

    zzao(@NonNull Context context, @NonNull zzef zzef) {
        this.zzjx = context;
        this.zzjy = zzef;
    }

    /* access modifiers changed from: package-private */
    public final Future<zzai<zzef>> zzcw() {
        if (this.zzjz != null) {
            return this.zzjz;
        }
        return Executors.newSingleThreadExecutor().submit(new zzdo(this.zzjy, this.zzjx));
    }

    public final Task<GetTokenResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzah zzah) {
        zzbe zzbe = (zzbe) new zzbe(str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zza(zzbe), zzbe);
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull zza zza) {
        zzcq zzcq = (zzcq) new zzcq(str).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzcq), zzcq);
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull AuthCredential authCredential, @Nullable String str, @NonNull zza zza) {
        zzco zzco = (zzco) new zzco(authCredential, str).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzco), zzco);
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @Nullable String str, @NonNull zzah zzah) {
        zzbo zzbo = (zzbo) new zzbo(authCredential, str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzbo), zzbo);
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @Nullable String str, @NonNull zzah zzah) {
        zzbq zzbq = (zzbq) new zzbq(authCredential, str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzbq), zzbq);
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull zza zza, @Nullable String str) {
        zzcm zzcm = (zzcm) new zzcm(str).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzcm), zzcm);
    }

    public final void zza(@NonNull FirebaseApp firebaseApp, @NonNull zzdj zzdj, @NonNull PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, @NonNull Executor executor) {
        zzdm zzdm = (zzdm) new zzdm(zzdj).zza(firebaseApp).zza(onVerificationStateChangedCallbacks, activity, executor);
        zza(zzb(zzdm), zzdm);
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest, @NonNull zzah zzah) {
        zzdi zzdi = (zzdi) new zzdi(userProfileChangeRequest).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzdi), zzdi);
    }

    public final Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzah zzah) {
        zzdc zzdc = (zzdc) new zzdc(str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzdc), zzdc);
    }

    public final Task<Void> zzc(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzah zzah) {
        zzde zzde = (zzde) new zzde(str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzde), zzde);
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential, @NonNull zzah zzah) {
        zzdg zzdg = (zzdg) new zzdg(phoneAuthCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzdg), zzdg);
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull zza zza) {
        zzaw zzaw = (zzaw) new zzaw(str, str2, str3).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzaw), zzaw);
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2, @Nullable String str3, @NonNull zza zza) {
        zzcs zzcs = (zzcs) new zzcs(str, str2, str3).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzcs), zzcs);
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull EmailAuthCredential emailAuthCredential, @NonNull zza zza) {
        zzcu zzcu = (zzcu) new zzcu(emailAuthCredential).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzcu), zzcu);
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull String str2, @Nullable String str3, @NonNull zzah zzah) {
        zzbw zzbw = (zzbw) new zzbw(str, str2, str3).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzbw), zzbw);
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull zzah zzah) {
        zzby zzby = (zzby) new zzby(str, str2, str3).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzby), zzby);
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull EmailAuthCredential emailAuthCredential, @NonNull zzah zzah) {
        zzbs zzbs = (zzbs) new zzbs(emailAuthCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzbs), zzbs);
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull EmailAuthCredential emailAuthCredential, @NonNull zzah zzah) {
        zzbu zzbu = (zzbu) new zzbu(emailAuthCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzbu), zzbu);
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull PhoneAuthCredential phoneAuthCredential, @Nullable String str, @NonNull zza zza) {
        zzcw zzcw = (zzcw) new zzcw(phoneAuthCredential, str).zza(firebaseApp).zzb(zza);
        return zza(zzb(zzcw), zzcw);
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential, @Nullable String str, @NonNull zzah zzah) {
        zzca zzca = (zzca) new zzca(phoneAuthCredential, str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzca), zzca);
    }

    public final Task<AuthResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential, @Nullable String str, @NonNull zzah zzah) {
        zzcc zzcc = (zzcc) new zzcc(phoneAuthCredential, str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzcc), zzcc);
    }

    public final Task<ProviderQueryResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @Nullable String str2) {
        zzba zzba = (zzba) new zzba(str, str2).zza(firebaseApp);
        return zza(zza(zzba), zzba);
    }

    public final Task<SignInMethodQueryResult> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str, @Nullable String str2) {
        zzbc zzbc = (zzbc) new zzbc(str, str2).zza(firebaseApp);
        return zza(zza(zzbc), zzbc);
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull ActionCodeSettings actionCodeSettings, @Nullable String str2) {
        actionCodeSettings.zza(zzjn.PASSWORD_RESET);
        zzci zzci = (zzci) new zzci(str, actionCodeSettings, str2, "sendPasswordResetEmail").zza(firebaseApp);
        return zza(zzb(zzci), zzci);
    }

    public final Task<Void> zzb(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull ActionCodeSettings actionCodeSettings, @Nullable String str2) {
        actionCodeSettings.zza(zzjn.EMAIL_SIGNIN);
        zzci zzci = (zzci) new zzci(str, actionCodeSettings, str2, "sendSignInLinkToEmail").zza(firebaseApp);
        return zza(zzb(zzci), zzci);
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @Nullable ActionCodeSettings actionCodeSettings, @NonNull String str) {
        zzcg zzcg = (zzcg) new zzcg(str, actionCodeSettings).zza(firebaseApp);
        return zza(zzb(zzcg), zzcg);
    }

    public final Task<ActionCodeResult> zzc(@NonNull FirebaseApp firebaseApp, @NonNull String str, @Nullable String str2) {
        zzas zzas = (zzas) new zzas(str, str2).zza(firebaseApp);
        return zza(zzb(zzas), zzas);
    }

    public final Task<Void> zzd(@NonNull FirebaseApp firebaseApp, @NonNull String str, @Nullable String str2) {
        zzaq zzaq = (zzaq) new zzaq(str, str2).zza(firebaseApp);
        return zza(zzb(zzaq), zzaq);
    }

    public final Task<String> zze(@NonNull FirebaseApp firebaseApp, @NonNull String str, @Nullable String str2) {
        zzdk zzdk = (zzdk) new zzdk(str, str2).zza(firebaseApp);
        return zza(zzb(zzdk), zzdk);
    }

    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull String str, @NonNull String str2, @Nullable String str3) {
        zzau zzau = (zzau) new zzau(str, str2, str3).zza(firebaseApp);
        return zza(zzb(zzau), zzau);
    }

    public final Task<AuthResult> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential, @NonNull zzah zzah) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzah);
        List<String> providers = firebaseUser.getProviders();
        if (providers != null && providers.contains(authCredential.getProvider())) {
            return Tasks.forException(zzds.zzb(new Status(FirebaseError.ERROR_PROVIDER_ALREADY_LINKED)));
        }
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzbz()) {
                zzbg zzbg = (zzbg) new zzbg(emailAuthCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
                return zza(zzb(zzbg), zzbg);
            }
            zzbm zzbm = (zzbm) new zzbm(emailAuthCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
            return zza(zzb(zzbm), zzbm);
        } else if (authCredential instanceof PhoneAuthCredential) {
            zzbk zzbk = (zzbk) new zzbk((PhoneAuthCredential) authCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
            return zza(zzb(zzbk), zzbk);
        } else {
            Preconditions.checkNotNull(firebaseApp);
            Preconditions.checkNotNull(authCredential);
            Preconditions.checkNotNull(firebaseUser);
            Preconditions.checkNotNull(zzah);
            zzbi zzbi = (zzbi) new zzbi(authCredential).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
            return zza(zzb(zzbi), zzbi);
        }
    }

    public final Task<AuthResult> zzd(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull String str, @NonNull zzah zzah) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzah);
        List<String> providers = firebaseUser.getProviders();
        if ((providers != null && !providers.contains(str)) || firebaseUser.isAnonymous()) {
            return Tasks.forException(zzds.zzb(new Status(FirebaseError.ERROR_NO_SUCH_PROVIDER, str)));
        }
        char c = 65535;
        if (str.hashCode() == 1216985755 && str.equals("password")) {
            c = 0;
        }
        if (c != 0) {
            zzda zzda = (zzda) new zzda(str).zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
            return zza(zzb(zzda), zzda);
        }
        zzcy zzcy = (zzcy) new zzcy().zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zzb(zzcy), zzcy);
    }

    @NonNull
    public final Task<Void> zza(@NonNull FirebaseApp firebaseApp, @NonNull FirebaseUser firebaseUser, @NonNull zzah zzah) {
        zzce zzce = (zzce) new zzce().zza(firebaseApp).zzf(firebaseUser).zzb(zzah).zza((zzw) zzah);
        return zza(zza(zzce), zzce);
    }

    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull zzv zzv) {
        zzay zzay = (zzay) new zzay().zzf(firebaseUser).zzb(zzv).zza((zzw) zzv);
        return zza(zzb(zzay), zzay);
    }

    @NonNull
    public final Task<Void> setFirebaseUIVersion(@NonNull String str) {
        zzck zzck = new zzck(str);
        return zza(zzb(zzck), zzck);
    }

    @NonNull
    @VisibleForTesting
    static zzl zza(@NonNull FirebaseApp firebaseApp, @NonNull zzct zzct) {
        Preconditions.checkNotNull(firebaseApp);
        Preconditions.checkNotNull(zzct);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new zzh(zzct, FirebaseAuthProvider.PROVIDER_ID));
        List<zzdb> zzdu = zzct.zzdu();
        if (zzdu != null && !zzdu.isEmpty()) {
            for (int i = 0; i < zzdu.size(); i++) {
                arrayList.add(new zzh(zzdu.get(i)));
            }
        }
        zzl zzl = new zzl(firebaseApp, arrayList);
        zzl.zza(new zzn(zzct.getLastSignInTimestamp(), zzct.getCreationTimestamp()));
        zzl.zzr(zzct.isNewUser());
        zzl.zzb(zzct.zzcv());
        return zzl;
    }

    @NonNull
    @VisibleForTesting
    private final <ResultT> Task<ResultT> zza(@NonNull Task<ResultT> task, @NonNull zzam<zzdq, ResultT> zzam) {
        return task.continueWithTask(new zzap(this, zzam));
    }
}
