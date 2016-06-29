package com.google.common.base;

import java.io.*;
import javax.annotation.*;

class Suppliers$SupplierComposition implements Supplier, Serializable
{
    final Function function;
    final Supplier supplier;
    private static final long serialVersionUID = 0L;
    
    Suppliers$SupplierComposition(final Function function, final Supplier supplier) {
        this.function = function;
        this.supplier = supplier;
    }
    
    @Override
    public Object get() {
        return this.function.apply(this.supplier.get());
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        if (o instanceof Suppliers$SupplierComposition) {
            final Suppliers$SupplierComposition suppliers$SupplierComposition = (Suppliers$SupplierComposition)o;
            return this.function.equals(suppliers$SupplierComposition.function) && this.supplier.equals(suppliers$SupplierComposition.supplier);
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.function, this.supplier);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.function);
        final String value2 = String.valueOf(this.supplier);
        return new StringBuilder(21 + String.valueOf(value).length() + String.valueOf(value2).length()).append("Suppliers.compose(").append(value).append(", ").append(value2).append(")").toString();
    }
}
