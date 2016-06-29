/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Supplier;
import java.io.Serializable;
import javax.annotation.Nullable;

class Suppliers$SupplierComposition
implements Supplier,
Serializable {
    final Function function;
    final Supplier supplier;
    private static final long serialVersionUID = 0;

    Suppliers$SupplierComposition(Function function, Supplier supplier) {
        this.function = function;
        this.supplier = supplier;
    }

    @Override
    public Object get() {
        return this.function.apply(this.supplier.get());
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Suppliers$SupplierComposition)) return false;
        Suppliers$SupplierComposition suppliers$SupplierComposition = (Suppliers$SupplierComposition)object;
        if (!this.function.equals(suppliers$SupplierComposition.function)) return false;
        if (!this.supplier.equals(suppliers$SupplierComposition.supplier)) return false;
        return true;
    }

    public int hashCode() {
        return Objects.hashCode(this.function, this.supplier);
    }

    public String toString() {
        String string = String.valueOf(this.function);
        String string2 = String.valueOf(this.supplier);
        return new StringBuilder(21 + String.valueOf(string).length() + String.valueOf(string2).length()).append("Suppliers.compose(").append(string).append(", ").append(string2).append(")").toString();
    }
}

