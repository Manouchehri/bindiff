package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$KeySet;
import com.google.common.collect.CollectPreconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMapBasedMultimap$KeySet$1 implements Iterator {
   Entry entry;
   // $FF: synthetic field
   final Iterator val$entryIterator;
   // $FF: synthetic field
   final AbstractMapBasedMultimap$KeySet this$1;

   AbstractMapBasedMultimap$KeySet$1(AbstractMapBasedMultimap$KeySet var1, Iterator var2) {
      this.this$1 = var1;
      this.val$entryIterator = var2;
   }

   public boolean hasNext() {
      return this.val$entryIterator.hasNext();
   }

   public Object next() {
      this.entry = (Entry)this.val$entryIterator.next();
      return this.entry.getKey();
   }

   public void remove() {
      CollectPreconditions.checkRemove(this.entry != null);
      Collection var1 = (Collection)this.entry.getValue();
      this.val$entryIterator.remove();
      AbstractMapBasedMultimap.access$202(this.this$1.this$0, AbstractMapBasedMultimap.access$200(this.this$1.this$0) - var1.size());
      var1.clear();
   }
}
