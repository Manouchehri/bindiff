package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.MoreExecutors$Application$1;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@GwtIncompatible("TODO")
@VisibleForTesting
class MoreExecutors$Application {
   final ExecutorService getExitingExecutorService(ThreadPoolExecutor var1, long var2, TimeUnit var4) {
      MoreExecutors.access$000(var1);
      ExecutorService var5 = Executors.unconfigurableExecutorService(var1);
      this.addDelayedShutdownHook(var5, var2, var4);
      return var5;
   }

   final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor var1, long var2, TimeUnit var4) {
      MoreExecutors.access$000(var1);
      ScheduledExecutorService var5 = Executors.unconfigurableScheduledExecutorService(var1);
      this.addDelayedShutdownHook(var5, var2, var4);
      return var5;
   }

   final void addDelayedShutdownHook(ExecutorService var1, long var2, TimeUnit var4) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var4);
      String var5 = String.valueOf(var1);
      this.addShutdownHook(MoreExecutors.newThread((new StringBuilder(24 + String.valueOf(var5).length())).append("DelayedShutdownHook-for-").append(var5).toString(), new MoreExecutors$Application$1(this, var1, var2, var4)));
   }

   final ExecutorService getExitingExecutorService(ThreadPoolExecutor var1) {
      return this.getExitingExecutorService(var1, 120L, TimeUnit.SECONDS);
   }

   final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor var1) {
      return this.getExitingScheduledExecutorService(var1, 120L, TimeUnit.SECONDS);
   }

   @VisibleForTesting
   void addShutdownHook(Thread var1) {
      Runtime.getRuntime().addShutdownHook(var1);
   }
}
