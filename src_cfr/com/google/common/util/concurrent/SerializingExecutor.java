/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.SerializingExecutor$1;
import com.google.common.util.concurrent.SerializingExecutor$QueueWorker;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

public final class SerializingExecutor
implements Executor {
    private static final Logger log = Logger.getLogger(SerializingExecutor.class.getName());
    private final Executor executor;
    @GuardedBy(value="internalLock")
    private final Deque queue = new ArrayDeque();
    @GuardedBy(value="internalLock")
    private boolean isWorkerRunning = false;
    @GuardedBy(value="internalLock")
    private int suspensions = 0;
    private final Object internalLock = new Object();

    public SerializingExecutor(Executor executor) {
        this.executor = (Executor)Preconditions.checkNotNull(executor);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void execute(Runnable runnable) {
        Object object = this.internalLock;
        synchronized (object) {
            this.queue.add(runnable);
        }
        this.startQueueWorker();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void executeFirst(Runnable runnable) {
        Object object = this.internalLock;
        synchronized (object) {
            this.queue.addFirst(runnable);
        }
        this.startQueueWorker();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void suspend() {
        Object object = this.internalLock;
        synchronized (object) {
            ++this.suspensions;
            return;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void resume() {
        Object object = this.internalLock;
        synchronized (object) {
            Preconditions.checkState(this.suspensions > 0);
            --this.suspensions;
        }
        this.startQueueWorker();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void startQueueWorker() {
        Object object = this.internalLock;
        synchronized (object) {
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
        boolean bl2 = true;
        try {
            this.executor.execute(new SerializingExecutor$QueueWorker(this, null));
            bl2 = false;
            return;
        }
        finally {
            if (bl2) {
                Object object2 = this.internalLock;
                synchronized (object2) {
                    this.isWorkerRunning = false;
                }
            }
        }
    }

    static /* synthetic */ Object access$100(SerializingExecutor serializingExecutor) {
        return serializingExecutor.internalLock;
    }

    static /* synthetic */ boolean access$202(SerializingExecutor serializingExecutor, boolean bl2) {
        serializingExecutor.isWorkerRunning = bl2;
        return serializingExecutor.isWorkerRunning;
    }

    static /* synthetic */ int access$300(SerializingExecutor serializingExecutor) {
        return serializingExecutor.suspensions;
    }

    static /* synthetic */ Deque access$400(SerializingExecutor serializingExecutor) {
        return serializingExecutor.queue;
    }

    static /* synthetic */ Logger access$500() {
        return log;
    }
}

