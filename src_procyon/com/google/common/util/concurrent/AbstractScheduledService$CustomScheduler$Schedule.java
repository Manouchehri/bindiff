package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.base.*;

@Beta
public final class AbstractScheduledService$CustomScheduler$Schedule
{
    private final long delay;
    private final TimeUnit unit;
    
    public AbstractScheduledService$CustomScheduler$Schedule(final long delay, final TimeUnit timeUnit) {
        this.delay = delay;
        this.unit = (TimeUnit)Preconditions.checkNotNull(timeUnit);
    }
}
