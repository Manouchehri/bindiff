package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedSortedSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableSet")
@VisibleForTesting
class Synchronized$SynchronizedNavigableSet extends Synchronized$SynchronizedSortedSet implements NavigableSet {
   transient NavigableSet descendingSet;
   private static final long serialVersionUID = 0L;

   Synchronized$SynchronizedNavigableSet(NavigableSet var1, @Nullable Object var2) {
      super(var1, var2);
   }

   NavigableSet delegate() {
      return (NavigableSet)super.delegate();
   }

   public Object ceiling(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().ceiling(var1);
      }
   }

   public Iterator descendingIterator() {
      return this.delegate().descendingIterator();
   }

   public NavigableSet descendingSet() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         if(this.descendingSet == null) {
            NavigableSet var2 = Synchronized.navigableSet(this.delegate().descendingSet(), this.mutex);
            this.descendingSet = var2;
            return var2;
         } else {
            return this.descendingSet;
         }
      }
   }

   public Object floor(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().floor(var1);
      }
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.navigableSet(this.delegate().headSet(var1, var2), this.mutex);
      }
   }

   public Object higher(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().higher(var1);
      }
   }

   public Object lower(Object var1) {
      Object var2 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().lower(var1);
      }
   }

   public Object pollFirst() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().pollFirst();
      }
   }

   public Object pollLast() {
      Object var1 = this.mutex;
      synchronized(this.mutex) {
         return this.delegate().pollLast();
      }
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      Object var5 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.navigableSet(this.delegate().subSet(var1, var2, var3, var4), this.mutex);
      }
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      Object var3 = this.mutex;
      synchronized(this.mutex) {
         return Synchronized.navigableSet(this.delegate().tailSet(var1, var2), this.mutex);
      }
   }

   public SortedSet headSet(Object var1) {
      return this.headSet(var1, false);
   }

   public SortedSet subSet(Object var1, Object var2) {
      return this.subSet(var1, true, var2, false);
   }

   public SortedSet tailSet(Object var1) {
      return this.tailSet(var1, true);
   }
}
