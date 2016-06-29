package com.google.common.collect;

import com.google.common.collect.ImmutableMapEntry;
import javax.annotation.Nullable;

class ImmutableMapEntry$NonTerminalImmutableMapEntry extends ImmutableMapEntry {
   private final transient ImmutableMapEntry nextInKeyBucket;

   ImmutableMapEntry$NonTerminalImmutableMapEntry(Object var1, Object var2, ImmutableMapEntry var3) {
      super(var1, var2);
      this.nextInKeyBucket = var3;
   }

   @Nullable
   final ImmutableMapEntry getNextInKeyBucket() {
      return this.nextInKeyBucket;
   }

   final boolean isReusable() {
      return false;
   }
}
