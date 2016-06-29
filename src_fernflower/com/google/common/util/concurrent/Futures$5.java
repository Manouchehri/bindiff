package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

final class Futures$5 implements Runnable {
   // $FF: synthetic field
   final ConcurrentLinkedQueue val$delegates;
   // $FF: synthetic field
   final ListenableFuture val$future;

   Futures$5(ConcurrentLinkedQueue var1, ListenableFuture var2) {
      this.val$delegates = var1;
      this.val$future = var2;
   }

   public void run() {
      ((SettableFuture)this.val$delegates.remove()).setFuture(this.val$future);
   }
}
