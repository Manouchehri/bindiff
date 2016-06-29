package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$NavigableKeySet;
import com.google.common.collect.AbstractMapBasedMultimap$SortedAsMap;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Map.Entry;

@GwtIncompatible("NavigableAsMap")
class AbstractMapBasedMultimap$NavigableAsMap extends AbstractMapBasedMultimap$SortedAsMap implements NavigableMap {
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$NavigableAsMap(AbstractMapBasedMultimap var1, NavigableMap var2) {
      super(var1, var2);
      this.this$0 = var1;
   }

   NavigableMap sortedMap() {
      return (NavigableMap)super.sortedMap();
   }

   public Entry lowerEntry(Object var1) {
      Entry var2 = this.sortedMap().lowerEntry(var1);
      return var2 == null?null:this.wrapEntry(var2);
   }

   public Object lowerKey(Object var1) {
      return this.sortedMap().lowerKey(var1);
   }

   public Entry floorEntry(Object var1) {
      Entry var2 = this.sortedMap().floorEntry(var1);
      return var2 == null?null:this.wrapEntry(var2);
   }

   public Object floorKey(Object var1) {
      return this.sortedMap().floorKey(var1);
   }

   public Entry ceilingEntry(Object var1) {
      Entry var2 = this.sortedMap().ceilingEntry(var1);
      return var2 == null?null:this.wrapEntry(var2);
   }

   public Object ceilingKey(Object var1) {
      return this.sortedMap().ceilingKey(var1);
   }

   public Entry higherEntry(Object var1) {
      Entry var2 = this.sortedMap().higherEntry(var1);
      return var2 == null?null:this.wrapEntry(var2);
   }

   public Object higherKey(Object var1) {
      return this.sortedMap().higherKey(var1);
   }

   public Entry firstEntry() {
      Entry var1 = this.sortedMap().firstEntry();
      return var1 == null?null:this.wrapEntry(var1);
   }

   public Entry lastEntry() {
      Entry var1 = this.sortedMap().lastEntry();
      return var1 == null?null:this.wrapEntry(var1);
   }

   public Entry pollFirstEntry() {
      return this.pollAsMapEntry(this.entrySet().iterator());
   }

   public Entry pollLastEntry() {
      return this.pollAsMapEntry(this.descendingMap().entrySet().iterator());
   }

   Entry pollAsMapEntry(Iterator var1) {
      if(!var1.hasNext()) {
         return null;
      } else {
         Entry var2 = (Entry)var1.next();
         Collection var3 = this.this$0.createCollection();
         var3.addAll((Collection)var2.getValue());
         var1.remove();
         return Maps.immutableEntry(var2.getKey(), this.this$0.unmodifiableCollectionSubclass(var3));
      }
   }

   public NavigableMap descendingMap() {
      return new AbstractMapBasedMultimap$NavigableAsMap(this.this$0, this.sortedMap().descendingMap());
   }

   public NavigableSet keySet() {
      return (NavigableSet)super.keySet();
   }

   NavigableSet createKeySet() {
      return new AbstractMapBasedMultimap$NavigableKeySet(this.this$0, this.sortedMap());
   }

   public NavigableSet navigableKeySet() {
      return this.keySet();
   }

   public NavigableSet descendingKeySet() {
      return this.descendingMap().navigableKeySet();
   }

   public NavigableMap subMap(Object var1, Object var2) {
      return this.subMap(var1, true, var2, false);
   }

   public NavigableMap subMap(Object var1, boolean var2, Object var3, boolean var4) {
      return new AbstractMapBasedMultimap$NavigableAsMap(this.this$0, this.sortedMap().subMap(var1, var2, var3, var4));
   }

   public NavigableMap headMap(Object var1) {
      return this.headMap(var1, false);
   }

   public NavigableMap headMap(Object var1, boolean var2) {
      return new AbstractMapBasedMultimap$NavigableAsMap(this.this$0, this.sortedMap().headMap(var1, var2));
   }

   public NavigableMap tailMap(Object var1) {
      return this.tailMap(var1, true);
   }

   public NavigableMap tailMap(Object var1, boolean var2) {
      return new AbstractMapBasedMultimap$NavigableAsMap(this.this$0, this.sortedMap().tailMap(var1, var2));
   }
}
