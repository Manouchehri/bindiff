package com.google.common.collect;

import com.google.common.collect.CompactHashMap$1;
import com.google.common.collect.CompactHashMap$EntrySetView;
import com.google.common.collect.CompactHashMap$Itr;
import com.google.common.collect.CompactHashMap$MapEntry;
import java.util.Map.Entry;

class CompactHashMap$EntrySetView$1 extends CompactHashMap$Itr {
   // $FF: synthetic field
   final CompactHashMap$EntrySetView this$1;

   CompactHashMap$EntrySetView$1(CompactHashMap$EntrySetView var1) {
      super(var1.this$0, (CompactHashMap$1)null);
      this.this$1 = var1;
   }

   Entry getOutput(int var1) {
      return new CompactHashMap$MapEntry(this.this$1.this$0, var1);
   }
}
