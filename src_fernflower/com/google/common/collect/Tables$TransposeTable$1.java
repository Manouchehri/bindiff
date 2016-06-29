package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Table$Cell;
import com.google.common.collect.Tables;

final class Tables$TransposeTable$1 implements Function {
   public Table$Cell apply(Table$Cell var1) {
      return Tables.immutableCell(var1.getColumnKey(), var1.getRowKey(), var1.getValue());
   }
}
