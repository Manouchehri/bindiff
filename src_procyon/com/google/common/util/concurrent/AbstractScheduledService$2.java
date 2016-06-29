package com.google.common.util.concurrent;

import java.util.concurrent.*;

class AbstractScheduledService$2 implements ThreadFactory
{
    final /* synthetic */ AbstractScheduledService this$0;
    
    AbstractScheduledService$2(final AbstractScheduledService this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public Thread newThread(final Runnable runnable) {
        return MoreExecutors.newThread(this.this$0.serviceName(), runnable);
    }
}
