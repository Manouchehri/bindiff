package com.google.common.util.concurrent;

import com.google.common.base.*;

final class Futures$AsyncCatchingFuture extends Futures$AbstractCatchingFuture
{
    Futures$AsyncCatchingFuture(final ListenableFuture listenableFuture, final Class clazz, final AsyncFunction asyncFunction) {
        super(listenableFuture, clazz, asyncFunction);
    }
    
    void doFallback(final AsyncFunction asyncFunction, final Throwable t) {
        final ListenableFuture apply = asyncFunction.apply(t);
        Preconditions.checkNotNull(apply, (Object)"AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
        this.setFuture(apply);
    }
}
