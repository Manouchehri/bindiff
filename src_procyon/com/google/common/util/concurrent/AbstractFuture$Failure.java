package com.google.common.util.concurrent;

import com.google.common.base.*;

final class AbstractFuture$Failure
{
    static final AbstractFuture$Failure FALLBACK_INSTANCE;
    final Throwable exception;
    
    AbstractFuture$Failure(final Throwable t) {
        this.exception = (Throwable)Preconditions.checkNotNull(t);
    }
    
    static {
        FALLBACK_INSTANCE = new AbstractFuture$Failure(new AbstractFuture$Failure$1("Failure occurred while trying to finish a future."));
    }
}
