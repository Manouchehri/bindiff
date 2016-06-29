/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.TrustedListenableFutureTask$TrustedFutureInterruptibleTask;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.RunnableFuture;
import javax.annotation.Nullable;

@GwtCompatible
class TrustedListenableFutureTask
extends AbstractFuture$TrustedFuture
implements RunnableFuture {
    private TrustedListenableFutureTask$TrustedFutureInterruptibleTask task;

    static TrustedListenableFutureTask create(Callable callable) {
        return new TrustedListenableFutureTask(callable);
    }

    static TrustedListenableFutureTask create(Runnable runnable, @Nullable Object object) {
        return new TrustedListenableFutureTask(Executors.callable(runnable, object));
    }

    TrustedListenableFutureTask(Callable callable) {
        this.task = new TrustedListenableFutureTask$TrustedFutureInterruptibleTask(this, callable);
    }

    @Override
    public void run() {
        TrustedListenableFutureTask$TrustedFutureInterruptibleTask trustedListenableFutureTask$TrustedFutureInterruptibleTask = this.task;
        if (trustedListenableFutureTask$TrustedFutureInterruptibleTask == null) return;
        trustedListenableFutureTask$TrustedFutureInterruptibleTask.run();
    }

    @Override
    final void done() {
        super.done();
        this.task = null;
    }

    @GwtIncompatible(value="Interruption not supported")
    @Override
    protected final void interruptTask() {
        TrustedListenableFutureTask$TrustedFutureInterruptibleTask trustedListenableFutureTask$TrustedFutureInterruptibleTask = this.task;
        if (trustedListenableFutureTask$TrustedFutureInterruptibleTask == null) return;
        trustedListenableFutureTask$TrustedFutureInterruptibleTask.interruptTask();
    }
}

