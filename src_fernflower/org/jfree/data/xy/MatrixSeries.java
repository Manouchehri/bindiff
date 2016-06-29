package org.jfree.data.xy;

import java.io.Serializable;
import org.jfree.data.general.Series;

public class MatrixSeries extends Series implements Serializable {
   private static final long serialVersionUID = 7934188527308315704L;
   protected double[][] data;

   public MatrixSeries(String var1, int var2, int var3) {
      super(var1);
      this.data = new double[var2][var3];
      this.zeroAll();
   }

   public int getColumnsCount() {
      return this.data[0].length;
   }

   public Number getItem(int var1) {
      int var2 = this.getItemRow(var1);
      int var3 = this.getItemColumn(var1);
      Double var4 = new Double(this.get(var2, var3));
      return var4;
   }

   public int getItemColumn(int var1) {
      return var1 % this.getColumnsCount();
   }

   public int getItemCount() {
      return this.getRowCount() * this.getColumnsCount();
   }

   public int getItemRow(int var1) {
      return var1 / this.getColumnsCount();
   }

   public int getRowCount() {
      return this.data.length;
   }

   public double get(int var1, int var2) {
      return this.data[var1][var2];
   }

   public void update(int var1, int var2, double var3) {
      this.data[var1][var2] = var3;
      this.fireSeriesChanged();
   }

   public void zeroAll() {
      int var1 = this.getRowCount();
      int var2 = this.getColumnsCount();

      for(int var3 = 0; var3 < var1; ++var3) {
         for(int var4 = 0; var4 < var2; ++var4) {
            this.data[var3][var4] = 0.0D;
         }
      }

      this.fireSeriesChanged();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof MatrixSeries)) {
         return false;
      } else {
         MatrixSeries var2 = (MatrixSeries)var1;
         if(this.getRowCount() != var2.getRowCount()) {
            return false;
         } else if(this.getColumnsCount() != var2.getColumnsCount()) {
            return false;
         } else {
            for(int var3 = 0; var3 < this.getRowCount(); ++var3) {
               for(int var4 = 0; var4 < this.getColumnsCount(); ++var4) {
                  if(this.get(var3, var4) != var2.get(var3, var4)) {
                     return false;
                  }
               }
            }

            return super.equals(var1);
         }
      }
   }
}
