package com.google.common.cache;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.cache.AbstractCache$SimpleStatsCounter;
import com.google.common.cache.AbstractCache$StatsCounter;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public abstract class AbstractCache implements Cache {
   public Object get(Object var1, Callable var2) {
      throw new UnsupportedOperationException();
   }

   public ImmutableMap getAllPresent(Iterable var1) {
      LinkedHashMap var2 = Maps.newLinkedHashMap();
      Iterator var3 = var1.iterator();

      while(var3.hasNext()) {
         Object var4 = var3.next();
         if(!var2.containsKey(var4)) {
            Object var6 = this.getIfPresent(var4);
            if(var6 != null) {
               var2.put(var4, var6);
            }
         }
      }

      return ImmutableMap.copyOf((Map)var2);
   }

   public void put(Object var1, Object var2) {
      throw new UnsupportedOperationException();
   }

   public void putAll(Map var1) {
      Iterator var2 = var1.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         this.put(var3.getKey(), var3.getValue());
      }

   }

   public void cleanUp() {
   }

   public long size() {
      throw new UnsupportedOperationException();
   }

   public void invalidate(Object var1) {
      throw new UnsupportedOperationException();
   }

   public void invalidateAll(Iterable var1) {
      Iterator var2 = var1.iterator();

      while(var2.hasNext()) {
         Object var3 = var2.next();
         this.invalidate(var3);
      }

   }

   public void invalidateAll() {
      throw new UnsupportedOperationException();
   }

   public CacheStats stats() {
      throw new UnsupportedOperationException();
   }

   public ConcurrentMap asMap() {
      throw new UnsupportedOperationException();
   }

   @GoogleInternal
   public static CacheStats aggregate(AbstractCache$StatsCounter... var0) {
      AbstractCache$SimpleStatsCounter var1 = new AbstractCache$SimpleStatsCounter();
      AbstractCache$StatsCounter[] var2 = var0;
      int var3 = var0.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         AbstractCache$StatsCounter var5 = var2[var4];
         var1.incrementBy(var5);
      }

      return var1.snapshot();
   }
}
