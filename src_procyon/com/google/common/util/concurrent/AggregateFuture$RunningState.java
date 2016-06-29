package com.google.common.util.concurrent;

import com.google.common.base.*;
import com.google.common.collect.*;
import java.util.*;
import java.util.concurrent.*;
import javax.annotation.*;
import java.util.logging.*;
import com.google.common.annotations.*;

abstract class AggregateFuture$RunningState extends AggregateFutureState implements Runnable
{
    private ImmutableCollection futures;
    private final boolean allMustSucceed;
    private final boolean collectsValues;
    final /* synthetic */ AggregateFuture this$0;
    
    AggregateFuture$RunningState(final AggregateFuture this$0, final ImmutableCollection collection, final boolean allMustSucceed, final boolean collectsValues) {
        this.this$0 = this$0;
        super(collection.size());
        this.futures = (ImmutableCollection)Preconditions.checkNotNull(collection);
        this.allMustSucceed = allMustSucceed;
        this.collectsValues = collectsValues;
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
            int n = 0;
            for (final ListenableFuture listenableFuture : this.futures) {
                listenableFuture.addListener(new AggregateFuture$RunningState$1(this, n++, listenableFuture), MoreExecutors.directExecutor());
            }
        }
        else {
            final UnmodifiableIterator iterator2 = this.futures.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().addListener(this, MoreExecutors.directExecutor());
            }
        }
    }
    
    private void handleException(final Throwable exception) {
        Preconditions.checkNotNull(exception);
        boolean setException = false;
        boolean access$400 = true;
        if (this.allMustSucceed) {
            setException = this.this$0.setException(exception);
            if (setException) {
                this.releaseResourcesAfterFailure();
            }
            else {
                access$400 = addCausalChain(this.getOrInitSeenExceptions(), exception);
            }
        }
        if (exception instanceof Error | (this.allMustSucceed & !setException & access$400)) {
            AggregateFuture.logger.log(Level.SEVERE, "input future failed.", exception);
        }
    }
    
    @Override
    final void addInitialException(final Set set) {
        if (!this.this$0.isCancelled()) {
            addCausalChain(set, this.this$0.trustedGetException());
        }
    }
    
    private void handleOneInputDone(final int n, final Future future) {
        Preconditions.checkState(this.allMustSucceed || !this.this$0.isDone() || this.this$0.isCancelled(), (Object)"Future was done before all dependencies completed");
        try {
            Preconditions.checkState(future.isDone(), (Object)"Tried to set value from future which is not done");
            if (this.allMustSucceed) {
                if (future.isCancelled()) {
                    this.this$0.cancel(false);
                }
                else {
                    final Object uninterruptibly = Uninterruptibles.getUninterruptibly(future);
                    if (this.collectsValues) {
                        this.collectOneValue(this.allMustSucceed, n, uninterruptibly);
                    }
                }
            }
            else if (this.collectsValues && !future.isCancelled()) {
                this.collectOneValue(this.allMustSucceed, n, Uninterruptibles.getUninterruptibly(future));
            }
        }
        catch (ExecutionException ex) {
            this.handleException(ex.getCause());
        }
        catch (Throwable t) {
            this.handleException(t);
        }
    }
    
    private void decrementCountAndMaybeComplete() {
        final int decrementRemainingAndGet = this.decrementRemainingAndGet();
        Preconditions.checkState(decrementRemainingAndGet >= 0, (Object)"Less than 0 remaining futures");
        if (decrementRemainingAndGet == 0) {
            this.processCompleted();
        }
    }
    
    private void processCompleted() {
        if (this.collectsValues & !this.allMustSucceed) {
            int n = 0;
            final UnmodifiableIterator iterator = this.futures.iterator();
            while (iterator.hasNext()) {
                this.handleOneInputDone(n++, iterator.next());
            }
        }
        this.handleAllCompleted();
    }
    
    void releaseResourcesAfterFailure() {
        this.futures = null;
    }
    
    abstract void collectOneValue(final boolean p0, final int p1, @Nullable final Object p2);
    
    abstract void handleAllCompleted();
    
    void interruptTask() {
    }
}
