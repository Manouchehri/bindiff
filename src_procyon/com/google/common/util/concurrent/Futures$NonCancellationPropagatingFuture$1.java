package com.google.common.util.concurrent;

class Futures$NonCancellationPropagatingFuture$1 implements Runnable
{
    final /* synthetic */ ListenableFuture val$delegate;
    final /* synthetic */ Futures$NonCancellationPropagatingFuture this$0;
    
    Futures$NonCancellationPropagatingFuture$1(final Futures$NonCancellationPropagatingFuture this$0, final ListenableFuture val$delegate) {
        this.this$0 = this$0;
        this.val$delegate = val$delegate;
    }
    
    @Override
    public void run() {
        this.this$0.setFuture(this.val$delegate);
    }
}
