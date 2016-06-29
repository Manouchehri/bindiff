/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.util.concurrent.WrappingExecutorService$1;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class WrappingExecutorService
implements ExecutorService {
    private final ExecutorService delegate;

    protected WrappingExecutorService(ExecutorService executorService) {
        this.delegate = (ExecutorService)Preconditions.checkNotNull(executorService);
    }

    protected abstract Callable wrapTask(Callable var1);

    protected Runnable wrapTask(Runnable runnable) {
        Callable callable = this.wrapTask(Executors.callable(runnable, null));
        return new WrappingExecutorService$1(this, callable);
    }

    private final ImmutableList wrapTasks(Collection collection) {
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        Iterator<E> iterator = collection.iterator();
        while (iterator.hasNext()) {
            Callable callable = (Callable)iterator.next();
            immutableList$Builder.add((Object)this.wrapTask(callable));
        }
        return immutableList$Builder.build();
    }

    @Override
    public final void execute(Runnable runnable) {
        this.delegate.execute(this.wrapTask(runnable));
    }

    public final Future submit(Callable callable) {
        return this.delegate.submit(this.wrapTask((Callable)Preconditions.checkNotNull(callable)));
    }

    public final Future submit(Runnable runnable) {
        return this.delegate.submit(this.wrapTask(runnable));
    }

    public final Future submit(Runnable runnable, Object object) {
        return this.delegate.submit(this.wrapTask(runnable), object);
    }

    public final List invokeAll(Collection collection) {
        return this.delegate.invokeAll(this.wrapTasks(collection));
    }

    public final List invokeAll(Collection collection, long l2, TimeUnit timeUnit) {
        return this.delegate.invokeAll(this.wrapTasks(collection), l2, timeUnit);
    }

    public final Object invokeAny(Collection collection) {
        return this.delegate.invokeAny(this.wrapTasks(collection));
    }

    public final Object invokeAny(Collection collection, long l2, TimeUnit timeUnit) {
        return this.delegate.invokeAny(this.wrapTasks(collection), l2, timeUnit);
    }

    @Override
    public final void shutdown() {
        this.delegate.shutdown();
    }

    public final List shutdownNow() {
        return this.delegate.shutdownNow();
    }

    @Override
    public final boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    @Override
    public final boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    @Override
    public final boolean awaitTermination(long l2, TimeUnit timeUnit) {
        return this.delegate.awaitTermination(l2, timeUnit);
    }
}

