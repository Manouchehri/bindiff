package com.google.common.collect;

import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableRangeSet;
import java.io.Serializable;

class ImmutableRangeSet$AsSetSerializedForm implements Serializable {
   private final ImmutableList ranges;
   private final DiscreteDomain domain;

   ImmutableRangeSet$AsSetSerializedForm(ImmutableList var1, DiscreteDomain var2) {
      this.ranges = var1;
      this.domain = var2;
   }

   Object readResolve() {
      return (new ImmutableRangeSet(this.ranges)).asSet(this.domain);
   }
}
