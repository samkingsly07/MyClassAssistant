package com.google.android.gms.common.data;

import android.os.Parcelable;

public final class zac implements Parcelable.Creator<DataHolder> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new DataHolder[i];
    }

    /* JADX WARNING: type inference failed for: r1v3, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r10) {
        /*
            r9 = this;
            int r0 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r10)
            r1 = 0
            r2 = 0
            r5 = r2
            r6 = r5
            r8 = r6
            r4 = 0
            r7 = 0
        L_0x0011:
            int r1 = r10.dataPosition()
            if (r1 >= r0) goto L_0x004c
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r10)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            r3 = 1000(0x3e8, float:1.401E-42)
            if (r2 == r3) goto L_0x0046
            switch(r2) {
                case 1: goto L_0x0040;
                case 2: goto L_0x0036;
                case 3: goto L_0x0030;
                case 4: goto L_0x002a;
                default: goto L_0x0026;
            }
        L_0x0026:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r10, r1)
            goto L_0x0011
        L_0x002a:
            android.os.Bundle r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createBundle(r10, r1)
            goto L_0x0011
        L_0x0030:
            int r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r10, r1)
            goto L_0x0011
        L_0x0036:
            android.os.Parcelable$Creator r2 = android.database.CursorWindow.CREATOR
            java.lang.Object[] r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedArray(r10, r1, r2)
            r6 = r1
            android.database.CursorWindow[] r6 = (android.database.CursorWindow[]) r6
            goto L_0x0011
        L_0x0040:
            java.lang.String[] r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringArray(r10, r1)
            goto L_0x0011
        L_0x0046:
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r10, r1)
            goto L_0x0011
        L_0x004c:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r10, r0)
            com.google.android.gms.common.data.DataHolder r10 = new com.google.android.gms.common.data.DataHolder
            r3 = r10
            r3.<init>((int) r4, (java.lang.String[]) r5, (android.database.CursorWindow[]) r6, (int) r7, (android.os.Bundle) r8)
            r10.zaca()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.zac.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
