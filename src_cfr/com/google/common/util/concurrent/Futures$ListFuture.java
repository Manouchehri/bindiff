/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.collect.ImmutableCollection;
import com.google.common.util.concurrent.AggregateFuture$RunningState;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.Futures$ListFuture$ListFutureRunningState;

final class Futures$ListFuture
extends CollectionFuture {
    Futures$ListFuture(ImmutableCollection immutableCollection, boolean bl2) {
        this.init(new Futures$ListFuture$ListFutureRunningState(this, immutableCollection, bl2));
    }
}

