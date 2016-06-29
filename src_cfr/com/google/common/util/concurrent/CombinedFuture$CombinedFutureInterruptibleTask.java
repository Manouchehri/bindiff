/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.InterruptibleTask;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

abstract class CombinedFuture$CombinedFutureInterruptibleTask
extends InterruptibleTask {
    private final Executor listenerExecutor;
    volatile boolean thrownByExecute;
    final /* synthetic */ CombinedFuture this$0;

    public CombinedFuture$CombinedFutureInterruptibleTask(CombinedFuture combinedFuture, Executor executor) {
        this.this$0 = combinedFuture;
        this.thrownByExecute = true;
        this.listenerExecutor = (Executor)Preconditions.checkNotNull(executor);
    }

    @Override
    final void runInterruptibly() {
        this.thrownByExecute = false;
        if (this.this$0.isDone()) return;
        try {
            this.setValue();
            return;
        }
        catch (ExecutionException var1_1) {
            this.this$0.setException(var1_1.getCause());
            return;
        }
        catch (CancellationException var1_2) {
            this.this$0.cancel(false);
            return;
        }
        catch (Throwable var1_3) {
            this.this$0.setException(var1_3);
        }
    }

    @Override
    final boolean wasInterrupted() {
        return this.this$0.wasInterrupted();
    }

    final void execute() {
        try {
            this.listenerExecutor.execute(this);
            return;
        }
        catch (RejectedExecutionException var1_1) {
            if (!this.thrownByExecute) return;
            this.this$0.setException(var1_1);
        }
    }

    abstract void setValue();
}

