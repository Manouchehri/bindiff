package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.cache.Cache;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ConcurrentMap;

@GwtCompatible
public interface LoadingCache extends Function, Cache {
   Object get(Object var1);

   Object getUnchecked(Object var1);

   ImmutableMap getAll(Iterable var1);

   @Deprecated
   Object apply(Object var1);

   void refresh(Object var1);

   ConcurrentMap asMap();
}
