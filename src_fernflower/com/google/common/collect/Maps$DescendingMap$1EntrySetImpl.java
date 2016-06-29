package com.google.common.collect;

import com.google.common.collect.Maps$DescendingMap;
import com.google.common.collect.Maps$EntrySet;
import java.util.Iterator;
import java.util.Map;

class Maps$DescendingMap$1EntrySetImpl extends Maps$EntrySet {
   // $FF: synthetic field
   final Maps$DescendingMap this$0;

   Maps$DescendingMap$1EntrySetImpl(Maps$DescendingMap var1) {
      this.this$0 = var1;
   }

   Map map() {
      return this.this$0;
   }

   public Iterator iterator() {
      return this.this$0.entryIterator();
   }
}
