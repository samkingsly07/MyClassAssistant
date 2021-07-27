package com.google.firebase.components;

import android.support.annotation.GuardedBy;
import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.events.Event;
import com.google.firebase.events.EventHandler;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
class zzh implements Publisher, Subscriber {
    @GuardedBy("this")
    private final Map<Class<?>, ConcurrentHashMap<EventHandler<Object>, Executor>> zza = new HashMap();
    @GuardedBy("this")
    private Queue<Event<?>> zzb = new ArrayDeque();
    private final Executor zzc;

    zzh(Executor executor) {
        this.zzc = executor;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r0.hasNext() == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r1 = r0.next();
        ((java.util.concurrent.Executor) r1.getValue()).execute(com.google.firebase.components.zzi.zza(r1, r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        r0 = zza(r4).iterator();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void publish(com.google.firebase.events.Event<?> r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r4)
            monitor-enter(r3)
            java.util.Queue<com.google.firebase.events.Event<?>> r0 = r3.zzb     // Catch:{ all -> 0x0035 }
            if (r0 == 0) goto L_0x000f
            java.util.Queue<com.google.firebase.events.Event<?>> r0 = r3.zzb     // Catch:{ all -> 0x0035 }
            r0.add(r4)     // Catch:{ all -> 0x0035 }
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            return
        L_0x000f:
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            java.util.Set r0 = r3.zza(r4)
            java.util.Iterator r0 = r0.iterator()
        L_0x0019:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0034
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            java.util.concurrent.Executor r2 = (java.util.concurrent.Executor) r2
            java.lang.Runnable r1 = com.google.firebase.components.zzi.zza(r1, r4)
            r2.execute(r1)
            goto L_0x0019
        L_0x0034:
            return
        L_0x0035:
            r0 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0035 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.zzh.publish(com.google.firebase.events.Event):void");
    }

    private synchronized Set<Map.Entry<EventHandler<Object>, Executor>> zza(Event<?> event) {
        Map map;
        map = this.zza.get(event.getType());
        return map == null ? Collections.emptySet() : map.entrySet();
    }

    public synchronized <T> void subscribe(Class<T> type, Executor executor, EventHandler<? super T> handler) {
        Preconditions.checkNotNull(type);
        Preconditions.checkNotNull(handler);
        Preconditions.checkNotNull(executor);
        if (!this.zza.containsKey(type)) {
            this.zza.put(type, new ConcurrentHashMap());
        }
        this.zza.get(type).put(handler, executor);
    }

    public <T> void subscribe(Class<T> cls, EventHandler<? super T> handler) {
        subscribe(cls, this.zzc, handler);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> void unsubscribe(java.lang.Class<T> r2, com.google.firebase.events.EventHandler<? super T> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x002b }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r3)     // Catch:{ all -> 0x002b }
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r0 = r1.zza     // Catch:{ all -> 0x002b }
            boolean r0 = r0.containsKey(r2)     // Catch:{ all -> 0x002b }
            if (r0 != 0) goto L_0x0011
            monitor-exit(r1)
            return
        L_0x0011:
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r0 = r1.zza     // Catch:{ all -> 0x002b }
            java.lang.Object r0 = r0.get(r2)     // Catch:{ all -> 0x002b }
            java.util.concurrent.ConcurrentHashMap r0 = (java.util.concurrent.ConcurrentHashMap) r0     // Catch:{ all -> 0x002b }
            r0.remove(r3)     // Catch:{ all -> 0x002b }
            boolean r3 = r0.isEmpty()     // Catch:{ all -> 0x002b }
            if (r3 == 0) goto L_0x0029
            java.util.Map<java.lang.Class<?>, java.util.concurrent.ConcurrentHashMap<com.google.firebase.events.EventHandler<java.lang.Object>, java.util.concurrent.Executor>> r3 = r1.zza     // Catch:{ all -> 0x002b }
            r3.remove(r2)     // Catch:{ all -> 0x002b }
        L_0x0029:
            monitor-exit(r1)
            return
        L_0x002b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.components.zzh.unsubscribe(java.lang.Class, com.google.firebase.events.EventHandler):void");
    }

    /* access modifiers changed from: package-private */
    public final void zza() {
        Queue<Event<?>> queue;
        synchronized (this) {
            if (this.zzb != null) {
                queue = this.zzb;
                this.zzb = null;
            } else {
                queue = null;
            }
        }
        if (queue != null) {
            for (Event publish : queue) {
                publish(publish);
            }
        }
    }
}
