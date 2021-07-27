package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.firebase_auth.zzdr;
import com.google.android.gms.internal.firebase_auth.zzz;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public final class zzac {
    @VisibleForTesting
    private static long zzrr = 3600000;
    private static final zzz<String> zzrs = zzz.zza("firebaseAppName", "firebaseUserUid", "operation", "tenantId", "verifyAssertionRequest", "statusCode", "statusMessage", "timestamp");
    private static final zzac zzrt = new zzac();
    private Task<AuthResult> zzru;
    private long zzrv = 0;

    private zzac() {
    }

    public static zzac zzen() {
        return zzrt;
    }

    public static void zza(@NonNull Context context, @NonNull zzdr zzdr, @NonNull String str, @Nullable String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putString("verifyAssertionRequest", SafeParcelableSerializer.serializeToString(zzdr));
        edit.putString("operation", str);
        edit.putString("tenantId", str2);
        edit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    public static void zza(@NonNull Context context, @NonNull Status status) {
        SharedPreferences.Editor edit = context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0).edit();
        edit.putInt("statusCode", status.getStatusCode());
        edit.putString("statusMessage", status.getStatusMessage());
        edit.putLong("timestamp", DefaultClock.getInstance().currentTimeMillis());
        edit.commit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0082, code lost:
        if (r5.equals("com.google.firebase.auth.internal.SIGN_IN") == false) goto L_0x0099;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x009d  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzh(@android.support.annotation.NonNull com.google.firebase.auth.FirebaseAuth r10) {
        /*
            r9 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r10)
            com.google.firebase.FirebaseApp r0 = r10.zzcc()
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r1 = "com.google.firebase.auth.internal.ProcessDeathHelper"
            r2 = 0
            android.content.SharedPreferences r0 = r0.getSharedPreferences(r1, r2)
            java.lang.String r1 = "firebaseAppName"
            java.lang.String r3 = ""
            java.lang.String r1 = r0.getString(r1, r3)
            com.google.firebase.FirebaseApp r3 = r10.zzcc()
            java.lang.String r3 = r3.getName()
            boolean r1 = r3.equals(r1)
            if (r1 != 0) goto L_0x0029
            return
        L_0x0029:
            java.lang.String r1 = "verifyAssertionRequest"
            boolean r1 = r0.contains(r1)
            r3 = 0
            if (r1 == 0) goto L_0x00f2
            java.lang.String r1 = "verifyAssertionRequest"
            java.lang.String r5 = ""
            java.lang.String r1 = r0.getString(r1, r5)
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdr> r5 = com.google.android.gms.internal.firebase_auth.zzdr.CREATOR
            com.google.android.gms.common.internal.safeparcel.SafeParcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer.deserializeFromString(r1, r5)
            com.google.android.gms.internal.firebase_auth.zzdr r1 = (com.google.android.gms.internal.firebase_auth.zzdr) r1
            java.lang.String r5 = "operation"
            java.lang.String r6 = ""
            java.lang.String r5 = r0.getString(r5, r6)
            java.lang.String r6 = "tenantId"
            r7 = 0
            java.lang.String r6 = r0.getString(r6, r7)
            java.lang.String r8 = "timestamp"
            long r3 = r0.getLong(r8, r3)
            r9.zzrv = r3
            java.lang.String r3 = "firebaseUserUid"
            java.lang.String r4 = ""
            java.lang.String r3 = r0.getString(r3, r4)
            if (r6 == 0) goto L_0x0067
            r10.zzc((java.lang.String) r6)
        L_0x0067:
            r4 = -1
            int r6 = r5.hashCode()
            r8 = -1843829902(0xffffffff92196372, float:-4.8400863E-28)
            if (r6 == r8) goto L_0x008f
            r8 = -286760092(0xffffffffeee86364, float:-3.596034E28)
            if (r6 == r8) goto L_0x0085
            r8 = 1731327805(0x6731f73d, float:8.404196E23)
            if (r6 == r8) goto L_0x007c
            goto L_0x0099
        L_0x007c:
            java.lang.String r6 = "com.google.firebase.auth.internal.SIGN_IN"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x0099
            goto L_0x009a
        L_0x0085:
            java.lang.String r2 = "com.google.firebase.auth.internal.LINK"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0099
            r2 = 1
            goto L_0x009a
        L_0x008f:
            java.lang.String r2 = "com.google.firebase.auth.internal.REAUTHENTICATE"
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x0099
            r2 = 2
            goto L_0x009a
        L_0x0099:
            r2 = -1
        L_0x009a:
            switch(r2) {
                case 0: goto L_0x00e2;
                case 1: goto L_0x00c1;
                case 2: goto L_0x00a0;
                default: goto L_0x009d;
            }
        L_0x009d:
            r9.zzru = r7
            goto L_0x00ee
        L_0x00a0:
            com.google.firebase.auth.FirebaseUser r2 = r10.getCurrentUser()
            java.lang.String r2 = r2.getUid()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00be
            com.google.firebase.auth.FirebaseUser r10 = r10.getCurrentUser()
            com.google.firebase.auth.zzd r1 = com.google.firebase.auth.zzd.zza(r1)
            com.google.android.gms.tasks.Task r10 = r10.reauthenticateAndRetrieveData(r1)
            r9.zzru = r10
            goto L_0x00ee
        L_0x00be:
            r9.zzru = r7
            goto L_0x00ee
        L_0x00c1:
            com.google.firebase.auth.FirebaseUser r2 = r10.getCurrentUser()
            java.lang.String r2 = r2.getUid()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00df
            com.google.firebase.auth.FirebaseUser r10 = r10.getCurrentUser()
            com.google.firebase.auth.zzd r1 = com.google.firebase.auth.zzd.zza(r1)
            com.google.android.gms.tasks.Task r10 = r10.linkWithCredential(r1)
            r9.zzru = r10
            goto L_0x00ee
        L_0x00df:
            r9.zzru = r7
            goto L_0x00ee
        L_0x00e2:
            com.google.firebase.auth.zzd r1 = com.google.firebase.auth.zzd.zza(r1)
            com.google.android.gms.tasks.Task r10 = r10.signInWithCredential(r1)
            r9.zzru = r10
        L_0x00ee:
            zza((android.content.SharedPreferences) r0)
            return
        L_0x00f2:
            java.lang.String r10 = "statusCode"
            boolean r10 = r0.contains(r10)
            if (r10 == 0) goto L_0x0126
            java.lang.String r10 = "statusCode"
            r1 = 17062(0x42a6, float:2.3909E-41)
            int r10 = r0.getInt(r10, r1)
            java.lang.String r1 = "statusMessage"
            java.lang.String r2 = ""
            java.lang.String r1 = r0.getString(r1, r2)
            com.google.android.gms.common.api.Status r2 = new com.google.android.gms.common.api.Status
            r2.<init>(r10, r1)
            java.lang.String r10 = "timestamp"
            long r3 = r0.getLong(r10, r3)
            r9.zzrv = r3
            zza((android.content.SharedPreferences) r0)
            com.google.firebase.FirebaseException r10 = com.google.firebase.auth.api.internal.zzds.zzb(r2)
            com.google.android.gms.tasks.Task r10 = com.google.android.gms.tasks.Tasks.forException(r10)
            r9.zzru = r10
            return
        L_0x0126:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzac.zzh(com.google.firebase.auth.FirebaseAuth):void");
    }

    public final void zza(@NonNull Context context) {
        Preconditions.checkNotNull(context);
        zza(context.getSharedPreferences("com.google.firebase.auth.internal.ProcessDeathHelper", 0));
        this.zzru = null;
        this.zzrv = 0;
    }

    private static void zza(@NonNull SharedPreferences sharedPreferences) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        zzz zzz = zzrs;
        int size = zzz.size();
        int i = 0;
        while (i < size) {
            Object obj = zzz.get(i);
            i++;
            edit.remove((String) obj);
        }
        edit.commit();
    }
}
