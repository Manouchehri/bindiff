/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ExecutionList;
import com.google.common.util.concurrent.ForwardingFuture;
import com.google.common.util.concurrent.JdkFutureAdapters$ListenableFutureAdapter$1;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

class JdkFutureAdapters$ListenableFutureAdapter
extends ForwardingFuture
implements ListenableFuture {
    private static final ThreadFactory threadFactory = new ThreadFactoryBuilder().setDaemon(true).setNameFormat("ListenableFutureAdapter-thread-%d").build();
    private static final Executor defaultAdapterExecutor = Executors.newCachedThreadPool(threadFactory);
    private final Executor adapterExecutor;
    private final ExecutionList executionList = new ExecutionList();
    private final AtomicBoolean hasListeners = new AtomicBoolean(false);
    private final Future delegate;

    JdkFutureAdapters$ListenableFutureAdapter(Future future) {
        this(future, defaultAdapterExecutor);
    }

    JdkFutureAdapters$ListenableFutureAdapter(Future future, Executor executor) {
        this.delegate = (Future)Preconditions.checkNotNull(future);
        this.adapterExecutor = (Executor)Preconditions.checkNotNull(executor);
    }

    @Override
    protected Future delegate() {
        return this.delegate;
    }

    @Override
    public void addListener(Runnable runnable, Executor executor) {
        this.executionList.add(runnable, executor);
        if (!this.hasListeners.compareAndSet(false, true)) return;
        if (this.delegate.isDone()) {
            this.executionList.execute();
            return;
        }
        this.adapterExecutor.execute(new JdkFutureAdapters$ListenableFutureAdapter$1(this));
    }

    static /* synthetic */ Future access$000(JdkFutureAdapters$ListenableFutureAdapter jdkFutureAdapters$ListenableFutureAdapter) {
        return jdkFutureAdapters$ListenableFutureAdapter.delegate;
    }

    static /* synthetic */ ExecutionList access$100(JdkFutureAdapters$ListenableFutureAdapter jdkFutureAdapters$ListenableFutureAdapter) {
        return jdkFutureAdapters$ListenableFutureAdapter.executionList;
    }
}

