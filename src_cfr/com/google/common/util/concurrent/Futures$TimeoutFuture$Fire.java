/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.Futures$TimeoutFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

final class Futures$TimeoutFuture$Fire
implements Runnable {
    @Nullable
    Futures$TimeoutFuture timeoutFutureRef;

    Futures$TimeoutFuture$Fire(Futures$TimeoutFuture timeoutFuture) {
        this.timeoutFutureRef = timeoutFuture;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void run() {
        Futures$TimeoutFuture futures$TimeoutFuture = this.timeoutFutureRef;
        if (futures$TimeoutFuture == null) {
            return;
        }
        ListenableFuture listenableFuture = futures$TimeoutFuture.delegateRef;
        if (listenableFuture == null) {
            return;
        }
        this.timeoutFutureRef = null;
        if (listenableFuture.isDone()) {
            futures$TimeoutFuture.setFuture(listenableFuture);
            return;
        }
        try {
            String string = String.valueOf(listenableFuture);
            futures$TimeoutFuture.setException(new TimeoutException(new StringBuilder(18 + String.valueOf(string).length()).append("Future timed out: ").append(string).toString()));
            return;
        }
        finally {
            listenableFuture.cancel(true);
        }
    }
}

