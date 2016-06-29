package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.BlockingQueue;

final class MoreExecutors$1 implements Runnable {
   // $FF: synthetic field
   final BlockingQueue val$queue;
   // $FF: synthetic field
   final ListenableFuture val$future;

   MoreExecutors$1(BlockingQueue var1, ListenableFuture var2) {
      this.val$queue = var1;
      this.val$future = var2;
   }

   public void run() {
      this.val$queue.add(this.val$future);
   }
}
