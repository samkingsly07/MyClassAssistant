package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs;
import java.io.IOException;
import java.util.Map;

final class zzfh extends zzfg<Object> {
    zzfh() {
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf(zzhb zzhb) {
        return zzhb instanceof zzfs.zzc;
    }

    /* access modifiers changed from: package-private */
    public final zzfj<Object> zzd(Object obj) {
        return ((zzfs.zzc) obj).zzxe;
    }

    /* access modifiers changed from: package-private */
    public final void zza(Object obj, zzfj<Object> zzfj) {
        ((zzfs.zzc) obj).zzxe = zzfj;
    }

    /* access modifiers changed from: package-private */
    public final zzfj<Object> zze(Object obj) {
        zzfj<Object> zzd = zzd(obj);
        if (!zzd.isImmutable()) {
            return zzd;
        }
        zzfj<Object> zzfj = (zzfj) zzd.clone();
        zza(obj, zzfj);
        return zzfj;
    }

    /* access modifiers changed from: package-private */
    public final void zzf(Object obj) {
        zzd(obj).zzev();
    }

    /* access modifiers changed from: package-private */
    public final <UT, UB> UB zza(zzhq zzhq, Object obj, zzff zzff, zzfj<Object> zzfj, UB ub, zzip<UT, UB> zzip) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final int zza(Map.Entry<?, ?> entry) {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzjk zzjk, Map.Entry<?, ?> entry) throws IOException {
        entry.getKey();
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final Object zza(zzff zzff, zzhb zzhb, int i) {
        return zzff.zza(zzhb, i);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzhq zzhq, Object obj, zzff zzff, zzfj<Object> zzfj) throws IOException {
        throw new NoSuchMethodError();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeh zzeh, Object obj, zzff zzff, zzfj<Object> zzfj) throws IOException {
        throw new NoSuchMethodError();
    }
}
