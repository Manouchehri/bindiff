/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Function;
import com.google.common.util.concurrent.Futures$AbstractChainingFuture;
import com.google.common.util.concurrent.ListenableFuture;

final class Futures$ChainingFuture
extends Futures$AbstractChainingFuture {
    Futures$ChainingFuture(ListenableFuture listenableFuture, Function function) {
        super(listenableFuture, function);
    }

    void doTransform(Function function, Object object) {
        this.set(function.apply(object));
    }
}

