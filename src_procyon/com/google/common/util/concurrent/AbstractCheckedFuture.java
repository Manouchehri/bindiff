package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;

@Beta
public abstract class AbstractCheckedFuture extends ForwardingListenableFuture$SimpleForwardingListenableFuture implements CheckedFuture
{
    protected AbstractCheckedFuture(final ListenableFuture listenableFuture) {
        super(listenableFuture);
    }
    
    protected abstract Exception mapException(final Exception p0);
    
    @Override
    public Object checkedGet() {
        try {
            return this.get();
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw this.mapException(ex);
        }
        catch (CancellationException ex2) {
            throw this.mapException(ex2);
        }
        catch (ExecutionException ex3) {
            throw this.mapException(ex3);
        }
    }
    
    @Override
    public Object checkedGet(final long n, final TimeUnit timeUnit) {
        try {
            return this.get(n, timeUnit);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw this.mapException(ex);
        }
        catch (CancellationException ex2) {
            throw this.mapException(ex2);
        }
        catch (ExecutionException ex3) {
            throw this.mapException(ex3);
        }
    }
}
