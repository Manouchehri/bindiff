package com.google.common.util.concurrent;

import com.google.common.base.*;

class AbstractExecutionThreadService$1 extends AbstractService
{
    final /* synthetic */ AbstractExecutionThreadService this$0;
    
    AbstractExecutionThreadService$1(final AbstractExecutionThreadService this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    protected final void doStart() {
        MoreExecutors.renamingDecorator(this.this$0.executor(), new AbstractExecutionThreadService$1$1(this)).execute(new AbstractExecutionThreadService$1$2(this));
    }
    
    @Override
    protected void doStop() {
        this.this$0.triggerShutdown();
    }
}
