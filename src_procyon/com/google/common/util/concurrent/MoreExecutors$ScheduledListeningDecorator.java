package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;

@GwtIncompatible("TODO")
class MoreExecutors$ScheduledListeningDecorator extends MoreExecutors$ListeningDecorator implements ListeningScheduledExecutorService
{
    final ScheduledExecutorService delegate;
    
    MoreExecutors$ScheduledListeningDecorator(final ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.delegate = (ScheduledExecutorService)Preconditions.checkNotNull(scheduledExecutorService);
    }
    
    @Override
    public ListenableScheduledFuture schedule(final Runnable runnable, final long n, final TimeUnit timeUnit) {
        final TrustedListenableFutureTask create = TrustedListenableFutureTask.create(runnable, null);
        return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(create, this.delegate.schedule(create, n, timeUnit));
    }
    
    @Override
    public ListenableScheduledFuture schedule(final Callable callable, final long n, final TimeUnit timeUnit) {
        final TrustedListenableFutureTask create = TrustedListenableFutureTask.create(callable);
        return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(create, this.delegate.schedule(create, n, timeUnit));
    }
    
    @Override
    public ListenableScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long n, final long n2, final TimeUnit timeUnit) {
        final MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask = new MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(runnable);
        return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, this.delegate.scheduleAtFixedRate(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, n, n2, timeUnit));
    }
    
    @Override
    public ListenableScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long n, final long n2, final TimeUnit timeUnit) {
        final MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask = new MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(runnable);
        return new MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, this.delegate.scheduleWithFixedDelay(moreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask, n, n2, timeUnit));
    }
}
