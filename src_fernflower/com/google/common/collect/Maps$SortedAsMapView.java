package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$AsMapView;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

class Maps$SortedAsMapView extends Maps$AsMapView implements SortedMap {
   Maps$SortedAsMapView(SortedSet var1, Function var2) {
      super(var1, var2);
   }

   SortedSet backingSet() {
      return (SortedSet)super.backingSet();
   }

   public Comparator comparator() {
      return this.backingSet().comparator();
   }

   public Set keySet() {
      return Maps.access$300(this.backingSet());
   }

   public SortedMap subMap(Object var1, Object var2) {
      return Maps.asMap(this.backingSet().subSet(var1, var2), this.function);
   }

   public SortedMap headMap(Object var1) {
      return Maps.asMap(this.backingSet().headSet(var1), this.function);
   }

   public SortedMap tailMap(Object var1) {
      return Maps.asMap(this.backingSet().tailSet(var1), this.function);
   }

   public Object firstKey() {
      return this.backingSet().first();
   }

   public Object lastKey() {
      return this.backingSet().last();
   }
}
