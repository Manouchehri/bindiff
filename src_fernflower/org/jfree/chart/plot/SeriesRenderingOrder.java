package org.jfree.chart.plot;

import java.io.Serializable;

public final class SeriesRenderingOrder implements Serializable {
   private static final long serialVersionUID = 209336477448807735L;
   public static final SeriesRenderingOrder FORWARD = new SeriesRenderingOrder("SeriesRenderingOrder.FORWARD");
   public static final SeriesRenderingOrder REVERSE = new SeriesRenderingOrder("SeriesRenderingOrder.REVERSE");
   private String name;

   private SeriesRenderingOrder(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof SeriesRenderingOrder)) {
         return false;
      } else {
         SeriesRenderingOrder var2 = (SeriesRenderingOrder)var1;
         return this.name.equals(var2.toString());
      }
   }

   private Object readResolve() {
      return this.equals(FORWARD)?FORWARD:(this.equals(REVERSE)?REVERSE:null);
   }
}
