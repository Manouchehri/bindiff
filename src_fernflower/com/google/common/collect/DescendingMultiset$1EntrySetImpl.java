package com.google.common.collect;

import com.google.common.collect.DescendingMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$EntrySet;
import java.util.Iterator;

class DescendingMultiset$1EntrySetImpl extends Multisets$EntrySet {
   // $FF: synthetic field
   final DescendingMultiset this$0;

   DescendingMultiset$1EntrySetImpl(DescendingMultiset var1) {
      this.this$0 = var1;
   }

   Multiset multiset() {
      return this.this$0;
   }

   public Iterator iterator() {
      return this.this$0.entryIterator();
   }

   public int size() {
      return this.this$0.forwardMultiset().entrySet().size();
   }
}
