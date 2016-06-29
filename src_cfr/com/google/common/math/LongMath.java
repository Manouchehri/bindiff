/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath$1;
import com.google.common.math.LongMath$MillerRabinTester;
import com.google.common.math.MathPreconditions;
import java.math.RoundingMode;

@GwtCompatible(emulated=1)
public final class LongMath {
    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = new byte[]{19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0};
    @GwtIncompatible(value="TODO")
    @VisibleForTesting
    static final long[] powersOf10 = new long[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L};
    @GwtIncompatible(value="TODO")
    @VisibleForTesting
    static final long[] halfPowersOf10 = new long[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L};
    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    static final long[] factorials = new long[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L};
    static final int[] biggestBinomials = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66};
    @VisibleForTesting
    static final int[] biggestSimpleBinomials = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61};
    private static final long[][] millerRabinBaseSets = new long[][]{{291830, 126401071349994536L}, {885594168, 725270293939359937L, 3569819667048198375L}, {273919523040L, 15, 7363882082L, 992620450144556L}, {47636622961200L, 2, 2570940, 211991001, 3749873356L}, {7999252175582850L, 2, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L}, {585226005592931976L, 2, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L}, {Long.MAX_VALUE, 2, 325, 9375, 28178, 450775, 9780504, 1795265022}};

    public static boolean isPowerOfTwo(long l2) {
        boolean bl2;
        boolean bl3 = l2 > 0;
        if ((l2 & l2 - 1) == 0) {
            bl2 = true;
            return bl3 & bl2;
        }
        bl2 = false;
        return bl3 & bl2;
    }

    @VisibleForTesting
    static int lessThanBranchFree(long l2, long l3) {
        return (int)((l2 - l3 ^ -1 ^ -1) >>> 63);
    }

    public static int log2(long l2, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", l2);
        switch (LongMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(LongMath.isPowerOfTwo(l2));
            }
            case 2: 
            case 3: {
                return 63 - Long.numberOfLeadingZeros(l2);
            }
            case 4: 
            case 5: {
                return 64 - Long.numberOfLeadingZeros(l2 - 1);
            }
            case 6: 
            case 7: 
            case 8: {
                int n2 = Long.numberOfLeadingZeros(l2);
                long l3 = -5402926248376769404L >>> n2;
                int n3 = 63 - n2;
                return n3 + LongMath.lessThanBranchFree(l3, l2);
            }
        }
        throw new AssertionError((Object)"impossible");
    }

    @GwtIncompatible(value="TODO")
    public static int log10(long l2, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", l2);
        int n2 = LongMath.log10Floor(l2);
        long l3 = powersOf10[n2];
        switch (LongMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(l2 == l3);
            }
            case 2: 
            case 3: {
                return n2;
            }
            case 4: 
            case 5: {
                return n2 + LongMath.lessThanBranchFree(l3, l2);
            }
            case 6: 
            case 7: 
            case 8: {
                return n2 + LongMath.lessThanBranchFree(halfPowersOf10[n2], l2);
            }
        }
        throw new AssertionError();
    }

    @GwtIncompatible(value="TODO")
    static int log10Floor(long l2) {
        byte by2 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(l2)];
        return by2 - LongMath.lessThanBranchFree(l2, powersOf10[by2]);
    }

    @GwtIncompatible(value="TODO")
    public static long pow(long l2, int n2) {
        MathPreconditions.checkNonNegative("exponent", n2);
        if (-2 <= l2 && l2 <= 2) {
            switch ((int)l2) {
                case 0: {
                    if (n2 != 0) return 0;
                    return 1;
                }
                case 1: {
                    return 1;
                }
                case -1: {
                    if ((n2 & 1) != 0) return -1;
                    return 1;
                }
                case 2: {
                    if (n2 >= 64) return 0;
                    long l3 = 1 << n2;
                    return l3;
                }
                case -2: {
                    long l4;
                    if (n2 >= 64) return 0;
                    if ((n2 & 1) == 0) {
                        l4 = 1 << n2;
                        return l4;
                    }
                    l4 = - (1 << n2);
                    return l4;
                }
            }
            throw new AssertionError();
        }
        long l5 = 1;
        block11 : do {
            switch (n2) {
                default: {
                    l5 *= (n2 & 1) == 0 ? 1 : l2;
                    l2 *= l2;
                    n2 >>= 1;
                    continue block11;
                }
                case 0: {
                    return l5;
                }
                case 1: 
            }
            break;
        } while (true);
        return l5 * l2;
    }

    @GwtIncompatible(value="TODO")
    public static long sqrt(long l2, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", l2);
        if (LongMath.fitsInInt(l2)) {
            return IntMath.sqrt((int)l2, roundingMode);
        }
        long l3 = (long)Math.sqrt(l2);
        long l4 = l3 * l3;
        switch (LongMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(l4 == l2);
                return l3;
            }
            case 2: 
            case 3: {
                if (l2 >= l4) return l3;
                return l3 - 1;
            }
            case 4: 
            case 5: {
                if (l2 <= l4) return l3;
                return l3 + 1;
            }
            case 6: 
            case 7: 
            case 8: {
                long l5 = l3 - (long)(l2 < l4) ? 1 : 0;
                long l6 = l5 * l5 + l5;
                return l5 + (long)LongMath.lessThanBranchFree(l6, l2);
            }
        }
        throw new AssertionError();
    }

    /*
     * Unable to fully structure code
     */
    @GwtIncompatible(value="TODO")
    public static long divide(long var0, long var2_1, RoundingMode var4_2) {
        Preconditions.checkNotNull((Object)var4_2);
        var5_3 = var0 / var2_1;
        var7_4 = var0 - var2_1 * var5_3;
        if (var7_4 == 0) {
            return var5_3;
        }
        var9_5 = 1 | (int)((var0 ^ var2_1) >> 63);
        switch (LongMath$1.$SwitchMap$java$math$RoundingMode[var4_2.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(var7_4 == 0);
            }
            case 2: {
                var10_6 = false;
                ** break;
            }
            case 4: {
                var10_6 = true;
                ** break;
            }
            case 5: {
                var10_6 = var9_5 > 0;
                ** break;
            }
            case 3: {
                var10_6 = var9_5 < 0;
                ** break;
            }
            case 6: 
            case 7: 
            case 8: {
                var11_7 = Math.abs(var7_4);
                var13_8 = var11_7 - (Math.abs(var2_1) - var11_7);
                if (var13_8 == 0) {
                    var10_6 = var4_2 == RoundingMode.HALF_UP | var4_2 == RoundingMode.HALF_EVEN & (var5_3 & 1) != 0;
                    ** break;
                }
                var10_6 = var13_8 > 0;
                ** break;
            }
        }
        throw new AssertionError();
lbl31: // 6 sources:
        if (var10_6) {
            v0 = var5_3 + (long)var9_5;
            return v0;
        }
        v0 = var5_3;
        return v0;
    }

    @GwtIncompatible(value="TODO")
    public static int mod(long l2, int n2) {
        return (int)LongMath.mod(l2, (long)n2);
    }

    @GwtIncompatible(value="TODO")
    public static long mod(long l2, long l3) {
        long l4;
        if (l3 <= 0) {
            throw new ArithmeticException("Modulus must be positive");
        }
        long l5 = l2 % l3;
        if (l5 >= 0) {
            l4 = l5;
            return l4;
        }
        l4 = l5 + l3;
        return l4;
    }

    public static long gcd(long l2, long l3) {
        MathPreconditions.checkNonNegative("a", l2);
        MathPreconditions.checkNonNegative("b", l3);
        if (l2 == 0) {
            return l3;
        }
        if (l3 == 0) {
            return l2;
        }
        int n2 = Long.numberOfTrailingZeros(l2);
        l2 >>= n2;
        int n3 = Long.numberOfTrailingZeros(l3);
        l3 >>= n3;
        while (l2 != l3) {
            long l4 = l2 - l3;
            long l5 = l4 & l4 >> 63;
            l2 = l4 - l5 - l5;
            l3 += l5;
            l2 >>= Long.numberOfTrailingZeros(l2);
        }
        return l2 << Math.min(n2, n3);
    }

    @GwtIncompatible(value="TODO")
    public static long checkedAdd(long l2, long l3) {
        long l4 = l2 + l3;
        MathPreconditions.checkNoOverflow((l2 ^ l3) < 0 | (l2 ^ l4) >= 0);
        return l4;
    }

    @GwtIncompatible(value="TODO")
    public static long checkedSubtract(long l2, long l3) {
        long l4 = l2 - l3;
        MathPreconditions.checkNoOverflow((l2 ^ l3) >= 0 | (l2 ^ l4) >= 0);
        return l4;
    }

    @GwtIncompatible(value="TODO")
    public static long checkedMultiply(long l2, long l3) {
        int n2 = Long.numberOfLeadingZeros(l2) + Long.numberOfLeadingZeros(l2 ^ -1) + Long.numberOfLeadingZeros(l3) + Long.numberOfLeadingZeros(l3 ^ -1);
        if (n2 > 65) {
            return l2 * l3;
        }
        MathPreconditions.checkNoOverflow(n2 >= 64);
        MathPreconditions.checkNoOverflow(l2 >= 0 | l3 != Long.MIN_VALUE);
        long l4 = l2 * l3;
        MathPreconditions.checkNoOverflow(l2 == 0 || l4 / l2 == l3);
        return l4;
    }

    @GwtIncompatible(value="TODO")
    public static long checkedPow(long l2, int n2) {
        MathPreconditions.checkNonNegative("exponent", n2);
        if (l2 >= -2 & l2 <= 2) {
            switch ((int)l2) {
                case 0: {
                    if (n2 != 0) return 0;
                    return 1;
                }
                case 1: {
                    return 1;
                }
                case -1: {
                    if ((n2 & 1) != 0) return -1;
                    return 1;
                }
                case 2: {
                    MathPreconditions.checkNoOverflow(n2 < 63);
                    return 1 << n2;
                }
                case -2: {
                    long l3;
                    MathPreconditions.checkNoOverflow(n2 < 64);
                    if ((n2 & 1) == 0) {
                        l3 = 1 << n2;
                        return l3;
                    }
                    l3 = -1 << n2;
                    return l3;
                }
            }
            throw new AssertionError();
        }
        long l4 = 1;
        block11 : do {
            switch (n2) {
                default: {
                    if ((n2 & 1) != 0) {
                        l4 = LongMath.checkedMultiply(l4, l2);
                    }
                    if ((n2 >>= 1) <= 0) continue block11;
                    MathPreconditions.checkNoOverflow(-3037000499L <= l2 && l2 <= 3037000499L);
                    l2 *= l2;
                    continue block11;
                }
                case 0: {
                    return l4;
                }
                case 1: 
            }
            break;
        } while (true);
        return LongMath.checkedMultiply(l4, l2);
    }

    @GwtIncompatible(value="TODO")
    public static long factorial(int n2) {
        MathPreconditions.checkNonNegative("n", n2);
        if (n2 >= factorials.length) return Long.MAX_VALUE;
        long l2 = factorials[n2];
        return l2;
    }

    public static long binomial(int n2, int n3) {
        MathPreconditions.checkNonNegative("n", n2);
        MathPreconditions.checkNonNegative("k", n3);
        Preconditions.checkArgument(n3 <= n2, "k (%s) > n (%s)", n3, n2);
        if (n3 > n2 >> 1) {
            n3 = n2 - n3;
        }
        switch (n3) {
            case 0: {
                return 1;
            }
            case 1: {
                return n2;
            }
        }
        if (n2 < factorials.length) {
            return factorials[n2] / (factorials[n3] * factorials[n2 - n3]);
        }
        if (n3 >= biggestBinomials.length) return Long.MAX_VALUE;
        if (n2 > biggestBinomials[n3]) {
            return Long.MAX_VALUE;
        }
        if (n3 < biggestSimpleBinomials.length && n2 <= biggestSimpleBinomials[n3]) {
            long l2 = n2--;
            int n4 = 2;
            while (n4 <= n3) {
                l2 *= (long)n2;
                l2 /= (long)n4;
                --n2;
                ++n4;
            }
            return l2;
        }
        int n5 = LongMath.log2(n2, RoundingMode.CEILING);
        long l3 = 1;
        long l4 = n2--;
        long l5 = 1;
        int n6 = n5;
        int n7 = 2;
        while (n7 <= n3) {
            if (n6 + n5 < 63) {
                l4 *= (long)n2;
                l5 *= (long)n7;
                n6 += n5;
            } else {
                l3 = LongMath.multiplyFraction(l3, l4, l5);
                l4 = n2;
                l5 = n7;
                n6 = n5;
            }
            ++n7;
            --n2;
        }
        return LongMath.multiplyFraction(l3, l4, l5);
    }

    static long multiplyFraction(long l2, long l3, long l4) {
        if (l2 == 1) {
            return l3 / l4;
        }
        long l5 = LongMath.gcd(l2, l4);
        return (l2 /= l5) * (l3 / (l4 /= l5));
    }

    static boolean fitsInInt(long l2) {
        if ((long)((int)l2) != l2) return false;
        return true;
    }

    public static long mean(long l2, long l3) {
        return (l2 & l3) + ((l2 ^ l3) >> 1);
    }

    @GoogleInternal
    @GwtIncompatible(value="TODO")
    public static boolean isPrime(long l2) {
        long[] arrl;
        block9 : {
            if (l2 < 2) {
                MathPreconditions.checkNonNegative("n", l2);
                return false;
            }
            if (l2 == 2) return true;
            if (l2 == 3) return true;
            if (l2 == 5) return true;
            if (l2 == 7) return true;
            if (l2 == 11) return true;
            if (l2 == 13) {
                return true;
            }
            int n2 = 527816573;
            if ((n2 & 1 << (int)(l2 % 30)) != 0) {
                return false;
            }
            if (l2 % 7 == 0) return false;
            if (l2 % 11 == 0) return false;
            if (l2 % 13 == 0) {
                return false;
            }
            if (l2 < 289) {
                return true;
            }
            long[][] arrl2 = millerRabinBaseSets;
            int n3 = arrl2.length;
            int n4 = 0;
            while (n4 < n3) {
                arrl = arrl2[n4];
                if (l2 > arrl[0]) {
                    ++n4;
                    continue;
                }
                break block9;
            }
            throw new AssertionError();
        }
        int n5 = 1;
        while (n5 < arrl.length) {
            if (!LongMath$MillerRabinTester.test(arrl[n5], l2)) {
                return false;
            }
            ++n5;
        }
        return true;
    }

    private LongMath() {
    }
}

