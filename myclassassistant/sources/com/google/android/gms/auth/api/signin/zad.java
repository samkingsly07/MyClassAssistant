package com.google.android.gms.auth.api.signin;

import android.os.Parcelable;

public final class zad implements Parcelable.Creator<GoogleSignInOptions> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new GoogleSignInOptions[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r14) {
        /*
            r13 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r14)
            r1 = 0
            r2 = 0
            r5 = r2
            r6 = r5
            r10 = r6
            r11 = r10
            r12 = r11
            r4 = 0
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0019:
            int r1 = r14.dataPosition()
            if (r1 >= r0) goto L_0x006a
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r14)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x0064;
                case 2: goto L_0x005d;
                case 3: goto L_0x0053;
                case 4: goto L_0x004d;
                case 5: goto L_0x0047;
                case 6: goto L_0x0041;
                case 7: goto L_0x003b;
                case 8: goto L_0x0035;
                case 9: goto L_0x002e;
                default: goto L_0x002a;
            }
        L_0x002a:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r14, r1)
            goto L_0x0019
        L_0x002e:
            android.os.Parcelable$Creator<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable> r2 = com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable.CREATOR
            java.util.ArrayList r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r14, r1, r2)
            goto L_0x0019
        L_0x0035:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x0019
        L_0x003b:
            java.lang.String r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x0019
        L_0x0041:
            boolean r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r14, r1)
            goto L_0x0019
        L_0x0047:
            boolean r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r14, r1)
            goto L_0x0019
        L_0x004d:
            boolean r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r14, r1)
            goto L_0x0019
        L_0x0053:
            android.os.Parcelable$Creator r2 = android.accounts.Account.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r2)
            r6 = r1
            android.accounts.Account r6 = (android.accounts.Account) r6
            goto L_0x0019
        L_0x005d:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r2 = com.google.android.gms.common.api.Scope.CREATOR
            java.util.ArrayList r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r14, r1, r2)
            goto L_0x0019
        L_0x0064:
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x0019
        L_0x006a:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r14, r0)
            com.google.android.gms.auth.api.signin.GoogleSignInOptions r14 = new com.google.android.gms.auth.api.signin.GoogleSignInOptions
            r3 = r14
            r3.<init>((int) r4, (java.util.ArrayList<com.google.android.gms.common.api.Scope>) r5, (android.accounts.Account) r6, (boolean) r7, (boolean) r8, (boolean) r9, (java.lang.String) r10, (java.lang.String) r11, (java.util.ArrayList<com.google.android.gms.auth.api.signin.internal.GoogleSignInOptionsExtensionParcelable>) r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.auth.api.signin.zad.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
