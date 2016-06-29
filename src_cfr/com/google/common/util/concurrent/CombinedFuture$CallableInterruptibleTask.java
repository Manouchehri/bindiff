/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.CombinedFuture$CombinedFutureInterruptibleTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

final class CombinedFuture$CallableInterruptibleTask
extends CombinedFuture$CombinedFutureInterruptibleTask {
    private final Callable callable;
    final /* synthetic */ CombinedFuture this$0;

    public CombinedFuture$CallableInterruptibleTask(CombinedFuture combinedFuture, Callable callable, Executor executor) {
        this.this$0 = combinedFuture;
        super(combinedFuture, executor);
        this.callable = (Callable)Preconditions.checkNotNull(callable);
    }

    @Override
    void setValue() {
        this.this$0.set(this.callable.call());
    }
}

