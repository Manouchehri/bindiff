/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.Futures$NonCancellationPropagatingFuture$1;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

@GwtIncompatible(value="TODO")
final class Futures$NonCancellationPropagatingFuture
extends AbstractFuture$TrustedFuture {
    Futures$NonCancellationPropagatingFuture(ListenableFuture listenableFuture) {
        listenableFuture.addListener(new Futures$NonCancellationPropagatingFuture$1(this, listenableFuture), MoreExecutors.directExecutor());
    }
}

