package com.google.common.base;

import java.io.*;
import javax.annotation.*;

class Functions$SupplierFunction implements Function, Serializable
{
    private final Supplier supplier;
    private static final long serialVersionUID = 0L;
    
    private Functions$SupplierFunction(final Supplier supplier) {
        this.supplier = (Supplier)Preconditions.checkNotNull(supplier);
    }
    
    @Override
    public Object apply(@Nullable final Object o) {
        return this.supplier.get();
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Functions$SupplierFunction && this.supplier.equals(((Functions$SupplierFunction)o).supplier);
    }
    
    @Override
    public int hashCode() {
        return this.supplier.hashCode();
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.supplier);
        return new StringBuilder(23 + String.valueOf(value).length()).append("Functions.forSupplier(").append(value).append(")").toString();
    }
}
