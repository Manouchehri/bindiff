package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.ArrayTable$ArrayMap;
import com.google.common.collect.ArrayTable$Column;
import java.util.Map;

class ArrayTable$ColumnMap extends ArrayTable$ArrayMap {
   // $FF: synthetic field
   final ArrayTable this$0;

   private ArrayTable$ColumnMap(ArrayTable var1) {
      super(ArrayTable.access$500(var1), (ArrayTable$1)null);
      this.this$0 = var1;
   }

   String getKeyRole() {
      return "Column";
   }

   Map getValue(int var1) {
      return new ArrayTable$Column(this.this$0, var1);
   }

   Map setValue(int var1, Map var2) {
      throw new UnsupportedOperationException();
   }

   public Map put(Object var1, Map var2) {
      throw new UnsupportedOperationException();
   }

   // $FF: synthetic method
   ArrayTable$ColumnMap(ArrayTable var1, ArrayTable$1 var2) {
      this(var1);
   }
}
