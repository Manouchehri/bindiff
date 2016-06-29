/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.AbstractIdleService$2;

class AbstractIdleService$2$2
implements Runnable {
    final /* synthetic */ AbstractIdleService$2 this$1;

    AbstractIdleService$2$2(AbstractIdleService$2 abstractIdleService$2) {
        this.this$1 = abstractIdleService$2;
    }

    @Override
    public void run() {
        try {
            this.this$1.this$0.shutDown();
            this.this$1.notifyStopped();
            return;
        }
        catch (Throwable var1_1) {
            this.this$1.notifyFailed(var1_1);
        }
    }
}

