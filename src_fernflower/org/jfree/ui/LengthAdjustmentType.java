package org.jfree.ui;

import java.io.Serializable;

public final class LengthAdjustmentType implements Serializable {
   private static final long serialVersionUID = -6097408511380545010L;
   public static final LengthAdjustmentType NO_CHANGE = new LengthAdjustmentType("NO_CHANGE");
   public static final LengthAdjustmentType EXPAND = new LengthAdjustmentType("EXPAND");
   public static final LengthAdjustmentType CONTRACT = new LengthAdjustmentType("CONTRACT");
   private String name;

   private LengthAdjustmentType(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof LengthAdjustmentType)) {
         return false;
      } else {
         LengthAdjustmentType var2 = (LengthAdjustmentType)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(NO_CHANGE)?NO_CHANGE:(this.equals(EXPAND)?EXPAND:(this.equals(CONTRACT)?CONTRACT:null));
   }
}
