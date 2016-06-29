/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

class AbstractExecutionThreadService$2
implements Executor {
    final /* synthetic */ AbstractExecutionThreadService this$0;

    AbstractExecutionThreadService$2(AbstractExecutionThreadService abstractExecutionThreadService) {
        this.this$0 = abstractExecutionThreadService;
    }

    @Override
    public void execute(Runnable runnable) {
        MoreExecutors.newThread(this.this$0.serviceName(), runnable).start();
    }
}

