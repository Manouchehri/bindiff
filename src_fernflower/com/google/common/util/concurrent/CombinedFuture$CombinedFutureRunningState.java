package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture$RunningState;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.CombinedFuture$CombinedFutureInterruptibleTask;
import javax.annotation.Nullable;

final class CombinedFuture$CombinedFutureRunningState extends AggregateFuture$RunningState {
   private CombinedFuture$CombinedFutureInterruptibleTask task;
   // $FF: synthetic field
   final CombinedFuture this$0;

   CombinedFuture$CombinedFutureRunningState(CombinedFuture var1, ImmutableCollection var2, boolean var3, CombinedFuture$CombinedFutureInterruptibleTask var4) {
      super(var1, var2, var3, false);
      this.this$0 = var1;
      this.task = var4;
   }

   void collectOneValue(boolean var1, int var2, @Nullable Object var3) {
   }

   void handleAllCompleted() {
      CombinedFuture$CombinedFutureInterruptibleTask var1 = this.task;
      if(var1 != null) {
         var1.execute();
      } else {
         Preconditions.checkState(this.this$0.isDone());
      }

   }

   void releaseResourcesAfterFailure() {
      super.releaseResourcesAfterFailure();
      this.task = null;
   }

   void interruptTask() {
      CombinedFuture$CombinedFutureInterruptibleTask var1 = this.task;
      if(var1 != null) {
         var1.interruptTask();
      }

   }
}
