package com.google.common.util.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import com.google.common.base.*;

class AbstractScheduledService$1 extends AbstractService
{
    private volatile Future runningTask;
    private volatile ScheduledExecutorService executorService;
    private final ReentrantLock lock;
    private final Runnable task;
    final /* synthetic */ AbstractScheduledService this$0;
    
    AbstractScheduledService$1(final AbstractScheduledService this$0) {
        this.this$0 = this$0;
        this.lock = new ReentrantLock();
        this.task = new AbstractScheduledService$1$Task(this);
    }
    
    @Override
    protected final void doStart() {
        (this.executorService = MoreExecutors.renamingDecorator(this.this$0.executor(), new AbstractScheduledService$1$1(this))).execute(new AbstractScheduledService$1$2(this));
    }
    
    @Override
    protected final void doStop() {
        this.runningTask.cancel(false);
        this.executorService.execute(new AbstractScheduledService$1$3(this));
    }
}
