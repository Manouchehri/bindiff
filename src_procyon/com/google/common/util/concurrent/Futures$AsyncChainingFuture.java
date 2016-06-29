package com.google.common.util.concurrent;

import com.google.common.base.*;

final class Futures$AsyncChainingFuture extends Futures$AbstractChainingFuture
{
    Futures$AsyncChainingFuture(final ListenableFuture listenableFuture, final AsyncFunction asyncFunction) {
        super(listenableFuture, asyncFunction);
    }
    
    void doTransform(final AsyncFunction asyncFunction, final Object o) {
        final ListenableFuture apply = asyncFunction.apply(o);
        Preconditions.checkNotNull(apply, (Object)"AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)?");
        this.setFuture(apply);
    }
}
