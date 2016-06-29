package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedSortedMap;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
@VisibleForTesting
class Synchronized$SynchronizedNavigableMap extends Synchronized$SynchronizedSortedMap implements NavigableMap {
   transient NavigableSet descendingKeySet;
   transient NavigableMap descendingMap;
   transient NavigableSet navigableKeySet;
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedNavigableMap(NavigableMap var1, @Nullable Object var2) {
      super(var1, var2);
   }

   NavigableMap delegate() {
      return (NavigableMap)super.delegate();
   }

   public Entry ceilingEntry(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$700(this.delegate().ceilingEntry(var1), this.mutex);
      }
   }

   public Object ceilingKey(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().ceilingKey(var1);
      }
   }

   public NavigableSet descendingKeySet() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.descendingKeySet == null?(this.descendingKeySet = Synchronized.navigableSet(this.delegate().descendingKeySet(), this.mutex)):this.descendingKeySet;
      }
   }

   public NavigableMap descendingMap() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.descendingMap == null?(this.descendingMap = Synchronized.navigableMap(this.delegate().descendingMap(), this.mutex)):this.descendingMap;
      }
   }

   public Entry firstEntry() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$700(this.delegate().firstEntry(), this.mutex);
      }
   }

   public Entry floorEntry(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$700(this.delegate().floorEntry(var1), this.mutex);
      }
   }

   public Object floorKey(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().floorKey(var1);
      }
   }

   public NavigableMap headMap(Object var1, boolean var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.navigableMap(this.delegate().headMap(var1, var2), this.mutex);
      }
   }

   public Entry higherEntry(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$700(this.delegate().higherEntry(var1), this.mutex);
      }
   }

   public Object higherKey(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().higherKey(var1);
      }
   }

   public Entry lastEntry() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$700(this.delegate().lastEntry(), this.mutex);
      }
   }

   public Entry lowerEntry(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$700(this.delegate().lowerEntry(var1), this.mutex);
      }
   }

   public Object lowerKey(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().lowerKey(var1);
      }
   }

   public Set keySet() {
      return this.navigableKeySet();
   }

   public NavigableSet navigableKeySet() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.navigableKeySet == null?(this.navigableKeySet = Synchronized.navigableSet(this.delegate().navigableKeySet(), this.mutex)):this.navigableKeySet;
      }
   }

   public Entry pollFirstEntry() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$700(this.delegate().pollFirstEntry(), this.mutex);
      }
   }

   public Entry pollLastEntry() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.access$700(this.delegate().pollLastEntry(), this.mutex);
      }
   }

   public NavigableMap subMap(Object var1, boolean var2, Object var3, boolean var4) {
      Object var5 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.navigableMap(this.delegate().subMap(var1, var2, var3, var4), this.mutex);
      }
   }

   public NavigableMap tailMap(Object var1, boolean var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.navigableMap(this.delegate().tailMap(var1, var2), this.mutex);
      }
   }

   public SortedMap headMap(Object var1) {
      return this.headMap(var1, false);
   }

   public SortedMap subMap(Object var1, Object var2) {
      return this.subMap(var1, true, var2, false);
   }

   public SortedMap tailMap(Object var1) {
      return this.tailMap(var1, true);
   }
}
