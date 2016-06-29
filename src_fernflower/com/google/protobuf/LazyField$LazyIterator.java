package com.google.protobuf;

import com.google.protobuf.LazyField;
import com.google.protobuf.LazyField$1;
import com.google.protobuf.LazyField$LazyEntry;
import java.util.Iterator;
import java.util.Map.Entry;

class LazyField$LazyIterator implements Iterator {
   private Iterator iterator;

   public LazyField$LazyIterator(Iterator var1) {
      this.iterator = var1;
   }

   public boolean hasNext() {
      return this.iterator.hasNext();
   }

   public Entry next() {
      Entry var1 = (Entry)this.iterator.next();
      return (Entry)(var1.getValue() instanceof LazyField?new LazyField$LazyEntry(var1, (LazyField$1)null):var1);
   }

   public void remove() {
      this.iterator.remove();
   }
}
