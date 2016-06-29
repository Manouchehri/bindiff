package com.google.common.collect;

import com.google.common.collect.MapMakerInternalMap$ReferenceEntry;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

interface MapMakerInternalMap$ValueReference {
   Object get();

   Object waitForValue();

   MapMakerInternalMap$ReferenceEntry getEntry();

   MapMakerInternalMap$ValueReference copyFor(ReferenceQueue var1, @Nullable Object var2, MapMakerInternalMap$ReferenceEntry var3);

   void clear(@Nullable MapMakerInternalMap$ValueReference var1);

   boolean isComputingReference();
}
