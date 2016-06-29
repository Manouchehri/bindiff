package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.StandardTable$RowMap$EntrySet;
import java.util.Map;

class StandardTable$RowMap$EntrySet$1 implements Function {
   // $FF: synthetic field
   final StandardTable$RowMap$EntrySet this$2;

   StandardTable$RowMap$EntrySet$1(StandardTable$RowMap$EntrySet var1) {
      this.this$2 = var1;
   }

   public Map apply(Object var1) {
      return this.this$2.this$1.this$0.row(var1);
   }
}
