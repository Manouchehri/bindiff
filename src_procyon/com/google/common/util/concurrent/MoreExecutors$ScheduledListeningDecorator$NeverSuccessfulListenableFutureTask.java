package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;

@GwtIncompatible("TODO")
final class MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask extends AbstractFuture implements Runnable
{
    private final Runnable delegate;
    
    public MoreExecutors$ScheduledListeningDecorator$NeverSuccessfulListenableFutureTask(final Runnable runnable) {
        this.delegate = (Runnable)Preconditions.checkNotNull(runnable);
    }
    
    @Override
    public void run() {
        try {
            this.delegate.run();
        }
        catch (Throwable exception) {
            this.setException(exception);
            throw Throwables.propagate(exception);
        }
    }
}
