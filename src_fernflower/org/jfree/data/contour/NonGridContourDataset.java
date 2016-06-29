package org.jfree.data.contour;

import org.jfree.data.Range;
import org.jfree.data.contour.DefaultContourDataset;

public class NonGridContourDataset extends DefaultContourDataset {
   static final int DEFAULT_NUM_X = 50;
   static final int DEFAULT_NUM_Y = 50;
   static final int DEFAULT_POWER = 4;

   public NonGridContourDataset() {
   }

   public NonGridContourDataset(String var1, Object[] var2, Object[] var3, Object[] var4) {
      super(var1, var2, var3, var4);
      this.buildGrid(50, 50, 4);
   }

   public NonGridContourDataset(String var1, Object[] var2, Object[] var3, Object[] var4, int var5, int var6, int var7) {
      super(var1, var2, var3, var4);
      this.buildGrid(var5, var6, var7);
   }

   protected void buildGrid(int var1, int var2, int var3) {
      int var4 = var1 * var2;
      double[] var5 = new double[var4];
      double[] var6 = new double[var4];
      double[] var7 = new double[var4];
      double var8 = 1.0E20D;

      for(int var10 = 0; var10 < this.xValues.length; ++var10) {
         var8 = Math.min(var8, this.xValues[var10].doubleValue());
      }

      double var34 = -1.0E20D;

      for(int var12 = 0; var12 < this.xValues.length; ++var12) {
         var34 = Math.max(var34, this.xValues[var12].doubleValue());
      }

      double var35 = 1.0E20D;

      for(int var14 = 0; var14 < this.yValues.length; ++var14) {
         var35 = Math.min(var35, this.yValues[var14].doubleValue());
      }

      double var36 = -1.0E20D;

      for(int var16 = 0; var16 < this.yValues.length; ++var16) {
         var36 = Math.max(var36, this.yValues[var16].doubleValue());
      }

      Range var37 = new Range(var8, var34);
      Range var17 = new Range(var35, var36);
      var37.getLength();
      var17.getLength();
      double var18 = var37.getLength() / (double)(var1 - 1);
      double var20 = var17.getLength() / (double)(var2 - 1);
      double var22 = 0.0D;

      int var24;
      double var25;
      int var27;
      for(var24 = 0; var24 < var1; ++var24) {
         if(var24 == 0) {
            var22 = var8;
         } else {
            var22 += var18;
         }

         var25 = 0.0D;

         for(var27 = 0; var27 < var2; ++var27) {
            int var28 = var2 * var24 + var27;
            var5[var28] = var22;
            if(var27 == 0) {
               var25 = var35;
            } else {
               var25 += var20;
            }

            var6[var28] = var25;
         }
      }

      for(var24 = 0; var24 < var5.length; ++var24) {
         var25 = 0.0D;
         var7[var24] = 0.0D;

         for(var27 = 0; var27 < this.xValues.length; ++var27) {
            double var38 = this.xValues[var27].doubleValue();
            double var30 = this.yValues[var27].doubleValue();
            double var32 = this.distance(var38, var30, var5[var24], var6[var24]);
            if(var3 != 1) {
               var32 = Math.pow(var32, (double)var3);
            }

            var32 = Math.sqrt(var32);
            if(var32 > 0.0D) {
               var32 = 1.0D / var32;
            } else {
               var32 = 1.0E20D;
            }

            if(this.zValues[var27] != null) {
               var7[var24] += this.zValues[var27].doubleValue() * var32;
            }

            var25 += var32;
         }

         var7[var24] /= var25;
      }

      this.initialize(formObjectArray(var5), formObjectArray(var6), formObjectArray(var7));
   }

   protected double distance(double var1, double var3, double var5, double var7) {
      double var9 = var1 - var5;
      double var11 = var3 - var7;
      return Math.sqrt(var9 * var9 + var11 * var11);
   }
}
