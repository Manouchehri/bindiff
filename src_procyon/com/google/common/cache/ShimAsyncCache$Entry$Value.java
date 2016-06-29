package com.google.common.cache;

import javax.annotation.*;
import com.google.common.util.concurrent.*;
import java.util.concurrent.*;

class ShimAsyncCache$Entry$Value implements ShimAsyncCache$Entry$EntryState
{
    final Object value;
    final ShimAsyncCache$PersistentQueue futures;
    final /* synthetic */ ShimAsyncCache$Entry this$0;
    
    ShimAsyncCache$Entry$Value(final ShimAsyncCache$Entry this$0, final Object value, final ShimAsyncCache$PersistentQueue futures) {
        this.this$0 = this$0;
        this.value = value;
        this.futures = futures;
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
    public void maybeLoad(final ShimAsyncCache$LoadWhen shimAsyncCache$LoadWhen) {
        if (shimAsyncCache$LoadWhen == ShimAsyncCache$LoadWhen.ALWAYS) {
            final SettableFuture create = SettableFuture.create();
            if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, this.value, this.futures.add(create)))) {
                this.this$0.loadOrBatch(create);
            }
            else {
                this.this$0.state.get().maybeLoad(shimAsyncCache$LoadWhen);
            }
        }
    }
    
    @Override
    public void addFuture(final ListenableFuture listenableFuture) {
        if (!this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, this.value, this.futures.add(listenableFuture)))) {
            this.this$0.state.get().addFuture(listenableFuture);
        }
    }
    
    @Override
    public void handleCompletion(final ListenableFuture listenableFuture) {
        Object o = this.value;
        boolean b = false;
        ShimAsyncCache$PersistentQueue shimAsyncCache$PersistentQueue;
        try {
            o = Uninterruptibles.getUninterruptibly(listenableFuture);
            b = true;
            shimAsyncCache$PersistentQueue = this.futures.retainNewer(listenableFuture);
        }
        catch (ExecutionException ex) {
            shimAsyncCache$PersistentQueue = this.futures.remove(listenableFuture);
        }
        catch (RuntimeException ex2) {
            shimAsyncCache$PersistentQueue = this.futures.remove(listenableFuture);
        }
        if (shimAsyncCache$PersistentQueue.size() == this.futures.size()) {
            return;
        }
        if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, o, shimAsyncCache$PersistentQueue))) {
            if (b) {
                this.this$0.refreshEntry();
            }
        }
        else {
            this.this$0.state.get().handleCompletion(listenableFuture);
        }
    }
}
