/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.Service$State;

class AbstractScheduledService$1$3
implements Runnable {
    final /* synthetic */ AbstractScheduledService$1 this$1;

    AbstractScheduledService$1$3(AbstractScheduledService$1 abstractScheduledService$1) {
        this.this$1 = abstractScheduledService$1;
    }

    @Override
    public void run() {
        try {
            AbstractScheduledService$1.access$100(this.this$1).lock();
            try {
                if (this.this$1.state() != Service$State.STOPPING) {
                    return;
                }
                this.this$1.this$0.shutDown();
            }
            finally {
                AbstractScheduledService$1.access$100(this.this$1).unlock();
            }
            this.this$1.notifyStopped();
            return;
        }
        catch (Throwable var1_2) {
            this.this$1.notifyFailed(var1_2);
        }
    }
}

