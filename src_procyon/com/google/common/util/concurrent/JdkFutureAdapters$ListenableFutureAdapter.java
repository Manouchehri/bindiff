package com.google.common.util.concurrent;

import java.util.concurrent.atomic.*;
import com.google.common.base.*;
import java.util.concurrent.*;

class JdkFutureAdapters$ListenableFutureAdapter extends ForwardingFuture implements ListenableFuture
{
    private static final ThreadFactory threadFactory;
    private static final Executor defaultAdapterExecutor;
    private final Executor adapterExecutor;
    private final ExecutionList executionList;
    private final AtomicBoolean hasListeners;
    private final Future delegate;
    
    JdkFutureAdapters$ListenableFutureAdapter(final Future future) {
        this(future, JdkFutureAdapters$ListenableFutureAdapter.defaultAdapterExecutor);
    }
    
    JdkFutureAdapters$ListenableFutureAdapter(final Future future, final Executor executor) {
        this.executionList = new ExecutionList();
        this.hasListeners = new AtomicBoolean(false);
        this.delegate = (Future)Preconditions.checkNotNull(future);
        this.adapterExecutor = (Executor)Preconditions.checkNotNull(executor);
    }
    
    @Override
    protected Future delegate() {
        return this.delegate;
    }
    
    @Override
    public void addListener(final Runnable runnable, final Executor executor) {
        this.executionList.add(runnable, executor);
        if (this.hasListeners.compareAndSet(false, true)) {
            if (this.delegate.isDone()) {
                this.executionList.execute();
                return;
            }
            this.adapterExecutor.execute(new JdkFutureAdapters$ListenableFutureAdapter$1(this));
        }
    }
    
    static {
        threadFactory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
        defaultAdapterExecutor = Executors.newCachedThreadPool(JdkFutureAdapters$ListenableFutureAdapter.threadFactory);
    }
}
