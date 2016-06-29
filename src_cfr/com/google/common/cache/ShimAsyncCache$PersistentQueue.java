/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 */
package com.google.common.cache;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenableFuture;
import javax.annotation.CheckReturnValue;

class ShimAsyncCache$PersistentQueue {
    final ImmutableList futures;

    ShimAsyncCache$PersistentQueue(ImmutableList immutableList) {
        this.futures = immutableList;
    }

    @CheckReturnValue
    ShimAsyncCache$PersistentQueue add(ListenableFuture listenableFuture) {
        return new ShimAsyncCache$PersistentQueue(ImmutableList.builder().add((Object)listenableFuture).addAll(this.futures).build());
    }

    @CheckReturnValue
    ShimAsyncCache$PersistentQueue retainNewer(ListenableFuture listenableFuture) {
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        UnmodifiableIterator unmodifiableIterator = this.futures.iterator();
        while (unmodifiableIterator.hasNext()) {
            ListenableFuture listenableFuture2 = (ListenableFuture)unmodifiableIterator.next();
            if (listenableFuture2 == listenableFuture) {
                return new ShimAsyncCache$PersistentQueue(immutableList$Builder.build());
            }
            immutableList$Builder.add((Object)listenableFuture2);
        }
        return this;
    }

    @CheckReturnValue
    ShimAsyncCache$PersistentQueue remove(ListenableFuture listenableFuture) {
        ImmutableList$Builder immutableList$Builder = ImmutableList.builder();
        UnmodifiableIterator unmodifiableIterator = this.futures.iterator();
        while (unmodifiableIterator.hasNext()) {
            ListenableFuture listenableFuture2 = (ListenableFuture)unmodifiableIterator.next();
            if (listenableFuture2.equals(listenableFuture)) continue;
            immutableList$Builder.add((Object)listenableFuture2);
        }
        return new ShimAsyncCache$PersistentQueue(immutableList$Builder.build());
    }

    int size() {
        return this.futures.size();
    }

    static ShimAsyncCache$PersistentQueue empty() {
        return new ShimAsyncCache$PersistentQueue(ImmutableList.of());
    }
}

