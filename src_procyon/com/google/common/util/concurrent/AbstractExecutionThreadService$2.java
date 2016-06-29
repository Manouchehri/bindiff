package com.google.common.util.concurrent;

import java.util.concurrent.*;

class AbstractExecutionThreadService$2 implements Executor
{
    final /* synthetic */ AbstractExecutionThreadService this$0;
    
    AbstractExecutionThreadService$2(final AbstractExecutionThreadService this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void execute(final Runnable runnable) {
        MoreExecutors.newThread(this.this$0.serviceName(), runnable).start();
    }
}
