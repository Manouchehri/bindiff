package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.cache.AsyncCacheLoader;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

final class AsyncCacheLoader$AsyncFunctionToCacheLoader extends AsyncCacheLoader {
   final AsyncFunction computingFunction;

   AsyncCacheLoader$AsyncFunctionToCacheLoader(AsyncFunction var1) {
      this.computingFunction = (AsyncFunction)Preconditions.checkNotNull(var1);
   }

   protected ListenableFuture load(Object var1) {
      Preconditions.checkNotNull(var1);

      try {
         return this.computingFunction.apply(var1);
      } catch (Exception var3) {
         return Futures.immediateFailedFuture(var3);
      }
   }
}
