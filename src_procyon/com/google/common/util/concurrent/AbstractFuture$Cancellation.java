package com.google.common.util.concurrent;

import com.google.common.base.*;

final class AbstractFuture$Cancellation
{
    final boolean wasInterrupted;
    final Throwable cause;
    
    AbstractFuture$Cancellation(final boolean wasInterrupted, final Throwable t) {
        this.wasInterrupted = wasInterrupted;
        this.cause = (Throwable)Preconditions.checkNotNull(t);
    }
}
