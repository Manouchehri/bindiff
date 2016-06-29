package com.google.common.base;

import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Supplier;
import java.io.Serializable;
import javax.annotation.Nullable;

class Suppliers$SupplierComposition implements Supplier, Serializable {
   final Function function;
   final Supplier supplier;
   private static final long serialVersionUID = 0L;

   Suppliers$SupplierComposition(Function var1, Supplier var2) {
      this.function = var1;
      this.supplier = var2;
   }

   public Object get() {
      return this.function.apply(this.supplier.get());
   }

   public boolean equals(@Nullable Object var1) {
      if(!(var1 instanceof Suppliers$SupplierComposition)) {
         return false;
      } else {
         Suppliers$SupplierComposition var2 = (Suppliers$SupplierComposition)var1;
         return this.function.equals(var2.function) && this.supplier.equals(var2.supplier);
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.function, this.supplier});
   }

   public String toString() {
      String var1 = String.valueOf(this.function);
      String var2 = String.valueOf(this.supplier);
      return (new StringBuilder(21 + String.valueOf(var1).length() + String.valueOf(var2).length())).append("Suppliers.compose(").append(var1).append(", ").append(var2).append(")").toString();
   }
}
