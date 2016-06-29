/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler;
import com.google.common.util.concurrent.AbstractScheduledService$CustomScheduler$Schedule;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.ForwardingFuture;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.concurrent.GuardedBy;

class AbstractScheduledService$CustomScheduler$ReschedulableCallable
extends ForwardingFuture
implements Callable {
    private final Runnable wrappedRunnable;
    private final ScheduledExecutorService executor;
    private final AbstractService service;
    private final ReentrantLock lock;
    @GuardedBy(value="lock")
    private Future currentFuture;
    final /* synthetic */ AbstractScheduledService$CustomScheduler this$0;

    AbstractScheduledService$CustomScheduler$ReschedulableCallable(AbstractScheduledService$CustomScheduler customScheduler, AbstractService abstractService, ScheduledExecutorService scheduledExecutorService, Runnable runnable) {
        this.this$0 = customScheduler;
        this.lock = new ReentrantLock();
        this.wrappedRunnable = runnable;
        this.executor = scheduledExecutorService;
        this.service = abstractService;
    }

    public Void call() {
        this.wrappedRunnable.run();
        this.reschedule();
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reschedule() {
        Throwable throwable;
        AbstractScheduledService$CustomScheduler$Schedule abstractScheduledService$CustomScheduler$Schedule;
        try {
            abstractScheduledService$CustomScheduler$Schedule = this.this$0.getNextSchedule();
        }
        catch (Throwable var2_2) {
            this.service.notifyFailed(var2_2);
            return;
        }
        throwable = null;
        this.lock.lock();
        try {
            if (this.currentFuture == null || !this.currentFuture.isCancelled()) {
                this.currentFuture = this.executor.schedule(this, AbstractScheduledService$CustomScheduler$Schedule.access$700(abstractScheduledService$CustomScheduler$Schedule), AbstractScheduledService$CustomScheduler$Schedule.access$800(abstractScheduledService$CustomScheduler$Schedule));
            }
        }
        catch (Throwable var3_4) {
            throwable = var3_4;
        }
        finally {
            this.lock.unlock();
        }
        if (throwable == null) return;
        this.service.notifyFailed(throwable);
    }

    @Override
    public boolean cancel(boolean bl2) {
        this.lock.lock();
        try {
            boolean bl3 = this.currentFuture.cancel(bl2);
            return bl3;
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override
    public boolean isCancelled() {
        this.lock.lock();
        try {
            boolean bl2 = this.currentFuture.isCancelled();
            return bl2;
        }
        finally {
            this.lock.unlock();
        }
    }

    @Override
    protected Future delegate() {
        throw new UnsupportedOperationException("Only cancel and isCancelled is supported by this future");
    }
}

