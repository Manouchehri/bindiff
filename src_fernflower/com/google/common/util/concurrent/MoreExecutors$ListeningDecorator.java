package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractListeningExecutorService;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@GwtIncompatible("TODO")
class MoreExecutors$ListeningDecorator extends AbstractListeningExecutorService {
   private final ExecutorService delegate;

   MoreExecutors$ListeningDecorator(ExecutorService var1) {
      this.delegate = (ExecutorService)Preconditions.checkNotNull(var1);
   }

   public boolean awaitTermination(long var1, TimeUnit var3) {
      return this.delegate.awaitTermination(var1, var3);
   }

   public boolean isShutdown() {
      return this.delegate.isShutdown();
   }

   public boolean isTerminated() {
      return this.delegate.isTerminated();
   }

   public void shutdown() {
      this.delegate.shutdown();
   }

   public List shutdownNow() {
      return this.delegate.shutdownNow();
   }

   public void execute(Runnable var1) {
      this.delegate.execute(var1);
   }
}
