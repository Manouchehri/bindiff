package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$KeySet;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Collection;
import java.util.Map;
import javax.annotation.Nullable;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1 extends Maps$KeySet {
   // $FF: synthetic field
   final TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;

   TreeRangeMap$SubRangeMap$SubRangeMapAsMap$1(TreeRangeMap$SubRangeMap$SubRangeMapAsMap var1, Map var2) {
      super(var2);
      this.this$2 = var1;
   }

   public boolean remove(@Nullable Object var1) {
      return this.this$2.remove(var1) != null;
   }

   public boolean retainAll(Collection var1) {
      return TreeRangeMap$SubRangeMap$SubRangeMapAsMap.access$300(this.this$2, Predicates.compose(Predicates.not(Predicates.in(var1)), Maps.keyFunction()));
   }
}
