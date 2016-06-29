package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.math.LinearTransformation;
import com.google.common.math.Stats;
import java.io.Serializable;
import javax.annotation.Nullable;

@GoogleInternal
public final class PairedStats implements Serializable {
   private final Stats xStats;
   private final Stats yStats;
   private final double sumOfProductsOfDeltas;

   PairedStats(Stats var1, Stats var2, double var3) {
      this.xStats = var1;
      this.yStats = var2;
      this.sumOfProductsOfDeltas = var3;
   }

   public long count() {
      return this.xStats.count();
   }

   public Stats xStats() {
      return this.xStats;
   }

   public Stats yStats() {
      return this.yStats;
   }

   public double populationCovariance() {
      Preconditions.checkState(this.count() != 0L);
      return this.sumOfProductsOfDeltas / (double)this.count();
   }

   public double sampleCovariance() {
      Preconditions.checkState(this.count() > 1L);
      return this.sumOfProductsOfDeltas / (double)(this.count() - 1L);
   }

   public double pearsonsCorrelationCoefficient() {
      Preconditions.checkState(this.count() != 0L);
      double var1 = this.xStats().sumOfSquaresOfDeltas();
      double var3 = this.yStats().sumOfSquaresOfDeltas();
      Preconditions.checkState(var1 > 0.0D);
      Preconditions.checkState(var3 > 0.0D);
      double var5 = ensurePositive(var1 * var3);
      return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(var5));
   }

   public LinearTransformation leastSquaresFit() {
      Preconditions.checkState(this.count() > 1L);
      double var1 = this.xStats.sumOfSquaresOfDeltas();
      if(var1 > 0.0D) {
         return this.yStats.sumOfSquaresOfDeltas() > 0.0D?LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / var1):LinearTransformation.horizontal(this.yStats.mean());
      } else {
         Preconditions.checkState(this.yStats.sumOfSquaresOfDeltas() > 0.0D);
         return LinearTransformation.vertical(this.xStats.mean());
      }
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 == null) {
         return false;
      } else if(this.getClass() != var1.getClass()) {
         return false;
      } else {
         PairedStats var2 = (PairedStats)var1;
         return this.xStats.equals(var2.xStats) && this.yStats.equals(var2.yStats) && Double.doubleToLongBits(this.sumOfProductsOfDeltas) == Double.doubleToLongBits(var2.sumOfProductsOfDeltas);
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.xStats, this.yStats, Double.valueOf(this.sumOfProductsOfDeltas)});
   }

   public String toString() {
      return MoreObjects.toStringHelper((Object)this).add("xStats", this.xStats).add("yStats", this.yStats).add("populationCovariance", this.populationCovariance()).toString();
   }

   private static double ensurePositive(double var0) {
      return var0 > 0.0D?var0:Double.MIN_VALUE;
   }

   private static double ensureInUnitRange(double var0) {
      return var0 >= 1.0D?1.0D:(var0 <= -1.0D?-1.0D:var0);
   }
}
