package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.cache.CacheLoader$1;
import com.google.common.cache.CacheLoader$FunctionToCacheLoader;
import com.google.common.cache.CacheLoader$SupplierToCacheLoader;
import com.google.common.cache.CacheLoader$UnsupportedLoadingOperationException;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Map;
import java.util.concurrent.Executor;

@GwtCompatible(
   emulated = true
)
public abstract class CacheLoader {
   public abstract Object load(Object var1);

   @GwtIncompatible("Futures")
   public ListenableFuture reload(Object var1, Object var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      return Futures.immediateFuture(this.load(var1));
   }

   public Map loadAll(Iterable var1) {
      throw new CacheLoader$UnsupportedLoadingOperationException();
   }

   public static CacheLoader from(Function var0) {
      return new CacheLoader$FunctionToCacheLoader(var0);
   }

   public static CacheLoader from(Supplier var0) {
      return new CacheLoader$SupplierToCacheLoader(var0);
   }

   @GwtIncompatible("Executor + Futures")
   public static CacheLoader asyncReloading(CacheLoader var0, Executor var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new CacheLoader$1(var0, var1);
   }
}
