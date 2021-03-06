package com.google.android.gms.internal.firebase_auth;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

public final class zzdl implements zzff<zzj.zzl> {
    private String zzgc;
    private String zzgh;
    private String zzgi;
    @Nullable
    private String zzgw;
    private String zzhw;
    private String zzhx;
    private zzdp zzpr = new zzdp();
    private zzdp zzps = new zzdp();
    private boolean zzpt = true;
    private String zzpu;

    public final boolean zzch(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        return this.zzps.zzeb().contains(str);
    }

    @Nullable
    public final String getEmail() {
        return this.zzgh;
    }

    @Nullable
    public final String getPassword() {
        return this.zzgi;
    }

    @Nullable
    public final String getDisplayName() {
        return this.zzhw;
    }

    @Nullable
    public final String zzal() {
        return this.zzhx;
    }

    @NonNull
    public final zzdl zzci(@NonNull String str) {
        this.zzgc = Preconditions.checkNotEmpty(str);
        return this;
    }

    @NonNull
    public final zzdl zzcj(@Nullable String str) {
        if (str == null) {
            this.zzps.zzeb().add("EMAIL");
        } else {
            this.zzgh = str;
        }
        return this;
    }

    @NonNull
    public final zzdl zzck(@Nullable String str) {
        if (str == null) {
            this.zzps.zzeb().add("PASSWORD");
        } else {
            this.zzgi = str;
        }
        return this;
    }

    @NonNull
    public final zzdl zzcl(@Nullable String str) {
        if (str == null) {
            this.zzps.zzeb().add("DISPLAY_NAME");
        } else {
            this.zzhw = str;
        }
        return this;
    }

    @NonNull
    public final zzdl zzcm(@Nullable String str) {
        if (str == null) {
            this.zzps.zzeb().add("PHOTO_URL");
        } else {
            this.zzhx = str;
        }
        return this;
    }

    @NonNull
    public final zzdl zzcn(@NonNull String str) {
        Preconditions.checkNotEmpty(str);
        this.zzpr.zzeb().add(str);
        return this;
    }

    @NonNull
    public final zzdl zzco(@NonNull String str) {
        this.zzpu = Preconditions.checkNotEmpty(str);
        return this;
    }

    @NonNull
    public final zzdl zzcp(@Nullable String str) {
        this.zzgw = str;
        return this;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x007e  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0081  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.google.android.gms.internal.firebase_auth.zzhb zzds() {
        /*
            r9 = this;
            com.google.android.gms.internal.firebase_auth.zzj$zzl$zza r0 = com.google.android.gms.internal.firebase_auth.zzj.zzl.zzai()
            boolean r1 = r9.zzpt
            com.google.android.gms.internal.firebase_auth.zzj$zzl$zza r0 = r0.zzf(r1)
            com.google.android.gms.internal.firebase_auth.zzdp r1 = r9.zzpr
            java.util.List r1 = r1.zzeb()
            com.google.android.gms.internal.firebase_auth.zzj$zzl$zza r0 = r0.zzd(r1)
            com.google.android.gms.internal.firebase_auth.zzdp r1 = r9.zzps
            java.util.List r1 = r1.zzeb()
            int r2 = r1.size()
            com.google.android.gms.internal.firebase_auth.zzo[] r2 = new com.google.android.gms.internal.firebase_auth.zzo[r2]
            r3 = 0
            r4 = 0
        L_0x0023:
            int r5 = r1.size()
            if (r4 >= r5) goto L_0x0088
            java.lang.Object r5 = r1.get(r4)
            java.lang.String r5 = (java.lang.String) r5
            r6 = -1
            int r7 = r5.hashCode()
            r8 = -333046776(0xffffffffec261c08, float:-8.0325624E26)
            if (r7 == r8) goto L_0x0067
            r8 = 66081660(0x3f0537c, float:1.4125099E-36)
            if (r7 == r8) goto L_0x005d
            r8 = 1939891618(0x73a065a2, float:2.541592E31)
            if (r7 == r8) goto L_0x0053
            r8 = 1999612571(0x772faa9b, float:3.5629384E33)
            if (r7 == r8) goto L_0x0049
            goto L_0x0071
        L_0x0049:
            java.lang.String r7 = "PASSWORD"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0071
            r5 = 2
            goto L_0x0072
        L_0x0053:
            java.lang.String r7 = "PHOTO_URL"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0071
            r5 = 3
            goto L_0x0072
        L_0x005d:
            java.lang.String r7 = "EMAIL"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0071
            r5 = 0
            goto L_0x0072
        L_0x0067:
            java.lang.String r7 = "DISPLAY_NAME"
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L_0x0071
            r5 = 1
            goto L_0x0072
        L_0x0071:
            r5 = -1
        L_0x0072:
            switch(r5) {
                case 0: goto L_0x0081;
                case 1: goto L_0x007e;
                case 2: goto L_0x007b;
                case 3: goto L_0x0078;
                default: goto L_0x0075;
            }
        L_0x0075:
            com.google.android.gms.internal.firebase_auth.zzo r5 = com.google.android.gms.internal.firebase_auth.zzo.USER_ATTRIBUTE_NAME_UNSPECIFIED
            goto L_0x0083
        L_0x0078:
            com.google.android.gms.internal.firebase_auth.zzo r5 = com.google.android.gms.internal.firebase_auth.zzo.PHOTO_URL
            goto L_0x0083
        L_0x007b:
            com.google.android.gms.internal.firebase_auth.zzo r5 = com.google.android.gms.internal.firebase_auth.zzo.PASSWORD
            goto L_0x0083
        L_0x007e:
            com.google.android.gms.internal.firebase_auth.zzo r5 = com.google.android.gms.internal.firebase_auth.zzo.DISPLAY_NAME
            goto L_0x0083
        L_0x0081:
            com.google.android.gms.internal.firebase_auth.zzo r5 = com.google.android.gms.internal.firebase_auth.zzo.EMAIL
        L_0x0083:
            r2[r4] = r5
            int r4 = r4 + 1
            goto L_0x0023
        L_0x0088:
            java.util.List r1 = java.util.Arrays.asList(r2)
            com.google.android.gms.internal.firebase_auth.zzj$zzl$zza r0 = r0.zzc(r1)
            java.lang.String r1 = r9.zzgc
            if (r1 == 0) goto L_0x009a
            java.lang.String r1 = r9.zzgc
            r0.zzan(r1)
        L_0x009a:
            java.lang.String r1 = r9.zzgh
            if (r1 == 0) goto L_0x00a3
            java.lang.String r1 = r9.zzgh
            r0.zzap(r1)
        L_0x00a3:
            java.lang.String r1 = r9.zzgi
            if (r1 == 0) goto L_0x00ac
            java.lang.String r1 = r9.zzgi
            r0.zzaq(r1)
        L_0x00ac:
            java.lang.String r1 = r9.zzhw
            if (r1 == 0) goto L_0x00b5
            java.lang.String r1 = r9.zzhw
            r0.zzao(r1)
        L_0x00b5:
            java.lang.String r1 = r9.zzhx
            if (r1 == 0) goto L_0x00be
            java.lang.String r1 = r9.zzhx
            r0.zzas(r1)
        L_0x00be:
            java.lang.String r1 = r9.zzpu
            if (r1 == 0) goto L_0x00c7
            java.lang.String r1 = r9.zzpu
            r0.zzar(r1)
        L_0x00c7:
            java.lang.String r1 = r9.zzgw
            if (r1 == 0) goto L_0x00d0
            java.lang.String r1 = r9.zzgw
            r0.zzat(r1)
        L_0x00d0:
            com.google.android.gms.internal.firebase_auth.zzhb r0 = r0.zzhm()
            com.google.android.gms.internal.firebase_auth.zzfs r0 = (com.google.android.gms.internal.firebase_auth.zzfs) r0
            com.google.android.gms.internal.firebase_auth.zzj$zzl r0 = (com.google.android.gms.internal.firebase_auth.zzj.zzl) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzdl.zzds():com.google.android.gms.internal.firebase_auth.zzhb");
    }
}
