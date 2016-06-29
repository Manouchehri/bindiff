package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Futures$NonCancellationPropagatingFuture;
import com.google.common.util.concurrent.ListenableFuture;

class Futures$NonCancellationPropagatingFuture$1 implements Runnable {
   // $FF: synthetic field
   final ListenableFuture val$delegate;
   // $FF: synthetic field
   final Futures$NonCancellationPropagatingFuture this$0;

   Futures$NonCancellationPropagatingFuture$1(Futures$NonCancellationPropagatingFuture var1, ListenableFuture var2) {
      this.this$0 = var1;
      this.val$delegate = var2;
   }

   public void run() {
      this.this$0.setFuture(this.val$delegate);
   }
}
