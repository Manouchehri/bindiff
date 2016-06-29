/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.InterruptibleTask;
import com.google.common.util.concurrent.TrustedListenableFutureTask;
import java.util.concurrent.Callable;

final class TrustedListenableFutureTask$TrustedFutureInterruptibleTask
extends InterruptibleTask {
    private final Callable callable;
    final /* synthetic */ TrustedListenableFutureTask this$0;

    TrustedListenableFutureTask$TrustedFutureInterruptibleTask(TrustedListenableFutureTask trustedListenableFutureTask, Callable callable) {
        this.this$0 = trustedListenableFutureTask;
        this.callable = (Callable)Preconditions.checkNotNull(callable);
    }

    @Override
    void runInterruptibly() {
        if (this.this$0.isDone()) return;
        try {
            this.this$0.set(this.callable.call());
            return;
        }
        catch (Throwable var1_1) {
            this.this$0.setException(var1_1);
        }
    }

    @Override
    boolean wasInterrupted() {
        return this.this$0.wasInterrupted();
    }
}

