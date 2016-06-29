package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.math.Quantiles$1;
import com.google.common.math.Quantiles$Scale;
import com.google.common.math.Quantiles$ScaleAndIndex;

@GoogleInternal
public final class Quantiles {
   public static Quantiles$ScaleAndIndex median() {
      return scale(2).index(1);
   }

   public static Quantiles$Scale quartiles() {
      return scale(4);
   }

   public static Quantiles$Scale percentiles() {
      return scale(100);
   }

   public static Quantiles$Scale scale(int var0) {
      return new Quantiles$Scale(var0, (Quantiles$1)null);
   }

   private static void checkIndex(int var0, int var1) {
      if(var0 < 0 || var0 > var1) {
         throw new IllegalArgumentException((new StringBuilder(70)).append("Quantile indexes must be between 0 and the scale, which is ").append(var1).toString());
      }
   }

   private static double[] longsToDoubles(long[] var0) {
      int var1 = var0.length;
      double[] var2 = new double[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = (double)var0[var3];
      }

      return var2;
   }

   private static double[] intsToDoubles(int[] var0) {
      int var1 = var0.length;
      double[] var2 = new double[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = (double)var0[var3];
      }

      return var2;
   }

   private static void selectInPlace(int var0, double[] var1, int var2, int var3) {
      int var4;
      if(var0 == var2) {
         var4 = var2;

         for(int var5 = var2 + 1; var5 <= var3; ++var5) {
            if(var1[var4] > var1[var5]) {
               var4 = var5;
            }
         }

         if(var4 != var2) {
            swap(var1, var4, var2);
         }

      } else {
         while(var3 > var2) {
            var4 = partition(var1, var2, var3);
            if(var4 >= var0) {
               var3 = var4 - 1;
            }

            if(var4 <= var0) {
               var2 = var4 + 1;
            }
         }

      }
   }

   private static int partition(double[] var0, int var1, int var2) {
      movePivotToStartOfSlice(var0, var1, var2);
      double var3 = var0[var1];
      int var5 = var2;

      for(int var6 = var2; var6 > var1; --var6) {
         if(var0[var6] > var3) {
            swap(var0, var5, var6);
            --var5;
         }
      }

      swap(var0, var1, var5);
      return var5;
   }

   private static void movePivotToStartOfSlice(double[] var0, int var1, int var2) {
      int var3 = var1 + var2 >>> 1;
      boolean var4 = var0[var2] < var0[var3];
      boolean var5 = var0[var3] < var0[var1];
      boolean var6 = var0[var2] < var0[var1];
      if(var4 == var5) {
         swap(var0, var3, var1);
      } else if(var4 != var6) {
         swap(var0, var1, var2);
      }

   }

   private static void selectAllInPlace(int[] var0, int var1, int var2, double[] var3, int var4, int var5) {
      int var6 = chooseNextSelection(var0, var1, var2, var4, var5);
      int var7 = var0[var6];
      selectInPlace(var7, var3, var4, var5);

      int var8;
      for(var8 = var6 - 1; var8 >= var1 && var0[var8] == var7; --var8) {
         ;
      }

      if(var8 >= var1) {
         selectAllInPlace(var0, var1, var8, var3, var4, var7 - 1);
      }

      int var9;
      for(var9 = var6 + 1; var9 <= var2 && var0[var9] == var7; ++var9) {
         ;
      }

      if(var9 <= var2) {
         selectAllInPlace(var0, var9, var2, var3, var7 + 1, var5);
      }

   }

   private static int chooseNextSelection(int[] var0, int var1, int var2, int var3, int var4) {
      if(var1 == var2) {
         return var1;
      } else {
         int var5 = var3 + var4 >>> 1;
         int var6 = var1;
         int var7 = var2;

         while(var7 > var6 + 1) {
            int var8 = var6 + var7 >>> 1;
            if(var0[var8] > var5) {
               var7 = var8;
            } else {
               if(var0[var8] >= var5) {
                  return var8;
               }

               var6 = var8;
            }
         }

         if(var3 + var4 - var0[var6] - var0[var7] > 0) {
            return var7;
         } else {
            return var6;
         }
      }
   }

   private static void swap(double[] var0, int var1, int var2) {
      double var3 = var0[var1];
      var0[var1] = var0[var2];
      var0[var2] = var3;
   }

   // $FF: synthetic method
   static void access$300(int var0, int var1) {
      checkIndex(var0, var1);
   }

   // $FF: synthetic method
   static double[] access$400(long[] var0) {
      return longsToDoubles(var0);
   }

   // $FF: synthetic method
   static double[] access$500(int[] var0) {
      return intsToDoubles(var0);
   }

   // $FF: synthetic method
   static void access$600(int var0, double[] var1, int var2, int var3) {
      selectInPlace(var0, var1, var2, var3);
   }

   // $FF: synthetic method
   static void access$700(int[] var0, int var1, int var2, double[] var3, int var4, int var5) {
      selectAllInPlace(var0, var1, var2, var3, var4, var5);
   }
}
