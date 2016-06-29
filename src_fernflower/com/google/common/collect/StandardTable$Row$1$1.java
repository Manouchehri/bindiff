package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.StandardTable$Row$1;
import java.util.Map.Entry;

class StandardTable$Row$1$1 extends ForwardingMapEntry {
   // $FF: synthetic field
   final Entry val$entry;
   // $FF: synthetic field
   final StandardTable$Row$1 this$2;

   StandardTable$Row$1$1(StandardTable$Row$1 var1, Entry var2) {
      this.this$2 = var1;
      this.val$entry = var2;
   }

   protected Entry delegate() {
      return this.val$entry;
   }

   public Object setValue(Object var1) {
      return super.setValue(Preconditions.checkNotNull(var1));
   }

   public boolean equals(Object var1) {
      return this.standardEquals(var1);
   }
}
