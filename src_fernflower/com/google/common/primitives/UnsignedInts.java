package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import com.google.common.primitives.ParseRequest;
import com.google.common.primitives.UnsignedInts$LexicographicalComparator;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

@Beta
@GwtCompatible
public final class UnsignedInts {
   static final long INT_MASK = 4294967295L;

   static int flip(int var0) {
      return var0 ^ Integer.MIN_VALUE;
   }

   @CheckReturnValue
   public static int compare(int var0, int var1) {
      return Ints.compare(flip(var0), flip(var1));
   }

   @CheckReturnValue
   public static long toLong(int var0) {
      return (long)var0 & 4294967295L;
   }

   @CheckReturnValue
   public static int min(int... var0) {
      Preconditions.checkArgument(var0.length > 0);
      int var1 = flip(var0[0]);

      for(int var2 = 1; var2 < var0.length; ++var2) {
         int var3 = flip(var0[var2]);
         if(var3 < var1) {
            var1 = var3;
         }
      }

      return flip(var1);
   }

   @CheckReturnValue
   public static int max(int... var0) {
      Preconditions.checkArgument(var0.length > 0);
      int var1 = flip(var0[0]);

      for(int var2 = 1; var2 < var0.length; ++var2) {
         int var3 = flip(var0[var2]);
         if(var3 > var1) {
            var1 = var3;
         }
      }

      return flip(var1);
   }

   @CheckReturnValue
   public static String join(String var0, int... var1) {
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
      return UnsignedInts$LexicographicalComparator.INSTANCE;
   }

   @CheckReturnValue
   public static int divide(int var0, int var1) {
      return (int)(toLong(var0) / toLong(var1));
   }

   @CheckReturnValue
   public static int remainder(int var0, int var1) {
      return (int)(toLong(var0) % toLong(var1));
   }

   public static int decode(String var0) {
      // $FF: Couldn't be decompiled
   }

   public static int parseUnsignedInt(String var0) {
      return parseUnsignedInt(var0, 10);
   }

   public static int parseUnsignedInt(String var0, int var1) {
      Preconditions.checkNotNull(var0);
      long var2 = Long.parseLong(var0, var1);
      if((var2 & 4294967295L) != var2) {
         throw new NumberFormatException((new StringBuilder(69 + String.valueOf(var0).length())).append("Input ").append(var0).append(" in base ").append(var1).append(" is not in the range of an unsigned integer").toString());
      } else {
         return (int)var2;
      }
   }

   @CheckReturnValue
   public static String toString(int var0) {
      return toString(var0, 10);
   }

   @CheckReturnValue
   public static String toString(int var0, int var1) {
      long var2 = (long)var0 & 4294967295L;
      return Long.toString(var2, var1);
   }
}
