package com.google.common.collect;

import com.google.common.collect.CompactHashMap$EntrySetView;
import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashMap$1EntrySetImpl$1;
import java.util.Iterator;

class CompactLinkedHashMap$1EntrySetImpl extends CompactHashMap$EntrySetView {
   // $FF: synthetic field
   final CompactLinkedHashMap this$0;

   CompactLinkedHashMap$1EntrySetImpl(CompactLinkedHashMap var1) {
      super(var1);
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return new CompactLinkedHashMap$1EntrySetImpl$1(this);
   }
}
