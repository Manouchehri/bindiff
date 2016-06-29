package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.RegularImmutableTable;
import com.google.common.collect.RegularImmutableTable$1;

final class RegularImmutableTable$Values extends ImmutableList {
   // $FF: synthetic field
   final RegularImmutableTable this$0;

   private RegularImmutableTable$Values(RegularImmutableTable var1) {
      this.this$0 = var1;
   }

   public int size() {
      return this.this$0.size();
   }

   public Object get(int var1) {
      return this.this$0.getValue(var1);
   }

   boolean isPartialView() {
      return true;
   }

   // $FF: synthetic method
   RegularImmutableTable$Values(RegularImmutableTable var1, RegularImmutableTable$1 var2) {
      this(var1);
   }
}
