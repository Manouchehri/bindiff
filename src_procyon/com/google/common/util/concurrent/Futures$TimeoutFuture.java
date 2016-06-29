package com.google.common.util.concurrent;

import javax.annotation.*;
import java.util.concurrent.*;
import com.google.common.base.*;

final class Futures$TimeoutFuture extends AbstractFuture$TrustedFuture
{
    @Nullable
    ListenableFuture delegateRef;
    @Nullable
    Future timer;
    
    Futures$TimeoutFuture(final ListenableFuture listenableFuture) {
        this.delegateRef = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
    }
    
    @Override
    void done() {
        this.maybePropagateCancellation(this.delegateRef);
        final Future timer = this.timer;
        if (timer != null) {
            timer.cancel(false);
        }
        this.delegateRef = null;
        this.timer = null;
    }
}
