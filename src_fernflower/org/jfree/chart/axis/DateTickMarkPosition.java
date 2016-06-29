package org.jfree.chart.axis;

import java.io.Serializable;

public final class DateTickMarkPosition implements Serializable {
   private static final long serialVersionUID = 2540750672764537240L;
   public static final DateTickMarkPosition START = new DateTickMarkPosition("DateTickMarkPosition.START");
   public static final DateTickMarkPosition MIDDLE = new DateTickMarkPosition("DateTickMarkPosition.MIDDLE");
   public static final DateTickMarkPosition END = new DateTickMarkPosition("DateTickMarkPosition.END");
   private String name;

   private DateTickMarkPosition(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof DateTickMarkPosition)) {
         return false;
      } else {
         DateTickMarkPosition var2 = (DateTickMarkPosition)var1;
         return this.name.equals(var2.toString());
      }
   }

   private Object readResolve() {
      return this.equals(START)?START:(this.equals(MIDDLE)?MIDDLE:(this.equals(END)?END:null));
   }
}
