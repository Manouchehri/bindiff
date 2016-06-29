package com.google.common.collect;

import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntry$NonTerminalImmutableMapEntry;
import javax.annotation.Nullable;

final class ImmutableMapEntry$NonTerminalImmutableBiMapEntry extends ImmutableMapEntry$NonTerminalImmutableMapEntry {
   private final transient ImmutableMapEntry nextInValueBucket;

   ImmutableMapEntry$NonTerminalImmutableBiMapEntry(Object var1, Object var2, ImmutableMapEntry var3, ImmutableMapEntry var4) {
      super(var1, var2, var3);
      this.nextInValueBucket = var4;
   }

   @Nullable
   ImmutableMapEntry getNextInValueBucket() {
      return this.nextInValueBucket;
   }
}
