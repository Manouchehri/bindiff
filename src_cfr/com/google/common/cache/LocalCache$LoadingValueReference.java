/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.cache;

import com.google.common.base.Stopwatch;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LocalCache;
import com.google.common.cache.LocalCache$LoadingValueReference$1;
import com.google.common.cache.LocalCache$ReferenceEntry;
import com.google.common.cache.LocalCache$ValueReference;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.Uninterruptibles;
import java.lang.ref.ReferenceQueue;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

class LocalCache$LoadingValueReference
implements LocalCache$ValueReference {
    volatile LocalCache$ValueReference oldValue;
    final SettableFuture futureValue = SettableFuture.create();
    final Stopwatch stopwatch = Stopwatch.createUnstarted();

    public LocalCache$LoadingValueReference() {
        this(LocalCache.unset());
    }

    public LocalCache$LoadingValueReference(LocalCache$ValueReference localCache$ValueReference) {
        this.oldValue = localCache$ValueReference;
    }

    @Override
    public boolean isLoading() {
        return true;
    }

    @Override
    public boolean isActive() {
        return this.oldValue.isActive();
    }

    @Override
    public int getWeight() {
        return this.oldValue.getWeight();
    }

    public boolean set(@Nullable Object object) {
        return this.futureValue.set(object);
    }

    public boolean setException(Throwable throwable) {
        return this.futureValue.setException(throwable);
    }

    private ListenableFuture fullyFailedFuture(Throwable throwable) {
        return Futures.immediateFailedFuture(throwable);
    }

    @Override
    public void notifyNewValue(@Nullable Object object) {
        if (object != null) {
            this.set(object);
            return;
        }
        this.oldValue = LocalCache.unset();
    }

    public ListenableFuture loadFuture(Object object, CacheLoader cacheLoader) {
        try {
            SettableFuture settableFuture /* !! */ ;
            this.stopwatch.start();
            Object object2 = this.oldValue.get();
            if (object2 != null) {
                ListenableFuture listenableFuture = cacheLoader.reload(object, object2);
                if (listenableFuture != null) return Futures.transform(listenableFuture, new LocalCache$LoadingValueReference$1(this));
                return Futures.immediateFuture(null);
            }
            Object object3 = cacheLoader.load(object);
            if (this.set(object3)) {
                settableFuture /* !! */  = this.futureValue;
                return settableFuture /* !! */ ;
            }
            settableFuture /* !! */  = Futures.immediateFuture(object3);
            return settableFuture /* !! */ ;
        }
        catch (Throwable var3_4) {
            ListenableFuture listenableFuture = this.setException(var3_4) ? this.futureValue : this.fullyFailedFuture(var3_4);
            if (!(var3_4 instanceof InterruptedException)) return listenableFuture;
            Thread.currentThread().interrupt();
            return listenableFuture;
        }
    }

    public long elapsedNanos() {
        return this.stopwatch.elapsed(TimeUnit.NANOSECONDS);
    }

    @Override
    public Object waitForValue() {
        return Uninterruptibles.getUninterruptibly(this.futureValue);
    }

    @Override
    public Object get() {
        return this.oldValue.get();
    }

    public LocalCache$ValueReference getOldValue() {
        return this.oldValue;
    }

    @Override
    public LocalCache$ReferenceEntry getEntry() {
        return null;
    }

    @Override
    public LocalCache$ValueReference copyFor(ReferenceQueue referenceQueue, @Nullable Object object, LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return this;
    }
}

