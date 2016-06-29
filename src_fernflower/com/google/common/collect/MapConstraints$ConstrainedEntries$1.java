package com.google.common.collect;

import com.google.common.collect.MapConstraints;
import com.google.common.collect.MapConstraints$ConstrainedEntries;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedEntries$1 extends TransformedIterator {
   // $FF: synthetic field
   final MapConstraints$ConstrainedEntries this$0;

   MapConstraints$ConstrainedEntries$1(MapConstraints$ConstrainedEntries var1, Iterator var2) {
      super(var2);
      this.this$0 = var1;
   }

   Entry transform(Entry var1) {
      return MapConstraints.access$500(var1, this.this$0.constraint);
   }
}
