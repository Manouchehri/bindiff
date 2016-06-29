package com.google.common.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import com.google.common.collect.Range;
import java.io.Serializable;

final class ImmutableRangeSet$SerializedForm implements Serializable {
   private final ImmutableList ranges;

   ImmutableRangeSet$SerializedForm(ImmutableList var1) {
      this.ranges = var1;
   }

   Object readResolve() {
      return this.ranges.isEmpty()?ImmutableRangeSet.of():(this.ranges.equals(ImmutableList.of(Range.all()))?ImmutableRangeSet.all():new ImmutableRangeSet(this.ranges));
   }
}
