package com.google.common.collect;

import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSet extends Synchronized$SynchronizedCollection implements Set {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedSet(Set var1, @Nullable Object var2) {
      super(var1, var2, (Synchronized$1)null);
   }

   Set delegate() {
      return (Set)super.delegate();
   }

   public boolean equals(Object var1) {
      if(var1 == this) {
         return true;
      } else {
         Object var2 = this.mutex;
         synchronized(this.mutex) {
            return this.delegate().equals(var1);
         }
      }
   }

   public int hashCode() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().hashCode();
      }
   }
}
