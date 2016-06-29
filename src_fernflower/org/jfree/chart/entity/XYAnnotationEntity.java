package org.jfree.chart.entity;

import java.awt.Shape;
import java.io.Serializable;
import org.jfree.chart.entity.ChartEntity;

public class XYAnnotationEntity extends ChartEntity implements Serializable {
   private static final long serialVersionUID = 2340334068383660799L;
   private int rendererIndex;

   public XYAnnotationEntity(Shape var1, int var2, String var3, String var4) {
      super(var1, var3, var4);
      this.rendererIndex = var2;
   }

   public int getRendererIndex() {
      return this.rendererIndex;
   }

   public void setRendererIndex(int var1) {
      this.rendererIndex = var1;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!super.equals(var1)) {
         return false;
      } else if(!(var1 instanceof XYAnnotationEntity)) {
         return false;
      } else {
         XYAnnotationEntity var2 = (XYAnnotationEntity)var1;
         return this.rendererIndex == var2.rendererIndex;
      }
   }
}
