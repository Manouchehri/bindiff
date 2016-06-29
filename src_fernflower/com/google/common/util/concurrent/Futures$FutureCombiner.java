package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

@GoogleInternal
@GwtCompatible
public final class Futures$FutureCombiner {
   private final boolean allMustSucceed;
   private final ImmutableList futures;

   private Futures$FutureCombiner(boolean var1, ImmutableList var2) {
      this.allMustSucceed = var1;
      this.futures = var2;
   }

   public ListenableFuture callAsync(AsyncCallable var1, Executor var2) {
      return new CombinedFuture(this.futures, this.allMustSucceed, var2, var1);
   }

   public ListenableFuture callAsync(AsyncCallable var1) {
      return this.callAsync(var1, MoreExecutors.directExecutor());
   }

   public ListenableFuture call(Callable var1, Executor var2) {
      return new CombinedFuture(this.futures, this.allMustSucceed, var2, var1);
   }

   public ListenableFuture call(Callable var1) {
      return this.call(var1, MoreExecutors.directExecutor());
   }

   // $FF: synthetic method
   Futures$FutureCombiner(boolean var1, ImmutableList var2, Futures$1 var3) {
      this(var1, var2);
   }
}
