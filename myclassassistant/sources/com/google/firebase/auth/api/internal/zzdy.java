package com.google.firebase.auth.api.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.firebase_auth.zzb;
import com.google.android.gms.internal.firebase_auth.zzc;
import com.google.android.gms.internal.firebase_auth.zzcg;
import com.google.android.gms.internal.firebase_auth.zzcj;
import com.google.android.gms.internal.firebase_auth.zzct;
import com.google.android.gms.internal.firebase_auth.zzcz;
import com.google.android.gms.internal.firebase_auth.zzdg;
import com.google.firebase.auth.PhoneAuthCredential;

public abstract class zzdy extends zzb implements zzdx {
    public zzdy() {
        super("com.google.firebase.auth.api.internal.IFirebaseAuthCallbacks");
    }

    /* access modifiers changed from: protected */
    public final boolean dispatchTransaction(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzb((zzcz) zzc.zza(parcel, zzcz.CREATOR));
                return true;
            case 2:
                zza((zzcz) zzc.zza(parcel, zzcz.CREATOR), (zzct) zzc.zza(parcel, zzct.CREATOR));
                return true;
            case 3:
                zza((zzcj) zzc.zza(parcel, zzcj.CREATOR));
                return true;
            case 4:
                zza((zzdg) zzc.zza(parcel, zzdg.CREATOR));
                return true;
            case 5:
                onFailure((Status) zzc.zza(parcel, Status.CREATOR));
                return true;
            case 6:
                zzde();
                return true;
            case 7:
                zzdf();
                return true;
            case 8:
                zzbs(parcel.readString());
                return true;
            case 9:
                zzbt(parcel.readString());
                return true;
            case 10:
                onVerificationCompleted((PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 11:
                zzbu(parcel.readString());
                return true;
            case 12:
                zza((Status) zzc.zza(parcel, Status.CREATOR), (PhoneAuthCredential) zzc.zza(parcel, PhoneAuthCredential.CREATOR));
                return true;
            case 13:
                zzdg();
                return true;
            case 14:
                zza((zzcg) zzc.zza(parcel, zzcg.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
