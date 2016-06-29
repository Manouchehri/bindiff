package com.google.common.collect;

import com.google.common.collect.CompactLinkedHashMap$1;
import com.google.common.collect.CompactLinkedHashMap$1ValuesImpl;
import com.google.common.collect.CompactLinkedHashMap$Itr;

class CompactLinkedHashMap$1ValuesImpl$1 extends CompactLinkedHashMap$Itr {
   // $FF: synthetic field
   final CompactLinkedHashMap$1ValuesImpl this$1;

   CompactLinkedHashMap$1ValuesImpl$1(CompactLinkedHashMap$1ValuesImpl var1) {
      super(var1.this$0, (CompactLinkedHashMap$1)null);
      this.this$1 = var1;
   }

   Object getOutput(int var1) {
      return this.this$1.this$0.values[var1];
   }
}
