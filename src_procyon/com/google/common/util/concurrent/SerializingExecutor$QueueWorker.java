package com.google.common.util.concurrent;

import java.util.logging.*;
import java.util.concurrent.*;
import javax.annotation.concurrent.*;
import java.util.*;
import com.google.common.base.*;

class SerializingExecutor$QueueWorker implements Runnable
{
    final /* synthetic */ SerializingExecutor this$0;
    
    private SerializingExecutor$QueueWorker(final SerializingExecutor this$0) {
        this.this$0 = this$0;
    }
    
    @Override
    public void run() {
        try {
            this.workOnQueue();
        }
        catch (Error error) {
            synchronized (this.this$0.internalLock) {
                this.this$0.isWorkerRunning = false;
            }
            throw error;
        }
    }
    
    private void workOnQueue() {
        while (true) {
            Runnable runnable = null;
            synchronized (this.this$0.internalLock) {
                if (this.this$0.suspensions == 0) {
                    runnable = this.this$0.queue.poll();
                }
                if (runnable == null) {
                    this.this$0.isWorkerRunning = false;
                    return;
                }
            }
            try {
                runnable.run();
            }
            catch (RuntimeException ex) {
                final Logger access$500 = SerializingExecutor.log;
                final Level severe = Level.SEVERE;
                final String value = String.valueOf(runnable);
                access$500.log(severe, new StringBuilder(35 + String.valueOf(value).length()).append("Exception while executing runnable ").append(value).toString(), ex);
            }
        }
    }
}
