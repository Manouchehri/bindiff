package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.Cache;
import com.google.common.cache.ForwardingCache;

public abstract class ForwardingCache$SimpleForwardingCache extends ForwardingCache {
   private final Cache delegate;

   protected ForwardingCache$SimpleForwardingCache(Cache var1) {
      this.delegate = (Cache)Preconditions.checkNotNull(var1);
   }

   protected final Cache delegate() {
      return this.delegate;
   }
}
