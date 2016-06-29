package com.google.common.collect;

import com.google.common.collect.Tables$AbstractCell;
import java.io.Serializable;
import javax.annotation.Nullable;

final class Tables$ImmutableCell extends Tables$AbstractCell implements Serializable {
   private final Object rowKey;
   private final Object columnKey;
   private final Object value;
   private static final long serialVersionUID = 0L;

   Tables$ImmutableCell(@Nullable Object var1, @Nullable Object var2, @Nullable Object var3) {
      this.rowKey = var1;
      this.columnKey = var2;
      this.value = var3;
   }

   public Object getRowKey() {
      return this.rowKey;
   }

   public Object getColumnKey() {
      return this.columnKey;
   }

   public Object getValue() {
      return this.value;
   }
}
