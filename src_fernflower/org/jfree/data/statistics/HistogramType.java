package org.jfree.data.statistics;

import java.io.Serializable;

public class HistogramType implements Serializable {
   private static final long serialVersionUID = 2618927186251997727L;
   public static final HistogramType FREQUENCY = new HistogramType("FREQUENCY");
   public static final HistogramType RELATIVE_FREQUENCY = new HistogramType("RELATIVE_FREQUENCY");
   public static final HistogramType SCALE_AREA_TO_1 = new HistogramType("SCALE_AREA_TO_1");
   private String name;

   private HistogramType(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(var1 == null) {
         return false;
      } else if(var1 == this) {
         return true;
      } else if(!(var1 instanceof HistogramType)) {
         return false;
      } else {
         HistogramType var2 = (HistogramType)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(FREQUENCY)?FREQUENCY:(this.equals(RELATIVE_FREQUENCY)?RELATIVE_FREQUENCY:(this.equals(SCALE_AREA_TO_1)?SCALE_AREA_TO_1:null));
   }
}
