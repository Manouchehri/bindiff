package org.jfree.chart.renderer.xy;

import org.jfree.data.DomainOrder;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.xy.XYDataset;

public class CyclicXYItemRenderer$OverwriteDataSet implements XYDataset {
   protected XYDataset delegateSet;
   Double[] x;
   Double[] y;

   public CyclicXYItemRenderer$OverwriteDataSet(double[] var1, double[] var2, XYDataset var3) {
      this.delegateSet = var3;
      this.x = new Double[var1.length];
      this.y = new Double[var2.length];

      for(int var4 = 0; var4 < var1.length; ++var4) {
         this.x[var4] = new Double(var1[var4]);
         this.y[var4] = new Double(var2[var4]);
      }

   }

   public DomainOrder getDomainOrder() {
      return DomainOrder.NONE;
   }

   public int getItemCount(int var1) {
      return this.x.length;
   }

   public Number getX(int var1, int var2) {
      return this.x[var2];
   }

   public double getXValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getX(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public Number getY(int var1, int var2) {
      return this.y[var2];
   }

   public double getYValue(int var1, int var2) {
      double var3 = Double.NaN;
      Number var5 = this.getY(var1, var2);
      if(var5 != null) {
         var3 = var5.doubleValue();
      }

      return var3;
   }

   public int getSeriesCount() {
      return this.delegateSet.getSeriesCount();
   }

   public Comparable getSeriesKey(int var1) {
      return this.delegateSet.getSeriesKey(var1);
   }

   public int indexOf(Comparable var1) {
      return this.delegateSet.indexOf(var1);
   }

   public void addChangeListener(DatasetChangeListener var1) {
   }

   public void removeChangeListener(DatasetChangeListener var1) {
   }

   public DatasetGroup getGroup() {
      return this.delegateSet.getGroup();
   }

   public void setGroup(DatasetGroup var1) {
   }
}
