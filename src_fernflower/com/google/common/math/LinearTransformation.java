package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.LinearTransformation$1;
import com.google.common.math.LinearTransformation$LinearTransformationBuilder;
import com.google.common.math.LinearTransformation$RegularLinearTransformation;
import com.google.common.math.LinearTransformation$VerticalLinearTransformation;

@GoogleInternal
public abstract class LinearTransformation {
   public static LinearTransformation$LinearTransformationBuilder mapping(double var0, double var2) {
      Preconditions.checkArgument(DoubleUtils.isFinite(var0) && DoubleUtils.isFinite(var2));
      return new LinearTransformation$LinearTransformationBuilder(var0, var2, (LinearTransformation$1)null);
   }

   public static LinearTransformation vertical(double var0) {
      Preconditions.checkArgument(DoubleUtils.isFinite(var0));
      return new LinearTransformation$VerticalLinearTransformation(var0);
   }

   public static LinearTransformation horizontal(double var0) {
      Preconditions.checkArgument(DoubleUtils.isFinite(var0));
      double var2 = 0.0D;
      return new LinearTransformation$RegularLinearTransformation(var2, var0);
   }

   public abstract boolean isVertical();

   public abstract boolean isHorizontal();

   public abstract double slope();

   public abstract double transformX(double var1);

   public abstract double transformY(double var1);
}
