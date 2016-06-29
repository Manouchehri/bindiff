package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$Values;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Collection;
import java.util.Map;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4 extends Maps$Values {
   // $FF: synthetic field
   final TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;

   TreeRangeMap$SubRangeMap$SubRangeMapAsMap$4(TreeRangeMap$SubRangeMap$SubRangeMapAsMap var1, Map var2) {
      super(var2);
      this.this$2 = var1;
   }

   public boolean removeAll(Collection var1) {
      return TreeRangeMap$SubRangeMap$SubRangeMapAsMap.access$300(this.this$2, Predicates.compose(Predicates.in(var1), Maps.valueFunction()));
   }

   public boolean retainAll(Collection var1) {
      return TreeRangeMap$SubRangeMap$SubRangeMapAsMap.access$300(this.this$2, Predicates.compose(Predicates.not(Predicates.in(var1)), Maps.valueFunction()));
   }
}
