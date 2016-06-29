package com.google.common.util.concurrent;

import java.util.concurrent.*;

final class Futures$5 implements Runnable
{
    final /* synthetic */ ConcurrentLinkedQueue val$delegates;
    final /* synthetic */ ListenableFuture val$future;
    
    Futures$5(final ConcurrentLinkedQueue val$delegates, final ListenableFuture val$future) {
        this.val$delegates = val$delegates;
        this.val$future = val$future;
    }
    
    @Override
    public void run() {
        ((SettableFuture)this.val$delegates.remove()).setFuture(this.val$future);
    }
}
