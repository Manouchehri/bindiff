package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.ImmutableMap;

final class DenseImmutableTable$Row extends DenseImmutableTable$ImmutableArrayMap {
   private final int rowIndex;
   // $FF: synthetic field
   final DenseImmutableTable this$0;

   DenseImmutableTable$Row(DenseImmutableTable var1, int var2) {
      super(DenseImmutableTable.access$200(var1)[var2]);
      this.this$0 = var1;
      this.rowIndex = var2;
   }

   ImmutableMap keyToIndex() {
      return DenseImmutableTable.access$300(this.this$0);
   }

   Object getValue(int var1) {
      return DenseImmutableTable.access$400(this.this$0)[this.rowIndex][var1];
   }

   boolean isPartialView() {
      return true;
   }
}
