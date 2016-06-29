package com.google.common.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheStats;
import com.google.common.collect.ForwardingObject;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import javax.annotation.Nullable;

public abstract class ForwardingCache extends ForwardingObject implements Cache {
   protected abstract Cache delegate();

   @Nullable
   public Object getIfPresent(Object var1) {
      return this.delegate().getIfPresent(var1);
   }

   public Object get(Object var1, Callable var2) {
      return this.delegate().get(var1, var2);
   }

   public ImmutableMap getAllPresent(Iterable var1) {
      return this.delegate().getAllPresent(var1);
   }

   public void put(Object var1, Object var2) {
      this.delegate().put(var1, var2);
   }

   public void putAll(Map var1) {
      this.delegate().putAll(var1);
   }

   public void invalidate(Object var1) {
      this.delegate().invalidate(var1);
   }

   public void invalidateAll(Iterable var1) {
      this.delegate().invalidateAll(var1);
   }

   public void invalidateAll() {
      this.delegate().invalidateAll();
   }

   public long size() {
      return this.delegate().size();
   }

   public CacheStats stats() {
      return this.delegate().stats();
   }

   public ConcurrentMap asMap() {
      return this.delegate().asMap();
   }

   public void cleanUp() {
      this.delegate().cleanUp();
   }
}
