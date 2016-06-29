package com.google.common.util.concurrent;

import com.google.common.collect.*;
import java.util.*;
import java.util.concurrent.*;
import java.lang.reflect.*;
import com.google.common.base.*;
import com.google.common.annotations.*;

@GwtIncompatible("TODO")
@VisibleForTesting
class MoreExecutors$Application
{
    final ExecutorService getExitingExecutorService(final ThreadPoolExecutor threadPoolExecutor, final long n, final TimeUnit timeUnit) {
        useDaemonThreadFactory(threadPoolExecutor);
        final ExecutorService unconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.addDelayedShutdownHook(unconfigurableExecutorService, n, timeUnit);
        return unconfigurableExecutorService;
    }
    
    final ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, final long n, final TimeUnit timeUnit) {
        useDaemonThreadFactory(scheduledThreadPoolExecutor);
        final ScheduledExecutorService unconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
        this.addDelayedShutdownHook(unconfigurableScheduledExecutorService, n, timeUnit);
        return unconfigurableScheduledExecutorService;
    }
    
    final void addDelayedShutdownHook(final ExecutorService executorService, final long n, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(executorService);
        Preconditions.checkNotNull(timeUnit);
        final String value = String.valueOf(executorService);
        this.addShutdownHook(MoreExecutors.newThread(new StringBuilder(24 + String.valueOf(value).length()).append("DelayedShutdownHook-for-").append(value).toString(), new MoreExecutors$Application$1(this, executorService, n, timeUnit)));
    }
    
    final ExecutorService getExitingExecutorService(final ThreadPoolExecutor threadPoolExecutor) {
        return this.getExitingExecutorService(threadPoolExecutor, 120L, TimeUnit.SECONDS);
    }
    
    final ScheduledExecutorService getExitingScheduledExecutorService(final ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return this.getExitingScheduledExecutorService(scheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
    }
    
    @VisibleForTesting
    void addShutdownHook(final Thread thread) {
        Runtime.getRuntime().addShutdownHook(thread);
    }
}
