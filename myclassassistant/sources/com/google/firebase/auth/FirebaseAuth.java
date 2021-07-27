package com.google.firebase.auth;

import android.app.Activity;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdj;
import com.google.android.gms.internal.firebase_auth.zzjn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.auth.api.internal.zzao;
import com.google.firebase.auth.api.internal.zzds;
import com.google.firebase.auth.api.internal.zzed;
import com.google.firebase.auth.api.internal.zzeg;
import com.google.firebase.auth.api.internal.zzem;
import com.google.firebase.auth.internal.InternalAuthProvider;
import com.google.firebase.auth.internal.zzaa;
import com.google.firebase.auth.internal.zzad;
import com.google.firebase.auth.internal.zzae;
import com.google.firebase.auth.internal.zzag;
import com.google.firebase.auth.internal.zzah;
import com.google.firebase.auth.internal.zzf;
import com.google.firebase.auth.internal.zzk;
import com.google.firebase.auth.internal.zzl;
import com.google.firebase.auth.internal.zzv;
import com.google.firebase.auth.internal.zzw;
import com.google.firebase.auth.internal.zzz;
import com.google.firebase.internal.InternalTokenResult;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class FirebaseAuth implements InternalAuthProvider {
    /* access modifiers changed from: private */
    public FirebaseApp zzgm;
    /* access modifiers changed from: private */
    public final List<IdTokenListener> zzgn;
    /* access modifiers changed from: private */
    public final List<com.google.firebase.auth.internal.IdTokenListener> zzgo;
    /* access modifiers changed from: private */
    public List<AuthStateListener> zzgp;
    private zzao zzgq;
    /* access modifiers changed from: private */
    public FirebaseUser zzgr;
    /* access modifiers changed from: private */
    public zzk zzgs;
    private final Object zzgt;
    private String zzgu;
    private final Object zzgv;
    private String zzgw;
    private final zzad zzgx;
    private final zzz zzgy;
    private zzae zzgz;
    private zzag zzha;

    public interface AuthStateListener {
        void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    public interface IdTokenListener {
        void onIdTokenChanged(@NonNull FirebaseAuth firebaseAuth);
    }

    @VisibleForTesting
    class zza implements com.google.firebase.auth.internal.zza {
        zza() {
        }

        public final void zza(@NonNull zzcz zzcz, @NonNull FirebaseUser firebaseUser) {
            Preconditions.checkNotNull(zzcz);
            Preconditions.checkNotNull(firebaseUser);
            firebaseUser.zza(zzcz);
            FirebaseAuth.this.zza(firebaseUser, zzcz, true);
        }
    }

    @VisibleForTesting
    class zzb extends zza implements com.google.firebase.auth.internal.zza, zzw {
        zzb() {
            super();
        }

        public final void zza(Status status) {
            if (status.getStatusCode() == 17011 || status.getStatusCode() == 17021 || status.getStatusCode() == 17005) {
                FirebaseAuth.this.signOut();
            }
        }
    }

    class zzc extends zza implements com.google.firebase.auth.internal.zza, zzw {
        zzc(FirebaseAuth firebaseAuth) {
            super();
        }

        public final void zza(Status status) {
        }
    }

    @Keep
    public static FirebaseAuth getInstance() {
        return (FirebaseAuth) FirebaseApp.getInstance().get(FirebaseAuth.class);
    }

    @Keep
    public static FirebaseAuth getInstance(@NonNull FirebaseApp firebaseApp) {
        return (FirebaseAuth) firebaseApp.get(FirebaseAuth.class);
    }

    public FirebaseAuth(FirebaseApp firebaseApp) {
        this(firebaseApp, zzed.zza(firebaseApp.getApplicationContext(), new zzeg(firebaseApp.getOptions().getApiKey()).zzdk()), new zzad(firebaseApp.getApplicationContext(), firebaseApp.getPersistenceKey()), zzz.zzem());
    }

    @VisibleForTesting
    private FirebaseAuth(FirebaseApp firebaseApp, zzao zzao, zzad zzad, zzz zzz) {
        zzcz zzh;
        this.zzgt = new Object();
        this.zzgv = new Object();
        this.zzgm = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzgq = (zzao) Preconditions.checkNotNull(zzao);
        this.zzgx = (zzad) Preconditions.checkNotNull(zzad);
        this.zzgs = new zzk();
        this.zzgy = (zzz) Preconditions.checkNotNull(zzz);
        this.zzgn = new CopyOnWriteArrayList();
        this.zzgo = new CopyOnWriteArrayList();
        this.zzgp = new CopyOnWriteArrayList();
        this.zzha = zzag.zzeq();
        this.zzgr = this.zzgx.zzeo();
        if (!(this.zzgr == null || (zzh = this.zzgx.zzh(this.zzgr)) == null)) {
            zza(this.zzgr, zzh, false);
        }
        this.zzgy.zzg(this);
    }

    @Nullable
    public FirebaseUser getCurrentUser() {
        return this.zzgr;
    }

    @Nullable
    public String getUid() {
        if (this.zzgr == null) {
            return null;
        }
        return this.zzgr.getUid();
    }

    public final void zza(@NonNull FirebaseUser firebaseUser, @NonNull zzcz zzcz, boolean z) {
        boolean z2;
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzcz);
        boolean z3 = true;
        if (this.zzgr == null) {
            z2 = true;
        } else {
            boolean z4 = !this.zzgr.zzcg().zzdw().equals(zzcz.zzdw());
            boolean equals = this.zzgr.getUid().equals(firebaseUser.getUid());
            z2 = !equals || z4;
            if (equals) {
                z3 = false;
            }
        }
        Preconditions.checkNotNull(firebaseUser);
        if (this.zzgr == null) {
            this.zzgr = firebaseUser;
        } else {
            this.zzgr.zza(firebaseUser.getProviderData());
            if (!firebaseUser.isAnonymous()) {
                this.zzgr.zzce();
            }
        }
        if (z) {
            this.zzgx.zzg(this.zzgr);
        }
        if (z2) {
            if (this.zzgr != null) {
                this.zzgr.zza(zzcz);
            }
            zzb(this.zzgr);
        }
        if (z3) {
            zzc(this.zzgr);
        }
        if (z) {
            this.zzgx.zza(firebaseUser, zzcz);
        }
        zzcb().zzc(this.zzgr.zzcg());
    }

    public final void zzca() {
        if (this.zzgr != null) {
            zzad zzad = this.zzgx;
            FirebaseUser firebaseUser = this.zzgr;
            Preconditions.checkNotNull(firebaseUser);
            zzad.clear(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}));
            this.zzgr = null;
        }
        this.zzgx.clear("com.google.firebase.auth.FIREBASE_USER");
        zzb((FirebaseUser) null);
        zzc((FirebaseUser) null);
    }

    @VisibleForTesting
    private final synchronized void zza(zzae zzae) {
        this.zzgz = zzae;
        this.zzgm.setIdTokenListenersCountChangedListener(zzae);
    }

    @VisibleForTesting
    private final synchronized zzae zzcb() {
        if (this.zzgz == null) {
            zza(new zzae(this.zzgm));
        }
        return this.zzgz;
    }

    public FirebaseApp getApp() {
        return this.zzgm;
    }

    public final FirebaseApp zzcc() {
        return this.zzgm;
    }

    public void addIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzgn.add(idTokenListener);
        this.zzha.execute(new zzi(this, idTokenListener));
    }

    @KeepForSdk
    public void addIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzgo.add(idTokenListener);
        zzcb().zzf(this.zzgo.size());
    }

    public void removeIdTokenListener(@NonNull IdTokenListener idTokenListener) {
        this.zzgn.remove(idTokenListener);
    }

    @KeepForSdk
    public void removeIdTokenListener(@NonNull com.google.firebase.auth.internal.IdTokenListener idTokenListener) {
        Preconditions.checkNotNull(idTokenListener);
        this.zzgo.remove(idTokenListener);
        zzcb().zzf(this.zzgo.size());
    }

    public void addAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zzgp.add(authStateListener);
        this.zzha.execute(new zzj(this, authStateListener));
    }

    public void removeAuthStateListener(@NonNull AuthStateListener authStateListener) {
        this.zzgp.remove(authStateListener);
    }

    private final void zzb(@Nullable FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb = new StringBuilder(String.valueOf(uid).length() + 45);
            sb.append("Notifying id token listeners about user ( ");
            sb.append(uid);
            sb.append(" ).");
            Log.d("FirebaseAuth", sb.toString());
        } else {
            Log.d("FirebaseAuth", "Notifying id token listeners about a sign-out event.");
        }
        this.zzha.execute(new zzk(this, new InternalTokenResult(firebaseUser != null ? firebaseUser.zzci() : null)));
    }

    private final void zzc(@Nullable FirebaseUser firebaseUser) {
        if (firebaseUser != null) {
            String uid = firebaseUser.getUid();
            StringBuilder sb = new StringBuilder(String.valueOf(uid).length() + 47);
            sb.append("Notifying auth state listeners about user ( ");
            sb.append(uid);
            sb.append(" ).");
            Log.d("FirebaseAuth", sb.toString());
        } else {
            Log.d("FirebaseAuth", "Notifying auth state listeners about a sign-out event.");
        }
        this.zzha.execute(new zzl(this));
    }

    @NonNull
    public Task<GetTokenResult> getAccessToken(boolean z) {
        return zza(this.zzgr, z);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.zzm, com.google.firebase.auth.internal.zzah] */
    @NonNull
    public final Task<GetTokenResult> zza(@Nullable FirebaseUser firebaseUser, boolean z) {
        if (firebaseUser == null) {
            return Tasks.forException(zzds.zzb(new Status(FirebaseError.ERROR_NO_SIGNED_IN_USER)));
        }
        zzcz zzcg = firebaseUser.zzcg();
        if (!zzcg.isValid() || z) {
            return this.zzgq.zza(this.zzgm, firebaseUser, zzcg.zzr(), (zzah) new zzm(this));
        }
        return Tasks.forResult(zzaa.zzcu(zzcg.zzdw()));
    }

    @NonNull
    public Task<AuthResult> signInWithCredential(@NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        if (authCredential instanceof EmailAuthCredential) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!emailAuthCredential.zzbz()) {
                return this.zzgq.zzb(this.zzgm, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), this.zzgw, (com.google.firebase.auth.internal.zza) new zza());
            }
            return this.zzgq.zza(this.zzgm, emailAuthCredential, (com.google.firebase.auth.internal.zza) new zza());
        } else if (!(authCredential instanceof PhoneAuthCredential)) {
            return this.zzgq.zza(this.zzgm, authCredential, this.zzgw, (com.google.firebase.auth.internal.zza) new zza());
        } else {
            return this.zzgq.zza(this.zzgm, (PhoneAuthCredential) authCredential, this.zzgw, (com.google.firebase.auth.internal.zza) new zza());
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r7v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        if (EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!"password".equals(emailAuthCredential.getSignInMethod())) {
                return this.zzgq.zza(this.zzgm, firebaseUser, emailAuthCredential, (zzah) new zzb());
            }
            return this.zzgq.zza(this.zzgm, firebaseUser, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), firebaseUser.zzcf(), new zzb());
        } else if (authCredential instanceof PhoneAuthCredential) {
            return this.zzgq.zza(this.zzgm, firebaseUser, (PhoneAuthCredential) authCredential, this.zzgw, (zzah) new zzb());
        } else {
            return this.zzgq.zza(this.zzgm, firebaseUser, authCredential, firebaseUser.zzcf(), (zzah) new zzb());
        }
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r6v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    /* JADX WARNING: type inference failed for: r7v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    public final Task<AuthResult> zzb(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(authCredential);
        if (EmailAuthCredential.class.isAssignableFrom(authCredential.getClass())) {
            EmailAuthCredential emailAuthCredential = (EmailAuthCredential) authCredential;
            if (!"password".equals(emailAuthCredential.getSignInMethod())) {
                return this.zzgq.zzb(this.zzgm, firebaseUser, emailAuthCredential, (zzah) new zzb());
            }
            return this.zzgq.zzb(this.zzgm, firebaseUser, emailAuthCredential.getEmail(), emailAuthCredential.getPassword(), firebaseUser.zzcf(), new zzb());
        } else if (authCredential instanceof PhoneAuthCredential) {
            return this.zzgq.zzb(this.zzgm, firebaseUser, (PhoneAuthCredential) authCredential, this.zzgw, (zzah) new zzb());
        } else {
            return this.zzgq.zzb(this.zzgm, firebaseUser, authCredential, firebaseUser.zzcf(), (zzah) new zzb());
        }
    }

    @NonNull
    public Task<AuthResult> signInWithCustomToken(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zza(this.zzgm, str, (com.google.firebase.auth.internal.zza) new zza());
    }

    @NonNull
    public Task<AuthResult> signInWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzgq.zzb(this.zzgm, str, str2, this.zzgw, (com.google.firebase.auth.internal.zza) new zza());
    }

    @NonNull
    public Task<AuthResult> signInWithEmailLink(@NonNull String str, @NonNull String str2) {
        return signInWithCredential(EmailAuthProvider.getCredentialWithLink(str, str2));
    }

    @NonNull
    public Task<AuthResult> signInAnonymously() {
        if (this.zzgr == null || !this.zzgr.isAnonymous()) {
            return this.zzgq.zza(this.zzgm, (com.google.firebase.auth.internal.zza) new zza(), this.zzgw);
        }
        zzl zzl = (zzl) this.zzgr;
        zzl.zzr(false);
        return Tasks.forResult(new zzf(zzl));
    }

    @NonNull
    public final void zza(@NonNull String str, long j, TimeUnit timeUnit, @NonNull PhoneAuthProvider.OnVerificationStateChangedCallbacks onVerificationStateChangedCallbacks, @Nullable Activity activity, @NonNull Executor executor, boolean z) {
        zzn zzn;
        long convert = TimeUnit.SECONDS.convert(j, timeUnit);
        if (convert < 0 || convert > 120) {
            throw new IllegalArgumentException("We only support 0-120 seconds for sms-auto-retrieval timeout");
        }
        zzdj zzdj = new zzdj(str, convert, z, this.zzgu, this.zzgw);
        if (this.zzgs.zzee()) {
            if (str.equals(this.zzgs.getPhoneNumber())) {
                zzn = new zzn(this, onVerificationStateChangedCallbacks);
                this.zzgq.zza(this.zzgm, zzdj, zzn, activity, executor);
            }
        }
        zzn = onVerificationStateChangedCallbacks;
        this.zzgq.zza(this.zzgm, zzdj, zzn, activity, executor);
    }

    /* JADX WARNING: type inference failed for: r0v4, types: [com.google.firebase.auth.FirebaseAuth$zzc, com.google.firebase.auth.internal.zzah] */
    public Task<Void> updateCurrentUser(@NonNull FirebaseUser firebaseUser) {
        if (firebaseUser == null) {
            throw new IllegalArgumentException("Cannot update current user with null user!");
        } else if (this.zzgr != null && !firebaseUser.zzcf().equals(this.zzgw)) {
            return Tasks.forException(zzds.zzb(new Status(17072)));
        } else {
            String apiKey = firebaseUser.zzcc().getOptions().getApiKey();
            String apiKey2 = this.zzgm.getOptions().getApiKey();
            if (!firebaseUser.zzcg().isValid() || !apiKey2.equals(apiKey)) {
                return zza(firebaseUser, (zzah) new zzc(this));
            }
            zza(zzl.zza(this.zzgm, firebaseUser), firebaseUser.zzcg(), true);
            return Tasks.forResult(null);
        }
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    public final Task<Void> zzd(@NonNull FirebaseUser firebaseUser) {
        return zza(firebaseUser, (zzah) new zzb());
    }

    @NonNull
    private final Task<Void> zza(@NonNull FirebaseUser firebaseUser, zzah zzah) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzgq.zza(this.zzgm, firebaseUser, zzah);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    @NonNull
    public final Task<AuthResult> zzc(@NonNull FirebaseUser firebaseUser, @NonNull AuthCredential authCredential) {
        Preconditions.checkNotNull(authCredential);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzgq.zza(this.zzgm, firebaseUser, authCredential, (zzah) new zzb());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    @NonNull
    public final Task<AuthResult> zza(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(firebaseUser);
        return this.zzgq.zzd(this.zzgm, firebaseUser, str, new zzb());
    }

    @NonNull
    public Task<AuthResult> createUserWithEmailAndPassword(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzgq.zza(this.zzgm, str, str2, this.zzgw, (com.google.firebase.auth.internal.zza) new zza());
    }

    @Deprecated
    @NonNull
    public Task<ProviderQueryResult> fetchProvidersForEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zza(this.zzgm, str, this.zzgw);
    }

    @NonNull
    public Task<SignInMethodQueryResult> fetchSignInMethodsForEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzb(this.zzgm, str, this.zzgw);
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull UserProfileChangeRequest userProfileChangeRequest) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(userProfileChangeRequest);
        return this.zzgq.zza(this.zzgm, firebaseUser, userProfileChangeRequest, (zzah) new zzb());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    @NonNull
    public final Task<Void> zzb(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzb(this.zzgm, firebaseUser, str, (zzah) new zzb());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    @NonNull
    public final Task<Void> zza(@NonNull FirebaseUser firebaseUser, @NonNull PhoneAuthCredential phoneAuthCredential) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(phoneAuthCredential);
        return this.zzgq.zza(this.zzgm, firebaseUser, phoneAuthCredential, (zzah) new zzb());
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.google.firebase.auth.FirebaseAuth$zzb, com.google.firebase.auth.internal.zzah] */
    @NonNull
    public final Task<Void> zzc(@NonNull FirebaseUser firebaseUser, @NonNull String str) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzc(this.zzgm, firebaseUser, str, new zzb());
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return sendPasswordResetEmail(str, (ActionCodeSettings) null);
    }

    @NonNull
    public Task<Void> sendPasswordResetEmail(@NonNull String str, @Nullable ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        if (actionCodeSettings == null) {
            actionCodeSettings = ActionCodeSettings.zzbs();
        }
        if (this.zzgu != null) {
            actionCodeSettings.zzbm(this.zzgu);
        }
        actionCodeSettings.zza(zzjn.PASSWORD_RESET);
        return this.zzgq.zza(this.zzgm, str, actionCodeSettings, this.zzgw);
    }

    public Task<Void> sendSignInLinkToEmail(@NonNull String str, @NonNull ActionCodeSettings actionCodeSettings) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(actionCodeSettings);
        if (!actionCodeSettings.canHandleCodeInApp()) {
            throw new IllegalArgumentException("You must set canHandleCodeInApp in your ActionCodeSettings to true for Email-Link Sign-in.");
        }
        if (this.zzgu != null) {
            actionCodeSettings.zzbm(this.zzgu);
        }
        return this.zzgq.zzb(this.zzgm, str, actionCodeSettings, this.zzgw);
    }

    public boolean isSignInWithEmailLink(@NonNull String str) {
        return EmailAuthCredential.isSignInWithEmailLink(str);
    }

    @NonNull
    public final Task<Void> zza(@Nullable ActionCodeSettings actionCodeSettings, @NonNull String str) {
        Preconditions.checkNotEmpty(str);
        if (this.zzgu != null) {
            if (actionCodeSettings == null) {
                actionCodeSettings = ActionCodeSettings.zzbs();
            }
            actionCodeSettings.zzbm(this.zzgu);
        }
        return this.zzgq.zza(this.zzgm, actionCodeSettings, str);
    }

    @NonNull
    public Task<ActionCodeResult> checkActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzc(this.zzgm, str, this.zzgw);
    }

    @NonNull
    public Task<Void> applyActionCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zzd(this.zzgm, str, this.zzgw);
    }

    @NonNull
    public Task<String> verifyPasswordResetCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzgq.zze(this.zzgm, str, this.zzgw);
    }

    @NonNull
    public Task<Void> confirmPasswordReset(@NonNull String str, @NonNull String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        return this.zzgq.zza(this.zzgm, str, str2, this.zzgw);
    }

    @NonNull
    public final Task<Void> zze(@NonNull FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        return this.zzgq.zza(firebaseUser, (zzv) new zzo(this, firebaseUser));
    }

    public void signOut() {
        zzca();
        if (this.zzgz != null) {
            this.zzgz.cancel();
        }
    }

    public void setLanguageCode(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzgt) {
            this.zzgu = str;
        }
    }

    @Nullable
    public String getLanguageCode() {
        String str;
        synchronized (this.zzgt) {
            str = this.zzgu;
        }
        return str;
    }

    public final void zzc(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        synchronized (this.zzgv) {
            this.zzgw = str;
        }
    }

    public void useAppLanguage() {
        synchronized (this.zzgt) {
            this.zzgu = zzem.zzdo();
        }
    }

    public FirebaseAuthSettings getFirebaseAuthSettings() {
        return this.zzgs;
    }

    public Task<Void> setFirebaseUIVersion(@Nullable String str) {
        return this.zzgq.setFirebaseUIVersion(str);
    }
}
