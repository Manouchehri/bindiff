/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Supplier;
import java.io.Serializable;

class Suppliers$ThreadSafeSupplier
implements Supplier,
Serializable {
    final Supplier delegate;
    private static final long serialVersionUID = 0;

    Suppliers$ThreadSafeSupplier(Supplier supplier) {
        this.delegate = supplier;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public Object get() {
        Supplier supplier = this.delegate;
        synchronized (supplier) {
            return this.delegate.get();
        }
    }

    public String toString() {
        String string = String.valueOf(this.delegate);
        return new StringBuilder(32 + String.valueOf(string).length()).append("Suppliers.synchronizedSupplier(").append(string).append(")").toString();
    }
}

