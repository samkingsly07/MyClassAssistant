package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzfs;

public final class zzim extends zzfs<zzim, zza> implements zzhd {
    /* access modifiers changed from: private */
    public static final zzim zzabk = new zzim();
    private static volatile zzhl<zzim> zzm;
    private long zzabi;
    private int zzabj;

    private zzim() {
    }

    public static final class zza extends zzfs.zza<zzim, zza> implements zzhd {
        private zza() {
            super(zzim.zzabk);
        }

        /* synthetic */ zza(zzin zzin) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzin.zzn[i - 1]) {
            case 1:
                return new zzim();
            case 2:
                return new zza((zzin) null);
            case 3:
                return new zzhp(zzabk, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzabi", "zzabj"});
            case 4:
                return zzabk;
            case 5:
                zzhl<zzim> zzhl = zzm;
                if (zzhl == null) {
                    synchronized (zzim.class) {
                        zzhl = zzm;
                        if (zzhl == null) {
                            zzhl = new zzfs.zzb<>(zzabk);
                            zzm = zzhl;
                        }
                    }
                }
                return zzhl;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    static {
        zzfs.zza(zzim.class, zzabk);
    }
}
