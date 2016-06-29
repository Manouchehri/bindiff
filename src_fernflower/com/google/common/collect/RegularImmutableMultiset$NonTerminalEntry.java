package com.google.common.collect;

import com.google.common.collect.Multisets$ImmutableEntry;

final class RegularImmutableMultiset$NonTerminalEntry extends Multisets$ImmutableEntry {
   private final Multisets$ImmutableEntry nextInBucket;

   RegularImmutableMultiset$NonTerminalEntry(Object var1, int var2, Multisets$ImmutableEntry var3) {
      super(var1, var2);
      this.nextInBucket = var3;
   }

   public Multisets$ImmutableEntry nextInBucket() {
      return this.nextInBucket;
   }
}
