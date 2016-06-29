package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder;
import com.google.common.primitives.UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

public final class UnsignedBytes {
   public static final byte MAX_POWER_OF_TWO = -128;
   public static final byte MAX_VALUE = -1;
   private static final int UNSIGNED_MASK = 255;

   @CheckReturnValue
   public static int toInt(byte var0) {
      return var0 & 255;
   }

   public static byte checkedCast(long var0) {
      if(var0 >> 8 != 0L) {
         throw new IllegalArgumentException((new StringBuilder(34)).append("Out of range: ").append(var0).toString());
      } else {
         return (byte)((int)var0);
      }
   }

   public static byte saturatedCast(long var0) {
      return var0 > (long)toInt((byte)-1)?-1:(var0 < 0L?0:(byte)((int)var0));
   }

   @CheckReturnValue
   public static int compare(byte var0, byte var1) {
      return toInt(var0) - toInt(var1);
   }

   @CheckReturnValue
   public static byte min(byte... var0) {
      Preconditions.checkArgument(var0.length > 0);
      int var1 = toInt(var0[0]);

      for(int var2 = 1; var2 < var0.length; ++var2) {
         int var3 = toInt(var0[var2]);
         if(var3 < var1) {
            var1 = var3;
         }
      }

      return (byte)var1;
   }

   @CheckReturnValue
   public static byte max(byte... var0) {
      Preconditions.checkArgument(var0.length > 0);
      int var1 = toInt(var0[0]);

      for(int var2 = 1; var2 < var0.length; ++var2) {
         int var3 = toInt(var0[var2]);
         if(var3 > var1) {
            var1 = var3;
         }
      }

      return (byte)var1;
   }

   @CheckReturnValue
   @Beta
   public static String toString(byte var0) {
      return toString(var0, 10);
   }

   @CheckReturnValue
   @Beta
   public static String toString(byte var0, int var1) {
      Preconditions.checkArgument(var1 >= 2 && var1 <= 36, "radix (%s) must be between Character.MIN_RADIX and Character.MAX_RADIX", new Object[]{Integer.valueOf(var1)});
      return Integer.toString(toInt(var0), var1);
   }

   @Beta
   public static byte parseUnsignedByte(String var0) {
      return parseUnsignedByte(var0, 10);
   }

   @Beta
   public static byte parseUnsignedByte(String var0, int var1) {
      int var2 = Integer.parseInt((String)Preconditions.checkNotNull(var0), var1);
      if(var2 >> 8 == 0) {
         return (byte)var2;
      } else {
         throw new NumberFormatException((new StringBuilder(25)).append("out of range: ").append(var2).toString());
      }
   }

   @CheckReturnValue
   public static String join(String var0, byte... var1) {
      Preconditions.checkNotNull(var0);
      if(var1.length == 0) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(var1.length * (3 + var0.length()));
         var2.append(toInt(var1[0]));

         for(int var3 = 1; var3 < var1.length; ++var3) {
            var2.append(var0).append(toString(var1[var3]));
         }

         return var2.toString();
      }
   }

   @CheckReturnValue
   public static Comparator lexicographicalComparator() {
      return UnsignedBytes$LexicographicalComparatorHolder.BEST_COMPARATOR;
   }

   @VisibleForTesting
   static Comparator lexicographicalComparatorJavaImpl() {
      return UnsignedBytes$LexicographicalComparatorHolder$PureJavaComparator.INSTANCE;
   }
}
