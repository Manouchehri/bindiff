/*
 * Decompiled with CFR 0_115.
 */
package com.google.common.base;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers$SupplierFunction;

enum Suppliers$SupplierFunctionImpl implements Suppliers$SupplierFunction
{
    INSTANCE;
    

    private Suppliers$SupplierFunctionImpl() {
    }

    public Object apply(Supplier supplier) {
        return supplier.get();
    }

    public String toString() {
        return "Suppliers.supplierFunction()";
    }
}

