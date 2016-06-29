package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.LinearTransformation;

final class LinearTransformation$RegularLinearTransformation extends LinearTransformation {
   final double slope;
   final double yIntercept;

   LinearTransformation$RegularLinearTransformation(double var1, double var3) {
      this.slope = var1;
      this.yIntercept = var3;
   }

   public boolean isVertical() {
      return false;
   }

   public boolean isHorizontal() {
      return this.slope == 0.0D;
   }

   public double slope() {
      return this.slope;
   }

   public double transformX(double var1) {
      return var1 * this.slope + this.yIntercept;
   }

   public double transformY(double var1) {
      Preconditions.checkState(this.slope != 0.0D);
      return (var1 - this.yIntercept) / this.slope;
   }

   public String toString() {
      return String.format("y = %g * x + %g", new Object[]{Double.valueOf(this.slope), Double.valueOf(this.yIntercept)});
   }
}
