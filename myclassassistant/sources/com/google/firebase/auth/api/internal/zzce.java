package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.firebase_auth.zze;
import com.google.firebase.auth.internal.zza;

@VisibleForTesting
final class zzce extends zzeo<Void, zza> {
    public zzce() {
        super(2);
    }

    public final String zzda() {
        return "reload";
    }

    public final TaskApiCall<zzdq, Void> zzdb() {
        Feature[] featureArr;
        TaskApiCall.Builder autoResolveMissingFeatures = TaskApiCall.builder().setAutoResolveMissingFeatures(false);
        if (this.zznr) {
            featureArr = null;
        } else {
            featureArr = new Feature[]{zze.zzf};
        }
        return autoResolveMissingFeatures.setFeatures(featureArr).run(new zzcf(this)).build();
    }

    public final void zzdd() {
        ((zza) this.zzne).zza(this.zznk, zzao.zza(this.zzgm, this.zznl));
        zzc(null);
    }
}
