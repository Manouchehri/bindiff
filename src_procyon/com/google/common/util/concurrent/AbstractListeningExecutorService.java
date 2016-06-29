package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import javax.annotation.*;
import java.util.concurrent.*;

@Beta
public abstract class AbstractListeningExecutorService extends AbstractExecutorService implements ListeningExecutorService
{
    @Override
    protected final RunnableFuture newTaskFor(final Runnable runnable, final Object o) {
        return TrustedListenableFutureTask.create(runnable, o);
    }
    
    @Override
    protected final RunnableFuture newTaskFor(final Callable callable) {
        return TrustedListenableFutureTask.create(callable);
    }
    
    @Override
    public ListenableFuture submit(final Runnable runnable) {
        return (ListenableFuture)super.submit(runnable);
    }
    
    @Override
    public ListenableFuture submit(final Runnable runnable, @Nullable final Object o) {
        return (ListenableFuture)super.submit(runnable, o);
    }
    
    @Override
    public ListenableFuture submit(final Callable callable) {
        return (ListenableFuture)super.submit((Callable<Object>)callable);
    }
}
