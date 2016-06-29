/*
 * Decompiled with CFR 0_115.
 */
package com.google.security.zynamics.bindiff.utils;

public class FlagUtils {
    public static boolean parseFlag(byte by2, byte by3) {
        if (by3 < 0) throw new IllegalArgumentException("Flag has only 8 bits.");
        if (by3 > 7) {
            throw new IllegalArgumentException("Flag has only 8 bits.");
        }
        int n2 = by2 >>> by3;
        if (0 == (n2 & 1)) return false;
        return true;
    }

    public static boolean parseFlag(int n2, byte by2) {
        if (by2 < 0) throw new IllegalArgumentException("Flag has only 32 bits.");
        if (by2 > 31) {
            throw new IllegalArgumentException("Flag has only 32 bits.");
        }
        int n3 = n2 >>> by2;
        if (0 == (n3 & 1)) return false;
        return true;
    }

    public static byte setFlag(byte by2, byte by3) {
        if (by3 < 0) throw new IllegalArgumentException("Flag has only 8 bits.");
        if (by3 > 7) {
            throw new IllegalArgumentException("Flag has only 8 bits.");
        }
        byte by4 = by2;
        return (byte)(by4 | 1 << by3);
    }

    public static int setFlag(int n2, byte by2) {
        if (by2 < 0) throw new IllegalArgumentException("Flag has only 32 bits.");
        if (by2 > 31) {
            throw new IllegalArgumentException("Flag has only 32 bits.");
        }
        int n3 = n2;
        return n3 |= 1 << by2;
    }
}

