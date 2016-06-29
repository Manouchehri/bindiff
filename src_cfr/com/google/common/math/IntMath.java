/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath$1;
import com.google.common.math.LongMath;
import com.google.common.math.MathPreconditions;
import java.math.RoundingMode;

@GwtCompatible(emulated=1)
public final class IntMath {
    @VisibleForTesting
    static final int MAX_POWER_OF_SQRT2_UNSIGNED = -1257966797;
    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros = new byte[]{9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0, 0};
    @VisibleForTesting
    static final int[] powersOf10 = new int[]{1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, 1000000000};
    @VisibleForTesting
    static final int[] halfPowersOf10 = new int[]{3, 31, 316, 3162, 31622, 316227, 3162277, 31622776, 316227766, Integer.MAX_VALUE};
    @VisibleForTesting
    static final int FLOOR_SQRT_MAX_INT = 46340;
    private static final int[] factorials = new int[]{1, 1, 2, 6, 24, 120, 720, 5040, 40320, 362880, 3628800, 39916800, 479001600};
    @VisibleForTesting
    static int[] biggestBinomials = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, 65536, 2345, 477, 193, 110, 75, 58, 49, 43, 39, 37, 35, 34, 34, 33};

    public static boolean isPowerOfTwo(int n2) {
        boolean bl2;
        boolean bl3 = n2 > 0;
        if ((n2 & n2 - 1) == 0) {
            bl2 = true;
            return bl3 & bl2;
        }
        bl2 = false;
        return bl3 & bl2;
    }

    @VisibleForTesting
    static int lessThanBranchFree(int n2, int n3) {
        return ~ (~ (n2 - n3)) >>> 31;
    }

    public static int log2(int n2, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", n2);
        switch (IntMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(IntMath.isPowerOfTwo(n2));
            }
            case 2: 
            case 3: {
                return 31 - Integer.numberOfLeadingZeros(n2);
            }
            case 4: 
            case 5: {
                return 32 - Integer.numberOfLeadingZeros(n2 - 1);
            }
            case 6: 
            case 7: 
            case 8: {
                int n3 = Integer.numberOfLeadingZeros(n2);
                int n4 = -1257966797 >>> n3;
                int n5 = 31 - n3;
                return n5 + IntMath.lessThanBranchFree(n4, n2);
            }
        }
        throw new AssertionError();
    }

    @GwtIncompatible(value="need BigIntegerMath to adequately test")
    public static int log10(int n2, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", n2);
        int n3 = IntMath.log10Floor(n2);
        int n4 = powersOf10[n3];
        switch (IntMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(n2 == n4);
            }
            case 2: 
            case 3: {
                return n3;
            }
            case 4: 
            case 5: {
                return n3 + IntMath.lessThanBranchFree(n4, n2);
            }
            case 6: 
            case 7: 
            case 8: {
                return n3 + IntMath.lessThanBranchFree(halfPowersOf10[n3], n2);
            }
        }
        throw new AssertionError();
    }

    private static int log10Floor(int n2) {
        byte by2 = maxLog10ForLeadingZeros[Integer.numberOfLeadingZeros(n2)];
        return by2 - IntMath.lessThanBranchFree(n2, powersOf10[by2]);
    }

    @GwtIncompatible(value="failing tests")
    public static int pow(int n2, int n3) {
        MathPreconditions.checkNonNegative("exponent", n3);
        switch (n2) {
            case 0: {
                if (n3 != 0) return 0;
                return 1;
            }
            case 1: {
                return 1;
            }
            case -1: {
                if ((n3 & 1) != 0) return -1;
                return 1;
            }
            case 2: {
                if (n3 >= 32) return 0;
                int n4 = 1 << n3;
                return n4;
            }
            case -2: {
                int n5;
                if (n3 >= 32) return 0;
                if ((n3 & 1) == 0) {
                    n5 = 1 << n3;
                    return n5;
                }
                n5 = - (1 << n3);
                return n5;
            }
        }
        int n6 = 1;
        block11 : do {
            switch (n3) {
                default: {
                    n6 *= (n3 & 1) == 0 ? 1 : n2;
                    n2 *= n2;
                    n3 >>= 1;
                    continue block11;
                }
                case 0: {
                    return n6;
                }
                case 1: 
            }
            break;
        } while (true);
        return n2 * n6;
    }

    @GwtIncompatible(value="need BigIntegerMath to adequately test")
    public static int sqrt(int n2, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", n2);
        int n3 = IntMath.sqrtFloor(n2);
        switch (IntMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(n3 * n3 == n2);
            }
            case 2: 
            case 3: {
                return n3;
            }
            case 4: 
            case 5: {
                return n3 + IntMath.lessThanBranchFree(n3 * n3, n2);
            }
            case 6: 
            case 7: 
            case 8: {
                int n4 = n3 * n3 + n3;
                return n3 + IntMath.lessThanBranchFree(n4, n2);
            }
        }
        throw new AssertionError();
    }

    private static int sqrtFloor(int n2) {
        return (int)Math.sqrt(n2);
    }

    /*
     * Unable to fully structure code
     */
    public static int divide(int var0, int var1_1, RoundingMode var2_2) {
        Preconditions.checkNotNull((Object)var2_2);
        if (var1_1 == 0) {
            throw new ArithmeticException("/ by zero");
        }
        var3_3 = var0 / var1_1;
        var4_4 = var0 - var1_1 * var3_3;
        if (var4_4 == 0) {
            return var3_3;
        }
        var5_5 = 1 | (var0 ^ var1_1) >> 31;
        switch (IntMath$1.$SwitchMap$java$math$RoundingMode[var2_2.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(var4_4 == 0);
            }
            case 2: {
                var6_6 = false;
                ** break;
            }
            case 4: {
                var6_6 = true;
                ** break;
            }
            case 5: {
                var6_6 = var5_5 > 0;
                ** break;
            }
            case 3: {
                var6_6 = var5_5 < 0;
                ** break;
            }
            case 6: 
            case 7: 
            case 8: {
                var7_7 = Math.abs(var4_4);
                var8_8 = var7_7 - (Math.abs(var1_1) - var7_7);
                if (var8_8 == 0) {
                    var6_6 = var2_2 == RoundingMode.HALF_UP || (var2_2 == RoundingMode.HALF_EVEN & (var3_3 & 1) != 0) != false;
                    ** break;
                }
                var6_6 = var8_8 > 0;
                ** break;
            }
        }
        throw new AssertionError();
lbl33: // 6 sources:
        if (var6_6) {
            v0 = var3_3 + var5_5;
            return v0;
        }
        v0 = var3_3;
        return v0;
    }

    public static int mod(int n2, int n3) {
        int n4;
        if (n3 <= 0) {
            throw new ArithmeticException(new StringBuilder(31).append("Modulus ").append(n3).append(" must be > 0").toString());
        }
        int n5 = n2 % n3;
        if (n5 >= 0) {
            n4 = n5;
            return n4;
        }
        n4 = n5 + n3;
        return n4;
    }

    public static int gcd(int n2, int n3) {
        MathPreconditions.checkNonNegative("a", n2);
        MathPreconditions.checkNonNegative("b", n3);
        if (n2 == 0) {
            return n3;
        }
        if (n3 == 0) {
            return n2;
        }
        int n4 = Integer.numberOfTrailingZeros(n2);
        n2 >>= n4;
        int n5 = Integer.numberOfTrailingZeros(n3);
        n3 >>= n5;
        while (n2 != n3) {
            int n6 = n2 - n3;
            int n7 = n6 & n6 >> 31;
            n2 = n6 - n7 - n7;
            n3 += n7;
            n2 >>= Integer.numberOfTrailingZeros(n2);
        }
        return n2 << Math.min(n4, n5);
    }

    public static int checkedAdd(int n2, int n3) {
        long l2 = (long)n2 + (long)n3;
        MathPreconditions.checkNoOverflow(l2 == (long)((int)l2));
        return (int)l2;
    }

    public static int checkedSubtract(int n2, int n3) {
        long l2 = (long)n2 - (long)n3;
        MathPreconditions.checkNoOverflow(l2 == (long)((int)l2));
        return (int)l2;
    }

    public static int checkedMultiply(int n2, int n3) {
        long l2 = (long)n2 * (long)n3;
        MathPreconditions.checkNoOverflow(l2 == (long)((int)l2));
        return (int)l2;
    }

    public static int checkedPow(int n2, int n3) {
        MathPreconditions.checkNonNegative("exponent", n3);
        switch (n2) {
            case 0: {
                if (n3 != 0) return 0;
                return 1;
            }
            case 1: {
                return 1;
            }
            case -1: {
                if ((n3 & 1) != 0) return -1;
                return 1;
            }
            case 2: {
                MathPreconditions.checkNoOverflow(n3 < 31);
                return 1 << n3;
            }
            case -2: {
                int n4;
                MathPreconditions.checkNoOverflow(n3 < 32);
                if ((n3 & 1) == 0) {
                    n4 = 1 << n3;
                    return n4;
                }
                n4 = -1 << n3;
                return n4;
            }
        }
        int n5 = 1;
        block11 : do {
            switch (n3) {
                default: {
                    if ((n3 & 1) != 0) {
                        n5 = IntMath.checkedMultiply(n5, n2);
                    }
                    if ((n3 >>= 1) <= 0) continue block11;
                    MathPreconditions.checkNoOverflow(-46340 <= n2 & n2 <= 46340);
                    n2 *= n2;
                    continue block11;
                }
                case 0: {
                    return n5;
                }
                case 1: 
            }
            break;
        } while (true);
        return IntMath.checkedMultiply(n5, n2);
    }

    public static int factorial(int n2) {
        MathPreconditions.checkNonNegative("n", n2);
        if (n2 >= factorials.length) return Integer.MAX_VALUE;
        int n3 = factorials[n2];
        return n3;
    }

    @GwtIncompatible(value="need BigIntegerMath to adequately test")
    public static int binomial(int n2, int n3) {
        MathPreconditions.checkNonNegative("n", n2);
        MathPreconditions.checkNonNegative("k", n3);
        Preconditions.checkArgument(n3 <= n2, "k (%s) > n (%s)", n3, n2);
        if (n3 > n2 >> 1) {
            n3 = n2 - n3;
        }
        if (n3 >= biggestBinomials.length) return Integer.MAX_VALUE;
        if (n2 > biggestBinomials[n3]) {
            return Integer.MAX_VALUE;
        }
        switch (n3) {
            case 0: {
                return 1;
            }
            case 1: {
                return n2;
            }
        }
        long l2 = 1;
        int n4 = 0;
        while (n4 < n3) {
            l2 *= (long)(n2 - n4);
            l2 /= (long)(n4 + 1);
            ++n4;
        }
        return (int)l2;
    }

    public static int mean(int n2, int n3) {
        return (n2 & n3) + ((n2 ^ n3) >> 1);
    }

    @GoogleInternal
    @GwtIncompatible(value="TODO")
    public static boolean isPrime(int n2) {
        return LongMath.isPrime(n2);
    }

    private IntMath() {
    }
}

