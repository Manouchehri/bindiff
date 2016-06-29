package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$FilteredEntryNavigableMap$1;
import com.google.common.collect.Maps$FilteredMapValues;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
class Maps$FilteredEntryNavigableMap extends AbstractNavigableMap {
   private final NavigableMap unfiltered;
   private final Predicate entryPredicate;
   private final Map filteredDelegate;

   Maps$FilteredEntryNavigableMap(NavigableMap var1, Predicate var2) {
      this.unfiltered = (NavigableMap)Preconditions.checkNotNull(var1);
      this.entryPredicate = var2;
      this.filteredDelegate = new Maps$FilteredEntryMap(var1, var2);
   }

   public Comparator comparator() {
      return this.unfiltered.comparator();
   }

   public NavigableSet navigableKeySet() {
      return new Maps$FilteredEntryNavigableMap$1(this, this);
   }

   public Collection values() {
      return new Maps$FilteredMapValues(this, this.unfiltered, this.entryPredicate);
   }

   Iterator entryIterator() {
      return Iterators.filter(this.unfiltered.entrySet().iterator(), this.entryPredicate);
   }

   Iterator descendingEntryIterator() {
      return Iterators.filter(this.unfiltered.descendingMap().entrySet().iterator(), this.entryPredicate);
   }

   public int size() {
      return this.filteredDelegate.size();
   }

   public boolean isEmpty() {
      return !Iterables.any(this.unfiltered.entrySet(), this.entryPredicate);
   }

   @Nullable
   public Object get(@Nullable Object var1) {
      return this.filteredDelegate.get(var1);
   }

   public boolean containsKey(@Nullable Object var1) {
      return this.filteredDelegate.containsKey(var1);
   }

   public Object put(Object var1, Object var2) {
      return this.filteredDelegate.put(var1, var2);
   }

   public Object remove(@Nullable Object var1) {
      return this.filteredDelegate.remove(var1);
   }

   public void putAll(Map var1) {
      this.filteredDelegate.putAll(var1);
   }

   public void clear() {
      this.filteredDelegate.clear();
   }

   public Set entrySet() {
      return this.filteredDelegate.entrySet();
   }

   public Entry pollFirstEntry() {
      return (Entry)Iterables.removeFirstMatching(this.unfiltered.entrySet(), this.entryPredicate);
   }

   public Entry pollLastEntry() {
      return (Entry)Iterables.removeFirstMatching(this.unfiltered.descendingMap().entrySet(), this.entryPredicate);
   }

   public NavigableMap descendingMap() {
      return Maps.filterEntries(this.unfiltered.descendingMap(), this.entryPredicate);
   }

   public NavigableMap subMap(Object var1, boolean var2, Object var3, boolean var4) {
      return Maps.filterEntries(this.unfiltered.subMap(var1, var2, var3, var4), this.entryPredicate);
   }

   public NavigableMap headMap(Object var1, boolean var2) {
      return Maps.filterEntries(this.unfiltered.headMap(var1, var2), this.entryPredicate);
   }

   public NavigableMap tailMap(Object var1, boolean var2) {
      return Maps.filterEntries(this.unfiltered.tailMap(var1, var2), this.entryPredicate);
   }

   // $FF: synthetic method
   static Predicate access$600(Maps$FilteredEntryNavigableMap var0) {
      return var0.entryPredicate;
   }

   // $FF: synthetic method
   static NavigableMap access$700(Maps$FilteredEntryNavigableMap var0) {
      return var0.unfiltered;
   }
}
