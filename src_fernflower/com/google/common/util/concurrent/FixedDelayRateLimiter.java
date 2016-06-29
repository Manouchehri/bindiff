package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;

@GoogleInternal
final class FixedDelayRateLimiter extends RateLimiter {
   private final long fixedDelay;

   FixedDelayRateLimiter(RateLimiter$SleepingStopwatch var1, long var2) {
      super(var1);
      this.fixedDelay = var2;
   }

   void doSetRate(double var1, long var3) {
      throw new UnsupportedOperationException();
   }

   double doGetRate() {
      return 0.0D;
   }

   long queryEarliestAvailable(long var1) {
      return var1 + this.fixedDelay;
   }

   long reserveEarliestAvailable(int var1, long var2) {
      return var2 + this.fixedDelay;
   }
}
