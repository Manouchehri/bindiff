package com.google.common.base;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Platform;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;

@VisibleForTesting
class Suppliers$ExpiringMemoizingSupplier implements Supplier, Serializable {
   final Supplier delegate;
   final long durationNanos;
   transient volatile Object value;
   transient volatile long expirationNanos;
   private static final long serialVersionUID = 0L;

   Suppliers$ExpiringMemoizingSupplier(Supplier var1, long var2, TimeUnit var4) {
      this.delegate = (Supplier)Preconditions.checkNotNull(var1);
      this.durationNanos = var4.toNanos(var2);
      Preconditions.checkArgument(var2 > 0L);
   }

   public Object get() {
      long var1 = this.expirationNanos;
      long var3 = Platform.systemNanoTime();
      if(var1 == 0L || var3 - var1 >= 0L) {
         synchronized(this) {
            if(var1 == this.expirationNanos) {
               Object var6 = this.delegate.get();
               this.value = var6;
               var1 = var3 + this.durationNanos;
               this.expirationNanos = var1 == 0L?1L:var1;
               return var6;
            }
         }
      }

      return this.value;
   }

   public String toString() {
      String var1 = String.valueOf(this.delegate);
      long var2 = this.durationNanos;
      return (new StringBuilder(62 + String.valueOf(var1).length())).append("Suppliers.memoizeWithExpiration(").append(var1).append(", ").append(var2).append(", NANOS)").toString();
   }
}
