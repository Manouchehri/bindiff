package com.google.common.collect;

import com.google.common.base.Predicates;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps$EntrySet;
import com.google.common.collect.TreeRangeMap$SubRangeMap$SubRangeMapAsMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

class TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2 extends Maps$EntrySet {
   // $FF: synthetic field
   final TreeRangeMap$SubRangeMap$SubRangeMapAsMap this$2;

   TreeRangeMap$SubRangeMap$SubRangeMapAsMap$2(TreeRangeMap$SubRangeMap$SubRangeMapAsMap var1) {
      this.this$2 = var1;
   }

   Map map() {
      return this.this$2;
   }

   public Iterator iterator() {
      return this.this$2.entryIterator();
   }

   public boolean retainAll(Collection var1) {
      return TreeRangeMap$SubRangeMap$SubRangeMapAsMap.access$300(this.this$2, Predicates.not(Predicates.in(var1)));
   }

   public int size() {
      return Iterators.size(this.iterator());
   }

   public boolean isEmpty() {
      return !this.iterator().hasNext();
   }
}
