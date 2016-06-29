package com.google.common.collect;

import com.google.common.collect.CompactHashMap$1;
import com.google.common.collect.CompactHashMap$Itr;
import com.google.common.collect.CompactHashMap$KeySetView;

class CompactHashMap$KeySetView$1 extends CompactHashMap$Itr {
   // $FF: synthetic field
   final CompactHashMap$KeySetView this$1;

   CompactHashMap$KeySetView$1(CompactHashMap$KeySetView var1) {
      super(var1.this$0, (CompactHashMap$1)null);
      this.this$1 = var1;
   }

   Object getOutput(int var1) {
      return this.this$1.this$0.keys[var1];
   }
}
