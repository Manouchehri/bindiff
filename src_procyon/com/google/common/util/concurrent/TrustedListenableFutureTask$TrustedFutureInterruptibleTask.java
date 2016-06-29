package com.google.common.util.concurrent;

import java.util.concurrent.*;
import com.google.common.base.*;

final class TrustedListenableFutureTask$TrustedFutureInterruptibleTask extends InterruptibleTask
{
    private final Callable callable;
    final /* synthetic */ TrustedListenableFutureTask this$0;
    
    TrustedListenableFutureTask$TrustedFutureInterruptibleTask(final TrustedListenableFutureTask this$0, final Callable callable) {
        this.this$0 = this$0;
        this.callable = (Callable)Preconditions.checkNotNull(callable);
    }
    
    @Override
    void runInterruptibly() {
        if (!this.this$0.isDone()) {
            try {
                this.this$0.set(this.callable.call());
            }
            catch (Throwable exception) {
                this.this$0.setException(exception);
            }
        }
    }
    
    @Override
    boolean wasInterrupted() {
        return this.this$0.wasInterrupted();
    }
}
