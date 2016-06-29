package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap;

class ArrayTable$Column extends ArrayTable$ArrayMap {
   final int columnIndex;
   // $FF: synthetic field
   final ArrayTable this$0;

   ArrayTable$Column(ArrayTable var1, int var2) {
      super(ArrayTable.access$200(var1), (ArrayTable$1)null);
      this.this$0 = var1;
      this.columnIndex = var2;
   }

   String getKeyRole() {
      return "Row";
   }

   Object getValue(int var1) {
      return this.this$0.at(var1, this.columnIndex);
   }

   Object setValue(int var1, Object var2) {
      return this.this$0.set(var1, this.columnIndex, var2);
   }
}
