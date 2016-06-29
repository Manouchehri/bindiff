package com.google.common.collect;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@VisibleForTesting
class Synchronized$SynchronizedCollection extends Synchronized$SynchronizedObject implements Collection {
   private static final long serialVersionUID = 0L;

   private Synchronized$SynchronizedCollection(Collection var1, @Nullable Object var2) {
      super(var1, var2);
   }

   Collection delegate() {
      return (Collection)super.delegate();
   }

   public boolean add(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().add(var1);
      }
   }

   public boolean addAll(Collection var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().addAll(var1);
      }
   }

   public void clear() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         this.delegate().clear();
      }
   }

   public boolean contains(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().contains(var1);
      }
   }

   public boolean containsAll(Collection var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().containsAll(var1);
      }
   }

   public boolean isEmpty() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().isEmpty();
      }
   }

   public Iterator iterator() {
      return this.delegate().iterator();
   }

   public boolean remove(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().remove(var1);
      }
   }

   public boolean removeAll(Collection var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().removeAll(var1);
      }
   }

   public boolean retainAll(Collection var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().retainAll(var1);
      }
   }

   public int size() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().size();
      }
   }

   public Object[] toArray() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().toArray();
      }
   }

   public Object[] toArray(Object[] var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().toArray(var1);
      }
   }

   // $FF: synthetic method
   Synchronized$SynchronizedCollection(Collection var1, Object var2, Synchronized$1 var3) {
      this(var1, var2);
   }
}
