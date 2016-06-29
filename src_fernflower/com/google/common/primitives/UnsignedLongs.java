package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Longs;
import com.google.common.primitives.ParseRequest;
import com.google.common.primitives.UnsignedLongs$LexicographicalComparator;
import java.math.BigInteger;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible
public final class UnsignedLongs {
   public static final long MAX_VALUE = -1L;
   private static final long[] maxValueDivs = new long[37];
   private static final int[] maxValueMods = new int[37];
   private static final int[] maxSafeDigits = new int[37];

   private static long flip(long var0) {
      return var0 ^ Long.MIN_VALUE;
   }

   @CheckReturnValue
   public static int compare(long var0, long var2) {
      return Longs.compare(flip(var0), flip(var2));
   }

   @CheckReturnValue
   public static long min(long... var0) {
      Preconditions.checkArgument(var0.length > 0);
      long var1 = flip(var0[0]);

      for(int var3 = 1; var3 < var0.length; ++var3) {
         long var4 = flip(var0[var3]);
         if(var4 < var1) {
            var1 = var4;
         }
      }

      return flip(var1);
   }

   @CheckReturnValue
   public static long max(long... var0) {
      Preconditions.checkArgument(var0.length > 0);
      long var1 = flip(var0[0]);

      for(int var3 = 1; var3 < var0.length; ++var3) {
         long var4 = flip(var0[var3]);
         if(var4 > var1) {
            var1 = var4;
         }
      }

      return flip(var1);
   }

   @CheckReturnValue
   public static String join(String var0, long... var1) {
      Preconditions.checkNotNull(var0);
      if(var1.length == 0) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(var1.length * 5);
         var2.append(toString(var1[0]));

         for(int var3 = 1; var3 < var1.length; ++var3) {
            var2.append(var0).append(toString(var1[var3]));
         }

         return var2.toString();
      }
   }

   @CheckReturnValue
   public static Comparator lexicographicalComparator() {
      return UnsignedLongs$LexicographicalComparator.INSTANCE;
   }

   @CheckReturnValue
   public static long divide(long var0, long var2) {
      if(var2 < 0L) {
         return compare(var0, var2) < 0?0L:1L;
      } else if(var0 >= 0L) {
         return var0 / var2;
      } else {
         long var4 = (var0 >>> 1) / var2 << 1;
         long var6 = var0 - var4 * var2;
         return var4 + (long)(compare(var6, var2) >= 0?1:0);
      }
   }

   @CheckReturnValue
   public static long remainder(long var0, long var2) {
      if(var2 < 0L) {
         return compare(var0, var2) < 0?var0:var0 - var2;
      } else if(var0 >= 0L) {
         return var0 % var2;
      } else {
         long var4 = (var0 >>> 1) / var2 << 1;
         long var6 = var0 - var4 * var2;
         return var6 - (compare(var6, var2) >= 0?var2:0L);
      }
   }

   public static long parseUnsignedLong(String var0) {
      return parseUnsignedLong(var0, 10);
   }

   public static long decode(String var0) {
      // $FF: Couldn't be decompiled
   }

   public static long parseUnsignedLong(String var0, int var1) {
      // $FF: Couldn't be decompiled
   }

   private static boolean overflowInParse(long var0, int var2, int var3) {
      return var0 >= 0L?(var0 < maxValueDivs[var3]?false:(var0 > maxValueDivs[var3]?true:var2 > maxValueMods[var3])):true;
   }

   @CheckReturnValue
   public static String toString(long var0) {
      return toString(var0, 10);
   }

   @CheckReturnValue
   public static String toString(long var0, int var2) {
      Preconditions.checkArgument(var2 >= 2 && var2 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", new Object[]{Integer.valueOf(var2)});
      if(var0 == 0L) {
         return "0";
      } else {
         char[] var3 = new char[64];
         int var4 = var3.length;
         if(var0 < 0L) {
            long var5 = divide(var0, (long)var2);
            long var7 = var0 - var5 * (long)var2;
            --var4;
            var3[var4] = Character.forDigit((int)var7, var2);
            var0 = var5;
         }

         while(var0 > 0L) {
            --var4;
            var3[var4] = Character.forDigit((int)(var0 % (long)var2), var2);
            var0 /= (long)var2;
         }

         return new String(var3, var4, var3.length - var4);
      }
   }

   static {
      BigInteger var0 = new BigInteger("10000000000000000", 16);

      for(int var1 = 2; var1 <= 36; ++var1) {
         maxValueDivs[var1] = divide(-1L, (long)var1);
         maxValueMods[var1] = (int)remainder(-1L, (long)var1);
         maxSafeDigits[var1] = var0.toString(var1).length() - 1;
      }

   }
}
