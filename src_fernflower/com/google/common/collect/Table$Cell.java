package com.google.common.collect;

import javax.annotation.Nullable;

public interface Table$Cell {
   @Nullable
   Object getRowKey();

   @Nullable
   Object getColumnKey();

   @Nullable
   Object getValue();

   boolean equals(@Nullable Object var1);

   int hashCode();
}
