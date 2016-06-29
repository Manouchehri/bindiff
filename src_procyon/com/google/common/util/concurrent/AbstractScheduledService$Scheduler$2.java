package com.google.common.util.concurrent;

import java.util.concurrent.*;

final class AbstractScheduledService$Scheduler$2 extends AbstractScheduledService$Scheduler
{
    final /* synthetic */ long val$initialDelay;
    final /* synthetic */ long val$period;
    final /* synthetic */ TimeUnit val$unit;
    
    AbstractScheduledService$Scheduler$2(final long val$initialDelay, final long val$period, final TimeUnit val$unit) {
        this.val$initialDelay = val$initialDelay;
        this.val$period = val$period;
        this.val$unit = val$unit;
        super(null);
    }
    
    public Future schedule(final AbstractService abstractService, final ScheduledExecutorService scheduledExecutorService, final Runnable runnable) {
        return scheduledExecutorService.scheduleAtFixedRate(runnable, this.val$initialDelay, this.val$period, this.val$unit);
    }
}
