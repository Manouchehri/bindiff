package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.ForwardingLoadingCache;
import com.google.common.cache.LoadingCache;

public abstract class ForwardingLoadingCache$SimpleForwardingLoadingCache extends ForwardingLoadingCache {
   private final LoadingCache delegate;

   protected ForwardingLoadingCache$SimpleForwardingLoadingCache(LoadingCache var1) {
      this.delegate = (LoadingCache)Preconditions.checkNotNull(var1);
   }

   protected final LoadingCache delegate() {
      return this.delegate;
   }
}
