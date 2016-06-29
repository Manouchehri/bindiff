package org.jfree.ui;

import java.io.Serializable;

public final class Layer implements Serializable {
   private static final long serialVersionUID = -1470104570733183430L;
   public static final Layer FOREGROUND = new Layer("Layer.FOREGROUND");
   public static final Layer BACKGROUND = new Layer("Layer.BACKGROUND");
   private String name;

   private Layer(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof Layer)) {
         return false;
      } else {
         Layer var2 = (Layer)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      Layer var1 = null;
      if(this.equals(FOREGROUND)) {
         var1 = FOREGROUND;
      } else if(this.equals(BACKGROUND)) {
         var1 = BACKGROUND;
      }

      return var1;
   }
}
