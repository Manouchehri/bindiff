package com.google.common.collect;

import com.google.common.collect.ListMultimap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedMultimap;
import java.util.List;
import javax.annotation.Nullable;

class Synchronized$SynchronizedListMultimap extends Synchronized$SynchronizedMultimap implements ListMultimap {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedListMultimap(ListMultimap var1, @Nullable Object var2) {
      super(var1, var2);
   }

   ListMultimap delegate() {
      return (ListMultimap)super.delegate();
   }

   public List get(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$200(this.delegate().get(var1), this.mutex);
      }
   }

   public List removeAll(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().removeAll(var1);
      }
   }

   public List replaceValues(Object var1, Iterable var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().replaceValues(var1, var2);
      }
   }
}
