package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@GwtIncompatible("TODO")
final class Futures$NonCancellationPropagatingFuture extends AbstractFuture$TrustedFuture
{
    Futures$NonCancellationPropagatingFuture(final ListenableFuture listenableFuture) {
        listenableFuture.addListener(new Futures$NonCancellationPropagatingFuture$1(this, listenableFuture), MoreExecutors.directExecutor());
    }
}
