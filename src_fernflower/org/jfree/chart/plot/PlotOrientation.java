package org.jfree.chart.plot;

import java.io.Serializable;

public final class PlotOrientation implements Serializable {
   private static final long serialVersionUID = -2508771828190337782L;
   public static final PlotOrientation HORIZONTAL = new PlotOrientation("PlotOrientation.HORIZONTAL");
   public static final PlotOrientation VERTICAL = new PlotOrientation("PlotOrientation.VERTICAL");
   private String name;

   private PlotOrientation(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof PlotOrientation)) {
         return false;
      } else {
         PlotOrientation var2 = (PlotOrientation)var1;
         return this.name.equals(var2.toString());
      }
   }

   private Object readResolve() {
      PlotOrientation var1 = null;
      if(this.equals(HORIZONTAL)) {
         var1 = HORIZONTAL;
      } else if(this.equals(VERTICAL)) {
         var1 = VERTICAL;
      }

      return var1;
   }
}
