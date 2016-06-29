package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.CombinedFuture$CombinedFutureInterruptibleTask;
import java.util.concurrent.Executor;

final class CombinedFuture$AsyncCallableInterruptibleTask extends CombinedFuture$CombinedFutureInterruptibleTask {
   private final AsyncCallable callable;
   // $FF: synthetic field
   final CombinedFuture this$0;

   public CombinedFuture$AsyncCallableInterruptibleTask(CombinedFuture var1, AsyncCallable var2, Executor var3) {
      super(var1, var3);
      this.this$0 = var1;
      this.callable = (AsyncCallable)Preconditions.checkNotNull(var2);
   }

   void setValue() {
      this.this$0.setFuture(this.callable.call());
   }
}
