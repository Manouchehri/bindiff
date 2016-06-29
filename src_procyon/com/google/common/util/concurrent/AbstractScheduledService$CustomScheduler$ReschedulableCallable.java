package com.google.common.util.concurrent;

import java.util.concurrent.locks.*;
import javax.annotation.concurrent.*;
import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.base.*;

class AbstractScheduledService$CustomScheduler$ReschedulableCallable extends ForwardingFuture implements Callable
{
    private final Runnable wrappedRunnable;
    private final ScheduledExecutorService executor;
    private final AbstractService service;
    private final ReentrantLock lock;
    @GuardedBy("lock")
    private Future currentFuture;
    final /* synthetic */ AbstractScheduledService$CustomScheduler this$0;
    
    AbstractScheduledService$CustomScheduler$ReschedulableCallable(final AbstractScheduledService$CustomScheduler this$0, final AbstractService service, final ScheduledExecutorService executor, final Runnable wrappedRunnable) {
        this.this$0 = this$0;
        this.lock = new ReentrantLock();
        this.wrappedRunnable = wrappedRunnable;
        this.executor = executor;
        this.service = service;
    }
    
    @Override
    public Void call() {
        this.wrappedRunnable.run();
        this.reschedule();
        return null;
    }
    
    public void reschedule() {
        AbstractScheduledService$CustomScheduler$Schedule nextSchedule;
        try {
            nextSchedule = this.this$0.getNextSchedule();
        }
        catch (Throwable t) {
            this.service.notifyFailed(t);
            return;
        }
        Throwable t2 = null;
        this.lock.lock();
        try {
            if (this.currentFuture == null || !this.currentFuture.isCancelled()) {
                this.currentFuture = this.executor.schedule((Callable<Object>)this, nextSchedule.delay, nextSchedule.unit);
            }
        }
        catch (Throwable t3) {
            t2 = t3;
        }
        finally {
            this.lock.unlock();
        }
        if (t2 != null) {
            this.service.notifyFailed(t2);
        }
    }
    
    @Override
    public boolean cancel(final boolean b) {
        this.lock.lock();
        try {
            return this.currentFuture.cancel(b);
        }
        finally {
            this.lock.unlock();
        }
    }
    
    @Override
    public boolean isCancelled() {
        this.lock.lock();
        try {
            return this.currentFuture.isCancelled();
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
