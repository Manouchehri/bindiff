package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.math.DoubleMath;
import com.google.common.util.concurrent.FixedDelayRateLimiter;
import com.google.common.util.concurrent.RateLimiter$1;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import com.google.common.util.concurrent.RequestAlignedBucketsRateLimiter;
import com.google.common.util.concurrent.SecondGranularityHorizonRateLimiter;
import com.google.common.util.concurrent.SmoothRateLimiter$SmoothBursty;
import com.google.common.util.concurrent.SmoothRateLimiter$SmoothWarmingUp;
import java.math.RoundingMode;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
@Beta
public abstract class RateLimiter {
   private final RateLimiter$SleepingStopwatch stopwatch;
   private volatile Object mutexDoNotUseDirectly;

   public static RateLimiter create(double var0) {
      return create(RateLimiter$SleepingStopwatch.createFromSystemTimer(), var0);
   }

   @GoogleInternal
   public final int latestPermitAgeSec() {
      synchronized(this.mutex()) {
         return this.doLatestPermitAgeSec(this.stopwatch.readMicros());
      }
   }

   @GoogleInternal
   int doLatestPermitAgeSec(long var1) {
      throw new UnsupportedOperationException();
   }

   @GoogleInternal
   public final void setPermitsWithinHorizon(int var1) {
      synchronized(this.mutex()) {
         this.doSetPermitsWithinHorizon(var1);
      }
   }

   @GoogleInternal
   void doSetPermitsWithinHorizon(int var1) {
      throw new UnsupportedOperationException();
   }

   @VisibleForTesting
   static RateLimiter create(RateLimiter$SleepingStopwatch var0, double var1) {
      SmoothRateLimiter$SmoothBursty var3 = new SmoothRateLimiter$SmoothBursty(var0, 1.0D);
      var3.setRate(var1);
      return var3;
   }

   public static RateLimiter create(double var0, long var2, TimeUnit var4) {
      Preconditions.checkArgument(var2 >= 0L, "warmupPeriod must not be negative: %s", new Object[]{Long.valueOf(var2)});
      return create(RateLimiter$SleepingStopwatch.createFromSystemTimer(), var0, var2, var4, 3.0D);
   }

   @GoogleInternal
   public static RateLimiter create(double var0, long var2, TimeUnit var4, double var5) {
      Preconditions.checkArgument(var2 >= 0L, "warmupPeriod must not be negative: %s", new Object[]{Long.valueOf(var2)});
      Preconditions.checkArgument(var5 >= 1.0D, "coldFactor must be >= 1.0: %s", new Object[]{Double.valueOf(var5)});
      return create(RateLimiter$SleepingStopwatch.createFromSystemTimer(), var0, var2, var4, var5);
   }

   @VisibleForTesting
   static RateLimiter create(RateLimiter$SleepingStopwatch var0, double var1, long var3, TimeUnit var5, double var6) {
      SmoothRateLimiter$SmoothWarmingUp var8 = new SmoothRateLimiter$SmoothWarmingUp(var0, var3, var5, var6);
      var8.setRate(var1);
      return var8;
   }

   @GoogleInternal
   public static RateLimiter createWithCapacity(double var0, long var2, TimeUnit var4) {
      return createWithCapacity(RateLimiter$SleepingStopwatch.createFromSystemTimer(), var0, var2, var4);
   }

   @GoogleInternal
   @VisibleForTesting
   static RateLimiter createWithCapacity(RateLimiter$SleepingStopwatch var0, double var1, long var3, TimeUnit var5) {
      Preconditions.checkArgument(var3 >= 0L, "maxBurstBuildup must not be negative: %s", new Object[]{Long.valueOf(var3)});
      double var6 = (double)var5.toNanos(var3) / 1.0E9D;
      SmoothRateLimiter$SmoothBursty var8 = new SmoothRateLimiter$SmoothBursty(var0, var6);
      var8.setRate(var1);
      return var8;
   }

   private Object mutex() {
      Object var1 = this.mutexDoNotUseDirectly;
      if(var1 == null) {
         synchronized(this) {
            var1 = this.mutexDoNotUseDirectly;
            if(var1 == null) {
               this.mutexDoNotUseDirectly = var1 = new Object();
            }
         }
      }

      return var1;
   }

   RateLimiter(RateLimiter$SleepingStopwatch var1) {
      this.stopwatch = (RateLimiter$SleepingStopwatch)Preconditions.checkNotNull(var1);
   }

   public final void setRate(double var1) {
      Preconditions.checkArgument(var1 > 0.0D && !Double.isNaN(var1), "rate must be positive");
      synchronized(this.mutex()) {
         this.doSetRate(var1, this.stopwatch.readMicros());
      }
   }

   abstract void doSetRate(double var1, long var3);

   public final double getRate() {
      synchronized(this.mutex()) {
         return this.doGetRate();
      }
   }

   abstract double doGetRate();

   @GoogleInternal
   public int getAvailablePermits() {
      synchronized(this.mutex()) {
         return this.doGetAvailablePermits(this.stopwatch.readMicros());
      }
   }

   @GoogleInternal
   int doGetAvailablePermits(long var1) {
      return 0;
   }

   public double acquire() {
      return this.acquire(1);
   }

   public double acquire(int var1) {
      long var2 = this.reserve(var1);
      this.stopwatch.sleepMicrosUninterruptibly(var2);
      return 1.0D * (double)var2 / (double)TimeUnit.SECONDS.toMicros(1L);
   }

   final long reserve(int var1) {
      checkPermits(var1);
      synchronized(this.mutex()) {
         return this.reserveAndGetWaitLength(var1, this.stopwatch.readMicros());
      }
   }

   @GoogleInternal
   final RateLimiter checkSupportsAsync() {
      Preconditions.checkArgument(this.supportsAsync(), "%s does not support asynchronous use", new Object[]{this});
      return this;
   }

   @GoogleInternal
   boolean supportsAsync() {
      return true;
   }

   public boolean tryAcquire(long var1, TimeUnit var3) {
      return this.tryAcquire(1, var1, var3);
   }

   public boolean tryAcquire(int var1) {
      return this.tryAcquire(var1, 0L, TimeUnit.MICROSECONDS);
   }

   public boolean tryAcquire() {
      return this.tryAcquire(1, 0L, TimeUnit.MICROSECONDS);
   }

   public boolean tryAcquire(int var1, long var2, TimeUnit var4) {
      long var5 = Math.max(var4.toMicros(var2), 0L);
      checkPermits(var1);
      long var7;
      synchronized(this.mutex()) {
         long var10 = this.stopwatch.readMicros();
         if(!this.canAcquire(var10, var5)) {
            return false;
         }

         var7 = this.reserveAndGetWaitLength(var1, var10);
      }

      this.stopwatch.sleepMicrosUninterruptibly(var7);
      return true;
   }

   @GoogleInternal
   public boolean couldAcquire() {
      synchronized(this.mutex()) {
         long var2 = this.stopwatch.readMicros();
         return this.canAcquire(var2, 0L);
      }
   }

   private boolean canAcquire(long var1, long var3) {
      return this.queryEarliestAvailable(var1) - var3 <= var1;
   }

   final long reserveAndGetWaitLength(int var1, long var2) {
      long var4 = this.reserveEarliestAvailable(var1, var2);
      return Math.max(var4 - var2, 0L);
   }

   abstract long queryEarliestAvailable(long var1);

   abstract long reserveEarliestAvailable(int var1, long var2);

   @GoogleInternal
   public void forceAcquire() {
      synchronized(this.mutex()) {
         long var2 = this.stopwatch.readMicros();
         this.doForceAcquire(var2);
      }
   }

   @GoogleInternal
   void doForceAcquire(long var1) {
      throw new UnsupportedOperationException();
   }

   public String toString() {
      return String.format(Locale.ROOT, "RateLimiter[stableRate=%3.1fqps]", new Object[]{Double.valueOf(this.getRate())});
   }

   private static int checkPermits(int var0) {
      Preconditions.checkArgument(var0 > 0, "Requested permits (%s) must be positive", new Object[]{Integer.valueOf(var0)});
      return var0;
   }

   @GoogleInternal
   public static RateLimiter createWithRequestAlignedBuckets(int var0, int var1) {
      return createWithRequestAlignedBuckets(RateLimiter$SleepingStopwatch.createFromSystemTimer(), var0, var1);
   }

   @GoogleInternal
   @VisibleForTesting
   static RateLimiter createWithRequestAlignedBuckets(RateLimiter$SleepingStopwatch var0, int var1, int var2) {
      Preconditions.checkArgument(var1 >= 0, "permitsPerBucket (%s) must be nonnegative", new Object[]{Integer.valueOf(var1)});
      Preconditions.checkArgument(var2 >= 0, "periodInMillis (%s) must be nonnegative", new Object[]{Integer.valueOf(var2)});
      return (RateLimiter)(var1 == 0?new FixedDelayRateLimiter(var0, (long)var2):new RequestAlignedBucketsRateLimiter(var0, var1, var2));
   }

   @GoogleInternal
   public static RateLimiter createWithSecondGranularityHorizon(int var0, int var1) {
      return createWithSecondGranularityHorizon(var0, var1, RateLimiter$SleepingStopwatch.createFromSystemTimer());
   }

   @GoogleInternal
   @VisibleForTesting
   public static RateLimiter createWithSecondGranularityHorizon(int var0, int var1, Ticker var2) {
      return createWithSecondGranularityHorizon(var0, var1, createStopwatch(var2));
   }

   @GoogleInternal
   @VisibleForTesting
   static RateLimiter createWithSecondGranularityHorizon(int var0, int var1, RateLimiter$SleepingStopwatch var2) {
      return new SecondGranularityHorizonRateLimiter(var2, var0, var1);
   }

   @GoogleInternal
   private static RateLimiter$SleepingStopwatch createStopwatch(Ticker var0) {
      Stopwatch var1 = Stopwatch.createStarted(var0);
      return new RateLimiter$1(var1);
   }

   @GoogleInternal
   static int microsToSec(long var0) {
      return (int)TimeUnit.MICROSECONDS.toSeconds(var0);
   }

   @GoogleInternal
   static int roundedPermitsPerTime(double var0, double var2) {
      int var4 = DoubleMath.roundToInt(var0 * var2, RoundingMode.HALF_UP);
      Preconditions.checkArgument(var4 > 0, "underflow changing to rate %s over time %s", new Object[]{Double.valueOf(var0), Double.valueOf(var2)});
      return var4;
   }
}
