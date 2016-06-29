/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.base.Objects;
import com.google.common.base.Supplier;
import java.io.Serializable;
import javax.annotation.Nullable;

class Suppliers$SupplierOfInstance
implements Supplier,
Serializable {
    final Object instance;
    private static final long serialVersionUID = 0;

    Suppliers$SupplierOfInstance(@Nullable Object object) {
        this.instance = object;
    }

    @Override
    public Object get() {
        return this.instance;
    }

    public boolean equals(@Nullable Object object) {
        if (!(object instanceof Suppliers$SupplierOfInstance)) return false;
        Suppliers$SupplierOfInstance suppliers$SupplierOfInstance = (Suppliers$SupplierOfInstance)object;
        return Objects.equal(this.instance, suppliers$SupplierOfInstance.instance);
    }

    public int hashCode() {
        return Objects.hashCode(this.instance);
    }

    public String toString() {
        String string = String.valueOf(this.instance);
        return new StringBuilder(22 + String.valueOf(string).length()).append("Suppliers.ofInstance(").append(string).append(")").toString();
    }
}

