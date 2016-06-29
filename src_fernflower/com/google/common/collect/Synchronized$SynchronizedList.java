package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.Nullable;

class Synchronized$SynchronizedList extends Synchronized$SynchronizedCollection implements List {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedList(List var1, @Nullable Object var2) {
      super(var1, var2, (Synchronized$1)null);
   }

   List delegate() {
      return (List)super.delegate();
   }

   public void add(int var1, Object var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         this.delegate().add(var1, var2);
      }
   }

   public boolean addAll(int var1, Collection var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().addAll(var1, var2);
      }
   }

   public Object get(int var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().get(var1);
      }
   }

   public int indexOf(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().indexOf(var1);
      }
   }

   public int lastIndexOf(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().lastIndexOf(var1);
      }
   }

   public ListIterator listIterator() {
      return this.delegate().listIterator();
   }

   public ListIterator listIterator(int var1) {
      return this.delegate().listIterator(var1);
   }

   public Object remove(int var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().remove(var1);
      }
   }

   public Object set(int var1, Object var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().set(var1, var2);
      }
   }

   public List subList(int var1, int var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$200(this.delegate().subList(var1, var2), this.mutex);
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
