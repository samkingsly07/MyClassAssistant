package com.google.firebase.auth.internal;

import android.content.Intent;
import android.os.Bundle;
import android.support.p000v4.app.FragmentActivity;
import android.support.p000v4.content.LocalBroadcastManager;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.Status;

@KeepName
public class FederatedSignInActivity extends FragmentActivity {
    private static final zzz zzgy = zzz.zzem();
    private static boolean zzrl = false;
    private boolean zzrm = false;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        String action = getIntent().getAction();
        if (!"com.google.firebase.auth.internal.SIGN_IN".equals(action) && !"com.google.firebase.auth.internal.LINK".equals(action) && !"com.google.firebase.auth.internal.REAUTHENTICATE".equals(action)) {
            String valueOf = String.valueOf(action);
            Log.e("IdpSignInActivity", valueOf.length() != 0 ? "Unknown action: ".concat(valueOf) : new String("Unknown action: "));
            zzel();
        } else if (zzrl) {
            finish();
        } else {
            zzrl = true;
            if (bundle != null) {
                this.zzrm = bundle.getBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean("com.google.firebase.auth.internal.KEY_STARTED_SIGN_IN", this.zzrm);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ab A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00ac  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r7 = this;
            super.onResume()
            android.content.Intent r0 = r7.getIntent()
            java.lang.String r1 = "com.google.firebase.auth.internal.WEB_SIGN_IN_FAILED"
            java.lang.String r2 = r0.getAction()
            boolean r1 = r1.equals(r2)
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0031
            java.lang.String r1 = "IdpSignInActivity"
            java.lang.String r2 = "Web sign-in failed, finishing"
            android.util.Log.e(r1, r2)
            boolean r1 = com.google.firebase.auth.internal.zzai.zza(r0)
            if (r1 == 0) goto L_0x002b
            com.google.android.gms.common.api.Status r0 = com.google.firebase.auth.internal.zzai.zzb(r0)
            r7.zze(r0)
            goto L_0x002e
        L_0x002b:
            r7.zzel()
        L_0x002e:
            r2 = 1
            goto L_0x00a8
        L_0x0031:
            java.lang.String r1 = "com.google.firebase.auth.internal.OPERATION"
            boolean r1 = r0.hasExtra(r1)
            if (r1 == 0) goto L_0x00a7
            java.lang.String r1 = "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST"
            boolean r1 = r0.hasExtra(r1)
            if (r1 == 0) goto L_0x00a7
            java.lang.String r1 = "com.google.firebase.auth.internal.EXTRA_TENANT_ID"
            java.lang.String r1 = r0.getStringExtra(r1)
            java.lang.String r4 = "com.google.firebase.auth.internal.OPERATION"
            java.lang.String r4 = r0.getStringExtra(r4)
            java.lang.String r5 = "com.google.firebase.auth.internal.SIGN_IN"
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0068
            java.lang.String r5 = "com.google.firebase.auth.internal.LINK"
            boolean r5 = r5.equals(r4)
            if (r5 != 0) goto L_0x0068
            java.lang.String r5 = "com.google.firebase.auth.internal.REAUTHENTICATE"
            boolean r5 = r5.equals(r4)
            if (r5 == 0) goto L_0x0066
            goto L_0x0068
        L_0x0066:
            goto L_0x00a8
        L_0x0068:
            java.lang.String r5 = "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST"
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdr> r6 = com.google.android.gms.internal.firebase_auth.zzdr.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromIntentExtra(r0, r5, r6)
            com.google.android.gms.internal.firebase_auth.zzdr r0 = (com.google.android.gms.internal.firebase_auth.zzdr) r0
            zzrl = r2
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r5 = "com.google.firebase.auth.internal.VERIFY_ASSERTION_REQUEST"
            com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.serializeToIntentExtra(r0, r2, r5)
            java.lang.String r5 = "com.google.firebase.auth.internal.OPERATION"
            r2.putExtra(r5, r4)
            java.lang.String r5 = "com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT"
            r2.setAction(r5)
            android.support.v4.content.LocalBroadcastManager r5 = android.support.p000v4.content.LocalBroadcastManager.getInstance(r7)
            boolean r2 = r5.sendBroadcast(r2)
            if (r2 != 0) goto L_0x009e
            android.content.Context r2 = r7.getApplicationContext()
            com.google.firebase.auth.internal.zzac.zza(r2, r0, r4, r1)
            goto L_0x00a3
        L_0x009e:
            com.google.firebase.auth.internal.zzz r0 = zzgy
            r0.zza(r7)
        L_0x00a3:
            r7.finish()
            goto L_0x002e
        L_0x00a7:
        L_0x00a8:
            if (r2 == 0) goto L_0x00ac
            return
        L_0x00ac:
            boolean r0 = r7.zzrm
            if (r0 != 0) goto L_0x00f1
            android.content.Intent r0 = new android.content.Intent
            java.lang.String r1 = "com.google.firebase.auth.api.gms.ui.START_WEB_SIGN_IN"
            r0.<init>(r1)
            java.lang.String r1 = "com.google.android.gms"
            r0.setPackage(r1)
            android.content.Intent r1 = r7.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            r0.putExtras(r1)
            java.lang.String r1 = "com.google.firebase.auth.internal.OPERATION"
            android.content.Intent r2 = r7.getIntent()
            java.lang.String r2 = r2.getAction()
            r0.putExtra(r1, r2)
            r1 = 40963(0xa003, float:5.7401E-41)
            r7.startActivityForResult(r0, r1)     // Catch:{ ActivityNotFoundException -> 0x00dc }
            goto L_0x00ee
        L_0x00dc:
            r0 = move-exception
            java.lang.String r0 = "Could not launch web sign-in Intent. Google Play service is unavailable"
            java.lang.String r1 = "IdpSignInActivity"
            android.util.Log.w(r1, r0)
            com.google.android.gms.common.api.Status r1 = new com.google.android.gms.common.api.Status
            r2 = 17499(0x445b, float:2.4521E-41)
            r1.<init>(r2, r0)
            r7.zze(r1)
        L_0x00ee:
            r7.zzrm = r3
            return
        L_0x00f1:
            r7.zzel()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.FederatedSignInActivity.onResume():void");
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    private final void zzel() {
        zzrl = false;
        this.zzrm = false;
        Intent intent = new Intent();
        intent.putExtra("com.google.firebase.auth.internal.EXTRA_CANCELED", true);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzac.zza(this, zzq.zzct("WEB_CONTEXT_CANCELED"));
        } else {
            zzgy.zza(this);
        }
        finish();
    }

    private final void zze(Status status) {
        zzrl = false;
        Intent intent = new Intent();
        zzai.zza(intent, status);
        intent.setAction("com.google.firebase.auth.ACTION_RECEIVE_FIREBASE_AUTH_INTENT");
        if (!LocalBroadcastManager.getInstance(this).sendBroadcast(intent)) {
            zzac.zza(getApplicationContext(), status);
        } else {
            zzgy.zza(this);
        }
        finish();
    }
}
