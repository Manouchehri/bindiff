package org.jfree.ui;

import java.io.Serializable;

public final class GradientPaintTransformType implements Serializable {
   private static final long serialVersionUID = 8331561784933982450L;
   public static final GradientPaintTransformType VERTICAL = new GradientPaintTransformType("GradientPaintTransformType.VERTICAL");
   public static final GradientPaintTransformType HORIZONTAL = new GradientPaintTransformType("GradientPaintTransformType.HORIZONTAL");
   public static final GradientPaintTransformType CENTER_VERTICAL = new GradientPaintTransformType("GradientPaintTransformType.CENTER_VERTICAL");
   public static final GradientPaintTransformType CENTER_HORIZONTAL = new GradientPaintTransformType("GradientPaintTransformType.CENTER_HORIZONTAL");
   private String name;

   private GradientPaintTransformType(String var1) {
      this.name = var1;
   }

   public String toString() {
      return this.name;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof GradientPaintTransformType)) {
         return false;
      } else {
         GradientPaintTransformType var2 = (GradientPaintTransformType)var1;
         return this.name.equals(var2.name);
      }
   }

   public int hashCode() {
      return this.name.hashCode();
   }

   private Object readResolve() {
      GradientPaintTransformType var1 = null;
      if(this.equals(HORIZONTAL)) {
         var1 = HORIZONTAL;
      } else if(this.equals(VERTICAL)) {
         var1 = VERTICAL;
      } else if(this.equals(CENTER_HORIZONTAL)) {
         var1 = CENTER_HORIZONTAL;
      } else if(this.equals(CENTER_VERTICAL)) {
         var1 = CENTER_VERTICAL;
      }

      return var1;
   }
}
