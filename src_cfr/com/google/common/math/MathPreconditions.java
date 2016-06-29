/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import java.math.BigInteger;
import javax.annotation.Nullable;

@GwtCompatible
final class MathPreconditions {
    static int checkPositive(@Nullable String string, int n2) {
        if (n2 > 0) return n2;
        throw new IllegalArgumentException(new StringBuilder(26 + String.valueOf(string).length()).append(string).append(" (").append(n2).append(") must be > 0").toString());
    }

    static long checkPositive(@Nullable String string, long l2) {
        if (l2 > 0) return l2;
        throw new IllegalArgumentException(new StringBuilder(35 + String.valueOf(string).length()).append(string).append(" (").append(l2).append(") must be > 0").toString());
    }

    static BigInteger checkPositive(@Nullable String string, BigInteger bigInteger) {
        if (bigInteger.signum() > 0) return bigInteger;
        String string2 = String.valueOf(bigInteger);
        throw new IllegalArgumentException(new StringBuilder(15 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(" (").append(string2).append(") must be > 0").toString());
    }

    static int checkNonNegative(@Nullable String string, int n2) {
        if (n2 >= 0) return n2;
        throw new IllegalArgumentException(new StringBuilder(27 + String.valueOf(string).length()).append(string).append(" (").append(n2).append(") must be >= 0").toString());
    }

    static long checkNonNegative(@Nullable String string, long l2) {
        if (l2 >= 0) return l2;
        throw new IllegalArgumentException(new StringBuilder(36 + String.valueOf(string).length()).append(string).append(" (").append(l2).append(") must be >= 0").toString());
    }

    static BigInteger checkNonNegative(@Nullable String string, BigInteger bigInteger) {
        if (bigInteger.signum() >= 0) return bigInteger;
        String string2 = String.valueOf(bigInteger);
        throw new IllegalArgumentException(new StringBuilder(16 + String.valueOf(string).length() + String.valueOf(string2).length()).append(string).append(" (").append(string2).append(") must be >= 0").toString());
    }

    static double checkNonNegative(@Nullable String string, double d2) {
        if (d2 >= 0.0) return d2;
        throw new IllegalArgumentException(new StringBuilder(40 + String.valueOf(string).length()).append(string).append(" (").append(d2).append(") must be >= 0").toString());
    }

    static void checkRoundingUnnecessary(boolean bl2) {
        if (bl2) return;
        throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
    }

    static void checkInRange(boolean bl2) {
        if (bl2) return;
        throw new ArithmeticException("not in range");
    }

    static void checkNoOverflow(boolean bl2) {
        if (bl2) return;
        throw new ArithmeticException("overflow");
    }

    private MathPreconditions() {
    }
}

