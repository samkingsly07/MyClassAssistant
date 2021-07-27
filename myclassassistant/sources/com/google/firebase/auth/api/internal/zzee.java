package com.google.firebase.auth.api.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.internal.ClientSettings;

final class zzee extends Api.AbstractClientBuilder<zzdq, zzef> {
    zzee() {
    }

    public final /* synthetic */ Api.Client buildClient(Context context, Looper looper, ClientSettings clientSettings, Object obj, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new zzdr(context, looper, clientSettings, (zzef) obj, connectionCallbacks, onConnectionFailedListener);
    }
}
