package com.google.common.math;

import com.google.common.math.LinearTransformation;

final class LinearTransformation$VerticalLinearTransformation extends LinearTransformation {
   final double x;

   LinearTransformation$VerticalLinearTransformation(double var1) {
      this.x = var1;
   }

   public boolean isVertical() {
      return true;
   }

   public boolean isHorizontal() {
      return false;
   }

   public double slope() {
      throw new IllegalStateException();
   }

   public double transformX(double var1) {
      throw new IllegalStateException();
   }

   public double transformY(double var1) {
      return this.x;
   }

   public String toString() {
      return String.format("x = %g", new Object[]{Double.valueOf(this.x)});
   }
}
