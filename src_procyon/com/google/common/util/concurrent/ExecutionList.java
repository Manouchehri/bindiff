package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import javax.annotation.concurrent.*;
import java.util.concurrent.*;
import com.google.common.base.*;
import java.util.logging.*;

public final class ExecutionList
{
    @VisibleForTesting
    static final Logger log;
    @GuardedBy("this")
    private ExecutionList$RunnableExecutorPair runnables;
    @GuardedBy("this")
    private boolean executed;
    
    public void add(final Runnable runnable, final Executor executor) {
        Preconditions.checkNotNull(runnable, (Object)"Runnable was null.");
        Preconditions.checkNotNull(executor, (Object)"Executor was null.");
        synchronized (this) {
            if (!this.executed) {
                this.runnables = new ExecutionList$RunnableExecutorPair(runnable, executor, this.runnables);
                return;
            }
        }
        executeListener(runnable, executor);
    }
    
    public void execute() {
        ExecutionList$RunnableExecutorPair executionList$RunnableExecutorPair;
        synchronized (this) {
            if (this.executed) {
                return;
            }
            this.executed = true;
            executionList$RunnableExecutorPair = this.runnables;
            this.runnables = null;
        }
        ExecutionList$RunnableExecutorPair next;
        ExecutionList$RunnableExecutorPair executionList$RunnableExecutorPair2;
        for (next = null; executionList$RunnableExecutorPair != null; executionList$RunnableExecutorPair = executionList$RunnableExecutorPair.next, executionList$RunnableExecutorPair2.next = next, next = executionList$RunnableExecutorPair2) {
            executionList$RunnableExecutorPair2 = executionList$RunnableExecutorPair;
        }
        while (next != null) {
            executeListener(next.runnable, next.executor);
            next = next.next;
        }
    }
    
    private static void executeListener(final Runnable runnable, final Executor executor) {
        try {
            executor.execute(runnable);
        }
        catch (RuntimeException ex) {
            final Logger log = ExecutionList.log;
            final Level severe = Level.SEVERE;
            final String value = String.valueOf(runnable);
            final String value2 = String.valueOf(executor);
            log.log(severe, new StringBuilder(57 + String.valueOf(value).length() + String.valueOf(value2).length()).append("RuntimeException while executing runnable ").append(value).append(" with executor ").append(value2).toString(), ex);
        }
    }
    
    static {
        log = Logger.getLogger(ExecutionList.class.getName());
    }
}
