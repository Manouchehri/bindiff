/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.MoreExecutors$Application;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

class MoreExecutors$Application$1
implements Runnable {
    final /* synthetic */ ExecutorService val$service;
    final /* synthetic */ long val$terminationTimeout;
    final /* synthetic */ TimeUnit val$timeUnit;
    final /* synthetic */ MoreExecutors.Application this$0;

    MoreExecutors$Application$1(MoreExecutors.Application application, ExecutorService executorService, long l2, TimeUnit timeUnit) {
        this.this$0 = application;
        this.val$service = executorService;
        this.val$terminationTimeout = l2;
        this.val$timeUnit = timeUnit;
    }

    @Override
    public void run() {
        try {
            this.val$service.shutdown();
            this.val$service.awaitTermination(this.val$terminationTimeout, this.val$timeUnit);
            return;
        }
        catch (InterruptedException var1_1) {
            // empty catch block
        }
    }
}

