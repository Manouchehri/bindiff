/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture;
import com.google.common.util.concurrent.AggregateFuture$RunningState;
import com.google.common.util.concurrent.AsyncCallable;
import com.google.common.util.concurrent.CombinedFuture$AsyncCallableInterruptibleTask;
import com.google.common.util.concurrent.CombinedFuture$CallableInterruptibleTask;
import com.google.common.util.concurrent.CombinedFuture$CombinedFutureInterruptibleTask;
import com.google.common.util.concurrent.CombinedFuture$CombinedFutureRunningState;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

@GoogleInternal
@GwtCompatible
final class CombinedFuture
extends AggregateFuture {
    CombinedFuture(ImmutableCollection immutableCollection, boolean bl2, Executor executor, AsyncCallable asyncCallable) {
        this.init(new CombinedFuture$CombinedFutureRunningState(this, immutableCollection, bl2, new CombinedFuture$AsyncCallableInterruptibleTask(this, asyncCallable, executor)));
    }

    CombinedFuture(ImmutableCollection immutableCollection, boolean bl2, Executor executor, Callable callable) {
        this.init(new CombinedFuture$CombinedFutureRunningState(this, immutableCollection, bl2, new CombinedFuture$CallableInterruptibleTask(this, callable, executor)));
    }
}

