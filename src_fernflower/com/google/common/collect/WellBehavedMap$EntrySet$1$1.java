package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.WellBehavedMap$EntrySet$1;

class WellBehavedMap$EntrySet$1$1 extends AbstractMapEntry {
   // $FF: synthetic field
   final Object val$key;
   // $FF: synthetic field
   final WellBehavedMap$EntrySet$1 this$2;

   WellBehavedMap$EntrySet$1$1(WellBehavedMap$EntrySet$1 var1, Object var2) {
      this.this$2 = var1;
      this.val$key = var2;
   }

   public Object getKey() {
      return this.val$key;
   }

   public Object getValue() {
      return this.this$2.this$1.this$0.get(this.val$key);
   }

   public Object setValue(Object var1) {
      return this.this$2.this$1.this$0.put(this.val$key, var1);
   }
}
