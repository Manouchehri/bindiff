package org.jfree.chart.entity;

import java.awt.Shape;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.xy.XYDataset;

public class XYItemEntity extends ChartEntity {
   private static final long serialVersionUID = -3870862224880283771L;
   private transient XYDataset dataset;
   private int series;
   private int item;

   public XYItemEntity(Shape var1, XYDataset var2, int var3, int var4, String var5, String var6) {
      super(var1, var5, var6);
      this.dataset = var2;
      this.series = var3;
      this.item = var4;
   }

   public XYDataset getDataset() {
      return this.dataset;
   }

   public void setDataset(XYDataset var1) {
      this.dataset = var1;
   }

   public int getSeriesIndex() {
      return this.series;
   }

   public void setSeriesIndex(int var1) {
      this.series = var1;
   }

   public int getItem() {
      return this.item;
   }

   public void setItem(int var1) {
      this.item = var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof XYItemEntity && super.equals(var1)) {
         XYItemEntity var2 = (XYItemEntity)var1;
         return this.series != var2.series?false:this.item == var2.item;
      } else {
         return false;
      }
   }

   public String toString() {
      return "XYItemEntity: series = " + this.getSeriesIndex() + ", item = " + this.getItem() + ", dataset = " + this.getDataset();
   }
}
