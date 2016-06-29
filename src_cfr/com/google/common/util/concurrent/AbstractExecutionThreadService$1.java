/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1$1;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1$2;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

class AbstractExecutionThreadService$1
extends AbstractService {
    final /* synthetic */ AbstractExecutionThreadService this$0;

    AbstractExecutionThreadService$1(AbstractExecutionThreadService abstractExecutionThreadService) {
        this.this$0 = abstractExecutionThreadService;
    }

    @Override
    protected final void doStart() {
        Executor executor = MoreExecutors.renamingDecorator(this.this$0.executor(), (Supplier)new AbstractExecutionThreadService$1$1(this));
        executor.execute(new AbstractExecutionThreadService$1$2(this));
    }

    @Override
    protected void doStop() {
        this.this$0.triggerShutdown();
    }
}

