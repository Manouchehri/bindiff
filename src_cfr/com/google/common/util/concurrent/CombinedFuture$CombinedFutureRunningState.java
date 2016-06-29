/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture;
import com.google.common.util.concurrent.AggregateFuture$RunningState;
import com.google.common.util.concurrent.CombinedFuture;
import com.google.common.util.concurrent.CombinedFuture$CombinedFutureInterruptibleTask;
import javax.annotation.Nullable;

final class CombinedFuture$CombinedFutureRunningState
extends AggregateFuture$RunningState {
    private CombinedFuture$CombinedFutureInterruptibleTask task;
    final /* synthetic */ CombinedFuture this$0;

    CombinedFuture$CombinedFutureRunningState(CombinedFuture combinedFuture, ImmutableCollection immutableCollection, boolean bl2, CombinedFuture$CombinedFutureInterruptibleTask combinedFuture$CombinedFutureInterruptibleTask) {
        this.this$0 = combinedFuture;
        super(combinedFuture, immutableCollection, bl2, false);
        this.task = combinedFuture$CombinedFutureInterruptibleTask;
    }

    @Override
    void collectOneValue(boolean bl2, int n2, @Nullable Object object) {
    }

    @Override
    void handleAllCompleted() {
        CombinedFuture$CombinedFutureInterruptibleTask combinedFuture$CombinedFutureInterruptibleTask = this.task;
        if (combinedFuture$CombinedFutureInterruptibleTask != null) {
            combinedFuture$CombinedFutureInterruptibleTask.execute();
            return;
        }
        Preconditions.checkState(this.this$0.isDone());
    }

    @Override
    void releaseResourcesAfterFailure() {
        super.releaseResourcesAfterFailure();
        this.task = null;
    }

    @Override
    void interruptTask() {
        CombinedFuture$CombinedFutureInterruptibleTask combinedFuture$CombinedFutureInterruptibleTask = this.task;
        if (combinedFuture$CombinedFutureInterruptibleTask == null) return;
        combinedFuture$CombinedFutureInterruptibleTask.interruptTask();
    }
}

