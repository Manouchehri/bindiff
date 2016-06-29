package com.google.common.util.concurrent;

import com.google.common.collect.*;
import javax.annotation.*;
import com.google.common.base.*;

final class CombinedFuture$CombinedFutureRunningState extends AggregateFuture$RunningState
{
    private CombinedFuture$CombinedFutureInterruptibleTask task;
    final /* synthetic */ CombinedFuture this$0;
    
    CombinedFuture$CombinedFutureRunningState(final CombinedFuture this$0, final ImmutableCollection collection, final boolean b, final CombinedFuture$CombinedFutureInterruptibleTask task) {
        this.this$0 = this$0;
        super(this$0, collection, b, false);
        this.task = task;
    }
    
    @Override
    void collectOneValue(final boolean b, final int n, @Nullable final Object o) {
    }
    
    @Override
    void handleAllCompleted() {
        final CombinedFuture$CombinedFutureInterruptibleTask task = this.task;
        if (task != null) {
            task.execute();
        }
        else {
            Preconditions.checkState(this.this$0.isDone());
        }
    }
    
    @Override
    void releaseResourcesAfterFailure() {
        super.releaseResourcesAfterFailure();
        this.task = null;
    }
    
    @Override
    void interruptTask() {
        final CombinedFuture$CombinedFutureInterruptibleTask task = this.task;
        if (task != null) {
            task.interruptTask();
        }
    }
}
