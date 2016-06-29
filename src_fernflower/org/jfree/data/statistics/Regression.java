package org.jfree.data.statistics;

import org.jfree.data.xy.XYDataset;

public abstract class Regression {
   public static double[] getOLSRegression(double[][] var0) {
      int var1 = var0.length;
      if(var1 < 2) {
         throw new IllegalArgumentException("Not enough data.");
      } else {
         double var2 = 0.0D;
         double var4 = 0.0D;
         double var6 = 0.0D;
         double var8 = 0.0D;

         for(int var10 = 0; var10 < var1; ++var10) {
            double var11 = var0[var10][0];
            double var13 = var0[var10][1];
            var2 += var11;
            var4 += var13;
            double var15 = var11 * var11;
            var6 += var15;
            double var17 = var11 * var13;
            var8 += var17;
         }

         double var19 = var6 - var2 * var2 / (double)var1;
         double var12 = var8 - var2 * var4 / (double)var1;
         double var14 = var2 / (double)var1;
         double var16 = var4 / (double)var1;
         double[] var18 = new double[]{0.0D, var12 / var19};
         var18[0] = var16 - var18[1] * var14;
         return var18;
      }
   }

   public static double[] getOLSRegression(XYDataset var0, int var1) {
      int var2 = var0.getItemCount(var1);
      if(var2 < 2) {
         throw new IllegalArgumentException("Not enough data.");
      } else {
         double var3 = 0.0D;
         double var5 = 0.0D;
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var2; ++var11) {
            double var12 = var0.getXValue(var1, var11);
            double var14 = var0.getYValue(var1, var11);
            var3 += var12;
            var5 += var14;
            double var16 = var12 * var12;
            var7 += var16;
            double var18 = var12 * var14;
            var9 += var18;
         }

         double var20 = var7 - var3 * var3 / (double)var2;
         double var13 = var9 - var3 * var5 / (double)var2;
         double var15 = var3 / (double)var2;
         double var17 = var5 / (double)var2;
         double[] var19 = new double[]{0.0D, var13 / var20};
         var19[0] = var17 - var19[1] * var15;
         return var19;
      }
   }

   public static double[] getPowerRegression(double[][] var0) {
      int var1 = var0.length;
      if(var1 < 2) {
         throw new IllegalArgumentException("Not enough data.");
      } else {
         double var2 = 0.0D;
         double var4 = 0.0D;
         double var6 = 0.0D;
         double var8 = 0.0D;

         for(int var10 = 0; var10 < var1; ++var10) {
            double var11 = Math.log(var0[var10][0]);
            double var13 = Math.log(var0[var10][1]);
            var2 += var11;
            var4 += var13;
            double var15 = var11 * var11;
            var6 += var15;
            double var17 = var11 * var13;
            var8 += var17;
         }

         double var19 = var6 - var2 * var2 / (double)var1;
         double var12 = var8 - var2 * var4 / (double)var1;
         double var14 = var2 / (double)var1;
         double var16 = var4 / (double)var1;
         double[] var18 = new double[]{0.0D, var12 / var19};
         var18[0] = Math.pow(Math.exp(1.0D), var16 - var18[1] * var14);
         return var18;
      }
   }

   public static double[] getPowerRegression(XYDataset var0, int var1) {
      int var2 = var0.getItemCount(var1);
      if(var2 < 2) {
         throw new IllegalArgumentException("Not enough data.");
      } else {
         double var3 = 0.0D;
         double var5 = 0.0D;
         double var7 = 0.0D;
         double var9 = 0.0D;

         for(int var11 = 0; var11 < var2; ++var11) {
            double var12 = Math.log(var0.getXValue(var1, var11));
            double var14 = Math.log(var0.getYValue(var1, var11));
            var3 += var12;
            var5 += var14;
            double var16 = var12 * var12;
            var7 += var16;
            double var18 = var12 * var14;
            var9 += var18;
         }

         double var20 = var7 - var3 * var3 / (double)var2;
         double var13 = var9 - var3 * var5 / (double)var2;
         double var15 = var3 / (double)var2;
         double var17 = var5 / (double)var2;
         double[] var19 = new double[]{0.0D, var13 / var20};
         var19[0] = Math.pow(Math.exp(1.0D), var17 - var19[1] * var15);
         return var19;
      }
   }
}
