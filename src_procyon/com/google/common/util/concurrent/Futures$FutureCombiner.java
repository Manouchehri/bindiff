package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.collect.*;
import java.util.concurrent.*;

@GoogleInternal
@GwtCompatible
public final class Futures$FutureCombiner
{
    private final boolean allMustSucceed;
    private final ImmutableList futures;
    
    private Futures$FutureCombiner(final boolean allMustSucceed, final ImmutableList futures) {
        this.allMustSucceed = allMustSucceed;
        this.futures = futures;
    }
    
    public ListenableFuture callAsync(final AsyncCallable asyncCallable, final Executor executor) {
        return new CombinedFuture(this.futures, this.allMustSucceed, executor, asyncCallable);
    }
    
    public ListenableFuture callAsync(final AsyncCallable asyncCallable) {
        return this.callAsync(asyncCallable, MoreExecutors.directExecutor());
    }
    
    public ListenableFuture call(final Callable callable, final Executor executor) {
        return new CombinedFuture(this.futures, this.allMustSucceed, executor, callable);
    }
    
    public ListenableFuture call(final Callable callable) {
        return this.call(callable, MoreExecutors.directExecutor());
    }
}
