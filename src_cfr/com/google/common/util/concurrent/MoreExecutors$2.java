/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Callables;
import java.util.concurrent.Executor;

final class MoreExecutors$2
implements Executor {
    final /* synthetic */ Executor val$executor;
    final /* synthetic */ Supplier val$nameSupplier;

    MoreExecutors$2(Executor executor, Supplier supplier) {
        this.val$executor = executor;
        this.val$nameSupplier = supplier;
    }

    @Override
    public void execute(Runnable runnable) {
        this.val$executor.execute(Callables.threadRenaming(runnable, this.val$nameSupplier));
    }
}

