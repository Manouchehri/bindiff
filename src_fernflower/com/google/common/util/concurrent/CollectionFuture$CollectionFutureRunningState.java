package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture$RunningState;
import com.google.common.util.concurrent.CollectionFuture;
import java.util.List;
import javax.annotation.Nullable;

abstract class CollectionFuture$CollectionFutureRunningState extends AggregateFuture$RunningState {
   private List values;
   // $FF: synthetic field
   final CollectionFuture this$0;

   CollectionFuture$CollectionFutureRunningState(CollectionFuture var1, ImmutableCollection var2, boolean var3) {
      super(var1, var2, var3, true);
      this.this$0 = var1;
      this.values = (List)(var2.isEmpty()?ImmutableList.of():Lists.newArrayListWithCapacity(var2.size()));

      for(int var4 = 0; var4 < var2.size(); ++var4) {
         this.values.add((Object)null);
      }

   }

   final void collectOneValue(boolean var1, int var2, @Nullable Object var3) {
      List var4 = this.values;
      if(var4 != null) {
         var4.set(var2, Optional.fromNullable(var3));
      } else {
         Preconditions.checkState(var1 || this.this$0.isCancelled(), "Future was done before all dependencies completed");
      }

   }

   final void handleAllCompleted() {
      List var1 = this.values;
      if(var1 != null) {
         this.this$0.set(this.combine(var1));
      } else {
         Preconditions.checkState(this.this$0.isDone());
      }

   }

   void releaseResourcesAfterFailure() {
      super.releaseResourcesAfterFailure();
      this.values = null;
   }

   abstract Object combine(List var1);
}
