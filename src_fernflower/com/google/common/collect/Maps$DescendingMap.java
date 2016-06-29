package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.Maps$DescendingMap$1EntrySetImpl;
import com.google.common.collect.Maps$NavigableKeySet;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.Ordering;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.Map.Entry;

@GwtIncompatible("NavigableMap")
abstract class Maps$DescendingMap extends ForwardingMap implements NavigableMap {
   private transient Comparator comparator;
   private transient Set entrySet;
   private transient NavigableSet navigableKeySet;

   abstract NavigableMap forward();

   protected final Map delegate() {
      return this.forward();
   }

   public Comparator comparator() {
      Comparator var1 = this.comparator;
      if(var1 == null) {
         Object var2 = this.forward().comparator();
         if(var2 == null) {
            var2 = Ordering.natural();
         }

         var1 = this.comparator = reverse((Comparator)var2);
      }

      return var1;
   }

   private static Ordering reverse(Comparator var0) {
      return Ordering.from(var0).reverse();
   }

   public Object firstKey() {
      return this.forward().lastKey();
   }

   public Object lastKey() {
      return this.forward().firstKey();
   }

   public Entry lowerEntry(Object var1) {
      return this.forward().higherEntry(var1);
   }

   public Object lowerKey(Object var1) {
      return this.forward().higherKey(var1);
   }

   public Entry floorEntry(Object var1) {
      return this.forward().ceilingEntry(var1);
   }

   public Object floorKey(Object var1) {
      return this.forward().ceilingKey(var1);
   }

   public Entry ceilingEntry(Object var1) {
      return this.forward().floorEntry(var1);
   }

   public Object ceilingKey(Object var1) {
      return this.forward().floorKey(var1);
   }

   public Entry higherEntry(Object var1) {
      return this.forward().lowerEntry(var1);
   }

   public Object higherKey(Object var1) {
      return this.forward().lowerKey(var1);
   }

   public Entry firstEntry() {
      return this.forward().lastEntry();
   }

   public Entry lastEntry() {
      return this.forward().firstEntry();
   }

   public Entry pollFirstEntry() {
      return this.forward().pollLastEntry();
   }

   public Entry pollLastEntry() {
      return this.forward().pollFirstEntry();
   }

   public NavigableMap descendingMap() {
      return this.forward();
   }

   public Set entrySet() {
      Set var1 = this.entrySet;
      return var1 == null?(this.entrySet = this.createEntrySet()):var1;
   }

   abstract Iterator entryIterator();

   Set createEntrySet() {
      return new Maps$DescendingMap$1EntrySetImpl(this);
   }

   public Set keySet() {
      return this.navigableKeySet();
   }

   public NavigableSet navigableKeySet() {
      NavigableSet var1 = this.navigableKeySet;
      return var1 == null?(this.navigableKeySet = new Maps$NavigableKeySet(this)):var1;
   }

   public NavigableSet descendingKeySet() {
      return this.forward().navigableKeySet();
   }

   public NavigableMap subMap(Object var1, boolean var2, Object var3, boolean var4) {
      return this.forward().subMap(var3, var4, var1, var2).descendingMap();
   }

   public NavigableMap headMap(Object var1, boolean var2) {
      return this.forward().tailMap(var1, var2).descendingMap();
   }

   public NavigableMap tailMap(Object var1, boolean var2) {
      return this.forward().headMap(var1, var2).descendingMap();
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

   public Collection values() {
      return new Maps$Values(this);
   }

   public String toString() {
      return this.standardToString();
   }
}
