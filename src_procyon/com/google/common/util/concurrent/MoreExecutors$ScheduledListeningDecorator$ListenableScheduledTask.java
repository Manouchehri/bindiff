package com.google.common.util.concurrent;

import java.util.concurrent.*;

final class MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask extends ForwardingListenableFuture$SimpleForwardingListenableFuture implements ListenableScheduledFuture
{
    private final ScheduledFuture scheduledDelegate;
    
    public MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(final ListenableFuture listenableFuture, final ScheduledFuture scheduledDelegate) {
        super(listenableFuture);
        this.scheduledDelegate = scheduledDelegate;
    }
    
    @Override
    public boolean cancel(final boolean b) {
        final boolean cancel = super.cancel(b);
        if (cancel) {
            this.scheduledDelegate.cancel(b);
        }
        return cancel;
    }
    
    @Override
    public long getDelay(final TimeUnit timeUnit) {
        return this.scheduledDelegate.getDelay(timeUnit);
    }
    
    @Override
    public int compareTo(final Delayed delayed) {
        return this.scheduledDelegate.compareTo(delayed);
    }
}
