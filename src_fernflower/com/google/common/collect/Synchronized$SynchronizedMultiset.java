package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedMultiset extends Synchronized$SynchronizedCollection implements Multiset {
   transient Set elementSet;
   transient Set entrySet;
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedMultiset(Multiset var1, @Nullable Object var2) {
      super(var1, var2, (Synchronized$1)null);
   }

   Multiset delegate() {
      return (Multiset)super.delegate();
   }

   public int count(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().count(var1);
      }
   }

   public int add(Object var1, int var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().add(var1, var2);
      }
   }

   public int remove(Object var1, int var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().remove(var1, var2);
      }
   }

   public int setCount(Object var1, int var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().setCount(var1, var2);
      }
   }

   public boolean setCount(Object var1, int var2, int var3) {
      Object var4 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().setCount(var1, var2, var3);
      }
   }

   public Set elementSet() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.elementSet == null) {
            this.elementSet = Synchronized.access$300(this.delegate().elementSet(), this.mutex);
         }

         return this.elementSet;
      }
   }

   public Set entrySet() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.entrySet == null) {
            this.entrySet = Synchronized.access$300(this.delegate().entrySet(), this.mutex);
         }

         return this.entrySet;
      }
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
