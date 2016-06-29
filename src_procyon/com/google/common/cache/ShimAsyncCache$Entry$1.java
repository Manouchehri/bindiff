package com.google.common.cache;

import com.google.common.util.concurrent.*;

class ShimAsyncCache$Entry$1 implements Runnable
{
    final /* synthetic */ ListenableFuture val$future;
    final /* synthetic */ ShimAsyncCache$Entry this$0;
    
    ShimAsyncCache$Entry$1(final ShimAsyncCache$Entry this$0, final ListenableFuture val$future) {
        this.this$0 = this$0;
        this.val$future = val$future;
    }
    
    @Override
    public void run() {
        this.this$0.state.get().handleCompletion(this.val$future);
    }
}
