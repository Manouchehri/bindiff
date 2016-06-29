package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$1;
import com.google.common.cache.LocalCache$LoadingSerializationProxy;
import com.google.common.cache.LocalCache$LocalManualCache;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.concurrent.ExecutionException;

class LocalCache$LocalLoadingCache extends LocalCache$LocalManualCache implements LoadingCache {
   private static final long serialVersionUID = 1L;

   LocalCache$LocalLoadingCache(CacheBuilder var1, CacheLoader var2) {
      super(new LocalCache(var1, (CacheLoader)Preconditions.checkNotNull(var2)), (LocalCache$1)null);
   }

   public Object get(Object var1) {
      return this.localCache.getOrLoad(var1);
   }

   public Object getUnchecked(Object var1) {
      try {
         return this.get(var1);
      } catch (ExecutionException var3) {
         throw new UncheckedExecutionException(var3.getCause());
      }
   }

   public ImmutableMap getAll(Iterable var1) {
      return this.localCache.getAll(var1);
   }

   public void refresh(Object var1) {
      this.localCache.refresh(var1);
   }

   public final Object apply(Object var1) {
      return this.getUnchecked(var1);
   }

   Object writeReplace() {
      return new LocalCache$LoadingSerializationProxy(this.localCache);
   }
}
