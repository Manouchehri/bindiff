package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$ValuesView$1;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.ObjectArrays;
import java.util.Iterator;

class CompactHashMap$ValuesView extends Maps$Values {
   // $FF: synthetic field
   final CompactHashMap this$0;

   CompactHashMap$ValuesView(CompactHashMap var1) {
      super(var1);
      this.this$0 = var1;
   }

   public Iterator iterator() {
      return new CompactHashMap$ValuesView$1(this);
   }

   public Object[] toArray() {
      return ObjectArrays.copyAsObjectArray(this.this$0.values, 0, CompactHashMap.access$000(this.this$0));
   }

   public Object[] toArray(Object[] var1) {
      return ObjectArrays.toArrayImpl(this.this$0.values, 0, CompactHashMap.access$000(this.this$0), var1);
   }
}
