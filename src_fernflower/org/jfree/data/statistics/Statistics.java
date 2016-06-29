package org.jfree.data.statistics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class Statistics {
   public static double calculateMean(Number[] var0) {
      return calculateMean(var0, true);
   }

   public static double calculateMean(Number[] var0, boolean var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'values\' argument.");
      } else {
         double var2 = 0.0D;
         int var6 = 0;

         for(int var7 = 0; var7 < var0.length; ++var7) {
            double var4;
            if(var0[var7] != null) {
               var4 = var0[var7].doubleValue();
            } else {
               var4 = Double.NaN;
            }

            if(var1 || !Double.isNaN(var4)) {
               var2 += var4;
               ++var6;
            }
         }

         double var9 = var2 / (double)var6;
         return var9;
      }
   }

   public static double calculateMean(Collection var0) {
      return calculateMean(var0, true);
   }

   public static double calculateMean(Collection var0, boolean var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'values\' argument.");
      } else {
         int var2 = 0;
         double var3 = 0.0D;
         Iterator var5 = var0.iterator();

         while(var5.hasNext()) {
            Object var6 = var5.next();
            if(var6 == null) {
               if(var1) {
                  return Double.NaN;
               }
            } else if(var6 instanceof Number) {
               Number var7 = (Number)var6;
               double var8 = var7.doubleValue();
               if(Double.isNaN(var8)) {
                  if(var1) {
                     return Double.NaN;
                  }
               } else {
                  var3 += var7.doubleValue();
                  ++var2;
               }
            }
         }

         return var3 / (double)var2;
      }
   }

   public static double calculateMedian(List var0) {
      return calculateMedian(var0, true);
   }

   public static double calculateMedian(List var0, boolean var1) {
      double var2 = Double.NaN;
      if(var0 != null) {
         int var4;
         if(var1) {
            var4 = ((List)var0).size();
            ArrayList var5 = new ArrayList(var4);

            for(int var6 = 0; var6 < var4; ++var6) {
               var5.add(var6, ((List)var0).get(var6));
            }

            Collections.sort(var5);
            var0 = var5;
         }

         var4 = ((List)var0).size();
         if(var4 > 0) {
            Number var7;
            if(var4 % 2 == 1) {
               if(var4 > 1) {
                  var7 = (Number)((List)var0).get((var4 - 1) / 2);
                  var2 = var7.doubleValue();
               } else {
                  var7 = (Number)((List)var0).get(0);
                  var2 = var7.doubleValue();
               }
            } else {
               var7 = (Number)((List)var0).get(var4 / 2 - 1);
               Number var8 = (Number)((List)var0).get(var4 / 2);
               var2 = (var7.doubleValue() + var8.doubleValue()) / 2.0D;
            }
         }
      }

      return var2;
   }

   public static double calculateMedian(List var0, int var1, int var2) {
      return calculateMedian(var0, var1, var2, true);
   }

   public static double calculateMedian(List var0, int var1, int var2, boolean var3) {
      double var4 = Double.NaN;
      if(var3) {
         ArrayList var6 = new ArrayList(var2 - var1 + 1);

         for(int var7 = var1; var7 <= var2; ++var7) {
            var6.add(var0.get(var7));
         }

         Collections.sort(var6);
         var4 = calculateMedian(var6, false);
      } else {
         int var9 = var2 - var1 + 1;
         if(var9 > 0) {
            Number var10;
            if(var9 % 2 == 1) {
               if(var9 > 1) {
                  var10 = (Number)var0.get(var1 + (var9 - 1) / 2);
                  var4 = var10.doubleValue();
               } else {
                  var10 = (Number)var0.get(var1);
                  var4 = var10.doubleValue();
               }
            } else {
               var10 = (Number)var0.get(var1 + var9 / 2 - 1);
               Number var8 = (Number)var0.get(var1 + var9 / 2);
               var4 = (var10.doubleValue() + var8.doubleValue()) / 2.0D;
            }
         }
      }

      return var4;
   }

   public static double getStdDev(Number[] var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'data\' array.");
      } else if(var0.length == 0) {
         throw new IllegalArgumentException("Zero length \'data\' array.");
      } else {
         double var1 = calculateMean(var0);
         double var3 = 0.0D;

         for(int var5 = 0; var5 < var0.length; ++var5) {
            double var6 = var0[var5].doubleValue() - var1;
            var3 += var6 * var6;
         }

         return Math.sqrt(var3 / (double)(var0.length - 1));
      }
   }

   public static double[] getLinearFit(Number[] var0, Number[] var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'xData\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'yData\' argument.");
      } else if(var0.length != var1.length) {
         throw new IllegalArgumentException("Statistics.getLinearFit(): array lengths must be equal.");
      } else {
         double[] var2 = new double[]{0.0D, getSlope(var0, var1)};
         var2[0] = calculateMean(var1) - var2[1] * calculateMean(var0);
         return var2;
      }
   }

   public static double getSlope(Number[] var0, Number[] var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'xData\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'yData\' argument.");
      } else if(var0.length != var1.length) {
         throw new IllegalArgumentException("Array lengths must be equal.");
      } else {
         double var2 = 0.0D;
         double var4 = 0.0D;
         double var6 = 0.0D;
         double var8 = 0.0D;

         int var10;
         for(var10 = 0; var10 < var0.length; ++var10) {
            var2 += var0[var10].doubleValue();
            var4 += Math.pow(var0[var10].doubleValue(), 2.0D);
            var6 += var1[var10].doubleValue() * var0[var10].doubleValue();
            var8 += var1[var10].doubleValue();
         }

         return (var6 - var2 * var8 / (double)var10) / (var4 - var2 * var2 / (double)var10);
      }
   }

   public static double getCorrelation(Number[] var0, Number[] var1) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'data1\' argument.");
      } else if(var1 == null) {
         throw new IllegalArgumentException("Null \'data2\' argument.");
      } else if(var0.length != var1.length) {
         throw new IllegalArgumentException("\'data1\' and \'data2\' arrays must have same length.");
      } else {
         int var2 = var0.length;
         double var3 = 0.0D;
         double var5 = 0.0D;
         double var7 = 0.0D;
         double var9 = 0.0D;
         double var11 = 0.0D;

         for(int var13 = 0; var13 < var2; ++var13) {
            double var14 = 0.0D;
            if(var0[var13] != null) {
               var14 = var0[var13].doubleValue();
            }

            double var16 = 0.0D;
            if(var1[var13] != null) {
               var16 = var1[var13].doubleValue();
            }

            var3 += var14;
            var5 += var16;
            var11 += var14 * var16;
            var7 += var14 * var14;
            var9 += var16 * var16;
         }

         return ((double)var2 * var11 - var3 * var5) / Math.pow(((double)var2 * var7 - var3 * var3) * ((double)var2 * var9 - var5 * var5), 0.5D);
      }
   }

   public static double[][] getMovingAverage(Number[] var0, Number[] var1, int var2) {
      if(var0.length != var1.length) {
         throw new IllegalArgumentException("Array lengths must be equal.");
      } else if(var2 > var0.length) {
         throw new IllegalArgumentException("Period can\'t be longer than dataset.");
      } else {
         double[][] var3 = new double[var0.length - var2][2];

         for(int var4 = 0; var4 < var3.length; ++var4) {
            var3[var4][0] = var0[var4 + var2].doubleValue();
            double var5 = 0.0D;

            for(int var7 = 0; var7 < var2; ++var7) {
               var5 += var1[var4 + var7].doubleValue();
            }

            var5 /= (double)var2;
            var3[var4][1] = var5;
         }

         return var3;
      }
   }
}
