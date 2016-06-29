package com.google.common.collect;

import com.google.common.collect.AbstractMapEntry;
import com.google.common.collect.Cut;
import com.google.common.collect.Range;

final class TreeRangeMap$RangeMapEntry extends AbstractMapEntry {
   private final Range range;
   private final Object value;

   TreeRangeMap$RangeMapEntry(Cut var1, Cut var2, Object var3) {
      this(Range.create(var1, var2), var3);
   }

   TreeRangeMap$RangeMapEntry(Range var1, Object var2) {
      this.range = var1;
      this.value = var2;
   }

   public Range getKey() {
      return this.range;
   }

   public Object getValue() {
      return this.value;
   }

   public boolean contains(Comparable var1) {
      return this.range.contains(var1);
   }

   Cut getLowerBound() {
      return this.range.lowerBound;
   }

   Cut getUpperBound() {
      return this.range.upperBound;
   }
}
