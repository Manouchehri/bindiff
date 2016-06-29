package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;

public class LegendItemEntity extends ChartEntity implements Serializable, Cloneable {
   private static final long serialVersionUID = -7435683933545666702L;
   private int seriesIndex;

   public LegendItemEntity(Shape var1) {
      super(var1);
   }

   public int getSeriesIndex() {
      return this.seriesIndex;
   }

   public void setSeriesIndex(int var1) {
      this.seriesIndex = var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof LegendItemEntity && super.equals(var1)) {
         LegendItemEntity var2 = (LegendItemEntity)var1;
         return this.seriesIndex == var2.seriesIndex;
      } else {
         return false;
      }
   }

   public Object clone() {
      return super.clone();
   }
}
