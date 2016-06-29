package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.TrustedListenableFutureTask$TrustedFutureInterruptibleTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@GwtCompatible
class TrustedListenableFutureTask extends AbstractFuture$TrustedFuture implements RunnableFuture {
   private TrustedListenableFutureTask$TrustedFutureInterruptibleTask task;

   static TrustedListenableFutureTask create(Callable var0) {
      return new TrustedListenableFutureTask(var0);
   }

   static TrustedListenableFutureTask create(Runnable var0, @Nullable Object var1) {
      return new TrustedListenableFutureTask(Executors.callable(var0, var1));
   }

   TrustedListenableFutureTask(Callable var1) {
      this.task = new TrustedListenableFutureTask$TrustedFutureInterruptibleTask(this, var1);
   }

   public void run() {
      TrustedListenableFutureTask$TrustedFutureInterruptibleTask var1 = this.task;
      if(var1 != null) {
         var1.run();
      }

   }

   final void done() {
      super.done();
      this.task = null;
   }

   @GwtIncompatible("Interruption not supported")
   protected final void interruptTask() {
      TrustedListenableFutureTask$TrustedFutureInterruptibleTask var1 = this.task;
      if(var1 != null) {
         var1.interruptTask();
      }

   }
}
