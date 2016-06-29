/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.Futures$2$1;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class Futures$2
implements Executor {
    volatile boolean thrownFromDelegate;
    final /* synthetic */ Executor val$delegate;
    final /* synthetic */ AbstractFuture val$future;

    Futures$2(Executor executor, AbstractFuture abstractFuture) {
        this.val$delegate = executor;
        this.val$future = abstractFuture;
        this.thrownFromDelegate = true;
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            this.val$delegate.execute(new Futures$2$1(this, runnable));
            return;
        }
        catch (RejectedExecutionException var2_2) {
            if (!this.thrownFromDelegate) return;
            this.val$future.setException(var2_2);
        }
    }
}

