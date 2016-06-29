package com.google.common.util.concurrent;

import java.util.concurrent.*;

final class Futures$2 implements Executor
{
    volatile boolean thrownFromDelegate;
    final /* synthetic */ Executor val$delegate;
    final /* synthetic */ AbstractFuture val$future;
    
    Futures$2(final Executor val$delegate, final AbstractFuture val$future) {
        this.val$delegate = val$delegate;
        this.val$future = val$future;
        this.thrownFromDelegate = true;
    }
    
    @Override
    public void execute(final Runnable runnable) {
        try {
            this.val$delegate.execute(new Futures$2$1(this, runnable));
        }
        catch (RejectedExecutionException exception) {
            if (this.thrownFromDelegate) {
                this.val$future.setException(exception);
            }
        }
    }
}
