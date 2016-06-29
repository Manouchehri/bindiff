package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.*;

final class MoreExecutors$3 extends WrappingExecutorService
{
    final /* synthetic */ Supplier val$nameSupplier;
    
    MoreExecutors$3(final ExecutorService executorService, final Supplier val$nameSupplier) {
        this.val$nameSupplier = val$nameSupplier;
        super(executorService);
    }
    
    @Override
    protected Callable wrapTask(final Callable callable) {
        return Callables.threadRenaming(callable, this.val$nameSupplier);
    }
    
    @Override
    protected Runnable wrapTask(final Runnable runnable) {
        return Callables.threadRenaming(runnable, this.val$nameSupplier);
    }
}
