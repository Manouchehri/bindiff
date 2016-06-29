package org.jfree.data.time;

import java.io.Serializable;

public final class TimePeriodAnchor implements Serializable {
   private static final long serialVersionUID = 2011955697457548862L;
   public static final TimePeriodAnchor START = new TimePeriodAnchor("TimePeriodAnchor.START");
   public static final TimePeriodAnchor MIDDLE = new TimePeriodAnchor("TimePeriodAnchor.MIDDLE");
   public static final TimePeriodAnchor END = new TimePeriodAnchor("TimePeriodAnchor.END");
   private String name;

   private TimePeriodAnchor(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof TimePeriodAnchor)) {
         return false;
      } else {
         TimePeriodAnchor var2 = (TimePeriodAnchor)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(START)?START:(this.equals(MIDDLE)?MIDDLE:(this.equals(END)?END:null));
   }
}
