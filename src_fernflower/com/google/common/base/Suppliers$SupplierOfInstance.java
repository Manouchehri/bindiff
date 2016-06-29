package com.google.common.base;

import com.google.common.base.Objects;
import com.google.common.base.Supplier;
import java.io.Serializable;
import javax.annotation.Nullable;

class Suppliers$SupplierOfInstance implements Supplier, Serializable {
   final Object instance;
   private static final long serialVersionUID = 0L;

   Suppliers$SupplierOfInstance(@Nullable Object var1) {
      this.instance = var1;
   }

   public Object get() {
      return this.instance;
   }

   public boolean equals(@Nullable Object var1) {
      if(var1 instanceof Suppliers$SupplierOfInstance) {
         Suppliers$SupplierOfInstance var2 = (Suppliers$SupplierOfInstance)var1;
         return Objects.equal(this.instance, var2.instance);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hashCode(new Object[]{this.instance});
   }

   public String toString() {
      String var1 = String.valueOf(this.instance);
      return (new StringBuilder(22 + String.valueOf(var1).length())).append("Suppliers.ofInstance(").append(var1).append(")").toString();
   }
}
