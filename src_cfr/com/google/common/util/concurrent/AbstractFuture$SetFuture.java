/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;

final class AbstractFuture$SetFuture
implements Runnable {
    final ListenableFuture future;
    final /* synthetic */ AbstractFuture this$0;

    AbstractFuture$SetFuture(AbstractFuture abstractFuture, ListenableFuture listenableFuture) {
        this.this$0 = abstractFuture;
        this.future = listenableFuture;
    }

    @Override
    public void run() {
        if (AbstractFuture.access$300(this.this$0) != this) {
            return;
        }
        AbstractFuture.access$400(this.this$0, this.future, this);
    }
}

