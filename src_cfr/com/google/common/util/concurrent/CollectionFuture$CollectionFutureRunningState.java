/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.AggregateFuture;
import com.google.common.util.concurrent.AggregateFuture$RunningState;
import com.google.common.util.concurrent.CollectionFuture;
import java.util.List;
import javax.annotation.Nullable;

abstract class CollectionFuture$CollectionFutureRunningState
extends AggregateFuture$RunningState {
    private List values;
    final /* synthetic */ CollectionFuture this$0;

    CollectionFuture$CollectionFutureRunningState(CollectionFuture collectionFuture, ImmutableCollection immutableCollection, boolean bl2) {
        this.this$0 = collectionFuture;
        super(collectionFuture, immutableCollection, bl2, true);
        this.values = immutableCollection.isEmpty() ? ImmutableList.of() : Lists.newArrayListWithCapacity(immutableCollection.size());
        int n2 = 0;
        while (n2 < immutableCollection.size()) {
            this.values.add(null);
            ++n2;
        }
    }

    @Override
    final void collectOneValue(boolean bl2, int n2, @Nullable Object object) {
        List list = this.values;
        if (list != null) {
            list.set(n2, Optional.fromNullable(object));
            return;
        }
        Preconditions.checkState(bl2 || this.this$0.isCancelled(), "Future was done before all dependencies completed");
    }

    @Override
    final void handleAllCompleted() {
        List list = this.values;
        if (list != null) {
            this.this$0.set(this.combine(list));
            return;
        }
        Preconditions.checkState(this.this$0.isDone());
    }

    @Override
    void releaseResourcesAfterFailure() {
        super.releaseResourcesAfterFailure();
        this.values = null;
    }

    abstract Object combine(List var1);
}

