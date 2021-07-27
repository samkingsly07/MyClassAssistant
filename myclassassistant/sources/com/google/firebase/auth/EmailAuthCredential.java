package com.google.firebase.auth;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.logging.Logger;

@SafeParcelable.Class(creator = "EmailAuthCredentialCreator")
public class EmailAuthCredential extends AuthCredential {
    public static final Parcelable.Creator<EmailAuthCredential> CREATOR = new zzf();
    private static final Logger zzgg = new Logger("EmailAuthCredential", new String[0]);
    @SafeParcelable.Field(getter = "getEmail", mo10718id = 1)
    private String zzgh;
    @SafeParcelable.Field(getter = "getPassword", mo10718id = 2)
    private String zzgi;
    @SafeParcelable.Field(getter = "getSignInLink", mo10718id = 3)
    private final String zzgj;
    @SafeParcelable.Field(getter = "getCachedState", mo10718id = 4)
    private String zzgk;
    @SafeParcelable.Field(getter = "isForLinking", mo10718id = 5)
    private boolean zzgl;

    @SafeParcelable.Constructor
    EmailAuthCredential(@SafeParcelable.Param(mo10721id = 1) @NonNull String str, @SafeParcelable.Param(mo10721id = 2) @NonNull String str2, @SafeParcelable.Param(mo10721id = 3) @NonNull String str3, @SafeParcelable.Param(mo10721id = 4) @NonNull String str4, @SafeParcelable.Param(mo10721id = 5) @NonNull boolean z) {
        this.zzgh = Preconditions.checkNotEmpty(str);
        if (!TextUtils.isEmpty(str2) || !TextUtils.isEmpty(str3)) {
            this.zzgi = str2;
            this.zzgj = str3;
            this.zzgk = str4;
            this.zzgl = z;
            return;
        }
        throw new IllegalArgumentException("Cannot create an EmailAuthCredential without a password or emailLink.");
    }

    EmailAuthCredential(String str, String str2) {
        this(str, str2, (String) null, (String) null, false);
    }

    @NonNull
    public final String getEmail() {
        return this.zzgh;
    }

    @NonNull
    public final String getPassword() {
        return this.zzgi;
    }

    @NonNull
    public final String zzbw() {
        return this.zzgj;
    }

    @Nullable
    public final String zzbx() {
        return this.zzgk;
    }

    public final boolean zzby() {
        return this.zzgl;
    }

    public final EmailAuthCredential zza(@Nullable FirebaseUser firebaseUser) {
        this.zzgk = firebaseUser.zzch();
        this.zzgl = true;
        return this;
    }

    @NonNull
    public String getProvider() {
        return "password";
    }

    public String getSignInMethod() {
        if (!TextUtils.isEmpty(this.zzgi)) {
            return "password";
        }
        return EmailAuthProvider.EMAIL_LINK_SIGN_IN_METHOD;
    }

    public final boolean zzbz() {
        return !TextUtils.isEmpty(this.zzgj);
    }

    public static boolean isSignInWithEmailLink(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (zzbn(str)) {
                return true;
            }
            return zzbn(Uri.parse(str).getQueryParameter("link"));
        } catch (UnsupportedOperationException e) {
            Logger logger = zzgg;
            Object[] objArr = new Object[1];
            String valueOf = String.valueOf(e.getMessage());
            objArr[0] = valueOf.length() != 0 ? "isSignInWithEmailLink returned an UnsupportedOperationException: ".concat(valueOf) : new String("isSignInWithEmailLink returned an UnsupportedOperationException: ");
            logger.mo10774v("EmailAuthCredential", objArr);
            return false;
        }
    }

    private static boolean zzbn(@NonNull String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        String queryParameter = parse.getQueryParameter("oobCode");
        String queryParameter2 = parse.getQueryParameter("mode");
        if (TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2) || !queryParameter2.equals("signIn")) {
            return false;
        }
        return true;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, this.zzgh, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzgi, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzgj, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzgk, false);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzgl);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
