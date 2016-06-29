/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.AggregateFuture;
import com.google.common.util.concurrent.AggregateFuture$RunningState$1;
import com.google.common.util.concurrent.AggregateFutureState;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.logging.Level;
import javax.annotation.Nullable;

abstract class AggregateFuture$RunningState
extends AggregateFutureState
implements Runnable {
    private ImmutableCollection futures;
    private final boolean allMustSucceed;
    private final boolean collectsValues;
    final /* synthetic */ AggregateFuture this$0;

    AggregateFuture$RunningState(AggregateFuture aggregateFuture, ImmutableCollection immutableCollection, boolean bl2, boolean bl3) {
        this.this$0 = aggregateFuture;
        super(immutableCollection.size());
        this.futures = (ImmutableCollection)Preconditions.checkNotNull(immutableCollection);
        this.allMustSucceed = bl2;
        this.collectsValues = bl3;
    }

    @Override
    public final void run() {
        this.decrementCountAndMaybeComplete();
    }

    private void init() {
        if (this.futures.isEmpty()) {
            this.handleAllCompleted();
            return;
        }
        if (this.allMustSucceed) {
            int n2 = 0;
            UnmodifiableIterator unmodifiableIterator = this.futures.iterator();
            while (unmodifiableIterator.hasNext()) {
                ListenableFuture listenableFuture = (ListenableFuture)unmodifiableIterator.next();
                int n3 = n2++;
                listenableFuture.addListener(new AggregateFuture$RunningState$1(this, n3, listenableFuture), MoreExecutors.directExecutor());
            }
            return;
        }
        UnmodifiableIterator unmodifiableIterator = this.futures.iterator();
        while (unmodifiableIterator.hasNext()) {
            ListenableFuture listenableFuture = (ListenableFuture)unmodifiableIterator.next();
            listenableFuture.addListener(this, MoreExecutors.directExecutor());
        }
    }

    private void handleException(Throwable throwable) {
        Preconditions.checkNotNull(throwable);
        boolean bl2 = false;
        boolean bl3 = true;
        if (this.allMustSucceed) {
            bl2 = this.this$0.setException(throwable);
            if (bl2) {
                this.releaseResourcesAfterFailure();
            } else {
                bl3 = AggregateFuture.access$400(this.getOrInitSeenExceptions(), throwable);
            }
        }
        if (!(throwable instanceof Error | this.allMustSucceed & !bl2 & bl3)) return;
        AggregateFuture.access$500().log(Level.SEVERE, "input future failed.", throwable);
    }

    @Override
    final void addInitialException(Set set) {
        if (this.this$0.isCancelled()) return;
        AggregateFuture.access$400(set, this.this$0.trustedGetException());
    }

    private void handleOneInputDone(int n2, Future future) {
        Preconditions.checkState(this.allMustSucceed || !this.this$0.isDone() || this.this$0.isCancelled(), "Future was done before all dependencies completed");
        try {
            Preconditions.checkState(future.isDone(), "Tried to set value from future which is not done");
            if (!this.allMustSucceed) {
                if (!this.collectsValues) return;
                if (future.isCancelled()) return;
                this.collectOneValue(this.allMustSucceed, n2, Uninterruptibles.getUninterruptibly(future));
                return;
            }
            if (future.isCancelled()) {
                AggregateFuture.access$601(this.this$0, false);
                return;
            }
            Object object = Uninterruptibles.getUninterruptibly(future);
            if (!this.collectsValues) return;
            this.collectOneValue(this.allMustSucceed, n2, object);
            return;
        }
        catch (ExecutionException var3_4) {
            this.handleException(var3_4.getCause());
            return;
        }
        catch (Throwable var3_5) {
            this.handleException(var3_5);
        }
    }

    private void decrementCountAndMaybeComplete() {
        int n2 = this.decrementRemainingAndGet();
        Preconditions.checkState(n2 >= 0, "Less than 0 remaining futures");
        if (n2 != 0) return;
        this.processCompleted();
    }

    private void processCompleted() {
        if (this.collectsValues & !this.allMustSucceed) {
            int n2 = 0;
            for (ListenableFuture listenableFuture : this.futures) {
                this.handleOneInputDone(n2++, listenableFuture);
            }
        }
        this.handleAllCompleted();
    }

    void releaseResourcesAfterFailure() {
        this.futures = null;
    }

    abstract void collectOneValue(boolean var1, int var2, @Nullable Object var3);

    abstract void handleAllCompleted();

    void interruptTask() {
    }

    static /* synthetic */ ImmutableCollection access$000(AggregateFuture$RunningState aggregateFuture$RunningState) {
        return aggregateFuture$RunningState.futures;
    }

    static /* synthetic */ void access$100(AggregateFuture$RunningState aggregateFuture$RunningState) {
        aggregateFuture$RunningState.init();
    }

    static /* synthetic */ void access$200(AggregateFuture$RunningState aggregateFuture$RunningState, int n2, Future future) {
        aggregateFuture$RunningState.handleOneInputDone(n2, future);
    }

    static /* synthetic */ void access$300(AggregateFuture$RunningState aggregateFuture$RunningState) {
        aggregateFuture$RunningState.decrementCountAndMaybeComplete();
    }
}

