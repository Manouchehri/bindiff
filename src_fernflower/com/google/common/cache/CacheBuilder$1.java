package com.google.common.cache;

import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheStats;

final class CacheBuilder$1 implements AbstractCache$StatsCounter {
   public void recordHits(int var1) {
   }

   public void recordMisses(int var1) {
   }

   public void recordLoadSuccess(long var1) {
   }

   public void recordLoadException(long var1) {
   }

   public void recordEviction() {
   }

   public CacheStats snapshot() {
      return CacheBuilder.EMPTY_STATS;
   }
}
