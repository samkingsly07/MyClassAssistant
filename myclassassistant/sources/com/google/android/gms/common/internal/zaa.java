package com.google.android.gms.common.internal;

import android.os.Parcelable;

public final class zaa implements Parcelable.Creator<AuthAccountRequest> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new AuthAccountRequest[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r1v4, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r11) {
        /*
            r10 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r11)
            r1 = 0
            r2 = 0
            r5 = r1
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r4 = 0
        L_0x0013:
            int r1 = r11.dataPosition()
            if (r1 >= r0) goto L_0x0054
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r11)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x004e;
                case 2: goto L_0x0048;
                case 3: goto L_0x003e;
                case 4: goto L_0x0038;
                case 5: goto L_0x0032;
                case 6: goto L_0x0028;
                default: goto L_0x0024;
            }
        L_0x0024:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r11, r1)
            goto L_0x0013
        L_0x0028:
            android.os.Parcelable$Creator r2 = android.accounts.Account.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r11, r1, r2)
            r9 = r1
            android.accounts.Account r9 = (android.accounts.Account) r9
            goto L_0x0013
        L_0x0032:
            java.lang.Integer r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIntegerObject(r11, r1)
            goto L_0x0013
        L_0x0038:
            java.lang.Integer r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIntegerObject(r11, r1)
            goto L_0x0013
        L_0x003e:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r2 = com.google.android.gms.common.api.Scope.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r11, r1, r2)
            r6 = r1
            com.google.android.gms.common.api.Scope[] r6 = (com.google.android.gms.common.api.Scope[]) r6
            goto L_0x0013
        L_0x0048:
            android.os.IBinder r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r11, r1)
            goto L_0x0013
        L_0x004e:
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r11, r1)
            goto L_0x0013
        L_0x0054:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r11, r0)
            com.google.android.gms.common.internal.AuthAccountRequest r11 = new com.google.android.gms.common.internal.AuthAccountRequest
            r3 = r11
            r3.<init>(r4, r5, r6, r7, r8, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zaa.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
