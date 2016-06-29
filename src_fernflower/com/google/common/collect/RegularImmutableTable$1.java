package com.google.common.collect;

import com.google.common.collect.Table$Cell;
import java.util.Comparator;

final class RegularImmutableTable$1 implements Comparator {
   // $FF: synthetic field
   final Comparator val$rowComparator;
   // $FF: synthetic field
   final Comparator val$columnComparator;

   RegularImmutableTable$1(Comparator var1, Comparator var2) {
      this.val$rowComparator = var1;
      this.val$columnComparator = var2;
   }

   public int compare(Table$Cell var1, Table$Cell var2) {
      int var3 = this.val$rowComparator == null?0:this.val$rowComparator.compare(var1.getRowKey(), var2.getRowKey());
      return var3 != 0?var3:(this.val$columnComparator == null?0:this.val$columnComparator.compare(var1.getColumnKey(), var2.getColumnKey()));
   }
}
