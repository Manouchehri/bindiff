package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@Deprecated
@Beta
@GwtCompatible
public interface FutureFallback
{
    ListenableFuture create(final Throwable p0);
}
