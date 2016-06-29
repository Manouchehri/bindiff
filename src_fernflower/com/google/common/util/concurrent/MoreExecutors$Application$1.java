package com.google.common.util.concurrent;

import com.google.common.util.concurrent.MoreExecutors$Application;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class MoreExecutors$Application$1 implements Runnable {
   // $FF: synthetic field
   final ExecutorService val$service;
   // $FF: synthetic field
   final long val$terminationTimeout;
   // $FF: synthetic field
   final TimeUnit val$timeUnit;
   // $FF: synthetic field
   final MoreExecutors$Application this$0;

   MoreExecutors$Application$1(MoreExecutors$Application var1, ExecutorService var2, long var3, TimeUnit var5) {
      this.this$0 = var1;
      this.val$service = var2;
      this.val$terminationTimeout = var3;
      this.val$timeUnit = var5;
   }

   public void run() {
      try {
         this.val$service.shutdown();
         this.val$service.awaitTermination(this.val$terminationTimeout, this.val$timeUnit);
      } catch (InterruptedException var2) {
         ;
      }

   }
}
