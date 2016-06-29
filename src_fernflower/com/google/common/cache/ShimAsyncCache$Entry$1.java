package com.google.common.cache;

import com.google.common.cache.ShimAsyncCache$Entry;
import com.google.common.cache.ShimAsyncCache$Entry$EntryState;
import com.google.common.util.concurrent.ListenableFuture;

class ShimAsyncCache$Entry$1 implements Runnable {
   // $FF: synthetic field
   final ListenableFuture val$future;
   // $FF: synthetic field
   final ShimAsyncCache$Entry this$0;

   ShimAsyncCache$Entry$1(ShimAsyncCache$Entry var1, ListenableFuture var2) {
      this.this$0 = var1;
      this.val$future = var2;
   }

   public void run() {
      ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).handleCompletion(this.val$future);
   }
}
