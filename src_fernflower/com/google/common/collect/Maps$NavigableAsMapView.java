package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.Collections2;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
final class Maps$NavigableAsMapView extends AbstractNavigableMap {
   private final NavigableSet set;
   private final Function function;

   Maps$NavigableAsMapView(NavigableSet var1, Function var2) {
      this.set = (NavigableSet)Preconditions.checkNotNull(var1);
      this.function = (Function)Preconditions.checkNotNull(var2);
   }

   public NavigableMap subMap(Object var1, boolean var2, Object var3, boolean var4) {
      return Maps.asMap(this.set.subSet(var1, var2, var3, var4), this.function);
   }

   public NavigableMap headMap(Object var1, boolean var2) {
      return Maps.asMap(this.set.headSet(var1, var2), this.function);
   }

   public NavigableMap tailMap(Object var1, boolean var2) {
      return Maps.asMap(this.set.tailSet(var1, var2), this.function);
   }

   public Comparator comparator() {
      return this.set.comparator();
   }

   @Nullable
   public Object get(@Nullable Object var1) {
      return Collections2.safeContains(this.set, var1)?this.function.apply(var1):null;
   }

   public void clear() {
      this.set.clear();
   }

   Iterator entryIterator() {
      return Maps.asMapEntryIterator(this.set, this.function);
   }

   Iterator descendingEntryIterator() {
      return this.descendingMap().entrySet().iterator();
   }

   public NavigableSet navigableKeySet() {
      return Maps.access$400(this.set);
   }

   public int size() {
      return this.set.size();
   }

   public NavigableMap descendingMap() {
      return Maps.asMap(this.set.descendingSet(), this.function);
   }
}
