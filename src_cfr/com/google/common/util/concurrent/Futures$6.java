/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.ExecutionException;

final class Futures$6
implements Runnable {
    final /* synthetic */ ListenableFuture val$future;
    final /* synthetic */ FutureCallback val$callback;

    Futures$6(ListenableFuture listenableFuture, FutureCallback futureCallback) {
        this.val$future = listenableFuture;
        this.val$callback = futureCallback;
    }

    @Override
    public void run() {
        Object object;
        try {
            object = Uninterruptibles.getUninterruptibly(this.val$future);
        }
        catch (ExecutionException var2_2) {
            this.val$callback.onFailure(var2_2.getCause());
            return;
        }
        catch (RuntimeException var2_3) {
            this.val$callback.onFailure(var2_3);
            return;
        }
        catch (Error var2_4) {
            this.val$callback.onFailure(var2_4);
            return;
        }
        this.val$callback.onSuccess(object);
    }
}

