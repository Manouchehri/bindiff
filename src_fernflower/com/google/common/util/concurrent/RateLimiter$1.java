package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import java.util.concurrent.TimeUnit;

final class RateLimiter$1 extends RateLimiter$SleepingStopwatch {
   // $FF: synthetic field
   final Stopwatch val$stopwatch;

   RateLimiter$1(Stopwatch var1) {
      this.val$stopwatch = var1;
   }

   void sleepMicrosUninterruptibly(long var1) {
      Preconditions.checkArgument(var1 <= 0L, "request to sleep (%s micros) unexpected for Throttle", new Object[]{Long.valueOf(var1)});
   }

   long readMicros() {
      return this.val$stopwatch.elapsed(TimeUnit.MICROSECONDS);
   }
}
