package com.google.common.util.concurrent;

import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.SmoothRateLimiter$1;
import java.util.concurrent.TimeUnit;

abstract class SmoothRateLimiter extends RateLimiter {
   double storedPermits;
   double maxPermits;
   double stableIntervalMicros;
   private long nextFreeTicketMicros;

   private SmoothRateLimiter(RateLimiter$SleepingStopwatch var1) {
      super(var1);
      this.nextFreeTicketMicros = 0L;
   }

   final void doSetRate(double var1, long var3) {
      this.resync(var3);
      double var5 = (double)TimeUnit.SECONDS.toMicros(1L) / var1;
      this.stableIntervalMicros = var5;
      this.doSetRate(var1, var5);
   }

   abstract void doSetRate(double var1, double var3);

   final double doGetRate() {
      return (double)TimeUnit.SECONDS.toMicros(1L) / this.stableIntervalMicros;
   }

   final long queryEarliestAvailable(long var1) {
      return this.nextFreeTicketMicros;
   }

   final long reserveEarliestAvailable(int var1, long var2) {
      this.resync(var2);
      long var4 = this.nextFreeTicketMicros;
      double var6 = Math.min((double)var1, this.storedPermits);
      double var8 = (double)var1 - var6;
      long var10 = this.storedPermitsToWaitTime(this.storedPermits, var6) + (long)(var8 * this.stableIntervalMicros);

      try {
         this.nextFreeTicketMicros = LongMath.checkedAdd(this.nextFreeTicketMicros, var10);
      } catch (ArithmeticException var13) {
         this.nextFreeTicketMicros = Long.MAX_VALUE;
      }

      this.storedPermits -= var6;
      return var4;
   }

   abstract long storedPermitsToWaitTime(double var1, double var3);

   abstract double coolDownIntervalMicros();

   void resync(long var1) {
      if(var1 > this.nextFreeTicketMicros) {
         this.storedPermits = Math.min(this.maxPermits, this.storedPermits + (double)(var1 - this.nextFreeTicketMicros) / this.coolDownIntervalMicros());
         this.nextFreeTicketMicros = var1;
      }

   }

   // $FF: synthetic method
   SmoothRateLimiter(RateLimiter$SleepingStopwatch var1, SmoothRateLimiter$1 var2) {
      this(var1);
   }
}
