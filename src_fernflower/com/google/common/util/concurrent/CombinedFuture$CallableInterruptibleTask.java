package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.CombinedFuture$CombinedFutureInterruptibleTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

final class CombinedFuture$CallableInterruptibleTask extends CombinedFuture$CombinedFutureInterruptibleTask {
   private final Callable callable;
   // $FF: synthetic field
   final CombinedFuture this$0;

   public CombinedFuture$CallableInterruptibleTask(CombinedFuture var1, Callable var2, Executor var3) {
      super(var1, var3);
      this.this$0 = var1;
      this.callable = (Callable)Preconditions.checkNotNull(var2);
   }

   void setValue() {
      this.this$0.set(this.callable.call());
   }
}
