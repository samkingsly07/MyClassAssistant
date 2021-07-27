package com.google.firebase.auth.internal;

import com.google.android.gms.common.api.internal.BackgroundDetector;

final class zzaf implements BackgroundDetector.BackgroundStateChangeListener {
    private final /* synthetic */ zzae zzsc;

    zzaf(zzae zzae) {
        this.zzsc = zzae;
    }

    public final void onBackgroundStateChanged(boolean z) {
        if (z) {
            boolean unused = this.zzsc.zzsb = true;
            this.zzsc.cancel();
            return;
        }
        boolean unused2 = this.zzsc.zzsb = false;
        if (this.zzsc.zzep()) {
            this.zzsc.zzsa.zzeh();
        }
    }
}
