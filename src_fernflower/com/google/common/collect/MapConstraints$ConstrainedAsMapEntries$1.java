package com.google.common.collect;

import com.google.common.collect.MapConstraints;
import com.google.common.collect.MapConstraints$ConstrainedAsMapEntries;
import com.google.common.collect.TransformedIterator;
import java.util.Iterator;
import java.util.Map.Entry;

class MapConstraints$ConstrainedAsMapEntries$1 extends TransformedIterator {
   // $FF: synthetic field
   final MapConstraints$ConstrainedAsMapEntries this$0;

   MapConstraints$ConstrainedAsMapEntries$1(MapConstraints$ConstrainedAsMapEntries var1, Iterator var2) {
      super(var2);
      this.this$0 = var1;
   }

   Entry transform(Entry var1) {
      return MapConstraints.access$700(var1, MapConstraints$ConstrainedAsMapEntries.access$600(this.this$0));
   }
}
