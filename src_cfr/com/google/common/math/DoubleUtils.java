/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.base.Preconditions;
import java.math.BigInteger;

final class DoubleUtils {
    static final long SIGNIFICAND_MASK = 0xFFFFFFFFFFFFFL;
    static final long EXPONENT_MASK = 9218868437227405312L;
    static final long SIGN_MASK = Long.MIN_VALUE;
    static final int SIGNIFICAND_BITS = 52;
    static final int EXPONENT_BIAS = 1023;
    static final long IMPLICIT_BIT = 0x10000000000000L;
    private static final long ONE_BITS = Double.doubleToRawLongBits(1.0);

    private DoubleUtils() {
    }

    static double nextDown(double d2) {
        return - Math.nextUp(- d2);
    }

    static long getSignificand(double d2) {
        long l2;
        Preconditions.checkArgument(DoubleUtils.isFinite(d2), "not a normal value");
        int n2 = Math.getExponent(d2);
        long l3 = Double.doubleToRawLongBits(d2);
        l3 &= 0xFFFFFFFFFFFFFL;
        if (n2 == -1023) {
            l2 = l3 << 1;
            return l2;
        }
        l2 = l3 | 0x10000000000000L;
        return l2;
    }

    static boolean isFinite(double d2) {
        if (Math.getExponent(d2) > 1023) return false;
        return true;
    }

    static boolean isNormal(double d2) {
        if (Math.getExponent(d2) < -1022) return false;
        return true;
    }

    static double scaleNormalize(double d2) {
        long l2 = Double.doubleToRawLongBits(d2) & 0xFFFFFFFFFFFFFL;
        return Double.longBitsToDouble(l2 | ONE_BITS);
    }

    static double bigToDouble(BigInteger bigInteger) {
        BigInteger bigInteger2 = bigInteger.abs();
        int n2 = bigInteger2.bitLength() - 1;
        if (n2 < 63) {
            return bigInteger.longValue();
        }
        if (n2 > 1023) {
            return (double)bigInteger.signum() * Double.POSITIVE_INFINITY;
        }
        int n3 = n2 - 52 - 1;
        long l2 = bigInteger2.shiftRight(n3).longValue();
        long l3 = l2 >> 1;
        boolean bl2 = (l2 & 1) != 0 && (((l3 &= 0xFFFFFFFFFFFFFL) & 1) != 0 || bigInteger2.getLowestSetBit() < n3);
        long l4 = bl2 ? l3 + 1 : l3;
        long l5 = (long)(n2 + 1023) << 52;
        l5 += l4;
        return Double.longBitsToDouble(l5 |= (long)bigInteger.signum() & Long.MIN_VALUE);
    }

    static double ensureNonNegative(double d2) {
        Preconditions.checkArgument(!Double.isNaN(d2));
        if (d2 <= 0.0) return 0.0;
        return d2;
    }
}

