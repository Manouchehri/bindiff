package com.google.common.util.concurrent;

import javax.annotation.*;
import com.google.common.annotations.*;

@GwtCompatible
public final class SettableFuture extends AbstractFuture$TrustedFuture
{
    public static SettableFuture create() {
        return new SettableFuture();
    }
    
    public boolean set(@Nullable final Object o) {
        return super.set(o);
    }
    
    public boolean setException(final Throwable exception) {
        return super.setException(exception);
    }
    
    @Beta
    public boolean setFuture(final ListenableFuture future) {
        return super.setFuture(future);
    }
}
