package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Supplier;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.StandardRowSortedTable$1;
import com.google.common.collect.StandardRowSortedTable$RowSortedMap;
import com.google.common.collect.StandardTable;
import java.util.SortedMap;
import java.util.SortedSet;

@GwtCompatible
class StandardRowSortedTable extends StandardTable implements RowSortedTable {
   private static final long serialVersionUID = 0L;

   StandardRowSortedTable(SortedMap var1, Supplier var2) {
      super(var1, var2);
   }

   private SortedMap sortedBackingMap() {
      return (SortedMap)this.backingMap;
   }

   public SortedSet rowKeySet() {
      return (SortedSet)this.rowMap().keySet();
   }

   public SortedMap rowMap() {
      return (SortedMap)super.rowMap();
   }

   SortedMap createRowMap() {
      return new StandardRowSortedTable$RowSortedMap(this, (StandardRowSortedTable$1)null);
   }

   // $FF: synthetic method
   static SortedMap access$100(StandardRowSortedTable var0) {
      return var0.sortedBackingMap();
   }
}
