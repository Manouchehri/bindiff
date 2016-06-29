package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;

@GwtIncompatible("serialization")
class ImmutableMapKeySet$KeySetSerializedForm implements Serializable {
   final ImmutableMap map;
   private static final long serialVersionUID = 0L;

   ImmutableMapKeySet$KeySetSerializedForm(ImmutableMap var1) {
      this.map = var1;
   }

   Object readResolve() {
      return this.map.keySet();
   }
}
