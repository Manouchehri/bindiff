/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.BlockingQueue;

final class MoreExecutors$1
implements Runnable {
    final /* synthetic */ BlockingQueue val$queue;
    final /* synthetic */ ListenableFuture val$future;

    MoreExecutors$1(BlockingQueue blockingQueue, ListenableFuture listenableFuture) {
        this.val$queue = blockingQueue;
        this.val$future = listenableFuture;
    }

    @Override
    public void run() {
        this.val$queue.add(this.val$future);
    }
}

