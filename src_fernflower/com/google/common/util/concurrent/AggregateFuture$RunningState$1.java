package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AggregateFuture$RunningState;
import com.google.common.util.concurrent.ListenableFuture;

class AggregateFuture$RunningState$1 implements Runnable {
   // $FF: synthetic field
   final int val$index;
   // $FF: synthetic field
   final ListenableFuture val$listenable;
   // $FF: synthetic field
   final AggregateFuture$RunningState this$1;

   AggregateFuture$RunningState$1(AggregateFuture$RunningState var1, int var2, ListenableFuture var3) {
      this.this$1 = var1;
      this.val$index = var2;
      this.val$listenable = var3;
   }

   public void run() {
      try {
         AggregateFuture$RunningState.access$200(this.this$1, this.val$index, this.val$listenable);
      } finally {
         AggregateFuture$RunningState.access$300(this.this$1);
      }

   }
}
