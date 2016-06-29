package com.google.common.util.concurrent;

import com.google.common.annotations.*;

@GoogleInternal
@GwtCompatible
public interface AsyncCallable
{
    ListenableFuture call();
}
