package org.jfree.chart;

import java.io.Serializable;

public final class LegendRenderingOrder implements Serializable {
   private static final long serialVersionUID = -3832486612685808616L;
   public static final LegendRenderingOrder STANDARD = new LegendRenderingOrder("LegendRenderingOrder.STANDARD");
   public static final LegendRenderingOrder REVERSE = new LegendRenderingOrder("LegendRenderingOrder.REVERSE");
   private String name;

   private LegendRenderingOrder(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof LegendRenderingOrder)) {
         return false;
      } else {
         LegendRenderingOrder var2 = (LegendRenderingOrder)var1;
         return this.name.equals(var2.toString());
      }
   }

   private Object readResolve() {
      return this.equals(STANDARD)?STANDARD:(this.equals(REVERSE)?REVERSE:null);
   }
}
