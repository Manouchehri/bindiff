/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.ScheduledExecutorService;

class AbstractScheduledService$3
extends Service$Listener {
    final /* synthetic */ ScheduledExecutorService val$executor;
    final /* synthetic */ AbstractScheduledService this$0;

    AbstractScheduledService$3(AbstractScheduledService abstractScheduledService, ScheduledExecutorService scheduledExecutorService) {
        this.this$0 = abstractScheduledService;
        this.val$executor = scheduledExecutorService;
    }

    @Override
    public void terminated(Service$State service$State) {
        this.val$executor.shutdown();
    }

    @Override
    public void failed(Service$State service$State, Throwable throwable) {
        this.val$executor.shutdown();
    }
}

