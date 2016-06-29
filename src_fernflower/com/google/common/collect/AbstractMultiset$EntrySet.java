package com.google.common.collect;

import com.google.common.collect.AbstractMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets$EntrySet;
import java.util.Iterator;

class AbstractMultiset$EntrySet extends Multisets$EntrySet {
   // $FF: synthetic field
   final AbstractMultiset this$0;

   AbstractMultiset$EntrySet(AbstractMultiset var1) {
      this.this$0 = var1;
   }

   Multiset multiset() {
      return this.this$0;
   }

   public Iterator iterator() {
      return this.this$0.entryIterator();
   }

   public int size() {
      return this.this$0.distinctElements();
   }
}
