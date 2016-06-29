package com.google.common.cache;

import com.google.common.util.concurrent.*;
import java.util.logging.*;

class LocalCache$Segment$1 implements Runnable
{
    final /* synthetic */ Object val$key;
    final /* synthetic */ int val$hash;
    final /* synthetic */ LocalCache$LoadingValueReference val$loadingValueReference;
    final /* synthetic */ ListenableFuture val$loadingFuture;
    final /* synthetic */ LocalCache$Segment this$0;
    
    LocalCache$Segment$1(final LocalCache$Segment this$0, final Object val$key, final int val$hash, final LocalCache$LoadingValueReference val$loadingValueReference, final ListenableFuture val$loadingFuture) {
        this.this$0 = this$0;
        this.val$key = val$key;
        this.val$hash = val$hash;
        this.val$loadingValueReference = val$loadingValueReference;
        this.val$loadingFuture = val$loadingFuture;
    }
    
    @Override
    public void run() {
        try {
            this.this$0.getAndRecordStats(this.val$key, this.val$hash, this.val$loadingValueReference, this.val$loadingFuture);
        }
        catch (Throwable exception) {
            LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", exception);
            this.val$loadingValueReference.setException(exception);
        }
    }
}
