/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
class Suppliers$ExpiringMemoizingSupplier
implements Supplier,
Serializable {
    final Supplier delegate;
    final long durationNanos;
    volatile transient Object value;
    volatile transient long expirationNanos;
    private static final long serialVersionUID = 0;

    Suppliers$ExpiringMemoizingSupplier(Supplier supplier, long l2, TimeUnit timeUnit) {
        this.delegate = (Supplier)Preconditions.checkNotNull(supplier);
        this.durationNanos = timeUnit.toNanos(l2);
        Preconditions.checkArgument(l2 > 0);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object get() {
        long l2 = this.expirationNanos;
        long l3 = Platform.systemNanoTime();
        if (l2 != 0) {
            if (l3 - l2 < 0) return this.value;
        }
        Suppliers$ExpiringMemoizingSupplier suppliers$ExpiringMemoizingSupplier = this;
        synchronized (suppliers$ExpiringMemoizingSupplier) {
            Object object;
            if (l2 != this.expirationNanos) return this.value;
            this.value = object = this.delegate.get();
            l2 = l3 + this.durationNanos;
            this.expirationNanos = l2 == 0 ? 1 : l2;
            return object;
        }
    }

    public String toString() {
        String string = String.valueOf(this.delegate);
        long l2 = this.durationNanos;
        return new StringBuilder(62 + String.valueOf(string).length()).append("Suppliers.memoizeWithExpiration(").append(string).append(", ").append(l2).append(", NANOS)").toString();
    }
}

