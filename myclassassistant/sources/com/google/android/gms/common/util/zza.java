package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

public final class zza {
    private static final IntentFilter filter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static long zzgu;
    private static float zzgv = Float.NaN;

    @TargetApi(20)
    public static int zzg(Context context) {
        int i;
        int i2;
        boolean z;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, filter);
        int i3 = 0;
        if (registerReceiver == null) {
            i = 0;
        } else {
            i = registerReceiver.getIntExtra("plugged", 0);
        }
        if ((i & 7) != 0) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (PlatformVersion.isAtLeastKitKatWatch()) {
            z = powerManager.isInteractive();
        } else {
            z = powerManager.isScreenOn();
        }
        if (z) {
            i3 = 2;
        }
        return i3 | i2;
    }

    public static synchronized float zzh(Context context) {
        synchronized (zza.class) {
            if (SystemClock.elapsedRealtime() - zzgu >= 60000 || Float.isNaN(zzgv)) {
                Intent registerReceiver = context.getApplicationContext().registerReceiver((BroadcastReceiver) null, filter);
                if (registerReceiver != null) {
                    zzgv = ((float) registerReceiver.getIntExtra("level", -1)) / ((float) registerReceiver.getIntExtra("scale", -1));
                }
                zzgu = SystemClock.elapsedRealtime();
                float f = zzgv;
                return f;
            }
            float f2 = zzgv;
            return f2;
        }
    }
}
