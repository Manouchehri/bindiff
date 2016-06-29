package com.google.common.util.concurrent;

import java.util.concurrent.*;
import javax.annotation.*;

final class AbstractFuture$Listener
{
    static final AbstractFuture$Listener TOMBSTONE;
    final Runnable task;
    final Executor executor;
    @Nullable
    AbstractFuture$Listener next;
    
    AbstractFuture$Listener(final Runnable task, final Executor executor) {
        this.task = task;
        this.executor = executor;
    }
    
    static {
        TOMBSTONE = new AbstractFuture$Listener(null, null);
    }
}
