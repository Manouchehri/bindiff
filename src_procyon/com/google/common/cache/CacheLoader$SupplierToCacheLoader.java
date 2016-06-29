package com.google.common.cache;

import java.io.*;
import com.google.common.base.*;

final class CacheLoader$SupplierToCacheLoader extends CacheLoader implements Serializable
{
    private final Supplier computingSupplier;
    private static final long serialVersionUID = 0L;
    
    public CacheLoader$SupplierToCacheLoader(final Supplier supplier) {
        this.computingSupplier = (Supplier)Preconditions.checkNotNull(supplier);
    }
    
    @Override
    public Object load(final Object o) {
        Preconditions.checkNotNull(o);
        return this.computingSupplier.get();
    }
}
