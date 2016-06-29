package com.google.common.base;

import java.io.*;

class Suppliers$ThreadSafeSupplier implements Supplier, Serializable
{
    final Supplier delegate;
    private static final long serialVersionUID = 0L;
    
    Suppliers$ThreadSafeSupplier(final Supplier delegate) {
        this.delegate = delegate;
    }
    
    @Override
    public Object get() {
        synchronized (this.delegate) {
            return this.delegate.get();
        }
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.delegate);
        return new StringBuilder(32 + String.valueOf(value).length()).append("Suppliers.synchronizedSupplier(").append(value).append(")").toString();
    }
}
