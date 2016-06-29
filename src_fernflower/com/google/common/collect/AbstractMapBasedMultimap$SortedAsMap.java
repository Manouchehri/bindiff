package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import com.google.common.collect.AbstractMapBasedMultimap$SortedKeySet;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class AbstractMapBasedMultimap$SortedAsMap extends AbstractMapBasedMultimap$AsMap implements SortedMap {
   SortedSet sortedKeySet;
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$SortedAsMap(AbstractMapBasedMultimap var1, SortedMap var2) {
      super(var1, var2);
      this.this$0 = var1;
   }

   SortedMap sortedMap() {
      return (SortedMap)this.submap;
   }

   public Comparator comparator() {
      return this.sortedMap().comparator();
   }

   public Object firstKey() {
      return this.sortedMap().firstKey();
   }

   public Object lastKey() {
      return this.sortedMap().lastKey();
   }

   public SortedMap headMap(Object var1) {
      return new AbstractMapBasedMultimap$SortedAsMap(this.this$0, this.sortedMap().headMap(var1));
   }

   public SortedMap subMap(Object var1, Object var2) {
      return new AbstractMapBasedMultimap$SortedAsMap(this.this$0, this.sortedMap().subMap(var1, var2));
   }

   public SortedMap tailMap(Object var1) {
      return new AbstractMapBasedMultimap$SortedAsMap(this.this$0, this.sortedMap().tailMap(var1));
   }

   public SortedSet keySet() {
      SortedSet var1 = this.sortedKeySet;
      return var1 == null?(this.sortedKeySet = this.createKeySet()):var1;
   }

   SortedSet createKeySet() {
      return new AbstractMapBasedMultimap$SortedKeySet(this.this$0, this.sortedMap());
   }
}
