package org.jfree.chart.axis;

import java.io.Serializable;

public final class CategoryAnchor implements Serializable {
   private static final long serialVersionUID = -2604142742210173810L;
   public static final CategoryAnchor START = new CategoryAnchor("CategoryAnchor.START");
   public static final CategoryAnchor MIDDLE = new CategoryAnchor("CategoryAnchor.MIDDLE");
   public static final CategoryAnchor END = new CategoryAnchor("CategoryAnchor.END");
   private String name;

   private CategoryAnchor(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof CategoryAnchor)) {
         return false;
      } else {
         CategoryAnchor var2 = (CategoryAnchor)var1;
         return this.name.equals(var2.toString());
      }
   }

   private Object readResolve() {
      return this.equals(START)?START:(this.equals(MIDDLE)?MIDDLE:(this.equals(END)?END:null));
   }
}
