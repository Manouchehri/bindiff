/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.zylib.general;

@Deprecated
public class MathUtils {
    public static long pow(long l2, long l3) {
        if (l3 == 0) {
            return 1;
        }
        long l4 = l2;
        int n2 = 1;
        while ((long)n2 < l3) {
            l4 *= l2;
            ++n2;
        }
        return l4;
    }
}

