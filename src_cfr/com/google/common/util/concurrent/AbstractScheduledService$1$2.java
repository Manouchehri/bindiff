/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler;
import com.google.common.util.concurrent.AbstractService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

class AbstractScheduledService$1$2
implements Runnable {
    final /* synthetic */ AbstractScheduledService$1 this$1;

    AbstractScheduledService$1$2(AbstractScheduledService$1 abstractScheduledService$1) {
        this.this$1 = abstractScheduledService$1;
    }

    @Override
    public void run() {
        AbstractScheduledService$1.access$100(this.this$1).lock();
        try {
            this.this$1.this$0.startUp();
            AbstractScheduledService$1.access$202(this.this$1, this.this$1.this$0.scheduler().schedule(AbstractScheduledService.access$400(this.this$1.this$0), AbstractScheduledService$1.access$500(this.this$1), AbstractScheduledService$1.access$600(this.this$1)));
            this.this$1.notifyStarted();
            return;
        }
        catch (Throwable var1_1) {
            this.this$1.notifyFailed(var1_1);
            if (AbstractScheduledService$1.access$200(this.this$1) == null) return;
            AbstractScheduledService$1.access$200(this.this$1).cancel(false);
            return;
        }
        finally {
            AbstractScheduledService$1.access$100(this.this$1).unlock();
        }
    }
}

