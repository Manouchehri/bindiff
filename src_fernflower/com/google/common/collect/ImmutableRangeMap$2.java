package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeMap;
import com.google.common.collect.Range;

class ImmutableRangeMap$2 extends ImmutableRangeMap {
   // $FF: synthetic field
   final Range val$range;
   // $FF: synthetic field
   final ImmutableRangeMap val$outer;
   // $FF: synthetic field
   final ImmutableRangeMap this$0;

   ImmutableRangeMap$2(ImmutableRangeMap var1, ImmutableList var2, ImmutableList var3, Range var4, ImmutableRangeMap var5) {
      super(var2, var3);
      this.this$0 = var1;
      this.val$range = var4;
      this.val$outer = var5;
   }

   public ImmutableRangeMap subRangeMap(Range var1) {
      return this.val$range.isConnected(var1)?this.val$outer.subRangeMap(var1.intersection(this.val$range)):ImmutableRangeMap.of();
   }
}
