package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.collect.*;
import java.util.concurrent.*;

@GoogleInternal
@GwtCompatible
final class CombinedFuture extends AggregateFuture
{
    CombinedFuture(final ImmutableCollection collection, final boolean b, final Executor executor, final AsyncCallable asyncCallable) {
        this.init(new CombinedFuture$CombinedFutureRunningState(this, collection, b, new CombinedFuture$AsyncCallableInterruptibleTask(this, asyncCallable, executor)));
    }
    
    CombinedFuture(final ImmutableCollection collection, final boolean b, final Executor executor, final Callable callable) {
        this.init(new CombinedFuture$CombinedFutureRunningState(this, collection, b, new CombinedFuture$CallableInterruptibleTask(this, callable, executor)));
    }
}
