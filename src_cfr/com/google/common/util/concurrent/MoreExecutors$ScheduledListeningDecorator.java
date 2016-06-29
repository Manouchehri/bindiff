/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import com.google.common.util.concurrent.ListeningScheduledExecutorService;
import com.google.common.util.concurrent.MoreExecutors$ListeningDecorator;
import com.google.common.util.concurrent.MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask;
import com.google.common.util.concurrent.MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask;
import com.google.common.util.concurrent.TrustedListenableFutureTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

@GwtIncompatible(value="TODO")
class MoreExecutors$ScheduledListeningDecorator
extends MoreExecutors$ListeningDecorator
implements ListeningScheduledExecutorService {
    final ScheduledExecutorService delegate;

    MoreExecutors$ScheduledListeningDecorator(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.delegate = (ScheduledExecutorService)Preconditions.checkNotNull(scheduledExecutorService);
    }

    @Override
    public ListenableScheduledFuture schedule(Runnable runnable, long l2, TimeUnit timeUnit) {
        TrustedListenableFutureTask trustedListenableFutureTask = TrustedListenableFutureTask.create(runnable, null);
        ScheduledFuture scheduledFuture = this.delegate.schedule(trustedListenableFutureTask, l2, timeUnit);
        return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(trustedListenableFutureTask, scheduledFuture);
    }

    @Override
    public ListenableScheduledFuture schedule(Callable callable, long l2, TimeUnit timeUnit) {
        TrustedListenableFutureTask trustedListenableFutureTask = TrustedListenableFutureTask.create(callable);
        ScheduledFuture scheduledFuture = this.delegate.schedule(trustedListenableFutureTask, l2, timeUnit);
        return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(trustedListenableFutureTask, scheduledFuture);
    }

    @Override
    public ListenableScheduledFuture scheduleAtFixedRate(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask = new MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(runnable);
        ScheduledFuture scheduledFuture = this.delegate.scheduleAtFixedRate(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, l2, l3, timeUnit);
        return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, scheduledFuture);
    }

    @Override
    public ListenableScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask = new MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(runnable);
        ScheduledFuture scheduledFuture = this.delegate.scheduleWithFixedDelay(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, l2, l3, timeUnit);
        return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, scheduledFuture);
    }
}

