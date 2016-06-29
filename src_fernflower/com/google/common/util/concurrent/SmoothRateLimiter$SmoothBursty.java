package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter;
import com.google.common.util.concurrent.SmoothRateLimiter$1;

final class SmoothRateLimiter$SmoothBursty extends SmoothRateLimiter {
   final double maxBurstSeconds;

   SmoothRateLimiter$SmoothBursty(RateLimiter$SleepingStopwatch var1, double var2) {
      super(var1, (SmoothRateLimiter$1)null);
      this.maxBurstSeconds = var2;
   }

   void doSetRate(double var1, double var3) {
      double var5 = this.maxPermits;
      this.maxPermits = this.maxBurstSeconds * var1;
      if(var5 == Double.POSITIVE_INFINITY) {
         this.storedPermits = this.maxPermits;
      } else {
         this.storedPermits = var5 == 0.0D?0.0D:this.storedPermits * this.maxPermits / var5;
      }

   }

   long storedPermitsToWaitTime(double var1, double var3) {
      return 0L;
   }

   double coolDownIntervalMicros() {
      return this.stableIntervalMicros;
   }

   @GoogleInternal
   int doGetAvailablePermits(long var1) {
      this.resync(var1);
      return (int)this.storedPermits;
   }
}
