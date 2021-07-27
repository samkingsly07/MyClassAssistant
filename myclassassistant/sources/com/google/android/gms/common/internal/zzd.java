package com.google.android.gms.common.internal;

import android.os.Parcelable;

public final class zzd implements Parcelable.Creator<GetServiceRequest> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new GetServiceRequest[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [java.lang.Object[]] */
    /* JADX WARNING: type inference failed for: r2v6, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r17) {
        /*
            r16 = this;
            r0 = r17
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r17)
            r2 = 0
            r3 = 0
            r8 = r3
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r14 = r13
            r5 = 0
            r6 = 0
            r7 = 0
            r15 = 0
        L_0x001e:
            int r2 = r17.dataPosition()
            if (r2 >= r1) goto L_0x0085
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r17)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x007f;
                case 2: goto L_0x0079;
                case 3: goto L_0x0073;
                case 4: goto L_0x006d;
                case 5: goto L_0x0067;
                case 6: goto L_0x005d;
                case 7: goto L_0x0057;
                case 8: goto L_0x004d;
                case 9: goto L_0x002f;
                case 10: goto L_0x0043;
                case 11: goto L_0x0039;
                case 12: goto L_0x0033;
                default: goto L_0x002f;
            }
        L_0x002f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x001e
        L_0x0033:
            boolean r15 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001e
        L_0x0039:
            android.os.Parcelable$Creator<com.google.android.gms.common.Feature> r3 = com.google.android.gms.common.Feature.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r0, r2, r3)
            r14 = r2
            com.google.android.gms.common.Feature[] r14 = (com.google.android.gms.common.Feature[]) r14
            goto L_0x001e
        L_0x0043:
            android.os.Parcelable$Creator<com.google.android.gms.common.Feature> r3 = com.google.android.gms.common.Feature.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r0, r2, r3)
            r13 = r2
            com.google.android.gms.common.Feature[] r13 = (com.google.android.gms.common.Feature[]) r13
            goto L_0x001e
        L_0x004d:
            android.os.Parcelable$Creator r3 = android.accounts.Account.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r12 = r2
            android.accounts.Account r12 = (android.accounts.Account) r12
            goto L_0x001e
        L_0x0057:
            android.os.Bundle r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r0, r2)
            goto L_0x001e
        L_0x005d:
            android.os.Parcelable$Creator<com.google.android.gms.common.api.Scope> r3 = com.google.android.gms.common.api.Scope.CREATOR
            java.lang.Object[] r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r0, r2, r3)
            r10 = r2
            com.google.android.gms.common.api.Scope[] r10 = (com.google.android.gms.common.api.Scope[]) r10
            goto L_0x001e
        L_0x0067:
            android.os.IBinder r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readIBinder(r0, r2)
            goto L_0x001e
        L_0x006d:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001e
        L_0x0073:
            int r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001e
        L_0x0079:
            int r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001e
        L_0x007f:
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r0, r2)
            goto L_0x001e
        L_0x0085:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.android.gms.common.internal.GetServiceRequest r0 = new com.google.android.gms.common.internal.GetServiceRequest
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.internal.zzd.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
