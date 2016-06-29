package com.google.common.util.concurrent;

import javax.annotation.*;
import com.google.common.base.*;
import java.util.concurrent.*;
import java.lang.reflect.*;
import com.google.errorprone.annotations.*;

abstract class Futures$AbstractChainingFuture extends AbstractFuture$TrustedFuture implements Runnable
{
    @Nullable
    ListenableFuture inputFuture;
    @Nullable
    Object function;
    
    Futures$AbstractChainingFuture(final ListenableFuture listenableFuture, final Object o) {
        this.inputFuture = (ListenableFuture)Preconditions.checkNotNull(listenableFuture);
        this.function = Preconditions.checkNotNull(o);
    }
    
    @Override
    public final void run() {
        try {
            final ListenableFuture inputFuture = this.inputFuture;
            final Object function = this.function;
            if (this.isCancelled() | inputFuture == null | function == null) {
                return;
            }
            this.inputFuture = null;
            this.function = null;
            Object uninterruptibly;
            try {
                uninterruptibly = Uninterruptibles.getUninterruptibly(inputFuture);
            }
            catch (CancellationException ex3) {
                this.cancel(false);
                return;
            }
            catch (ExecutionException ex) {
                this.setException(ex.getCause());
                return;
            }
            this.doTransform(function, uninterruptibly);
        }
        catch (UndeclaredThrowableException ex2) {
            this.setException(ex2.getCause());
        }
        catch (Throwable exception) {
            this.setException(exception);
        }
    }
    
    @ForOverride
    abstract void doTransform(final Object p0, final Object p1);
    
    @Override
    final void done() {
        this.maybePropagateCancellation(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }
}
