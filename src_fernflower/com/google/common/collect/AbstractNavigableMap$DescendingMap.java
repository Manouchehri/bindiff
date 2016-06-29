package com.google.common.collect;

import com.google.common.collect.AbstractNavigableMap;
import com.google.common.collect.AbstractNavigableMap$1;
import com.google.common.collect.Maps$DescendingMap;
import java.util.Iterator;
import java.util.NavigableMap;

final class AbstractNavigableMap$DescendingMap extends Maps$DescendingMap {
   // $FF: synthetic field
   final AbstractNavigableMap this$0;

   private AbstractNavigableMap$DescendingMap(AbstractNavigableMap var1) {
      this.this$0 = var1;
   }

   NavigableMap forward() {
      return this.this$0;
   }

   Iterator entryIterator() {
      return this.this$0.descendingEntryIterator();
   }

   // $FF: synthetic method
   AbstractNavigableMap$DescendingMap(AbstractNavigableMap var1, AbstractNavigableMap$1 var2) {
      this(var1);
   }
}
