package com.google.common.base;

import java.io.*;
import javax.annotation.*;

class Suppliers$SupplierOfInstance implements Supplier, Serializable
{
    final Object instance;
    private static final long serialVersionUID = 0L;
    
    Suppliers$SupplierOfInstance(@Nullable final Object instance) {
        this.instance = instance;
    }
    
    @Override
    public Object get() {
        return this.instance;
    }
    
    @Override
    public boolean equals(@Nullable final Object o) {
        return o instanceof Suppliers$SupplierOfInstance && Objects.equal(this.instance, ((Suppliers$SupplierOfInstance)o).instance);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(this.instance);
    }
    
    @Override
    public String toString() {
        final String value = String.valueOf(this.instance);
        return new StringBuilder(22 + String.valueOf(value).length()).append("Suppliers.ofInstance(").append(value).append(")").toString();
    }
}
