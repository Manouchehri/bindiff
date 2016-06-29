package org.jfree.chart.block;

import java.io.Serializable;

public final class LengthConstraintType implements Serializable {
   private static final long serialVersionUID = -1156658804028142978L;
   public static final LengthConstraintType NONE = new LengthConstraintType("LengthConstraintType.NONE");
   public static final LengthConstraintType RANGE = new LengthConstraintType("RectangleConstraintType.RANGE");
   public static final LengthConstraintType FIXED = new LengthConstraintType("LengthConstraintType.FIXED");
   private String name;

   private LengthConstraintType(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof LengthConstraintType)) {
         return false;
      } else {
         LengthConstraintType var2 = (LengthConstraintType)var1;
         return this.name.equals(var2.toString());
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(NONE)?NONE:(this.equals(RANGE)?RANGE:(this.equals(FIXED)?FIXED:null));
   }
}
