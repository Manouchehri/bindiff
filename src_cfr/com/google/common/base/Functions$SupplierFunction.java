/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Functions$1;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$SupplierFunction
implements Function,
Serializable {
    private final Supplier supplier;
    private static final long serialVersionUID = 0;

    private Functions$SupplierFunction(Supplier supplier) {
        this.supplier = (Supplier)Preconditions.checkNotNull(supplier);
    }

    @Override
    public Object apply(@Nullable Object object) {
        return this.supplier.get();
    }

    @Override
    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Functions$SupplierFunction)) return false;
        Functions$SupplierFunction functions$SupplierFunction = (Functions$SupplierFunction)object;
        return this.supplier.equals(functions$SupplierFunction.supplier);
    }

    public int hashCode() {
        return this.supplier.hashCode();
    }

    public String toString() {
        String string = String.valueOf(this.supplier);
        return new StringBuilder(23 + String.valueOf(string).length()).append("Functions.forSupplier(").append(string).append(")").toString();
    }

    /* synthetic */ Functions$SupplierFunction(Supplier supplier, Functions$1 functions$1) {
        this(supplier);
    }
}

