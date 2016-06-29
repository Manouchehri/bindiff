package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import javax.annotation.concurrent.*;
import java.util.*;
import java.util.concurrent.*;

@GwtIncompatible("TODO")
class MoreExecutors$DirectExecutorService extends AbstractListeningExecutorService
{
    private final Object lock;
    @GuardedBy("lock")
    private int runningTasks;
    @GuardedBy("lock")
    private boolean shutdown;
    
    private MoreExecutors$DirectExecutorService() {
        this.lock = new Object();
        this.runningTasks = 0;
        this.shutdown = false;
    }
    
    @Override
    public void execute(final Runnable runnable) {
        this.startTask();
        try {
            runnable.run();
        }
        finally {
            this.endTask();
        }
    }
    
    @Override
    public boolean isShutdown() {
        synchronized (this.lock) {
            return this.shutdown;
        }
    }
    
    @Override
    public void shutdown() {
        synchronized (this.lock) {
            this.shutdown = true;
            if (this.runningTasks == 0) {
                this.lock.notifyAll();
            }
        }
    }
    
    @Override
    public List shutdownNow() {
        this.shutdown();
        return Collections.emptyList();
    }
    
    @Override
    public boolean isTerminated() {
        synchronized (this.lock) {
            return this.shutdown && this.runningTasks == 0;
        }
    }
    
    @Override
    public boolean awaitTermination(final long n, final TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(n);
        synchronized (this.lock) {
            while (!this.shutdown || this.runningTasks != 0) {
                if (nanos <= 0L) {
                    return false;
                }
                final long nanoTime = System.nanoTime();
                TimeUnit.NANOSECONDS.timedWait(this.lock, nanos);
                nanos -= System.nanoTime() - nanoTime;
            }
            return true;
        }
    }
    
    private void startTask() {
        synchronized (this.lock) {
            if (this.shutdown) {
                throw new RejectedExecutionException("Executor already shutdown");
            }
            ++this.runningTasks;
        }
    }
    
    private void endTask() {
        synchronized (this.lock) {
            final int runningTasks = this.runningTasks - 1;
            this.runningTasks = runningTasks;
            if (runningTasks == 0) {
                this.lock.notifyAll();
            }
        }
    }
}
