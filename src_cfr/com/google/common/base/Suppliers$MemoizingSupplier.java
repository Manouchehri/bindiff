/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Supplier;
import java.io.Serializable;

@VisibleForTesting
class Suppliers$MemoizingSupplier
implements Supplier,
Serializable {
    final Supplier delegate;
    volatile transient boolean initialized;
    transient Object value;
    private static final long serialVersionUID = 0;

    Suppliers$MemoizingSupplier(Supplier supplier) {
        this.delegate = supplier;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object get() {
        if (this.initialized) return this.value;
        Suppliers$MemoizingSupplier suppliers$MemoizingSupplier = this;
        synchronized (suppliers$MemoizingSupplier) {
            Object object;
            if (this.initialized) return this.value;
            this.value = object = this.delegate.get();
            this.initialized = true;
            return object;
        }
    }

    public String toString() {
        String string = String.valueOf(this.delegate);
        return new StringBuilder(19 + String.valueOf(string).length()).append("Suppliers.memoize(").append(string).append(")").toString();
    }
}

