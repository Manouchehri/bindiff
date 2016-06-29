/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.AbstractIdleService$2;

class AbstractIdleService$2$1
implements Runnable {
    final /* synthetic */ AbstractIdleService$2 this$1;

    AbstractIdleService$2$1(AbstractIdleService$2 var1_1) {
        this.this$1 = var1_1;
    }

    @Override
    public void run() {
        try {
            this.this$1.this$0.startUp();
            this.this$1.notifyStarted();
            return;
        }
        catch (Throwable var1_1) {
            this.this$1.notifyFailed(var1_1);
        }
    }
}

