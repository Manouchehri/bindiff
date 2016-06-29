package com.google.common.util.concurrent;

import java.util.concurrent.*;

final class AbstractScheduledService$Scheduler$1 extends AbstractScheduledService$Scheduler
{
    final /* synthetic */ long val$initialDelay;
    final /* synthetic */ long val$delay;
    final /* synthetic */ TimeUnit val$unit;
    
    AbstractScheduledService$Scheduler$1(final long val$initialDelay, final long val$delay, final TimeUnit val$unit) {
        this.val$initialDelay = val$initialDelay;
        this.val$delay = val$delay;
        this.val$unit = val$unit;
        super(null);
    }
    
    public Future schedule(final AbstractService abstractService, final ScheduledExecutorService scheduledExecutorService, final Runnable runnable) {
        return scheduledExecutorService.scheduleWithFixedDelay(runnable, this.val$initialDelay, this.val$delay, this.val$unit);
    }
}
