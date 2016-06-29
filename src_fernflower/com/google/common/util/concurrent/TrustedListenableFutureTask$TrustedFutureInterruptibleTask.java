package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.InterruptibleTask;
import com.google.common.util.concurrent.TrustedListenableFutureTask;
import java.util.concurrent.Callable;

final class TrustedListenableFutureTask$TrustedFutureInterruptibleTask extends InterruptibleTask {
   private final Callable callable;
   // $FF: synthetic field
   final TrustedListenableFutureTask this$0;

   TrustedListenableFutureTask$TrustedFutureInterruptibleTask(TrustedListenableFutureTask var1, Callable var2) {
      this.this$0 = var1;
      this.callable = (Callable)Preconditions.checkNotNull(var2);
   }

   void runInterruptibly() {
      if(!this.this$0.isDone()) {
         try {
            this.this$0.set(this.callable.call());
         } catch (Throwable var2) {
            this.this$0.setException(var2);
         }
      }

   }

   boolean wasInterrupted() {
      return this.this$0.wasInterrupted();
   }
}
