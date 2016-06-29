/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler;
import com.google.common.util.concurrent.AbstractService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class AbstractScheduledService$Scheduler$2
extends AbstractScheduledService$Scheduler {
    final /* synthetic */ long val$initialDelay;
    final /* synthetic */ long val$period;
    final /* synthetic */ TimeUnit val$unit;

    AbstractScheduledService$Scheduler$2(long l2, long l3, TimeUnit timeUnit) {
        this.val$initialDelay = l2;
        this.val$period = l3;
        this.val$unit = timeUnit;
        super(null);
    }

    @Override
    public Future schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
        return scheduledExecutorService.scheduleAtFixedRate(runnable, this.val$initialDelay, this.val$period, this.val$unit);
    }
}

