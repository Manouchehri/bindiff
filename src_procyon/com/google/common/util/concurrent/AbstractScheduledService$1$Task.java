package com.google.common.util.concurrent;

import java.util.concurrent.locks.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.logging.*;
import java.util.concurrent.*;

class AbstractScheduledService$1$Task implements Runnable
{
    final /* synthetic */ AbstractScheduledService$1 this$1;
    
    AbstractScheduledService$1$Task(final AbstractScheduledService$1 this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public void run() {
        this.this$1.lock.lock();
        try {
            if (this.this$1.runningTask.isCancelled()) {
                return;
            }
            this.this$1.this$0.runOneIteration();
        }
        catch (Throwable t) {
            try {
                this.this$1.this$0.shutDown();
            }
            catch (Exception ex) {
                AbstractScheduledService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", ex);
            }
            this.this$1.notifyFailed(t);
            this.this$1.runningTask.cancel(false);
        }
        finally {
            this.this$1.lock.unlock();
        }
    }
}
