/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import java.util.concurrent.Executor;
import javax.annotation.Nullable;

final class AbstractFuture$Listener {
    static final AbstractFuture$Listener TOMBSTONE = new AbstractFuture$Listener(null, null);
    final Runnable task;
    final Executor executor;
    @Nullable
    AbstractFuture$Listener next;

    AbstractFuture$Listener(Runnable runnable, Executor executor) {
        this.task = runnable;
        this.executor = executor;
    }
}

