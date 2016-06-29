package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;

public class ContourEntity extends ChartEntity implements Serializable, Cloneable {
   private static final long serialVersionUID = 1249570520505992847L;
   private int index = -1;

   public ContourEntity(Shape var1, String var2) {
      super(var1, var2);
   }

   public ContourEntity(Shape var1, String var2, String var3) {
      super(var1, var2, var3);
   }

   public int getIndex() {
      return this.index;
   }

   public void setIndex(int var1) {
      this.index = var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(var1 instanceof ContourEntity && super.equals(var1)) {
         ContourEntity var2 = (ContourEntity)var1;
         return this.index == var2.index;
      } else {
         return false;
      }
   }

   public Object clone() {
      return super.clone();
   }
}
