package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.LongMath;
import com.google.common.math.Quantiles;
import com.google.common.math.Quantiles$1;
import com.google.common.primitives.Doubles;
import java.math.RoundingMode;
import java.util.Collection;

public final class Quantiles$ScaleAndIndex {
   private final int scale;
   private final int index;

   private Quantiles$ScaleAndIndex(int var1, int var2) {
      Quantiles.access$300(var2, var1);
      this.scale = var1;
      this.index = var2;
   }

   public double compute(Collection var1) {
      return this.computeInPlace(Doubles.toArray(var1));
   }

   public double compute(double... var1) {
      return this.computeInPlace((double[])var1.clone());
   }

   public double compute(long... var1) {
      return this.computeInPlace(Quantiles.access$400(var1));
   }

   public double compute(int... var1) {
      return this.computeInPlace(Quantiles.access$500(var1));
   }

   public double computeInPlace(double... var1) {
      Preconditions.checkArgument(var1.length > 0, "Cannot calculate quantiles of an empty dataset");
      long var2 = (long)this.index * (long)(var1.length - 1);
      int var4 = (int)LongMath.divide(var2, (long)this.scale, RoundingMode.DOWN);
      int var5 = (int)(var2 - (long)var4 * (long)this.scale);
      Quantiles.access$600(var4, var1, 0, var1.length - 1);
      if(var5 == 0) {
         return var1[var4];
      } else {
         Quantiles.access$600(var4 + 1, var1, var4 + 1, var1.length - 1);
         return var1[var4] + (var1[var4 + 1] - var1[var4]) * (double)var5 / (double)this.scale;
      }
   }

   // $FF: synthetic method
   Quantiles$ScaleAndIndex(int var1, int var2, Quantiles$1 var3) {
      this(var1, var2);
   }
}
