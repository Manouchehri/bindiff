package com.google.common.collect;

import com.google.common.collect.Iterators$MergingIterator;
import com.google.common.collect.PeekingIterator;
import java.util.Comparator;

class Iterators$MergingIterator$1 implements Comparator {
   // $FF: synthetic field
   final Comparator val$itemComparator;
   // $FF: synthetic field
   final Iterators$MergingIterator this$0;

   Iterators$MergingIterator$1(Iterators$MergingIterator var1, Comparator var2) {
      this.this$0 = var1;
      this.val$itemComparator = var2;
   }

   public int compare(PeekingIterator var1, PeekingIterator var2) {
      return this.val$itemComparator.compare(var1.peek(), var2.peek());
   }
}
