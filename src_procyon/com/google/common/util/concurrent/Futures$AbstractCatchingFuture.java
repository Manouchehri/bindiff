package com.google.common.util.concurrent;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.concurrent.*;
import com.google.errorprone.annotations.*;

abstract class Futures$AbstractCatchingFuture extends AbstractFuture$TrustedFuture implements Runnable
{
    @Nullable
    ListenableFuture inputFuture;
    @Nullable
    Class exceptionType;
    @Nullable
    Object fallback;
    
    Futures$AbstractCatchingFuture(final ListenableFuture listenableFuture, final Class clazz, final Object o) {
        this.inputFuture = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
        this.exceptionType = (Class)Preconditions.checkNotNull(clazz);
        this.fallback = Preconditions.checkNotNull(o);
    }
    
    @Override
    public final void run() {
        final ListenableFuture inputFuture = this.inputFuture;
        final Class exceptionType = this.exceptionType;
        final Object fallback = this.fallback;
        if (inputFuture == null | exceptionType == null | fallback == null | this.isCancelled()) {
            return;
        }
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
        Throwable cause;
        try {
            this.set(Uninterruptibles.getUninterruptibly(inputFuture));
            return;
        }
        catch (ExecutionException ex) {
            cause = ex.getCause();
        }
        catch (Throwable t) {
            cause = t;
        }
        try {
            if (Platform.isInstanceOfThrowableClass(cause, exceptionType)) {
                this.doFallback(fallback, cause);
            }
            else {
                this.setException(cause);
            }
        }
        catch (Throwable exception) {
            this.setException(exception);
        }
    }
    
    @ForOverride
    abstract void doFallback(final Object p0, final Throwable p1);
    
    @Override
    final void done() {
        this.maybePropagateCancellation(this.inputFuture);
        this.inputFuture = null;
        this.exceptionType = null;
        this.fallback = null;
    }
}
