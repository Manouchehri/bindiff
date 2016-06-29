/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1;
import java.util.logging.Level;

class AbstractExecutionThreadService$1$2
implements Runnable {
    final /* synthetic */ AbstractExecutionThreadService$1 this$1;

    AbstractExecutionThreadService$1$2(AbstractExecutionThreadService$1 abstractExecutionThreadService$1) {
        this.this$1 = abstractExecutionThreadService$1;
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
                catch (Throwable var1_1) {
                    try {
                        this.this$1.this$0.shutDown();
                    }
                    catch (Exception var2_3) {
                        AbstractExecutionThreadService.access$000().log(Level.WARNING, "Error while attempting to shut down the service after failure.", var2_3);
                    }
                    this.this$1.notifyFailed(var1_1);
                    return;
                }
            }
            this.this$1.this$0.shutDown();
            this.this$1.notifyStopped();
            return;
        }
        catch (Throwable var1_2) {
            this.this$1.notifyFailed(var1_2);
        }
    }
}

