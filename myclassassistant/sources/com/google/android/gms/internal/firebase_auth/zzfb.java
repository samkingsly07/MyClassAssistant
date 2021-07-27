package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs;
import java.io.IOException;
import java.util.List;
import java.util.Map;

final class zzfb implements zzjk {
    private final zzez zzsv;

    public static zzfb zza(zzez zzez) {
        if (zzez.zztq != null) {
            return zzez.zztq;
        }
        return new zzfb(zzez);
    }

    private zzfb(zzez zzez) {
        this.zzsv = (zzez) zzfu.zza(zzez, "output");
        this.zzsv.zztq = this;
    }

    public final int zzgk() {
        return zzfs.zze.zzxq;
    }

    public final void zzq(int i, int i2) throws IOException {
        this.zzsv.zzj(i, i2);
    }

    public final void zzi(int i, long j) throws IOException {
        this.zzsv.zza(i, j);
    }

    public final void zzj(int i, long j) throws IOException {
        this.zzsv.zzc(i, j);
    }

    public final void zza(int i, float f) throws IOException {
        this.zzsv.zza(i, f);
    }

    public final void zza(int i, double d) throws IOException {
        this.zzsv.zza(i, d);
    }

    public final void zzr(int i, int i2) throws IOException {
        this.zzsv.zzg(i, i2);
    }

    public final void zza(int i, long j) throws IOException {
        this.zzsv.zza(i, j);
    }

    public final void zzg(int i, int i2) throws IOException {
        this.zzsv.zzg(i, i2);
    }

    public final void zzc(int i, long j) throws IOException {
        this.zzsv.zzc(i, j);
    }

    public final void zzj(int i, int i2) throws IOException {
        this.zzsv.zzj(i, i2);
    }

    public final void zzb(int i, boolean z) throws IOException {
        this.zzsv.zzb(i, z);
    }

    public final void zza(int i, String str) throws IOException {
        this.zzsv.zza(i, str);
    }

    public final void zza(int i, zzeh zzeh) throws IOException {
        this.zzsv.zza(i, zzeh);
    }

    public final void zzh(int i, int i2) throws IOException {
        this.zzsv.zzh(i, i2);
    }

    public final void zzi(int i, int i2) throws IOException {
        this.zzsv.zzi(i, i2);
    }

    public final void zzb(int i, long j) throws IOException {
        this.zzsv.zzb(i, j);
    }

    public final void zza(int i, Object obj, zzhv zzhv) throws IOException {
        this.zzsv.zza(i, (zzhb) obj, zzhv);
    }

    public final void zzb(int i, Object obj, zzhv zzhv) throws IOException {
        zzez zzez = this.zzsv;
        zzez.zzf(i, 3);
        zzhv.zza((zzhb) obj, zzez.zztq);
        zzez.zzf(i, 4);
    }

    public final void zzao(int i) throws IOException {
        this.zzsv.zzf(i, 3);
    }

    public final void zzap(int i) throws IOException {
        this.zzsv.zzf(i, 4);
    }

    public final void zza(int i, Object obj) throws IOException {
        if (obj instanceof zzeh) {
            this.zzsv.zzb(i, (zzeh) obj);
        } else {
            this.zzsv.zza(i, (zzhb) obj);
        }
    }

    public final void zza(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzag(list.get(i4).intValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzab(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzb(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzaj(list.get(i4).intValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzae(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzj(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzc(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zze(list.get(i4).longValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzd(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzf(list.get(i4).longValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzb(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zza(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zze(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzh(list.get(i4).longValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzd(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzf(int i, List<Float> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzb(list.get(i4).floatValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zza(list.get(i2).floatValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zza(i, list.get(i2).floatValue());
            i2++;
        }
    }

    public final void zzg(int i, List<Double> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzb(list.get(i4).doubleValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zza(list.get(i2).doubleValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zza(i, list.get(i2).doubleValue());
            i2++;
        }
    }

    public final void zzh(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzal(list.get(i4).intValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzab(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzg(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzi(int i, List<Boolean> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzt(list.get(i4).booleanValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzs(list.get(i2).booleanValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzb(i, list.get(i2).booleanValue());
            i2++;
        }
    }

    public final void zza(int i, List<String> list) throws IOException {
        int i2 = 0;
        if (list instanceof zzgk) {
            zzgk zzgk = (zzgk) list;
            while (i2 < list.size()) {
                Object zzas = zzgk.zzas(i2);
                if (zzas instanceof String) {
                    this.zzsv.zza(i, (String) zzas);
                } else {
                    this.zzsv.zza(i, (zzeh) zzas);
                }
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zza(i, list.get(i2));
            i2++;
        }
    }

    public final void zzb(int i, List<zzeh> list) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.zzsv.zza(i, list.get(i2));
        }
    }

    public final void zzj(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzah(list.get(i4).intValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzac(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzh(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzk(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzak(list.get(i4).intValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzae(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzj(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzl(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzi(list.get(i4).longValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzd(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzc(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zzm(int i, List<Integer> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzai(list.get(i4).intValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzad(list.get(i2).intValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzi(i, list.get(i2).intValue());
            i2++;
        }
    }

    public final void zzn(int i, List<Long> list, boolean z) throws IOException {
        int i2 = 0;
        if (z) {
            this.zzsv.zzf(i, 2);
            int i3 = 0;
            for (int i4 = 0; i4 < list.size(); i4++) {
                i3 += zzez.zzg(list.get(i4).longValue());
            }
            this.zzsv.zzac(i3);
            while (i2 < list.size()) {
                this.zzsv.zzc(list.get(i2).longValue());
                i2++;
            }
            return;
        }
        while (i2 < list.size()) {
            this.zzsv.zzb(i, list.get(i2).longValue());
            i2++;
        }
    }

    public final void zza(int i, List<?> list, zzhv zzhv) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zza(i, (Object) list.get(i2), zzhv);
        }
    }

    public final void zzb(int i, List<?> list, zzhv zzhv) throws IOException {
        for (int i2 = 0; i2 < list.size(); i2++) {
            zzb(i, (Object) list.get(i2), zzhv);
        }
    }

    public final <K, V> void zza(int i, zzgu<K, V> zzgu, Map<K, V> map) throws IOException {
        for (Map.Entry next : map.entrySet()) {
            this.zzsv.zzf(i, 2);
            this.zzsv.zzac(zzgt.zza(zzgu, next.getKey(), next.getValue()));
            zzgt.zza(this.zzsv, zzgu, next.getKey(), next.getValue());
        }
    }
}
