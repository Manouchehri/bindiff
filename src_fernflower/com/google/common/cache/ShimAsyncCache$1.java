package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.cache.ShimAsyncCache;
import com.google.common.util.concurrent.ListenableFuture;

final class ShimAsyncCache$1 implements Function {
   public ListenableFuture apply(ListenableFuture var1) {
      return ShimAsyncCache.access$100(var1);
   }
}
