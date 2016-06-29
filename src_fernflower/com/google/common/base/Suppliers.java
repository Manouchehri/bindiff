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
   public static Supplier compose(Function var0, Supplier var1) {
      Preconditions.checkNotNull(var0);
      Preconditions.checkNotNull(var1);
      return new Suppliers$SupplierComposition(var0, var1);
   }

   public static Supplier memoize(Supplier var0) {
      return (Supplier)(var0 instanceof Suppliers$MemoizingSupplier?var0:new Suppliers$MemoizingSupplier((Supplier)Preconditions.checkNotNull(var0)));
   }

   public static Supplier memoizeWithExpiration(Supplier var0, long var1, TimeUnit var3) {
      return new Suppliers$ExpiringMemoizingSupplier(var0, var1, var3);
   }

   public static Supplier ofInstance(@Nullable Object var0) {
      return new Suppliers$SupplierOfInstance(var0);
   }

   public static Supplier synchronizedSupplier(Supplier var0) {
      return new Suppliers$ThreadSafeSupplier((Supplier)Preconditions.checkNotNull(var0));
   }

   @Beta
   public static Function supplierFunction() {
      Suppliers$SupplierFunctionImpl var0 = Suppliers$SupplierFunctionImpl.INSTANCE;
      return var0;
   }
}
