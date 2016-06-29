package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.CombinedFuture$AsyncCallableInterruptibleTask;
import com.google.common.util.concurrent.CombinedFuture$CallableInterruptibleTask;
import com.google.common.util.concurrent.CombinedFuture$CombinedFutureRunningState;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

@GoogleInternal
@GwtCompatible
final class CombinedFuture extends AggregateFuture {
   CombinedFuture(ImmutableCollection var1, boolean var2, Executor var3, AsyncCallable var4) {
      this.init(new CombinedFuture$CombinedFutureRunningState(this, var1, var2, new CombinedFuture$AsyncCallableInterruptibleTask(this, var4, var3)));
   }

   CombinedFuture(ImmutableCollection var1, boolean var2, Executor var3, Callable var4) {
      this.init(new CombinedFuture$CombinedFutureRunningState(this, var1, var2, new CombinedFuture$CallableInterruptibleTask(this, var4, var3)));
   }
}
