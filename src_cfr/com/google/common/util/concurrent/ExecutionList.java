/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.concurrent.GuardedBy
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionList$RunnableExecutorPair;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.concurrent.GuardedBy;

public final class ExecutionList {
    @VisibleForTesting
    static final Logger log = Logger.getLogger(ExecutionList.class.getName());
    @GuardedBy(value="this")
    private ExecutionList$RunnableExecutorPair runnables;
    @GuardedBy(value="this")
    private boolean executed;

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void add(Runnable runnable, Executor executor) {
        Preconditions.checkNotNull(runnable, "Runnable was null.");
        Preconditions.checkNotNull(executor, "Executor was null.");
        ExecutionList executionList = this;
        synchronized (executionList) {
            if (!this.executed) {
                this.runnables = new ExecutionList$RunnableExecutorPair(runnable, executor, this.runnables);
                return;
            }
        }
        ExecutionList.executeListener(runnable, executor);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void execute() {
        ExecutionList$RunnableExecutorPair executionList$RunnableExecutorPair;
        Object object = this;
        synchronized (object) {
            if (this.executed) {
                return;
            }
            this.executed = true;
            executionList$RunnableExecutorPair = this.runnables;
            this.runnables = null;
        }
        object = null;
        while (executionList$RunnableExecutorPair != null) {
            ExecutionList$RunnableExecutorPair executionList$RunnableExecutorPair2 = executionList$RunnableExecutorPair;
            executionList$RunnableExecutorPair = executionList$RunnableExecutorPair.next;
            executionList$RunnableExecutorPair2.next = object;
            object = executionList$RunnableExecutorPair2;
        }
    }

    private static void executeListener(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
            return;
        }
        catch (RuntimeException var2_2) {
            String string = String.valueOf(runnable);
            String string2 = String.valueOf(executor);
            log.log(Level.SEVERE, new StringBuilder(57 + String.valueOf(string).length() + String.valueOf(string2).length()).append("RuntimeException while executing runnable ").append(string).append(" with executor ").append(string2).toString(), var2_2);
        }
    }
}

