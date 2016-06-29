package com.google.common.primitives;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Converter;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Doubles$DoubleArrayAsList;
import com.google.common.primitives.Doubles$DoubleConverter;
import com.google.common.primitives.Doubles$LexicographicalComparator;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible(
   emulated = true
)
public final class Doubles {
   public static final int BYTES = 8;
   @GwtIncompatible("regular expressions")
   static final Pattern FLOATING_POINT_PATTERN = fpPattern();

   public static int hashCode(double var0) {
      return Double.valueOf(var0).hashCode();
   }

   static int compare(double var0, double var2) {
      return Double.compare(var0, var2);
   }

   public static boolean isFinite(double var0) {
      return Double.NEGATIVE_INFINITY < var0 & var0 < Double.POSITIVE_INFINITY;
   }

   public static boolean contains(double[] var0, double var1) {
      double[] var3 = var0;
      int var4 = var0.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         double var6 = var3[var5];
         if(var6 == var1) {
            return true;
         }
      }

      return false;
   }

   public static int indexOf(double[] var0, double var1) {
      return indexOf(var0, var1, 0, var0.length);
   }

   private static int indexOf(double[] var0, double var1, int var3, int var4) {
      for(int var5 = var3; var5 < var4; ++var5) {
         if(var0[var5] == var1) {
            return var5;
         }
      }

      return -1;
   }

   public static int indexOf(double[] var0, double[] var1) {
      Preconditions.checkNotNull(var0, "array");
      Preconditions.checkNotNull(var1, "target");
      if(var1.length == 0) {
         return 0;
      } else {
         label28:
         for(int var2 = 0; var2 < var0.length - var1.length + 1; ++var2) {
            for(int var3 = 0; var3 < var1.length; ++var3) {
               if(var0[var2 + var3] != var1[var3]) {
                  continue label28;
               }
            }

            return var2;
         }

         return -1;
      }
   }

   public static int lastIndexOf(double[] var0, double var1) {
      return lastIndexOf(var0, var1, 0, var0.length);
   }

   private static int lastIndexOf(double[] var0, double var1, int var3, int var4) {
      for(int var5 = var4 - 1; var5 >= var3; --var5) {
         if(var0[var5] == var1) {
            return var5;
         }
      }

      return -1;
   }

   public static double min(double... var0) {
      Preconditions.checkArgument(var0.length > 0);
      double var1 = var0[0];

      for(int var3 = 1; var3 < var0.length; ++var3) {
         var1 = Math.min(var1, var0[var3]);
      }

      return var1;
   }

   public static double max(double... var0) {
      Preconditions.checkArgument(var0.length > 0);
      double var1 = var0[0];

      for(int var3 = 1; var3 < var0.length; ++var3) {
         var1 = Math.max(var1, var0[var3]);
      }

      return var1;
   }

   public static double[] concat(double[]... var0) {
      int var1 = 0;
      double[][] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         double[] var5 = var2[var4];
         var1 += var5.length;
      }

      double[] var8 = new double[var1];
      var3 = 0;
      double[][] var9 = var0;
      int var10 = var0.length;

      for(int var6 = 0; var6 < var10; ++var6) {
         double[] var7 = var9[var6];
         System.arraycopy(var7, 0, var8, var3, var7.length);
         var3 += var7.length;
      }

      return var8;
   }

   @Beta
   public static Converter stringConverter() {
      return Doubles$DoubleConverter.INSTANCE;
   }

   public static double[] ensureCapacity(double[] var0, int var1, int var2) {
      Preconditions.checkArgument(var1 >= 0, "Invalid minLength: %s", new Object[]{Integer.valueOf(var1)});
      Preconditions.checkArgument(var2 >= 0, "Invalid padding: %s", new Object[]{Integer.valueOf(var2)});
      return var0.length < var1?copyOf(var0, var1 + var2):var0;
   }

   private static double[] copyOf(double[] var0, int var1) {
      double[] var2 = new double[var1];
      System.arraycopy(var0, 0, var2, 0, Math.min(var0.length, var1));
      return var2;
   }

   public static String join(String var0, double... var1) {
      Preconditions.checkNotNull(var0);
      if(var1.length == 0) {
         return "";
      } else {
         StringBuilder var2 = new StringBuilder(var1.length * 12);
         var2.append(var1[0]);

         for(int var3 = 1; var3 < var1.length; ++var3) {
            var2.append(var0).append(var1[var3]);
         }

         return var2.toString();
      }
   }

   public static Comparator lexicographicalComparator() {
      return Doubles$LexicographicalComparator.INSTANCE;
   }

   public static double[] toArray(Collection var0) {
      if(var0 instanceof Doubles$DoubleArrayAsList) {
         return ((Doubles$DoubleArrayAsList)var0).toDoubleArray();
      } else {
         Object[] var1 = var0.toArray();
         int var2 = var1.length;
         double[] var3 = new double[var2];

         for(int var4 = 0; var4 < var2; ++var4) {
            var3[var4] = ((Number)Preconditions.checkNotNull(var1[var4])).doubleValue();
         }

         return var3;
      }
   }

   public static List asList(double... var0) {
      return (List)(var0.length == 0?Collections.emptyList():new Doubles$DoubleArrayAsList(var0));
   }

   @GwtIncompatible("regular expressions")
   private static Pattern fpPattern() {
      String var0 = "(?:\\d++(?:\\.\\d*+)?|\\.\\d++)";
      String var1 = String.valueOf(var0).concat("(?:[eE][+-]?\\d++)?[fFdD]?");
      String var2 = "(?:\\p{XDigit}++(?:\\.\\p{XDigit}*+)?|\\.\\p{XDigit}++)";
      String var3 = (new StringBuilder(25 + String.valueOf(var2).length())).append("0[xX]").append(var2).append("[pP][+-]?\\d++[fFdD]?").toString();
      String var4 = (new StringBuilder(23 + String.valueOf(var1).length() + String.valueOf(var3).length())).append("[+-]?(?:NaN|Infinity|").append(var1).append("|").append(var3).append(")").toString();
      return Pattern.compile(var4);
   }

   @Nullable
   @CheckForNull
   @Beta
   @GwtIncompatible("regular expressions")
   public static Double tryParse(String var0) {
      if(FLOATING_POINT_PATTERN.matcher(var0).matches()) {
         try {
            return Double.valueOf(Double.parseDouble(var0));
         } catch (NumberFormatException var2) {
            ;
         }
      }

      return null;
   }

   // $FF: synthetic method
   static int access$000(double[] var0, double var1, int var3, int var4) {
      return indexOf(var0, var1, var3, var4);
   }

   // $FF: synthetic method
   static int access$100(double[] var0, double var1, int var3, int var4) {
      return lastIndexOf(var0, var1, var3, var4);
   }
}
