/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GoogleInternal;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.AggregateFuture$RunningState;
import com.google.common.util.concurrent.CollectionFuture;
import com.google.common.util.concurrent.Futures$MapFuture$MapFutureRunningState;

@GoogleInternal
@GwtIncompatible(value="TODO")
final class Futures$MapFuture
extends CollectionFuture {
    Futures$MapFuture(ImmutableMap immutableMap, boolean bl2) {
        this.init(new Futures$MapFuture$MapFutureRunningState(this, immutableMap, bl2));
    }
}

