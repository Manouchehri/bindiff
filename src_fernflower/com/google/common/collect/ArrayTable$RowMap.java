package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ArrayTable$Row;
import java.util.Map;

class ArrayTable$RowMap extends ArrayTable$ArrayMap {
   // $FF: synthetic field
   final ArrayTable this$0;

   private ArrayTable$RowMap(ArrayTable var1) {
      super(ArrayTable.access$200(var1), (ArrayTable$1)null);
      this.this$0 = var1;
   }

   String getKeyRole() {
      return "Row";
   }

   Map getValue(int var1) {
      return new ArrayTable$Row(this.this$0, var1);
   }

   Map setValue(int var1, Map var2) {
      throw new UnsupportedOperationException();
   }

   public Map put(Object var1, Map var2) {
      throw new UnsupportedOperationException();
   }

   // $FF: synthetic method
   ArrayTable$RowMap(ArrayTable var1, ArrayTable$1 var2) {
      this(var1);
   }
}
