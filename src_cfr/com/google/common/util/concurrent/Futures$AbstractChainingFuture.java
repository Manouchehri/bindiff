/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.ForOverride;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

abstract class Futures$AbstractChainingFuture
extends AbstractFuture$TrustedFuture
implements Runnable {
    @Nullable
    ListenableFuture inputFuture;
    @Nullable
    Object function;

    Futures$AbstractChainingFuture(ListenableFuture listenableFuture, Object object) {
        this.inputFuture = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
        this.function = Preconditions.checkNotNull(object);
    }

    @Override
    public final void run() {
        try {
            Object object;
            ListenableFuture listenableFuture = this.inputFuture;
            Object object2 = this.function;
            if (this.isCancelled() | listenableFuture == null | object2 == null) {
                return;
            }
            this.inputFuture = null;
            this.function = null;
            try {
                object = Uninterruptibles.getUninterruptibly(listenableFuture);
            }
            catch (CancellationException var4_6) {
                this.cancel(false);
                return;
            }
            catch (ExecutionException var4_7) {
                this.setException(var4_7.getCause());
                return;
            }
            this.doTransform(object2, object);
            return;
        }
        catch (UndeclaredThrowableException var1_2) {
            this.setException(var1_2.getCause());
            return;
        }
        catch (Throwable var1_3) {
            this.setException(var1_3);
        }
    }

    @ForOverride
    abstract void doTransform(Object var1, Object var2);

    @Override
    final void done() {
        this.maybePropagateCancellation(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }
}

