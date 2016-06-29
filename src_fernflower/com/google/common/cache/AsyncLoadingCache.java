package com.google.common.cache;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.Nullable;

@GoogleInternal
@GwtIncompatible("Futures")
public interface AsyncLoadingCache {
   ListenableFuture get(Object var1);

   ImmutableMap getAll(Iterable var1);

   @Nullable
   Object getIfPresent(Object var1);

   void invalidateAll();

   void invalidate(Object var1);

   void put(Object var1, Object var2);
}
