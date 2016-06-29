package org.jfree.chart.renderer;

import java.io.Serializable;

public final class AreaRendererEndType implements Serializable {
   private static final long serialVersionUID = -1774146392916359839L;
   public static final AreaRendererEndType TAPER = new AreaRendererEndType("AreaRendererEndType.TAPER");
   public static final AreaRendererEndType TRUNCATE = new AreaRendererEndType("AreaRendererEndType.TRUNCATE");
   public static final AreaRendererEndType LEVEL = new AreaRendererEndType("AreaRendererEndType.LEVEL");
   private String name;

   private AreaRendererEndType(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof AreaRendererEndType)) {
         return false;
      } else {
         AreaRendererEndType var2 = (AreaRendererEndType)var1;
         return this.name.equals(var2.toString());
      }
   }

   private Object readResolve() {
      AreaRendererEndType var1 = null;
      if(this.equals(LEVEL)) {
         var1 = LEVEL;
      } else if(this.equals(TAPER)) {
         var1 = TAPER;
      } else if(this.equals(TRUNCATE)) {
         var1 = TRUNCATE;
      }

      return var1;
   }
}
