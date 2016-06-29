package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.logging.*;
import java.util.concurrent.*;

class AbstractExecutionThreadService$1$2 implements Runnable
{
    final /* synthetic */ AbstractExecutionThreadService$1 this$1;
    
    AbstractExecutionThreadService$1$2(final AbstractExecutionThreadService$1 this$1) {
        this.this$1 = this$1;
    }
    
    @Override
    public void run() {
        try {
            this.this$1.this$0.startUp();
            this.this$1.notifyStarted();
            if (this.this$1.isRunning()) {
                try {
                    this.this$1.this$0.run();
                }
                catch (Throwable t) {
                    try {
                        this.this$1.this$0.shutDown();
                    }
                    catch (Exception ex) {
                        AbstractExecutionThreadService.logger.log(Level.WARNING, "Error while attempting to shut down the service after failure.", ex);
                    }
                    this.this$1.notifyFailed(t);
                    return;
                }
            }
            this.this$1.this$0.shutDown();
            this.this$1.notifyStopped();
        }
        catch (Throwable t2) {
            this.this$1.notifyFailed(t2);
        }
    }
}
