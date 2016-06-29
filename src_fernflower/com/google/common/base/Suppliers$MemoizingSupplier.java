package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Supplier;
import java.io.Serializable;

@VisibleForTesting
class Suppliers$MemoizingSupplier implements Supplier, Serializable {
   final Supplier delegate;
   transient volatile boolean initialized;
   transient Object value;
   private static final long serialVersionUID = 0L;

   Suppliers$MemoizingSupplier(Supplier var1) {
      this.delegate = var1;
   }

   public Object get() {
      if(!this.initialized) {
         synchronized(this) {
            if(!this.initialized) {
               Object var2 = this.delegate.get();
               this.value = var2;
               this.initialized = true;
               return var2;
            }
         }
      }

      return this.value;
   }

   public String toString() {
      String var1 = String.valueOf(this.delegate);
      return (new StringBuilder(19 + String.valueOf(var1).length())).append("Suppliers.memoize(").append(var1).append(")").toString();
   }
}
