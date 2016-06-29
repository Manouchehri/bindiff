package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.ImmutableMap;
import java.io.Serializable;

@GwtIncompatible("serialization")
class ImmutableMapEntrySet$EntrySetSerializedForm implements Serializable {
   final ImmutableMap map;
   private static final long serialVersionUID = 0L;

   ImmutableMapEntrySet$EntrySetSerializedForm(ImmutableMap var1) {
      this.map = var1;
   }

   Object readResolve() {
      return this.map.entrySet();
   }
}
