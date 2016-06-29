/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.Futures$1;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

@GoogleInternal
@GwtCompatible
public final class Futures$FutureCombiner {
    private final boolean allMustSucceed;
    private final ImmutableList futures;

    private Futures$FutureCombiner(boolean bl2, ImmutableList immutableList) {
        this.allMustSucceed = bl2;
        this.futures = immutableList;
    }

    public ListenableFuture callAsync(AsyncCallable asyncCallable, Executor executor) {
        return new CombinedFuture((ImmutableCollection)this.futures, this.allMustSucceed, executor, asyncCallable);
    }

    public ListenableFuture callAsync(AsyncCallable asyncCallable) {
        return this.callAsync(asyncCallable, MoreExecutors.directExecutor());
    }

    public ListenableFuture call(Callable callable, Executor executor) {
        return new CombinedFuture((ImmutableCollection)this.futures, this.allMustSucceed, executor, callable);
    }

    public ListenableFuture call(Callable callable) {
        return this.call(callable, MoreExecutors.directExecutor());
    }

    /* synthetic */ Futures$FutureCombiner(boolean bl2, ImmutableList immutableList, Futures$1 futures$1) {
        this(bl2, immutableList);
    }
}

