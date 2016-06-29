package com.google.common.collect;

import com.google.common.collect.CompactHashMap$MapEntry;
import com.google.common.collect.CompactLinkedHashMap$1;
import com.google.common.collect.CompactLinkedHashMap$1EntrySetImpl;
import com.google.common.collect.CompactLinkedHashMap$Itr;
import java.util.Map.Entry;

class CompactLinkedHashMap$1EntrySetImpl$1 extends CompactLinkedHashMap$Itr {
   // $FF: synthetic field
   final CompactLinkedHashMap$1EntrySetImpl this$1;

   CompactLinkedHashMap$1EntrySetImpl$1(CompactLinkedHashMap$1EntrySetImpl var1) {
      super(var1.this$0, (CompactLinkedHashMap$1)null);
      this.this$1 = var1;
   }

   Entry getOutput(int var1) {
      return new CompactHashMap$MapEntry(this.this$1.this$0, var1);
   }
}
