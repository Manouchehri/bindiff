/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ForwardingListenableFuture$SimpleForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableScheduledFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

final class MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask
extends ForwardingListenableFuture$SimpleForwardingListenableFuture
implements ListenableScheduledFuture {
    private final ScheduledFuture scheduledDelegate;

    public MoreExecutors$ScheduledListeningDecorator$ListenableScheduledTask(ListenableFuture listenableFuture, ScheduledFuture scheduledFuture) {
        super(listenableFuture);
        this.scheduledDelegate = scheduledFuture;
    }

    @Override
    public boolean cancel(boolean bl2) {
        boolean bl3 = super.cancel(bl2);
        if (!bl3) return bl3;
        this.scheduledDelegate.cancel(bl2);
        return bl3;
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        return this.scheduledDelegate.getDelay(timeUnit);
    }

    @Override
    public int compareTo(Delayed delayed) {
        return this.scheduledDelegate.compareTo(delayed);
    }
}

