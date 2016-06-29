package com.google.common.util.concurrent;

import java.util.concurrent.*;
import com.google.common.base.*;

final class CombinedFuture$AsyncCallableInterruptibleTask extends CombinedFuture$CombinedFutureInterruptibleTask
{
    private final AsyncCallable callable;
    final /* synthetic */ CombinedFuture this$0;
    
    public CombinedFuture$AsyncCallableInterruptibleTask(final CombinedFuture this$0, final AsyncCallable asyncCallable, final Executor executor) {
        this.this$0 = this$0;
        super(this$0, executor);
        this.callable = (AsyncCallable)Preconditions.checkNotNull(asyncCallable);
    }
    
    @Override
    void setValue() {
        this.this$0.setFuture(this.callable.call());
    }
}
