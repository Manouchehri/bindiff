package com.google.common.cache;

import com.google.common.util.concurrent.*;
import javax.annotation.*;
import com.google.common.collect.*;

class ShimAsyncCache$PersistentQueue
{
    final ImmutableList futures;
    
    ShimAsyncCache$PersistentQueue(final ImmutableList futures) {
        this.futures = futures;
    }
    
    @CheckReturnValue
    ShimAsyncCache$PersistentQueue add(final ListenableFuture listenableFuture) {
        return new ShimAsyncCache$PersistentQueue(ImmutableList.builder().add(listenableFuture).addAll(this.futures).build());
    }
    
    @CheckReturnValue
    ShimAsyncCache$PersistentQueue retainNewer(final ListenableFuture listenableFuture) {
        final ImmutableList$Builder builder = ImmutableList.builder();
        for (final ListenableFuture listenableFuture2 : this.futures) {
            if (listenableFuture2 == listenableFuture) {
                return new ShimAsyncCache$PersistentQueue(builder.build());
            }
            builder.add(listenableFuture2);
        }
        return this;
    }
    
    @CheckReturnValue
    ShimAsyncCache$PersistentQueue remove(final ListenableFuture listenableFuture) {
        final ImmutableList$Builder builder = ImmutableList.builder();
        for (final ListenableFuture listenableFuture2 : this.futures) {
            if (!listenableFuture2.equals(listenableFuture)) {
                builder.add(listenableFuture2);
            }
        }
        return new ShimAsyncCache$PersistentQueue(builder.build());
    }
    
    int size() {
        return this.futures.size();
    }
    
    static ShimAsyncCache$PersistentQueue empty() {
        return new ShimAsyncCache$PersistentQueue(ImmutableList.of());
    }
}
