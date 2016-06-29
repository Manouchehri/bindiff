package com.google.common.cache;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.cache.AsyncCacheLoader$AsyncFunctionToCacheLoader;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.Set;

@GoogleInternal
@GwtIncompatible("Futures")
public abstract class AsyncCacheLoader {
   protected abstract ListenableFuture load(Object var1);

   protected Map loadAll(Set var1) {
      Preconditions.checkNotNull(var1);
      return ImmutableMap.of();
   }

   public static AsyncCacheLoader from(AsyncFunction var0) {
      return new AsyncCacheLoader$AsyncFunctionToCacheLoader(var0);
   }
}
