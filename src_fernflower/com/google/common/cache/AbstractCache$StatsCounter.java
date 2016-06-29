package com.google.common.cache;

import com.google.common.cache.CacheStats;

public interface AbstractCache$StatsCounter {
   void recordHits(int var1);

   void recordMisses(int var1);

   void recordLoadSuccess(long var1);

   void recordLoadException(long var1);

   void recordEviction();

   CacheStats snapshot();
}
