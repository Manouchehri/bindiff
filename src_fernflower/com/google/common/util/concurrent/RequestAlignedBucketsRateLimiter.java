package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.math.LongMath;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import java.math.RoundingMode;
import java.util.concurrent.TimeUnit;

@GoogleInternal
final class RequestAlignedBucketsRateLimiter extends RateLimiter {
   private static final int NO_BUCKETS_CREATED_YET = -1;
   private long potentiallyAvailableBucketStartMicros;
   private int permitsAcquiredInBucket = -1;
   private int permitsPerBucket;
   private long periodInMicros;

   RequestAlignedBucketsRateLimiter(RateLimiter$SleepingStopwatch var1, int var2, int var3) {
      super(var1);
      this.permitsPerBucket = var2;
      this.periodInMicros = TimeUnit.MILLISECONDS.toMicros((long)var3);
   }

   void doSetRate(double var1, long var3) {
      double var5 = (double)this.periodInMicros / 1000000.0D;
      this.permitsPerBucket = roundedPermitsPerTime(var1, var5);
   }

   double doGetRate() {
      double var1 = (double)this.periodInMicros / 1000000.0D;
      return (double)this.permitsPerBucket / var1;
   }

   long queryEarliestAvailable(long var1) {
      return this.actuallyAvailableBucketStartMicros(var1);
   }

   long reserveEarliestAvailable(int var1, long var2) {
      long var4;
      try {
         this.updatePotentialBucketToActual(var2);
         var4 = this.potentiallyAvailableBucketStartMicros;
      } finally {
         this.consumePermitsAndBuckets(var1);
      }

      return var4;
   }

   private void updatePotentialBucketToActual(long var1) {
      long var3 = this.actuallyAvailableBucketStartMicros(var1);
      if(var3 != this.potentiallyAvailableBucketStartMicros || this.permitsAcquiredInBucket == -1) {
         this.potentiallyAvailableBucketStartMicros = var3;
         this.permitsAcquiredInBucket = 0;
      }

   }

   private long actuallyAvailableBucketStartMicros(long var1) {
      return var1 - this.potentiallyAvailableBucketStartMicros <= this.periodInMicros && this.permitsAcquiredInBucket != -1?(this.permitsAcquiredInBucket + 1 > this.permitsPerBucket?this.potentiallyAvailableBucketStartMicros + this.periodInMicros:this.potentiallyAvailableBucketStartMicros):var1;
   }

   private void consumePermitsAndBuckets(int var1) {
      this.permitsAcquiredInBucket += var1;
      long var2 = LongMath.divide((long)this.permitsAcquiredInBucket, (long)this.permitsPerBucket, RoundingMode.CEILING) - 1L;
      this.potentiallyAvailableBucketStartMicros += var2 * this.periodInMicros;
      this.permitsAcquiredInBucket = (int)((long)this.permitsAcquiredInBucket - var2 * (long)this.permitsPerBucket);
   }
}
