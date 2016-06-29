package com.google.common.cache;

import javax.annotation.*;
import com.google.common.base.*;
import com.google.common.util.concurrent.*;
import java.util.concurrent.*;
import java.lang.ref.*;

class LocalCache$LoadingValueReference implements LocalCache$ValueReference
{
    volatile LocalCache$ValueReference oldValue;
    final SettableFuture futureValue;
    final Stopwatch stopwatch;
    
    public LocalCache$LoadingValueReference() {
        this(LocalCache.unset());
    }
    
    public LocalCache$LoadingValueReference(final LocalCache$ValueReference oldValue) {
        this.futureValue = SettableFuture.create();
        this.stopwatch = Stopwatch.createUnstarted();
        this.oldValue = oldValue;
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
    
    public boolean set(@Nullable final Object o) {
        return this.futureValue.set(o);
    }
    
    public boolean setException(final Throwable exception) {
        return this.futureValue.setException(exception);
    }
    
    private ListenableFuture fullyFailedFuture(final Throwable t) {
        return Futures.immediateFailedFuture(t);
    }
    
    @Override
    public void notifyNewValue(@Nullable final Object o) {
        if (o != null) {
            this.set(o);
        }
        else {
            this.oldValue = LocalCache.unset();
        }
    }
    
    public ListenableFuture loadFuture(final Object o, final CacheLoader cacheLoader) {
        try {
            this.stopwatch.start();
            final Object value = this.oldValue.get();
            if (value == null) {
                final Object load = cacheLoader.load(o);
                return this.set(load) ? this.futureValue : Futures.immediateFuture(load);
            }
            final ListenableFuture reload = cacheLoader.reload(o, value);
            if (reload == null) {
                return Futures.immediateFuture(null);
            }
            return Futures.transform(reload, new LocalCache$LoadingValueReference$1(this));
        }
        catch (Throwable exception) {
            final ListenableFuture listenableFuture = this.setException(exception) ? this.futureValue : this.fullyFailedFuture(exception);
            if (exception instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
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
    public LocalCache$ValueReference copyFor(final ReferenceQueue referenceQueue, @Nullable final Object o, final LocalCache$ReferenceEntry localCache$ReferenceEntry) {
        return this;
    }
}
