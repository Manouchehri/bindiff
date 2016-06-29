package com.google.common.util.concurrent;

import java.util.*;
import com.google.common.collect.*;
import javax.annotation.*;
import com.google.common.base.*;

abstract class CollectionFuture$CollectionFutureRunningState extends AggregateFuture$RunningState
{
    private List values;
    final /* synthetic */ CollectionFuture this$0;
    
    CollectionFuture$CollectionFutureRunningState(final CollectionFuture this$0, final ImmutableCollection collection, final boolean b) {
        this.this$0 = this$0;
        super(this$0, collection, b, true);
        this.values = (collection.isEmpty() ? ImmutableList.of() : Lists.newArrayListWithCapacity(collection.size()));
        for (int i = 0; i < collection.size(); ++i) {
            this.values.add(null);
        }
    }
    
    @Override
    final void collectOneValue(final boolean b, final int n, @Nullable final Object o) {
        final List values = this.values;
        if (values != null) {
            values.set(n, Optional.fromNullable(o));
        }
        else {
            Preconditions.checkState(b || this.this$0.isCancelled(), (Object)"Future was done before all dependencies completed");
        }
    }
    
    @Override
    final void handleAllCompleted() {
        final List values = this.values;
        if (values != null) {
            this.this$0.set(this.combine(values));
        }
        else {
            Preconditions.checkState(this.this$0.isDone());
        }
    }
    
    @Override
    void releaseResourcesAfterFailure() {
        super.releaseResourcesAfterFailure();
        this.values = null;
    }
    
    abstract Object combine(final List p0);
}
