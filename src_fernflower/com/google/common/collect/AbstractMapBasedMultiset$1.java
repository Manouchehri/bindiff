package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultiset;
import com.google.common.collect.AbstractMapBasedMultiset$1$1;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.Count;
import com.google.common.collect.Multiset$Entry;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMapBasedMultiset$1 implements Iterator {
   Entry toRemove;
   // $FF: synthetic field
   final Iterator val$backingEntries;
   // $FF: synthetic field
   final AbstractMapBasedMultiset this$0;

   AbstractMapBasedMultiset$1(AbstractMapBasedMultiset var1, Iterator var2) {
      this.this$0 = var1;
      this.val$backingEntries = var2;
   }

   public boolean hasNext() {
      return this.val$backingEntries.hasNext();
   }

   public Multiset$Entry next() {
      Entry var1 = (Entry)this.val$backingEntries.next();
      this.toRemove = var1;
      return new AbstractMapBasedMultiset$1$1(this, var1);
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.toRemove != null);
      AbstractMapBasedMultiset.access$102(this.this$0, AbstractMapBasedMultiset.access$100(this.this$0) - (long)((Count)this.toRemove.getValue()).getAndSet(0));
      this.val$backingEntries.remove();
      this.toRemove = null;
   }
}
