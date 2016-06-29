package com.google.common.util.concurrent;

import javax.annotation.*;
import java.util.concurrent.*;
import com.google.common.annotations.*;

@GwtCompatible
class TrustedListenableFutureTask extends AbstractFuture$TrustedFuture implements RunnableFuture
{
    private TrustedListenableFutureTask$TrustedFutureInterruptibleTask task;
    
    static TrustedListenableFutureTask create(final Callable callable) {
        return new TrustedListenableFutureTask(callable);
    }
    
    static TrustedListenableFutureTask create(final Runnable runnable, @Nullable final Object o) {
        return new TrustedListenableFutureTask(Executors.callable(runnable, o));
    }
    
    TrustedListenableFutureTask(final Callable callable) {
        this.task = new TrustedListenableFutureTask$TrustedFutureInterruptibleTask(this, callable);
    }
    
    @Override
    public void run() {
        final TrustedListenableFutureTask$TrustedFutureInterruptibleTask task = this.task;
        if (task != null) {
            task.run();
        }
    }
    
    @Override
    final void done() {
        super.done();
        this.task = null;
    }
    
    @GwtIncompatible("Interruption not supported")
    @Override
    protected final void interruptTask() {
        final TrustedListenableFutureTask$TrustedFutureInterruptibleTask task = this.task;
        if (task != null) {
            task.interruptTask();
        }
    }
}
