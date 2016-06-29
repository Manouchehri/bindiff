package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;

class ImmutableRangeMap$1 extends ImmutableList {
   // $FF: synthetic field
   final int val$len;
   // $FF: synthetic field
   final int val$off;
   // $FF: synthetic field
   final Range val$range;
   // $FF: synthetic field
   final ImmutableRangeMap this$0;

   ImmutableRangeMap$1(ImmutableRangeMap var1, int var2, int var3, Range var4) {
      this.this$0 = var1;
      this.val$len = var2;
      this.val$off = var3;
      this.val$range = var4;
   }

   public int size() {
      return this.val$len;
   }

   public Range get(int var1) {
      Preconditions.checkElementIndex(var1, this.val$len);
      return var1 != 0 && var1 != this.val$len - 1?(Range)ImmutableRangeMap.access$000(this.this$0).get(var1 + this.val$off):((Range)ImmutableRangeMap.access$000(this.this$0).get(var1 + this.val$off)).intersection(this.val$range);
   }

   boolean isPartialView() {
      return true;
   }
}
