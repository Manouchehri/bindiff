package com.google.common.cache;

import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LongAddable;
import com.google.common.cache.LongAddables;

public final class AbstractCache$SimpleStatsCounter implements AbstractCache$StatsCounter {
   private final LongAddable hitCount = LongAddables.create();
   private final LongAddable missCount = LongAddables.create();
   private final LongAddable loadSuccessCount = LongAddables.create();
   private final LongAddable loadExceptionCount = LongAddables.create();
   private final LongAddable totalLoadTime = LongAddables.create();
   private final LongAddable evictionCount = LongAddables.create();

   public void recordHits(int var1) {
      this.hitCount.add((long)var1);
   }

   public void recordMisses(int var1) {
      this.missCount.add((long)var1);
   }

   public void recordLoadSuccess(long var1) {
      this.loadSuccessCount.increment();
      this.totalLoadTime.add(var1);
   }

   public void recordLoadException(long var1) {
      this.loadExceptionCount.increment();
      this.totalLoadTime.add(var1);
   }

   public void recordEviction() {
      this.evictionCount.increment();
   }

   public CacheStats snapshot() {
      return new CacheStats(this.hitCount.sum(), this.missCount.sum(), this.loadSuccessCount.sum(), this.loadExceptionCount.sum(), this.totalLoadTime.sum(), this.evictionCount.sum());
   }

   public void incrementBy(AbstractCache$StatsCounter var1) {
      CacheStats var2 = var1.snapshot();
      this.hitCount.add(var2.hitCount());
      this.missCount.add(var2.missCount());
      this.loadSuccessCount.add(var2.loadSuccessCount());
      this.loadExceptionCount.add(var2.loadExceptionCount());
      this.totalLoadTime.add(var2.totalLoadTime());
      this.evictionCount.add(var2.evictionCount());
   }
}
