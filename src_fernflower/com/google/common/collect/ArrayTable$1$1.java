package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.ArrayTable$1;
import com.google.common.collect.Tables$AbstractCell;

class ArrayTable$1$1 extends Tables$AbstractCell {
   final int rowIndex;
   final int columnIndex;
   // $FF: synthetic field
   final int val$index;
   // $FF: synthetic field
   final ArrayTable$1 this$1;

   ArrayTable$1$1(ArrayTable$1 var1, int var2) {
      this.this$1 = var1;
      this.val$index = var2;
      this.rowIndex = this.val$index / ArrayTable.access$000(this.this$1.this$0).size();
      this.columnIndex = this.val$index % ArrayTable.access$000(this.this$1.this$0).size();
   }

   public Object getRowKey() {
      return ArrayTable.access$100(this.this$1.this$0).get(this.rowIndex);
   }

   public Object getColumnKey() {
      return ArrayTable.access$000(this.this$1.this$0).get(this.columnIndex);
   }

   public Object getValue() {
      return this.this$1.this$0.at(this.rowIndex, this.columnIndex);
   }
}
