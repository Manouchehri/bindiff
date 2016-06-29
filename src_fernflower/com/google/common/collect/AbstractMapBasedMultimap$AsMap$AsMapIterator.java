package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.AbstractMapBasedMultimap$AsMap;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMapBasedMultimap$AsMap$AsMapIterator implements Iterator {
   final Iterator delegateIterator;
   Collection collection;
   // $FF: synthetic field
   final AbstractMapBasedMultimap$AsMap this$1;

   AbstractMapBasedMultimap$AsMap$AsMapIterator(AbstractMapBasedMultimap$AsMap var1) {
      this.this$1 = var1;
      this.delegateIterator = this.this$1.submap.entrySet().iterator();
   }

   public boolean hasNext() {
      return this.delegateIterator.hasNext();
   }

   public Entry next() {
      Entry var1 = (Entry)this.delegateIterator.next();
      this.collection = (Collection)var1.getValue();
      return this.this$1.wrapEntry(var1);
   }

   public void remove() {
      this.delegateIterator.remove();
      AbstractMapBasedMultimap.access$202(this.this$1.this$0, AbstractMapBasedMultimap.access$200(this.this$1.this$0) - this.collection.size());
      this.collection.clear();
   }
}
