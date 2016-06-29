package com.google.common.collect;

import com.google.common.collect.Iterators;
import com.google.common.collect.TreeRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap;
import com.google.common.collect.TreeRangeMap$SubRangeMap$1$1;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Iterator;

class TreeRangeMap$SubRangeMap$1 extends TreeRangeMap$SubRangeMap$SubRangeMapAsMap {
   // $FF: synthetic field
   final TreeRangeMap$SubRangeMap this$1;

   TreeRangeMap$SubRangeMap$1(TreeRangeMap$SubRangeMap var1) {
      super(var1);
      this.this$1 = var1;
   }

   Iterator entryIterator() {
      if(TreeRangeMap$SubRangeMap.access$200(this.this$1).isEmpty()) {
         return Iterators.emptyIterator();
      } else {
         Iterator var1 = TreeRangeMap.access$000(this.this$1.this$0).headMap(TreeRangeMap$SubRangeMap.access$200(this.this$1).upperBound, false).descendingMap().values().iterator();
         return new TreeRangeMap$SubRangeMap$1$1(this, var1);
      }
   }
}
