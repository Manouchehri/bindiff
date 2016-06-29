package com.google.common.collect;

import com.google.common.collect.ImmutableSet$Indexed;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.RegularImmutableTable$1;
import com.google.common.collect.Table$Cell;
import javax.annotation.Nullable;

final class RegularImmutableTable$CellSet extends ImmutableSet$Indexed {
   // $FF: synthetic field
   final RegularImmutableTable this$0;

   private RegularImmutableTable$CellSet(RegularImmutableTable var1) {
      this.this$0 = var1;
   }

   public int size() {
      return this.this$0.size();
   }

   Table$Cell get(int var1) {
      return this.this$0.getCell(var1);
   }

   public boolean contains(@Nullable Object var1) {
      if(!(var1 instanceof Table$Cell)) {
         return false;
      } else {
         Table$Cell var2 = (Table$Cell)var1;
         Object var3 = this.this$0.get(var2.getRowKey(), var2.getColumnKey());
         return var3 != null && var3.equals(var2.getValue());
      }
   }

   boolean isPartialView() {
      return false;
   }

   // $FF: synthetic method
   RegularImmutableTable$CellSet(RegularImmutableTable var1, RegularImmutableTable$1 var2) {
      this(var1);
   }
}
