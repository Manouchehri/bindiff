package org.jfree.data.function;

import org.jfree.data.function.Function2D;

public class LineFunction2D implements Function2D {
   private double a;
   private double b;

   public LineFunction2D(double var1, double var3) {
      this.a = var1;
      this.b = var3;
   }

   public double getValue(double var1) {
      return this.a + this.b * var1;
   }
}
