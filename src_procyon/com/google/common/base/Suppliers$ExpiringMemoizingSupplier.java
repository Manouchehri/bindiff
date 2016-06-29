package com.google.common.base;

import java.io.*;
import com.google.common.annotations.*;
import java.util.concurrent.*;

@VisibleForTesting
class Suppliers$ExpiringMemoizingSupplier implements Supplier, Serializable
{
    final Supplier delegate;
    final long durationNanos;
    transient volatile Object value;
    transient volatile long expirationNanos;
    private static final long serialVersionUID = 0L;
    
    Suppliers$ExpiringMemoizingSupplier(final Supplier supplier, final long n, final TimeUnit timeUnit) {
        this.delegate = (Supplier)Preconditions.checkNotNull(supplier);
        this.durationNanos = timeUnit.toNanos(n);
        Preconditions.checkArgument(n > 0L);
    }
    
    @Override
    public Object get() {
        final long expirationNanos = this.expirationNanos;
        final long systemNanoTime = Platform.systemNanoTime();
        if (expirationNanos == 0L || systemNanoTime - expirationNanos >= 0L) {
            synchronized (this) {
                if (expirationNanos == this.expirationNanos) {
                    final Object value = this.delegate.get();
                    this.value = value;
                    final long n = systemNanoTime + this.durationNanos;
                    this.expirationNanos = ((n == 0L) ? 1L : n);
                    return value;
                }
            }
        }
        return this.value;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.delegate);
        return new StringBuilder(62 + String.valueOf(value).length()).append("Suppliers.memoizeWithExpiration(").append(value).append(", ").append(this.durationNanos).append(", NANOS)").toString();
    }
}
