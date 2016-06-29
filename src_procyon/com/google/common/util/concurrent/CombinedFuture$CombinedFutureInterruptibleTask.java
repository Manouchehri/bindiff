package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.*;

abstract class CombinedFuture$CombinedFutureInterruptibleTask extends InterruptibleTask
{
    private final Executor listenerExecutor;
    volatile boolean thrownByExecute;
    final /* synthetic */ CombinedFuture this$0;
    
    public CombinedFuture$CombinedFutureInterruptibleTask(final CombinedFuture this$0, final Executor executor) {
        this.this$0 = this$0;
        this.thrownByExecute = true;
        this.listenerExecutor = (Executor)Preconditions.checkNotNull(executor);
    }
    
    @Override
    final void runInterruptibly() {
        this.thrownByExecute = false;
        if (!this.this$0.isDone()) {
            try {
                this.setValue();
            }
            catch (ExecutionException ex) {
                this.this$0.setException(ex.getCause());
            }
            catch (CancellationException ex2) {
                this.this$0.cancel(false);
            }
            catch (Throwable exception) {
                this.this$0.setException(exception);
            }
        }
    }
    
    @Override
    final boolean wasInterrupted() {
        return this.this$0.wasInterrupted();
    }
    
    final void execute() {
        try {
            this.listenerExecutor.execute(this);
        }
        catch (RejectedExecutionException exception) {
            if (this.thrownByExecute) {
                this.this$0.setException(exception);
            }
        }
    }
    
    abstract void setValue();
}
