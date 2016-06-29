package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.util.concurrent.ListenableFuture;

@Deprecated
@Beta
@GwtCompatible
public interface FutureFallback {
   ListenableFuture create(Throwable var1);
}
