/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.ShimAsyncCache$Entry;
import com.google.common.cache.ShimAsyncCache$Entry$EntryState;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.atomic.AtomicReference;

class ShimAsyncCache$Entry$1
implements Runnable {
    final /* synthetic */ ListenableFuture val$future;
    final /* synthetic */ ShimAsyncCache$Entry this$0;

    ShimAsyncCache$Entry$1(ShimAsyncCache$Entry shimAsyncCache$Entry, ListenableFuture listenableFuture) {
        this.this$0 = shimAsyncCache$Entry;
        this.val$future = listenableFuture;
    }

    @Override
    public void run() {
        ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).handleCompletion(this.val$future);
    }
}

