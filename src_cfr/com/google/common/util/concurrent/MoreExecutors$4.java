/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import com.google.common.util.concurrent.WrappingScheduledExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledExecutorService;

final class MoreExecutors$4
extends WrappingScheduledExecutorService {
    final /* synthetic */ Supplier val$nameSupplier;

    MoreExecutors$4(ScheduledExecutorService scheduledExecutorService, Supplier supplier) {
        this.val$nameSupplier = supplier;
        super(scheduledExecutorService);
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

