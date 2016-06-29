package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors$ListeningDecorator;
import com.google.common.util.concurrent.MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask;
import com.google.common.util.concurrent.MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask;
import com.google.common.util.concurrent.TrustedListenableFutureTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@GwtIncompatible("TODO")
class MoreExecutors$ScheduledListeningDecorator extends MoreExecutors$ListeningDecorator implements ListeningScheduledExecutorService {
   final ScheduledExecutorService delegate;

   MoreExecutors$ScheduledListeningDecorator(ScheduledExecutorService var1) {
      super(var1);
      this.delegate = (ScheduledExecutorService)Preconditions.checkNotNull(var1);
   }

   public ListenableScheduledFuture schedule(Runnable var1, long var2, TimeUnit var4) {
      TrustedListenableFutureTask var5 = TrustedListenableFutureTask.create(var1, (Object)null);
      ScheduledFuture var6 = this.delegate.schedule(var5, var2, var4);
      return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(var5, var6);
   }

   public ListenableScheduledFuture schedule(Callable var1, long var2, TimeUnit var4) {
      TrustedListenableFutureTask var5 = TrustedListenableFutureTask.create(var1);
      ScheduledFuture var6 = this.delegate.schedule(var5, var2, var4);
      return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(var5, var6);
   }

   public ListenableScheduledFuture scheduleAtFixedRate(Runnable var1, long var2, long var4, TimeUnit var6) {
      MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask var7 = new MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(var1);
      ScheduledFuture var8 = this.delegate.scheduleAtFixedRate(var7, var2, var4, var6);
      return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(var7, var8);
   }

   public ListenableScheduledFuture scheduleWithFixedDelay(Runnable var1, long var2, long var4, TimeUnit var6) {
      MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask var7 = new MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(var1);
      ScheduledFuture var8 = this.delegate.scheduleWithFixedDelay(var7, var2, var4, var6);
      return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(var7, var8);
   }
}
