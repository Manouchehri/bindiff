package com.google.common.collect;

import com.google.common.collect.DenseImmutableTable;
import com.google.common.collect.DenseImmutableTable$ImmutableArrayMap;
import com.google.common.collect.ImmutableMap;

final class DenseImmutableTable$Column extends DenseImmutableTable$ImmutableArrayMap {
   private final int columnIndex;
   // $FF: synthetic field
   final DenseImmutableTable this$0;

   DenseImmutableTable$Column(DenseImmutableTable var1, int var2) {
      super(DenseImmutableTable.access$500(var1)[var2]);
      this.this$0 = var1;
      this.columnIndex = var2;
   }

   ImmutableMap keyToIndex() {
      return DenseImmutableTable.access$600(this.this$0);
   }

   Object getValue(int var1) {
      return DenseImmutableTable.access$400(this.this$0)[var1][this.columnIndex];
   }

   boolean isPartialView() {
      return true;
   }
}
