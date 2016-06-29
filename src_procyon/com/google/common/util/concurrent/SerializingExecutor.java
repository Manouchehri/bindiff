package com.google.common.util.concurrent;

import java.util.concurrent.*;
import java.util.logging.*;
import javax.annotation.concurrent.*;
import java.util.*;
import com.google.common.base.*;

public final class SerializingExecutor implements Executor
{
    private static final Logger log;
    private final Executor executor;
    @GuardedBy("internalLock")
    private final Deque queue;
    @GuardedBy("internalLock")
    private boolean isWorkerRunning;
    @GuardedBy("internalLock")
    private int suspensions;
    private final Object internalLock;
    
    public SerializingExecutor(final Executor executor) {
        this.queue = new ArrayDeque();
        this.isWorkerRunning = false;
        this.suspensions = 0;
        this.internalLock = new Object();
        this.executor = (Executor)Preconditions.checkNotNull(executor);
    }
    
    @Override
    public void execute(final Runnable runnable) {
        synchronized (this.internalLock) {
            this.queue.add(runnable);
        }
        this.startQueueWorker();
    }
    
    public void executeFirst(final Runnable runnable) {
        synchronized (this.internalLock) {
            this.queue.addFirst(runnable);
        }
        this.startQueueWorker();
    }
    
    public void suspend() {
        synchronized (this.internalLock) {
            ++this.suspensions;
        }
    }
    
    public void resume() {
        synchronized (this.internalLock) {
            Preconditions.checkState(this.suspensions > 0);
            --this.suspensions;
        }
        this.startQueueWorker();
    }
    
    private void startQueueWorker() {
        synchronized (this.internalLock) {
            if (this.queue.peek() == null) {
                return;
            }
            if (this.suspensions > 0) {
                return;
            }
            if (this.isWorkerRunning) {
                return;
            }
            this.isWorkerRunning = true;
        }
        boolean b = true;
        try {
            this.executor.execute(new SerializingExecutor$QueueWorker(this, null));
            b = false;
        }
        finally {
            if (b) {
                synchronized (this.internalLock) {
                    this.isWorkerRunning = false;
                }
            }
        }
    }
    
    static {
        log = Logger.getLogger(SerializingExecutor.class.getName());
    }
}
