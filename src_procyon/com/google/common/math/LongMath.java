package com.google.common.math;

import java.math.*;
import com.google.common.base.*;
import com.google.common.annotations.*;

@GwtCompatible(emulated = true)
public final class LongMath
{
    @VisibleForTesting
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = -5402926248376769404L;
    @VisibleForTesting
    static final byte[] maxLog10ForLeadingZeros;
    @GwtIncompatible("TODO")
    @VisibleForTesting
    static final long[] powersOf10;
    @GwtIncompatible("TODO")
    @VisibleForTesting
    static final long[] halfPowersOf10;
    @VisibleForTesting
    static final long FLOOR_SQRT_MAX_LONG = 3037000499L;
    static final long[] factorials;
    static final int[] biggestBinomials;
    @VisibleForTesting
    static final int[] biggestSimpleBinomials;
    private static final long[][] millerRabinBaseSets;
    
    public static boolean isPowerOfTwo(final long n) {
        return n > 0L & (n & n - 1L) == 0x0L;
    }
    
    @VisibleForTesting
    static int lessThanBranchFree(final long n, final long n2) {
        return (int)(~(~(n - n2)) >>> 63);
    }
    
    public static int log2(final long n, final RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", n);
        switch (LongMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(n));
            }
            case 2:
            case 3: {
                return 63 - Long.numberOfLeadingZeros(n);
            }
            case 4:
            case 5: {
                return 64 - Long.numberOfLeadingZeros(n - 1L);
            }
            case 6:
            case 7:
            case 8: {
                final int numberOfLeadingZeros = Long.numberOfLeadingZeros(n);
                return 63 - numberOfLeadingZeros + lessThanBranchFree(-5402926248376769404L >>> numberOfLeadingZeros, n);
            }
            default: {
                throw new AssertionError((Object)"impossible");
            }
        }
    }
    
    @GwtIncompatible("TODO")
    public static int log10(final long n, final RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", n);
        final int log10Floor = log10Floor(n);
        final long n2 = LongMath.powersOf10[log10Floor];
        switch (LongMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(n == n2);
            }
            case 2:
            case 3: {
                return log10Floor;
            }
            case 4:
            case 5: {
                return log10Floor + lessThanBranchFree(n2, n);
            }
            case 6:
            case 7:
            case 8: {
                return log10Floor + lessThanBranchFree(LongMath.halfPowersOf10[log10Floor], n);
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    @GwtIncompatible("TODO")
    static int log10Floor(final long n) {
        final byte b = LongMath.maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(n)];
        return b - lessThanBranchFree(n, LongMath.powersOf10[b]);
    }
    
    @GwtIncompatible("TODO")
    public static long pow(long n, int n2) {
        MathPreconditions.checkNonNegative("exponent", n2);
        if (-2L <= n && n <= 2L) {
            switch ((int)n) {
                case 0: {
                    return (n2 == 0) ? 1 : 0;
                }
                case 1: {
                    return 1L;
                }
                case -1: {
                    return ((n2 & 0x1) == 0x0) ? 1L : -1L;
                }
                case 2: {
                    return (n2 < 64) ? (1L << n2) : 0L;
                }
                case -2: {
                    if (n2 < 64) {
                        return ((n2 & 0x1) == 0x0) ? (1L << n2) : (-(1L << n2));
                    }
                    return 0L;
                }
                default: {
                    throw new AssertionError();
                }
            }
        }
        else {
            long n3 = 1L;
            while (true) {
                switch (n2) {
                    case 0: {
                        return n3;
                    }
                    case 1: {
                        return n3 * n;
                    }
                    default: {
                        n3 *= (((n2 & 0x1) == 0x0) ? 1L : n);
                        n *= n;
                        n2 >>= 1;
                        continue;
                    }
                }
            }
        }
    }
    
    @GwtIncompatible("TODO")
    public static long sqrt(final long n, final RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", n);
        if (fitsInInt(n)) {
            return IntMath.sqrt((int)n, roundingMode);
        }
        final long n2 = (long)Math.sqrt(n);
        final long n3 = n2 * n2;
        switch (LongMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(n3 == n);
                return n2;
            }
            case 2:
            case 3: {
                if (n < n3) {
                    return n2 - 1L;
                }
                return n2;
            }
            case 4:
            case 5: {
                if (n > n3) {
                    return n2 + 1L;
                }
                return n2;
            }
            case 6:
            case 7:
            case 8: {
                final long n4 = n2 - ((n < n3) ? 1 : 0);
                return n4 + lessThanBranchFree(n4 * n4 + n4, n);
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    @GwtIncompatible("TODO")
    public static long divide(final long n, final long n2, final RoundingMode roundingMode) {
        Preconditions.checkNotNull(roundingMode);
        final long n3 = n / n2;
        final long n4 = n - n2 * n3;
        if (n4 == 0L) {
            return n3;
        }
        final int n5 = 0x1 | (int)((n ^ n2) >> 63);
        boolean b = false;
        switch (LongMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(n4 == 0L);
            }
            case 2: {
                b = false;
                break;
            }
            case 4: {
                b = true;
                break;
            }
            case 5: {
                b = (n5 > 0);
                break;
            }
            case 3: {
                b = (n5 < 0);
                break;
            }
            case 6:
            case 7:
            case 8: {
                final long abs = Math.abs(n4);
                final long n6 = abs - (Math.abs(n2) - abs);
                if (n6 == 0L) {
                    b = (roundingMode == RoundingMode.HALF_UP | (roundingMode == RoundingMode.HALF_EVEN & (n3 & 0x1L) != 0x0L));
                    break;
                }
                b = (n6 > 0L);
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
        return b ? (n3 + n5) : n3;
    }
    
    @GwtIncompatible("TODO")
    public static int mod(final long n, final int n2) {
        return (int)mod(n, (long)n2);
    }
    
    @GwtIncompatible("TODO")
    public static long mod(final long n, final long n2) {
        if (n2 <= 0L) {
            throw new ArithmeticException("Modulus must be positive");
        }
        final long n3 = n % n2;
        return (n3 >= 0L) ? n3 : (n3 + n2);
    }
    
    public static long gcd(long n, long n2) {
        MathPreconditions.checkNonNegative("a", n);
        MathPreconditions.checkNonNegative("b", n2);
        if (n == 0L) {
            return n2;
        }
        if (n2 == 0L) {
            return n;
        }
        final int numberOfTrailingZeros = Long.numberOfTrailingZeros(n);
        n >>= numberOfTrailingZeros;
        final int numberOfTrailingZeros2 = Long.numberOfTrailingZeros(n2);
        long n3;
        long n4;
        for (n2 >>= numberOfTrailingZeros2; n != n2; n = n3 - n4 - n4, n2 += n4, n >>= Long.numberOfTrailingZeros(n)) {
            n3 = n - n2;
            n4 = (n3 & n3 >> 63);
        }
        return n << Math.min(numberOfTrailingZeros, numberOfTrailingZeros2);
    }
    
    @GwtIncompatible("TODO")
    public static long checkedAdd(final long n, final long n2) {
        final long n3 = n + n2;
        MathPreconditions.checkNoOverflow((n ^ n2) < 0L | (n ^ n3) >= 0L);
        return n3;
    }
    
    @GwtIncompatible("TODO")
    public static long checkedSubtract(final long n, final long n2) {
        final long n3 = n - n2;
        MathPreconditions.checkNoOverflow((n ^ n2) >= 0L | (n ^ n3) >= 0L);
        return n3;
    }
    
    @GwtIncompatible("TODO")
    public static long checkedMultiply(final long n, final long n2) {
        final int n3 = Long.numberOfLeadingZeros(n) + Long.numberOfLeadingZeros(~n) + Long.numberOfLeadingZeros(n2) + Long.numberOfLeadingZeros(~n2);
        if (n3 > 65) {
            return n * n2;
        }
        MathPreconditions.checkNoOverflow(n3 >= 64);
        MathPreconditions.checkNoOverflow(n >= 0L | n2 != Long.MIN_VALUE);
        final long n4 = n * n2;
        MathPreconditions.checkNoOverflow(n == 0L || n4 / n == n2);
        return n4;
    }
    
    @GwtIncompatible("TODO")
    public static long checkedPow(long n, int n2) {
        MathPreconditions.checkNonNegative("exponent", n2);
        if (n >= -2L & n <= 2L) {
            switch ((int)n) {
                case 0: {
                    return (n2 == 0) ? 1 : 0;
                }
                case 1: {
                    return 1L;
                }
                case -1: {
                    return ((n2 & 0x1) == 0x0) ? 1L : -1L;
                }
                case 2: {
                    MathPreconditions.checkNoOverflow(n2 < 63);
                    return 1L << n2;
                }
                case -2: {
                    MathPreconditions.checkNoOverflow(n2 < 64);
                    return ((n2 & 0x1) == 0x0) ? (1L << n2) : (-1L << n2);
                }
                default: {
                    throw new AssertionError();
                }
            }
        }
        else {
            long checkedMultiply = 1L;
            while (true) {
                switch (n2) {
                    case 0: {
                        return checkedMultiply;
                    }
                    case 1: {
                        return checkedMultiply(checkedMultiply, n);
                    }
                    default: {
                        if ((n2 & 0x1) != 0x0) {
                            checkedMultiply = checkedMultiply(checkedMultiply, n);
                        }
                        n2 >>= 1;
                        if (n2 > 0) {
                            MathPreconditions.checkNoOverflow(-3037000499L <= n && n <= 3037000499L);
                            n *= n;
                            continue;
                        }
                        continue;
                    }
                }
            }
        }
    }
    
    @GwtIncompatible("TODO")
    public static long factorial(final int n) {
        MathPreconditions.checkNonNegative("n", n);
        return (n < LongMath.factorials.length) ? LongMath.factorials[n] : Long.MAX_VALUE;
    }
    
    public static long binomial(int n, int n2) {
        MathPreconditions.checkNonNegative("n", n);
        MathPreconditions.checkNonNegative("k", n2);
        Preconditions.checkArgument(n2 <= n, "k (%s) > n (%s)", n2, n);
        if (n2 > n >> 1) {
            n2 = n - n2;
        }
        switch (n2) {
            case 0: {
                return 1L;
            }
            case 1: {
                return n;
            }
            default: {
                if (n < LongMath.factorials.length) {
                    return LongMath.factorials[n] / (LongMath.factorials[n2] * LongMath.factorials[n - n2]);
                }
                if (n2 >= LongMath.biggestBinomials.length || n > LongMath.biggestBinomials[n2]) {
                    return Long.MAX_VALUE;
                }
                if (n2 < LongMath.biggestSimpleBinomials.length && n <= LongMath.biggestSimpleBinomials[n2]) {
                    long n3 = n--;
                    for (int i = 2; i <= n2; ++i) {
                        n3 = n3 * n / i;
                        --n;
                    }
                    return n3;
                }
                final int log2 = log2(n, RoundingMode.CEILING);
                long multiplyFraction = 1L;
                long n4 = n--;
                long n5 = 1L;
                int n6 = log2;
                for (int j = 2; j <= n2; ++j, --n) {
                    if (n6 + log2 < 63) {
                        n4 *= n;
                        n5 *= j;
                        n6 += log2;
                    }
                    else {
                        multiplyFraction = multiplyFraction(multiplyFraction, n4, n5);
                        n4 = n;
                        n5 = j;
                        n6 = log2;
                    }
                }
                return multiplyFraction(multiplyFraction, n4, n5);
            }
        }
    }
    
    static long multiplyFraction(long n, final long n2, long n3) {
        if (n == 1L) {
            return n2 / n3;
        }
        final long gcd = gcd(n, n3);
        n /= gcd;
        n3 /= gcd;
        return n * (n2 / n3);
    }
    
    static boolean fitsInInt(final long n) {
        return (int)n == n;
    }
    
    public static long mean(final long n, final long n2) {
        return (n & n2) + ((n ^ n2) >> 1);
    }
    
    @GoogleInternal
    @GwtIncompatible("TODO")
    public static boolean isPrime(final long n) {
        if (n < 2L) {
            MathPreconditions.checkNonNegative("n", n);
            return false;
        }
        if (n == 2L || n == 3L || n == 5L || n == 7L || n == 11L || n == 13L) {
            return true;
        }
        if ((0x1F75D77D & 1 << (int)(n % 30L)) != 0x0) {
            return false;
        }
        if (n % 7L == 0L || n % 11L == 0L || n % 13L == 0L) {
            return false;
        }
        if (n < 289L) {
            return true;
        }
        for (final long[] array : LongMath.millerRabinBaseSets) {
            if (n <= array[0]) {
                for (int j = 1; j < array.length; ++j) {
                    if (!LongMath$MillerRabinTester.test(array[j], n)) {
                        return false;
                    }
                }
                return true;
            }
        }
        throw new AssertionError();
    }
    
    static {
        maxLog10ForLeadingZeros = new byte[] { 19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 0, 0, 0 };
        powersOf10 = new long[] { 1L, 10L, 100L, 1000L, 10000L, 100000L, 1000000L, 10000000L, 100000000L, 1000000000L, 10000000000L, 100000000000L, 1000000000000L, 10000000000000L, 100000000000000L, 1000000000000000L, 10000000000000000L, 100000000000000000L, 1000000000000000000L };
        halfPowersOf10 = new long[] { 3L, 31L, 316L, 3162L, 31622L, 316227L, 3162277L, 31622776L, 316227766L, 3162277660L, 31622776601L, 316227766016L, 3162277660168L, 31622776601683L, 316227766016837L, 3162277660168379L, 31622776601683793L, 316227766016837933L, 3162277660168379331L };
        factorials = new long[] { 1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 362880L, 3628800L, 39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L, 20922789888000L, 355687428096000L, 6402373705728000L, 121645100408832000L, 2432902008176640000L };
        biggestBinomials = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 3810779, 121977, 16175, 4337, 1733, 887, 534, 361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 66, 66, 66, 66 };
        biggestSimpleBinomials = new int[] { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 2642246, 86251, 11724, 3218, 1313, 684, 419, 287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 61 };
        millerRabinBaseSets = new long[][] { { 291830L, 126401071349994536L }, { 885594168L, 725270293939359937L, 3569819667048198375L }, { 273919523040L, 15L, 7363882082L, 992620450144556L }, { 47636622961200L, 2L, 2570940L, 211991001L, 3749873356L }, { 7999252175582850L, 2L, 4130806001517L, 149795463772692060L, 186635894390467037L, 3967304179347715805L }, { 585226005592931976L, 2L, 123635709730000L, 9233062284813009L, 43835965440333360L, 761179012939631437L, 1263739024124850375L }, { Long.MAX_VALUE, 2L, 325L, 9375L, 28178L, 450775L, 9780504L, 1795265022L } };
    }
}
