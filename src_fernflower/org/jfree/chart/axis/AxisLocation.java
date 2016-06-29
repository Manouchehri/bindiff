package org.jfree.chart.axis;

import java.io.Serializable;

public final class AxisLocation implements Serializable {
   private static final long serialVersionUID = -3276922179323563410L;
   public static final AxisLocation TOP_OR_LEFT = new AxisLocation("AxisLocation.TOP_OR_LEFT");
   public static final AxisLocation TOP_OR_RIGHT = new AxisLocation("AxisLocation.TOP_OR_RIGHT");
   public static final AxisLocation BOTTOM_OR_LEFT = new AxisLocation("AxisLocation.BOTTOM_OR_LEFT");
   public static final AxisLocation BOTTOM_OR_RIGHT = new AxisLocation("AxisLocation.BOTTOM_OR_RIGHT");
   private String name;

   private AxisLocation(String var1) {
      this.name = var1;
   }

   public AxisLocation getOpposite() {
      return getOpposite(this);
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof AxisLocation)) {
         return false;
      } else {
         AxisLocation var2 = (AxisLocation)var1;
         return this.name.equals(var2.toString());
      }
   }

   public static AxisLocation getOpposite(AxisLocation var0) {
      if(var0 == null) {
         throw new IllegalArgumentException("Null \'location\' argument.");
      } else {
         AxisLocation var1 = null;
         if(var0 == TOP_OR_LEFT) {
            var1 = BOTTOM_OR_RIGHT;
         } else if(var0 == TOP_OR_RIGHT) {
            var1 = BOTTOM_OR_LEFT;
         } else if(var0 == BOTTOM_OR_LEFT) {
            var1 = TOP_OR_RIGHT;
         } else {
            if(var0 != BOTTOM_OR_RIGHT) {
               throw new IllegalStateException("AxisLocation not recognised.");
            }

            var1 = TOP_OR_LEFT;
         }

         return var1;
      }
   }

   private Object readResolve() {
      return this.equals(TOP_OR_RIGHT)?TOP_OR_RIGHT:(this.equals(BOTTOM_OR_RIGHT)?BOTTOM_OR_RIGHT:(this.equals(TOP_OR_LEFT)?TOP_OR_LEFT:(this.equals(BOTTOM_OR_LEFT)?BOTTOM_OR_LEFT:null)));
   }
}
