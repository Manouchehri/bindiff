/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Futures$NonCancellationPropagatingFuture;
import com.google.common.util.concurrent.ListenableFuture;

class Futures$NonCancellationPropagatingFuture$1
implements Runnable {
    final /* synthetic */ ListenableFuture val$delegate;
    final /* synthetic */ Futures$NonCancellationPropagatingFuture this$0;

    Futures$NonCancellationPropagatingFuture$1(Futures$NonCancellationPropagatingFuture nonCancellationPropagatingFuture, ListenableFuture listenableFuture) {
        this.this$0 = nonCancellationPropagatingFuture;
        this.val$delegate = listenableFuture;
    }

    @Override
    public void run() {
        this.this$0.setFuture(this.val$delegate);
    }
}

