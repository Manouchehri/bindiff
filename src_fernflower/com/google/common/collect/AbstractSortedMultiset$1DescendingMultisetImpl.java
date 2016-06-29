package com.google.common.collect;

import com.google.common.collect.AbstractSortedMultiset;
import com.google.common.collect.DescendingMultiset;
import com.google.common.collect.SortedMultiset;
import java.util.Iterator;

class AbstractSortedMultiset$1DescendingMultisetImpl extends DescendingMultiset {
   // $FF: synthetic field
   final AbstractSortedMultiset this$0;

   AbstractSortedMultiset$1DescendingMultisetImpl(AbstractSortedMultiset var1) {
      this.this$0 = var1;
   }

   SortedMultiset forwardMultiset() {
      return this.this$0;
   }

   Iterator entryIterator() {
      return this.this$0.descendingEntryIterator();
   }

   public Iterator iterator() {
      return this.this$0.descendingIterator();
   }
}
