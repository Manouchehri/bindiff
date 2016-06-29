package com.google.common.util.concurrent;

import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;

final class ManualRateLimiter$1 extends RateLimiter$SleepingStopwatch {
   void sleepMicrosUninterruptibly(long var1) {
      throw new AssertionError();
   }

   long readMicros() {
      throw new UnsupportedOperationException();
   }
}
