/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.CombinedFuture$CombinedFutureInterruptibleTask;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;

final class CombinedFuture$AsyncCallableInterruptibleTask
extends CombinedFuture$CombinedFutureInterruptibleTask {
    private final AsyncCallable callable;
    final /* synthetic */ CombinedFuture this$0;

    public CombinedFuture$AsyncCallableInterruptibleTask(CombinedFuture combinedFuture, AsyncCallable asyncCallable, Executor executor) {
        this.this$0 = combinedFuture;
        super(combinedFuture, executor);
        this.callable = (AsyncCallable)Preconditions.checkNotNull(asyncCallable);
    }

    @Override
    void setValue() {
        this.this$0.setFuture(this.callable.call());
    }
}

