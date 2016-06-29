package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntrySortedMap$SortedKeySet;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class Maps$FilteredEntrySortedMap extends Maps$FilteredEntryMap implements SortedMap {
   Maps$FilteredEntrySortedMap(SortedMap var1, Predicate var2) {
      super(var1, var2);
   }

   SortedMap sortedMap() {
      return (SortedMap)this.unfiltered;
   }

   public SortedSet keySet() {
      return (SortedSet)super.keySet();
   }

   SortedSet createKeySet() {
      return new Maps$FilteredEntrySortedMap$SortedKeySet(this);
   }

   public Comparator comparator() {
      return this.sortedMap().comparator();
   }

   public Object firstKey() {
      return this.keySet().iterator().next();
   }

   public Object lastKey() {
      SortedMap var1 = this.sortedMap();

      while(true) {
         Object var2 = var1.lastKey();
         if(this.apply(var2, this.unfiltered.get(var2))) {
            return var2;
         }

         var1 = this.sortedMap().headMap(var2);
      }
   }

   public SortedMap headMap(Object var1) {
      return new Maps$FilteredEntrySortedMap(this.sortedMap().headMap(var1), this.predicate);
   }

   public SortedMap subMap(Object var1, Object var2) {
      return new Maps$FilteredEntrySortedMap(this.sortedMap().subMap(var1, var2), this.predicate);
   }

   public SortedMap tailMap(Object var1) {
      return new Maps$FilteredEntrySortedMap(this.sortedMap().tailMap(var1), this.predicate);
   }
}
