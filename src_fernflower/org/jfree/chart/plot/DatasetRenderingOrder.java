package org.jfree.chart.plot;

import java.io.Serializable;

public final class DatasetRenderingOrder implements Serializable {
   private static final long serialVersionUID = -600593412366385072L;
   public static final DatasetRenderingOrder FORWARD = new DatasetRenderingOrder("DatasetRenderingOrder.FORWARD");
   public static final DatasetRenderingOrder REVERSE = new DatasetRenderingOrder("DatasetRenderingOrder.REVERSE");
   private String name;

   private DatasetRenderingOrder(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof DatasetRenderingOrder)) {
         return false;
      } else {
         DatasetRenderingOrder var2 = (DatasetRenderingOrder)var1;
         return this.name.equals(var2.toString());
      }
   }

   private Object readResolve() {
      return this.equals(FORWARD)?FORWARD:(this.equals(REVERSE)?REVERSE:null);
   }
}
