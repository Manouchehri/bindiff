package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.Futures$AbstractChainingFuture;
import com.google.common.util.concurrent.ListenableFuture;

final class Futures$AsyncChainingFuture extends Futures$AbstractChainingFuture {
   Futures$AsyncChainingFuture(ListenableFuture var1, AsyncFunction var2) {
      super(var1, var2);
   }

   void doTransform(AsyncFunction var1, Object var2) {
      ListenableFuture var3 = var1.apply(var2);
      Preconditions.checkNotNull(var3, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
      this.setFuture(var3);
   }
}
