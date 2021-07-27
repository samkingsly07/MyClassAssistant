package com.google.firebase.auth.api.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.AnyClient;
import com.google.android.gms.common.api.internal.TaskApiCall;

public interface zzam<A extends Api.AnyClient, ResultT> {
    String zzda();

    TaskApiCall<A, ResultT> zzdb();

    zzam<A, ResultT> zzdc();
}
