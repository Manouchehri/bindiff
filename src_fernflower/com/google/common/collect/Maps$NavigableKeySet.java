package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$SortedKeySet;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;

@GwtIncompatible("NavigableMap")
class Maps$NavigableKeySet extends Maps$SortedKeySet implements NavigableSet {
   Maps$NavigableKeySet(NavigableMap var1) {
      super(var1);
   }

   NavigableMap map() {
      return (NavigableMap)this.map;
   }

   public Object lower(Object var1) {
      return this.map().lowerKey(var1);
   }

   public Object floor(Object var1) {
      return this.map().floorKey(var1);
   }

   public Object ceiling(Object var1) {
      return this.map().ceilingKey(var1);
   }

   public Object higher(Object var1) {
      return this.map().higherKey(var1);
   }

   public Object pollFirst() {
      return Maps.keyOrNull(this.map().pollFirstEntry());
   }

   public Object pollLast() {
      return Maps.keyOrNull(this.map().pollLastEntry());
   }

   public NavigableSet descendingSet() {
      return this.map().descendingKeySet();
   }

   public Iterator descendingIterator() {
      return this.descendingSet().iterator();
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      return this.map().subMap(var1, var2, var3, var4).navigableKeySet();
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      return this.map().headMap(var1, var2).navigableKeySet();
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      return this.map().tailMap(var1, var2).navigableKeySet();
   }

   public SortedSet subSet(Object var1, Object var2) {
      return this.subSet(var1, true, var2, false);
   }

   public SortedSet headSet(Object var1) {
      return this.headSet(var1, false);
   }

   public SortedSet tailSet(Object var1) {
      return this.tailSet(var1, true);
   }
}
