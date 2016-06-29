package com.google.common.collect;

import com.google.common.collect.Multimaps$Keys$1;
import com.google.common.collect.Multisets$AbstractEntry;
import java.util.Collection;
import java.util.Map.Entry;

class Multimaps$Keys$1$1 extends Multisets$AbstractEntry {
   // $FF: synthetic field
   final Entry val$backingEntry;
   // $FF: synthetic field
   final Multimaps$Keys$1 this$1;

   Multimaps$Keys$1$1(Multimaps$Keys$1 var1, Entry var2) {
      this.this$1 = var1;
      this.val$backingEntry = var2;
   }

   public Object getElement() {
      return this.val$backingEntry.getKey();
   }

   public int getCount() {
      return ((Collection)this.val$backingEntry.getValue()).size();
   }
}
