package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap;

class ArrayTable$Row extends ArrayTable$ArrayMap {
   final int rowIndex;
   // $FF: synthetic field
   final ArrayTable this$0;

   ArrayTable$Row(ArrayTable var1, int var2) {
      super(ArrayTable.access$500(var1), (ArrayTable$1)null);
      this.this$0 = var1;
      this.rowIndex = var2;
   }

   String getKeyRole() {
      return "Column";
   }

   Object getValue(int var1) {
      return this.this$0.at(this.rowIndex, var1);
   }

   Object setValue(int var1, Object var2) {
      return this.this$0.set(this.rowIndex, var1, var2);
   }
}
