package org.jfree.ui;

import java.io.Serializable;

public final class HorizontalAlignment implements Serializable {
   private static final long serialVersionUID = -8249740987565309567L;
   public static final HorizontalAlignment LEFT = new HorizontalAlignment("HorizontalAlignment.LEFT");
   public static final HorizontalAlignment RIGHT = new HorizontalAlignment("HorizontalAlignment.RIGHT");
   public static final HorizontalAlignment CENTER = new HorizontalAlignment("HorizontalAlignment.CENTER");
   private String name;

   private HorizontalAlignment(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof HorizontalAlignment)) {
         return false;
      } else {
         HorizontalAlignment var2 = (HorizontalAlignment)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      HorizontalAlignment var1 = null;
      if(this.equals(LEFT)) {
         var1 = LEFT;
      } else if(this.equals(RIGHT)) {
         var1 = RIGHT;
      } else if(this.equals(CENTER)) {
         var1 = CENTER;
      }

      return var1;
   }
}
