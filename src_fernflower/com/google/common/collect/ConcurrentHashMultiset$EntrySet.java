package com.google.common.collect;

import com.google.common.collect.AbstractMultiset$EntrySet;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.ConcurrentHashMultiset$1;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;

class ConcurrentHashMultiset$EntrySet extends AbstractMultiset$EntrySet {
   // $FF: synthetic field
   final ConcurrentHashMultiset this$0;

   private ConcurrentHashMultiset$EntrySet(ConcurrentHashMultiset var1) {
      super(var1);
      this.this$0 = var1;
   }

   ConcurrentHashMultiset multiset() {
      return this.this$0;
   }

   public Object[] toArray() {
      return this.snapshot().toArray();
   }

   public Object[] toArray(Object[] var1) {
      return this.snapshot().toArray(var1);
   }

   private List snapshot() {
      ArrayList var1 = Lists.newArrayListWithExpectedSize(this.size());
      Iterators.addAll(var1, this.iterator());
      return var1;
   }

   // $FF: synthetic method
   ConcurrentHashMultiset$EntrySet(ConcurrentHashMultiset var1, ConcurrentHashMultiset$1 var2) {
      this(var1);
   }
}
