package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Functions$1;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import javax.annotation.Nullable;

class Functions$SupplierFunction implements Function, Serializable {
   private final Supplier supplier;
   private static final long serialVersionUID = 0L;

   private Functions$SupplierFunction(Supplier var1) {
      this.supplier = (Supplier)Preconditions.checkNotNull(var1);
   }

   public Object apply(@Nullable Object var1) {
      return this.supplier.get();
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Functions$SupplierFunction) {
         Functions$SupplierFunction var2 = (Functions$SupplierFunction)var1;
         return this.supplier.equals(var2.supplier);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return this.supplier.hashCode();
   }

   public String toString() {
      String var1 = String.valueOf(this.supplier);
      return (new StringBuilder(23 + String.valueOf(var1).length())).append("Functions.forSupplier(").append(var1).append(")").toString();
   }

   // $FF: synthetic method
   Functions$SupplierFunction(Supplier var1, Functions$1 var2) {
      this(var1);
   }
}
