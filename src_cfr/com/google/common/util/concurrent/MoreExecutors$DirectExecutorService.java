/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.AbstractListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors$1;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import javax.annotation.concurrent.GuardedBy;

@GwtIncompatible(value="TODO")
class MoreExecutors$DirectExecutorService
extends AbstractListeningExecutorService {
    private final Object lock = new Object();
    @GuardedBy(value="lock")
    private int runningTasks = 0;
    @GuardedBy(value="lock")
    private boolean shutdown = false;

    private MoreExecutors$DirectExecutorService() {
    }

    @Override
    public void execute(Runnable runnable) {
        this.startTask();
        try {
            runnable.run();
            return;
        }
        finally {
            this.endTask();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isShutdown() {
        Object object = this.lock;
        synchronized (object) {
            return this.shutdown;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void shutdown() {
        Object object = this.lock;
        synchronized (object) {
            this.shutdown = true;
            if (this.runningTasks != 0) return;
            this.lock.notifyAll();
            return;
        }
    }

    public List shutdownNow() {
        this.shutdown();
        return Collections.emptyList();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean isTerminated() {
        Object object = this.lock;
        synchronized (object) {
            if (!this.shutdown) return false;
            if (this.runningTasks != 0) return false;
            return true;
        }
    }

    @Override
    public boolean awaitTermination(long l2, TimeUnit timeUnit) {
        long l3 = timeUnit.toNanos(l2);
        Object object = this.lock;
        synchronized (object) {
            do {
                if (this.shutdown && this.runningTasks == 0) {
                    return true;
                }
                if (l3 <= 0) {
                    return false;
                }
                long l4 = System.nanoTime();
                TimeUnit.NANOSECONDS.timedWait(this.lock, l3);
                l3 -= System.nanoTime() - l4;
            } while (true);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void startTask() {
        Object object = this.lock;
        synchronized (object) {
            if (this.shutdown) {
                throw new RejectedExecutionException("Executor already shutdown");
            }
            ++this.runningTasks;
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void endTask() {
        Object object = this.lock;
        synchronized (object) {
            int n2 = --this.runningTasks;
            if (n2 != 0) return;
            this.lock.notifyAll();
            return;
        }
    }

    /* synthetic */ MoreExecutors$DirectExecutorService(MoreExecutors$1 moreExecutors$1) {
        this();
    }
}

