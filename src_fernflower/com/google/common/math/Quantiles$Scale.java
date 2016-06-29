package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.math.Quantiles$1;
import com.google.common.math.Quantiles$ScaleAndIndex;
import com.google.common.math.Quantiles$ScaleAndIndexes;
import com.google.common.primitives.Ints;
import java.util.Collection;

public final class Quantiles$Scale {
   private final int scale;

   private Quantiles$Scale(int var1) {
      Preconditions.checkArgument(var1 > 0, "Quantile scale must be positive");
      this.scale = var1;
   }

   public Quantiles$ScaleAndIndex index(int var1) {
      return new Quantiles$ScaleAndIndex(this.scale, var1, (Quantiles$1)null);
   }

   public Quantiles$ScaleAndIndexes indexes(int... var1) {
      return new Quantiles$ScaleAndIndexes(this.scale, (int[])var1.clone(), (Quantiles$1)null);
   }

   public Quantiles$ScaleAndIndexes indexes(Collection var1) {
      return new Quantiles$ScaleAndIndexes(this.scale, Ints.toArray(var1), (Quantiles$1)null);
   }

   // $FF: synthetic method
   Quantiles$Scale(int var1, Quantiles$1 var2) {
      this(var1);
   }
}
