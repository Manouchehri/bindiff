package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.primitives.SignedBytes$LexicographicalComparator;
import java.util.Comparator;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
@GwtCompatible
public final class SignedBytes {
   public static final byte MAX_POWER_OF_TWO = 64;

   public static byte checkedCast(long var0) {
      byte var2 = (byte)((int)var0);
      if((long)var2 != var0) {
         throw new IllegalArgumentException((new StringBuilder(34)).append("Out of range: ").append(var0).toString());
      } else {
         return var2;
      }
   }

   public static byte saturatedCast(long var0) {
      return var0 > 127L?127:(var0 < -128L?-128:(byte)((int)var0));
   }

   public static int compare(byte var0, byte var1) {
      return var0 - var1;
   }

   public static byte min(byte... var0) {
      Preconditions.checkArgument(var0.length > 0);
      byte var1 = var0[0];

      for(int var2 = 1; var2 < var0.length; ++var2) {
         if(var0[var2] < var1) {
            var1 = var0[var2];
         }
      }

      return var1;
   }

   public static byte max(byte... var0) {
      Preconditions.checkArgument(var0.length > 0);
      byte var1 = var0[0];

      for(int var2 = 1; var2 < var0.length; ++var2) {
         if(var0[var2] > var1) {
            var1 = var0[var2];
         }
      }

      return var1;
   }

   public static String join(String var0, byte... var1) {
      Preconditions.checkNotNull(var0);
      if(var1.length == 0) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(var1.length * 5);
         var2.append(var1[0]);

         for(int var3 = 1; var3 < var1.length; ++var3) {
            var2.append(var0).append(var1[var3]);
         }

         return var2.toString();
      }
   }

   public static Comparator lexicographicalComparator() {
      return SignedBytes$LexicographicalComparator.INSTANCE;
   }
}
