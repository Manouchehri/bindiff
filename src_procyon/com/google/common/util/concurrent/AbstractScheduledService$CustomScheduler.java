package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;

@Beta
public abstract class AbstractScheduledService$CustomScheduler extends AbstractScheduledService$Scheduler
{
    public AbstractScheduledService$CustomScheduler() {
        super(null);
    }
    
    @Override
    final Future schedule(final AbstractService abstractService, final ScheduledExecutorService scheduledExecutorService, final Runnable runnable) {
        final AbstractScheduledService$CustomScheduler$ReschedulableCallable abstractScheduledService$CustomScheduler$ReschedulableCallable = new AbstractScheduledService$CustomScheduler$ReschedulableCallable(this, abstractService, scheduledExecutorService, runnable);
        abstractScheduledService$CustomScheduler$ReschedulableCallable.reschedule();
        return abstractScheduledService$CustomScheduler$ReschedulableCallable;
    }
    
    protected abstract AbstractScheduledService$CustomScheduler$Schedule getNextSchedule();
}
