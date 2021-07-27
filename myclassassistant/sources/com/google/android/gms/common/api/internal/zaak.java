package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.signin.SignInOptions;
import com.google.android.gms.signin.internal.zaj;
import com.google.android.gms.signin.zad;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;
import javax.annotation.concurrent.GuardedBy;

public final class zaak implements zabd {
    /* access modifiers changed from: private */
    public final Context mContext;
    private final Api.AbstractClientBuilder<? extends zad, SignInOptions> zacd;
    /* access modifiers changed from: private */
    public final Lock zaen;
    private final ClientSettings zaes;
    private final Map<Api<?>, Boolean> zaev;
    /* access modifiers changed from: private */
    public final GoogleApiAvailabilityLight zaex;
    private ConnectionResult zafg;
    /* access modifiers changed from: private */
    public final zabe zafs;
    private int zafv;
    private int zafw = 0;
    private int zafx;
    private final Bundle zafy = new Bundle();
    private final Set<Api.AnyClientKey> zafz = new HashSet();
    /* access modifiers changed from: private */
    public zad zaga;
    private boolean zagb;
    /* access modifiers changed from: private */
    public boolean zagc;
    private boolean zagd;
    /* access modifiers changed from: private */
    public IAccountAccessor zage;
    private boolean zagf;
    private boolean zagg;
    private ArrayList<Future<?>> zagh = new ArrayList<>();

    public zaak(zabe zabe, ClientSettings clientSettings, Map<Api<?>, Boolean> map, GoogleApiAvailabilityLight googleApiAvailabilityLight, Api.AbstractClientBuilder<? extends zad, SignInOptions> abstractClientBuilder, Lock lock, Context context) {
        this.zafs = zabe;
        this.zaes = clientSettings;
        this.zaev = map;
        this.zaex = googleApiAvailabilityLight;
        this.zacd = abstractClientBuilder;
        this.zaen = lock;
        this.mContext = context;
    }

    public final void begin() {
        this.zafs.zaho.clear();
        this.zagc = false;
        this.zafg = null;
        this.zafw = 0;
        this.zagb = true;
        this.zagd = false;
        this.zagf = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api next : this.zaev.keySet()) {
            Api.Client client = this.zafs.zagy.get(next.getClientKey());
            z |= next.zah().getPriority() == 1;
            boolean booleanValue = this.zaev.get(next).booleanValue();
            if (client.requiresSignIn()) {
                this.zagc = true;
                if (booleanValue) {
                    this.zafz.add(next.getClientKey());
                } else {
                    this.zagb = false;
                }
            }
            hashMap.put(client, new zaam(this, next, booleanValue));
        }
        if (z) {
            this.zagc = false;
        }
        if (this.zagc) {
            this.zaes.setClientSessionId(Integer.valueOf(System.identityHashCode(this.zafs.zaed)));
            zaat zaat = new zaat(this, (zaal) null);
            this.zaga = (zad) this.zacd.buildClient(this.mContext, this.zafs.zaed.getLooper(), this.zaes, this.zaes.getSignInOptions(), zaat, zaat);
        }
        this.zafx = this.zafs.zagy.size();
        this.zagh.add(zabh.zabb().submit(new zaan(this, hashMap)));
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean zaao() {
        this.zafx--;
        if (this.zafx > 0) {
            return false;
        }
        if (this.zafx < 0) {
            Log.w("GoogleApiClientConnecting", this.zafs.zaed.zaay());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zae(new ConnectionResult(8, (PendingIntent) null));
            return false;
        } else if (this.zafg == null) {
            return true;
        } else {
            this.zafs.zahr = this.zafv;
            zae(this.zafg);
            return false;
        }
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zaa(zaj zaj) {
        if (zac(0)) {
            ConnectionResult connectionResult = zaj.getConnectionResult();
            if (connectionResult.isSuccess()) {
                ResolveAccountResponse zacw = zaj.zacw();
                ConnectionResult connectionResult2 = zacw.getConnectionResult();
                if (!connectionResult2.isSuccess()) {
                    String valueOf = String.valueOf(connectionResult2);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 48);
                    sb.append("Sign-in succeeded with resolve account failure: ");
                    sb.append(valueOf);
                    Log.wtf("GoogleApiClientConnecting", sb.toString(), new Exception());
                    zae(connectionResult2);
                    return;
                }
                this.zagd = true;
                this.zage = zacw.getAccountAccessor();
                this.zagf = zacw.getSaveDefaultAccount();
                this.zagg = zacw.isFromCrossClientAuth();
                zaap();
            } else if (zad(connectionResult)) {
                zaar();
                zaap();
            } else {
                zae(connectionResult);
            }
        }
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zaap() {
        if (this.zafx == 0) {
            if (!this.zagc || this.zagd) {
                ArrayList arrayList = new ArrayList();
                this.zafw = 1;
                this.zafx = this.zafs.zagy.size();
                for (Api.AnyClientKey next : this.zafs.zagy.keySet()) {
                    if (!this.zafs.zaho.containsKey(next)) {
                        arrayList.add(this.zafs.zagy.get(next));
                    } else if (zaao()) {
                        zaaq();
                    }
                }
                if (!arrayList.isEmpty()) {
                    this.zagh.add(zabh.zabb().submit(new zaaq(this, arrayList)));
                }
            }
        }
    }

    @GuardedBy("mLock")
    public final void onConnected(Bundle bundle) {
        if (zac(1)) {
            if (bundle != null) {
                this.zafy.putAll(bundle);
            }
            if (zaao()) {
                zaaq();
            }
        }
    }

    @GuardedBy("mLock")
    public final void zaa(ConnectionResult connectionResult, Api<?> api, boolean z) {
        if (zac(1)) {
            zab(connectionResult, api, z);
            if (zaao()) {
                zaaq();
            }
        }
    }

    @GuardedBy("mLock")
    private final void zaaq() {
        this.zafs.zaba();
        zabh.zabb().execute(new zaal(this));
        if (this.zaga != null) {
            if (this.zagf) {
                this.zaga.zaa(this.zage, this.zagg);
            }
            zab(false);
        }
        for (Api.AnyClientKey<?> anyClientKey : this.zafs.zaho.keySet()) {
            this.zafs.zagy.get(anyClientKey).disconnect();
        }
        this.zafs.zahs.zab(this.zafy.isEmpty() ? null : this.zafy);
    }

    public final <A extends Api.AnyClient, R extends Result, T extends BaseImplementation.ApiMethodImpl<R, A>> T enqueue(T t) {
        this.zafs.zaed.zafb.add(t);
        return t;
    }

    public final <A extends Api.AnyClient, T extends BaseImplementation.ApiMethodImpl<? extends Result, A>> T execute(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }

    public final void connect() {
    }

    public final boolean disconnect() {
        zaas();
        zab(true);
        this.zafs.zaf((ConnectionResult) null);
        return true;
    }

    @GuardedBy("mLock")
    public final void onConnectionSuspended(int i) {
        zae(new ConnectionResult(8, (PendingIntent) null));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0024, code lost:
        if ((r5.hasResolution() || r4.zaex.getErrorResolutionIntent(r5.getErrorCode()) != null) != false) goto L_0x0026;
     */
    @javax.annotation.concurrent.GuardedBy("mLock")
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zab(com.google.android.gms.common.ConnectionResult r5, com.google.android.gms.common.api.Api<?> r6, boolean r7) {
        /*
            r4 = this;
            com.google.android.gms.common.api.Api$BaseClientBuilder r0 = r6.zah()
            int r0 = r0.getPriority()
            r1 = 0
            r2 = 1
            if (r7 == 0) goto L_0x0026
            boolean r7 = r5.hasResolution()
            if (r7 == 0) goto L_0x0016
        L_0x0014:
            r7 = 1
            goto L_0x0024
        L_0x0016:
            com.google.android.gms.common.GoogleApiAvailabilityLight r7 = r4.zaex
            int r3 = r5.getErrorCode()
            android.content.Intent r7 = r7.getErrorResolutionIntent(r3)
            if (r7 == 0) goto L_0x0023
            goto L_0x0014
        L_0x0023:
            r7 = 0
        L_0x0024:
            if (r7 == 0) goto L_0x002f
        L_0x0026:
            com.google.android.gms.common.ConnectionResult r7 = r4.zafg
            if (r7 == 0) goto L_0x0030
            int r7 = r4.zafv
            if (r0 >= r7) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            goto L_0x0031
        L_0x0030:
            r1 = 1
        L_0x0031:
            if (r1 == 0) goto L_0x0037
            r4.zafg = r5
            r4.zafv = r0
        L_0x0037:
            com.google.android.gms.common.api.internal.zabe r7 = r4.zafs
            java.util.Map<com.google.android.gms.common.api.Api$AnyClientKey<?>, com.google.android.gms.common.ConnectionResult> r7 = r7.zaho
            com.google.android.gms.common.api.Api$AnyClientKey r6 = r6.getClientKey()
            r7.put(r6, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zaak.zab(com.google.android.gms.common.ConnectionResult, com.google.android.gms.common.api.Api, boolean):void");
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zaar() {
        this.zagc = false;
        this.zafs.zaed.zagz = Collections.emptySet();
        for (Api.AnyClientKey next : this.zafz) {
            if (!this.zafs.zaho.containsKey(next)) {
                this.zafs.zaho.put(next, new ConnectionResult(17, (PendingIntent) null));
            }
        }
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean zad(ConnectionResult connectionResult) {
        return this.zagb && !connectionResult.hasResolution();
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final void zae(ConnectionResult connectionResult) {
        zaas();
        zab(!connectionResult.hasResolution());
        this.zafs.zaf(connectionResult);
        this.zafs.zahs.zac(connectionResult);
    }

    private final void zab(boolean z) {
        if (this.zaga != null) {
            if (this.zaga.isConnected() && z) {
                this.zaga.zacv();
            }
            this.zaga.disconnect();
            this.zage = null;
        }
    }

    private final void zaas() {
        ArrayList arrayList = this.zagh;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((Future) obj).cancel(true);
        }
        this.zagh.clear();
    }

    /* access modifiers changed from: private */
    public final Set<Scope> zaat() {
        if (this.zaes == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet(this.zaes.getRequiredScopes());
        Map<Api<?>, ClientSettings.OptionalApiSettings> optionalApiSettings = this.zaes.getOptionalApiSettings();
        for (Api next : optionalApiSettings.keySet()) {
            if (!this.zafs.zaho.containsKey(next.getClientKey())) {
                hashSet.addAll(optionalApiSettings.get(next).mScopes);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: private */
    @GuardedBy("mLock")
    public final boolean zac(int i) {
        if (this.zafw == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.zafs.zaed.zaay());
        String valueOf = String.valueOf(this);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 23);
        sb.append("Unexpected callback in ");
        sb.append(valueOf);
        Log.w("GoogleApiClientConnecting", sb.toString());
        int i2 = this.zafx;
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append("mRemainingConnections=");
        sb2.append(i2);
        Log.w("GoogleApiClientConnecting", sb2.toString());
        String zad = zad(this.zafw);
        String zad2 = zad(i);
        StringBuilder sb3 = new StringBuilder(String.valueOf(zad).length() + 70 + String.valueOf(zad2).length());
        sb3.append("GoogleApiClient connecting is in step ");
        sb3.append(zad);
        sb3.append(" but received callback for step ");
        sb3.append(zad2);
        Log.wtf("GoogleApiClientConnecting", sb3.toString(), new Exception());
        zae(new ConnectionResult(8, (PendingIntent) null));
        return false;
    }

    private static String zad(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }
}
