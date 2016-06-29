/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ForwardingObject;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class ForwardingExecutorService
extends ForwardingObject
implements ExecutorService {
    protected ForwardingExecutorService() {
    }

    @Override
    protected abstract ExecutorService delegate();

    @Override
    public boolean awaitTermination(long l2, TimeUnit timeUnit) {
        return this.delegate().awaitTermination(l2, timeUnit);
    }

    public List invokeAll(Collection collection) {
        return this.delegate().invokeAll(collection);
    }

    public List invokeAll(Collection collection, long l2, TimeUnit timeUnit) {
        return this.delegate().invokeAll(collection, l2, timeUnit);
    }

    public Object invokeAny(Collection collection) {
        return this.delegate().invokeAny(collection);
    }

    public Object invokeAny(Collection collection, long l2, TimeUnit timeUnit) {
        return this.delegate().invokeAny(collection, l2, timeUnit);
    }

    @Override
    public boolean isShutdown() {
        return this.delegate().isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return this.delegate().isTerminated();
    }

    @Override
    public void shutdown() {
        this.delegate().shutdown();
    }

    public List shutdownNow() {
        return this.delegate().shutdownNow();
    }

    @Override
    public void execute(Runnable runnable) {
        this.delegate().execute(runnable);
    }

    public Future submit(Callable callable) {
        return this.delegate().submit(callable);
    }

    public Future submit(Runnable runnable) {
        return this.delegate().submit(runnable);
    }

    public Future submit(Runnable runnable, Object object) {
        return this.delegate().submit(runnable, object);
    }
}

