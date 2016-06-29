package com.google.common.collect;

import com.google.common.collect.CompactHashMap$KeySetView;
import com.google.common.collect.CompactLinkedHashMap;
import com.google.common.collect.CompactLinkedHashMap$1KeySetImpl$1;
import com.google.common.collect.ObjectArrays;
import java.util.Iterator;

class CompactLinkedHashMap$1KeySetImpl extends CompactHashMap$KeySetView {
   // $FF: synthetic field
   final CompactLinkedHashMap this$0;

   CompactLinkedHashMap$1KeySetImpl(CompactLinkedHashMap var1) {
      super(var1);
      this.this$0 = var1;
   }

   public Object[] toArray() {
      return ObjectArrays.toArrayImpl(this);
   }

   public Object[] toArray(Object[] var1) {
      return ObjectArrays.toArrayImpl(this, var1);
   }

   public Iterator iterator() {
      return new CompactLinkedHashMap$1KeySetImpl$1(this);
   }
}
