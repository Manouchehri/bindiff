package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Maps$EntryTransformer;
import com.google.common.collect.Maps$TransformedEntriesMap;
import java.util.Comparator;
import java.util.SortedMap;

class Maps$TransformedEntriesSortedMap extends Maps$TransformedEntriesMap implements SortedMap {
   protected SortedMap fromMap() {
      return (SortedMap)this.fromMap;
   }

   Maps$TransformedEntriesSortedMap(SortedMap var1, Maps$EntryTransformer var2) {
      super(var1, var2);
   }

   public Comparator comparator() {
      return this.fromMap().comparator();
   }

   public Object firstKey() {
      return this.fromMap().firstKey();
   }

   public SortedMap headMap(Object var1) {
      return Maps.transformEntries(this.fromMap().headMap(var1), this.transformer);
   }

   public Object lastKey() {
      return this.fromMap().lastKey();
   }

   public SortedMap subMap(Object var1, Object var2) {
      return Maps.transformEntries(this.fromMap().subMap(var1, var2), this.transformer);
   }

   public SortedMap tailMap(Object var1) {
      return Maps.transformEntries(this.fromMap().tailMap(var1), this.transformer);
   }
}
