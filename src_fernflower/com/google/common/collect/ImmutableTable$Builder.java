package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.SingletonImmutableTable;
import com.google.common.collect.Table;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables$ImmutableCell;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class ImmutableTable$Builder {
   private final List cells = Lists.newArrayList();
   private Comparator rowComparator;
   private Comparator columnComparator;

   public ImmutableTable$Builder orderRowsBy(Comparator var1) {
      this.rowComparator = (Comparator)Preconditions.checkNotNull(var1);
      return this;
   }

   public ImmutableTable$Builder orderColumnsBy(Comparator var1) {
      this.columnComparator = (Comparator)Preconditions.checkNotNull(var1);
      return this;
   }

   public ImmutableTable$Builder put(Object var1, Object var2, Object var3) {
      this.cells.add(ImmutableTable.cellOf(var1, var2, var3));
      return this;
   }

   public ImmutableTable$Builder put(Table$Cell var1) {
      if(var1 instanceof Tables$ImmutableCell) {
         Preconditions.checkNotNull(var1.getRowKey());
         Preconditions.checkNotNull(var1.getColumnKey());
         Preconditions.checkNotNull(var1.getValue());
         this.cells.add(var1);
      } else {
         this.put(var1.getRowKey(), var1.getColumnKey(), var1.getValue());
      }

      return this;
   }

   public ImmutableTable$Builder putAll(Table var1) {
      Iterator var2 = var1.cellSet().iterator();

      while(var2.hasNext()) {
         Table$Cell var3 = (Table$Cell)var2.next();
         this.put(var3);
      }

      return this;
   }

   public ImmutableTable build() {
      int var1 = this.cells.size();
      switch(var1) {
      case 0:
         return ImmutableTable.of();
      case 1:
         return new SingletonImmutableTable((Table$Cell)Iterables.getOnlyElement(this.cells));
      default:
         return RegularImmutableTable.forCells(this.cells, this.rowComparator, this.columnComparator);
      }
   }
}
