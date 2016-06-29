package com.google.protobuf;

import com.google.protobuf.Internal$MapAdapter;
import com.google.protobuf.Internal$MapAdapter$EntryAdapter;
import java.util.Iterator;
import java.util.Map.Entry;

class Internal$MapAdapter$IteratorAdapter implements Iterator {
   private final Iterator realIterator;
   // $FF: synthetic field
   final Internal$MapAdapter this$0;

   public Internal$MapAdapter$IteratorAdapter(Internal$MapAdapter var1, Iterator var2) {
      this.this$0 = var1;
      this.realIterator = var2;
   }

   public boolean hasNext() {
      return this.realIterator.hasNext();
   }

   public Entry next() {
      return new Internal$MapAdapter$EntryAdapter(this.this$0, (Entry)this.realIterator.next());
   }

   public void remove() {
      this.realIterator.remove();
   }
}
