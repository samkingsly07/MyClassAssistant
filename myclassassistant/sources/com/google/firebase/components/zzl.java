package com.google.firebase.components;

import com.google.firebase.events.Event;
import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@16.0.2 */
final class zzl extends zza {
    private final Set<Class<?>> zza;
    private final Set<Class<?>> zzb;
    private final Set<Class<?>> zzc;
    private final ComponentContainer zzd;

    zzl(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (Dependency next : component.zzb()) {
            if (next.zzc()) {
                hashSet.add(next.zza());
            } else {
                hashSet2.add(next.zza());
            }
        }
        if (!component.zzd().isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.zza = Collections.unmodifiableSet(hashSet);
        this.zzb = Collections.unmodifiableSet(hashSet2);
        this.zzc = component.zzd();
        this.zzd = componentContainer;
    }

    public final <T> T get(Class<T> anInterface) {
        if (!this.zza.contains(anInterface)) {
            throw new IllegalArgumentException(String.format("Requesting %s is not allowed.", new Object[]{anInterface}));
        }
        T t = this.zzd.get(anInterface);
        if (!anInterface.equals(Publisher.class)) {
            return t;
        }
        return new zza(this.zzc, (Publisher) t);
    }

    public final <T> Provider<T> getProvider(Class<T> anInterface) {
        if (this.zzb.contains(anInterface)) {
            return this.zzd.getProvider(anInterface);
        }
        throw new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", new Object[]{anInterface}));
    }

    /* compiled from: com.google.firebase:firebase-common@@16.0.2 */
    static class zza implements Publisher {
        private final Set<Class<?>> zza;
        private final Publisher zzb;

        public zza(Set<Class<?>> set, Publisher publisher) {
            this.zza = set;
            this.zzb = publisher;
        }

        public final void publish(Event<?> event) {
            if (!this.zza.contains(event.getType())) {
                throw new IllegalArgumentException(String.format("Attempting to publish an undeclared event %s.", new Object[]{event}));
            } else {
                this.zzb.publish(event);
            }
        }
    }
}
