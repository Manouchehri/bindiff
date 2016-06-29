package com.google.common.util.concurrent;

import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import com.google.common.util.concurrent.SmoothRateLimiter$1;
import java.util.concurrent.TimeUnit;

final class SmoothRateLimiter$SmoothWarmingUp extends SmoothRateLimiter {
   private final long warmupPeriodMicros;
   private double slope;
   private double thresholdPermits;
   private double coldFactor;

   SmoothRateLimiter$SmoothWarmingUp(RateLimiter$SleepingStopwatch var1, long var2, TimeUnit var4, double var5) {
      super(var1, (SmoothRateLimiter$1)null);
      this.warmupPeriodMicros = var4.toMicros(var2);
      this.coldFactor = var5;
   }

   void doSetRate(double var1, double var3) {
      double var5 = this.maxPermits;
      double var7 = var3 * this.coldFactor;
      this.thresholdPermits = 0.5D * (double)this.warmupPeriodMicros / var3;
      this.maxPermits = this.thresholdPermits + 2.0D * (double)this.warmupPeriodMicros / (var3 + var7);
      this.slope = (var7 - var3) / (this.maxPermits - this.thresholdPermits);
      if(var5 == Double.POSITIVE_INFINITY) {
         this.storedPermits = 0.0D;
      } else {
         this.storedPermits = var5 == 0.0D?this.maxPermits:this.storedPermits * this.maxPermits / var5;
      }

   }

   long storedPermitsToWaitTime(double var1, double var3) {
      double var5 = var1 - this.thresholdPermits;
      long var7 = 0L;
      if(var5 > 0.0D) {
         double var9 = Math.min(var5, var3);
         var7 = (long)(var9 * (this.permitsToTime(var5) + this.permitsToTime(var5 - var9)) / 2.0D);
         var3 -= var9;
      }

      var7 = (long)((double)var7 + this.stableIntervalMicros * var3);
      return var7;
   }

   private double permitsToTime(double var1) {
      return this.stableIntervalMicros + var1 * this.slope;
   }

   double coolDownIntervalMicros() {
      return (double)this.warmupPeriodMicros / this.maxPermits;
   }
}
