package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$1;
import com.google.common.collect.LinkedListMultimap$DistinctKeyIterator;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Iterator;

class LinkedListMultimap$1KeySetImpl extends Sets$ImprovedAbstractSet {
   // $FF: synthetic field
   final LinkedListMultimap this$0;

   LinkedListMultimap$1KeySetImpl(LinkedListMultimap var1) {
      this.this$0 = var1;
   }

   public int size() {
      return LinkedListMultimap.access$600(this.this$0).size();
   }

   public Iterator iterator() {
      return new LinkedListMultimap$DistinctKeyIterator(this.this$0, (LinkedListMultimap$1)null);
   }

   public boolean contains(Object var1) {
      return this.this$0.containsKey(var1);
   }

   public boolean remove(Object var1) {
      return !this.this$0.removeAll(var1).isEmpty();
   }
}
