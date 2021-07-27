package com.google.android.gms.internal.firebase_auth;

import android.os.Parcelable;

public final class zzcu implements Parcelable.Creator<zzct> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzct[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r22) {
        /*
            r21 = this;
            r0 = r22
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r22)
            r2 = 0
            r4 = 0
            r5 = 0
            r15 = r2
            r17 = r15
            r7 = r5
            r8 = r7
            r10 = r8
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r20 = r14
            r9 = 0
            r19 = 0
        L_0x0025:
            int r2 = r22.dataPosition()
            if (r2 >= r1) goto L_0x008b
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r22)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 2: goto L_0x0085;
                case 3: goto L_0x007f;
                case 4: goto L_0x0079;
                case 5: goto L_0x0073;
                case 6: goto L_0x006d;
                case 7: goto L_0x0063;
                case 8: goto L_0x005d;
                case 9: goto L_0x0057;
                case 10: goto L_0x0051;
                case 11: goto L_0x004b;
                case 12: goto L_0x0045;
                case 13: goto L_0x003a;
                default: goto L_0x0036;
            }
        L_0x0036:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x0025
        L_0x003a:
            android.os.Parcelable$Creator<com.google.firebase.auth.zzd> r3 = com.google.firebase.auth.zzd.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r20 = r2
            com.google.firebase.auth.zzd r20 = (com.google.firebase.auth.zzd) r20
            goto L_0x0025
        L_0x0045:
            boolean r19 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0025
        L_0x004b:
            long r17 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0025
        L_0x0051:
            long r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readLong(r0, r2)
            goto L_0x0025
        L_0x0057:
            java.lang.String r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0025
        L_0x005d:
            java.lang.String r13 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0025
        L_0x0063:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdd> r3 = com.google.android.gms.internal.firebase_auth.zzdd.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r12 = r2
            com.google.android.gms.internal.firebase_auth.zzdd r12 = (com.google.android.gms.internal.firebase_auth.zzdd) r12
            goto L_0x0025
        L_0x006d:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0025
        L_0x0073:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0025
        L_0x0079:
            boolean r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x0025
        L_0x007f:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0025
        L_0x0085:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x0025
        L_0x008b:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.internal.firebase_auth.zzct r0 = new com.google.android.gms.internal.firebase_auth.zzct
            r6 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r17, r19, r20)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzcu.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
