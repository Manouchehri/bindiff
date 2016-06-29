package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$TransformedEntriesSortedMap;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
class Maps$TransformedEntriesNavigableMap extends Maps$TransformedEntriesSortedMap implements NavigableMap {
   Maps$TransformedEntriesNavigableMap(NavigableMap var1, Maps$EntryTransformer var2) {
      super(var1, var2);
   }

   public Entry ceilingEntry(Object var1) {
      return this.transformEntry(this.fromMap().ceilingEntry(var1));
   }

   public Object ceilingKey(Object var1) {
      return this.fromMap().ceilingKey(var1);
   }

   public NavigableSet descendingKeySet() {
      return this.fromMap().descendingKeySet();
   }

   public NavigableMap descendingMap() {
      return Maps.transformEntries(this.fromMap().descendingMap(), this.transformer);
   }

   public Entry firstEntry() {
      return this.transformEntry(this.fromMap().firstEntry());
   }

   public Entry floorEntry(Object var1) {
      return this.transformEntry(this.fromMap().floorEntry(var1));
   }

   public Object floorKey(Object var1) {
      return this.fromMap().floorKey(var1);
   }

   public NavigableMap headMap(Object var1) {
      return this.headMap(var1, false);
   }

   public NavigableMap headMap(Object var1, boolean var2) {
      return Maps.transformEntries(this.fromMap().headMap(var1, var2), this.transformer);
   }

   public Entry higherEntry(Object var1) {
      return this.transformEntry(this.fromMap().higherEntry(var1));
   }

   public Object higherKey(Object var1) {
      return this.fromMap().higherKey(var1);
   }

   public Entry lastEntry() {
      return this.transformEntry(this.fromMap().lastEntry());
   }

   public Entry lowerEntry(Object var1) {
      return this.transformEntry(this.fromMap().lowerEntry(var1));
   }

   public Object lowerKey(Object var1) {
      return this.fromMap().lowerKey(var1);
   }

   public NavigableSet navigableKeySet() {
      return this.fromMap().navigableKeySet();
   }

   public Entry pollFirstEntry() {
      return this.transformEntry(this.fromMap().pollFirstEntry());
   }

   public Entry pollLastEntry() {
      return this.transformEntry(this.fromMap().pollLastEntry());
   }

   public NavigableMap subMap(Object var1, boolean var2, Object var3, boolean var4) {
      return Maps.transformEntries(this.fromMap().subMap(var1, var2, var3, var4), this.transformer);
   }

   public NavigableMap subMap(Object var1, Object var2) {
      return this.subMap(var1, true, var2, false);
   }

   public NavigableMap tailMap(Object var1) {
      return this.tailMap(var1, true);
   }

   public NavigableMap tailMap(Object var1, boolean var2) {
      return Maps.transformEntries(this.fromMap().tailMap(var1, var2), this.transformer);
   }

   @Nullable
   private Entry transformEntry(@Nullable Entry var1) {
      return var1 == null?null:Maps.transformEntry(this.transformer, var1);
   }

   protected NavigableMap fromMap() {
      return (NavigableMap)super.fromMap();
   }
}
