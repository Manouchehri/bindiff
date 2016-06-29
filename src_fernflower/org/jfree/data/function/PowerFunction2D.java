package org.jfree.data.function;

import org.jfree.data.function.Function2D;

public class PowerFunction2D implements Function2D {
   private double a;
   private double b;

   public PowerFunction2D(double var1, double var3) {
      this.a = var1;
      this.b = var3;
   }

   public double getValue(double var1) {
      return this.a * Math.pow(var1, this.b);
   }
}
