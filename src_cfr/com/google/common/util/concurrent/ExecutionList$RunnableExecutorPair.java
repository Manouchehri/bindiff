/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class ExecutionList$RunnableExecutorPair {
    final Runnable runnable;
    final Executor executor;
    @Nullable
    ExecutionList$RunnableExecutorPair next;

    ExecutionList$RunnableExecutorPair(Runnable runnable, Executor executor, ExecutionList$RunnableExecutorPair executionList$RunnableExecutorPair) {
        this.runnable = runnable;
        this.executor = executor;
        this.next = executionList$RunnableExecutorPair;
    }
}

