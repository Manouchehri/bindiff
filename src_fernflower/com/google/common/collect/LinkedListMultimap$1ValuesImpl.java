package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$1ValuesImpl$1;
import com.google.common.collect.LinkedListMultimap$NodeIterator;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

class LinkedListMultimap$1ValuesImpl extends AbstractSequentialList {
   // $FF: synthetic field
   final LinkedListMultimap this$0;

   LinkedListMultimap$1ValuesImpl(LinkedListMultimap var1) {
      this.this$0 = var1;
   }

   public int size() {
      return LinkedListMultimap.access$900(this.this$0);
   }

   public ListIterator listIterator(int var1) {
      LinkedListMultimap$NodeIterator var2 = new LinkedListMultimap$NodeIterator(this.this$0, var1);
      return new LinkedListMultimap$1ValuesImpl$1(this, var2, var2);
   }
}
