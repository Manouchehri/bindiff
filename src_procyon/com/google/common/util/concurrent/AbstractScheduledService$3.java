package com.google.common.util.concurrent;

import java.util.concurrent.*;

class AbstractScheduledService$3 extends Service$Listener
{
    final /* synthetic */ ScheduledExecutorService val$executor;
    final /* synthetic */ AbstractScheduledService this$0;
    
    AbstractScheduledService$3(final AbstractScheduledService this$0, final ScheduledExecutorService val$executor) {
        this.this$0 = this$0;
        this.val$executor = val$executor;
    }
    
    @Override
    public void terminated(final Service$State service$State) {
        this.val$executor.shutdown();
    }
    
    @Override
    public void failed(final Service$State service$State, final Throwable t) {
        this.val$executor.shutdown();
    }
}
