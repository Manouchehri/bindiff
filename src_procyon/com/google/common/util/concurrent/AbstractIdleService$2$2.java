package com.google.common.util.concurrent;

class AbstractIdleService$2$2 implements Runnable
{
    final /* synthetic */ AbstractIdleService$2 this$1;
    
    AbstractIdleService$2$2(final AbstractIdleService$2 this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public void run() {
        try {
            this.this$1.this$0.shutDown();
            this.this$1.notifyStopped();
        }
        catch (Throwable t) {
            this.this$1.notifyFailed(t);
        }
    }
}
