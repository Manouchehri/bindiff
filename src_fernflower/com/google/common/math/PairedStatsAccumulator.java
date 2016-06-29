package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.math.LinearTransformation;
import com.google.common.math.PairedStats;
import com.google.common.math.Stats;
import com.google.common.math.StatsAccumulator;

@GoogleInternal
public final class PairedStatsAccumulator {
   private final StatsAccumulator xStats = new StatsAccumulator();
   private final StatsAccumulator yStats = new StatsAccumulator();
   private double sumOfProductsOfDeltas = 0.0D;

   public void add(double var1, double var3) {
      this.xStats.add(var1);
      if(this.xStats.count() > 1L) {
         this.sumOfProductsOfDeltas += (var1 - this.xStats.mean()) * (var3 - this.yStats.mean());
      }

      this.yStats.add(var3);
   }

   public PairedStats snapshot() {
      return new PairedStats(this.xStats.snapshot(), this.yStats.snapshot(), this.sumOfProductsOfDeltas);
   }

   public long count() {
      return this.xStats.count();
   }

   public Stats xStats() {
      return this.xStats.snapshot();
   }

   public Stats yStats() {
      return this.yStats.snapshot();
   }

   public double populationCovariance() {
      Preconditions.checkState(this.count() != 0L);
      return this.sumOfProductsOfDeltas / (double)this.count();
   }

   public final double sampleCovariance() {
      Preconditions.checkState(this.count() > 1L);
      return this.sumOfProductsOfDeltas / (double)(this.count() - 1L);
   }

   public final double pearsonsCorrelationCoefficient() {
      Preconditions.checkState(this.count() != 0L);
      double var1 = this.xStats.sumOfSquaresOfDeltas();
      double var3 = this.yStats.sumOfSquaresOfDeltas();
      Preconditions.checkState(var1 > 0.0D);
      Preconditions.checkState(var3 > 0.0D);
      double var5 = this.ensurePositive(var1 * var3);
      return ensureInUnitRange(this.sumOfProductsOfDeltas / Math.sqrt(var5));
   }

   public final LinearTransformation leastSquaresFit() {
      Preconditions.checkState(this.count() > 1L);
      double var1 = this.xStats.sumOfSquaresOfDeltas();
      if(var1 > 0.0D) {
         return this.yStats.sumOfSquaresOfDeltas() > 0.0D?LinearTransformation.mapping(this.xStats.mean(), this.yStats.mean()).withSlope(this.sumOfProductsOfDeltas / var1):LinearTransformation.horizontal(this.yStats.mean());
      } else {
         Preconditions.checkState(this.yStats.sumOfSquaresOfDeltas() > 0.0D);
         return LinearTransformation.vertical(this.xStats.mean());
      }
   }

   private double ensurePositive(double var1) {
      return var1 > 0.0D?var1:Double.MIN_VALUE;
   }

   private static double ensureInUnitRange(double var0) {
      return var0 >= 1.0D?1.0D:(var0 <= -1.0D?-1.0D:var0);
   }
}
