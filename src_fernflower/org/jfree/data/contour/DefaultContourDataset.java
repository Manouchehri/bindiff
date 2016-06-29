package org.jfree.data.contour;

import java.util.Arrays;
import java.util.Date;
import java.util.Vector;
import org.jfree.data.Range;
import org.jfree.data.contour.ContourDataset;
import org.jfree.data.xy.AbstractXYZDataset;

public class DefaultContourDataset extends AbstractXYZDataset implements ContourDataset {
   protected Comparable seriesKey = null;
   protected Number[] xValues = null;
   protected Number[] yValues = null;
   protected Number[] zValues = null;
   protected int[] xIndex = null;
   boolean[] dateAxis = new boolean[3];

   public DefaultContourDataset() {
   }

   public DefaultContourDataset(Comparable var1, Object[] var2, Object[] var3, Object[] var4) {
      this.seriesKey = var1;
      this.initialize(var2, var3, var4);
   }

   public void initialize(Object[] var1, Object[] var2, Object[] var3) {
      this.xValues = new Double[var1.length];
      this.yValues = new Double[var2.length];
      this.zValues = new Double[var3.length];
      Vector var4 = new Vector();
      double var5 = 1.123452E31D;

      for(int var7 = 0; var7 < this.xValues.length; ++var7) {
         if(var1[var7] != null) {
            Object var8;
            if(var1[var7] instanceof Number) {
               var8 = (Number)var1[var7];
            } else if(var1[var7] instanceof Date) {
               this.dateAxis[0] = true;
               Date var9 = (Date)var1[var7];
               var8 = new Long(var9.getTime());
            } else {
               var8 = new Integer(0);
            }

            this.xValues[var7] = new Double(((Number)var8).doubleValue());
            if(var5 != this.xValues[var7].doubleValue()) {
               var4.add(new Integer(var7));
               var5 = this.xValues[var7].doubleValue();
            }
         }
      }

      Object[] var10 = var4.toArray();
      this.xIndex = new int[var10.length];

      int var11;
      for(var11 = 0; var11 < var10.length; ++var11) {
         this.xIndex[var11] = ((Integer)var10[var11]).intValue();
      }

      for(var11 = 0; var11 < this.yValues.length; ++var11) {
         this.yValues[var11] = (Double)var2[var11];
         if(var3[var11] != null) {
            this.zValues[var11] = (Double)var3[var11];
         }
      }

   }

   public static Object[][] formObjectArray(double[][] var0) {
      Double[][] var1 = new Double[var0.length][var0[0].length];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         for(int var3 = 0; var3 < var1[var2].length; ++var3) {
            var1[var2][var3] = new Double(var0[var2][var3]);
         }
      }

      return var1;
   }

   public static Object[] formObjectArray(double[] var0) {
      Double[] var1 = new Double[var0.length];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = new Double(var0[var2]);
      }

      return var1;
   }

   public int getItemCount(int var1) {
      if(var1 > 0) {
         throw new IllegalArgumentException("Only one series for contour");
      } else {
         return this.zValues.length;
      }
   }

   public double getMaxZValue() {
      double var1 = -1.0E20D;

      for(int var3 = 0; var3 < this.zValues.length; ++var3) {
         if(this.zValues[var3] != null) {
            var1 = Math.max(var1, this.zValues[var3].doubleValue());
         }
      }

      return var1;
   }

   public double getMinZValue() {
      double var1 = 1.0E20D;

      for(int var3 = 0; var3 < this.zValues.length; ++var3) {
         if(this.zValues[var3] != null) {
            var1 = Math.min(var1, this.zValues[var3].doubleValue());
         }
      }

      return var1;
   }

   public Range getZValueRange(Range var1, Range var2) {
      double var3 = var1.getLowerBound();
      double var5 = var2.getLowerBound();
      double var7 = var1.getUpperBound();
      double var9 = var2.getUpperBound();
      double var11 = 1.0E20D;
      double var13 = -1.0E20D;

      for(int var15 = 0; var15 < this.zValues.length; ++var15) {
         if(this.xValues[var15].doubleValue() >= var3 && this.xValues[var15].doubleValue() <= var7 && this.yValues[var15].doubleValue() >= var5 && this.yValues[var15].doubleValue() <= var9 && this.zValues[var15] != null) {
            var11 = Math.min(var11, this.zValues[var15].doubleValue());
            var13 = Math.max(var13, this.zValues[var15].doubleValue());
         }
      }

      return new Range(var11, var13);
   }

   public double getMinZValue(double var1, double var3, double var5, double var7) {
      double var9 = 1.0E20D;

      for(int var11 = 0; var11 < this.zValues.length; ++var11) {
         if(this.zValues[var11] != null) {
            var9 = Math.min(var9, this.zValues[var11].doubleValue());
         }
      }

      return var9;
   }

   public int getSeriesCount() {
      return 1;
   }

   public Comparable getSeriesKey(int var1) {
      if(var1 > 0) {
         throw new IllegalArgumentException("Only one series for contour");
      } else {
         return this.seriesKey;
      }
   }

   public int[] getXIndices() {
      return this.xIndex;
   }

   public Number[] getXValues() {
      return this.xValues;
   }

   public Number getX(int var1, int var2) {
      if(var1 > 0) {
         throw new IllegalArgumentException("Only one series for contour");
      } else {
         return this.xValues[var2];
      }
   }

   public Number getXValue(int var1) {
      return this.xValues[var1];
   }

   public Number[] getYValues() {
      return this.yValues;
   }

   public Number getY(int var1, int var2) {
      if(var1 > 0) {
         throw new IllegalArgumentException("Only one series for contour");
      } else {
         return this.yValues[var2];
      }
   }

   public Number[] getZValues() {
      return this.zValues;
   }

   public Number getZ(int var1, int var2) {
      if(var1 > 0) {
         throw new IllegalArgumentException("Only one series for contour");
      } else {
         return this.zValues[var2];
      }
   }

   public int[] indexX() {
      int[] var1 = new int[this.xValues.length];

      for(int var2 = 0; var2 < var1.length; ++var2) {
         var1[var2] = this.indexX(var2);
      }

      return var1;
   }

   public int indexX(int var1) {
      int var2 = Arrays.binarySearch(this.xIndex, var1);
      return var2 >= 0?var2:-1 * var2 - 2;
   }

   public int indexY(int var1) {
      return var1 / this.xValues.length;
   }

   public int indexZ(int var1, int var2) {
      return this.xValues.length * var2 + var1;
   }

   public boolean isDateAxis(int var1) {
      return var1 >= 0 && var1 <= 2?this.dateAxis[var1]:false;
   }

   public void setSeriesKeys(Comparable[] var1) {
      if(var1.length > 1) {
         throw new IllegalArgumentException("Contours only support one series");
      } else {
         this.seriesKey = var1[0];
         this.fireDatasetChanged();
      }
   }
}
