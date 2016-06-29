package com.google.common.util.concurrent;

import java.util.concurrent.locks.*;
import com.google.common.base.*;
import com.google.common.annotations.*;
import java.util.logging.*;
import java.util.concurrent.*;

class AbstractScheduledService$1$2 implements Runnable
{
    final /* synthetic */ AbstractScheduledService$1 this$1;
    
    AbstractScheduledService$1$2(final AbstractScheduledService$1 this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public void run() {
        this.this$1.lock.lock();
        try {
            this.this$1.this$0.startUp();
            this.this$1.runningTask = this.this$1.this$0.scheduler().schedule(this.this$1.this$0.delegate, this.this$1.executorService, this.this$1.task);
            this.this$1.notifyStarted();
        }
        catch (Throwable t) {
            this.this$1.notifyFailed(t);
            if (this.this$1.runningTask != null) {
                this.this$1.runningTask.cancel(false);
            }
        }
        finally {
            this.this$1.lock.unlock();
        }
    }
}
