package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.RowSortedTable;
import com.google.common.collect.Tables;
import com.google.common.collect.Tables$UnmodifiableTable;
import java.util.Collections;
import java.util.SortedMap;
import java.util.SortedSet;

final class Tables$UnmodifiableRowSortedMap extends Tables$UnmodifiableTable implements RowSortedTable {
   private static final long serialVersionUID = 0L;

   public Tables$UnmodifiableRowSortedMap(RowSortedTable var1) {
      super(var1);
   }

   protected RowSortedTable delegate() {
      return (RowSortedTable)super.delegate();
   }

   public SortedMap rowMap() {
      Function var1 = Tables.access$000();
      return Collections.unmodifiableSortedMap(Maps.transformValues(this.delegate().rowMap(), var1));
   }

   public SortedSet rowKeySet() {
      return Collections.unmodifiableSortedSet(this.delegate().rowKeySet());
   }
}
