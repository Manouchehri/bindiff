package org.jfree.data;

import java.io.Serializable;

public final class RangeType implements Serializable {
   private static final long serialVersionUID = -9073319010650549239L;
   public static final RangeType FULL = new RangeType("RangeType.FULL");
   public static final RangeType POSITIVE = new RangeType("RangeType.POSITIVE");
   public static final RangeType NEGATIVE = new RangeType("RangeType.NEGATIVE");
   private String name;

   private RangeType(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof RangeType)) {
         return false;
      } else {
         RangeType var2 = (RangeType)var1;
         return this.name.equals(var2.toString());
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(FULL)?FULL:(this.equals(POSITIVE)?POSITIVE:(this.equals(NEGATIVE)?NEGATIVE:null));
   }
}
