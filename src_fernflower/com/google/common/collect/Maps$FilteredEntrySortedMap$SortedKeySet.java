package com.google.common.collect;

import com.google.common.collect.Maps$FilteredEntryMap$KeySet;
import com.google.common.collect.Maps$FilteredEntrySortedMap;
import java.util.Comparator;
import java.util.SortedSet;

class Maps$FilteredEntrySortedMap$SortedKeySet extends Maps$FilteredEntryMap$KeySet implements SortedSet {
   // $FF: synthetic field
   final Maps$FilteredEntrySortedMap this$0;

   Maps$FilteredEntrySortedMap$SortedKeySet(Maps$FilteredEntrySortedMap var1) {
      super(var1);
      this.this$0 = var1;
   }

   public Comparator comparator() {
      return this.this$0.sortedMap().comparator();
   }

   public SortedSet subSet(Object var1, Object var2) {
      return (SortedSet)this.this$0.subMap(var1, var2).keySet();
   }

   public SortedSet headSet(Object var1) {
      return (SortedSet)this.this$0.headMap(var1).keySet();
   }

   public SortedSet tailSet(Object var1) {
      return (SortedSet)this.this$0.tailMap(var1).keySet();
   }

   public Object first() {
      return this.this$0.firstKey();
   }

   public Object last() {
      return this.this$0.lastKey();
   }
}
