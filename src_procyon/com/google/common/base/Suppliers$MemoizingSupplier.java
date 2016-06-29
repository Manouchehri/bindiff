package com.google.common.base;

import java.io.*;
import com.google.common.annotations.*;

@VisibleForTesting
class Suppliers$MemoizingSupplier implements Supplier, Serializable
{
    final Supplier delegate;
    transient volatile boolean initialized;
    transient Object value;
    private static final long serialVersionUID = 0L;
    
    Suppliers$MemoizingSupplier(final Supplier delegate) {
        this.delegate = delegate;
    }
    
    @Override
    public Object get() {
        if (!this.initialized) {
            synchronized (this) {
                if (!this.initialized) {
                    final Object value = this.delegate.get();
                    this.value = value;
                    this.initialized = true;
                    return value;
                }
            }
        }
        return this.value;
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.delegate);
        return new StringBuilder(19 + String.valueOf(value).length()).append("Suppliers.memoize(").append(value).append(")").toString();
    }
}
