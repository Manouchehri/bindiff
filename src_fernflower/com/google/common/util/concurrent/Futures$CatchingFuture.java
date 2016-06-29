package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures$AbstractCatchingFuture;
import com.google.common.util.concurrent.ListenableFuture;

final class Futures$CatchingFuture extends Futures$AbstractCatchingFuture {
   Futures$CatchingFuture(ListenableFuture var1, Class var2, Function var3) {
      super(var1, var2, var3);
   }

   void doFallback(Function var1, Throwable var2) {
      Object var3 = var1.apply(var2);
      this.set(var3);
   }
}
