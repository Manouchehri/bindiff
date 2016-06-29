/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import com.google.common.util.concurrent.WrappingExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

final class MoreExecutors$3
extends WrappingExecutorService {
    final /* synthetic */ Supplier val$nameSupplier;

    MoreExecutors$3(ExecutorService executorService, Supplier supplier) {
        this.val$nameSupplier = supplier;
        super(executorService);
    }

    @Override
    protected Callable wrapTask(Callable callable) {
        return Callables.threadRenaming(callable, this.val$nameSupplier);
    }

    @Override
    protected Runnable wrapTask(Runnable runnable) {
        return Callables.threadRenaming(runnable, this.val$nameSupplier);
    }
}

