package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps$SortedKeySet;
import com.google.common.collect.StandardRowSortedTable;
import com.google.common.collect.StandardRowSortedTable$1;
import com.google.common.collect.StandardTable$RowMap;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

class StandardRowSortedTable$RowSortedMap extends StandardTable$RowMap implements SortedMap {
   // $FF: synthetic field
   final StandardRowSortedTable this$0;

   private StandardRowSortedTable$RowSortedMap(StandardRowSortedTable var1) {
      super(var1);
      this.this$0 = var1;
   }

   public SortedSet keySet() {
      return (SortedSet)super.keySet();
   }

   SortedSet createKeySet() {
      return new Maps$SortedKeySet(this);
   }

   public Comparator comparator() {
      return StandardRowSortedTable.access$100(this.this$0).comparator();
   }

   public Object firstKey() {
      return StandardRowSortedTable.access$100(this.this$0).firstKey();
   }

   public Object lastKey() {
      return StandardRowSortedTable.access$100(this.this$0).lastKey();
   }

   public SortedMap headMap(Object var1) {
      Preconditions.checkNotNull(var1);
      return (new StandardRowSortedTable(StandardRowSortedTable.access$100(this.this$0).headMap(var1), this.this$0.factory)).rowMap();
   }

   public SortedMap subMap(Object var1, Object var2) {
      Preconditions.checkNotNull(var1);
      Preconditions.checkNotNull(var2);
      return (new StandardRowSortedTable(StandardRowSortedTable.access$100(this.this$0).subMap(var1, var2), this.this$0.factory)).rowMap();
   }

   public SortedMap tailMap(Object var1) {
      Preconditions.checkNotNull(var1);
      return (new StandardRowSortedTable(StandardRowSortedTable.access$100(this.this$0).tailMap(var1), this.this$0.factory)).rowMap();
   }

   // $FF: synthetic method
   StandardRowSortedTable$RowSortedMap(StandardRowSortedTable var1, StandardRowSortedTable$1 var2) {
      this(var1);
   }
}
