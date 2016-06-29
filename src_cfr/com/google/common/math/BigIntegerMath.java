/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.BigIntegerMath$1;
import com.google.common.math.DoubleMath;
import com.google.common.math.DoubleUtils;
import com.google.common.math.IntMath;
import com.google.common.math.LongMath;
import com.google.common.math.MathPreconditions;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

@GwtCompatible(emulated=1)
public final class BigIntegerMath {
    @VisibleForTesting
    static final int SQRT2_PRECOMPUTE_THRESHOLD = 256;
    @VisibleForTesting
    static final BigInteger SQRT2_PRECOMPUTED_BITS = new BigInteger("16a09e667f3bcc908b2fb1366ea957d3e3adec17512775099da2f590b0667322a", 16);
    private static final double LN_10 = Math.log(10.0);
    private static final double LN_2 = Math.log(2.0);

    public static boolean isPowerOfTwo(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        if (bigInteger.signum() <= 0) return false;
        if (bigInteger.getLowestSetBit() != bigInteger.bitLength() - 1) return false;
        return true;
    }

    public static int log2(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", (BigInteger)Preconditions.checkNotNull(bigInteger));
        int n2 = bigInteger.bitLength() - 1;
        switch (BigIntegerMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(BigIntegerMath.isPowerOfTwo(bigInteger));
            }
            case 2: 
            case 3: {
                return n2;
            }
            case 4: 
            case 5: {
                int n3;
                if (BigIntegerMath.isPowerOfTwo(bigInteger)) {
                    n3 = n2;
                    return n3;
                }
                n3 = n2 + 1;
                return n3;
            }
            case 6: 
            case 7: 
            case 8: {
                int n4;
                if (n2 < 256) {
                    BigInteger bigInteger2 = SQRT2_PRECOMPUTED_BITS.shiftRight(256 - n2);
                    if (bigInteger.compareTo(bigInteger2) > 0) return n2 + 1;
                    return n2;
                }
                BigInteger bigInteger3 = bigInteger.pow(2);
                int n5 = bigInteger3.bitLength() - 1;
                if (n5 < 2 * n2 + 1) {
                    n4 = n2;
                    return n4;
                }
                n4 = n2 + 1;
                return n4;
            }
        }
        throw new AssertionError();
    }

    @GwtIncompatible(value="TODO")
    public static int log10(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.checkPositive("x", bigInteger);
        if (BigIntegerMath.fitsInLong(bigInteger)) {
            return LongMath.log10(bigInteger.longValue(), roundingMode);
        }
        int n2 = (int)((double)BigIntegerMath.log2(bigInteger, RoundingMode.FLOOR) * LN_2 / LN_10);
        BigInteger bigInteger2 = BigInteger.TEN.pow(n2);
        int n3 = bigInteger2.compareTo(bigInteger);
        if (n3 > 0) {
            do {
                --n2;
            } while ((n3 = (bigInteger2 = bigInteger2.divide(BigInteger.TEN)).compareTo(bigInteger)) > 0);
        } else {
            BigInteger bigInteger3 = BigInteger.TEN.multiply(bigInteger2);
            int n4 = bigInteger3.compareTo(bigInteger);
            while (n4 <= 0) {
                ++n2;
                bigInteger2 = bigInteger3;
                n3 = n4;
                bigInteger3 = BigInteger.TEN.multiply(bigInteger2);
                n4 = bigInteger3.compareTo(bigInteger);
            }
        }
        int n5 = n2;
        BigInteger bigInteger4 = bigInteger2;
        int n6 = n3;
        switch (BigIntegerMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(n6 == 0);
            }
            case 2: 
            case 3: {
                return n5;
            }
            case 4: 
            case 5: {
                int n7;
                if (bigInteger4.equals(bigInteger)) {
                    n7 = n5;
                    return n7;
                }
                n7 = n5 + 1;
                return n7;
            }
            case 6: 
            case 7: 
            case 8: {
                int n8;
                BigInteger bigInteger5 = bigInteger.pow(2);
                BigInteger bigInteger6 = bigInteger4.pow(2).multiply(BigInteger.TEN);
                if (bigInteger5.compareTo(bigInteger6) <= 0) {
                    n8 = n5;
                    return n8;
                }
                n8 = n5 + 1;
                return n8;
            }
        }
        throw new AssertionError();
    }

    @GwtIncompatible(value="TODO")
    public static BigInteger sqrt(BigInteger bigInteger, RoundingMode roundingMode) {
        MathPreconditions.checkNonNegative("x", bigInteger);
        if (BigIntegerMath.fitsInLong(bigInteger)) {
            return BigInteger.valueOf(LongMath.sqrt(bigInteger.longValue(), roundingMode));
        }
        BigInteger bigInteger2 = BigIntegerMath.sqrtFloor(bigInteger);
        switch (BigIntegerMath$1.$SwitchMap$java$math$RoundingMode[roundingMode.ordinal()]) {
            case 1: {
                MathPreconditions.checkRoundingUnnecessary(bigInteger2.pow(2).equals(bigInteger));
            }
            case 2: 
            case 3: {
                return bigInteger2;
            }
            case 4: 
            case 5: {
                boolean bl2;
                BigInteger bigInteger3;
                int n2 = bigInteger2.intValue();
                boolean bl3 = bl2 = n2 * n2 == bigInteger.intValue() && bigInteger2.pow(2).equals(bigInteger);
                if (bl2) {
                    bigInteger3 = bigInteger2;
                    return bigInteger3;
                }
                bigInteger3 = bigInteger2.add(BigInteger.ONE);
                return bigInteger3;
            }
            case 6: 
            case 7: 
            case 8: {
                BigInteger bigInteger4;
                BigInteger bigInteger5 = bigInteger2.pow(2).add(bigInteger2);
                if (bigInteger5.compareTo(bigInteger) >= 0) {
                    bigInteger4 = bigInteger2;
                    return bigInteger4;
                }
                bigInteger4 = bigInteger2.add(BigInteger.ONE);
                return bigInteger4;
            }
        }
        throw new AssertionError();
    }

    @GwtIncompatible(value="TODO")
    private static BigInteger sqrtFloor(BigInteger bigInteger) {
        BigInteger bigInteger2;
        int n2 = BigIntegerMath.log2(bigInteger, RoundingMode.FLOOR);
        if (n2 < 1023) {
            bigInteger2 = BigIntegerMath.sqrtApproxWithDoubles(bigInteger);
        } else {
            int n3 = n2 - 52 & -2;
            bigInteger2 = BigIntegerMath.sqrtApproxWithDoubles(bigInteger.shiftRight(n3)).shiftLeft(n3 >> 1);
        }
        BigInteger bigInteger3 = bigInteger2.add(bigInteger.divide(bigInteger2)).shiftRight(1);
        if (bigInteger2.equals(bigInteger3)) {
            return bigInteger2;
        }
        do {
            bigInteger2 = bigInteger3;
        } while ((bigInteger3 = bigInteger2.add(bigInteger.divide(bigInteger2)).shiftRight(1)).compareTo(bigInteger2) < 0);
        return bigInteger2;
    }

    @GwtIncompatible(value="TODO")
    private static BigInteger sqrtApproxWithDoubles(BigInteger bigInteger) {
        return DoubleMath.roundToBigInteger(Math.sqrt(DoubleUtils.bigToDouble(bigInteger)), RoundingMode.HALF_EVEN);
    }

    @GwtIncompatible(value="TODO")
    public static BigInteger divide(BigInteger bigInteger, BigInteger bigInteger2, RoundingMode roundingMode) {
        BigDecimal bigDecimal = new BigDecimal(bigInteger);
        BigDecimal bigDecimal2 = new BigDecimal(bigInteger2);
        return bigDecimal.divide(bigDecimal2, 0, roundingMode).toBigIntegerExact();
    }

    public static BigInteger factorial(int n2) {
        MathPreconditions.checkNonNegative("n", n2);
        if (n2 < LongMath.factorials.length) {
            return BigInteger.valueOf(LongMath.factorials[n2]);
        }
        int n3 = IntMath.divide(n2 * IntMath.log2(n2, RoundingMode.CEILING), 64, RoundingMode.CEILING);
        ArrayList<BigInteger> arrayList = new ArrayList<BigInteger>(n3);
        int n4 = LongMath.factorials.length;
        long l2 = LongMath.factorials[n4 - 1];
        int n5 = Long.numberOfTrailingZeros(l2);
        int n6 = LongMath.log2(l2 >>= n5, RoundingMode.FLOOR) + 1;
        int n7 = LongMath.log2(n4, RoundingMode.FLOOR) + 1;
        int n8 = 1 << n7 - 1;
        long l3 = n4;
        do {
            if (l3 > (long)n2) {
                if (l2 <= 1) return BigIntegerMath.listProduct(arrayList).shiftLeft(n5);
                arrayList.add(BigInteger.valueOf(l2));
                return BigIntegerMath.listProduct(arrayList).shiftLeft(n5);
            }
            if ((l3 & (long)n8) != 0) {
                n8 <<= 1;
                ++n7;
            }
            int n9 = Long.numberOfTrailingZeros(l3);
            long l4 = l3 >> n9;
            n5 += n9;
            int n10 = n7 - n9;
            if (n10 + n6 >= 64) {
                arrayList.add(BigInteger.valueOf(l2));
                l2 = 1;
                n6 = 0;
            }
            n6 = LongMath.log2(l2 *= l4, RoundingMode.FLOOR) + 1;
            ++l3;
        } while (true);
    }

    static BigInteger listProduct(List list) {
        return BigIntegerMath.listProduct(list, 0, list.size());
    }

    static BigInteger listProduct(List list, int n2, int n3) {
        switch (n3 - n2) {
            case 0: {
                return BigInteger.ONE;
            }
            case 1: {
                return (BigInteger)list.get(n2);
            }
            case 2: {
                return ((BigInteger)list.get(n2)).multiply((BigInteger)list.get(n2 + 1));
            }
            case 3: {
                return ((BigInteger)list.get(n2)).multiply((BigInteger)list.get(n2 + 1)).multiply((BigInteger)list.get(n2 + 2));
            }
        }
        int n4 = n3 + n2 >>> 1;
        return BigIntegerMath.listProduct(list, n2, n4).multiply(BigIntegerMath.listProduct(list, n4, n3));
    }

    public static BigInteger binomial(int n2, int n3) {
        int n4;
        MathPreconditions.checkNonNegative("n", n2);
        MathPreconditions.checkNonNegative("k", n3);
        Preconditions.checkArgument(n3 <= n2, "k (%s) > n (%s)", n3, n2);
        if (n3 > n2 >> 1) {
            n3 = n2 - n3;
        }
        if (n3 < LongMath.biggestBinomials.length && n2 <= LongMath.biggestBinomials[n3]) {
            return BigInteger.valueOf(LongMath.binomial(n2, n3));
        }
        BigInteger bigInteger = BigInteger.ONE;
        long l2 = n2;
        long l3 = 1;
        int n5 = n4 = LongMath.log2(n2, RoundingMode.CEILING);
        int n6 = 1;
        while (n6 < n3) {
            int n7 = n2 - n6;
            int n8 = n6 + 1;
            if (n5 + n4 >= 63) {
                bigInteger = bigInteger.multiply(BigInteger.valueOf(l2)).divide(BigInteger.valueOf(l3));
                l2 = n7;
                l3 = n8;
                n5 = n4;
            } else {
                l2 *= (long)n7;
                l3 *= (long)n8;
                n5 += n4;
            }
            ++n6;
        }
        return bigInteger.multiply(BigInteger.valueOf(l2)).divide(BigInteger.valueOf(l3));
    }

    @GwtIncompatible(value="TODO")
    static boolean fitsInLong(BigInteger bigInteger) {
        if (bigInteger.bitLength() > 63) return false;
        return true;
    }

    private BigIntegerMath() {
    }
}

