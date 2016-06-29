package com.google.common.util.concurrent;

import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.TimeUnit;

final class RateLimiter$SleepingStopwatch$1 extends RateLimiter$SleepingStopwatch {
   final Stopwatch stopwatch = Stopwatch.createStarted();

   long readMicros() {
      return this.stopwatch.elapsed(TimeUnit.MICROSECONDS);
   }

   void sleepMicrosUninterruptibly(long var1) {
      if(var1 > 0L) {
         Uninterruptibles.sleepUninterruptibly(var1, TimeUnit.MICROSECONDS);
      }

   }
}
