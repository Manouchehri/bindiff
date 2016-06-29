package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures$AbstractCatchingFuture;
import com.google.common.util.concurrent.ListenableFuture;

final class Futures$AsyncCatchingFuture extends Futures$AbstractCatchingFuture {
   Futures$AsyncCatchingFuture(ListenableFuture var1, Class var2, AsyncFunction var3) {
      super(var1, var2, var3);
   }

   void doFallback(AsyncFunction var1, Throwable var2) {
      ListenableFuture var3 = var1.apply(var2);
      Preconditions.checkNotNull(var3, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
      this.setFuture(var3);
   }
}
