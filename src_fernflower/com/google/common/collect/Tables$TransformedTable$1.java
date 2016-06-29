package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;
import com.google.common.collect.Tables$TransformedTable;

class Tables$TransformedTable$1 implements Function {
   // $FF: synthetic field
   final Tables$TransformedTable this$0;

   Tables$TransformedTable$1(Tables$TransformedTable var1) {
      this.this$0 = var1;
   }

   public Table$Cell apply(Table$Cell var1) {
      return Tables.immutableCell(var1.getRowKey(), var1.getColumnKey(), this.this$0.function.apply(var1.getValue()));
   }
}
