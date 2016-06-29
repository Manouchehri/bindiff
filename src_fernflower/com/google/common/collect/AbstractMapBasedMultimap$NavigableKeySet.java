package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$SortedKeySet;
import com.google.common.collect.Iterators;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;

@GwtIncompatible("NavigableSet")
class AbstractMapBasedMultimap$NavigableKeySet extends AbstractMapBasedMultimap$SortedKeySet implements NavigableSet {
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$NavigableKeySet(AbstractMapBasedMultimap var1, NavigableMap var2) {
      super(var1, var2);
      this.this$0 = var1;
   }

   NavigableMap sortedMap() {
      return (NavigableMap)super.sortedMap();
   }

   public Object lower(Object var1) {
      return this.sortedMap().lowerKey(var1);
   }

   public Object floor(Object var1) {
      return this.sortedMap().floorKey(var1);
   }

   public Object ceiling(Object var1) {
      return this.sortedMap().ceilingKey(var1);
   }

   public Object higher(Object var1) {
      return this.sortedMap().higherKey(var1);
   }

   public Object pollFirst() {
      return Iterators.pollNext(this.iterator());
   }

   public Object pollLast() {
      return Iterators.pollNext(this.descendingIterator());
   }

   public NavigableSet descendingSet() {
      return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().descendingMap());
   }

   public Iterator descendingIterator() {
      return this.descendingSet().iterator();
   }

   public NavigableSet headSet(Object var1) {
      return this.headSet(var1, false);
   }

   public NavigableSet headSet(Object var1, boolean var2) {
      return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().headMap(var1, var2));
   }

   public NavigableSet subSet(Object var1, Object var2) {
      return this.subSet(var1, true, var2, false);
   }

   public NavigableSet subSet(Object var1, boolean var2, Object var3, boolean var4) {
      return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().subMap(var1, var2, var3, var4));
   }

   public NavigableSet tailSet(Object var1) {
      return this.tailSet(var1, true);
   }

   public NavigableSet tailSet(Object var1, boolean var2) {
      return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap().tailMap(var1, var2));
   }
}
