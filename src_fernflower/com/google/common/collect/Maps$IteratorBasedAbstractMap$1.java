package com.google.common.collect;

import com.google.common.collect.Maps$EntrySet;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import java.util.Iterator;
import java.util.Map;

class Maps$IteratorBasedAbstractMap$1 extends Maps$EntrySet {
   // $FF: synthetic field
   final Maps$IteratorBasedAbstractMap this$0;

   Maps$IteratorBasedAbstractMap$1(Maps$IteratorBasedAbstractMap var1) {
      this.this$0 = var1;
   }

   Map map() {
      return this.this$0;
   }

   public Iterator iterator() {
      return this.this$0.entryIterator();
   }
}
