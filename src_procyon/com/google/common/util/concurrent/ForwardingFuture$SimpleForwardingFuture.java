package com.google.common.util.concurrent;

import java.util.concurrent.*;
import com.google.common.base.*;

public abstract class ForwardingFuture$SimpleForwardingFuture extends ForwardingFuture
{
    private final Future delegate;
    
    protected ForwardingFuture$SimpleForwardingFuture(final Future future) {
        this.delegate = (Future)Preconditions.checkNotNull(future);
    }
    
    @Override
    protected final Future delegate() {
        return this.delegate;
    }
}
