package org.jfree.data.function;

import org.jfree.data.function.Function2D;

public class NormalDistributionFunction2D implements Function2D {
   private double mean;
   private double std;

   public NormalDistributionFunction2D(double var1, double var3) {
      this.mean = var1;
      this.std = var3;
   }

   public double getMean() {
      return this.mean;
   }

   public double getStandardDeviation() {
      return this.std;
   }

   public double getValue(double var1) {
      return Math.exp(-1.0D * (var1 - this.mean) * (var1 - this.mean) / (2.0D * this.std * this.std)) / Math.sqrt(6.283185307179586D * this.std * this.std);
   }
}
