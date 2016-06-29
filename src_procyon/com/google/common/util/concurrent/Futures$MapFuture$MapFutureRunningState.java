package com.google.common.util.concurrent;

import javax.annotation.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import java.util.*;

final class Futures$MapFuture$MapFutureRunningState extends CollectionFuture$CollectionFutureRunningState
{
    @Nullable
    ImmutableMap futures;
    final /* synthetic */ Futures$MapFuture this$0;
    
    Futures$MapFuture$MapFutureRunningState(final Futures$MapFuture this$0, final ImmutableMap futures, final boolean b) {
        this.this$0 = this$0;
        super(this$0, futures.values(), b);
        this.futures = futures;
    }
    
    public Map combine(final List list) {
        final LinkedHashMap linkedHashMap = Maps.newLinkedHashMap();
        for (final Pair pair : Iterables.pairUp(this.futures.keySet(), list)) {
            if (pair.second != null) {
                linkedHashMap.put(pair.first, ((Optional)pair.second).orNull());
            }
        }
        return Collections.unmodifiableMap((Map<?, ?>)linkedHashMap);
    }
    
    @Override
    void releaseResourcesAfterFailure() {
        super.releaseResourcesAfterFailure();
        this.futures = null;
    }
}
