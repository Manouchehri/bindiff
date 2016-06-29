package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.ArrayTable$ArrayMap$1;

class ArrayTable$ArrayMap$1$1 extends AbstractMapEntry {
   // $FF: synthetic field
   final int val$index;
   // $FF: synthetic field
   final ArrayTable$ArrayMap$1 this$1;

   ArrayTable$ArrayMap$1$1(ArrayTable$ArrayMap$1 var1, int var2) {
      this.this$1 = var1;
      this.val$index = var2;
   }

   public Object getKey() {
      return this.this$1.this$0.getKey(this.val$index);
   }

   public Object getValue() {
      return this.this$1.this$0.getValue(this.val$index);
   }

   public Object setValue(Object var1) {
      return this.this$1.this$0.setValue(this.val$index, var1);
   }
}
