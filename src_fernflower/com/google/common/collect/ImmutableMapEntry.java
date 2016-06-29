package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableEntry;
import javax.annotation.Nullable;

@GwtIncompatible("unnecessary")
class ImmutableMapEntry extends ImmutableEntry {
   static ImmutableMapEntry[] createEntryArray(int var0) {
      return new ImmutableMapEntry[var0];
   }

   ImmutableMapEntry(Object var1, Object var2) {
      super(var1, var2);
      CollectPreconditions.checkEntryNotNull(var1, var2);
   }

   ImmutableMapEntry(ImmutableMapEntry var1) {
      super(var1.getKey(), var1.getValue());
   }

   @Nullable
   ImmutableMapEntry getNextInKeyBucket() {
      return null;
   }

   @Nullable
   ImmutableMapEntry getNextInValueBucket() {
      return null;
   }

   boolean isReusable() {
      return true;
   }
}
