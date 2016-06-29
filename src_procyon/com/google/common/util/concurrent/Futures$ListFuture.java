package com.google.common.util.concurrent;

import com.google.common.collect.*;

final class Futures$ListFuture extends CollectionFuture
{
    Futures$ListFuture(final ImmutableCollection collection, final boolean b) {
        this.init(new Futures$ListFuture$ListFutureRunningState(this, collection, b));
    }
}
