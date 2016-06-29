package org.jfree.data;

public final class KeyedValueComparatorType {
   public static final KeyedValueComparatorType BY_KEY = new KeyedValueComparatorType("KeyedValueComparatorType.BY_KEY");
   public static final KeyedValueComparatorType BY_VALUE = new KeyedValueComparatorType("KeyedValueComparatorType.BY_VALUE");
   private String name;

   private KeyedValueComparatorType(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof KeyedValueComparatorType)) {
         return false;
      } else {
         KeyedValueComparatorType var2 = (KeyedValueComparatorType)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }
}
