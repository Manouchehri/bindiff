package com.google.common.collect;

import com.google.common.collect.SetMultimap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedMultimap;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSetMultimap extends Synchronized$SynchronizedMultimap implements SetMultimap {
   transient Set entrySet;
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedSetMultimap(SetMultimap var1, @Nullable Object var2) {
      super(var1, var2);
   }

   SetMultimap delegate() {
      return (SetMultimap)super.delegate();
   }

   public Set get(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.set(this.delegate().get(var1), this.mutex);
      }
   }

   public Set removeAll(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().removeAll(var1);
      }
   }

   public Set replaceValues(Object var1, Iterable var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().replaceValues(var1, var2);
      }
   }

   public Set entries() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.entrySet == null) {
            this.entrySet = Synchronized.set(this.delegate().entries(), this.mutex);
         }

         return this.entrySet;
      }
   }
}
