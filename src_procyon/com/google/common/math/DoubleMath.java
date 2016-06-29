package com.google.common.math;

import com.google.common.annotations.*;
import java.math.*;
import com.google.common.base.*;
import com.google.common.primitives.*;
import java.util.*;

@GwtCompatible(emulated = true)
public final class DoubleMath
{
    private static final double MIN_INT_AS_DOUBLE = -2.147483648E9;
    private static final double MAX_INT_AS_DOUBLE = 2.147483647E9;
    private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18;
    private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18;
    private static final double LN_2;
    @VisibleForTesting
    static final int MAX_FACTORIAL = 170;
    @VisibleForTesting
    static final double[] everySixteenthFactorial;
    
    @GwtIncompatible("#isMathematicalInteger, com.google.common.math.DoubleUtils")
    static double roundIntermediate(final double n, final RoundingMode roundingMode) {
        if (!DoubleUtils.isFinite(n)) {
            throw new ArithmeticException("input is infinite or NaN");
        }
        switch (DoubleMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(n));
                return n;
            }
            case 2: {
                if (n >= 0.0 || isMathematicalInteger(n)) {
                    return n;
                }
                return n - 1.0;
            }
            case 3: {
                if (n <= 0.0 || isMathematicalInteger(n)) {
                    return n;
                }
                return n + 1.0;
            }
            case 4: {
                return n;
            }
            case 5: {
                if (isMathematicalInteger(n)) {
                    return n;
                }
                return n + Math.copySign(1.0, n);
            }
            case 6: {
                return Math.rint(n);
            }
            case 7: {
                final double rint = Math.rint(n);
                if (Math.abs(n - rint) == 0.5) {
                    return n + Math.copySign(0.5, n);
                }
                return rint;
            }
            case 8: {
                final double rint2 = Math.rint(n);
                if (Math.abs(n - rint2) == 0.5) {
                    return n;
                }
                return rint2;
            }
            default: {
                throw new AssertionError();
            }
        }
    }
    
    @GwtIncompatible("#roundIntermediate")
    public static int roundToInt(final double n, final RoundingMode roundingMode) {
        final double roundIntermediate = roundIntermediate(n, roundingMode);
        MathPreconditions.checkInRange(roundIntermediate > -2.147483649E9 & roundIntermediate < 2.147483648E9);
        return (int)roundIntermediate;
    }
    
    @GwtIncompatible("#roundIntermediate")
    public static long roundToLong(final double n, final RoundingMode roundingMode) {
        final double roundIntermediate = roundIntermediate(n, roundingMode);
        MathPreconditions.checkInRange(-9.223372036854776E18 - roundIntermediate < 1.0 & roundIntermediate < 9.223372036854776E18);
        return (long)roundIntermediate;
    }
    
    @GwtIncompatible("#roundIntermediate, java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static BigInteger roundToBigInteger(double roundIntermediate, final RoundingMode roundingMode) {
        roundIntermediate = roundIntermediate(roundIntermediate, roundingMode);
        if (-9.223372036854776E18 - roundIntermediate < 1.0 & roundIntermediate < 9.223372036854776E18) {
            return BigInteger.valueOf((long)roundIntermediate);
        }
        final BigInteger shiftLeft = BigInteger.valueOf(DoubleUtils.getSignificand(roundIntermediate)).shiftLeft(Math.getExponent(roundIntermediate) - 52);
        return (roundIntermediate < 0.0) ? shiftLeft.negate() : shiftLeft;
    }
    
    @GwtIncompatible("com.google.common.math.DoubleUtils")
    public static boolean isPowerOfTwo(final double n) {
        return n > 0.0 && DoubleUtils.isFinite(n) && LongMath.isPowerOfTwo(DoubleUtils.getSignificand(n));
    }
    
    public static double log2(final double n) {
        return Math.log(n) / DoubleMath.LN_2;
    }
    
    @GwtIncompatible("java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static int log2(final double n, final RoundingMode roundingMode) {
        Preconditions.checkArgument(n > 0.0 && DoubleUtils.isFinite(n), (Object)"x must be positive and finite");
        final int exponent = Math.getExponent(n);
        if (!DoubleUtils.isNormal(n)) {
            return log2(n * 4.503599627370496E15, roundingMode) - 52;
        }
        boolean b = false;
        switch (DoubleMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(n));
            }
            case 2: {
                b = false;
                break;
            }
            case 3: {
                b = !isPowerOfTwo(n);
                break;
            }
            case 4: {
                b = (exponent < 0 & !isPowerOfTwo(n));
                break;
            }
            case 5: {
                b = (exponent >= 0 & !isPowerOfTwo(n));
                break;
            }
            case 6:
            case 7:
            case 8: {
                final double scaleNormalize = DoubleUtils.scaleNormalize(n);
                b = (scaleNormalize * scaleNormalize > 2.0);
                break;
            }
            default: {
                throw new AssertionError();
            }
        }
        return b ? (exponent + 1) : exponent;
    }
    
    @GwtIncompatible("java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
    public static boolean isMathematicalInteger(final double n) {
        return DoubleUtils.isFinite(n) && (n == 0.0 || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(n)) <= Math.getExponent(n));
    }
    
    public static double factorial(final int n) {
        MathPreconditions.checkNonNegative("n", n);
        if (n > 170) {
            return Double.POSITIVE_INFINITY;
        }
        double n2 = 1.0;
        for (int i = 1 + (n & 0xFFFFFFF0); i <= n; ++i) {
            n2 *= i;
        }
        return n2 * DoubleMath.everySixteenthFactorial[n >> 4];
    }
    
    public static boolean fuzzyEquals(final double n, final double n2, final double n3) {
        MathPreconditions.checkNonNegative("tolerance", n3);
        return Math.copySign(n - n2, 1.0) <= n3 || n == n2 || (Double.isNaN(n) && Double.isNaN(n2));
    }
    
    public static int fuzzyCompare(final double n, final double n2, final double n3) {
        if (fuzzyEquals(n, n2, n3)) {
            return 0;
        }
        if (n < n2) {
            return -1;
        }
        if (n > n2) {
            return 1;
        }
        return Booleans.compare(Double.isNaN(n), Double.isNaN(n2));
    }
    
    @GwtIncompatible("com.google.common.math.DoubleUtils")
    public static double mean(final double... array) {
        Preconditions.checkArgument(array.length > 0, (Object)"Cannot take mean of 0 values");
        long n = 1L;
        double checkFinite = checkFinite(array[0]);
        for (int i = 1; i < array.length; ++i) {
            checkFinite(array[i]);
            ++n;
            checkFinite += (array[i] - checkFinite) / n;
        }
        return checkFinite;
    }
    
    public static double mean(final int... array) {
        Preconditions.checkArgument(array.length > 0, (Object)"Cannot take mean of 0 values");
        long n = 0L;
        for (int i = 0; i < array.length; ++i) {
            n += array[i];
        }
        return n / array.length;
    }
    
    public static double mean(final long... array) {
        Preconditions.checkArgument(array.length > 0, (Object)"Cannot take mean of 0 values");
        long n = 1L;
        double n2 = array[0];
        for (int i = 1; i < array.length; ++i) {
            ++n;
            n2 += (array[i] - n2) / n;
        }
        return n2;
    }
    
    @GwtIncompatible("com.google.common.math.DoubleUtils")
    public static double mean(final Iterable iterable) {
        return mean(iterable.iterator());
    }
    
    @GwtIncompatible("com.google.common.math.DoubleUtils")
    public static double mean(final Iterator iterator) {
        Preconditions.checkArgument(iterator.hasNext(), (Object)"Cannot take mean of 0 values");
        long n = 1L;
        double checkFinite = checkFinite(iterator.next().doubleValue());
        while (iterator.hasNext()) {
            final double checkFinite2 = checkFinite(iterator.next().doubleValue());
            ++n;
            checkFinite += (checkFinite2 - checkFinite) / n;
        }
        return checkFinite;
    }
    
    @GwtIncompatible("com.google.common.math.DoubleUtils")
    private static double checkFinite(final double n) {
        Preconditions.checkArgument(DoubleUtils.isFinite(n));
        return n;
    }
    
    static {
        LN_2 = Math.log(2.0);
        everySixteenthFactorial = new double[] { 1.0, 2.0922789888E13, 2.631308369336935E35, 1.2413915592536073E61, 1.2688693218588417E89, 7.156945704626381E118, 9.916779348709496E149, 1.974506857221074E182, 3.856204823625804E215, 5.5502938327393044E249, 4.7147236359920616E284 };
    }
}
