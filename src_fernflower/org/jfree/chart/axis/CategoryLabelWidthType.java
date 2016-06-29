package org.jfree.chart.axis;

import java.io.Serializable;

public final class CategoryLabelWidthType implements Serializable {
   private static final long serialVersionUID = -6976024792582949656L;
   public static final CategoryLabelWidthType CATEGORY = new CategoryLabelWidthType("CategoryLabelWidthType.CATEGORY");
   public static final CategoryLabelWidthType RANGE = new CategoryLabelWidthType("CategoryLabelWidthType.RANGE");
   private String name;

   private CategoryLabelWidthType(String var1) {
      if(var1 == null) {
         throw new IllegalArgumentException("Null \'name\' argument.");
      } else {
         this.name = var1;
      }
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof CategoryLabelWidthType)) {
         return false;
      } else {
         CategoryLabelWidthType var2 = (CategoryLabelWidthType)var1;
         return this.name.equals(var2.toString());
      }
   }

   private Object readResolve() {
      return this.equals(CATEGORY)?CATEGORY:(this.equals(RANGE)?RANGE:null);
   }
}
