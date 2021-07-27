package com.google.android.gms.internal.firebase_auth;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzhz extends zzhy<FieldDescriptorType, Object> {
    zzhz(int i) {
        super(i, (zzhz) null);
    }

    public final void zzev() {
        if (!isImmutable()) {
            for (int i = 0; i < zzjd(); i++) {
                Map.Entry zzbb = zzbb(i);
                if (((zzfl) zzbb.getKey()).zzgz()) {
                    zzbb.setValue(Collections.unmodifiableList((List) zzbb.getValue()));
                }
            }
            for (Map.Entry entry : zzje()) {
                if (((zzfl) entry.getKey()).zzgz()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzev();
    }
}
