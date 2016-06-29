package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.StatsAccumulator;
import java.io.Serializable;
import java.util.Iterator;
import javax.annotation.Nullable;

@GoogleInternal
public final class Stats implements Serializable {
   private final long count;
   private final double mean;
   private final double sumOfSquaresOfDeltas;
   private final double min;
   private final double max;

   Stats(long var1, double var3, double var5, double var7, double var9) {
      this.count = var1;
      this.mean = var3;
      this.sumOfSquaresOfDeltas = var5;
      this.min = var7;
      this.max = var9;
   }

   public static Stats of(Iterable var0) {
      StatsAccumulator var1 = new StatsAccumulator();
      var1.addAll(var0);
      return var1.snapshot();
   }

   public static Stats of(Iterator var0) {
      StatsAccumulator var1 = new StatsAccumulator();
      var1.addAll(var0);
      return var1.snapshot();
   }

   public static Stats of(double... var0) {
      StatsAccumulator var1 = new StatsAccumulator();
      var1.addAll(var0);
      return var1.snapshot();
   }

   public static Stats of(int... var0) {
      StatsAccumulator var1 = new StatsAccumulator();
      var1.addAll(var0);
      return var1.snapshot();
   }

   public static Stats of(long... var0) {
      StatsAccumulator var1 = new StatsAccumulator();
      var1.addAll(var0);
      return var1.snapshot();
   }

   public long count() {
      return this.count;
   }

   public double mean() {
      Preconditions.checkState(this.count != 0L);
      return this.mean;
   }

   public double sum() {
      return this.mean * (double)this.count;
   }

   public double populationVariance() {
      Preconditions.checkState(this.count > 0L);
      return this.count == 1L?0.0D:DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (double)this.count();
   }

   public double populationStandardDeviation() {
      return Math.sqrt(this.populationVariance());
   }

   public double sampleVariance() {
      Preconditions.checkState(this.count > 1L);
      return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (double)(this.count - 1L);
   }

   public double sampleStandardDeviation() {
      return Math.sqrt(this.sampleVariance());
   }

   public double min() {
      Preconditions.checkState(this.count != 0L);
      return this.min;
   }

   public double max() {
      Preconditions.checkState(this.count != 0L);
      return this.max;
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 == null) {
         return false;
      } else if(this.getClass() != var1.getClass()) {
         return false;
      } else {
         Stats var2 = (Stats)var1;
         return this.count == var2.count && Double.doubleToLongBits(this.mean) == Double.doubleToLongBits(var2.mean) && Double.doubleToLongBits(this.sumOfSquaresOfDeltas) == Double.doubleToLongBits(var2.sumOfSquaresOfDeltas) && Double.doubleToLongBits(this.min) == Double.doubleToLongBits(var2.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(var2.max);
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{Long.valueOf(this.count), Double.valueOf(this.mean), Double.valueOf(this.sumOfSquaresOfDeltas), Double.valueOf(this.min), Double.valueOf(this.max)});
   }

   public String toString() {
      return MoreObjects.toStringHelper((Object)this).add("count", this.count).add("mean", this.mean).add("populationStandardDeviation", this.populationStandardDeviation()).add("min", this.min).add("max", this.max).toString();
   }

   double sumOfSquaresOfDeltas() {
      return this.sumOfSquaresOfDeltas;
   }
}
