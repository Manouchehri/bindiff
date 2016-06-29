package org.jfree.data.xy;

import org.jfree.data.xy.MatrixSeries;

public class NormalizedMatrixSeries extends MatrixSeries {
   public static final double DEFAULT_SCALE_FACTOR = 1.0D;
   private double m_scaleFactor = 1.0D;
   private double m_totalSum = Double.MIN_VALUE;

   public NormalizedMatrixSeries(String var1, int var2, int var3) {
      super(var1, var2, var3);
   }

   public Number getItem(int var1) {
      int var2 = this.getItemRow(var1);
      int var3 = this.getItemColumn(var1);
      double var4 = this.get(var2, var3) * this.m_scaleFactor;
      Double var6 = new Double(var4 / this.m_totalSum);
      return var6;
   }

   public void setScaleFactor(double var1) {
      this.m_scaleFactor = var1;
   }

   public double getScaleFactor() {
      return this.m_scaleFactor;
   }

   public void update(int var1, int var2, double var3) {
      this.m_totalSum -= this.get(var1, var2);
      this.m_totalSum += var3;
      super.update(var1, var2, var3);
   }

   public void zeroAll() {
      this.m_totalSum = 0.0D;
      super.zeroAll();
   }
}
