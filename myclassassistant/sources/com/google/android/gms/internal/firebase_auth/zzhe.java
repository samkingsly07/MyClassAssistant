package com.google.android.gms.internal.firebase_auth;

import java.util.List;
import java.util.Map;

final class zzhe {
    static String zza(zzhb zzhb, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zza(zzhb, sb, 0);
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01fd, code lost:
        if (((java.lang.Boolean) r6).booleanValue() == false) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0211, code lost:
        if (((java.lang.Integer) r6).intValue() == 0) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0223, code lost:
        if (((java.lang.Float) r6).floatValue() == 0.0f) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0236, code lost:
        if (((java.lang.Double) r6).doubleValue() == 0.0d) goto L_0x01ff;
     */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0271  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0273  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void zza(com.google.android.gms.internal.firebase_auth.zzhb r12, java.lang.StringBuilder r13, int r14) {
        /*
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.util.TreeSet r2 = new java.util.TreeSet
            r2.<init>()
            java.lang.Class r3 = r12.getClass()
            java.lang.reflect.Method[] r3 = r3.getDeclaredMethods()
            int r4 = r3.length
            r5 = 0
            r6 = 0
        L_0x001a:
            if (r6 >= r4) goto L_0x0049
            r7 = r3[r6]
            java.lang.String r8 = r7.getName()
            r1.put(r8, r7)
            java.lang.Class[] r8 = r7.getParameterTypes()
            int r8 = r8.length
            if (r8 != 0) goto L_0x0046
            java.lang.String r8 = r7.getName()
            r0.put(r8, r7)
            java.lang.String r8 = r7.getName()
            java.lang.String r9 = "get"
            boolean r8 = r8.startsWith(r9)
            if (r8 == 0) goto L_0x0046
            java.lang.String r7 = r7.getName()
            r2.add(r7)
        L_0x0046:
            int r6 = r6 + 1
            goto L_0x001a
        L_0x0049:
            java.util.Iterator r2 = r2.iterator()
        L_0x004d:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x028f
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = "get"
            java.lang.String r6 = ""
            java.lang.String r4 = r3.replaceFirst(r4, r6)
            java.lang.String r6 = "List"
            boolean r6 = r4.endsWith(r6)
            r7 = 1
            if (r6 == 0) goto L_0x00c9
            java.lang.String r6 = "OrBuilderList"
            boolean r6 = r4.endsWith(r6)
            if (r6 != 0) goto L_0x00c9
            java.lang.String r6 = "List"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x00c9
            java.lang.String r6 = r4.substring(r5, r7)
            java.lang.String r6 = r6.toLowerCase()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r8 = r4.length()
            int r8 = r8 + -4
            java.lang.String r8 = r4.substring(r7, r8)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r9 = r8.length()
            if (r9 == 0) goto L_0x00a0
            java.lang.String r6 = r6.concat(r8)
            goto L_0x00a6
        L_0x00a0:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r6)
            r6 = r8
        L_0x00a6:
            java.lang.Object r8 = r0.get(r3)
            java.lang.reflect.Method r8 = (java.lang.reflect.Method) r8
            if (r8 == 0) goto L_0x00c9
            java.lang.Class r9 = r8.getReturnType()
            java.lang.Class<java.util.List> r10 = java.util.List.class
            boolean r9 = r9.equals(r10)
            if (r9 == 0) goto L_0x00c9
            java.lang.String r3 = zzdc(r6)
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzfs.zza((java.lang.reflect.Method) r8, (java.lang.Object) r12, (java.lang.Object[]) r4)
            zza(r13, r14, r3, r4)
            goto L_0x004d
        L_0x00c9:
            java.lang.String r6 = "Map"
            boolean r6 = r4.endsWith(r6)
            if (r6 == 0) goto L_0x013b
            java.lang.String r6 = "Map"
            boolean r6 = r4.equals(r6)
            if (r6 != 0) goto L_0x013b
            java.lang.String r6 = r4.substring(r5, r7)
            java.lang.String r6 = r6.toLowerCase()
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r8 = r4.length()
            int r8 = r8 + -3
            java.lang.String r8 = r4.substring(r7, r8)
            java.lang.String r8 = java.lang.String.valueOf(r8)
            int r9 = r8.length()
            if (r9 == 0) goto L_0x00ff
            java.lang.String r6 = r6.concat(r8)
            goto L_0x0105
        L_0x00ff:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r6)
            r6 = r8
        L_0x0105:
            java.lang.Object r3 = r0.get(r3)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r3 == 0) goto L_0x013b
            java.lang.Class r8 = r3.getReturnType()
            java.lang.Class<java.util.Map> r9 = java.util.Map.class
            boolean r8 = r8.equals(r9)
            if (r8 == 0) goto L_0x013b
            java.lang.Class<java.lang.Deprecated> r8 = java.lang.Deprecated.class
            boolean r8 = r3.isAnnotationPresent(r8)
            if (r8 != 0) goto L_0x013b
            int r8 = r3.getModifiers()
            boolean r8 = java.lang.reflect.Modifier.isPublic(r8)
            if (r8 == 0) goto L_0x013b
            java.lang.String r4 = zzdc(r6)
            java.lang.Object[] r6 = new java.lang.Object[r5]
            java.lang.Object r3 = com.google.android.gms.internal.firebase_auth.zzfs.zza((java.lang.reflect.Method) r3, (java.lang.Object) r12, (java.lang.Object[]) r6)
            zza(r13, r14, r4, r3)
            goto L_0x004d
        L_0x013b:
            java.lang.String r3 = "set"
            java.lang.String r6 = java.lang.String.valueOf(r4)
            int r8 = r6.length()
            if (r8 == 0) goto L_0x014c
            java.lang.String r3 = r3.concat(r6)
            goto L_0x0152
        L_0x014c:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r3)
            r3 = r6
        L_0x0152:
            java.lang.Object r3 = r1.get(r3)
            java.lang.reflect.Method r3 = (java.lang.reflect.Method) r3
            if (r3 == 0) goto L_0x004d
            java.lang.String r3 = "Bytes"
            boolean r3 = r4.endsWith(r3)
            if (r3 == 0) goto L_0x0189
            java.lang.String r3 = "get"
            int r6 = r4.length()
            int r6 = r6 + -5
            java.lang.String r6 = r4.substring(r5, r6)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r8 = r6.length()
            if (r8 == 0) goto L_0x017d
            java.lang.String r3 = r3.concat(r6)
            goto L_0x0183
        L_0x017d:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r3)
            r3 = r6
        L_0x0183:
            boolean r3 = r0.containsKey(r3)
            if (r3 != 0) goto L_0x004d
        L_0x0189:
            java.lang.String r3 = r4.substring(r5, r7)
            java.lang.String r3 = r3.toLowerCase()
            java.lang.String r3 = java.lang.String.valueOf(r3)
            java.lang.String r6 = r4.substring(r7)
            java.lang.String r6 = java.lang.String.valueOf(r6)
            int r8 = r6.length()
            if (r8 == 0) goto L_0x01a8
            java.lang.String r3 = r3.concat(r6)
            goto L_0x01ae
        L_0x01a8:
            java.lang.String r6 = new java.lang.String
            r6.<init>(r3)
            r3 = r6
        L_0x01ae:
            java.lang.String r6 = "get"
            java.lang.String r8 = java.lang.String.valueOf(r4)
            int r9 = r8.length()
            if (r9 == 0) goto L_0x01bf
            java.lang.String r6 = r6.concat(r8)
            goto L_0x01c5
        L_0x01bf:
            java.lang.String r8 = new java.lang.String
            r8.<init>(r6)
            r6 = r8
        L_0x01c5:
            java.lang.Object r6 = r0.get(r6)
            java.lang.reflect.Method r6 = (java.lang.reflect.Method) r6
            java.lang.String r8 = "has"
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r9 = r4.length()
            if (r9 == 0) goto L_0x01dc
            java.lang.String r4 = r8.concat(r4)
            goto L_0x01e1
        L_0x01dc:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r8)
        L_0x01e1:
            java.lang.Object r4 = r0.get(r4)
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4
            if (r6 == 0) goto L_0x028d
            java.lang.Object[] r8 = new java.lang.Object[r5]
            java.lang.Object r6 = com.google.android.gms.internal.firebase_auth.zzfs.zza((java.lang.reflect.Method) r6, (java.lang.Object) r12, (java.lang.Object[]) r8)
            if (r4 != 0) goto L_0x0276
            boolean r4 = r6 instanceof java.lang.Boolean
            if (r4 == 0) goto L_0x0206
            r4 = r6
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x0202
        L_0x01ff:
            r4 = 1
            goto L_0x026f
        L_0x0202:
        L_0x0203:
            r4 = 0
            goto L_0x026f
        L_0x0206:
            boolean r4 = r6 instanceof java.lang.Integer
            if (r4 == 0) goto L_0x0215
            r4 = r6
            java.lang.Integer r4 = (java.lang.Integer) r4
            int r4 = r4.intValue()
            if (r4 != 0) goto L_0x0214
            goto L_0x01ff
        L_0x0214:
            goto L_0x0203
        L_0x0215:
            boolean r4 = r6 instanceof java.lang.Float
            if (r4 == 0) goto L_0x0227
            r4 = r6
            java.lang.Float r4 = (java.lang.Float) r4
            float r4 = r4.floatValue()
            r8 = 0
            int r4 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r4 != 0) goto L_0x0226
            goto L_0x01ff
        L_0x0226:
            goto L_0x0203
        L_0x0227:
            boolean r4 = r6 instanceof java.lang.Double
            if (r4 == 0) goto L_0x023a
            r4 = r6
            java.lang.Double r4 = (java.lang.Double) r4
            double r8 = r4.doubleValue()
            r10 = 0
            int r4 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r4 != 0) goto L_0x0239
            goto L_0x01ff
        L_0x0239:
            goto L_0x0203
        L_0x023a:
            boolean r4 = r6 instanceof java.lang.String
            if (r4 == 0) goto L_0x0245
            java.lang.String r4 = ""
            boolean r4 = r6.equals(r4)
            goto L_0x026f
        L_0x0245:
            boolean r4 = r6 instanceof com.google.android.gms.internal.firebase_auth.zzeh
            if (r4 == 0) goto L_0x0250
            com.google.android.gms.internal.firebase_auth.zzeh r4 = com.google.android.gms.internal.firebase_auth.zzeh.zzso
            boolean r4 = r6.equals(r4)
            goto L_0x026f
        L_0x0250:
            boolean r4 = r6 instanceof com.google.android.gms.internal.firebase_auth.zzhb
            if (r4 == 0) goto L_0x025f
            r4 = r6
            com.google.android.gms.internal.firebase_auth.zzhb r4 = (com.google.android.gms.internal.firebase_auth.zzhb) r4
            com.google.android.gms.internal.firebase_auth.zzhb r4 = r4.zzhh()
            if (r6 != r4) goto L_0x025e
            goto L_0x01ff
        L_0x025e:
            goto L_0x0203
        L_0x025f:
            boolean r4 = r6 instanceof java.lang.Enum
            if (r4 == 0) goto L_0x026e
            r4 = r6
            java.lang.Enum r4 = (java.lang.Enum) r4
            int r4 = r4.ordinal()
            if (r4 != 0) goto L_0x026d
            goto L_0x01ff
        L_0x026d:
            goto L_0x0203
        L_0x026e:
            goto L_0x0203
        L_0x026f:
            if (r4 != 0) goto L_0x0273
            r4 = 1
            goto L_0x0282
        L_0x0273:
            r4 = 0
            goto L_0x0282
        L_0x0276:
            java.lang.Object[] r7 = new java.lang.Object[r5]
            java.lang.Object r4 = com.google.android.gms.internal.firebase_auth.zzfs.zza((java.lang.reflect.Method) r4, (java.lang.Object) r12, (java.lang.Object[]) r7)
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
        L_0x0282:
            if (r4 == 0) goto L_0x004d
            java.lang.String r3 = zzdc(r3)
            zza(r13, r14, r3, r6)
            goto L_0x004d
        L_0x028d:
            goto L_0x004d
        L_0x028f:
            boolean r0 = r12 instanceof com.google.android.gms.internal.firebase_auth.zzfs.zzc
            if (r0 == 0) goto L_0x02b1
            r0 = r12
            com.google.android.gms.internal.firebase_auth.zzfs$zzc r0 = (com.google.android.gms.internal.firebase_auth.zzfs.zzc) r0
            com.google.android.gms.internal.firebase_auth.zzfj<java.lang.Object> r0 = r0.zzxe
            java.util.Iterator r0 = r0.iterator()
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02b1
            java.lang.Object r12 = r0.next()
            java.util.Map$Entry r12 = (java.util.Map.Entry) r12
            r12.getKey()
            java.lang.NoSuchMethodError r12 = new java.lang.NoSuchMethodError
            r12.<init>()
            throw r12
        L_0x02b1:
            com.google.android.gms.internal.firebase_auth.zzfs r12 = (com.google.android.gms.internal.firebase_auth.zzfs) r12
            com.google.android.gms.internal.firebase_auth.zziq r0 = r12.zzwy
            if (r0 == 0) goto L_0x02bc
            com.google.android.gms.internal.firebase_auth.zziq r12 = r12.zzwy
            r12.zza((java.lang.StringBuilder) r13, (int) r14)
        L_0x02bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase_auth.zzhe.zza(com.google.android.gms.internal.firebase_auth.zzhb, java.lang.StringBuilder, int):void");
    }

    static final void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zza : (List) obj) {
                zza(sb, i, str, zza);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zza2 : ((Map) obj).entrySet()) {
                zza(sb, i, str, zza2);
            }
        } else {
            sb.append(10);
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzij.zzf(zzeh.zzcy((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zzeh) {
                sb.append(": \"");
                sb.append(zzij.zzf((zzeh) obj));
                sb.append('\"');
            } else if (obj instanceof zzfs) {
                sb.append(" {");
                zza((zzfs) obj, sb, i + 2);
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i4 = i + 2;
                zza(sb, i4, "key", entry.getKey());
                zza(sb, i4, "value", entry.getValue());
                sb.append("\n");
                while (i2 < i) {
                    sb.append(' ');
                    i2++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static final String zzdc(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }
}
