package com.google.firebase.database.logging;

import com.google.firebase.database.logging.Logger;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-database@@16.0.4 */
public class DefaultLogger implements Logger {
    private final Set<String> enabledComponents;
    private final Logger.Level minLevel;

    public DefaultLogger(Logger.Level level, List<String> enabledComponents2) {
        if (enabledComponents2 != null) {
            this.enabledComponents = new HashSet(enabledComponents2);
        } else {
            this.enabledComponents = null;
        }
        this.minLevel = level;
    }

    public Logger.Level getLogLevel() {
        return this.minLevel;
    }

    public void onLogMessage(Logger.Level level, String tag, String message, long msTimestamp) {
        if (shouldLog(level, tag)) {
            String toLog = buildLogMessage(level, tag, message, msTimestamp);
            switch (level) {
                case ERROR:
                    error(tag, toLog);
                    return;
                case WARN:
                    warn(tag, toLog);
                    return;
                case INFO:
                    info(tag, toLog);
                    return;
                case DEBUG:
                    debug(tag, toLog);
                    return;
                default:
                    throw new RuntimeException("Should not reach here!");
            }
        }
    }

    /* access modifiers changed from: protected */
    public String buildLogMessage(Logger.Level level, String tag, String message, long msTimestamp) {
        Date now = new Date(msTimestamp);
        return now.toString() + " [" + level + "] " + tag + ": " + message;
    }

    /* access modifiers changed from: protected */
    public void error(String tag, String toLog) {
        System.err.println(toLog);
    }

    /* access modifiers changed from: protected */
    public void warn(String tag, String toLog) {
        System.out.println(toLog);
    }

    /* access modifiers changed from: protected */
    public void info(String tag, String toLog) {
        System.out.println(toLog);
    }

    /* access modifiers changed from: protected */
    public void debug(String tag, String toLog) {
        System.out.println(toLog);
    }

    /* access modifiers changed from: protected */
    public boolean shouldLog(Logger.Level level, String tag) {
        return level.ordinal() >= this.minLevel.ordinal() && (this.enabledComponents == null || level.ordinal() > Logger.Level.DEBUG.ordinal() || this.enabledComponents.contains(tag));
    }
}
