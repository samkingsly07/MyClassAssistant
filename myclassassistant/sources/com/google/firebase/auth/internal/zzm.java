package com.google.firebase.auth.internal;

import android.os.Parcelable;

public final class zzm implements Parcelable.Creator<zzl> {
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzl[i];
    }

    /* JADX WARNING: type inference failed for: r2v3, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v4, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v5, types: [android.os.Parcelable] */
    /* JADX WARNING: type inference failed for: r2v6, types: [android.os.Parcelable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object createFromParcel(android.os.Parcel r17) {
        /*
            r16 = this;
            r0 = r17
            int r1 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.validateObjectHeader(r17)
            r2 = 0
            r3 = 0
            r5 = r2
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
            r10 = r9
            r11 = r10
            r12 = r11
            r13 = r12
            r15 = r13
            r14 = 0
        L_0x001e:
            int r2 = r17.dataPosition()
            if (r2 >= r1) goto L_0x0086
            int r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readHeader(r17)
            int r3 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.getFieldId(r2)
            switch(r3) {
                case 1: goto L_0x007c;
                case 2: goto L_0x0072;
                case 3: goto L_0x006c;
                case 4: goto L_0x0066;
                case 5: goto L_0x005f;
                case 6: goto L_0x0059;
                case 7: goto L_0x0053;
                case 8: goto L_0x004d;
                case 9: goto L_0x0043;
                case 10: goto L_0x003d;
                case 11: goto L_0x0033;
                default: goto L_0x002f;
            }
        L_0x002f:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.skipUnknownField(r0, r2)
            goto L_0x001e
        L_0x0033:
            android.os.Parcelable$Creator<com.google.firebase.auth.zzd> r3 = com.google.firebase.auth.zzd.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r15 = r2
            com.google.firebase.auth.zzd r15 = (com.google.firebase.auth.zzd) r15
            goto L_0x001e
        L_0x003d:
            boolean r14 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBoolean(r0, r2)
            goto L_0x001e
        L_0x0043:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzn> r3 = com.google.firebase.auth.internal.zzn.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r13 = r2
            com.google.firebase.auth.internal.zzn r13 = (com.google.firebase.auth.internal.zzn) r13
            goto L_0x001e
        L_0x004d:
            java.lang.Boolean r12 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.readBooleanObject(r0, r2)
            goto L_0x001e
        L_0x0053:
            java.lang.String r11 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001e
        L_0x0059:
            java.util.ArrayList r10 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createStringList(r0, r2)
            goto L_0x001e
        L_0x005f:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzh> r3 = com.google.firebase.auth.internal.zzh.CREATOR
            java.util.ArrayList r9 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createTypedList(r0, r2, r3)
            goto L_0x001e
        L_0x0066:
            java.lang.String r8 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001e
        L_0x006c:
            java.lang.String r7 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createString(r0, r2)
            goto L_0x001e
        L_0x0072:
            android.os.Parcelable$Creator<com.google.firebase.auth.internal.zzh> r3 = com.google.firebase.auth.internal.zzh.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r6 = r2
            com.google.firebase.auth.internal.zzh r6 = (com.google.firebase.auth.internal.zzh) r6
            goto L_0x001e
        L_0x007c:
            android.os.Parcelable$Creator<com.google.android.gms.internal.firebase_auth.zzcz> r3 = com.google.android.gms.internal.firebase_auth.zzcz.CREATOR
            android.os.Parcelable r2 = com.google.android.gms.common.internal.safeparcel.SafeParcelReader.createParcelable(r0, r2, r3)
            r5 = r2
            com.google.android.gms.internal.firebase_auth.zzcz r5 = (com.google.android.gms.internal.firebase_auth.zzcz) r5
            goto L_0x001e
        L_0x0086:
            com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ensureAtEnd(r0, r1)
            com.google.firebase.auth.internal.zzl r0 = new com.google.firebase.auth.internal.zzl
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.auth.internal.zzm.createFromParcel(android.os.Parcel):java.lang.Object");
    }
}
