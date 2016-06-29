package org.jfree.chart.plot;

import java.io.Serializable;

public final class DialShape implements Serializable {
   private static final long serialVersionUID = -3471933055190251131L;
   public static final DialShape CIRCLE = new DialShape("DialShape.CIRCLE");
   public static final DialShape CHORD = new DialShape("DialShape.CHORD");
   public static final DialShape PIE = new DialShape("DialShape.PIE");
   private String name;

   private DialShape(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof DialShape)) {
         return false;
      } else {
         DialShape var2 = (DialShape)var1;
         return this.name.equals(var2.toString());
      }
   }

   private Object readResolve() {
      return this.equals(CIRCLE)?CIRCLE:(this.equals(CHORD)?CHORD:(this.equals(PIE)?PIE:null));
   }
}
