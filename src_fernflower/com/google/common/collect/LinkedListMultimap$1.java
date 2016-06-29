package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.LinkedListMultimap$KeyList;
import com.google.common.collect.LinkedListMultimap$ValueForKeyIterator;
import java.util.AbstractSequentialList;
import java.util.ListIterator;

class LinkedListMultimap$1 extends AbstractSequentialList {
   // $FF: synthetic field
   final Object val$key;
   // $FF: synthetic field
   final LinkedListMultimap this$0;

   LinkedListMultimap$1(LinkedListMultimap var1, Object var2) {
      this.this$0 = var1;
      this.val$key = var2;
   }

   public int size() {
      LinkedListMultimap$KeyList var1 = (LinkedListMultimap$KeyList)LinkedListMultimap.access$600(this.this$0).get(this.val$key);
      return var1 == null?0:var1.count;
   }

   public ListIterator listIterator(int var1) {
      return new LinkedListMultimap$ValueForKeyIterator(this.this$0, this.val$key, var1);
   }
}
