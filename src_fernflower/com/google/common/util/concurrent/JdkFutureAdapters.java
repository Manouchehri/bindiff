package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.JdkFutureAdapters$ListenableFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@Beta
public final class JdkFutureAdapters {
   public static ListenableFuture listenInPoolThread(Future var0) {
      return (ListenableFuture)(var0 instanceof ListenableFuture?(ListenableFuture)var0:new JdkFutureAdapters$ListenableFutureAdapter(var0));
   }

   public static ListenableFuture listenInPoolThread(Future var0, Executor var1) {
      Preconditions.checkNotNull(var1);
      return (ListenableFuture)(var0 instanceof ListenableFuture?(ListenableFuture)var0:new JdkFutureAdapters$ListenableFutureAdapter(var0, var1));
   }
}
