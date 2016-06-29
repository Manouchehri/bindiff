package com.google.common.util.concurrent;

import com.google.common.base.*;
import java.util.concurrent.*;

public abstract class AbstractScheduledService$Scheduler
{
    public static AbstractScheduledService$Scheduler newFixedDelaySchedule(final long n, final long n2, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        Preconditions.checkArgument(n2 > 0L, "delay must be > 0, found %s", n2);
        return new AbstractScheduledService$Scheduler$1(n, n2, timeUnit);
    }
    
    public static AbstractScheduledService$Scheduler newFixedRateSchedule(final long n, final long n2, final TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        Preconditions.checkArgument(n2 > 0L, "period must be > 0, found %s", n2);
        return new AbstractScheduledService$Scheduler$2(n, n2, timeUnit);
    }
    
    abstract Future schedule(final AbstractService p0, final ScheduledExecutorService p1, final Runnable p2);
}
