package com.google.common.util.concurrent;

import java.util.concurrent.*;
import com.google.common.base.*;

final class CombinedFuture$CallableInterruptibleTask extends CombinedFuture$CombinedFutureInterruptibleTask
{
    private final Callable callable;
    final /* synthetic */ CombinedFuture this$0;
    
    public CombinedFuture$CallableInterruptibleTask(final CombinedFuture this$0, final Callable callable, final Executor executor) {
        this.this$0 = this$0;
        super(this$0, executor);
        this.callable = (Callable)Preconditions.checkNotNull(callable);
    }
    
    @Override
    void setValue() {
        this.this$0.set(this.callable.call());
    }
}
