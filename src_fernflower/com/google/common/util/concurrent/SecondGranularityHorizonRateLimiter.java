package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.base.Preconditions;
import com.google.common.collect.SortedLists;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import com.google.common.util.concurrent.RateLimiter;
import com.google.common.util.concurrent.RateLimiter$SleepingStopwatch;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import java.util.concurrent.TimeUnit;

@GoogleInternal
final class SecondGranularityHorizonRateLimiter extends RateLimiter {
   private int permitsWithinHorizon;
   private final int horizonSec;
   private final IntArrayList permitGrantsSec = new IntArrayList();
   private Integer latestPermitGrantSec;

   SecondGranularityHorizonRateLimiter(RateLimiter$SleepingStopwatch var1, int var2, int var3) {
      super(var1);
      this.doSetPermitsWithinHorizon(var2);
      Preconditions.checkArgument(var3 > 0, "horizonSec (%s) must be positive", new Object[]{Integer.valueOf(var3)});
      this.horizonSec = var3;
   }

   void doSetRate(double var1, long var3) {
      this.permitsWithinHorizon = roundedPermitsPerTime(var1, (double)this.horizonSec);
   }

   double doGetRate() {
      return (double)this.permitsWithinHorizon / (double)this.horizonSec;
   }

   long queryEarliestAvailable(long var1) {
      int var3 = microsToSec(var1);
      int var4 = this.nextAvailableTimeSec(var3);
      return TimeUnit.SECONDS.toMicros((long)var4);
   }

   long reserveEarliestAvailable(int var1, long var2) {
      int var4 = microsToSec(var2);
      int var5 = this.nextAvailableTimeSec(var4);
      this.recordGrants(var1, var5);
      return TimeUnit.SECONDS.toMicros((long)var5);
   }

   private int nextAvailableTimeSec(int var1) {
      this.pruneEvents(var1);
      return this.permitGrantsSec.size() < this.permitsWithinHorizon?var1:this.permitGrantsSec.getInt(this.permitGrantsSec.size() - this.permitsWithinHorizon) + this.horizonSec;
   }

   private void pruneEvents(int var1) {
      int var2 = var1 - this.horizonSec;
      int var3 = SortedLists.binarySearch(this.permitGrantsSec, Integer.valueOf(var2), SortedLists$KeyPresentBehavior.FIRST_AFTER, SortedLists$KeyAbsentBehavior.NEXT_HIGHER);
      this.permitGrantsSec.removeElements(0, var3);
   }

   int doLatestPermitAgeSec(long var1) {
      Preconditions.checkState(this.latestPermitGrantSec != null, "No permits have been granted yet");
      int var3 = microsToSec(var1);
      return var3 - this.latestPermitGrantSec.intValue();
   }

   void doForceAcquire(long var1) {
      int var3 = microsToSec(var1);
      this.recordGrants(1, var3);
   }

   private void recordGrants(int var1, int var2) {
      for(int var3 = 0; var3 < var1; ++var3) {
         this.permitGrantsSec.add(var2);
      }

      this.latestPermitGrantSec = Integer.valueOf(var2);
   }

   void doSetPermitsWithinHorizon(int var1) {
      Preconditions.checkArgument(var1 > 0, "permitsWithinHorizon (%s) must be positive", new Object[]{Integer.valueOf(var1)});
      this.permitsWithinHorizon = var1;
   }
}
