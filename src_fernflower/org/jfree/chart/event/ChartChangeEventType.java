package org.jfree.chart.event;

import java.io.Serializable;

public final class ChartChangeEventType implements Serializable {
   private static final long serialVersionUID = 5481917022435735602L;
   public static final ChartChangeEventType GENERAL = new ChartChangeEventType("ChartChangeEventType.GENERAL");
   public static final ChartChangeEventType NEW_DATASET = new ChartChangeEventType("ChartChangeEventType.NEW_DATASET");
   public static final ChartChangeEventType DATASET_UPDATED = new ChartChangeEventType("ChartChangeEventType.DATASET_UPDATED");
   private String name;

   private ChartChangeEventType(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof ChartChangeEventType)) {
         return false;
      } else {
         ChartChangeEventType var2 = (ChartChangeEventType)var1;
         return this.name.equals(var2.toString());
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(GENERAL)?GENERAL:(this.equals(NEW_DATASET)?NEW_DATASET:(this.equals(DATASET_UPDATED)?DATASET_UPDATED:null));
   }
}
