/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.util.concurrent.CheckedFuture;
import com.google.common.util.concurrent.ForwardingListenableFuture$SimpleForwardingListenableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@Beta
public abstract class AbstractCheckedFuture
extends ForwardingListenableFuture$SimpleForwardingListenableFuture
implements CheckedFuture {
    protected AbstractCheckedFuture(ListenableFuture listenableFuture) {
        super(listenableFuture);
    }

    protected abstract Exception mapException(Exception var1);

    @Override
    public Object checkedGet() {
        try {
            return this.get();
        }
        catch (InterruptedException var1_1) {
            Thread.currentThread().interrupt();
            throw this.mapException(var1_1);
        }
        catch (CancellationException var1_2) {
            throw this.mapException(var1_2);
        }
        catch (ExecutionException var1_3) {
            throw this.mapException(var1_3);
        }
    }

    @Override
    public Object checkedGet(long l2, TimeUnit timeUnit) {
        try {
            return this.get(l2, timeUnit);
        }
        catch (InterruptedException var4_3) {
            Thread.currentThread().interrupt();
            throw this.mapException(var4_3);
        }
        catch (CancellationException var4_4) {
            throw this.mapException(var4_4);
        }
        catch (ExecutionException var4_5) {
            throw this.mapException(var4_5);
        }
    }
}

