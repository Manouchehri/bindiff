package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapEntrySet;
import java.util.Map;

class StandardTable$ColumnMap$ColumnMapEntrySet$1 implements Function {
   // $FF: synthetic field
   final StandardTable$ColumnMap$ColumnMapEntrySet this$2;

   StandardTable$ColumnMap$ColumnMapEntrySet$1(StandardTable$ColumnMap$ColumnMapEntrySet var1) {
      this.this$2 = var1;
   }

   public Map apply(Object var1) {
      return this.this$2.this$1.this$0.column(var1);
   }
}
