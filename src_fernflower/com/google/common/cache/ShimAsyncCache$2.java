package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;

final class ShimAsyncCache$2 implements Function {
   // $FF: synthetic field
   final RuntimeException val$e;

   ShimAsyncCache$2(RuntimeException var1) {
      this.val$e = var1;
   }

   public ListenableFuture apply(Object var1) {
      return Futures.immediateFailedFuture(this.val$e);
   }
}
