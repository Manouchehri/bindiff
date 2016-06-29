package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.collect.ForwardingNavigableMap;
import com.google.common.collect.ForwardingNavigableMap$StandardDescendingMap$1;
import com.google.common.collect.Maps$DescendingMap;
import java.util.Iterator;
import java.util.NavigableMap;

@Beta
public class ForwardingNavigableMap$StandardDescendingMap extends Maps$DescendingMap {
   // $FF: synthetic field
   final ForwardingNavigableMap this$0;

   public ForwardingNavigableMap$StandardDescendingMap(ForwardingNavigableMap var1) {
      this.this$0 = var1;
   }

   NavigableMap forward() {
      return this.this$0;
   }

   protected Iterator entryIterator() {
      return new ForwardingNavigableMap$StandardDescendingMap$1(this);
   }
}
