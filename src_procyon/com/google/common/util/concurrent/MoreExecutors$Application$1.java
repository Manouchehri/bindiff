package com.google.common.util.concurrent;

import java.util.concurrent.*;

class MoreExecutors$Application$1 implements Runnable
{
    final /* synthetic */ ExecutorService val$service;
    final /* synthetic */ long val$terminationTimeout;
    final /* synthetic */ TimeUnit val$timeUnit;
    final /* synthetic */ MoreExecutors$Application this$0;
    
    MoreExecutors$Application$1(final MoreExecutors$Application this$0, final ExecutorService val$service, final long val$terminationTimeout, final TimeUnit val$timeUnit) {
        this.this$0 = this$0;
        this.val$service = val$service;
        this.val$terminationTimeout = val$terminationTimeout;
        this.val$timeUnit = val$timeUnit;
    }
    
    @Override
    public void run() {
        try {
            this.val$service.shutdown();
            this.val$service.awaitTermination(this.val$terminationTimeout, this.val$timeUnit);
        }
        catch (InterruptedException ex) {}
    }
}
