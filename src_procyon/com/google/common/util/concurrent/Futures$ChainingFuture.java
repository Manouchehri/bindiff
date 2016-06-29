package com.google.common.util.concurrent;

import com.google.common.base.*;

final class Futures$ChainingFuture extends Futures$AbstractChainingFuture
{
    Futures$ChainingFuture(final ListenableFuture listenableFuture, final Function function) {
        super(listenableFuture, function);
    }
    
    void doTransform(final Function function, final Object o) {
        this.set(function.apply(o));
    }
}
