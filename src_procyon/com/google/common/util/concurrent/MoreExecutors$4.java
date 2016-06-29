package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.*;

final class MoreExecutors$4 extends WrappingScheduledExecutorService
{
    final /* synthetic */ Supplier val$nameSupplier;
    
    MoreExecutors$4(final ScheduledExecutorService scheduledExecutorService, final Supplier val$nameSupplier) {
        this.val$nameSupplier = val$nameSupplier;
        super(scheduledExecutorService);
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
