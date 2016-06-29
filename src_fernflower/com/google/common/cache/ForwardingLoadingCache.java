package com.google.common.cache;

import com.google.common.cache.ForwardingCache;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;

public abstract class ForwardingLoadingCache extends ForwardingCache implements LoadingCache {
   protected abstract LoadingCache delegate();

   public Object get(Object var1) {
      return this.delegate().get(var1);
   }

   public Object getUnchecked(Object var1) {
      return this.delegate().getUnchecked(var1);
   }

   public ImmutableMap getAll(Iterable var1) {
      return this.delegate().getAll(var1);
   }

   public Object apply(Object var1) {
      return this.delegate().apply(var1);
   }

   public void refresh(Object var1) {
      this.delegate().refresh(var1);
   }
}
