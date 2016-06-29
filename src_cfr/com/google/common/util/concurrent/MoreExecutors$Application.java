/*
 * Decompiled with CFR 0_115.
 */
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

@GwtIncompatible(value="TODO")
@VisibleForTesting
class MoreExecutors$Application {
    MoreExecutors$Application() {
    }

    final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor, long l2, TimeUnit timeUnit) {
        MoreExecutors.access$000(threadPoolExecutor);
        ExecutorService executorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.addDelayedShutdownHook(executorService, l2, timeUnit);
        return executorService;
    }

    final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long l2, TimeUnit timeUnit) {
        MoreExecutors.access$000(scheduledThreadPoolExecutor);
        ScheduledExecutorService scheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
        this.addDelayedShutdownHook(scheduledExecutorService, l2, timeUnit);
        return scheduledExecutorService;
    }

    final void addDelayedShutdownHook(ExecutorService executorService, long l2, TimeUnit timeUnit) {
        Preconditions.checkNotNull(executorService);
        Preconditions.checkNotNull((Object)timeUnit);
        String string = String.valueOf(executorService);
        this.addShutdownHook(MoreExecutors.newThread(new StringBuilder(24 + String.valueOf(string).length()).append("DelayedShutdownHook-for-").append(string).toString(), new MoreExecutors$Application$1(this, executorService, l2, timeUnit)));
    }

    final ExecutorService getExitingExecutorService(ThreadPoolExecutor threadPoolExecutor) {
        return this.getExitingExecutorService(threadPoolExecutor, 120, TimeUnit.SECONDS);
    }

    final ScheduledExecutorService getExitingScheduledExecutorService(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return this.getExitingScheduledExecutorService(scheduledThreadPoolExecutor, 120, TimeUnit.SECONDS);
    }

    @VisibleForTesting
    void addShutdownHook(Thread thread) {
        Runtime.getRuntime().addShutdownHook(thread);
    }
}

