/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

final class Futures$TimeoutFuture
extends AbstractFuture$TrustedFuture {
    @Nullable
    ListenableFuture delegateRef;
    @Nullable
    Future timer;

    Futures$TimeoutFuture(ListenableFuture listenableFuture) {
        this.delegateRef = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
    }

    @Override
    void done() {
        this.maybePropagateCancellation(this.delegateRef);
        Future future = this.timer;
        if (future != null) {
            future.cancel(false);
        }
        this.delegateRef = null;
        this.timer = null;
    }
}

