package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.collect.*;

@GoogleInternal
@GwtIncompatible("TODO")
final class Futures$MapFuture extends CollectionFuture
{
    Futures$MapFuture(final ImmutableMap immutableMap, final boolean b) {
        this.init(new Futures$MapFuture$MapFutureRunningState(this, immutableMap, b));
    }
}
