/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler$1;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler$2;
import com.google.common.util.concurrent.AbstractService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public abstract class AbstractScheduledService$Scheduler {
    public static AbstractScheduledService$Scheduler newFixedDelaySchedule(long l2, long l3, TimeUnit timeUnit) {
        Preconditions.checkNotNull((Object)timeUnit);
        Preconditions.checkArgument(l3 > 0, "delay must be > 0, found %s", l3);
        return new AbstractScheduledService$Scheduler$1(l2, l3, timeUnit);
    }

    public static AbstractScheduledService$Scheduler newFixedRateSchedule(long l2, long l3, TimeUnit timeUnit) {
        Preconditions.checkNotNull((Object)timeUnit);
        Preconditions.checkArgument(l3 > 0, "period must be > 0, found %s", l3);
        return new AbstractScheduledService$Scheduler$2(l2, l3, timeUnit);
    }

    abstract Future schedule(AbstractService var1, ScheduledExecutorService var2, Runnable var3);

    private AbstractScheduledService$Scheduler() {
    }

    /* synthetic */ AbstractScheduledService$Scheduler(AbstractScheduledService$1 abstractScheduledService$1) {
        this();
    }
}

