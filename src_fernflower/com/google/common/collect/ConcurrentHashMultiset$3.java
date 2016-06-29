package com.google.common.collect;

import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.ForwardingIterator;
import com.google.common.collect.Multiset$Entry;
import java.util.Iterator;

class ConcurrentHashMultiset$3 extends ForwardingIterator {
   private Multiset$Entry last;
   // $FF: synthetic field
   final Iterator val$readOnlyIterator;
   // $FF: synthetic field
   final ConcurrentHashMultiset this$0;

   ConcurrentHashMultiset$3(ConcurrentHashMultiset var1, Iterator var2) {
      this.this$0 = var1;
      this.val$readOnlyIterator = var2;
   }

   protected Iterator delegate() {
      return this.val$readOnlyIterator;
   }

   public Multiset$Entry next() {
      this.last = (Multiset$Entry)super.next();
      return this.last;
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.last != null);
      this.this$0.setCount(this.last.getElement(), 0);
      this.last = null;
   }
}
