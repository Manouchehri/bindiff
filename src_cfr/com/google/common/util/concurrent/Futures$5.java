/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import java.util.concurrent.ConcurrentLinkedQueue;

final class Futures$5
implements Runnable {
    final /* synthetic */ ConcurrentLinkedQueue val$delegates;
    final /* synthetic */ ListenableFuture val$future;

    Futures$5(ConcurrentLinkedQueue concurrentLinkedQueue, ListenableFuture listenableFuture) {
        this.val$delegates = concurrentLinkedQueue;
        this.val$future = listenableFuture;
    }

    @Override
    public void run() {
        ((SettableFuture)this.val$delegates.remove()).setFuture(this.val$future);
    }
}

