package com.google.common.math;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleMath$1;
import com.google.common.math.DoubleUtils;
import com.google.common.math.LongMath;
import com.google.common.math.MathPreconditions;
import com.google.common.primitives.Booleans;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Iterator;

@GwtCompatible(
   emulated = true
)
public final class DoubleMath {
   private static final double MIN_INT_AS_DOUBLE = -2.147483648E9D;
   private static final double MAX_INT_AS_DOUBLE = 2.147483647E9D;
   private static final double MIN_LONG_AS_DOUBLE = -9.223372036854776E18D;
   private static final double MAX_LONG_AS_DOUBLE_PLUS_ONE = 9.223372036854776E18D;
   private static final double LN_2 = Math.log(2.0D);
   @VisibleForTesting
   static final int MAX_FACTORIAL = 170;
   @VisibleForTesting
   static final double[] everySixteenthFactorial = new double[]{1.0D, 2.0922789888E13D, 2.631308369336935E35D, 1.2413915592536073E61D, 1.2688693218588417E89D, 7.156945704626381E118D, 9.916779348709496E149D, 1.974506857221074E182D, 3.856204823625804E215D, 5.5502938327393044E249D, 4.7147236359920616E284D};

   @GwtIncompatible("#isMathematicalInteger, com.google.common.math.DoubleUtils")
   static double roundIntermediate(double var0, RoundingMode var2) {
      if(!DoubleUtils.isFinite(var0)) {
         throw new ArithmeticException("input is infinite or NaN");
      } else {
         double var3;
         switch(DoubleMath$1.$SwitchMap$java$math$RoundingMode[var2.ordinal()]) {
         case 1:
            MathPreconditions.checkRoundingUnnecessary(isMathematicalInteger(var0));
            return var0;
         case 2:
            if(var0 < 0.0D && !isMathematicalInteger(var0)) {
               return var0 - 1.0D;
            }

            return var0;
         case 3:
            if(var0 > 0.0D && !isMathematicalInteger(var0)) {
               return var0 + 1.0D;
            }

            return var0;
         case 4:
            return var0;
         case 5:
            if(isMathematicalInteger(var0)) {
               return var0;
            }

            return var0 + Math.copySign(1.0D, var0);
         case 6:
            return Math.rint(var0);
         case 7:
            var3 = Math.rint(var0);
            if(Math.abs(var0 - var3) == 0.5D) {
               return var0 + Math.copySign(0.5D, var0);
            }

            return var3;
         case 8:
            var3 = Math.rint(var0);
            if(Math.abs(var0 - var3) == 0.5D) {
               return var0;
            }

            return var3;
         default:
            throw new AssertionError();
         }
      }
   }

   @GwtIncompatible("#roundIntermediate")
   public static int roundToInt(double var0, RoundingMode var2) {
      double var3 = roundIntermediate(var0, var2);
      MathPreconditions.checkInRange(var3 > -2.147483649E9D & var3 < 2.147483648E9D);
      return (int)var3;
   }

   @GwtIncompatible("#roundIntermediate")
   public static long roundToLong(double var0, RoundingMode var2) {
      double var3 = roundIntermediate(var0, var2);
      MathPreconditions.checkInRange(-9.223372036854776E18D - var3 < 1.0D & var3 < 9.223372036854776E18D);
      return (long)var3;
   }

   @GwtIncompatible("#roundIntermediate, java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
   public static BigInteger roundToBigInteger(double var0, RoundingMode var2) {
      var0 = roundIntermediate(var0, var2);
      if(-9.223372036854776E18D - var0 < 1.0D & var0 < 9.223372036854776E18D) {
         return BigInteger.valueOf((long)var0);
      } else {
         int var3 = Math.getExponent(var0);
         long var4 = DoubleUtils.getSignificand(var0);
         BigInteger var6 = BigInteger.valueOf(var4).shiftLeft(var3 - 52);
         return var0 < 0.0D?var6.negate():var6;
      }
   }

   @GwtIncompatible("com.google.common.math.DoubleUtils")
   public static boolean isPowerOfTwo(double var0) {
      return var0 > 0.0D && DoubleUtils.isFinite(var0) && LongMath.isPowerOfTwo(DoubleUtils.getSignificand(var0));
   }

   public static double log2(double var0) {
      return Math.log(var0) / LN_2;
   }

   @GwtIncompatible("java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
   public static int log2(double var0, RoundingMode var2) {
      Preconditions.checkArgument(var0 > 0.0D && DoubleUtils.isFinite(var0), "x must be positive and finite");
      int var3 = Math.getExponent(var0);
      if(!DoubleUtils.isNormal(var0)) {
         return log2(var0 * 4.503599627370496E15D, var2) - 52;
      } else {
         boolean var4;
         switch(DoubleMath$1.$SwitchMap$java$math$RoundingMode[var2.ordinal()]) {
         case 1:
            MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(var0));
         case 2:
            var4 = false;
            break;
         case 3:
            var4 = !isPowerOfTwo(var0);
            break;
         case 4:
            var4 = var3 < 0 & !isPowerOfTwo(var0);
            break;
         case 5:
            var4 = var3 >= 0 & !isPowerOfTwo(var0);
            break;
         case 6:
         case 7:
         case 8:
            double var5 = DoubleUtils.scaleNormalize(var0);
            var4 = var5 * var5 > 2.0D;
            break;
         default:
            throw new AssertionError();
         }

         return var4?var3 + 1:var3;
      }
   }

   @GwtIncompatible("java.lang.Math.getExponent, com.google.common.math.DoubleUtils")
   public static boolean isMathematicalInteger(double var0) {
      return DoubleUtils.isFinite(var0) && (var0 == 0.0D || 52 - Long.numberOfTrailingZeros(DoubleUtils.getSignificand(var0)) <= Math.getExponent(var0));
   }

   public static double factorial(int var0) {
      MathPreconditions.checkNonNegative("n", var0);
      if(var0 > 170) {
         return Double.POSITIVE_INFINITY;
      } else {
         double var1 = 1.0D;

         for(int var3 = 1 + (var0 & -16); var3 <= var0; ++var3) {
            var1 *= (double)var3;
         }

         return var1 * everySixteenthFactorial[var0 >> 4];
      }
   }

   public static boolean fuzzyEquals(double var0, double var2, double var4) {
      MathPreconditions.checkNonNegative("tolerance", var4);
      return Math.copySign(var0 - var2, 1.0D) <= var4 || var0 == var2 || Double.isNaN(var0) && Double.isNaN(var2);
   }

   public static int fuzzyCompare(double var0, double var2, double var4) {
      return fuzzyEquals(var0, var2, var4)?0:(var0 < var2?-1:(var0 > var2?1:Booleans.compare(Double.isNaN(var0), Double.isNaN(var2))));
   }

   @GwtIncompatible("com.google.common.math.DoubleUtils")
   public static double mean(double... var0) {
      Preconditions.checkArgument(var0.length > 0, "Cannot take mean of 0 values");
      long var1 = 1L;
      double var3 = checkFinite(var0[0]);

      for(int var5 = 1; var5 < var0.length; ++var5) {
         checkFinite(var0[var5]);
         ++var1;
         var3 += (var0[var5] - var3) / (double)var1;
      }

      return var3;
   }

   public static double mean(int... var0) {
      Preconditions.checkArgument(var0.length > 0, "Cannot take mean of 0 values");
      long var1 = 0L;

      for(int var3 = 0; var3 < var0.length; ++var3) {
         var1 += (long)var0[var3];
      }

      return (double)var1 / (double)var0.length;
   }

   public static double mean(long... var0) {
      Preconditions.checkArgument(var0.length > 0, "Cannot take mean of 0 values");
      long var1 = 1L;
      double var3 = (double)var0[0];

      for(int var5 = 1; var5 < var0.length; ++var5) {
         ++var1;
         var3 += ((double)var0[var5] - var3) / (double)var1;
      }

      return var3;
   }

   @GwtIncompatible("com.google.common.math.DoubleUtils")
   public static double mean(Iterable var0) {
      return mean(var0.iterator());
   }

   @GwtIncompatible("com.google.common.math.DoubleUtils")
   public static double mean(Iterator var0) {
      Preconditions.checkArgument(var0.hasNext(), "Cannot take mean of 0 values");
      long var1 = 1L;

      double var3;
      double var5;
      for(var3 = checkFinite(((Number)var0.next()).doubleValue()); var0.hasNext(); var3 += (var5 - var3) / (double)var1) {
         var5 = checkFinite(((Number)var0.next()).doubleValue());
         ++var1;
      }

      return var3;
   }

   @GwtIncompatible("com.google.common.math.DoubleUtils")
   private static double checkFinite(double var0) {
      Preconditions.checkArgument(DoubleUtils.isFinite(var0));
      return var0;
   }
}
