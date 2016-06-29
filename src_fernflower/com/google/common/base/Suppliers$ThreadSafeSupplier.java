package com.google.common.base;

import com.google.common.base.Supplier;
import java.io.Serializable;

class Suppliers$ThreadSafeSupplier implements Supplier, Serializable {
   final Supplier delegate;
   private static final long serialVersionUID = 0L;

   Suppliers$ThreadSafeSupplier(Supplier var1) {
      this.delegate = var1;
   }

   public Object get() {
      Supplier var1 = this.delegate;
      synchronized(this.delegate) {
         return this.delegate.get();
      }
   }

   public String toString() {
      String var1 = String.valueOf(this.delegate);
      return (new StringBuilder(32 + String.valueOf(var1).length())).append("Suppliers.synchronizedSupplier(").append(var1).append(")").toString();
   }
}
