/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractScheduledService$1;
import java.util.logging.Level;

class AbstractScheduledService$1$Task
implements Runnable {
    final /* synthetic */ AbstractScheduledService$1 this$1;

    AbstractScheduledService$1$Task(AbstractScheduledService$1 abstractScheduledService$1) {
        this.this$1 = abstractScheduledService$1;
    }

    @Override
    public void run() {
        AbstractScheduledService$1.access$100(this.this$1).lock();
        try {
            if (AbstractScheduledService$1.access$200(this.this$1).isCancelled()) {
                return;
            }
            this.this$1.this$0.runOneIteration();
            return;
        }
        catch (Throwable var1_1) {
            try {
                this.this$1.this$0.shutDown();
            }
            catch (Exception var2_2) {
                AbstractScheduledService.access$300().log(Level.WARNING, "Error while attempting to shut down the service after failure.", var2_2);
            }
            this.this$1.notifyFailed(var1_1);
            AbstractScheduledService$1.access$200(this.this$1).cancel(false);
            return;
        }
        finally {
            AbstractScheduledService$1.access$100(this.this$1).unlock();
        }
    }
}

