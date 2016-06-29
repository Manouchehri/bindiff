package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedSet;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSortedSet extends Synchronized$SynchronizedSet implements SortedSet {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedSortedSet(SortedSet var1, @Nullable Object var2) {
      super(var1, var2);
   }

   SortedSet delegate() {
      return (SortedSet)super.delegate();
   }

   public Comparator comparator() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().comparator();
      }
   }

   public SortedSet subSet(Object var1, Object var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$100(this.delegate().subSet(var1, var2), this.mutex);
      }
   }

   public SortedSet headSet(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$100(this.delegate().headSet(var1), this.mutex);
      }
   }

   public SortedSet tailSet(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$100(this.delegate().tailSet(var1), this.mutex);
      }
   }

   public Object first() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().first();
      }
   }

   public Object last() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().last();
      }
   }
}
