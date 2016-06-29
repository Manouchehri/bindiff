package org.jfree.data.xy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jfree.data.general.DatasetChangeEvent;
import org.jfree.data.xy.AbstractIntervalXYDataset;

public class DefaultIntervalXYDataset extends AbstractIntervalXYDataset {
   private List seriesKeys = new ArrayList();
   private List seriesList = new ArrayList();

   public int getSeriesCount() {
      return this.seriesList.size();
   }

   public Comparable getSeriesKey(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         return (Comparable)this.seriesKeys.get(var1);
      } else {
         throw new IllegalArgumentException("Series index out of bounds");
      }
   }

   public int getItemCount(int var1) {
      if(var1 >= 0 && var1 < this.getSeriesCount()) {
         double[][] var2 = (double[][])((double[][])this.seriesList.get(var1));
         return var2[0].length;
      } else {
         throw new IllegalArgumentException("Series index out of bounds");
      }
   }

   public double getXValue(int var1, int var2) {
      double[][] var3 = (double[][])((double[][])this.seriesList.get(var1));
      return var3[0][var2];
   }

   public double getYValue(int var1, int var2) {
      double[][] var3 = (double[][])((double[][])this.seriesList.get(var1));
      return var3[3][var2];
   }

   public double getStartXValue(int var1, int var2) {
      double[][] var3 = (double[][])((double[][])this.seriesList.get(var1));
      return var3[1][var2];
   }

   public double getEndXValue(int var1, int var2) {
      double[][] var3 = (double[][])((double[][])this.seriesList.get(var1));
      return var3[2][var2];
   }

   public double getStartYValue(int var1, int var2) {
      double[][] var3 = (double[][])((double[][])this.seriesList.get(var1));
      return var3[4][var2];
   }

   public double getEndYValue(int var1, int var2) {
      double[][] var3 = (double[][])((double[][])this.seriesList.get(var1));
      return var3[5][var2];
   }

   public Number getEndX(int var1, int var2) {
      return new Double(this.getEndXValue(var1, var2));
   }

   public Number getEndY(int var1, int var2) {
      return new Double(this.getEndYValue(var1, var2));
   }

   public Number getStartX(int var1, int var2) {
      return new Double(this.getStartXValue(var1, var2));
   }

   public Number getStartY(int var1, int var2) {
      return new Double(this.getStartYValue(var1, var2));
   }

   public Number getX(int var1, int var2) {
      return new Double(this.getXValue(var1, var2));
   }

   public Number getY(int var1, int var2) {
      return new Double(this.getYValue(var1, var2));
   }

   public void addSeries(Comparable var1, double[][] var2) {
      if(var1 == null) {
         throw new IllegalArgumentException("The \'seriesKey\' cannot be null.");
      } else if(var2 == null) {
         throw new IllegalArgumentException("The \'data\' is null.");
      } else if(var2.length != 6) {
         throw new IllegalArgumentException("The \'data\' array must have length == 6.");
      } else {
         int var3 = var2[0].length;
         if(var3 == var2[1].length && var3 == var2[2].length && var3 == var2[3].length && var3 == var2[4].length && var3 == var2[5].length) {
            int var4 = this.indexOf(var1);
            if(var4 == -1) {
               this.seriesKeys.add(var1);
               this.seriesList.add(var2);
            } else {
               this.seriesList.remove(var4);
               this.seriesList.add(var4, var2);
            }

            this.notifyListeners(new DatasetChangeEvent(this, this));
         } else {
            throw new IllegalArgumentException("The \'data\' array must contain two arrays with equal length.");
         }
      }
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof DefaultIntervalXYDataset)) {
         return false;
      } else {
         DefaultIntervalXYDataset var2 = (DefaultIntervalXYDataset)var1;
         if(!this.seriesKeys.equals(var2.seriesKeys)) {
            return false;
         } else {
            for(int var3 = 0; var3 < this.seriesList.size(); ++var3) {
               double[][] var4 = (double[][])((double[][])this.seriesList.get(var3));
               double[][] var5 = (double[][])((double[][])var2.seriesList.get(var3));
               double[] var6 = var4[0];
               double[] var7 = var5[0];
               if(!Arrays.equals(var6, var7)) {
                  return false;
               }

               double[] var8 = var4[1];
               double[] var9 = var5[1];
               if(!Arrays.equals(var8, var9)) {
                  return false;
               }

               double[] var10 = var4[2];
               double[] var11 = var5[2];
               if(!Arrays.equals(var10, var11)) {
                  return false;
               }

               double[] var12 = var4[3];
               double[] var13 = var5[3];
               if(!Arrays.equals(var12, var13)) {
                  return false;
               }

               double[] var14 = var4[4];
               double[] var15 = var5[4];
               if(!Arrays.equals(var14, var15)) {
                  return false;
               }

               double[] var16 = var4[5];
               double[] var17 = var5[5];
               if(!Arrays.equals(var16, var17)) {
                  return false;
               }
            }

            return true;
         }
      }
   }

   public int hashCode() {
      int var1 = this.seriesKeys.hashCode();
      var1 = 29 * var1 + this.seriesList.hashCode();
      return var1;
   }

   public Object clone() {
      DefaultIntervalXYDataset var1 = (DefaultIntervalXYDataset)super.clone();
      var1.seriesKeys = new ArrayList(this.seriesKeys);
      var1.seriesList = new ArrayList(this.seriesList.size());

      for(int var2 = 0; var2 < this.seriesList.size(); ++var2) {
         double[][] var3 = (double[][])((double[][])this.seriesList.get(var2));
         double[] var4 = var3[0];
         double[] var5 = var3[1];
         double[] var6 = var3[2];
         double[] var7 = var3[3];
         double[] var8 = var3[4];
         double[] var9 = var3[5];
         double[] var10 = new double[var4.length];
         double[] var11 = new double[var5.length];
         double[] var12 = new double[var6.length];
         double[] var13 = new double[var7.length];
         double[] var14 = new double[var8.length];
         double[] var15 = new double[var9.length];
         System.arraycopy(var4, 0, var10, 0, var4.length);
         System.arraycopy(var5, 0, var11, 0, var5.length);
         System.arraycopy(var6, 0, var12, 0, var6.length);
         System.arraycopy(var7, 0, var13, 0, var7.length);
         System.arraycopy(var8, 0, var14, 0, var8.length);
         System.arraycopy(var9, 0, var15, 0, var9.length);
         var1.seriesList.add(var2, new double[][]{var10, var11, var12, var13, var14, var15});
      }

      return var1;
   }
}
