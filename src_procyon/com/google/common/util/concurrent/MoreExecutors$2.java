package com.google.common.util.concurrent;

import java.util.concurrent.*;
import com.google.common.base.*;

final class MoreExecutors$2 implements Executor
{
    final /* synthetic */ Executor val$executor;
    final /* synthetic */ Supplier val$nameSupplier;
    
    MoreExecutors$2(final Executor val$executor, final Supplier val$nameSupplier) {
        this.val$executor = val$executor;
        this.val$nameSupplier = val$nameSupplier;
    }
    
    @Override
    public void execute(final Runnable runnable) {
        this.val$executor.execute(Callables.threadRenaming(runnable, this.val$nameSupplier));
    }
}
