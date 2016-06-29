package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.InterruptibleTask;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

abstract class CombinedFuture$CombinedFutureInterruptibleTask extends InterruptibleTask {
   private final Executor listenerExecutor;
   volatile boolean thrownByExecute;
   // $FF: synthetic field
   final CombinedFuture this$0;

   public CombinedFuture$CombinedFutureInterruptibleTask(CombinedFuture var1, Executor var2) {
      this.this$0 = var1;
      this.thrownByExecute = true;
      this.listenerExecutor = (Executor)Preconditions.checkNotNull(var2);
   }

   final void runInterruptibly() {
      this.thrownByExecute = false;
      if(!this.this$0.isDone()) {
         try {
            this.setValue();
         } catch (ExecutionException var2) {
            this.this$0.setException(var2.getCause());
         } catch (CancellationException var3) {
            this.this$0.cancel(false);
         } catch (Throwable var4) {
            this.this$0.setException(var4);
         }
      }

   }

   final boolean wasInterrupted() {
      return this.this$0.wasInterrupted();
   }

   final void execute() {
      try {
         this.listenerExecutor.execute(this);
      } catch (RejectedExecutionException var2) {
         if(this.thrownByExecute) {
            this.this$0.setException(var2);
         }
      }

   }

   abstract void setValue();
}
