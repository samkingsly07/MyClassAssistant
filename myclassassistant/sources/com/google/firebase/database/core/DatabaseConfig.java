package com.google.firebase.database.core;

import android.support.p000v4.media.session.PlaybackStateCompat;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.Logger;
import com.google.firebase.database.logging.Logger;
import java.util.List;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class DatabaseConfig extends Context {
    public synchronized void setLogger(Logger logger) {
        assertUnfrozen();
        this.logger = logger;
    }

    public synchronized void setEventTarget(EventTarget eventTarget) {
        assertUnfrozen();
        this.eventTarget = eventTarget;
    }

    public synchronized void setLogLevel(Logger.Level logLevel) {
        assertUnfrozen();
        switch (logLevel) {
            case DEBUG:
                this.logLevel = Logger.Level.DEBUG;
                break;
            case INFO:
                this.logLevel = Logger.Level.INFO;
                break;
            case WARN:
                this.logLevel = Logger.Level.WARN;
                break;
            case ERROR:
                this.logLevel = Logger.Level.ERROR;
                break;
            case NONE:
                this.logLevel = Logger.Level.NONE;
                break;
            default:
                throw new IllegalArgumentException("Unknown log level: " + logLevel);
        }
    }

    public synchronized void setDebugLogComponents(List<String> debugComponents) {
        assertUnfrozen();
        setLogLevel(Logger.Level.DEBUG);
        this.loggedComponents = debugComponents;
    }

    public void setRunLoop(RunLoop runLoop) {
        this.runLoop = runLoop;
    }

    public void setAuthTokenProvider(AuthTokenProvider provider) {
        this.authTokenProvider = provider;
    }

    public synchronized void setSessionPersistenceKey(String sessionKey) {
        assertUnfrozen();
        if (sessionKey != null) {
            if (!sessionKey.isEmpty()) {
                this.persistenceKey = sessionKey;
            }
        }
        throw new IllegalArgumentException("Session identifier is not allowed to be empty or null!");
    }

    public synchronized void setPersistenceEnabled(boolean isEnabled) {
        assertUnfrozen();
        this.persistenceEnabled = isEnabled;
    }

    public synchronized void setPersistenceCacheSizeBytes(long cacheSizeInBytes) {
        assertUnfrozen();
        if (cacheSizeInBytes < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            throw new DatabaseException("The minimum cache size must be at least 1MB");
        } else if (cacheSizeInBytes > 104857600) {
            throw new DatabaseException("Firebase Database currently doesn't support a cache size larger than 100MB");
        } else {
            this.cacheSize = cacheSizeInBytes;
        }
    }

    public synchronized void setFirebaseApp(FirebaseApp app) {
        this.firebaseApp = app;
    }
}
