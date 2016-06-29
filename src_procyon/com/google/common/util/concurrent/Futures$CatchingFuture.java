package com.google.common.util.concurrent;

import com.google.common.base.*;

final class Futures$CatchingFuture extends Futures$AbstractCatchingFuture
{
    Futures$CatchingFuture(final ListenableFuture listenableFuture, final Class clazz, final Function function) {
        super(listenableFuture, clazz, function);
    }
    
    void doFallback(final Function function, final Throwable t) {
        this.set(function.apply(t));
    }
}
