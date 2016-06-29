package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$1;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.DenseImmutableTable$Row;
import com.google.common.collect.ImmutableMap;
import java.util.Map;

final class DenseImmutableTable$RowMap extends DenseImmutableTable$ImmutableArrayMap {
   // $FF: synthetic field
   final DenseImmutableTable this$0;

   private DenseImmutableTable$RowMap(DenseImmutableTable var1) {
      super(DenseImmutableTable.access$200(var1).length);
      this.this$0 = var1;
   }

   ImmutableMap keyToIndex() {
      return DenseImmutableTable.access$600(this.this$0);
   }

   Map getValue(int var1) {
      return new DenseImmutableTable$Row(this.this$0, var1);
   }

   boolean isPartialView() {
      return false;
   }

   // $FF: synthetic method
   DenseImmutableTable$RowMap(DenseImmutableTable var1, DenseImmutableTable$1 var2) {
      this(var1);
   }
}
