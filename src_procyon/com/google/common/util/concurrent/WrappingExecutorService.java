package com.google.common.util.concurrent;

import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;
import java.util.concurrent.*;

public abstract class WrappingExecutorService implements ExecutorService
{
    private final ExecutorService delegate;
    
    protected WrappingExecutorService(final ExecutorService executorService) {
        this.delegate = (ExecutorService)Preconditions.checkNotNull(executorService);
    }
    
    protected abstract Callable wrapTask(final Callable p0);
    
    protected Runnable wrapTask(final Runnable runnable) {
        return new WrappingExecutorService$1(this, this.wrapTask(Executors.callable(runnable, (Object)null)));
    }
    
    private final ImmutableList wrapTasks(final Collection collection) {
        final ImmutableList$Builder builder = ImmutableList.builder();
        final Iterator<Callable> iterator = collection.iterator();
        while (iterator.hasNext()) {
            builder.add(this.wrapTask(iterator.next()));
        }
        return builder.build();
    }
    
    @Override
    public final void execute(final Runnable runnable) {
        this.delegate.execute(this.wrapTask(runnable));
    }
    
    @Override
    public final Future submit(final Callable callable) {
        return this.delegate.submit((Callable<Object>)this.wrapTask((Callable)Preconditions.checkNotNull(callable)));
    }
    
    @Override
    public final Future submit(final Runnable runnable) {
        return this.delegate.submit(this.wrapTask(runnable));
    }
    
    @Override
    public final Future submit(final Runnable runnable, final Object o) {
        return this.delegate.submit(this.wrapTask(runnable), o);
    }
    
    @Override
    public final List invokeAll(final Collection collection) {
        return this.delegate.invokeAll((Collection<? extends Callable<Object>>)this.wrapTasks(collection));
    }
    
    @Override
    public final List invokeAll(final Collection collection, final long n, final TimeUnit timeUnit) {
        return this.delegate.invokeAll((Collection<? extends Callable<Object>>)this.wrapTasks(collection), n, timeUnit);
    }
    
    @Override
    public final Object invokeAny(final Collection collection) {
        return this.delegate.invokeAny((Collection<? extends Callable<Object>>)this.wrapTasks(collection));
    }
    
    @Override
    public final Object invokeAny(final Collection collection, final long n, final TimeUnit timeUnit) {
        return this.delegate.invokeAny((Collection<? extends Callable<Object>>)this.wrapTasks(collection), n, timeUnit);
    }
    
    @Override
    public final void shutdown() {
        this.delegate.shutdown();
    }
    
    @Override
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
    public final boolean awaitTermination(final long n, final TimeUnit timeUnit) {
        return this.delegate.awaitTermination(n, timeUnit);
    }
}
