package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap$1ValuesImpl;
import com.google.common.collect.LinkedListMultimap$NodeIterator;
import com.google.common.collect.TransformedListIterator;
import java.util.ListIterator;
import java.util.Map.Entry;

class LinkedListMultimap$1ValuesImpl$1 extends TransformedListIterator {
   // $FF: synthetic field
   final LinkedListMultimap$NodeIterator val$nodeItr;
   // $FF: synthetic field
   final LinkedListMultimap$1ValuesImpl this$1;

   LinkedListMultimap$1ValuesImpl$1(LinkedListMultimap$1ValuesImpl var1, ListIterator var2, LinkedListMultimap$NodeIterator var3) {
      super(var2);
      this.this$1 = var1;
      this.val$nodeItr = var3;
   }

   Object transform(Entry var1) {
      return var1.getValue();
   }

   public void set(Object var1) {
      this.val$nodeItr.setValue(var1);
   }
}
