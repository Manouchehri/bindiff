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
import com.google.common.base.Functions$1;
import com.google.common.base.Functions$ConstantFunction;
import com.google.common.base.Functions$ForMapWithDefault;
import com.google.common.base.Functions$FunctionComposition;
import com.google.common.base.Functions$FunctionForMapNoDefault;
import com.google.common.base.Functions$IdentityFunction;
import com.google.common.base.Functions$PredicateFunction;
import com.google.common.base.Functions$SupplierFunction;
import com.google.common.base.Functions$ToStringFunction;
import com.google.common.base.Predicate;
import com.google.common.base.Supplier;
import java.util.Map;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
@GwtCompatible
public final class Functions {
    private Functions() {
    }

    public static Function toStringFunction() {
        return Functions$ToStringFunction.INSTANCE;
    }

    public static Function identity() {
        return Functions$IdentityFunction.INSTANCE;
    }

    public static Function forMap(Map map) {
        return new Functions$FunctionForMapNoDefault(map);
    }

    public static Function forMap(Map map, @Nullable Object object) {
        return new Functions$ForMapWithDefault(map, object);
    }

    public static Function compose(Function function, Function function2) {
        return new Functions$FunctionComposition(function, function2);
    }

    public static Function forPredicate(Predicate predicate) {
        return new Functions$PredicateFunction(predicate, null);
    }

    public static Function constant(@Nullable Object object) {
        return new Functions$ConstantFunction(object);
    }

    @Beta
    public static Function forSupplier(Supplier supplier) {
        return new Functions$SupplierFunction(supplier, null);
    }
}

