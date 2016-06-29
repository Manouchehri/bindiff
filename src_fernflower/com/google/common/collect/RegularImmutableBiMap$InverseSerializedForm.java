package com.google.common.collect;

import com.google.common.collect.ImmutableBiMap;
import java.io.Serializable;

class RegularImmutableBiMap$InverseSerializedForm implements Serializable {
   private final ImmutableBiMap forward;
   private static final long serialVersionUID = 1L;

   RegularImmutableBiMap$InverseSerializedForm(ImmutableBiMap var1) {
      this.forward = var1;
   }

   Object readResolve() {
      return this.forward.inverse();
   }
}
