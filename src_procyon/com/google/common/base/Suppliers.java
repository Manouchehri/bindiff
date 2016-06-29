package com.google.common.base;

import java.util.concurrent.*;
import javax.annotation.*;
import com.google.common.annotations.*;

@CheckReturnValue
@GwtCompatible
public final class Suppliers
{
    public static Supplier compose(final Function function, final Supplier supplier) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(supplier);
        return new Suppliers$SupplierComposition(function, supplier);
    }
    
    public static Supplier memoize(final Supplier supplier) {
        return (supplier instanceof Suppliers$MemoizingSupplier) ? supplier : new Suppliers$MemoizingSupplier((Supplier)Preconditions.checkNotNull(supplier));
    }
    
    public static Supplier memoizeWithExpiration(final Supplier supplier, final long n, final TimeUnit timeUnit) {
        return new Suppliers$ExpiringMemoizingSupplier(supplier, n, timeUnit);
    }
    
    public static Supplier ofInstance(@Nullable final Object o) {
        return new Suppliers$SupplierOfInstance(o);
    }
    
    public static Supplier synchronizedSupplier(final Supplier supplier) {
        return new Suppliers$ThreadSafeSupplier((Supplier)Preconditions.checkNotNull(supplier));
    }
    
    @Beta
    public static Function supplierFunction() {
        return Suppliers$SupplierFunctionImpl.INSTANCE;
    }
}
