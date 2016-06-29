package org.jfree.util;

import java.io.Serializable;

public final class Rotation implements Serializable {
   private static final long serialVersionUID = -4662815260201591676L;
   public static final Rotation CLOCKWISE = new Rotation("Rotation.CLOCKWISE", -1.0D);
   public static final Rotation ANTICLOCKWISE = new Rotation("Rotation.ANTICLOCKWISE", 1.0D);
   private String name;
   private double factor;

   private Rotation(String var1, double var2) {
      this.name = var1;
      this.factor = var2;
   }

   public String toString() {
      return this.name;
   }

   public double getFactor() {
      return this.factor;
   }

   public boolean equals(Object var1) {
      if(this == var1) {
         return true;
      } else if(!(var1 instanceof Rotation)) {
         return false;
      } else {
         Rotation var2 = (Rotation)var1;
         return this.factor == var2.factor;
      }
   }

   public int hashCode() {
      long var1 = Double.doubleToLongBits(this.factor);
      return (int)(var1 ^ var1 >>> 32);
   }

   private Object readResolve() {
      return this.equals(CLOCKWISE)?CLOCKWISE:(this.equals(ANTICLOCKWISE)?ANTICLOCKWISE:null);
   }
}
