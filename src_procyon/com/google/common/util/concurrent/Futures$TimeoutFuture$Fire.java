package com.google.common.util.concurrent;

import javax.annotation.*;
import java.util.concurrent.*;

final class Futures$TimeoutFuture$Fire implements Runnable
{
    @Nullable
    Futures$TimeoutFuture timeoutFutureRef;
    
    Futures$TimeoutFuture$Fire(final Futures$TimeoutFuture timeoutFutureRef) {
        this.timeoutFutureRef = timeoutFutureRef;
    }
    
    @Override
    public void run() {
        final Futures$TimeoutFuture timeoutFutureRef = this.timeoutFutureRef;
        if (timeoutFutureRef == null) {
            return;
        }
        final ListenableFuture delegateRef = timeoutFutureRef.delegateRef;
        if (delegateRef == null) {
            return;
        }
        this.timeoutFutureRef = null;
        if (delegateRef.isDone()) {
            timeoutFutureRef.setFuture(delegateRef);
        }
        else {
            try {
                final Futures$TimeoutFuture futures$TimeoutFuture = timeoutFutureRef;
                final String value = String.valueOf(delegateRef);
                futures$TimeoutFuture.setException(new TimeoutException(new StringBuilder(18 + String.valueOf(value).length()).append("Future timed out: ").append(value).toString()));
            }
            finally {
                delegateRef.cancel(true);
            }
        }
    }
}
