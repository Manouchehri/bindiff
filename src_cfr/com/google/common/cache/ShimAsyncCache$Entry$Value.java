/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.cache.ShimAsyncCache$Entry;
import com.google.common.cache.ShimAsyncCache$Entry$EntryState;
import com.google.common.cache.ShimAsyncCache$LoadWhen;
import com.google.common.cache.ShimAsyncCache$PersistentQueue;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.Nullable;

class ShimAsyncCache$Entry$Value
implements ShimAsyncCache$Entry$EntryState {
    final Object value;
    final ShimAsyncCache$PersistentQueue futures;
    final /* synthetic */ ShimAsyncCache$Entry this$0;

    ShimAsyncCache$Entry$Value(ShimAsyncCache$Entry shimAsyncCache$Entry, Object object, ShimAsyncCache$PersistentQueue persistentQueue) {
        this.this$0 = shimAsyncCache$Entry;
        this.value = object;
        this.futures = persistentQueue;
    }

    @Override
    public ListenableFuture getOrLoadFuture() {
        return Futures.immediateFuture(this.value);
    }

    @Nullable
    @Override
    public Object getIfPresent() {
        return this.value;
    }

    @Override
    public void maybeLoad(ShimAsyncCache$LoadWhen shimAsyncCache$LoadWhen) {
        if (shimAsyncCache$LoadWhen != ShimAsyncCache$LoadWhen.ALWAYS) return;
        SettableFuture settableFuture = SettableFuture.create();
        if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, this.value, this.futures.add(settableFuture)))) {
            this.this$0.loadOrBatch(settableFuture);
            return;
        }
        ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).maybeLoad(shimAsyncCache$LoadWhen);
    }

    @Override
    public void addFuture(ListenableFuture listenableFuture) {
        if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, this.value, this.futures.add(listenableFuture)))) return;
        ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).addFuture(listenableFuture);
    }

    @Override
    public void handleCompletion(ListenableFuture listenableFuture) {
        ShimAsyncCache$PersistentQueue shimAsyncCache$PersistentQueue;
        Object object = this.value;
        boolean bl2 = false;
        try {
            object = Uninterruptibles.getUninterruptibly(listenableFuture);
            bl2 = true;
            shimAsyncCache$PersistentQueue = this.futures.retainNewer(listenableFuture);
        }
        catch (ExecutionException var5_5) {
            shimAsyncCache$PersistentQueue = this.futures.remove(listenableFuture);
        }
        catch (RuntimeException var5_6) {
            shimAsyncCache$PersistentQueue = this.futures.remove(listenableFuture);
        }
        if (shimAsyncCache$PersistentQueue.size() == this.futures.size()) {
            return;
        }
        if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, object, shimAsyncCache$PersistentQueue))) {
            if (!bl2) return;
            this.this$0.refreshEntry();
            return;
        }
        ((ShimAsyncCache$Entry$EntryState)this.this$0.state.get()).handleCompletion(listenableFuture);
    }
}

