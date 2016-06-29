package org.jfree.ui;

import java.io.Serializable;

public final class VerticalAlignment implements Serializable {
   private static final long serialVersionUID = 7272397034325429853L;
   public static final VerticalAlignment TOP = new VerticalAlignment("VerticalAlignment.TOP");
   public static final VerticalAlignment BOTTOM = new VerticalAlignment("VerticalAlignment.BOTTOM");
   public static final VerticalAlignment CENTER = new VerticalAlignment("VerticalAlignment.CENTER");
   private String name;

   private VerticalAlignment(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof VerticalAlignment)) {
         return false;
      } else {
         VerticalAlignment var2 = (VerticalAlignment)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      return this.equals(TOP)?TOP:(this.equals(BOTTOM)?BOTTOM:(this.equals(CENTER)?CENTER:null));
   }
}
