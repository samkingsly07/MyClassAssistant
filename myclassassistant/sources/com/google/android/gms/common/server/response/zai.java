package com.google.android.gms.common.server.response;

import android.os.Parcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;

public final class zai implements Parcelable.Creator<FastJsonResponse.Field> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new FastJsonResponse.Field[i];
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
            r9 = r1
            r11 = r9
            r12 = r11
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
        L_0x0019:
            int r1 = r14.dataPosition()
            if (r1 >= r0) goto L_0x0068
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r14)
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r1)
            switch(r2) {
                case 1: goto L_0x0062;
                case 2: goto L_0x005c;
                case 3: goto L_0x0056;
                case 4: goto L_0x0050;
                case 5: goto L_0x004a;
                case 6: goto L_0x0044;
                case 7: goto L_0x003e;
                case 8: goto L_0x0038;
                case 9: goto L_0x002e;
                default: goto L_0x002a;
            }
        L_0x002a:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r14, r1)
            goto L_0x0019
        L_0x002e:
            android.os.Parcelable$Creator<com.google.android.gms.common.server.converter.zaa> r2 = com.google.android.gms.common.server.converter.zaa.CREATOR
            android.os.Parcelable r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r14, r1, r2)
            r12 = r1
            com.google.android.gms.common.server.converter.zaa r12 = (com.google.android.gms.common.server.converter.zaa) r12
            goto L_0x0019
        L_0x0038:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x0019
        L_0x003e:
            int r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x0019
        L_0x0044:
            java.lang.String r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r14, r1)
            goto L_0x0019
        L_0x004a:
            boolean r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r14, r1)
            goto L_0x0019
        L_0x0050:
            int r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x0019
        L_0x0056:
            boolean r6 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r14, r1)
            goto L_0x0019
        L_0x005c:
            int r5 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x0019
        L_0x0062:
            int r4 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readInt(r14, r1)
            goto L_0x0019
        L_0x0068:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r14, r0)
            com.google.android.gms.common.server.response.FastJsonResponse$Field r14 = new com.google.android.gms.common.server.response.FastJsonResponse$Field
            r3 = r14
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.zai.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
