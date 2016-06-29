/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractScheduledService$1$1;
import com.google.common.util.concurrent.AbstractScheduledService$1$2;
import com.google.common.util.concurrent.AbstractScheduledService$1$3;
import com.google.common.util.concurrent.AbstractScheduledService$1$Task;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;

class AbstractScheduledService$1
extends AbstractService {
    private volatile Future runningTask;
    private volatile ScheduledExecutorService executorService;
    private final ReentrantLock lock;
    private final Runnable task;
    final /* synthetic */ AbstractScheduledService this$0;

    AbstractScheduledService$1(AbstractScheduledService abstractScheduledService) {
        this.this$0 = abstractScheduledService;
        this.lock = new ReentrantLock();
        this.task = new AbstractScheduledService$1$Task(this);
    }

    @Override
    protected final void doStart() {
        this.executorService = MoreExecutors.renamingDecorator(this.this$0.executor(), (Supplier)new AbstractScheduledService$1$1(this));
        this.executorService.execute(new AbstractScheduledService$1$2(this));
    }

    @Override
    protected final void doStop() {
        this.runningTask.cancel(false);
        this.executorService.execute(new AbstractScheduledService$1$3(this));
    }

    static /* synthetic */ ReentrantLock access$100(AbstractScheduledService$1 abstractScheduledService$1) {
        return abstractScheduledService$1.lock;
    }

    static /* synthetic */ Future access$200(AbstractScheduledService$1 abstractScheduledService$1) {
        return abstractScheduledService$1.runningTask;
    }

    static /* synthetic */ Future access$202(AbstractScheduledService$1 abstractScheduledService$1, Future future) {
        abstractScheduledService$1.runningTask = future;
        return abstractScheduledService$1.runningTask;
    }

    static /* synthetic */ ScheduledExecutorService access$500(AbstractScheduledService$1 abstractScheduledService$1) {
        return abstractScheduledService$1.executorService;
    }

    static /* synthetic */ Runnable access$600(AbstractScheduledService$1 abstractScheduledService$1) {
        return abstractScheduledService$1.task;
    }
}

