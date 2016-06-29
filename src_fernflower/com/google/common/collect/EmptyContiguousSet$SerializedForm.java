package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.EmptyContiguousSet;
import com.google.common.collect.EmptyContiguousSet$1;
import java.io.Serializable;

@GwtIncompatible("serialization")
final class EmptyContiguousSet$SerializedForm implements Serializable {
   private final DiscreteDomain domain;
   private static final long serialVersionUID = 0L;

   private EmptyContiguousSet$SerializedForm(DiscreteDomain var1) {
      this.domain = var1;
   }

   private Object readResolve() {
      return new EmptyContiguousSet(this.domain);
   }

   // $FF: synthetic method
   EmptyContiguousSet$SerializedForm(DiscreteDomain var1, EmptyContiguousSet$1 var2) {
      this(var1);
   }
}
