/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.ListenerCallQueue$Callback;
import java.util.Queue;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

final class ListenerCallQueue
implements Runnable {
    private static final Logger logger = Logger.getLogger(ListenerCallQueue.class.getName());
    private final Object listener;
    private final Executor executor;
    @GuardedBy(value="this")
    private final Queue waitQueue = Queues.newArrayDeque();
    @GuardedBy(value="this")
    private boolean isThreadScheduled;

    ListenerCallQueue(Object object, Executor executor) {
        this.listener = Preconditions.checkNotNull(object);
        this.executor = (Executor)Preconditions.checkNotNull(executor);
    }

    synchronized void add(ListenerCallQueue$Callback listenerCallQueue$Callback) {
        this.waitQueue.add(listenerCallQueue$Callback);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void execute() {
        boolean bl2 = false;
        ListenerCallQueue listenerCallQueue = this;
        synchronized (listenerCallQueue) {
            if (!this.isThreadScheduled) {
                this.isThreadScheduled = true;
                bl2 = true;
            }
        }
        if (!bl2) return;
        try {
            this.executor.execute(this);
            return;
        }
        catch (RuntimeException var2_3) {
            Object object = this;
            synchronized (object) {
                this.isThreadScheduled = false;
            }
            object = String.valueOf(this.listener);
            String string = String.valueOf(this.executor);
            logger.log(Level.SEVERE, new StringBuilder(42 + String.valueOf(object).length() + String.valueOf(string).length()).append("Exception while running callbacks for ").append((String)object).append(" on ").append(string).toString(), var2_3);
            throw var2_3;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    @Override
    public void run() {
        var1_1 = true;
        do lbl-1000: // 3 sources:
        {
            var3_3 = this;
            // MONITORENTER : var3_3
            Preconditions.checkState(this.isThreadScheduled);
            var2_2 = (ListenerCallQueue$Callback)this.waitQueue.poll();
            if (var2_2 == null) {
                this.isThreadScheduled = false;
                var1_1 = false;
                // MONITOREXIT : var3_3
                return;
            }
            // MONITOREXIT : var3_3
            try {
                var2_2.call(this.listener);
            }
            catch (RuntimeException var3_4) {
                var4_5 = String.valueOf(this.listener);
                var5_6 = ListenerCallQueue$Callback.access$000((ListenerCallQueue$Callback)var2_2);
                ListenerCallQueue.logger.log(Level.SEVERE, new StringBuilder(37 + String.valueOf(var4_5).length() + String.valueOf(var5_6).length()).append("Exception while executing callback: ").append(var4_5).append(".").append(var5_6).toString(), var3_4);
                continue;
            }
            break;
        } while (true);
        ** GOTO lbl-1000
        finally {
            if (var1_1) {
                var2_2 = this;
                // MONITORENTER : var2_2
                this.isThreadScheduled = false;
                // MONITOREXIT : var2_2
            }
        }
    }
}

