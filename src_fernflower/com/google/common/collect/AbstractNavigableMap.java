package com.google.common.collect;

import com.google.common.collect.AbstractNavigableMap$1;
import com.google.common.collect.AbstractNavigableMap$DescendingMap;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.Maps$NavigableKeySet;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;
import javax.annotation.Nullable;

abstract class AbstractNavigableMap extends Maps$IteratorBasedAbstractMap implements NavigableMap {
   @Nullable
   public abstract Object get(@Nullable Object var1);

   @Nullable
   public Entry firstEntry() {
      return (Entry)Iterators.getNext(this.entryIterator(), (Object)null);
   }

   @Nullable
   public Entry lastEntry() {
      return (Entry)Iterators.getNext(this.descendingEntryIterator(), (Object)null);
   }

   @Nullable
   public Entry pollFirstEntry() {
      return (Entry)Iterators.pollNext(this.entryIterator());
   }

   @Nullable
   public Entry pollLastEntry() {
      return (Entry)Iterators.pollNext(this.descendingEntryIterator());
   }

   public Object firstKey() {
      Entry var1 = this.firstEntry();
      if(var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1.getKey();
      }
   }

   public Object lastKey() {
      Entry var1 = this.lastEntry();
      if(var1 == null) {
         throw new NoSuchElementException();
      } else {
         return var1.getKey();
      }
   }

   @Nullable
   public Entry lowerEntry(Object var1) {
      return this.headMap(var1, false).lastEntry();
   }

   @Nullable
   public Entry floorEntry(Object var1) {
      return this.headMap(var1, true).lastEntry();
   }

   @Nullable
   public Entry ceilingEntry(Object var1) {
      return this.tailMap(var1, true).firstEntry();
   }

   @Nullable
   public Entry higherEntry(Object var1) {
      return this.tailMap(var1, false).firstEntry();
   }

   public Object lowerKey(Object var1) {
      return Maps.keyOrNull(this.lowerEntry(var1));
   }

   public Object floorKey(Object var1) {
      return Maps.keyOrNull(this.floorEntry(var1));
   }

   public Object ceilingKey(Object var1) {
      return Maps.keyOrNull(this.ceilingEntry(var1));
   }

   public Object higherKey(Object var1) {
      return Maps.keyOrNull(this.higherEntry(var1));
   }

   abstract Iterator descendingEntryIterator();

   public SortedMap subMap(Object var1, Object var2) {
      return this.subMap(var1, true, var2, false);
   }

   public SortedMap headMap(Object var1) {
      return this.headMap(var1, false);
   }

   public SortedMap tailMap(Object var1) {
      return this.tailMap(var1, true);
   }

   public NavigableSet navigableKeySet() {
      return new Maps$NavigableKeySet(this);
   }

   public Set keySet() {
      return this.navigableKeySet();
   }

   public NavigableSet descendingKeySet() {
      return this.descendingMap().navigableKeySet();
   }

   public NavigableMap descendingMap() {
      return new AbstractNavigableMap$DescendingMap(this, (AbstractNavigableMap$1)null);
   }
}
