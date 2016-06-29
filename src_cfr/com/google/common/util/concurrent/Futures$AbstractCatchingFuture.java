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
import com.google.common.util.concurrent.Platform;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import javax.annotation.Nullable;

abstract class Futures$AbstractCatchingFuture
extends AbstractFuture$TrustedFuture
implements Runnable {
    @Nullable
    ListenableFuture inputFuture;
    @Nullable
    Class exceptionType;
    @Nullable
    Object fallback;

    Futures$AbstractCatchingFuture(ListenableFuture listenableFuture, Class class_, Object object) {
        this.inputFuture = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
        this.exceptionType = (Class)Preconditions.checkNotNull(class_);
        this.fallback = Preconditions.checkNotNull(object);
    }

    @Override
    public final void run() {
        Throwable throwable;
        Object object;
        Class class_;
        ListenableFuture listenableFuture = this.inputFuture;
        if (listenableFuture == null | (class_ = this.exceptionType) == null | (object = this.fallback) == null | this.isCancelled()) {
            return;
        }
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
        try {
            this.set(Uninterruptibles.getUninterruptibly(listenableFuture));
            return;
        }
        catch (ExecutionException var5_4) {
            throwable = var5_4.getCause();
        }
        catch (Throwable var5_5) {
            throwable = var5_5;
        }
        try {
            if (Platform.isInstanceOfThrowableClass(throwable, class_)) {
                Throwable throwable2 = throwable;
                this.doFallback(object, throwable2);
                return;
            }
            this.setException(throwable);
            return;
        }
        catch (Throwable var5_7) {
            this.setException(var5_7);
        }
    }

    @ForOverride
    abstract void doFallback(Object var1, Throwable var2);

    @Override
    final void done() {
        this.maybePropagateCancellation(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }
}

