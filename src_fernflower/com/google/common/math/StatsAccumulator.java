package com.google.common.math;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.math.DoubleUtils;
import com.google.common.math.Stats;
import com.google.common.primitives.Doubles;
import java.util.Iterator;

@GoogleInternal
public final class StatsAccumulator {
   private long count = 0L;
   private double mean = 0.0D;
   private double sumOfSquaresOfDeltas = 0.0D;
   private double min = Double.NaN;
   private double max = Double.NaN;

   public void add(double var1) {
      Preconditions.checkArgument(Doubles.isFinite(var1));
      ++this.count;
      if(this.count == 1L) {
         this.mean = var1;
         this.min = var1;
         this.max = var1;
      } else {
         double var3 = this.mean + (var1 - this.mean) / (double)this.count;
         this.sumOfSquaresOfDeltas += (var1 - this.mean) * (var1 - var3);
         this.mean = var3;
         if(var1 < this.min) {
            this.min = var1;
         }

         if(var1 > this.max) {
            this.max = var1;
         }
      }

   }

   public void addAll(Iterable var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Number var3 = (Number)var2.next();
         this.add(var3.doubleValue());
      }

   }

   public void addAll(Iterator var1) {
      while(var1.hasNext()) {
         this.add(((Number)var1.next()).doubleValue());
      }

   }

   public void addAll(double... var1) {
      double[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         double var5 = var2[var4];
         this.add(var5);
      }

   }

   public void addAll(int... var1) {
      int[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int var5 = var2[var4];
         this.add((double)var5);
      }

   }

   public void addAll(long... var1) {
      long[] var2 = var1;
      int var3 = var1.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         long var5 = var2[var4];
         this.add((double)var5);
      }

   }

   public Stats snapshot() {
      return new Stats(this.count, this.mean, this.sumOfSquaresOfDeltas, this.min, this.max);
   }

   public long count() {
      return this.count;
   }

   public double mean() {
      Preconditions.checkState(this.count != 0L);
      return this.mean;
   }

   public final double sum() {
      return this.mean * (double)this.count;
   }

   public final double populationVariance() {
      Preconditions.checkState(this.count != 0L);
      return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (double)this.count;
   }

   public final double populationStandardDeviation() {
      return Math.sqrt(this.populationVariance());
   }

   public final double sampleVariance() {
      Preconditions.checkState(this.count > 1L);
      return DoubleUtils.ensureNonNegative(this.sumOfSquaresOfDeltas) / (double)(this.count - 1L);
   }

   public final double sampleStandardDeviation() {
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

   double sumOfSquaresOfDeltas() {
      return this.sumOfSquaresOfDeltas;
   }
}
