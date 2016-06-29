package com.google.common.collect;

import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedSetMultimap;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSortedSetMultimap extends Synchronized$SynchronizedSetMultimap implements SortedSetMultimap {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedSortedSetMultimap(SortedSetMultimap var1, @Nullable Object var2) {
      super(var1, var2);
   }

   SortedSetMultimap delegate() {
      return (SortedSetMultimap)super.delegate();
   }

   public SortedSet get(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$100(this.delegate().get(var1), this.mutex);
      }
   }

   public SortedSet removeAll(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().removeAll(var1);
      }
   }

   public SortedSet replaceValues(Object var1, Iterable var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().replaceValues(var1, var2);
      }
   }

   public Comparator valueComparator() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().valueComparator();
      }
   }
}
