package com.google.common.collect;

import com.google.common.collect.AbstractMapBasedMultimap;
import com.google.common.collect.Iterators;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

abstract class AbstractMapBasedMultimap$Itr implements Iterator {
   final Iterator keyIterator;
   Object key;
   Collection collection;
   Iterator valueIterator;
   // $FF: synthetic field
   final AbstractMapBasedMultimap this$0;

   AbstractMapBasedMultimap$Itr(AbstractMapBasedMultimap var1) {
      this.this$0 = var1;
      this.keyIterator = AbstractMapBasedMultimap.access$000(var1).entrySet().iterator();
      this.key = null;
      this.collection = null;
      this.valueIterator = Iterators.emptyModifiableIterator();
   }

   abstract Object output(Object var1, Object var2);

   public boolean hasNext() {
      return this.keyIterator.hasNext() || this.valueIterator.hasNext();
   }

   public Object next() {
      if(!this.valueIterator.hasNext()) {
         Entry var1 = (Entry)this.keyIterator.next();
         this.key = var1.getKey();
         this.collection = (Collection)var1.getValue();
         this.valueIterator = this.collection.iterator();
      }

      return this.output(this.key, this.valueIterator.next());
   }

   public void remove() {
      this.valueIterator.remove();
      if(this.collection.isEmpty()) {
         this.keyIterator.remove();
      }

      AbstractMapBasedMultimap.access$210(this.this$0);
   }
}
