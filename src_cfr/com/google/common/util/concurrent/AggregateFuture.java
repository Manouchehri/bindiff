/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AbstractFuture$TrustedFuture;
import com.google.common.util.concurrent.AggregateFuture$RunningState;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Set;
import java.util.logging.Logger;

@GwtCompatible
abstract class AggregateFuture
extends AbstractFuture$TrustedFuture {
    private static final Logger logger = Logger.getLogger(AggregateFuture.class.getName());
    private AggregateFuture$RunningState runningState;

    AggregateFuture() {
    }

    @Override
    final void done() {
        super.done();
        this.runningState = null;
    }

    @Override
    public final boolean cancel(boolean bl2) {
        AggregateFuture$RunningState aggregateFuture$RunningState = this.runningState;
        ImmutableCollection immutableCollection = aggregateFuture$RunningState != null ? AggregateFuture$RunningState.access$000(aggregateFuture$RunningState) : null;
        boolean bl3 = super.cancel(bl2);
        if (!(bl3 & immutableCollection != null)) return bl3;
        UnmodifiableIterator unmodifiableIterator = immutableCollection.iterator();
        while (unmodifiableIterator.hasNext()) {
            ListenableFuture listenableFuture = (ListenableFuture)unmodifiableIterator.next();
            listenableFuture.cancel(bl2);
        }
        return bl3;
    }

    @GwtIncompatible(value="Interruption not supported")
    @Override
    protected final void interruptTask() {
        AggregateFuture$RunningState aggregateFuture$RunningState = this.runningState;
        if (aggregateFuture$RunningState == null) return;
        aggregateFuture$RunningState.interruptTask();
    }

    final void init(AggregateFuture$RunningState aggregateFuture$RunningState) {
        this.runningState = aggregateFuture$RunningState;
        AggregateFuture$RunningState.access$100(aggregateFuture$RunningState);
    }

    private static boolean addCausalChain(Set set, Throwable throwable) {
        while (throwable != null) {
            boolean bl2 = set.add(throwable);
            if (!bl2) {
                return false;
            }
            throwable = throwable.getCause();
        }
        return true;
    }

    static /* synthetic */ boolean access$400(Set set, Throwable throwable) {
        return AggregateFuture.addCausalChain(set, throwable);
    }

    static /* synthetic */ Logger access$500() {
        return logger;
    }

    static /* synthetic */ boolean access$601(AggregateFuture aggregateFuture, boolean bl2) {
        return aggregateFuture.cancel(bl2);
    }
}

