package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.internal.firebase_auth.zzdz;
import com.google.android.gms.internal.firebase_auth.zzea;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class zzdz<MessageType extends zzdz<MessageType, BuilderType>, BuilderType extends zzea<MessageType, BuilderType>> implements zzhb {
    private static boolean zzsg = false;
    protected int zzsf = 0;

    public final zzeh zzer() {
        try {
            zzeo zzl = zzeh.zzl(zzgv());
            zzb(zzl.zzfg());
            return zzl.zzff();
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("ByteString").length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("ByteString");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    public final byte[] toByteArray() {
        try {
            byte[] bArr = new byte[zzgv()];
            zzez zzb = zzez.zzb(bArr);
            zzb(zzb);
            zzb.zzgi();
            return bArr;
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 62 + String.valueOf("byte array").length());
            sb.append("Serializing ");
            sb.append(name);
            sb.append(" to a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e);
        }
    }

    /* access modifiers changed from: package-private */
    public int zzes() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public void zzg(int i) {
        throw new UnsupportedOperationException();
    }

    protected static <T> void zza(Iterable<T> iterable, List<? super T> list) {
        zzfu.checkNotNull(iterable);
        if (iterable instanceof zzgk) {
            List<?> zzib = ((zzgk) iterable).zzib();
            zzgk zzgk = (zzgk) list;
            int size = list.size();
            for (Object next : zzib) {
                if (next == null) {
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(zzgk.size() - size);
                    sb.append(" is null.");
                    String sb2 = sb.toString();
                    for (int size2 = zzgk.size() - 1; size2 >= size; size2--) {
                        zzgk.remove(size2);
                    }
                    throw new NullPointerException(sb2);
                } else if (next instanceof zzeh) {
                    zzgk.zzc((zzeh) next);
                } else {
                    zzgk.add((String) next);
                }
            }
        } else if (iterable instanceof zzhm) {
            list.addAll((Collection) iterable);
        } else {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (T next2 : iterable) {
                if (next2 == null) {
                    StringBuilder sb3 = new StringBuilder(37);
                    sb3.append("Element at index ");
                    sb3.append(list.size() - size3);
                    sb3.append(" is null.");
                    String sb4 = sb3.toString();
                    for (int size4 = list.size() - 1; size4 >= size3; size4--) {
                        list.remove(size4);
                    }
                    throw new NullPointerException(sb4);
                }
                list.add(next2);
            }
        }
    }
}
