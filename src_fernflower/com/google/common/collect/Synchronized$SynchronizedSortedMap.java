package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedMap;
import java.util.Comparator;
import java.util.SortedMap;
import javax.annotation.Nullable;

class Synchronized$SynchronizedSortedMap extends Synchronized$SynchronizedMap implements SortedMap {
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedSortedMap(SortedMap var1, @Nullable Object var2) {
      super(var1, var2);
   }

   SortedMap delegate() {
      return (SortedMap)super.delegate();
   }

   public Comparator comparator() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().comparator();
      }
   }

   public Object firstKey() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().firstKey();
      }
   }

   public SortedMap headMap(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.sortedMap(this.delegate().headMap(var1), this.mutex);
      }
   }

   public Object lastKey() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().lastKey();
      }
   }

   public SortedMap subMap(Object var1, Object var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.sortedMap(this.delegate().subMap(var1, var2), this.mutex);
      }
   }

   public SortedMap tailMap(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.sortedMap(this.delegate().tailMap(var1), this.mutex);
      }
   }
}
