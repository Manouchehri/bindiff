package com.google.common.collect;

import com.google.common.collect.CompactHashMap;
import com.google.common.collect.CompactHashMap$KeySetView$1;
import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.ObjectArrays;
import java.util.Iterator;
import javax.annotation.Nullable;

class CompactHashMap$KeySetView extends Maps$KeySet {
   // $FF: synthetic field
   final CompactHashMap this$0;

   CompactHashMap$KeySetView(CompactHashMap var1) {
      super(var1);
      this.this$0 = var1;
   }

   public Object[] toArray() {
      return ObjectArrays.copyAsObjectArray(this.this$0.keys, 0, CompactHashMap.access$000(this.this$0));
   }

   public Object[] toArray(Object[] var1) {
      return ObjectArrays.toArrayImpl(this.this$0.keys, 0, CompactHashMap.access$000(this.this$0), var1);
   }

   public boolean remove(@Nullable Object var1) {
      int var2 = CompactHashMap.access$200(this.this$0, var1);
      if(var2 == -1) {
         return false;
      } else {
         CompactHashMap.access$100(this.this$0, var2);
         return true;
      }
   }

   public Iterator iterator() {
      return new CompactHashMap$KeySetView$1(this);
   }
}
