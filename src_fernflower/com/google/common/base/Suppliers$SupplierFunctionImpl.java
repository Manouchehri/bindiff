package com.google.common.base;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers$SupplierFunction;

enum Suppliers$SupplierFunctionImpl implements Suppliers$SupplierFunction {
   INSTANCE;

   public Object apply(Supplier var1) {
      return var1.get();
   }

   public String toString() {
      return "Suppliers.supplierFunction()";
   }
}
