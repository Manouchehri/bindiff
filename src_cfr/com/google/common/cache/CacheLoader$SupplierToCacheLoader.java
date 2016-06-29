/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.cache.CacheLoader;
import java.io.Serializable;

final class CacheLoader$SupplierToCacheLoader
extends CacheLoader
implements Serializable {
    private final Supplier computingSupplier;
    private static final long serialVersionUID = 0;

    public CacheLoader$SupplierToCacheLoader(Supplier supplier) {
        this.computingSupplier = (Supplier)Preconditions.checkNotNull(supplier);
    }

    @Override
    public Object load(Object object) {
        Preconditions.checkNotNull(object);
        return this.computingSupplier.get();
    }
}

