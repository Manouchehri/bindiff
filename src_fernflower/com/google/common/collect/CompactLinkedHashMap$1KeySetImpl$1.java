package com.google.common.collect;

import com.google.common.collect.CompactLinkedHashMap$1;
import com.google.common.collect.CompactLinkedHashMap$1KeySetImpl;
import com.google.common.collect.CompactLinkedHashMap$Itr;

class CompactLinkedHashMap$1KeySetImpl$1 extends CompactLinkedHashMap$Itr {
   // $FF: synthetic field
   final CompactLinkedHashMap$1KeySetImpl this$1;

   CompactLinkedHashMap$1KeySetImpl$1(CompactLinkedHashMap$1KeySetImpl var1) {
      super(var1.this$0, (CompactLinkedHashMap$1)null);
      this.this$1 = var1;
   }

   Object getOutput(int var1) {
      return this.this$1.this$0.keys[var1];
   }
}
