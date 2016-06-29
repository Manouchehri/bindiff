/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.ShimAsyncCache$Entry;
import com.google.common.cache.ShimAsyncCache$Entry$EntryState;
import com.google.common.cache.ShimAsyncCache$Entry$Value;
import com.google.common.cache.ShimAsyncCache$LoadWhen;
import com.google.common.cache.ShimAsyncCache$PersistentQueue;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

class ShimAsyncCache$Entry$Waiting
implements ShimAsyncCache$Entry$EntryState {
    final ShimAsyncCache$PersistentQueue futures;
    final SettableFuture result;
    final /* synthetic */ ShimAsyncCache$Entry this$0;

    ShimAsyncCache$Entry$Waiting(ShimAsyncCache$Entry shimAsyncCache$Entry, ShimAsyncCache$PersistentQueue shimAsyncCache$PersistentQueue, SettableFuture settableFuture) {
        this.this$0 = shimAsyncCache$Entry;
        this.futures = shimAsyncCache$PersistentQueue;
        this.result = settableFuture;
    }

    @Override
    public ListenableFuture getOrLoadFuture() {
        this.maybeLoad(ShimAsyncCache$LoadWhen.NOT_PENDING_OR_AVAILABLE);
        return Futures.nonCancellationPropagating(this.result);
    }

    @Nullable
    @Override
    public Object getIfPresent() {
        return null;
    }

    @Override
    public void maybeLoad(ShimAsyncCache$LoadWhen shimAsyncCache$LoadWhen) {
        SettableFuture settableFuture;
        if (shimAsyncCache$LoadWhen != ShimAsyncCache$LoadWhen.ALWAYS) {
            if (this.futures.size() != 0) return;
        }
        if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Waiting(this.this$0, this.futures.add(settableFuture = SettableFuture.create()), this.result))) {
            this.this$0.loadOrBatch(settableFuture);
            return;
        }
        ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).maybeLoad(shimAsyncCache$LoadWhen);
    }

    @Override
    public void addFuture(ListenableFuture listenableFuture) {
        if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Waiting(this.this$0, this.futures.add(listenableFuture), this.result))) return;
        ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).addFuture(listenableFuture);
    }

    @Override
    public void handleCompletion(ListenableFuture listenableFuture) {
        try {
            Object object = Uninterruptibles.getUninterruptibly(listenableFuture);
            if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, object, this.futures.retainNewer(listenableFuture)))) {
                this.this$0.refreshEntry();
                this.result.set(object);
                return;
            }
            ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).handleCompletion(listenableFuture);
            return;
        }
        catch (ExecutionException var2_3) {
            this.handleFailure(listenableFuture, var2_3.getCause());
            return;
        }
        catch (RuntimeException var2_4) {
            this.handleFailure(listenableFuture, var2_4);
        }
    }

    private void handleFailure(ListenableFuture listenableFuture, Throwable throwable) {
        SettableFuture settableFuture = SettableFuture.create();
        if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Waiting(this.this$0, this.futures.remove(listenableFuture), settableFuture))) {
            this.result.setException(throwable);
            return;
        }
        ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).handleCompletion(listenableFuture);
    }
}

