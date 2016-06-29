/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.WrappingExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public abstract class WrappingScheduledExecutorService
extends WrappingExecutorService
implements ScheduledExecutorService {
    final ScheduledExecutorService delegate;

    protected WrappingScheduledExecutorService(ScheduledExecutorService scheduledExecutorService) {
        super(scheduledExecutorService);
        this.delegate = scheduledExecutorService;
    }

    public final ScheduledFuture schedule(Runnable runnable, long l2, TimeUnit timeUnit) {
        return this.delegate.schedule(this.wrapTask(runnable), l2, timeUnit);
    }

    public final ScheduledFuture schedule(Callable callable, long l2, TimeUnit timeUnit) {
        return this.delegate.schedule(this.wrapTask(callable), l2, timeUnit);
    }

    public final ScheduledFuture scheduleAtFixedRate(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        return this.delegate.scheduleAtFixedRate(this.wrapTask(runnable), l2, l3, timeUnit);
    }

    public final ScheduledFuture scheduleWithFixedDelay(Runnable runnable, long l2, long l3, TimeUnit timeUnit) {
        return this.delegate.scheduleWithFixedDelay(this.wrapTask(runnable), l2, l3, timeUnit);
    }
}

