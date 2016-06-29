package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ManualRateLimiter$1;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

@GoogleInternal
public final class ManualRateLimiter extends RateLimiter {
   private static final RateLimiter$SleepingStopwatch THROWING_STOPWATCH = new ManualRateLimiter$1();
   private final Semaphore callsToProceed = new Semaphore(0, true);

   public ManualRateLimiter() {
      super(THROWING_STOPWATCH);
   }

   public void release(int var1) {
      this.callsToProceed.release(var1);
   }

   public double acquire(int var1) {
      this.callsToProceed.acquireUninterruptibly(var1);
      return 1.0D;
   }

   public boolean couldAcquire() {
      return this.callsToProceed.availablePermits() > 0;
   }

   public boolean tryAcquire(int var1, long var2, TimeUnit var4) {
      Preconditions.checkArgument(var2 <= 0L, "ManualRateLimiter does not support blocking tryAcquire(); see class-level Javadoc");
      Preconditions.checkNotNull(var4);
      return Uninterruptibles.tryAcquireUninterruptibly(this.callsToProceed, var1, 0L, TimeUnit.SECONDS);
   }

   public boolean tryAcquire(long var1, TimeUnit var3) {
      return super.tryAcquire(var1, var3);
   }

   void doSetRate(double var1, long var3) {
      throw new UnsupportedOperationException();
   }

   double doGetRate() {
      throw new UnsupportedOperationException();
   }

   boolean supportsAsync() {
      return false;
   }

   long queryEarliestAvailable(long var1) {
      throw new AssertionError();
   }

   long reserveEarliestAvailable(int var1, long var2) {
      throw new AssertionError();
   }
}
