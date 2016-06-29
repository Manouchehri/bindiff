package org.jfree.util;

import java.io.Serializable;

public final class UnitType implements Serializable {
   private static final long serialVersionUID = 6531925392288519884L;
   public static final UnitType ABSOLUTE = new UnitType("UnitType.ABSOLUTE");
   public static final UnitType RELATIVE = new UnitType("UnitType.RELATIVE");
   private String name;

   private UnitType(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else if(!(var1 instanceof UnitType)) {
         return false;
      } else {
         UnitType var2 = (UnitType)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(ABSOLUTE)?ABSOLUTE:(this.equals(RELATIVE)?RELATIVE:null);
   }
}
