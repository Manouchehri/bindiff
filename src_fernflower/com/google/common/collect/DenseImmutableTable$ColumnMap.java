package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$1;
import com.google.common.collect.DenseImmutableTable$Column;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

final class DenseImmutableTable$ColumnMap extends DenseImmutableTable$ImmutableArrayMap {
   // $FF: synthetic field
   final DenseImmutableTable this$0;

   private DenseImmutableTable$ColumnMap(DenseImmutableTable var1) {
      super(DenseImmutableTable.access$500(var1).length);
      this.this$0 = var1;
   }

   ImmutableMap keyToIndex() {
      return DenseImmutableTable.access$300(this.this$0);
   }

   Map getValue(int var1) {
      return new DenseImmutableTable$Column(this.this$0, var1);
   }

   boolean isPartialView() {
      return false;
   }

   // $FF: synthetic method
   DenseImmutableTable$ColumnMap(DenseImmutableTable var1, DenseImmutableTable$1 var2) {
      this(var1);
   }
}
