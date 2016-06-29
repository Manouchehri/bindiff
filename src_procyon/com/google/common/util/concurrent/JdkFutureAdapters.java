package com.google.common.util.concurrent;

import com.google.common.annotations.*;
import java.util.concurrent.*;
import com.google.common.base.*;

@Beta
public final class JdkFutureAdapters
{
    public static ListenableFuture listenInPoolThread(final Future future) {
        if (future instanceof ListenableFuture) {
            return (ListenableFuture)future;
        }
        return new JdkFutureAdapters$ListenableFutureAdapter(future);
    }
    
    public static ListenableFuture listenInPoolThread(final Future future, final Executor executor) {
        Preconditions.checkNotNull(executor);
        if (future instanceof ListenableFuture) {
            return (ListenableFuture)future;
        }
        return new JdkFutureAdapters$ListenableFutureAdapter(future, executor);
    }
}
