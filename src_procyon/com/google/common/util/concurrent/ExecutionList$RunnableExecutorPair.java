package com.google.common.util.concurrent;

import java.util.concurrent.*;
import javax.annotation.*;

final class ExecutionList$RunnableExecutorPair
{
    final Runnable runnable;
    final Executor executor;
    @Nullable
    ExecutionList$RunnableExecutorPair next;
    
    ExecutionList$RunnableExecutorPair(final Runnable runnable, final Executor executor, final ExecutionList$RunnableExecutorPair next) {
        this.runnable = runnable;
        this.executor = executor;
        this.next = next;
    }
}
