/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures$AbstractCatchingFuture;
import com.google.common.util.concurrent.ListenableFuture;

final class Futures$CatchingFuture
extends Futures$AbstractCatchingFuture {
    Futures$CatchingFuture(ListenableFuture listenableFuture, Class class_, Function function) {
        super(listenableFuture, class_, function);
    }

    void doFallback(Function function, Throwable throwable) {
        Object object = function.apply(throwable);
        this.set(object);
    }
}

