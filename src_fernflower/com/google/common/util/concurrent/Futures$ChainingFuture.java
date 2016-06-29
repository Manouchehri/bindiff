package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures$AbstractChainingFuture;
import com.google.common.util.concurrent.ListenableFuture;

final class Futures$ChainingFuture extends Futures$AbstractChainingFuture {
   Futures$ChainingFuture(ListenableFuture var1, Function var2) {
      super(var1, var2);
   }

   void doTransform(Function var1, Object var2) {
      this.set(var1.apply(var2));
   }
}
