package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Range;
import com.google.common.collect.RegularContiguousSet;
import com.google.common.collect.RegularContiguousSet$1;
import java.io.Serializable;

@GwtIncompatible("serialization")
final class RegularContiguousSet$SerializedForm implements Serializable {
   final Range range;
   final DiscreteDomain domain;

   private RegularContiguousSet$SerializedForm(Range var1, DiscreteDomain var2) {
      this.range = var1;
      this.domain = var2;
   }

   private Object readResolve() {
      return new RegularContiguousSet(this.range, this.domain);
   }

   // $FF: synthetic method
   RegularContiguousSet$SerializedForm(Range var1, DiscreteDomain var2, RegularContiguousSet$1 var3) {
      this(var1, var2);
   }
}
