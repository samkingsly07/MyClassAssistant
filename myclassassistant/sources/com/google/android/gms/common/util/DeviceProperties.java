package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class DeviceProperties {
    private static Boolean zzgm;
    private static Boolean zzgn;
    private static Boolean zzgo;
    private static Boolean zzgp;
    private static Boolean zzgq;
    private static Boolean zzgr;
    private static Boolean zzgs;
    private static Boolean zzgt;

    private DeviceProperties() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x003f, code lost:
        if (zzgn.booleanValue() != false) goto L_0x0043;
     */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isTablet(android.content.res.Resources r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.Boolean r1 = zzgm
            if (r1 != 0) goto L_0x004a
            android.content.res.Configuration r1 = r4.getConfiguration()
            int r1 = r1.screenLayout
            r1 = r1 & 15
            r2 = 3
            r3 = 1
            if (r1 <= r2) goto L_0x0017
            r1 = 1
            goto L_0x0019
        L_0x0017:
            r1 = 0
        L_0x0019:
            if (r1 != 0) goto L_0x0043
            java.lang.Boolean r1 = zzgn
            if (r1 != 0) goto L_0x0039
            android.content.res.Configuration r4 = r4.getConfiguration()
            int r1 = r4.screenLayout
            r1 = r1 & 15
            if (r1 > r2) goto L_0x0031
            int r4 = r4.smallestScreenWidthDp
            r1 = 600(0x258, float:8.41E-43)
            if (r4 < r1) goto L_0x0031
            r4 = 1
            goto L_0x0033
        L_0x0031:
            r4 = 0
        L_0x0033:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            zzgn = r4
        L_0x0039:
            java.lang.Boolean r4 = zzgn
            boolean r4 = r4.booleanValue()
            if (r4 == 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            goto L_0x0044
        L_0x0043:
            r0 = 1
        L_0x0044:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r0)
            zzgm = r4
        L_0x004a:
            java.lang.Boolean r4 = zzgm
            boolean r4 = r4.booleanValue()
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.util.DeviceProperties.isTablet(android.content.res.Resources):boolean");
    }

    @TargetApi(20)
    @KeepForSdk
    public static boolean isWearable(Context context) {
        if (zzgo == null) {
            zzgo = Boolean.valueOf(PlatformVersion.isAtLeastKitKatWatch() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch"));
        }
        return zzgo.booleanValue();
    }

    @TargetApi(26)
    @KeepForSdk
    public static boolean isWearableWithoutPlayStore(Context context) {
        if (!isWearable(context)) {
            return false;
        }
        if (PlatformVersion.isAtLeastN()) {
            return isSidewinder(context) && !PlatformVersion.isAtLeastO();
        }
        return true;
    }

    @TargetApi(21)
    @KeepForSdk
    public static boolean isSidewinder(Context context) {
        if (zzgp == null) {
            zzgp = Boolean.valueOf(PlatformVersion.isAtLeastLollipop() && context.getPackageManager().hasSystemFeature("cn.google"));
        }
        return zzgp.booleanValue();
    }

    @KeepForSdk
    public static boolean isLatchsky(Context context) {
        if (zzgq == null) {
            PackageManager packageManager = context.getPackageManager();
            zzgq = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.feature.services_updater") && packageManager.hasSystemFeature("cn.google.services"));
        }
        return zzgq.booleanValue();
    }

    public static boolean zzf(Context context) {
        if (zzgr == null) {
            zzgr = Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.type.iot") || context.getPackageManager().hasSystemFeature("android.hardware.type.embedded"));
        }
        return zzgr.booleanValue();
    }

    @KeepForSdk
    public static boolean isAuto(Context context) {
        if (zzgs == null) {
            zzgs = Boolean.valueOf(PlatformVersion.isAtLeastO() && context.getPackageManager().hasSystemFeature("android.hardware.type.automotive"));
        }
        return zzgs.booleanValue();
    }

    @KeepForSdk
    public static boolean isTv(Context context) {
        if (zzgt == null) {
            PackageManager packageManager = context.getPackageManager();
            zzgt = Boolean.valueOf(packageManager.hasSystemFeature("com.google.android.tv") || packageManager.hasSystemFeature("android.hardware.type.television") || packageManager.hasSystemFeature("android.software.leanback"));
        }
        return zzgt.booleanValue();
    }

    @KeepForSdk
    public static boolean isUserBuild() {
        return "user".equals(Build.TYPE);
    }
}
