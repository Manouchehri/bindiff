package com.google.common.base;

import java.util.*;
import javax.annotation.*;
import com.google.common.annotations.*;

@CheckReturnValue
@GwtCompatible
public final class Functions
{
    public static Function toStringFunction() {
        return Functions$ToStringFunction.INSTANCE;
    }
    
    public static Function identity() {
        return Functions$IdentityFunction.INSTANCE;
    }
    
    public static Function forMap(final Map map) {
        return new Functions$FunctionForMapNoDefault(map);
    }
    
    public static Function forMap(final Map map, @Nullable final Object o) {
        return new Functions$ForMapWithDefault(map, o);
    }
    
    public static Function compose(final Function function, final Function function2) {
        return new Functions$FunctionComposition(function, function2);
    }
    
    public static Function forPredicate(final Predicate predicate) {
        return new Functions$PredicateFunction(predicate, null);
    }
    
    public static Function constant(@Nullable final Object o) {
        return new Functions$ConstantFunction(o);
    }
    
    @Beta
    public static Function forSupplier(final Supplier supplier) {
        return new Functions$SupplierFunction(supplier, null);
    }
}
