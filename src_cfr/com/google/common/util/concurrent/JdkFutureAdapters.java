/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.JdkFutureAdapters$ListenableFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;

@Beta
public final class JdkFutureAdapters {
    public static ListenableFuture listenInPoolThread(Future future) {
        if (!(future instanceof ListenableFuture)) return new JdkFutureAdapters$ListenableFutureAdapter(future);
        return (ListenableFuture)future;
    }

    public static ListenableFuture listenInPoolThread(Future future, Executor executor) {
        Preconditions.checkNotNull(executor);
        if (!(future instanceof ListenableFuture)) return new JdkFutureAdapters$ListenableFutureAdapter(future, executor);
        return (ListenableFuture)future;
    }

    private JdkFutureAdapters() {
    }
}

