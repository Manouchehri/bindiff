package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;

class ImmutableList$SubList extends ImmutableList {
   final transient int offset;
   final transient int length;
   // $FF: synthetic field
   final ImmutableList this$0;

   ImmutableList$SubList(ImmutableList var1, int var2, int var3) {
      this.this$0 = var1;
      this.offset = var2;
      this.length = var3;
   }

   public int size() {
      return this.length;
   }

   public Object get(int var1) {
      Preconditions.checkElementIndex(var1, this.length);
      return this.this$0.get(var1 + this.offset);
   }

   public ImmutableList subList(int var1, int var2) {
      Preconditions.checkPositionIndexes(var1, var2, this.length);
      return this.this$0.subList(var1 + this.offset, var2 + this.offset);
   }

   boolean isPartialView() {
      return true;
   }
}
