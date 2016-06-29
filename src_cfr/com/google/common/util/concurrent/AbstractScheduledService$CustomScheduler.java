/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler$ReschedulableCallable;
import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler$Schedule;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler;
import com.google.common.util.concurrent.AbstractService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

@Beta
public abstract class AbstractScheduledService$CustomScheduler
extends AbstractScheduledService$Scheduler {
    public AbstractScheduledService$CustomScheduler() {
        super(null);
    }

    @Override
    final Future schedule(AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
        AbstractScheduledService$CustomScheduler$ReschedulableCallable abstractScheduledService$CustomScheduler$ReschedulableCallable = new AbstractScheduledService$CustomScheduler$ReschedulableCallable(this, abstractService, scheduledExecutorService, runnable);
        abstractScheduledService$CustomScheduler$ReschedulableCallable.reschedule();
        return abstractScheduledService$CustomScheduler$ReschedulableCallable;
    }

    protected abstract AbstractScheduledService$CustomScheduler$Schedule getNextSchedule();
}

