package com.google.android.gms.common.internal;

import android.app.PendingIntent;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.IAccountAccessor;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "ResolveAccountResponseCreator")
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new zan();
    @SafeParcelable.Field(getter = "getConnectionResult", mo10718id = 3)
    private ConnectionResult zadh;
    @SafeParcelable.Field(getter = "getSaveDefaultAccount", mo10718id = 4)
    private boolean zagf;
    @SafeParcelable.VersionField(mo10724id = 1)
    private final int zale;
    @SafeParcelable.Field(mo10718id = 2)
    private IBinder zanw;
    @SafeParcelable.Field(getter = "isFromCrossClientAuth", mo10718id = 5)
    private boolean zapb;

    @SafeParcelable.Constructor
    ResolveAccountResponse(@SafeParcelable.Param(mo10721id = 1) int i, @SafeParcelable.Param(mo10721id = 2) IBinder iBinder, @SafeParcelable.Param(mo10721id = 3) ConnectionResult connectionResult, @SafeParcelable.Param(mo10721id = 4) boolean z, @SafeParcelable.Param(mo10721id = 5) boolean z2) {
        this.zale = i;
        this.zanw = iBinder;
        this.zadh = connectionResult;
        this.zagf = z;
        this.zapb = z2;
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, (IBinder) null, connectionResult, false, false);
    }

    public ResolveAccountResponse(int i) {
        this(new ConnectionResult(i, (PendingIntent) null));
    }

    public IAccountAccessor getAccountAccessor() {
        return IAccountAccessor.Stub.asInterface(this.zanw);
    }

    public ResolveAccountResponse setAccountAccessor(IAccountAccessor iAccountAccessor) {
        this.zanw = iAccountAccessor == null ? null : iAccountAccessor.asBinder();
        return this;
    }

    public ConnectionResult getConnectionResult() {
        return this.zadh;
    }

    public boolean getSaveDefaultAccount() {
        return this.zagf;
    }

    public ResolveAccountResponse setSaveDefaultAccount(boolean z) {
        this.zagf = z;
        return this;
    }

    public boolean isFromCrossClientAuth() {
        return this.zapb;
    }

    public ResolveAccountResponse setIsFromCrossClientAuth(boolean z) {
        this.zapb = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zale);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zanw, false);
        SafeParcelWriter.writeParcelable(parcel, 3, getConnectionResult(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 4, getSaveDefaultAccount());
        SafeParcelWriter.writeBoolean(parcel, 5, isFromCrossClientAuth());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        if (!this.zadh.equals(resolveAccountResponse.zadh) || !getAccountAccessor().equals(resolveAccountResponse.getAccountAccessor())) {
            return false;
        }
        return true;
    }
}
