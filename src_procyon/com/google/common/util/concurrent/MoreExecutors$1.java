package com.google.common.util.concurrent;

import java.util.concurrent.*;

final class MoreExecutors$1 implements Runnable
{
    final /* synthetic */ BlockingQueue val$queue;
    final /* synthetic */ ListenableFuture val$future;
    
    MoreExecutors$1(final BlockingQueue val$queue, final ListenableFuture val$future) {
        this.val$queue = val$queue;
        this.val$future = val$future;
    }
    
    @Override
    public void run() {
        this.val$queue.add(this.val$future);
    }
}
