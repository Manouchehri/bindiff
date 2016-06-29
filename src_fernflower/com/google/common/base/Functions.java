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
   public static Function toStringFunction() {
      return Functions$ToStringFunction.INSTANCE;
   }

   public static Function identity() {
      return Functions$IdentityFunction.INSTANCE;
   }

   public static Function forMap(Map var0) {
      return new Functions$FunctionForMapNoDefault(var0);
   }

   public static Function forMap(Map var0, @Nullable Object var1) {
      return new Functions$ForMapWithDefault(var0, var1);
   }

   public static Function compose(Function var0, Function var1) {
      return new Functions$FunctionComposition(var0, var1);
   }

   public static Function forPredicate(Predicate var0) {
      return new Functions$PredicateFunction(var0, (Functions$1)null);
   }

   public static Function constant(@Nullable Object var0) {
      return new Functions$ConstantFunction(var0);
   }

   @Beta
   public static Function forSupplier(Supplier var0) {
      return new Functions$SupplierFunction(var0, (Functions$1)null);
   }
}
