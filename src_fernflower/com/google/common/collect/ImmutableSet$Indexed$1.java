package com.google.common.collect;

import com.google.common.collect.ImmutableAsList;
import com.google.common.collect.ImmutableSet$Indexed;

class ImmutableSet$Indexed$1 extends ImmutableAsList {
   // $FF: synthetic field
   final ImmutableSet$Indexed this$0;

   ImmutableSet$Indexed$1(ImmutableSet$Indexed var1) {
      this.this$0 = var1;
   }

   public Object get(int var1) {
      return this.this$0.get(var1);
   }

   ImmutableSet$Indexed delegateCollection() {
      return this.this$0;
   }
}
