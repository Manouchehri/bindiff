package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import com.google.common.base.*;
import java.util.concurrent.*;

@Beta
public abstract class ForwardingCheckedFuture$SimpleForwardingCheckedFuture extends ForwardingCheckedFuture
{
    private final CheckedFuture delegate;
    
    protected ForwardingCheckedFuture$SimpleForwardingCheckedFuture(final CheckedFuture checkedFuture) {
        this.delegate = (CheckedFuture)Preconditions.checkNotNull(checkedFuture);
    }
    
    @Override
    protected final CheckedFuture delegate() {
        return this.delegate;
    }
}
