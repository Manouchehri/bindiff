package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.AbstractCache$SimpleStatsCounter;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.CacheStats;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$LocalManualCache$1;
import com.google.common.cache.LocalCache$ManualSerializationProxy;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

class LocalCache$LocalManualCache implements Cache, Serializable {
   final LocalCache localCache;
   private static final long serialVersionUID = 1L;

   LocalCache$LocalManualCache(CacheBuilder var1) {
      this(new LocalCache(var1, (CacheLoader)null));
   }

   private LocalCache$LocalManualCache(LocalCache var1) {
      this.localCache = var1;
   }

   @Nullable
   public Object getIfPresent(Object var1) {
      return this.localCache.getIfPresent(var1);
   }

   public Object get(Object var1, Callable var2) {
      Preconditions.checkNotNull(var2);
      return this.localCache.get(var1, new LocalCache$LocalManualCache$1(this, var2));
   }

   public ImmutableMap getAllPresent(Iterable var1) {
      return this.localCache.getAllPresent(var1);
   }

   public void put(Object var1, Object var2) {
      this.localCache.put(var1, var2);
   }

   public void putAll(Map var1) {
      this.localCache.putAll(var1);
   }

   public void invalidate(Object var1) {
      Preconditions.checkNotNull(var1);
      this.localCache.remove(var1);
   }

   public void invalidateAll(Iterable var1) {
      this.localCache.invalidateAll(var1);
   }

   public void invalidateAll() {
      this.localCache.clear();
   }

   public long size() {
      return this.localCache.longSize();
   }

   public ConcurrentMap asMap() {
      return this.localCache;
   }

   public CacheStats stats() {
      AbstractCache$SimpleStatsCounter var1 = new AbstractCache$SimpleStatsCounter();
      var1.incrementBy(this.localCache.globalStatsCounter);
      LocalCache$Segment[] var2 = this.localCache.segments;
      int var3 = var2.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         LocalCache$Segment var5 = var2[var4];
         var1.incrementBy(var5.statsCounter);
      }

      return var1.snapshot();
   }

   public void cleanUp() {
      this.localCache.cleanUp();
   }

   Object writeReplace() {
      return new LocalCache$ManualSerializationProxy(this.localCache);
   }

   // $FF: synthetic method
   LocalCache$LocalManualCache(LocalCache var1, LocalCache$1 var2) {
      this(var1);
   }
}
