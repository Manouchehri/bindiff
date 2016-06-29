package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingSortedMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import java.io.Serializable;
import java.util.Collections;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;

@GwtIncompatible("NavigableMap")
class Maps$UnmodifiableNavigableMap extends ForwardingSortedMap implements Serializable, NavigableMap {
   private final NavigableMap delegate;
   private transient Maps$UnmodifiableNavigableMap descendingMap;

   Maps$UnmodifiableNavigableMap(NavigableMap var1) {
      this.delegate = var1;
   }

   Maps$UnmodifiableNavigableMap(NavigableMap var1, Maps$UnmodifiableNavigableMap var2) {
      this.delegate = var1;
      this.descendingMap = var2;
   }

   protected SortedMap delegate() {
      return Collections.unmodifiableSortedMap(this.delegate);
   }

   public Entry lowerEntry(Object var1) {
      return Maps.access$800(this.delegate.lowerEntry(var1));
   }

   public Object lowerKey(Object var1) {
      return this.delegate.lowerKey(var1);
   }

   public Entry floorEntry(Object var1) {
      return Maps.access$800(this.delegate.floorEntry(var1));
   }

   public Object floorKey(Object var1) {
      return this.delegate.floorKey(var1);
   }

   public Entry ceilingEntry(Object var1) {
      return Maps.access$800(this.delegate.ceilingEntry(var1));
   }

   public Object ceilingKey(Object var1) {
      return this.delegate.ceilingKey(var1);
   }

   public Entry higherEntry(Object var1) {
      return Maps.access$800(this.delegate.higherEntry(var1));
   }

   public Object higherKey(Object var1) {
      return this.delegate.higherKey(var1);
   }

   public Entry firstEntry() {
      return Maps.access$800(this.delegate.firstEntry());
   }

   public Entry lastEntry() {
      return Maps.access$800(this.delegate.lastEntry());
   }

   public final Entry pollFirstEntry() {
      throw new UnsupportedOperationException();
   }

   public final Entry pollLastEntry() {
      throw new UnsupportedOperationException();
   }

   public NavigableMap descendingMap() {
      Maps$UnmodifiableNavigableMap var1 = this.descendingMap;
      return var1 == null?(this.descendingMap = new Maps$UnmodifiableNavigableMap(this.delegate.descendingMap(), this)):var1;
   }

   public Set keySet() {
      return this.navigableKeySet();
   }

   public NavigableSet navigableKeySet() {
      return Sets.unmodifiableNavigableSet(this.delegate.navigableKeySet());
   }

   public NavigableSet descendingKeySet() {
      return Sets.unmodifiableNavigableSet(this.delegate.descendingKeySet());
   }

   public SortedMap subMap(Object var1, Object var2) {
      return this.subMap(var1, true, var2, false);
   }

   public SortedMap headMap(Object var1) {
      return this.headMap(var1, false);
   }

   public SortedMap tailMap(Object var1) {
      return this.tailMap(var1, true);
   }

   public NavigableMap subMap(Object var1, boolean var2, Object var3, boolean var4) {
      return Maps.unmodifiableNavigableMap(this.delegate.subMap(var1, var2, var3, var4));
   }

   public NavigableMap headMap(Object var1, boolean var2) {
      return Maps.unmodifiableNavigableMap(this.delegate.headMap(var1, var2));
   }

   public NavigableMap tailMap(Object var1, boolean var2) {
      return Maps.unmodifiableNavigableMap(this.delegate.tailMap(var1, var2));
   }
}
