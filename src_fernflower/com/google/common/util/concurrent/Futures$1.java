package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncFunction;
import com.google.common.util.concurrent.FutureFallback;
import com.google.common.util.concurrent.ListenableFuture;

final class Futures$1 implements AsyncFunction {
   // $FF: synthetic field
   final FutureFallback val$fallback;

   Futures$1(FutureFallback var1) {
      this.val$fallback = var1;
   }

   public ListenableFuture apply(Throwable var1) {
      return (ListenableFuture)Preconditions.checkNotNull(this.val$fallback.create(var1), "FutureFallback.create returned null instead of a Future. Did you mean to return immediateFuture(null)?");
   }
}
