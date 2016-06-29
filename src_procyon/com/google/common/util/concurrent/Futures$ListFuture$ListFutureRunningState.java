package com.google.common.util.concurrent;

import com.google.common.collect.*;
import com.google.common.base.*;
import java.util.*;

final class Futures$ListFuture$ListFutureRunningState extends CollectionFuture$CollectionFutureRunningState
{
    final /* synthetic */ Futures$ListFuture this$0;
    
    Futures$ListFuture$ListFutureRunningState(final Futures$ListFuture this$0, final ImmutableCollection collection, final boolean b) {
        this.this$0 = this$0;
        super(this$0, collection, b);
    }
    
    public List combine(final List list) {
        final ArrayList arrayList = Lists.newArrayList();
        for (final Optional optional : list) {
            arrayList.add((optional != null) ? optional.orNull() : null);
        }
        return Collections.unmodifiableList((List<?>)arrayList);
    }
}
