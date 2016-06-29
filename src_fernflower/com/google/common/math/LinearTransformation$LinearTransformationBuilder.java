package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.LinearTransformation;
import com.google.common.math.LinearTransformation$1;
import com.google.common.math.LinearTransformation$RegularLinearTransformation;
import com.google.common.math.LinearTransformation$VerticalLinearTransformation;

public final class LinearTransformation$LinearTransformationBuilder {
   private final double x1;
   private final double y1;

   private LinearTransformation$LinearTransformationBuilder(double var1, double var3) {
      this.x1 = var1;
      this.y1 = var3;
   }

   public LinearTransformation and(double var1, double var3) {
      Preconditions.checkArgument(DoubleUtils.isFinite(var1) && DoubleUtils.isFinite(var3));
      if(var1 == this.x1) {
         Preconditions.checkArgument(var3 != this.y1);
         return new LinearTransformation$VerticalLinearTransformation(this.x1);
      } else {
         return this.withSlope((var3 - this.y1) / (var1 - this.x1));
      }
   }

   public LinearTransformation withSlope(double var1) {
      Preconditions.checkArgument(!Double.isNaN(var1));
      if(DoubleUtils.isFinite(var1)) {
         double var3 = this.y1 - this.x1 * var1;
         return new LinearTransformation$RegularLinearTransformation(var1, var3);
      } else {
         return new LinearTransformation$VerticalLinearTransformation(this.x1);
      }
   }

   // $FF: synthetic method
   LinearTransformation$LinearTransformationBuilder(double var1, double var3, LinearTransformation$1 var5) {
      this(var1, var3);
   }
}
