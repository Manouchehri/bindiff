package com.google.common.collect;

import com.google.common.collect.Multimaps$MapMultimap;
import com.google.common.collect.Multimaps$MapMultimap$1$1;
import com.google.common.collect.Sets$ImprovedAbstractSet;
import java.util.Iterator;

class Multimaps$MapMultimap$1 extends Sets$ImprovedAbstractSet {
   // $FF: synthetic field
   final Object val$key;
   // $FF: synthetic field
   final Multimaps$MapMultimap this$0;

   Multimaps$MapMultimap$1(Multimaps$MapMultimap var1, Object var2) {
      this.this$0 = var1;
      this.val$key = var2;
   }

   public Iterator iterator() {
      return new Multimaps$MapMultimap$1$1(this);
   }

   public int size() {
      return this.this$0.map.containsKey(this.val$key)?1:0;
   }
}
