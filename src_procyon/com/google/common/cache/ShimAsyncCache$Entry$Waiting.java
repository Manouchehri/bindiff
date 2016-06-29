package com.google.common.cache;

import javax.annotation.*;
import com.google.common.util.concurrent.*;
import java.util.concurrent.*;

class ShimAsyncCache$Entry$Waiting implements ShimAsyncCache$Entry$EntryState
{
    final ShimAsyncCache$PersistentQueue futures;
    final SettableFuture result;
    final /* synthetic */ ShimAsyncCache$Entry this$0;
    
    ShimAsyncCache$Entry$Waiting(final ShimAsyncCache$Entry this$0, final ShimAsyncCache$PersistentQueue futures, final SettableFuture result) {
        this.this$0 = this$0;
        this.futures = futures;
        this.result = result;
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
    public void maybeLoad(final ShimAsyncCache$LoadWhen shimAsyncCache$LoadWhen) {
        if (shimAsyncCache$LoadWhen == ShimAsyncCache$LoadWhen.ALWAYS || this.futures.size() == 0) {
            final SettableFuture create = SettableFuture.create();
            if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Waiting(this.this$0, this.futures.add(create), this.result))) {
                this.this$0.loadOrBatch(create);
            }
            else {
                this.this$0.state.get().maybeLoad(shimAsyncCache$LoadWhen);
            }
        }
    }
    
    @Override
    public void addFuture(final ListenableFuture listenableFuture) {
        if (!this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Waiting(this.this$0, this.futures.add(listenableFuture), this.result))) {
            this.this$0.state.get().addFuture(listenableFuture);
        }
    }
    
    @Override
    public void handleCompletion(final ListenableFuture listenableFuture) {
        try {
            final Object uninterruptibly = Uninterruptibles.getUninterruptibly(listenableFuture);
            if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Value(this.this$0, uninterruptibly, this.futures.retainNewer(listenableFuture)))) {
                this.this$0.refreshEntry();
                this.result.set(uninterruptibly);
            }
            else {
                this.this$0.state.get().handleCompletion(listenableFuture);
            }
        }
        catch (ExecutionException ex) {
            this.handleFailure(listenableFuture, ex.getCause());
        }
        catch (RuntimeException ex2) {
            this.handleFailure(listenableFuture, ex2);
        }
    }
    
    private void handleFailure(final ListenableFuture listenableFuture, final Throwable exception) {
        if (this.this$0.state.compareAndSet(this, new ShimAsyncCache$Entry$Waiting(this.this$0, this.futures.remove(listenableFuture), SettableFuture.create()))) {
            this.result.setException(exception);
        }
        else {
            this.this$0.state.get().handleCompletion(listenableFuture);
        }
    }
}
