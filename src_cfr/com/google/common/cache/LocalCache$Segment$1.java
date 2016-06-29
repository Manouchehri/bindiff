/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$LoadingValueReference;
import com.google.common.cache.LocalCache$Segment;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

class LocalCache$Segment$1
implements Runnable {
    final /* synthetic */ Object val$key;
    final /* synthetic */ int val$hash;
    final /* synthetic */ LocalCache$LoadingValueReference val$loadingValueReference;
    final /* synthetic */ ListenableFuture val$loadingFuture;
    final /* synthetic */ LocalCache$Segment this$0;

    LocalCache$Segment$1(LocalCache$Segment localCache$Segment, Object object, int n2, LocalCache$LoadingValueReference localCache$LoadingValueReference, ListenableFuture listenableFuture) {
        this.this$0 = localCache$Segment;
        this.val$key = object;
        this.val$hash = n2;
        this.val$loadingValueReference = localCache$LoadingValueReference;
        this.val$loadingFuture = listenableFuture;
    }

    @Override
    public void run() {
        try {
            Object object = this.this$0.getAndRecordStats(this.val$key, this.val$hash, this.val$loadingValueReference, this.val$loadingFuture);
            return;
        }
        catch (Throwable var1_2) {
            LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", var1_2);
            this.val$loadingValueReference.setException(var1_2);
        }
    }
}

