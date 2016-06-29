/*
 * Decompiled with CFR 0_115.
 * 
 * Could not load the following classes:
 *  javax.annotation.CheckReturnValue
 *  javax.annotation.Nullable
 */
package com.google.common.base;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers$ExpiringMemoizingSupplier;
import com.google.common.base.Suppliers$MemoizingSupplier;
import com.google.common.base.Suppliers$SupplierComposition;
import com.google.common.base.Suppliers$SupplierFunctionImpl;
import com.google.common.base.Suppliers$SupplierOfInstance;
import com.google.common.base.Suppliers$ThreadSafeSupplier;
import java.util.concurrent.TimeUnit;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Suppliers {
    private Suppliers() {
    }

    public static Supplier compose(Function function, Supplier supplier) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(supplier);
        return new Suppliers$SupplierComposition(function, supplier);
    }

    public static Supplier memoize(Supplier supplier) {
        Supplier supplier2;
        if (supplier instanceof Suppliers$MemoizingSupplier) {
            supplier2 = supplier;
            return supplier2;
        }
        supplier2 = new Suppliers$MemoizingSupplier((Supplier)Preconditions.checkNotNull(supplier));
        return supplier2;
    }

    public static Supplier memoizeWithExpiration(Supplier supplier, long l2, TimeUnit timeUnit) {
        return new Suppliers$ExpiringMemoizingSupplier(supplier, l2, timeUnit);
    }

    public static Supplier ofInstance(@Nullable Object object) {
        return new Suppliers$SupplierOfInstance(object);
    }

    public static Supplier synchronizedSupplier(Supplier supplier) {
        return new Suppliers$ThreadSafeSupplier((Supplier)Preconditions.checkNotNull(supplier));
    }

    @Beta
    public static Function supplierFunction() {
        return Suppliers$SupplierFunctionImpl.INSTANCE;
    }
}

