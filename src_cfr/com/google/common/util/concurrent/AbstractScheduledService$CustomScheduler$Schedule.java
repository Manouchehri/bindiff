/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.util.concurrent.TimeUnit;

@Beta
public final class AbstractScheduledService$CustomScheduler$Schedule {
    private final long delay;
    private final TimeUnit unit;

    public AbstractScheduledService$CustomScheduler$Schedule(long l2, TimeUnit timeUnit) {
        this.delay = l2;
        this.unit = (TimeUnit)((Object)Preconditions.checkNotNull((Object)timeUnit));
    }

    static /* synthetic */ long access$700(AbstractScheduledService$CustomScheduler$Schedule abstractScheduledService$CustomScheduler$Schedule) {
        return abstractScheduledService$CustomScheduler$Schedule.delay;
    }

    static /* synthetic */ TimeUnit access$800(AbstractScheduledService$CustomScheduler$Schedule abstractScheduledService$CustomScheduler$Schedule) {
        return abstractScheduledService$CustomScheduler$Schedule.unit;
    }
}

