package com.google.firebase.auth;

import android.os.Parcelable;

public final class zze implements Parcelable.Creator<zzd> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzd[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r9) {
        /*
            r8 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r9)
            r1 = 0
            r3 = r1
            r4 = r3
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x0010:
            int r1 = r9.dataPosition()
            if (r1 >= r0) goto L_0x0047
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r9)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x0041;
                case 2: goto L_0x003b;
                case 3: goto L_0x0035;
                case 4: goto L_0x002b;
                case 5: goto L_0x0025;
                default: goto L_0x0021;
            }
        L_0x0021:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r9, r1)
            goto L_0x0010
        L_0x0025:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r9, r1)
            goto L_0x0010
        L_0x002b:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzdr> r2 = com.google.android.gms.internal.firebase_auth.zzdr.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r9, r1, r2)
            r6 = r1
            com.google.android.gms.internal.firebase_auth.zzdr r6 = (com.google.android.gms.internal.firebase_auth.zzdr) r6
            goto L_0x0010
        L_0x0035:
            java.lang.String r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r9, r1)
            goto L_0x0010
        L_0x003b:
            java.lang.String r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r9, r1)
            goto L_0x0010
        L_0x0041:
            java.lang.String r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r9, r1)
            goto L_0x0010
        L_0x0047:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r9, r0)
            com.google.firebase.auth.zzd r9 = new com.google.firebase.auth.zzd
            r2 = r9
            r2.<init>(r3, r4, r5, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.zze.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
