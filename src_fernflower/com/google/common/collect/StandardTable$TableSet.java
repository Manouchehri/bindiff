package com.google.common.collect;

import com.google.common.collect.Sets$ImprovedAbstractSet;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;

abstract class StandardTable$TableSet extends Sets$ImprovedAbstractSet {
   // $FF: synthetic field
   final StandardTable this$0;

   private StandardTable$TableSet(StandardTable var1) {
      this.this$0 = var1;
   }

   public boolean isEmpty() {
      return this.this$0.backingMap.isEmpty();
   }

   public void clear() {
      this.this$0.backingMap.clear();
   }

   // $FF: synthetic method
   StandardTable$TableSet(StandardTable var1, StandardTable$1 var2) {
      this(var1);
   }
}
