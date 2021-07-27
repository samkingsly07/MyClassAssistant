package com.google.android.gms.internal.firebase_auth;

import java.util.Collections;
import java.util.List;

final class zzgn extends zzgl {
    private static final Class<?> zzyw = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzgn() {
        super();
    }

    /* access modifiers changed from: package-private */
    public final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Object obj, long j) {
        Object obj2;
        List list = (List) zziv.zzp(obj, j);
        if (list instanceof zzgk) {
            obj2 = ((zzgk) list).zzic();
        } else if (!zzyw.isAssignableFrom(list.getClass())) {
            if (!(list instanceof zzhm) || !(list instanceof zzga)) {
                obj2 = Collections.unmodifiableList(list);
            } else {
                zzga zzga = (zzga) list;
                if (zzga.zzeu()) {
                    zzga.zzev();
                    return;
                }
                return;
            }
        } else {
            return;
        }
        zziv.zza(obj, j, obj2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.google.android.gms.internal.firebase_auth.zzgj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.google.android.gms.internal.firebase_auth.zzgj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: com.google.android.gms.internal.firebase_auth.zzgj} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static <L> java.util.List<L> zza(java.lang.Object r3, long r4, int r6) {
        /*
            java.util.List r0 = zzc(r3, r4)
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x002d
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_auth.zzgk
            if (r1 == 0) goto L_0x0014
            com.google.android.gms.internal.firebase_auth.zzgj r0 = new com.google.android.gms.internal.firebase_auth.zzgj
            r0.<init>((int) r6)
            goto L_0x0029
        L_0x0014:
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_auth.zzhm
            if (r1 == 0) goto L_0x0024
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_auth.zzga
            if (r1 == 0) goto L_0x0024
            com.google.android.gms.internal.firebase_auth.zzga r0 = (com.google.android.gms.internal.firebase_auth.zzga) r0
            com.google.android.gms.internal.firebase_auth.zzga r6 = r0.zzj(r6)
            r0 = r6
            goto L_0x0029
        L_0x0024:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r6)
        L_0x0029:
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
            goto L_0x0082
        L_0x002d:
            java.lang.Class<?> r1 = zzyw
            java.lang.Class r2 = r0.getClass()
            boolean r1 = r1.isAssignableFrom(r2)
            if (r1 == 0) goto L_0x004d
            java.util.ArrayList r1 = new java.util.ArrayList
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>(r2)
            r1.addAll(r0)
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
        L_0x004b:
            r0 = r1
            goto L_0x0082
        L_0x004d:
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_auth.zzis
            if (r1 == 0) goto L_0x0065
            com.google.android.gms.internal.firebase_auth.zzgj r1 = new com.google.android.gms.internal.firebase_auth.zzgj
            int r2 = r0.size()
            int r2 = r2 + r6
            r1.<init>((int) r2)
            com.google.android.gms.internal.firebase_auth.zzis r0 = (com.google.android.gms.internal.firebase_auth.zzis) r0
            r1.addAll(r0)
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r1)
            goto L_0x004b
        L_0x0065:
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_auth.zzhm
            if (r1 == 0) goto L_0x0082
            boolean r1 = r0 instanceof com.google.android.gms.internal.firebase_auth.zzga
            if (r1 == 0) goto L_0x0082
            r1 = r0
            com.google.android.gms.internal.firebase_auth.zzga r1 = (com.google.android.gms.internal.firebase_auth.zzga) r1
            boolean r2 = r1.zzeu()
            if (r2 != 0) goto L_0x0082
            int r0 = r0.size()
            int r0 = r0 + r6
            com.google.android.gms.internal.firebase_auth.zzga r0 = r1.zzj(r0)
            com.google.android.gms.internal.firebase_auth.zziv.zza((java.lang.Object) r3, (long) r4, (java.lang.Object) r0)
        L_0x0082:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzgn.zza(java.lang.Object, long, int):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final <E> void zza(Object obj, Object obj2, long j) {
        List zzc = zzc(obj2, j);
        List zza = zza(obj, j, zzc.size());
        int size = zza.size();
        int size2 = zzc.size();
        if (size > 0 && size2 > 0) {
            zza.addAll(zzc);
        }
        if (size > 0) {
            zzc = zza;
        }
        zziv.zza(obj, j, (Object) zzc);
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zziv.zzp(obj, j);
    }
}
