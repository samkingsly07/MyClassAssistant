package com.google.firebase.auth.api.internal;

import com.google.android.gms.internal.firebase_auth.zzb;

public abstract class zzeb extends zzb implements zzea {
    public zzeb() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthService");
    }

    /* JADX WARNING: type inference failed for: r5v17, types: [android.os.IInterface] */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean dispatchTransaction(int r4, android.os.Parcel r5, android.os.Parcel r6, int r7) throws android.os.RemoteException {
        /*
            r3 = this;
            r7 = 0
            switch(r4) {
                case 1: goto L_0x0837;
                case 2: goto L_0x0815;
                case 3: goto L_0x07ef;
                case 4: goto L_0x07c4;
                case 5: goto L_0x079d;
                case 6: goto L_0x0776;
                case 7: goto L_0x074f;
                case 8: goto L_0x0728;
                case 9: goto L_0x0705;
                case 10: goto L_0x06e2;
                case 11: goto L_0x06b7;
                case 12: goto L_0x068c;
                case 13: goto L_0x0669;
                case 14: goto L_0x0642;
                case 15: goto L_0x061f;
                case 16: goto L_0x05ff;
                case 17: goto L_0x05dc;
                case 18: goto L_0x05b9;
                case 19: goto L_0x0596;
                case 20: goto L_0x0573;
                case 21: goto L_0x054c;
                case 22: goto L_0x0525;
                case 23: goto L_0x04fe;
                case 24: goto L_0x04d3;
                case 25: goto L_0x04a8;
                case 26: goto L_0x047d;
                case 27: goto L_0x045a;
                case 28: goto L_0x042f;
                case 29: goto L_0x0408;
                default: goto L_0x0004;
            }
        L_0x0004:
            switch(r4) {
                case 101: goto L_0x03e1;
                case 102: goto L_0x03ba;
                case 103: goto L_0x0393;
                case 104: goto L_0x036c;
                case 105: goto L_0x0345;
                case 106: goto L_0x031e;
                case 107: goto L_0x02f7;
                case 108: goto L_0x02d0;
                case 109: goto L_0x02a9;
                default: goto L_0x0007;
            }
        L_0x0007:
            switch(r4) {
                case 111: goto L_0x0282;
                case 112: goto L_0x025b;
                case 113: goto L_0x0234;
                case 114: goto L_0x020d;
                case 115: goto L_0x01e6;
                case 116: goto L_0x01bf;
                case 117: goto L_0x0198;
                default: goto L_0x000a;
            }
        L_0x000a:
            switch(r4) {
                case 119: goto L_0x0171;
                case 120: goto L_0x014a;
                case 121: goto L_0x0123;
                case 122: goto L_0x00fc;
                case 123: goto L_0x00d5;
                case 124: goto L_0x00ae;
                default: goto L_0x000d;
            }
        L_0x000d:
            switch(r4) {
                case 126: goto L_0x0087;
                case 127: goto L_0x0060;
                case 128: goto L_0x0039;
                case 129: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            r4 = 0
            return r4
        L_0x0012:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbw> r4 = com.google.android.gms.internal.firebase_auth.zzbw.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbw r4 = (com.google.android.gms.internal.firebase_auth.zzbw) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0021
            goto L_0x0033
        L_0x0021:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x002e
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0033
        L_0x002e:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0033:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbw) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0039:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbi> r4 = com.google.android.gms.internal.firebase_auth.zzbi.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbi r4 = (com.google.android.gms.internal.firebase_auth.zzbi) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0048
            goto L_0x005a
        L_0x0048:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0055
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x005a
        L_0x0055:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x005a:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbi) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0060:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbm> r4 = com.google.android.gms.internal.firebase_auth.zzbm.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbm r4 = (com.google.android.gms.internal.firebase_auth.zzbm) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x006f
            goto L_0x0081
        L_0x006f:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x007c
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0081
        L_0x007c:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0081:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbm) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0087:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbg> r4 = com.google.android.gms.internal.firebase_auth.zzbg.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbg r4 = (com.google.android.gms.internal.firebase_auth.zzbg) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0096
            goto L_0x00a8
        L_0x0096:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x00a3
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x00a8
        L_0x00a3:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x00a8:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbg) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x00ae:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbc> r4 = com.google.android.gms.internal.firebase_auth.zzbc.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbc r4 = (com.google.android.gms.internal.firebase_auth.zzbc) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x00bd
            goto L_0x00cf
        L_0x00bd:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x00ca
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x00cf
        L_0x00ca:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x00cf:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbc) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x00d5:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzby> r4 = com.google.android.gms.internal.firebase_auth.zzby.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzby r4 = (com.google.android.gms.internal.firebase_auth.zzby) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x00e4
            goto L_0x00f6
        L_0x00e4:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x00f1
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x00f6
        L_0x00f1:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x00f6:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzby) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x00fc:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbk> r4 = com.google.android.gms.internal.firebase_auth.zzbk.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbk r4 = (com.google.android.gms.internal.firebase_auth.zzbk) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x010b
            goto L_0x011d
        L_0x010b:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0118
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x011d
        L_0x0118:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x011d:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbk) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0123:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzao> r4 = com.google.android.gms.internal.firebase_auth.zzao.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzao r4 = (com.google.android.gms.internal.firebase_auth.zzao) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0132
            goto L_0x0144
        L_0x0132:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x013f
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0144
        L_0x013f:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0144:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzao) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x014a:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzag> r4 = com.google.android.gms.internal.firebase_auth.zzag.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzag r4 = (com.google.android.gms.internal.firebase_auth.zzag) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0159
            goto L_0x016b
        L_0x0159:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0166
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x016b
        L_0x0166:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x016b:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzag) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0171:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzam> r4 = com.google.android.gms.internal.firebase_auth.zzam.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzam r4 = (com.google.android.gms.internal.firebase_auth.zzam) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0180
            goto L_0x0192
        L_0x0180:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x018d
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0192
        L_0x018d:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0192:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzam) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0198:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzas> r4 = com.google.android.gms.internal.firebase_auth.zzas.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzas r4 = (com.google.android.gms.internal.firebase_auth.zzas) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x01a7
            goto L_0x01b9
        L_0x01a7:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x01b4
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x01b9
        L_0x01b4:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x01b9:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzas) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x01bf:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbo> r4 = com.google.android.gms.internal.firebase_auth.zzbo.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbo r4 = (com.google.android.gms.internal.firebase_auth.zzbo) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x01ce
            goto L_0x01e0
        L_0x01ce:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x01db
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x01e0
        L_0x01db:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x01e0:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbo) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x01e6:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbe> r4 = com.google.android.gms.internal.firebase_auth.zzbe.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbe r4 = (com.google.android.gms.internal.firebase_auth.zzbe) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x01f5
            goto L_0x0207
        L_0x01f5:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0202
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0207
        L_0x0202:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0207:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbe) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x020d:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcc> r4 = com.google.android.gms.internal.firebase_auth.zzcc.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzcc r4 = (com.google.android.gms.internal.firebase_auth.zzcc) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x021c
            goto L_0x022e
        L_0x021c:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0229
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x022e
        L_0x0229:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x022e:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzcc) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0234:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzca> r4 = com.google.android.gms.internal.firebase_auth.zzca.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzca r4 = (com.google.android.gms.internal.firebase_auth.zzca) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0243
            goto L_0x0255
        L_0x0243:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0250
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0255
        L_0x0250:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0255:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzca) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x025b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzba> r4 = com.google.android.gms.internal.firebase_auth.zzba.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzba r4 = (com.google.android.gms.internal.firebase_auth.zzba) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x026a
            goto L_0x027c
        L_0x026a:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0277
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x027c
        L_0x0277:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x027c:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzba) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0282:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzay> r4 = com.google.android.gms.internal.firebase_auth.zzay.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzay r4 = (com.google.android.gms.internal.firebase_auth.zzay) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0291
            goto L_0x02a3
        L_0x0291:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x029e
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x02a3
        L_0x029e:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x02a3:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzay) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x02a9:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzaw> r4 = com.google.android.gms.internal.firebase_auth.zzaw.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzaw r4 = (com.google.android.gms.internal.firebase_auth.zzaw) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x02b8
            goto L_0x02ca
        L_0x02b8:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x02c5
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x02ca
        L_0x02c5:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x02ca:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzaw) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x02d0:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbu> r4 = com.google.android.gms.internal.firebase_auth.zzbu.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbu r4 = (com.google.android.gms.internal.firebase_auth.zzbu) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x02df
            goto L_0x02f1
        L_0x02df:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x02ec
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x02f1
        L_0x02ec:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x02f1:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbu) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x02f7:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzaq> r4 = com.google.android.gms.internal.firebase_auth.zzaq.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzaq r4 = (com.google.android.gms.internal.firebase_auth.zzaq) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0306
            goto L_0x0318
        L_0x0306:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0313
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0318
        L_0x0313:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0318:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzaq) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x031e:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzak> r4 = com.google.android.gms.internal.firebase_auth.zzak.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzak r4 = (com.google.android.gms.internal.firebase_auth.zzak) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x032d
            goto L_0x033f
        L_0x032d:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x033a
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x033f
        L_0x033a:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x033f:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzak) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0345:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzai> r4 = com.google.android.gms.internal.firebase_auth.zzai.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzai r4 = (com.google.android.gms.internal.firebase_auth.zzai) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0354
            goto L_0x0366
        L_0x0354:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0361
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0366
        L_0x0361:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0366:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzai) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x036c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzce> r4 = com.google.android.gms.internal.firebase_auth.zzce.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzce r4 = (com.google.android.gms.internal.firebase_auth.zzce) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x037b
            goto L_0x038d
        L_0x037b:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0388
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x038d
        L_0x0388:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x038d:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzce) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0393:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbq> r4 = com.google.android.gms.internal.firebase_auth.zzbq.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbq r4 = (com.google.android.gms.internal.firebase_auth.zzbq) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x03a2
            goto L_0x03b4
        L_0x03a2:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x03af
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x03b4
        L_0x03af:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x03b4:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbq) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x03ba:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzbs> r4 = com.google.android.gms.internal.firebase_auth.zzbs.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzbs r4 = (com.google.android.gms.internal.firebase_auth.zzbs) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x03c9
            goto L_0x03db
        L_0x03c9:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x03d6
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x03db
        L_0x03d6:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x03db:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzbs) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x03e1:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzau> r4 = com.google.android.gms.internal.firebase_auth.zzau.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzau r4 = (com.google.android.gms.internal.firebase_auth.zzau) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x03f0
            goto L_0x0402
        L_0x03f0:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x03fd
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0402
        L_0x03fd:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0402:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzau) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0408:
            android.os.Parcelable$Creator<com.google.firebase.auth.EmailAuthCredential> r4 = com.google.firebase.auth.EmailAuthCredential.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.firebase.auth.EmailAuthCredential r4 = (com.google.firebase.auth.EmailAuthCredential) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0417
            goto L_0x0429
        L_0x0417:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0424
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0429
        L_0x0424:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0429:
            r3.zza((com.google.firebase.auth.EmailAuthCredential) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x042f:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.firebase.auth.ActionCodeSettings> r0 = com.google.firebase.auth.ActionCodeSettings.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r0)
            com.google.firebase.auth.ActionCodeSettings r0 = (com.google.firebase.auth.ActionCodeSettings) r0
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0442
            goto L_0x0454
        L_0x0442:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x044f
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0454
        L_0x044f:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0454:
            r3.zzc((java.lang.String) r4, (com.google.firebase.auth.ActionCodeSettings) r0, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x045a:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0465
            goto L_0x0477
        L_0x0465:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0472
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0477
        L_0x0472:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0477:
            r3.zzk(r4, r7)
            goto L_0x0859
        L_0x047d:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.firebase.auth.ActionCodeSettings> r0 = com.google.firebase.auth.ActionCodeSettings.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r0)
            com.google.firebase.auth.ActionCodeSettings r0 = (com.google.firebase.auth.ActionCodeSettings) r0
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0490
            goto L_0x04a2
        L_0x0490:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x049d
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x04a2
        L_0x049d:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x04a2:
            r3.zzb((java.lang.String) r4, (com.google.firebase.auth.ActionCodeSettings) r0, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x04a8:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.firebase.auth.ActionCodeSettings> r0 = com.google.firebase.auth.ActionCodeSettings.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r0)
            com.google.firebase.auth.ActionCodeSettings r0 = (com.google.firebase.auth.ActionCodeSettings) r0
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x04bb
            goto L_0x04cd
        L_0x04bb:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x04c8
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x04cd
        L_0x04c8:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x04cd:
            r3.zza((java.lang.String) r4, (com.google.firebase.auth.ActionCodeSettings) r0, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x04d3:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.firebase.auth.PhoneAuthCredential> r0 = com.google.firebase.auth.PhoneAuthCredential.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r0)
            com.google.firebase.auth.PhoneAuthCredential r0 = (com.google.firebase.auth.PhoneAuthCredential) r0
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x04e6
            goto L_0x04f8
        L_0x04e6:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x04f3
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x04f8
        L_0x04f3:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x04f8:
            r3.zza((java.lang.String) r4, (com.google.firebase.auth.PhoneAuthCredential) r0, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x04fe:
            android.os.Parcelable$Creator<com.google.firebase.auth.PhoneAuthCredential> r4 = com.google.firebase.auth.PhoneAuthCredential.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.firebase.auth.PhoneAuthCredential r4 = (com.google.firebase.auth.PhoneAuthCredential) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x050d
            goto L_0x051f
        L_0x050d:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x051a
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x051f
        L_0x051a:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x051f:
            r3.zza((com.google.firebase.auth.PhoneAuthCredential) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0525:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdj> r4 = com.google.android.gms.internal.firebase_auth.zzdj.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdj r4 = (com.google.android.gms.internal.firebase_auth.zzdj) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0534
            goto L_0x0546
        L_0x0534:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0541
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0546
        L_0x0541:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0546:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdj) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x054c:
            java.lang.String r4 = r5.readString()
            java.lang.String r0 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x055b
            goto L_0x056d
        L_0x055b:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x0568
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x056d
        L_0x0568:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x056d:
            r3.zzf(r4, r0, r7)
            goto L_0x0859
        L_0x0573:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x057e
            goto L_0x0590
        L_0x057e:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x058b
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0590
        L_0x058b:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0590:
            r3.zzj(r4, r7)
            goto L_0x0859
        L_0x0596:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x05a1
            goto L_0x05b3
        L_0x05a1:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x05ae
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x05b3
        L_0x05ae:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x05b3:
            r3.zzi(r4, r7)
            goto L_0x0859
        L_0x05b9:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x05c4
            goto L_0x05d6
        L_0x05c4:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x05d1
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x05d6
        L_0x05d1:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x05d6:
            r3.zzh(r4, r7)
            goto L_0x0859
        L_0x05dc:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x05e7
            goto L_0x05f9
        L_0x05e7:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x05f4
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x05f9
        L_0x05f4:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x05f9:
            r3.zzg(r4, r7)
            goto L_0x0859
        L_0x05ff:
            android.os.IBinder r4 = r5.readStrongBinder()
            if (r4 != 0) goto L_0x0606
            goto L_0x0619
        L_0x0606:
            java.lang.String r5 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r5 = r4.queryLocalInterface(r5)
            boolean r7 = r5 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r7 == 0) goto L_0x0614
            r7 = r5
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0619
        L_0x0614:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r4)
        L_0x0619:
            r3.zza(r7)
            goto L_0x0859
        L_0x061f:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x062a
            goto L_0x063c
        L_0x062a:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0637
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x063c
        L_0x0637:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x063c:
            r3.zzf(r4, r7)
            goto L_0x0859
        L_0x0642:
            java.lang.String r4 = r5.readString()
            java.lang.String r0 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0651
            goto L_0x0663
        L_0x0651:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x065e
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0663
        L_0x065e:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0663:
            r3.zze(r4, r0, r7)
            goto L_0x0859
        L_0x0669:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0674
            goto L_0x0686
        L_0x0674:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x0681
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0686
        L_0x0681:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0686:
            r3.zze(r4, r7)
            goto L_0x0859
        L_0x068c:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdr> r0 = com.google.android.gms.internal.firebase_auth.zzdr.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r0)
            com.google.android.gms.internal.firebase_auth.zzdr r0 = (com.google.android.gms.internal.firebase_auth.zzdr) r0
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x069f
            goto L_0x06b1
        L_0x069f:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x06ac
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x06b1
        L_0x06ac:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x06b1:
            r3.zza((java.lang.String) r4, (com.google.android.gms.internal.firebase_auth.zzdr) r0, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x06b7:
            java.lang.String r4 = r5.readString()
            java.lang.String r0 = r5.readString()
            java.lang.String r1 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x06ca
            goto L_0x06dc
        L_0x06ca:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r2 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r2 == 0) goto L_0x06d7
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x06dc
        L_0x06d7:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x06dc:
            r3.zza(r4, r0, r1, r7)
            goto L_0x0859
        L_0x06e2:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x06ed
            goto L_0x06ff
        L_0x06ed:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x06fa
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x06ff
        L_0x06fa:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x06ff:
            r3.zzd(r4, r7)
            goto L_0x0859
        L_0x0705:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0710
            goto L_0x0722
        L_0x0710:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x071d
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0722
        L_0x071d:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0722:
            r3.zzc(r4, r7)
            goto L_0x0859
        L_0x0728:
            java.lang.String r4 = r5.readString()
            java.lang.String r0 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0737
            goto L_0x0749
        L_0x0737:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x0744
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0749
        L_0x0744:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0749:
            r3.zzd(r4, r0, r7)
            goto L_0x0859
        L_0x074f:
            java.lang.String r4 = r5.readString()
            java.lang.String r0 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x075e
            goto L_0x0770
        L_0x075e:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x076b
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0770
        L_0x076b:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0770:
            r3.zzc((java.lang.String) r4, (java.lang.String) r0, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0776:
            java.lang.String r4 = r5.readString()
            java.lang.String r0 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0785
            goto L_0x0797
        L_0x0785:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x0792
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0797
        L_0x0792:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0797:
            r3.zzb((java.lang.String) r4, (java.lang.String) r0, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x079d:
            java.lang.String r4 = r5.readString()
            java.lang.String r0 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x07ac
            goto L_0x07be
        L_0x07ac:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x07b9
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x07be
        L_0x07b9:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x07be:
            r3.zza((java.lang.String) r4, (java.lang.String) r0, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x07c4:
            java.lang.String r4 = r5.readString()
            android.os.Parcelable$Creator<com.google.firebase.auth.UserProfileChangeRequest> r0 = com.google.firebase.auth.UserProfileChangeRequest.CREATOR
            android.os.Parcelable r0 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r0)
            com.google.firebase.auth.UserProfileChangeRequest r0 = (com.google.firebase.auth.UserProfileChangeRequest) r0
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x07d7
            goto L_0x07e9
        L_0x07d7:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r1 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r1 == 0) goto L_0x07e4
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x07e9
        L_0x07e4:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x07e9:
            r3.zza((java.lang.String) r4, (com.google.firebase.auth.UserProfileChangeRequest) r0, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x07ef:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdr> r4 = com.google.android.gms.internal.firebase_auth.zzdr.CREATOR
            android.os.Parcelable r4 = com.google.android.gms.internal.firebase_auth.zzc.zza((android.os.Parcel) r5, r4)
            com.google.android.gms.internal.firebase_auth.zzdr r4 = (com.google.android.gms.internal.firebase_auth.zzdr) r4
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x07fe
            goto L_0x0810
        L_0x07fe:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x080b
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0810
        L_0x080b:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0810:
            r3.zza((com.google.android.gms.internal.firebase_auth.zzdr) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
            goto L_0x0859
        L_0x0815:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0820
            goto L_0x0832
        L_0x0820:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x082d
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0832
        L_0x082d:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0832:
            r3.zzb(r4, r7)
            goto L_0x0859
        L_0x0837:
            java.lang.String r4 = r5.readString()
            android.os.IBinder r5 = r5.readStrongBinder()
            if (r5 != 0) goto L_0x0842
            goto L_0x0854
        L_0x0842:
            java.lang.String r7 = "com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks"
            android.os.IInterface r7 = r5.queryLocalInterface(r7)
            boolean r0 = r7 instanceof com.google.firebase.auth.api.internal.zzdx
            if (r0 == 0) goto L_0x084f
            com.google.firebase.auth.api.internal.zzdx r7 = (com.google.firebase.auth.api.internal.zzdx) r7
            goto L_0x0854
        L_0x084f:
            com.google.firebase.auth.api.internal.zzdz r7 = new com.google.firebase.auth.api.internal.zzdz
            r7.<init>(r5)
        L_0x0854:
            r3.zza((java.lang.String) r4, (com.google.firebase.auth.api.internal.zzdx) r7)
        L_0x0859:
            r6.writeNoException()
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.api.internal.zzeb.dispatchTransaction(int, android.os.Parcel, android.os.Parcel, int):boolean");
    }
}
