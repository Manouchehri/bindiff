package com.google.common.util.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.locks.*;
import com.google.common.base.*;

class AbstractScheduledService$1$3 implements Runnable
{
    final /* synthetic */ AbstractScheduledService$1 this$1;
    
    AbstractScheduledService$1$3(final AbstractScheduledService$1 this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public void run() {
        try {
            this.this$1.lock.lock();
            try {
                if (this.this$1.state() != Service$State.STOPPING) {
                    return;
                }
                this.this$1.this$0.shutDown();
            }
            finally {
                this.this$1.lock.unlock();
            }
            this.this$1.notifyStopped();
        }
        catch (Throwable t) {
            this.this$1.notifyFailed(t);
        }
    }
}
