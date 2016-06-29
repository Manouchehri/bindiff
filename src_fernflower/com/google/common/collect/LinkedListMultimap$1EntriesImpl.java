package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$NodeIterator;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

class LinkedListMultimap$1EntriesImpl extends AbstractSequentialList {
   // $FF: synthetic field
   final LinkedListMultimap this$0;

   LinkedListMultimap$1EntriesImpl(LinkedListMultimap var1) {
      this.this$0 = var1;
   }

   public int size() {
      return LinkedListMultimap.access$900(this.this$0);
   }

   public ListIterator listIterator(int var1) {
      return new LinkedListMultimap$NodeIterator(this.this$0, var1);
   }
}
